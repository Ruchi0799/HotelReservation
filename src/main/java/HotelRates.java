public class HotelRates {
    String name;
    Integer rating;
    Integer ratestotal;

    public HotelRates(String name, Integer rating, Integer ratestotal) {
        this.name = name;
        this.rating = rating;
        this.ratestotal = ratestotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRatestotal() {
        return ratestotal;
    }

    public void setRatestotal(Integer ratestotal) {
        this.ratestotal = ratestotal;
    }
}
