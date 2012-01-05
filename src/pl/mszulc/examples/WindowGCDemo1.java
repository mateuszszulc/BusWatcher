package pl.mszulc.examples; /**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 04.01.12
 * Time: 22:06
 */

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WindowGCDemo1 {
    private javax.swing.Timer timer = null;
    private int count = 0;
    private JFrame myFrame = new JFrame();

    public WindowGCDemo1() {
        myFrame = new JFrame();
        myFrame.setLocation(150, 150);
        myFrame.setSize(200, 400);
        myFrame.setVisible(false);
        myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        System.out.println(myFrame.getExtendedState());
        start();
    }

    private void start() {
        timer = new javax.swing.Timer(1000, updateCol());
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("Set Delay") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                myFrame.setExtendedState(JFrame.ICONIFIED);
                System.out.println(myFrame.getExtendedState());
                count++;
                startAgain();
            }
        };
    }

    private void startAgain() {
        timer = new javax.swing.Timer(1000, updateColAgain());
        timer.start();
    }

    public Action updateColAgain() {
        return new AbstractAction("Set Delay") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                myFrame.setExtendedState(JFrame.NORMAL);
                System.out.println(myFrame.getExtendedState());
                count++;
                if (count > 5) {
                    timer.stop();
                    stop();
                }
                start();
            }
        };
    }

    private void stop() {
        System.out.println("--------------------------------------------");
        System.out.println("System Exit");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindowGCDemo1 windowGCDemo = new WindowGCDemo1();
            }
        });
    }
}
