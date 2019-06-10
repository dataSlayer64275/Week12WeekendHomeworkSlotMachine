import VendingMachine.Drawer.Drawer;
import VendingMachine.Drawer.drawerCode;
import VendingMachine.Products.Sweet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DrawerTest {

    Sweet marsBar;
    Drawer drawer;

    @Before

    public void setUp() {
        marsBar = new Sweet("Mars Bar", "Mars");
        drawer = new Drawer(drawerCode.C1, 90, marsBar);
    }

    @Test
    public void hasCode() {
        assertEquals(drawerCode.C1, drawer.getCode());
    }

    @Test
    public void hasProduct() {
        assertEquals(marsBar, drawer.getProduct());
    }

    @Test
    public void hasPrice() {
        assertEquals(90, drawer.getPrice());
    }
}
