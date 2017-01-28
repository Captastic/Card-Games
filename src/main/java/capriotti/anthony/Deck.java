package capriotti.anthony;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anthonycapriotti on 1/27/17.
 */
public class Deck {

    ArrayList<Card> deck;

    public Deck(){

        deck = new ArrayList<Card>();
        Card temp;
        int deckSize = 52;
        int index = 0;

        for(int suit = 0; suit < 4; suit++){
            for(int rank = 0; rank < 13; rank++){
                deck.add(new Card(suit, rank));
            }
        }

        while(deckSize > 0){
            index = (int)Math.floor(Math.random() * deckSize);

            temp = deck.get(index);
            deck.set(index, deck.get(deckSize - 1));
            deck.set(deckSize - 1,temp);

            deckSize--;
        }

    }

    public int getDeckSize(){
        return deck.size();
    }

    public Card drawOne(){
        Card cardName =deck.get(0);
        deck.remove(0);
        return cardName;

    }



}
