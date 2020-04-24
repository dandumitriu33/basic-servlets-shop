package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/cart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Cart";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title>"+
                        "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<table class=\"table table-striped\">"+
                        "<thead>"+
                        "<tr>"+
                        "<th scope=\"col\">Name</th>"+
                        "<th scope=\"col\">Price</th>"+
                        "</tr>"+
                        "</thead>"+
                        "<tbody>"+
                        "<tr>"+
                        "<td>Harry Potter Ebook</td>"+
                        "<td>50 USD</td>"+
                        "</tr>"+
                        "<tr>"+
                        "<td>Harry Potter Ebook</td>"+
                        "<td>50 USD</td>"+
                        "</tr>"+
                        "<tr>"+
                        "<td>Harry Potter Ebook</td>"+
                        "<td>50 USD</td>"+
                        "</tr>"+
                        "<tr>"+
                        "<td>Lego</td>"+
                        "<td>80 USD</td>"+
                        "</tr>"+
                        "</tbody>"+
                        "</table>"+
                        "<div>Total: 230 USD</div>"+
                        "<div><a href=\"/shop\">Back To Shop</a></div>"+
                        "</body></html>"
        );
    }
}
