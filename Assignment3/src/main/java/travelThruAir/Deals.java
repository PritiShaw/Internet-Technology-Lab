package travelThruAir;

public class Deals{
    String depart;
    String arrival;
    int price;
    int expiryTime;

    public Deals(String depart, String arrival, int price, int expiryTime){
        this.depart=depart;
        this.arrival=arrival;
        this.price=price;
        this.expiryTime=expiryTime;
    }

    public int getPrice(){
        return this.price;
    }
    
    public int getExpiryTime(){
        return this.expiryTime;
    } 

    public String getSector(){
        return this.depart + "-" + this.arrival;
    }

}

