package isa.webshop.server;

import com.google.gson.*;
import isa.webshop.model.OrderItem;
import isa.webshop.model.Product;
import isa.webshop.model.PurchaseOrder;
import isa.webshop.model.User;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.Date;

public class PaymentApi {
  public static String makePayment(Request request, Response response) {
    JsonObject root = new JsonParser().parse(request.body()).getAsJsonObject();
    JsonObject order = root.getAsJsonObject("order");
    JsonArray items = order.getAsJsonArray("items");
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    em.getTransaction().begin();
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.setDate(new Date());

    for (int i = 0; i < items.size(); i++) {
      OrderItem item = new OrderItem();
      int productId = items.get(i).getAsJsonObject().get("product").getAsJsonObject().get("id").getAsInt();
      item.setProduct(em.find(Product.class, productId));
      item.setQuantity(items.get(i).getAsJsonObject().get("quantity").getAsInt());
      purchaseOrder.add(item);
    }
    User user = em.find(User.class, 1);
    user.add(purchaseOrder);
    response.status(201);

    em.getTransaction().commit();
    em.close();
    return "{ \"status\": \"OK\"}";
  }
}
