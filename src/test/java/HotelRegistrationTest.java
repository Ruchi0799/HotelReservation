import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

public class HotelRegistrationTest {

    HotelRegistration hotelReservationSystem;

    @Test
    public void addingHotel_IfDone_ShouldReturnSize() {


        Integer arraySizeL = hotelReservationSystem.hotelName.size()+1;
        HashMap<CustomerType, Rate> map = new HashMap<CustomerType,Rate>();
        map.put(CustomerType.Regular, new Rate(110,90));
        map.put(CustomerType.Rewarded, new Rate(80,80));
        hotelReservationSystem = new HotelRegistration("Lakewood",3,map);
        hotelReservationSystem.addHotel(hotelReservationSystem);
        Integer resultL = hotelReservationSystem.hotelDetails();
        Assert.assertEquals(arraySizeL, resultL);
        
        Integer arraySizeB = hotelReservationSystem.hotelName.size()+1;
        HashMap<CustomerType, Rate> mapB = new HashMap<CustomerType,Rate>();
        mapB.put(CustomerType.Regular, new Rate(160,40));
        mapB.put(CustomerType.Rewarded, new Rate(110,50));
        hotelReservationSystem = new HotelRegistration("Bridgewood",4,mapB);
        hotelReservationSystem.addHotel(hotelReservationSystem);
        Integer resultB = hotelReservationSystem.hotelDetails();
        Assert.assertEquals(arraySizeB, resultB);

        Integer arraySizeR = hotelReservationSystem.hotelName.size()+1;
        HashMap<CustomerType, Rate> mapR = new HashMap<CustomerType,Rate>();
        mapR.put(CustomerType.Regular, new Rate(220,150));
        mapR.put(CustomerType.Rewarded, new Rate(100,40));
        hotelReservationSystem = new HotelRegistration("Ridgewood",5,mapR);
        hotelReservationSystem.addHotel(hotelReservationSystem);
        Integer resultR = hotelReservationSystem.hotelDetails();
        Assert.assertEquals(arraySizeR, resultR);


    }

    @Test
    public void findHotelName_CheapestAmongAll_ShouldReturnName() {

        Scanner sc = new Scanner(System.in);
        String inputDate ="11Sep2020,12Sep2020";
        hotelReservationSystem = new HotelRegistration();
        String name = hotelReservationSystem.calculateHotel(inputDate);
        Assert.assertEquals("Lakewood", name);

    }

//    @Test
//    public void findHotelName_BestRatedCheapestAmongAll_ShouldReturnName() {
//
//        Scanner sc = new Scanner(System.in);
//        String inputDate ="11Sep2020,12Sep2020";
//        hotelReservationSystem = new HotelRegistration();
//        String name = hotelReservationSystem.calculateHotel(inputDate);
//         Assert.assertEquals("Bridgewood", name);
//
//    }



    @Test
    public void findHotelName_BestRatedCheapestAmongAll_ShouldReturnName() {
        Scanner sc = new Scanner(System.in);
        String inputDate ="11Sep2020,12Sep2020";
        hotelReservationSystem = new HotelRegistration();
        String name = hotelReservationSystem.BestRatedCheapHotel(inputDate);
        Assert.assertEquals("Bridgewood", name);

    }
}
