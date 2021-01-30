package com.hust.cqb.BookTest.Test10Inner;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        int i = 0;
        i++;
        System.out.println(i);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
    static class TalkingClock {
        private int interval;
        private boolean beep;

        public TalkingClock(int interval, boolean beep) {
            this.interval = interval;
            this.beep = beep;
        }

        public void start() {
            ActionListener listener = new TimePrinter();
            Timer t = new Timer(interval, listener);
            t.start();
        }

        public class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                Date date = new Date();
                System.out.println("At the tone, the time is " + date);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
