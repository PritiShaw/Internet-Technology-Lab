package travelThruAir;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello Admin";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        String dep = request.getParameter("departure").toUpperCase();
        String arr = request.getParameter("arrival").toUpperCase();
        String pass = request.getParameter("password");
        int cos = Integer.parseInt(request.getParameter("cost"));
        int exp = Integer.parseInt(request.getParameter("expiry").replace(":", ""));
        
        
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        
        if(pass.equals("password")){
            Database.addDeal(dep, arr, cos, exp);
            request.setAttribute("message", "Success");
        }
        else{
            request.setAttribute("message", "Access Denied");
        }
        getServletConfig().getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("message", "");
        getServletConfig().getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
    }

    public void destroy() {
        // do nothing.
    }
}
