package pl.mszulc.BusWatcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 06.01.12
 * Time: 10:15
 */
public class MPKTimetable {
    final static String sourceUrlForTimetables = "http://www.um.wroc.pl/rozklady/linie/";

    public static BusRoute getBusTimetable(int lineNumber) {
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
        System.out.println(linia.size());
        //System.out.println(linia.first());
        Element table = linia.first();
        //System.out.println(table.getElementsByTag("tbody"));
        Elements tbody = table.getElementsByTag("tbody");
        Elements trElements = tbody.first().getElementsByTag("tr");

        trElements.remove(0);
        trElements.remove(0);

        for (Element busStationTr : trElements) {
            Elements trChildrens = busStationTr.children();
            System.out.println("*******************************");
            System.out.print(trChildrens.get(0).text() + "  ");
            System.out.print(trChildrens.get(1).getElementsByTag("a").first().attr("href") + "  ");
            System.out.println(trChildrens.get(1).text() + "  ");
        }
        //System.out.println(trElements.first());
        //Element tr = trElements.get(2);

        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<BusStation> fetchSecondaryDirection(Document doc) {

        return null;
    }


}
