/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.string;

import java.util.Random;

/**
 *
 * @author Jonathan
 */
public class TimeStampGenerator {

    static int varMIN = 30;
    static int workingHR = 9;

    static int startHR = 9;
    static int startMIN = 0;

    T start = new T();
    T end = new T();

    static Random R = new Random();

    void rolling() {
        int m = R.nextInt(varMIN);
        start.hour = startHR;
        start.minuet = startMIN + m;
        while (start.minuet >= 60) {
            start.hour++;
            start.minuet -= 60;
        }

        m = R.nextInt(varMIN);
        end.hour = start.hour + workingHR;
        end.minuet = start.minuet + m;
        while (end.minuet >= 60) {
            end.hour++;
            end.minuet -= 60;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = 28;
        TimeStampGenerator tsg = new TimeStampGenerator();
        for (int i = 0; i < number; i++) {
            System.out.printf("%2d.", i + 1);
            tsg.rolling();
            System.out.printf("%2d:%02d, ", tsg.start.hour, tsg.start.minuet);
            System.out.printf("%2d:%02d", tsg.end.hour, tsg.end.minuet);
            System.out.println("");
        }

    }
}

class T {

    int hour;
    int minuet;
}
