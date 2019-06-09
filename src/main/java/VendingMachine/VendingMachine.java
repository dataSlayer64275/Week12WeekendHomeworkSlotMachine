package VendingMachine;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.coinReturn;
import VendingMachine.Coins.coinType;
import VendingMachine.Drawer.Drawer;
import VendingMachine.Drawer.drawerCode;
import VendingMachine.Products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private ArrayList<Coin> coins;
    private coinReturn coinReturn;

    public VendingMachine(){
        this.drawers = new ArrayList<Drawer>();
        this.coins = new ArrayList<Coin>();
        this.coinReturn = new coinReturn();
    }

    public void addDrawer(Drawer drawer){
        drawers.add(drawer);
    }

    public int getNumberOfDrawers(){
        return drawers.size();
    }

    public Product getProduct(Drawer drawer) {
        return drawer.getProduct();
    }

//    public void removeProduct(Drawer drawer){
//        drawer.removeProduct();
//    }

    public boolean checkCoinValid(Coin coin) {
        coinType type = coin.getType();
        if (type == coinType.ONE || type == coinType.TWO) {
            return false;
        }
        return true;
    }

    public void addCoin(Coin coin){
        if (checkCoinValid(coin)){
            coins.add(coin);
        } else {
            coinReturn.addCoin(coin);
        }
    }

    public int getTotalCoinValue(){
        int total = 0;
        for (Coin coin : coins){
            total += coin.getValue();
        }
        return total;
    }

    public int getCoinReturnNumberOfCoins(){
        return coinReturn.getNumberOfCoins();
    }

    public Product buy(drawerCode code){
        for (Drawer drawer : drawers) {
            if (drawer.getCode() == code) {
                if (drawer.getPrice() <= getTotalCoinValue()) {
                    return vend(drawer.getProduct());
                }
            }
        }
        return null;
    }

    public Product vend(Product product){
        coins.clear();

        return product;

    }

}
