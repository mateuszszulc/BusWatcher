package pl.mszulc.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 11.01.12
 * Time: 16:12
 */
public class CitizensCounter {
    final static String wikiURL = "http://en.wikipedia.org/wiki/List_of_cities_in_Germany_with_more_than_100,000_inhabitants";

    public static void main(String[] args) {
        File input = new File("Wiki.html");


        Document doc = null;
        while (doc == null) {
            try {
                doc = Jsoup.connect(wikiURL).timeout(10).get();
            } catch (IOException e) {
                System.out.println("I'm here");
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        Element html = doc.body();
        Elements div1 = html.select("div#bodyContent");
        Elements div2 = div1.select("div.mw-content-ltr");
        Elements tables = div2.select("table.sortable");
        Element table = tables.get(0);
        Elements tableRows = table.getElementsByTag("tr");

        tableRows.remove(0);
        System.out.println(tableRows.get(0));

        int sum = 0;
        for (Element tr : tableRows) {
            Elements tds = tr.getElementsByTag("td");
            //System.out.println(tds.get(4));
            Element elem = tds.get(4);
            String text = elem.text().replace(",", "").replace("*", "");
            //System.out.println(text);
            sum += Integer.parseInt(text);

        }
        System.out.println(sum);

    }
}

/*Elements elements = doc.getElementsByClass("wikitable");
Element el = elements.get(1);
Elements tbody = el.getElementsByTag("tbody");
Element tbody1 = tbody.get(0);
Elements trs = tbody1.getElementsByTag("tr");*/