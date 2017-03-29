import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws AWTException {

        long startTime = System.currentTimeMillis();


        Robot robot = new Robot();

        Scanner input = new Scanner(System.in);
        System.out.print("How many times would you like to press the mouse? ");
        int clicks = input.nextInt();


        try {
            Thread.sleep(2000);


            for (int i = 1; i <= clicks; i++) {
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.delay(90);
                if (i % 10 == 0) {
                    System.out.println(i + " of clicks so far");
                }

                if (i % 100 == 0) {
                    System.out.print("Would you like to continue? (1/0)");
                    Scanner input1 = new Scanner(System.in);
                    int playing = input1.nextInt();
                    if (playing == 1) {
                        Thread.sleep(2000);
                    } else {
                        break;
                    }

                }
            }

            long endTime = System.currentTimeMillis();
            long TotalTime = endTime - startTime;
            System.out.println(clicks + " clicks completed!");
            System.out.println("It took: " + TotalTime + " milliseconds");
        } catch (Exception e) {
            System.out.println("Caught an Error");
        }
    }
}
