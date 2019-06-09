package VendingMachine.Drawer;

import VendingMachine.Products.Product;

import java.util.ArrayList;

public class Drawer {

    private drawerCode code;
    private int price;
    private Product product;

    public Drawer(drawerCode code, int price, Product product){
        this.code = code;
        this.price = price;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public drawerCode getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    public void removeProduct() {
        this.product = null;
    }
}
