package pl.mszulc.BusWatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 04.01.12
 * Time: 21:22
 */
public class BusWatcherMainWindow {
    private JFrame mainFrame;

    public BusWatcherMainWindow() {
        setupMainFrame();
    }

    private void setupMainFrame() {
        mainFrame = new JFrame("BusWatcher");

        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainFrame.setExtendedState(JFrame.ICONIFIED);
        //mainFrame.setExtendedState(mainFrame.getExtendedState() | JFrame.ICONIFIED);

        setupWindowFocusListener();
        setupWindowStateListener();
        setupTrayIcon();

        mainFrame.setSize(200, 100);
        mainFrame.setVisible(true);

        startBusWatcher();
        System.out.println(Thread.currentThread());


        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread());
                toggleVisibility();
            }
        }, 3000, 7000);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());

                toggleVisibility();
            }
        });
        t.start();
    }

    private void startBusWatcher() {
        Calendar nextBusTime = fetchNextBus();
        int delay = 3000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println(Thread.currentThread());
                System.out.println("Jest tu!");
                toggleVisibility();
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private Calendar fetchNextBus() {
        //stub
        return Calendar.getInstance();
    }

    private void setupTrayIcon() {
        if (!SystemTray.isSupported()) return;

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("kadu.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

        MenuItem exitItem = new MenuItem("Exit");

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(Thread.currentThread());

                toggleVisibility();
            }
        });
    }

    public void toggleVisibility() {
        if (mainFrame.isVisible())
            hide();
        else
            show();
    }

    protected static Image createImage(String path, String description) {
        URL imageURL = BusWatcherMain.class.getResource(path);
        System.out.println(BusWatcherMain.class.getResource(path));

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }


    private void setupWindowStateListener() {
        WindowStateListener stateListener = new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println(mainFrame.getExtendedState());

                //Yes, I know, that if you read this line, you won't now at first sight, what it does.
                //Without thinking I don't know this either
                mainFrame.setVisible(mainFrame.getExtendedState() == 0);
            }
        };
        mainFrame.addWindowStateListener(stateListener);
    }

    private void setupWindowFocusListener() {
        WindowFocusListener listener = new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("Focus Gain!");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("Focus Lost!");
            }
        };
        mainFrame.addWindowFocusListener(listener);
    }

    public void show() {
        mainFrame.setVisible(true);
        mainFrame.setExtendedState(JFrame.NORMAL);
    }

    public void hide() {
        mainFrame.setVisible(false);
        mainFrame.setExtendedState(JFrame.ICONIFIED);
    }


}
