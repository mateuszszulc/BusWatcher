package pl.mszulc.BusWatcher;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 11.01.12
 * Time: 22:15
 */
public class ConfigurationFrame {
    private JDialog frame;
    private JTextField delay;


    public ConfigurationFrame() {
        frame = new JDialog();
        delay = new JTextField("dsdsdf");
        frame.add(delay);
        frame.setAlwaysOnTop(true);
        frame.setModal(true);
        frame.pack();
    }

    public String delegateTextField() {
        return delay.getText();
    }


    public void show() {
        frame.setVisible(true);

    }
}
