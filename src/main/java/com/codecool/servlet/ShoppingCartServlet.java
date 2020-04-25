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

    Cart myCart = new Cart();
    Item p1 = Stock.p1;
    Item p2 = Stock.p2;
    Item p3 = Stock.p3;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("reached cart");
        String productId = request.getParameter("product_id");
        System.out.println(productId);
        if (productId.substring(0, 3).equals("add")) {
            System.out.println("entered Add procedure");
            System.out.println(productId.substring(4));
            if (productId.substring(4).equals("1")) myCart.add(p1);
            else if (productId.substring(4).equals("2")) myCart.add(p2);
            else if (productId.substring(4).equals("3")) myCart.add(p3);
        }
        else if (productId.substring(0, 6).equals("remove")) {
            System.out.println("Entered Remove procedure");
            System.out.println(productId.substring(6));
            if (productId.substring(7).equals("1")) myCart.remove(p1);
            else if (productId.substring(7).equals("2")) myCart.remove(p2);
            else if (productId.substring(7).equals("3")) myCart.remove(p3);
        }

        for (Item i:myCart.list) {
            System.out.println(i.name);

        }
        response.sendRedirect("shop");
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
                        "<div><a href=\"/shop\"><button type=\"button\" class=\"btn btn-light\">Shop</button></a></div>"+
                        "</body></html>"
        );
    }
}
