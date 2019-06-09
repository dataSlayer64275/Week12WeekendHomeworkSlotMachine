import VendingMachine.Coins.Coin;
import VendingMachine.Coins.coinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CoinTest {

    Coin coin;

    @Before

    public void setUp() {
        coin = new Coin(coinType.ONE);
    }

    @Test
    public void hasType() {
        assertEquals(coinType.ONE, coin.getType());
    }

    @Test
    public void hasCorrectType() {
        assertNotEquals(coinType.TWENTY, coin.getType());
    }
}
