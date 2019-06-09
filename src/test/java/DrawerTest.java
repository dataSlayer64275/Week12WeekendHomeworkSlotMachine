import VendingMachine.Drawer.Drawer;
import VendingMachine.Drawer.drawerCode;
import VendingMachine.Products.Sweet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DrawerTest {

    Sweet MarsBar;
    Drawer drawer;

    @Before

    public void setUp() {
        MarsBar = new Sweet("Mars Bar", "Mars");
        drawer = new Drawer(drawerCode.C1, 90, MarsBar);
    }

    @Test
    public void hasCode() {
        assertEquals(drawerCode.C1, drawer.getCode());
    }
}
