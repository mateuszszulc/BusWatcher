package pl.mszulc.BusWatcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 06.01.12
 * Time: 10:15
 */
public class BusRouteManager {
    final private static String sourceUrlForTimetables = "http://www.um.wroc.pl/rozklady/linie/";
    private List<Integer> routeNumbers;
    private String destination;
    private String startPoint;

    public static String getSourceUrlForTimetables() {
        return sourceUrlForTimetables;
    }

    private HashMap<Integer, BusRoute> BusRouteCache = new HashMap<Integer, BusRoute>();
    //private RouteCache;

    public BusRouteManager() {
        this.routeNumbers = null;
    }

    public BusRouteManager(List<Integer> routeNumbers) {
        this.routeNumbers = routeNumbers;
    }

    public static BusRoute getBusRouteInformation(int lineNumber) {
        String timetableURL = sourceUrlForTimetables + lineNumber + ".html";

        Document doc = null;
        try {
            System.out.println("Debug");
            doc = Jsoup.connect(timetableURL).get();
            System.out.println("Debug");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Elements newsHeadlines = doc.select("#mp-itn b a");

        List<BusStation> primaryDirection = fetchPrimaryDirection(doc);
        List<BusStation> secondaryDirection = fetchSecondaryDirection(doc);

        return new BusRoute(primaryDirection, secondaryDirection);
    }

    public static List<BusStation> fetchPrimaryDirection(Document doc) {
        Elements linia = doc.getElementsByClass("linia");
        Element table = linia.first();
        Elements tbody = table.getElementsByTag("tbody");
        Elements trElements = tbody.first().getElementsByTag("tr");

        trElements.remove(0);
        trElements.remove(0);

        for (Element busStationTr : trElements) {
            Elements trChildrens = busStationTr.children();

            BusStation busStation = new BusStation();
            busStation.setRoute(trChildrens.get(0).text());
            busStation.setSourceUrl(trChildrens.get(1).getElementsByTag("a").first().attr("href"));
            busStation.setName(trChildrens.get(1).text());

            System.out.println("*******************************");
            System.out.print(trChildrens.get(1).getElementsByTag("a").first().attr("href") + "  ");
            System.out.println(trChildrens.get(1).text() + "  ");
        }

        return null;
    }

    public static List<BusStation> fetchSecondaryDirection(Document doc) {

        return null;
    }


    public boolean nextBusInLessThanOneMinute() {
        Calendar earliestBusTime = getNextBusTime();
        return false;
    }

    private Calendar getNextBusTime() {
        List<Calendar> earliestTimeForAllRoutes = getEarliestTimeForAllRoutes();
        return getEarliestBus(earliestTimeForAllRoutes);
    }

    private List<Calendar> getEarliestTimeForAllRoutes() {
        List<Calendar> nextBusTimes = new ArrayList<Calendar>();
        for (Integer routeNumber : routeNumbers) {
            Calendar earliestBusTime = getEarliestBusTime(routeNumber);
            if (earliestBusTime == null)
                nextBusTimes.add(earliestBusTime);
        }
        return nextBusTimes;
    }

    private Calendar getEarliestBusTime(Integer routeNumber) {
        //BACK HERE

        return Calendar.getInstance();  //To change body of created methods use File | Settings | File Templates.
    }

    private Calendar getEarliestBus(List<Calendar> nextBusTimes) {
        Calendar earliestBusTime = nextBusTimes.get(0);
        for (Calendar busTime : nextBusTimes) {
            if (earliestBusTime.compareTo(busTime) > 0)
                earliestBusTime = busTime;
        }
        return earliestBusTime;
    }

    public List<Calendar> getNextBuses(int busCount) {
        //TODO: HARDCODED VALUE!!!!
        List<Calendar> tmp = new ArrayList<Calendar>();
        tmp.add(getNextBusTime());
        return tmp;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
}
