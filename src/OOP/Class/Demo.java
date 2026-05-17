package OOP.Class;

import java.time.LocalDate;

class Product{
    Integer id;
    String name;
    Float price;
    int quantity;
    LocalDate importedDate;

    // constructor
    Product(){} // default constructor

    Product(Integer id, String name,
            float price, int quantity,
            LocalDate importedDate){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.importedDate = importedDate;
    }// constructor with parameters
    // method
    void getProductInfo(){
        System.out.println("============ | Product Info | ==========");
        System.out.println("ID :" + id);
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
        System.out.println("Quantity : " + quantity);
        System.out.println("Imported Date : " + importedDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", importedDate=" + importedDate +
                '}';
    }
}
public class Demo {
    public static void main(String[] args) {
        Product product = new Product();
        Product product1 = new Product(1,"Apple",10.5f,10,LocalDate.now());

        product.getProductInfo();
        product1.getProductInfo();
    }
}
