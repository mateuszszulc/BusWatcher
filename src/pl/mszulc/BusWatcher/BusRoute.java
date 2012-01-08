package pl.mszulc.BusWatcher;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 06.01.12
 * Time: 10:19
 */
public class BusRoute {
    List<BusStation> busStationList;
    List<BusStation> reverseBusStationList;

    enum BusDirection {PRIMARY_DIRECTION, SECONDARY_DIRECTION}

    public BusRoute(List<BusStation> busStationList, List<BusStation> secondaryDirection) {
        this.busStationList = busStationList;
        this.reverseBusStationList = secondaryDirection;
    }

    public void getTimetable(String busStationName, String busStationDestinationName) {
        if (isPrimaryDirection(busStationName, busStationDestinationName)) {

        }


    }

    private boolean isPrimaryDirection(String busStationName, String busStationDestName) {
        int indexOfStartBusStation = indexOfBusStation(busStationName, busStationList);
        int indexOfDestinationBusStation = indexOfBusStation(busStationDestName, busStationList);
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

    public void setBusStationList(List<BusStation> busStationList) {
        this.busStationList = busStationList;

    }
}
