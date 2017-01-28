package capriotti.anthony.CardTest;

/**
 * Created by anthonycapriotti on 1/27/17.
 */
import capriotti.anthony.Card;
import capriotti.anthony.Card.*;
import capriotti.anthony.Deck;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {

     Deck test;

     @Before
     public void setup(){
         test = new Deck();
     }


    @Test
    public void deckSizeTest(){
         int expected = 52;
         int actual = test.getDeckSize();
         assertEquals("testing the deck size", expected, actual);
    }

    @Test
    public void drawOnetest(){
        test.drawOne();
        int expected = 51;
        int actual = test.getDeckSize();
        assertEquals("Deck will decrease by one", expected, actual);
    }


}
