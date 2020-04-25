package com.codecool.servlet;

import javax.servlet.RequestDispatcher;
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

    Stock currentStock = new Stock();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ddd");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String title = "Shop";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title>" +
                        //"<link rel=\"stylesheet\" type=\"text/css\" href=\"/Resources/css/main.css\">" +
                        "<script language=\"JavaScript\">");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/js/main.js");
        requestDispatcher.include(request, response);
        out.println(
                        "</script>" +
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


        Iterator<Item> i = currentStock.shopStock.iterator();
        Item currentProduct;
        while(i.hasNext()){
            currentProduct = i.next();
            out.println(
                    "<tr>"+
                        "<th scope=\"row\">"+ currentProduct.id +"</th>"+
                        "<td>"+ currentProduct.name +"</td>"+
                        "<td>"+ currentProduct.price +" USD</td>"+
                        "<td>" +
                            "<form action=\"cart\" method=\"post\"> " +
                                "<input type=\"hidden\" name=\"product_id\" value=\"add_"+ currentProduct.id +"\" >"+
                                "<input type=\"submit\" class=\"btn btn-light\" value=\"Add\">"+
                            "</form>" +
                        "</td>"+
                        "<td><button type=\"button\" class=\"btn btn-light\" name=\"remove_"+ currentProduct.id +"\">Remove</button></td>"+
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
