<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
  <head>
    <title>Vasa korpa</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  <body>
    <h3>Vasa korpa</h3>
    <h4>Korisnik: ${user.firstName} ${user.lastName}</h4>
    <table style="spacing:0;padding:1px;border:1px">
      <thead>
        <tr>
          <td>Proizvod</td>
          <td>Kolicina</td>
          <td>Cena</td>
          <td>Iznos</td>
        <tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${order.items}">
          <tr>
	          <td>${item.product.name}</td>
	          <td align="right">${item.quantity}</td>
	          <td align="right">${item.product.price}</td>
	          <td align="right">${item.sum}</td>
          </tr>
        </c:forEach>
        <tr>
          <td colspan="3">UKUPNO</td>
          <td align="right"><b>${order.total}</b></td>
        </tr>
      </tbody>
    </table>
    <p>
      <form action="pay.jsp" method="post">
        <input type="submit" value="Placanje">
      </form>
      <form action="index.jsp" method="get">
        <input type="submit" value="Nazad u katalog">
      </form>
     </p>
  </body>
</html>