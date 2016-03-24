package Controller;

import Model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 433080 on 3/18/2016.
 */
@WebServlet(name = "Controller.LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        Customer loggedIn = Customer.login(username,password);
        out.println(loggedIn.getCustFirstName());
        out.println(loggedIn.getCustLastName());
        out.println(loggedIn.getCustAddress());
        out.println(loggedIn.getCustPostal());
        out.println(loggedIn.getCustCity());
        out.println(loggedIn.getCustProv());
        out.println(loggedIn.getCustCountry());
        out.println(loggedIn.getCustEmail());
        out.println(loggedIn.getCustBusPhone());


    }
}
