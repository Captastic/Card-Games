package capriotti.anthony;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * Created by anthonycapriotti on 2/5/17.
 */
public class BJGameLogic {

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Blackjack blackjack = new Blackjack();
        String choice;
        boolean valid = true, valid1 = false;

        System.out.println("Please place your bets!!");
        blackjack.setBet(scan.nextDouble());

        while (blackjack.getBet() > blackjack.getMAX_bet()){
            System.out.println("The table's max bet is " + blackjack.getMAX_bet() + " , please lower your bet and place again");
            blackjack.setBet(scan.nextDouble());
        }

        while (blackjack.getBet() < blackjack.getMIN_bet()){
            System.out.println("The table minimun is " + blackjack.getMIN_bet() + " , please increase your bet");
            blackjack.setBet(scan.nextDouble());
        }

        System.out.println("You've been dealt a " + blackjack.playerHand.get(0).getRank() + " and a " + blackjack.playerHand.get(1).getRank());

        System.out.println("The dealer is showing a " + blackjack.dealerHand.get(0).getRank() + " and a " + blackjack.dealerHand.get(1).getRank());
        System.out.println("What will your choice be? Hit? Stay? Split?");
        scan.nextLine();
        choice = scan.nextLine();
        blackjack.choice(choice);

        if (choice.equalsIgnoreCase("split") &&
            blackjack.playerHand.get(0).getRank().getValue() == blackjack.playerHand.get(1).getRank().getValue()) {

            System.out.println("Hand one: " + blackjack.splitHand.get(0).getRank() + "" + blackjack.splitHand.get(1).getRank());
            System.out.println("Hand two: " + blackjack.splitHand.get(0).getRank() + "" + blackjack.splitHand.get(1).getRank());

            blackjack.setPlayersHandPoints(blackjack.splitHand);
            while (blackjack.getPlayersPoints() < blackjack.getTWENTY_ONE() && valid){

                System.out.println("Would you like to hit or stay on the first hand?");
                choice = scan.nextLine();


                if (choice.equalsIgnoreCase("hit")){
                    blackjack.splitHandHit();
                    System.out.println("You drew a  " + blackjack.splitHand.get(blackjack.splitHand.size()-1).getRank());
                }

                blackjack.setPlayersHandPoints(blackjack.splitHand);

                System.out.println("Points " + blackjack.getPlayersPoints());
                for(int i = 0; i < blackjack.splitHand.size(); i++)
                    System.out.println(blackjack.splitHand.get(i).getRank());


                for (int i = 0; i < blackjack.splitHand.size(); i++) {
                    if (blackjack.splitHand.get(i).getRank().equals(Card.Rank.ACE)) {
                        if (blackjack.getPlayersPoints() + 10 < blackjack.getTWENTY_ONE()) {
                            System.out.println("Would you like your ace to have a value of 1 or 11");
                            int aceValue = scan.nextInt();
                            if (aceValue == 11) {
                                Card ace11 = new Card(0, 13);
                                blackjack.splitHand.set(i, ace11);
                            }
                        }
                    } else if (blackjack.getPlayersPoints() > blackjack.getTWENTY_ONE()) {
                        if (blackjack.getPlayersPoints() - 10 < blackjack.getTWENTY_ONE()) {
                            Card ace = new Card(0, 0);
                            break; blackjack.splitHand.set(i, ace);
                        }
                    }
                }

                if (blackjack.getPlayersPoints() > blackjack.getTWENTY_ONE()) {
                    System.out.println("You bust!");
                    blackjack.lose(blackjack.getBet());
                    valid = false;
                }
                else if (choice.equalsIgnoreCase("stay")) {
                    valid = false;
                } else
                    valid = true;

            }

            blackjack.setPlayersHandPoints(blackjack.splitHand2);
            while (blackjack.getPlayersPoints2() < blackjack.getTWENTY_ONE() && valid1) {


                System.out.println("Would you like to hit or stay on the second hand?");
                choice = scan.nextLine();

                if (choice.equalsIgnoreCase("hit")) {
                    blackjack.splitHand2Hit();
                    System.out.println("You drew a " + blackjack.splitHand2.get(blackjack.splitHand2.size()-1).getRank());
                }
                blackjack.setPlayersPoints2(blackjack.splitHand2);

                System.out.println("Points " + blackjack.getPlayersPoints());
                for(int i = 0; i < blackjack.splitHand2.size(); i++)
                    System.out.println(blackjack.splitHand2.get(i).getRank());

                for (int i = 0; i < blackjack.splitHand2.size(); i++) {
                    if (blackjack.splitHand2.get(i).getRank() == Card.Rank.ACE) {
                        if (blackjack.getPlayersPoints2() + 10 < blackjack.getTWENTY_ONE()) {
                            System.out.println("Would you like your ace to have a value of 1 or 11");
                            int aceValue = scan.nextInt();
                            if (aceValue == 11) {
                                Card ace11 = new Card(0, 13);
                                blackjack.splitHand2.set(i, ace11);
                            }
                        }
                    } else if (blackjack.getPlayersPoints2() > blackjack.getTWENTY_ONE()) {
                        if (blackjack.getPlayersPoints2() - 10 < blackjack.getTWENTY_ONE()) {
                            Card ace = new Card(0, 0);
                            blackjack.splitHand2.set(i, ace);
                        }
                    }
                }

                if (blackjack.getPlayersPoints2() > blackjack.getTWENTY_ONE()) {
                    System.out.println("You bust!");
                    blackjack.lose(blackjack.getBet());
                    valid1 = false;
                } else if (choice.equalsIgnoreCase("stay")) {
                    valid1 = false;
                } else
                    valid1 = true;

            }
        }
    }
}
