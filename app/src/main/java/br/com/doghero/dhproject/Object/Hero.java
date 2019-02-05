package br.com.doghero.dhproject.Object;

public class Hero {

    private String  first_name              ;
    private String  address_neighborhood    ;
    private Double  price                   ;
    private String  image_url               ;
    private boolean is_superhero            ;

    public Hero(String first_name, String address_neighborhood, Double price, String image_url, boolean is_superhero){
        this.first_name = first_name;
        this.address_neighborhood = address_neighborhood;
        this.price = price;
        this.image_url = image_url;
        this.is_superhero = is_superhero;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAddress_neighborhood() {
        return address_neighborhood;
    }

    public void setAddress_neighborhood(String address_neighborhood) {
        this.address_neighborhood = address_neighborhood;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isIs_superhero() {
        return is_superhero;
    }

    public void setIs_superhero(boolean is_superhero) {
        this.is_superhero = is_superhero;
    }


}
