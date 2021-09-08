import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelRegistration {
    public static ArrayList<HotelRegistration> hotelName = new ArrayList<>();
    public LinkedList<HotelRates> rates1=new LinkedList<>();
    public LinkedList<HotelRates> rates2=new LinkedList<>();

    String name;
    Integer rating;
    Map<CustomerType,Rate> rates;

    public HotelRegistration() {

    }

    public HotelRegistration(String name,Integer rating,Map<CustomerType,Rate> rates) {
        this.name = name;
        this.rating = rating;
        this.rates = rates;
    }

    public void addHotel(HotelRegistration hotelRegistration) {
        hotelName.add(hotelRegistration);
    }

    public Integer hotelDetails() {
        return hotelName.size();
    }

    public String calculateHotel(String inputDate){

        String[] inputArr = inputDate.split(",");
        DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");

        ArrayList<LocalDate> dateArr = new ArrayList<>();
        dateArr.add(LocalDate.parse(inputArr[0],fomat));
        long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));

        while(noOfDaysBetween>0) {
            dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOfDaysBetween--;
        }

        Integer[] rate=new Integer[] {0,0,0};
        int total=0;



        dateArr.stream().forEach(n->{
            for(int i=0;i<hotelName.size();i++) {
                if (n.getDayOfWeek().equals(DayOfWeek.SATURDAY) || n.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekEnd;

                   HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates1.add(hotelRates);
                }
                else {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekDay;

                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates1.add(hotelRates);
                }

            }
        });



        Integer n = Arrays.asList(rate).indexOf(Collections.min(Arrays.asList(rate)));

        
       System.out.println(hotelName.get(n).name + ", Rate: " + rate[n]);
        return hotelName.get(n).name;
    }



    public String BestRatedCheapHotel(String inputDate){

        String[] inputArr = inputDate.split(",");
        DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");

        ArrayList<LocalDate> dateArr = new ArrayList<>();
        dateArr.add(LocalDate.parse(inputArr[0],fomat));
        long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));

        while(noOfDaysBetween>0) {
            dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOfDaysBetween--;
        }

        Integer[] rate=new Integer[] {0,0,0};
        int total=0;



        dateArr.stream().forEach(n->{
            for(int i=0;i<hotelName.size();i++) {

                if (n.getDayOfWeek().equals(DayOfWeek.SATURDAY) || n.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekEnd;

                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates1.add(hotelRates);
                }
                else {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekDay;
                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates1.add(hotelRates);
                }

            }
        });



        Integer n = Arrays.asList(rate).indexOf(Collections.min(Arrays.asList(rate)));
        for(int i=3;i<rates1.size()-1;i++){
            if(rates1.get(i).ratestotal>rates1.get(i+1).ratestotal)
            {
                int temp=rates1.get(i).ratestotal;
                rates1.get(i).ratestotal=rates1.get(i+1).ratestotal;
                rates1.get(i+1).ratestotal=temp;

            }
        }

        if(rates1.get(3).rating>rates1.get(4).rating && rates1.get(3).ratestotal.equals(rates1.get(4).ratestotal))
        {
            System.out.println(rates1.get(3).name + ", Rate: " + rates1.get(3).ratestotal+" Ratings: " +rates1.get(3).rating);
            return rates1.get(3).name;
        }
        else if(rates1.get(3).rating<rates1.get(4).rating && rates1.get(3).ratestotal.equals(rates1.get(4).ratestotal))
        {

            System.out.println(rates1.get(4).name + ", Rate: " + rates1.get(4).ratestotal +" Ratings: " +rates1.get(4).rating);
            return rates1.get(4).name;
        }


        return "none";
    }


    public String BestRatedHotel(String inputDate){

        String[] inputArr = inputDate.split(",");
        DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");

        ArrayList<LocalDate> dateArr = new ArrayList<>();
        dateArr.add(LocalDate.parse(inputArr[0],fomat));
        long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));

        while(noOfDaysBetween>0) {
            dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOfDaysBetween--;
        }

        Integer[] rate=new Integer[] {0,0,0};
        int total=0;

        System.out.println(hotelName.size());
        dateArr.stream().forEach(n->{
            for(int i=0;i<hotelName.size();i++) {

                if (n.getDayOfWeek().equals(DayOfWeek.SATURDAY) || n.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekEnd;

                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates1.add(hotelRates);
                }
                else {
                    rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekDay;
                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates1.add(hotelRates);
                }

            }
        });
        
        Integer n = Arrays.asList(rate).indexOf(Collections.min(Arrays.asList(rate)));
        for(int i=3;i<rates1.size()-1;i++){
            if(rates1.get(i).rating>rates1.get(i+1).rating)
            {
                int temp=rates1.get(i).rating;
                rates1.get(i).rating=rates1.get(i+1).rating;
                rates1.get(i+1).rating=temp;

            }
        }



            System.out.println("Best rated hotel: " + rates1.get(5).name + ", " + "Rate: " + rates1.get(5).ratestotal + " Ratings: " + rates1.get(5).rating);

            return "Best rated hotel: " + rates1.get(5).name + ", " + "Rate: " + rates1.get(5).ratestotal + " Ratings: " + rates1.get(5).rating;



    }

    public String BestRatedCheapHotelForRewarded(String inputDate){

        String[] inputArr = inputDate.split(",");
        DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");

        ArrayList<LocalDate> dateArr = new ArrayList<>();
        dateArr.add(LocalDate.parse(inputArr[0],fomat));
        long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));

        while(noOfDaysBetween>0) {
            dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOfDaysBetween--;
        }

        Integer[] rate=new Integer[] {0,0,0};
        int total=0;



        dateArr.stream().forEach(n->{
            for(int i=0;i<hotelName.size();i++) {

                if (n.getDayOfWeek().equals(DayOfWeek.SATURDAY) || n.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Rewarded).weekEnd;
                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates2.add(hotelRates);
                }
                else {

                    rate[i] += hotelName.get(i).rates.get(CustomerType.Rewarded).weekDay;
                    HotelRates hotelRates=new HotelRates(hotelName.get(i).name,hotelName.get(i).rating,rate[i]);
                    rates2.add(hotelRates);
                }

            }
        });



        for(int m=5;m>2;m--){
            if(rates2.get(m).ratestotal<=rates2.get(m-1).ratestotal)
            {

                System.out.println("Best rated cheap hotel for rewarded: "+rates2.get(m).name + ", Rate: " + rates2.get(m).ratestotal+" Ratings: " +rates2.get(m).rating);
                return "Best rated cheap hotel for rewarded: "+rates2.get(m).name + ", Rate: " + rates2.get(m).ratestotal+" Ratings: " +rates2.get(m).rating;
            }
        }
        
        return "none";
    }




}
