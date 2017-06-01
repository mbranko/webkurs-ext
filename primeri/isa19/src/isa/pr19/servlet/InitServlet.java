package isa.pr19.servlet;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import isa.pr19.session.InitDbLocal;

public class InitServlet extends HttpServlet {

  @Override
  public void init(ServletConfig cfg) throws ServletException {
    System.out.println("Upisujem pocetne podatke u bazu...");
    initializer.initDatabase();
  }
  
  @EJB
  private InitDbLocal initializer;
  
  private static final long serialVersionUID = 1L;
}
