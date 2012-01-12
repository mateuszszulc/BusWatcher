package pl.mszulc.BusWatcher;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 04.01.12
 * Time: 21:11
 */

public class BusWatcherMainApp {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    private static void createAndShowGui() {
        BusWatcherMainWindow mainWindow = new BusWatcherMainWindow();
    }
}
