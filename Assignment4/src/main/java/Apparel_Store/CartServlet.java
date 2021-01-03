package Apparel_Store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.LinkedList;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
        HttpSession session = request.getSession();
        Connection conn = dbManager.getConnection();
        String user_id = (String)session.getAttribute("email");
        try {            
            LinkedList<Product> result = new LinkedList<>();
            if(user_id!=null && user_id.length()>0){
                    Statement stmt = conn.createStatement();
                    String sql =  "SELECT P.product_id, name, IFNULL(discount, 0) as discount, qty, cost from "
                                + " (SELECT * FROM cart WHERE qty>0 AND cart.user_id = '" + user_id + "') C "
                                + " INNER JOIN products P on C.product_id = P.product_id "
                                + " LEFT JOIN "
                                + " (SELECT * FROM discount WHERE (discount.expiry is NULL OR discount.expiry >= CURRENT_DATE())) D "
                                + " on D.id = C.discount_id";
                    
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        result.add(new Product(
                            rs.getInt("product_id"),
                            rs.getString("name"),
                            rs.getInt("discount"),
                            rs.getInt("qty"),
                            rs.getInt("cost")
                        ));
                }
            }
            request.setAttribute("cart_items", result);
            request.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
        Connection conn = dbManager.getConnection();
        String user_id = (String)request.getSession().getAttribute("email");
        PrintWriter writer = response.getWriter();
        String product_id = (String)request.getParameter("pid");
        try {            
            if(product_id !=null && product_id.length()>0 && user_id!=null && user_id.length()>0){
                Statement stmt = conn.createStatement();
                String deal_id = (String)request.getParameter("dis");
                if(Integer.parseInt(deal_id)<1)                    
                    deal_id = null;
                String sql =    "INSERT INTO cart (product_id, user_id, discount_id) VALUES  ("
                                + product_id
                                + ", '" 
                                + user_id 
                                + "', " 
                                + deal_id
                                + ") ON DUPLICATE KEY UPDATE qty = qty + 1";
                stmt.executeUpdate(sql);
                
                request.getSession().setAttribute("tracker", 
                    (int)request.getSession().getAttribute("tracker") + (deal_id==null?-1:1));                
                // If add to cart is discounted then increment tracker else decrement

                if((int)request.getSession().getAttribute("tracker")<0)
                    request.getSession().setAttribute("preference", "N");                     
                else
                    request.getSession().setAttribute("preference", "D");      
                writer.print("200");
            }
            else{
                writer.print("100");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            writer.print("500");
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
        HttpSession session = request.getSession();
        Connection conn = dbManager.getConnection();
        String user_id = (String)session.getAttribute("email");
        String product_id = (String)request.getParameter("pid");
        PrintWriter writer = response.getWriter();

        try {            
            if(product_id !=null && product_id.length()>0 && user_id!=null && user_id.length()>0){
                Statement stmt = conn.createStatement();
                String sql =  "DELETE FROM cart "
                            + "WHERE product_id = " + product_id                                
                            + " AND user_id = '" + user_id + "'";
                stmt.executeUpdate(sql);
                writer.print("200");
            }
            else{
                writer.print("100");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            writer.print("500");
        }
    }
}
