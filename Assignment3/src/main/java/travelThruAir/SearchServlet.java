package travelThruAir;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.Gson;

// Extend HttpServlet class
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Search";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String src=request.getParameter("src");
        String dest=request.getParameter("dest");
        int time =Integer.parseInt(request.getParameter("time"));

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + src + " "+ dest+ " " + Integer.toString(time) + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}
