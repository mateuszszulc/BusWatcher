package pl.mszulc.BusWatcher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 08.01.12
 * Time: 18:00
 */
public class BusWatcherService {
    private BusWatcherMainWindow busWatcherMainWindow;
    private BusRouteManager timetable;

    public BusWatcherService(BusWatcherMainWindow busWatcherMainWindow) {
        this.busWatcherMainWindow = busWatcherMainWindow;
    }

    public void start() {
        int delay = 1000; //milliseconds
        //int delayBeforeNextPopup = nextBusTime - Calendar.getInstance();
        initializeMPKTimetable();
        if (timetable.nextBusInLessThanOneMinute())
            triggerDisplayInfo();

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println(Thread.currentThread());
                System.out.println("Jest tu!");
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private void triggerDisplayInfo() {
        int busCount = 3;
        List<Calendar> nextBuses = timetable.getNextBuses(busCount);
        busWatcherMainWindow.displayInfo(nextBuses);
    }

    private void initializeMPKTimetable() {
        List<Integer> routeNumbers = busWatcherMainWindow.getRouteNumbers();
        timetable = new BusRouteManager(routeNumbers);
        //timetable.setStartPoint(busWatcherMainWindow.getStartPoint());
        //timetable.setDestination(busWatcherMainWindow.getDestination());
    }
}
