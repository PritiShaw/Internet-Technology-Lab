package Apparel_Store;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.LinkedList;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
        Connection conn = dbManager.getConnection();
        String query = request.getParameter("query");
        try {            
            LinkedList<Product> result = new LinkedList<>();
            if(query!=null && query.length()>0){
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM products WHERE LOWER(name) LIKE '%" + query.toLowerCase() + "%'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) 
                    result.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getInt("cost"),
                        rs.getInt("discount"),
                        rs.getDate("added_on"),
                        rs.getString("image_url")
                    ));
            }
            request.setAttribute("search_result", result);
            request.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}