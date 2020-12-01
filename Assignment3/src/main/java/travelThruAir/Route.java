package travelThruAir;

import java.util.ArrayList;

public class Route {
   int cost;
   int start;
   int end;
   int flyingTime;
   ArrayList<Flight> flights;

   public Route(ArrayList<Flight> flights) {
      int cost = 0;
      int start = -1;
      int end = 0;
      for (Flight flight : flights) {
         if (start < 0)
            start = flight.getDepartureTime();
         cost += flight.getPrice();
         end = flight.getArrivalTime();
         flyingTime += flight.getDuration();
      }
      this.cost = cost;
      this.flights = flights;
      this.end = end;
   }

   public int getStart() {
      return start;
   }

   public int getEnd() {
      return end;
   }

   public int getCost() {
      return cost;
   }

   public int getDuration() {
      return end - start;
   }

   public ArrayList<Flight> getFlights() {
      return flights;
   }

   public void addFlight(Flight flight) throws Exception {
      if (this.end > 0 && (flight.getDepartureTime() < (this.end + 30)))
         throw new Exception("Flights Overlap");

      this.cost += flight.getPrice();
      if (this.start < 0)
         this.start = flight.getDepartureTime();
      this.end = flight.getArrivalTime();
      this.flights.add(flight);
   }
}
