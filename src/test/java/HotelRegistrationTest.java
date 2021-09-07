import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HotelRegistrationTest {
    @Test
    public void setHotel_ifAdded_return_countOfTotalHotels(){
        HotelRegistration hotelReservation=new HotelRegistration();
        hotelReservation.setHotelsPresent("LakeWood",110,90,3);
        hotelReservation.setHotelsPresent("BridgeWood",160,60,4);
        hotelReservation.setHotelsPresent("RidgeWood",220,150,5);
        Assert.assertEquals(3,hotelReservation.count);

    }

}
