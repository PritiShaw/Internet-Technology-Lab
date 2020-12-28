package Apparel_Store;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/auth/signin")
public class SignIn extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null)
            response.sendRedirect("");
        else {
            ServletContext context = getServletContext();
            DBConnection dbManager = (DBConnection) context.getAttribute("DBManager");
            Connection conn = dbManager.getConnection();

            String username = request.getParameter("email");
            String password = request.getParameter("password");
            Integer hashcode = password.hashCode();
            Statement stmt;
            try {
                stmt = conn.createStatement();
                String sql = "SELECT gender, preference, name FROM users WHERE username = '" + username + "' and hash=" + Integer.toString(hashcode);
                
                ResultSet rs = stmt.executeQuery(sql);
                int count = 0;
                String gender = "";
                String preference = "";
                String name = "";
                while (rs.next()){
                    gender = rs.getString("gender");
                    preference = rs.getString("preference");
                    name = rs.getString("name");
                    count++;
                }
                if(count==1){
                    session.setAttribute("name", name);
                    session.setAttribute("email", username);
                    session.setAttribute("gender", gender);
                    session.setAttribute("preference", preference);
                    response.sendRedirect("");
                }
                else{                    
                    request.setAttribute("login_error", "Email or Password is wrong");
                    request.setCharacterEncoding("UTF-8");
                    request.getRequestDispatcher("/authorization.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();                
                request.setAttribute("login_error", e.getMessage());
                request.setCharacterEncoding("UTF-8");
                request.getRequestDispatcher("/authorization.jsp").forward(request, response);
            }            
        }        
    }
}
