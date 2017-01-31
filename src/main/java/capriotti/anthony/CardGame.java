package capriotti.anthony;

import java.util.ArrayList;

/**
 * Created by anthonycapriotti on 1/28/17.
 */
public abstract class CardGame {
     protected Deck deck;
     public ArrayList<Card> playerHand;
     public ArrayList<Card> dealerHand;

     public CardGame(){
         playerHand = new ArrayList<>();
         dealerHand = new ArrayList<>();
         deck = new Deck();

     }

     public void playerDrawsOne(){
         playerHand.add(deck.drawOne());
     }

     public void dealerDrawsOne(){
         dealerHand.add(deck.drawOne());
     }

     protected abstract void setHands();

     public int getPlayerHandCount(){
         return playerHand.size();
     }

     public int getDealerHandCount(){
         return dealerHand.size();
     }





}
