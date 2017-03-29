import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws AWTException {

        long startTime = System.currentTimeMillis();

        //Creates a robot object
        Robot robot = new Robot();
        //Takes in the amount of clicks the user would like to do
        Scanner input = new Scanner(System.in);
        System.out.print("How many times would you like to press the mouse? ");
        int clicks = input.nextInt();


        try {
            //Gives the user a 2 second delay before starting clicks
            Thread.sleep(2000);


            for (int i = 1; i <= clicks; i++) {
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.delay(90);
                if (i % 10 == 0) {
                    //Tells the user how many clicks have gone by so far can be easily changed from 10 to
                    //whatever number
                    System.out.println(i + " of clicks so far");
                }
                    //Checks to see if the user is okay with finishing the clicks they initially wanted.
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
            //Tells the user the amount of time it took for the Clicker to finish all the clicks
            long endTime = System.currentTimeMillis();
            long TotalTime = endTime - startTime;
            System.out.println(clicks + " clicks completed!");
            System.out.println("It took: " + TotalTime + " milliseconds");
        } catch (Exception e) {
            System.out.println("Caught an Error");
        }
    }
}
