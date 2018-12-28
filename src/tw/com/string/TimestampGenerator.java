package tw.com.string;

import java.util.Random;

/**
 * <p>
 * A tiny program for timestamp generation.
 * </p>
 * <p>
 * <li><code>varMin</code> = variation in minutes.</li>
 * <li><code>workingHR</code> = longest working hours.</li>
 * <li><code>startHR</code> = start working time by hour.</li>
 * <li><code>startMIN</code> = start working time by minutes.</li>
 * </p>
 *
 * @author Jonathan
 */
public class TimestampGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int day_num = 31;
        TimestampGenerator t_gen = new TimestampGenerator();
        for (int i = 0; i < day_num; i++) {
            System.out.printf("%2d.", i + 1);
            t_gen.rolling();
            System.out.printf("%2d:%02d, ", t_gen.start.hour, t_gen.start.minuet);
            System.out.printf("%2d:%02d", t_gen.end.hour, t_gen.end.minuet);
            System.out.println("");
        }

    }
    static int varMIN = 30;
    static int workingHR = 9;

    static int startHR = 9;
    static int startMIN = 30;

    Timestamp start;
    Timestamp end;

    static Random R = new Random();

    void rolling() {
        int m = R.nextInt(varMIN);
        start = new Timestamp(startHR, startMIN + m);
        while (start.minuet >= 60) {
            start.hour++;
            start.minuet -= 60;
        }

        m = R.nextInt(varMIN);
        end = new Timestamp(start.hour + workingHR, start.minuet + m);
        while (end.minuet >= 60) {
            end.hour++;
            end.minuet -= 60;
        }
    }

}
