package pl.mszulc.BusWatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 07.01.12
 * Time: 23:36
 */
public class BusRouteManagerTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBusTimetable() throws Exception {
        BusRouteManager.getBusRouteInformation(1);
    }
}
