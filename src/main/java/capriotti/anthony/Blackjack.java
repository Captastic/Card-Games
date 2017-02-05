package capriotti.anthony;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anthonycapriotti on 1/30/17.
 */
public class Blackjack extends CardGame {
    Scanner scanner = new Scanner(System.in);
    private final double MAX_bet = 100.0d;
    private final double MIN_bet = 5.00d;
    private double playersPoints, playersPoints2, dealersPoints, bet, playersCash;
    private final double TWENTY_ONE = 21;
    ArrayList<Card> splitHand = new ArrayList<>();
    ArrayList<Card> splitHand2 = new ArrayList<>();

    public Blackjack(){
        super();
        setHands();
    }

    @Override
    public void setHands(){
        for(int i = 0; i < 2; i++){
            playerDrawsOne();
            dealerDrawsOne();
        }
    }

    @Override
    public void playerDrawsOne(){
        playerHand.add(deck.drawOne());
    }
    @Override
    public void dealerDrawsOne(){
        dealerHand.add(deck.drawOne());
    }

    public double getPlayersPoints() {
        return playersPoints;
    }

    public double getPlayersPoints2(){ return playersPoints2; }

    public double getDealersPoints() {
        return dealersPoints;
    }

    public double getPlayersCash() {
        return playersCash;
    }

    public double getMAX_bet() {
        return MAX_bet;
    }

    public double getMIN_bet() {
        return MIN_bet;
    }

    public double getBet() {
        return bet;
    }

    public double getTWENTY_ONE(){
        return TWENTY_ONE;
    }

    public ArrayList<Card> getSplitHand(){
        return splitHand;
    }

    public ArrayList<Card> getSplitHand2(){
        return splitHand2;
    }

    public void setBet(double amount){
        bet = amount;
    }

    public void win(){
        playersCash += (2 * bet);
    }

    public void lose(){
        playersCash -= bet;
    }

    public void blackjack(){
        playersCash += 1.5 * bet;
    }

    public void push(){
        playersCash += bet;
    }

    public void surrender(){
        playersCash += .5 * bet;
    }

    public void setAce(Card card){
        card.rank = Card.Rank.ACE;
    }

    public void setBlackJackAce(Card card){
        card.rank = Card.Rank.BLACK_JACK_ACE;
    }

    public void setDealersPoints(ArrayList<Card> hand){
        for (Card card : hand) {
            dealersPoints += card.getRank().getValue();
        }
    }

    public void setPlayersHandPoints(ArrayList<Card> hand){
        for (Card card : hand){
            playersPoints += card.getRank().getValue();
        }
    }

    public void setPlayersPoints2(ArrayList<Card> hand){
        playersPoints2 -= playersPoints2;
        for (Card card: hand){
            playersPoints2 += card.getRank().getValue();
        }
    }

    public void resetPlayersPoints(){
        playersPoints = 0;
    }

    public void split(boolean hand) {

        if (hand == true) {

            splitHand.add(playerHand.get(0));
            splitHand.add(super.playerDrawsOne(););
            splitHand2.add(playerHand.get(1));
            splitHand2.add(super.playerDrawsOne(););
        }

        else if (hand == false) {
            System.out.println("You cannot split ranks that are not the same, pick another " +
                    "choice");
            choice(scanner.nextLine());

        }
    }

    public void doubleDown(boolean win) {

        if (win == true) {

            playersPoints += 2 * bet;
        } else
            playersPoints -= 2 * bet;

    }

    public void splitHandHit(){

        splitHand.add((super.playerDrawsOne()));
    }

    public void splitHand2Hit(){

        splitHand2.add(super.playerDrawsOne());
    }

    public void choice(String choice) {

        if (choice.equalsIgnoreCase("surrender")) {

            surrender();
        }

        if (choice.equalsIgnoreCase("split")) {

            split(playerHand.get(0).getRank().getValue() == playerHand.get(1).getRank().getValue());

        }


    }
}








}
