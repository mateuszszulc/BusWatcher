package pl.mszulc.BusWatcher;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;

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
        //mainFrame.setExtendedState(JFrame.ICONIFIED);
        //mainFrame.setExtendedState(mainFrame.getExtendedState() | JFrame.ICONIFIED);
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

        WindowStateListener stateListener = new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println(mainFrame.getExtendedState());
                mainFrame.setVisible(mainFrame.getExtendedState() == 0 ? true : false);
            }
        }                                                      ;
        mainFrame.addWindowStateListener(stateListener);

        
        mainFrame.setSize(200,100);
        mainFrame.setVisible(true);
    }

    public void show() {
        mainFrame.setVisible(true);
        mainFrame.setExtendedState(JFrame.NORMAL);

    }
}
