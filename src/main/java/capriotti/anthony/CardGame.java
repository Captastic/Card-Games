package capriotti.anthony;

import java.util.ArrayList;

/**
 * Created by anthonycapriotti on 1/28/17.
 */
public abstract class CardGame {
     private Deck deck;
     public ArrayList<Card> playerHand = new ArrayList();
     public ArrayList<Card> dealerHand = new ArrayList();

     public CardGame(){
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
