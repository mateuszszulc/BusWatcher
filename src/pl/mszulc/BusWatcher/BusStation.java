package pl.mszulc.BusWatcher;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 07.01.12
 * Time: 00:47
 */
public class BusStation {
    String name;
    String sourceUrl;

    public BusStation(String name, String sourceUrl) {
        this.name = name;
        this.sourceUrl = sourceUrl;
    }

    public String getName() {
        return name;
    }
}
