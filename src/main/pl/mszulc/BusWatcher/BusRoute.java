package pl.mszulc.BusWatcher;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 06.01.12
 * Time: 10:19
 */
public class BusRoute {
    List<BusStation> primaryBusStationList;
    List<BusStation> reverseBusStationList;

    enum BusDirection {PRIMARY_DIRECTION, SECONDARY_DIRECTION}

    public BusRoute(List<BusStation> primaryBusStationList, List<BusStation> secondaryDirection) {
        this.primaryBusStationList = primaryBusStationList;
        this.reverseBusStationList = secondaryDirection;
    }

    public Timetable getTimetable(String busStationName, String busStationDestinationName) {
        String timetableURL = BusRouteManager.getSourceUrlForTimetables();
        timetableURL = timetableURL.replace("linie", "przystanki");

        if (isPrimaryDirection(busStationName, busStationDestinationName)) {
            timetableURL += getTimetableFilename(busStationName, primaryBusStationList);
            return new Timetable(timetableURL);
        }
        timetableURL += getTimetableFilename(busStationName, reverseBusStationList);
        return new Timetable(timetableURL);
    }

    private String getTimetableFilename(String busStationName, List<BusStation> busStationsList) {

        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean isPrimaryDirection(String busStationName, String busStationDestName) {
        int indexOfStartBusStation = indexOfBusStation(busStationName, primaryBusStationList);
        int indexOfDestinationBusStation = indexOfBusStation(busStationDestName, primaryBusStationList);
        return (indexOfStartBusStation < indexOfDestinationBusStation);
    }

    private int indexOfBusStation(String busStationName, List<BusStation> busStationList) {
        int index = 0;

        for (BusStation busStation : busStationList) {
            if (busStation.getName().equals(busStationName))
                return index;
            index++;
        }
        assert false;
        return -1;
    }

    public void setReverseBusStationList(List<BusStation> reverseBusStationList) {
        this.reverseBusStationList = reverseBusStationList;
    }

    public void setPrimaryBusStationList(List<BusStation> primaryBusStationList) {
        this.primaryBusStationList = primaryBusStationList;

    }
}
