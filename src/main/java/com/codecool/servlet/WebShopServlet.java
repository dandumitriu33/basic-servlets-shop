package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebShopServlet", urlPatterns = {"/shop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Shop";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title>"+
                        "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                        "<li><b>First Name</b>: " + request.getParameter("first_name") + "\n" +
                        "<li><b>Last Name</b>: " + request.getParameter("last_name") + "\n" +
                        "</ul>\n" +
                        "<div>Visit another servlet: <a href=\"/another\">Visit the other servlet</a></div>" +
                        "<button type=\"button\" class=\"btn btn-primary\">Primary</button>" +





                        "</body></html>"
        );
    }
}
