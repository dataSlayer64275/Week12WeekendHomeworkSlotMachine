package VendingMachine.Coins;

import java.util.ArrayList;

public class coinReturn {

    private ArrayList<Coin> coins;

    public coinReturn (){
        this.coins = new ArrayList<Coin>();
    }

    public int getNumberOfCoins (){
        return coins.size();
    }

    public void addCoin(Coin coin){
        coins.add(coin);
    }

    public ArrayList<Coin> returnCoins(){
        return coins;
    }
}
