package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

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
                        "<table class=\"table table-striped\">"+
                            "<thead>"+
                                "<tr>"+
                                    "<th scope=\"col\">ID</th>"+
                                    "<th scope=\"col\">Name</th>"+
                                    "<th scope=\"col\">Price</th>"+
                                    "<th scope=\"col\"></th>"+
                                    "<th scope=\"col\"></th>"+
                                "</tr>"+
                            "</thead>"+
                            "<tbody>");


        Stock currentStock = new Stock();
        Item p1 = new Item("Asus Laptop", 1600);
        Item p2 = new Item("Harry Potter Ebook", 50);
        Item p3 = new Item("Lego Set", 80);

        currentStock.add(p1);
        currentStock.add(p2);
        currentStock.add(p3);
        Iterator<Item> i = currentStock.shopStock.iterator();
        Item currentProduct;
        while(i.hasNext()){
            currentProduct = i.next();
            out.println(
                    "<tr>"+
                        "<th scope=\"row\">"+ currentProduct.id +"</th>"+
                        "<td>"+ currentProduct.name +"</td>"+
                        "<td>"+ currentProduct.price +" USD</td>"+
                        "<td><button type=\"button\" class=\"btn btn-light\">Add</button></td>"+
                        "<td><button type=\"button\" class=\"btn btn-light\">Remove</button></td>"+
                    "</tr>"


            );
        }
        out.println(
                            "</tbody>"+
                        "</table>"+
                        "<div><a href=\"/cart\"><button type=\"button\" class=\"btn btn-light\">Check Shopping Cart</button></a></div>"+
                        "</body></html>"
        );
    }
}
