package travelThruAir;
import java.util.Random;

import javax.xml.crypto.Data; 

public class Flight{
    String flightNumber;
    String departure;
    String arrival;
    int departureTime;
    int arrivalTime;
    int price;
    int totalCost;
    boolean isDiscounted = false;

    public Flight(String flightNumber, String departure, String arrival, int departureTime, int arrivalTime){
        this.flightNumber=flightNumber;
        this.departure=departure;
        this.arrival=arrival;
        this.departureTime=departureTime;   
        this.arrivalTime=arrivalTime;
        
        int duration = getDuration(); 
        Random rand = new Random();   

        int rand_int = rand.nextInt(5) + 5; 
        this.price = duration * rand_int;
        while(this.price < 1000)
            this.price *= rand_int;

        this.totalCost=this.price;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public String getArrival(){
        return arrival;
    }

    public String getDeparture(){
        return departure;
    }
    
    public int getDuration(){
        int departureTimeMin = departureTime%100;
        int departureTimeHr = departureTime/100;
        int arrivalTimeMin = arrivalTime%100;
        int arrivalTimeHr = arrivalTime/100;
        int hrDiff = arrivalTimeHr - departureTimeHr;
        int minDiff = arrivalTimeMin - departureTimeMin;
      
        if(minDiff<0){
            minDiff += 60;
            hrDiff -= 1;
        }
        else if(minDiff>59){
            minDiff -= 60;
            hrDiff += 1;
        }
        return hrDiff*100+minDiff;
    }
    public String getDuration(int i){
        int duration = getDuration();
        int durationMin = duration%100;
        int durationHr = duration/100;
        if(durationHr == 0)
           return durationMin + " min";
        if(durationMin == 0)
           return durationHr + " hr";
        return durationHr + "hr "  + durationMin + "min";
    }

    public int getDepartureTime(){
        return this.departureTime;
    }
    public int getArrivalTime(){
        return this.arrivalTime;
    }
    public int getPrice(){
        int discounted_rate = Database.getDealDiscount(departure, arrival, departureTime);
        int cost = this.totalCost;
        if (discounted_rate > 0 && discounted_rate < cost){
            cost = discounted_rate;
            isDiscounted = true;
        }
        else
            isDiscounted = false;
        return cost;
    }
    public int getTotalCost(){
        return this.totalCost;
    }
    public Boolean isDiscounted(){
        return isDiscounted;
    }
}
