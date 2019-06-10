import VendingMachine.Coins.Coin;
import VendingMachine.Coins.coinType;
import VendingMachine.Drawer.Drawer;
import VendingMachine.Drawer.drawerCode;
import VendingMachine.Products.Crisp;
import VendingMachine.Products.Drink;
import VendingMachine.Products.Sweet;
import VendingMachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VendingMachineTest {

    Drink IrnBru;
    Crisp CheeseAndOnion;
    Sweet MarsBar;
    Drawer drawer1;
    Drawer drawer2;
    Drawer drawer3;
    VendingMachine vendingMachine;
    Coin one;
    Coin two;
    Coin five;
    Coin ten;
    Coin twenty;
    Coin fifty;


    @Before

    public void setUp() {
        IrnBru = new Drink("Irn Bru", "Barr");
        CheeseAndOnion = new Crisp("Cheese and Onion", "Lays");
        MarsBar = new Sweet("Mars Bar", "Mars");
        drawer1 = new Drawer(drawerCode.A1, 75, IrnBru );
        drawer2 = new Drawer(drawerCode.B1, 60, CheeseAndOnion);
        drawer3 = new Drawer(drawerCode.C1, 90, MarsBar);
        vendingMachine = new VendingMachine();
        vendingMachine.addDrawer(drawer1);
        vendingMachine.addDrawer(drawer2);
        vendingMachine.addDrawer(drawer3);
        one = new Coin(coinType.ONE);
        two = new Coin(coinType.TWO);
        five = new Coin(coinType.FIVE);
        ten = new Coin(coinType.TEN);
        twenty = new Coin(coinType.TWENTY);
        fifty = new Coin(coinType.FIFTY);
    }

    @Test
    public void canAddDrawers() {
        assertEquals(3, vendingMachine.getNumberOfDrawers());
    }

    @Test
    public void canGetProductFromDrawers() {
        assertEquals(IrnBru, vendingMachine.getProduct(drawer1));
    }

    @Test
    public void canGetPriceFromDrawers() {
        assertEquals(60, vendingMachine.getPrice(drawer2));
    }

    @Test
    public void canAddCoins() {
        vendingMachine.addCoin(five);
        vendingMachine.addCoin(fifty);
        vendingMachine.addCoin(twenty);
        assertEquals(75, vendingMachine.getTotalCoinValue());
    }

    @Test
    public void cannotAddInvalidCoins() {
        vendingMachine.addCoin(one);
        vendingMachine.addCoin(two);
        vendingMachine.addCoin(one);
        vendingMachine.addCoin(two);
        assertEquals(4, vendingMachine.getCoinReturnNumberOfCoins());
    }

    @Test
    public void canBuyProduct() {
        vendingMachine.addCoin(five);
        vendingMachine.addCoin(fifty);
        vendingMachine.addCoin(twenty);
        assertEquals(75, vendingMachine.getTotalCoinValue());
        assertEquals(IrnBru, vendingMachine.buy(drawerCode.A1));
        assertEquals(0, vendingMachine.getTotalCoinValue());
    }

    @Test
    public void canReturnChangeAfterBuyingProduct() {
        vendingMachine.addCoin(five);
        vendingMachine.addCoin(fifty);
        vendingMachine.addCoin(twenty);
        vendingMachine.addCoin(twenty);
        assertEquals(95, vendingMachine.getTotalCoinValue());
        assertEquals(CheeseAndOnion, vendingMachine.buy(drawerCode.B1));
        assertEquals(0, vendingMachine.getTotalCoinValue());
        assertEquals(1, vendingMachine.getCoinReturnNumberOfCoins());

    }

    @Test
    public void cannotBuyProductWithUnsufficientFunds() {
        vendingMachine.addCoin(fifty);
        assertEquals(null, vendingMachine.buy(drawerCode.C1));
    }

    @Test
    public void canReturnCoins() {
        vendingMachine.addCoin(twenty);
        vendingMachine.addCoin(fifty);
        vendingMachine.addCoin(twenty);
        assertEquals(90, vendingMachine.getTotalCoinValue());
        vendingMachine.returnCoins();
        assertEquals(0, vendingMachine.getTotalCoinValue());
    }
}
