package travelThruAir;

// Import required java libraries
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static ArrayList<Flight> all_flights;
    public static HashMap<String, HashSet<Flight>> airport_flights = new HashMap<>();

    public void init() throws ServletException {
        all_flights = Database.getAllFlights();
        for (Flight flight : all_flights) {
            HashSet<Flight> airport_flights_map;

            if (!airport_flights.containsKey(flight.departure)) // check if orgin airport in hashmap
                airport_flights_map = new HashSet<Flight>();
            else
                airport_flights_map = airport_flights.get(flight.departure); // Get origin airport from Hashmap

            airport_flights_map.add(flight); // add flight to airport in hashmap
            airport_flights.put(flight.departure, airport_flights_map);

            if (!airport_flights.containsKey(flight.arrival)) // check if destination in airport map
                airport_flights.put(flight.arrival, new HashSet<Flight>());

        }
        return;
    }

    private ArrayList<Route> getRoutes(String src, String dest, int time) {
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>();
        this.getRoutes(src, dest, time, 0, "", flights, routes);
        routes.sort((r1, r2) -> {
            int res = r1.cost - r2.cost;
            if (res == 0) {
               res = r1.flights.size() - r2.flights.size();
               if (res == 0)
                  return r1.flyingTime - r2.flyingTime;
               return res;
            }
            return res;
         });
        return routes;
    }

    private void getRoutes(String src, String dest, int time, int cost, String path, ArrayList<Flight> flights,
            ArrayList<Route> routes) {
        if (!airport_flights.containsKey(dest) || !airport_flights.containsKey(src))
            return;
        if (src.equals(dest)) {
            if (flights.size() > 0)
                routes.add(new Route(flights));
            return;
        }
        for (Flight flight : airport_flights.get(src)) {
            if (flight.departureTime < time)
                continue;
            String next_airport = flight.arrival;
            if (!path.contains(next_airport)) {
                ArrayList<Flight> flights_copy = new ArrayList<Flight>(flights);
                flights_copy.add(flight);
                getRoutes(next_airport, dest, flight.arrivalTime + 30, cost + flight.getPrice(), path + src + "|",
                        flights_copy, routes);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String departure = request.getParameter("dep").toUpperCase();
            String arrival = request.getParameter("arr").toUpperCase();
            int time = Integer.parseInt(request.getParameter("time").replace(":", ""));
    
            ArrayList<Route> search_result = getRoutes(departure, arrival, time);
    
            response.setContentType("text/html");
            request.setCharacterEncoding("UTF-8");
            
            request.setAttribute("arr", arrival);
            request.setAttribute("dep", departure);
            request.setAttribute("time", request.getParameter("time"));
            request.setAttribute("result", search_result);    
            getServletConfig().getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }                
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        // do nothing.
    }
}
