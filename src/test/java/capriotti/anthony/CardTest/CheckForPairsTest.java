package capriotti.anthony.CardTest;

/**
 * Created by anthonycapriotti on 1/28/17.
 */
import capriotti.anthony.Card;
import capriotti.anthony.CheckForPairs;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CheckForPairsTest {
    Card card = new Card(0, 0);
    ArrayList<Card> deck = new ArrayList<>();
    CheckForPairs check;


    @Before
    public void setUp() {
        check = new CheckForPairs();
        for(int i = 0; i < 4; i++) {
            deck.add(card);
        }
    }

    @Test
    public void checkForPairsTest(){
        int expected = 4;
        check.setRankCount(deck);
        int actual = check.getAceCount();
        assertEquals("They be all Aces", expected, actual);

    }

    @Test
    public void getBookTest(){
        check.setRankCount(deck);
        Card.Rank expected = Card.Rank.ACE;
        Card.Rank actual = Card.Rank.ACE;
        assertEquals("Book o' Aces return", expected, actual);
    }

}
