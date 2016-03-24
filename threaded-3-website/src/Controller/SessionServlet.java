package Controller;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Controller.SessionServlet
 *
 */
 public class SessionServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SessionServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		if (session.isNew())
		{
			out.write("new session<br>");
			out.write("Session ID: " + session.getId() + "<br>");
			session.setAttribute("firstname", "Harv");
			session.setAttribute("lastname", "Peters");
		}
		else
		{
			out.write("Session ID: " + session.getId() + "<br>");
			out.write("Creation date: " + session.getCreationTime() + "<br>");
			out.write("Last accessed date: " + session.getLastAccessedTime() + "<br>");
			out.write("timeout seconds: " + session.getMaxInactiveInterval() + "<br>");
			session.setMaxInactiveInterval(5);
			out.write("timeout seconds: " + session.getMaxInactiveInterval() + "<br>");
			Enumeration attList = session.getAttributeNames();
			while (attList.hasMoreElements())
			{
				String attName = (String)attList.nextElement();
				out.print(attName + " " + session.getAttribute(attName) + "<br>");
			}
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}