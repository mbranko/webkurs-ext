package isa.pr19.session;

import java.math.BigDecimal;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isa.pr19.entity.Admin;
import isa.pr19.entity.Category;
import isa.pr19.entity.Product;
import isa.pr19.entity.Supplier;
import isa.pr19.entity.User;

@Stateless
@Remote(InitDb.class)
@Local(InitDbLocal.class)
public class InitDbBean implements InitDb {

  @PersistenceContext
  private EntityManager em;
  
  @Override
  public void initDatabase() {
    Admin admin = new Admin();
    admin.setUsername("admin");
    admin.setPassword("admin");
    em.persist(admin);
    
    Category racunari = new Category();
    racunari.setName("Racunari");
    racunari.setDescription("Razni racunari");
    Category laptop = new Category();
    laptop.setName("Laptop");
    laptop.setDescription("Prenosni racunari");
    Category desktop = new Category();
    desktop.setName("Desktop");
    desktop.setDescription("Prenosni ali teski racunari");
    Category server = new Category();
    server.setName("Server");
    server.setDescription("Tesko prenosni racunari");
    racunari.add(laptop);
    racunari.add(desktop);
    racunari.add(server);
    em.persist(racunari);
    
    Supplier zika1 = new Supplier();
    zika1.setName("Zika Trade");
    zika1.setAddress("Bulevar Oslobodjenja 1");
    Supplier zika2 = new Supplier();
    zika2.setName("Zika Computers");
    zika2.setAddress("Bulevar Oslobodjenja 2");
    Supplier zika3 = new Supplier();
    zika3.setName("Zika Soft");
    zika3.setAddress("Bulevar Oslobodjenja 3");
    em.persist(zika1);
    em.persist(zika2);
    em.persist(zika3);
    
    Product p1 = new Product();
    p1.setName("ThinkPad T61");
    p1.setVendor("IBM");
    p1.setDescription("trt");
    p1.setPrice(new BigDecimal(1000));
    laptop.add(p1);
    zika2.add(p1);
    Product p2 = new Product();
    p2.setName("Compaq nx9010");
    p2.setVendor("HP");
    p2.setDescription("trt");
    p2.setPrice(new BigDecimal(1000));
    laptop.add(p2);
    zika2.add(p2);
    Product p3 = new Product();
    p3.setName("Tecra S5");
    p3.setVendor("Toshiba");
    p3.setDescription("trt");
    p3.setPrice(new BigDecimal(1000));
    laptop.add(p3);
    zika2.add(p3);
    // da li ce se proizvodi snimiti u bazu?
    
    User branko = new User();
    branko.setUsername("mbranko");
    branko.setPassword("mbranko");
    branko.setFirstName("Branko");
    branko.setLastName("Milosavljevic");
    branko.setAddress("Fruskogorska 11");
    branko.setEmail("mbranko@uns.ac.rs");
    branko.setReceiveNews(false);
    User minja = new User();
    minja.setUsername("minja");
    minja.setPassword("minja");
    minja.setFirstName("Milan");
    minja.setLastName("Vidakovic");
    minja.setAddress("Fruskogorska 11");
    minja.setEmail("minja@uns.ac.rs");
    minja.setReceiveNews(false);
    em.persist(branko);
    em.persist(minja);
  }

}