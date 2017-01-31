package capriotti.anthony;

import java.util.Scanner;

/**
 * Created by anthonycapriotti on 1/30/17.
 */
public class GameSelection {
    static Scanner scanner = new Scanner(System.in);
    static int selection;

    public static void gameSelection(){
        System.out.println("Come on come all to the polymorphin casino");
        System.out.println("What game are you looking to play?");
        System.out.println("Version 1.0 only has GoFish or BlackJack, pick one or the other");
        System.out.println("Input 1 for GoFish or 2 for BlackJack");
        selection = scanner.nextInt();
        gameSwitch();
    }

    public static void gameSwitch(){
        switch (selection){
            case 1:
                //runBlackJack();
                break;
            case 2:
                //runGoFish();
                break;
             default:
                 System.out.println("Pick again");
                 gameSelection();
                 break;
        }
    }
}
