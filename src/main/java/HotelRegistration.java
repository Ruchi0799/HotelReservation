import java.util.HashMap;

public class HotelRegistration {

    //public HashMap<String, List<Integer>> hotelsPresent=new HashMap<String, List<Integer>>();
    public HashMap<String, HashMap<String, Integer>> hotelsPresent=new HashMap<String, HashMap<String, Integer>>();
    //public HashMap<String, List<Integer>> bridgeWood=new HashMap<String, List<Integer>>();
    //public HashMap<String, List<Integer>> ridgeWood=new HashMap<String, List<Integer>>();
    HashMap<String,Integer> rating=new HashMap<String,Integer>();
    public int hotelRating;
    //public int bridgeWoodRating;
    //public int ridgeWoodRating;
    public boolean flag=false;
    public int count=0;


    public void setHotelsPresent(String hotelName,int weekdayRegular,int weekendRegular,int hotelRating){



        HashMap<String,Integer> hotelRates=new HashMap<String,Integer>();
        hotelRates.put("WeekdayRegular",weekdayRegular);
        hotelRates.put("WeekendRegular",weekendRegular);


        hotelsPresent.put(hotelName,hotelRates);
        rating.put(hotelName,hotelRating);
        countHotels();


    }


        public int countHotels(){
            count++;
            return count;
        }
}
