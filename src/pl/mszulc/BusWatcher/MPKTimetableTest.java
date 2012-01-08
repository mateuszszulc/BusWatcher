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
public class MPKTimetableTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBusTimetable() throws Exception {
        MPKTimetable.getBusTimetable(1);
    }
}
