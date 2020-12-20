package Apparel_Store;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/auth/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null)
            response.sendRedirect("");
        else {
            ServletContext context = getServletContext();
            DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
            Connection conn = dbManager.getConnection();

            String name = request.getParameter("name");
            String username = request.getParameter("email");
            String gender = request.getParameter("gender");
            String preference = request.getParameter("preference");
            String password = request.getParameter("password");
            Integer hashcode = 7;
            for (int i = 0; i < password.length() ; i++) {
                hashcode = hashcode*31 + password.charAt(i);
            }
            Statement stmt;
            try {
                stmt = conn.createStatement();
                String sql = "INSERT into users (name,username,hash,gender,preference) values ('" + name + "','" + username + "', " + Integer.toString(hashcode) + ", '" + gender + "', '" + preference + "')";
                stmt.executeUpdate(sql);       
                
                session.setAttribute("name", name);
                session.setAttribute("email", username);
                session.setAttribute("gender", gender);
                session.setAttribute("preference", preference);         
                response.sendRedirect("");                
            } 
            catch (SQLException e) {
                request.setAttribute("reg_error", e.getMessage());
                request.setCharacterEncoding("UTF-8");
                request.getRequestDispatcher("/authorization.jsp").forward(request, response);
                e.printStackTrace();
            }            
        }        
    }
}