package Apparel_Store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LinkedList<Product> getApparels(Statement stmt, HttpSession session) throws SQLException {
        LinkedList<Product> apparels = new LinkedList<>();
        String gender = (String) session.getAttribute("gender");
        String preference = (String) session.getAttribute("preference");
        String condition = "GENDER = '" + gender + "'";
        if(preference.equals("D"))
            condition += " and discount>0";
        else{
            Date today = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            condition += " and added_on>'" + df.format(new Date(today.getTime() - 604800000)) + "'";
        }
        String sql =  "SELECT P.product_id, D.discount_id, name, gender, cost, discount, added_on, img_url FROM `products` P "
                    + "LEFT JOIN ("
                    + "SELECT id as discount_id, product_id, MAX(discount) as discount, expiry from discount "
                    + "GROUP BY product_id "
                    + "HAVING (expiry is NULL OR expiry >= CURRENT_DATE())"
                    + ") D ON D.product_id = P.product_id "
                    + "WHERE " + condition
                    + " ORDER BY RAND()";                    
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next())
            apparels.add(new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("gender"),
                    rs.getInt("cost"), rs.getInt("discount"), rs.getDate("added_on"), rs.getString("img_url"), rs.getInt("discount_id")));
        return apparels;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
        Connection conn = dbManager.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            request.setAttribute("results", getApparels(stmt, request.getSession()));
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
