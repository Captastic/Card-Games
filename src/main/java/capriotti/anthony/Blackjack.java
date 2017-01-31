package capriotti.anthony;

import java.util.ArrayList;

/**
 * Created by anthonycapriotti on 1/30/17.
 */
public class Blackjack extends CardGame {
    private final double MAX_bet = 100.0d;
    private final double MIN_bet = 5.00d;
    private double playersPoints, dealersPoints, bet, playersCash;
    private final double blackjack = 21;

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





}
