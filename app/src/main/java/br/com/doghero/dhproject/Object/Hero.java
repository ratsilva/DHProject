package br.com.doghero.dhproject.Object;

public class Hero {

    private String  address_neighborhood    ;
    private Double  price                   ;
    private boolean is_superhero            ;
    private User    user                    ;

    public Hero(String address_neighborhood, Double price, boolean is_superhero, User user){
        this.user = user;
        this.address_neighborhood = address_neighborhood;
        this.price = price;
        this.is_superhero = is_superhero;
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

    public boolean isIs_superhero() {
        return is_superhero;
    }

    public void setIs_superhero(boolean is_superhero) {
        this.is_superhero = is_superhero;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public class User {

        private String  first_name              ;
        private String  image_url               ;

        public User(String first_name, String image_url) {
            this.first_name = first_name;
            this.image_url = image_url;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}
