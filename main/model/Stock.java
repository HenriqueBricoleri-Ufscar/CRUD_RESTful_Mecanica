package CRUD_RESTful_Mecanica.main.model;

public class Stock {
    
    private String id;
    private String name;
    private int quantity;
    private String car_model;
    private int car_year;

    public Stock() {}

    public Stock(String id, String name, int quantity, String car_model, int car_year) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.car_model = car_model;
        this.car_year = car_year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCar_model() {
        return car_model;
    }

    public int getCar_year() {
        return car_year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public void setCar_year(int car_year) {
        this.car_year = car_year;
    }
}
