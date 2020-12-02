package travelThruAir;

// Import required java libraries
import java.io.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class AirportDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static HashMap<String,Airport> airports;

    public void init() throws ServletException {
        // Do required initialization
        airports = Database.getAirportDetails();
        return;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code").toUpperCase();
        response.setContentType("text/plain");
        request.setCharacterEncoding("UTF-8");
        if (airports.containsKey(code))
            response.getWriter().print(airports.get(code).name);
        else
            response.getWriter().print("");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void destroy() {
        // do nothing.
    }
}
