package capriotti.anthony;

import java.lang.reflect.Array;
import java.lang.reflect.Array.*;

/**
 * Created by anthonycapriotti on 1/27/17.
 */
public class Card {
    Suit suit;
    Rank rank;

    public enum Suit {SPADE, HEARTS, DIAMOND, CLUBS};
    public enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(10), QUEEN(10), KING(10), BLACK_JACK_ACE(11);

        int value;

        public int getValue() {
            return value;
        }

         Rank(int x) {
            this.value = x;
        }

        }


    public Card(int suit, int rank){
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }



}

