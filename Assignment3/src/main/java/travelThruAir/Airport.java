package travelThruAir;

public class Airport {
    String code;
    String name;
    double latitude;
    double longitude;

    public Airport(String code, String name, double latitude, double longitude){
        this.code = code;
        this.name = name;
        this.longitude = Math.toRadians(latitude);
        this.longitude = Math.toRadians(longitude);
    }

    public Boolean closerTo(String code1,String code2){
        Airport a1 = AirportDetailsServlet.airports.get(code1);        
        double dlon1 = a1.longitude - longitude;
        double dlat1 = a1.latitude - latitude;

        Airport a2 = AirportDetailsServlet.airports.get(code2);
        double dlon2 = a2.longitude - longitude;
        double dlat2 = a2.latitude - latitude;

        double cal1 = Math.pow(Math.sin(dlat1 / 2), 2) 
        + Math.cos(latitude) * Math.cos(a1.latitude) 
        * Math.pow(Math.sin(dlon1 / 2),2); 

        double cal2 = Math.pow(Math.sin(dlat2 / 2), 2) 
        + Math.cos(latitude) * Math.cos(a2.latitude) 
        * Math.pow(Math.sin(dlon2 / 2),2); 

        double dist1 = Math.asin(Math.sqrt(cal1));
        double dist2 = Math.asin(Math.sqrt(cal2));

        return !(dist1 <= dist2);
    }
}
