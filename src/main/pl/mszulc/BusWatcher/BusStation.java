package pl.mszulc.BusWatcher;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 07.01.12
 * Time: 00:47
 */
public class BusStation {
    String route;
    String name;
    String sourceUrl;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public BusStation() {
    }

    public BusStation(String name, String sourceUrl) {
        this.name = name;
        this.sourceUrl = sourceUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
