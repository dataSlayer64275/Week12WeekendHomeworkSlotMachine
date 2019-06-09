package VendingMachine.Products;

public abstract class Product {

    private String name;
    private String brand;

    public Product(String name, String brand){
        this.name = name;
        this.brand = brand;
    }
}
