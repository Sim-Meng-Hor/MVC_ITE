package OOP.Class.Phone;

public class Phone {
    String brand;
    String model;
    double price;
    int storage;
    int battery;

    Phone(){}

    Phone(String brand, String model, double price, int storage, int battery){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storage = storage;
        this.battery = battery;
    }

    void calling(){
        System.out.println("Phone is Charging...");
        System.out.println("Battery : " + battery);
    }

    void getPhoneInfo(){
        System.out.println("============ | Phone Info | ===========");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
        System.out.println("Storage : " + storage);
        System.out.println("Battery : " + battery);
    }
}
