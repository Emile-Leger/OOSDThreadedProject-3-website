package Controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet
{
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int sum = 0;
        Cookie theCookie = null;
        Cookie cookies[] = request.getCookies();
        if (cookies != null)
        {
            for(int i=0; i < cookies.length; i++)
            {
                theCookie = cookies[i];
                if (theCookie.getName().equals("sum"))
                {
                    try
                    {
                        sum = Integer.parseInt(theCookie.getValue());
                    }
                    catch(NumberFormatException e)
                    {
                        sum = 0;
                    }
                    i = cookies.length;
                }
            }
        }

        try
        {
            theCookie = new Cookie ("sum", Integer.toString(++sum));
        }
        catch (NumberFormatException e)
        {
            if (theCookie == null)
            {
                theCookie = new Cookie ("sum", "0");
            }
        }
        theCookie.setMaxAge(10000);


// Generate Output
        response.setContentType("text/html");
// Save cookie
        response.addCookie(theCookie);
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<head><title>Cookie Information</title></head>" +
                "<body bgcolor=\"#FFFFFF\">" +
                "<h1>Cookie Information</h1><table>");
        if (cookies != null) {
            for(int i=0; i < cookies.length; i++) {
                out.println ("<tr><td>" + cookies[i].getName() + "</td>");
                out.println ("<td>" + cookies[i].getValue() + "</td></tr>");
            }
        }
        out.println("</table></body></html>");
        out.close();
    }
}
