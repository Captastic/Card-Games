package capriotti.anthony.CardTest;

/**
 * Created by anthonycapriotti on 1/28/17.
 */
import capriotti.anthony.Card;
import capriotti.anthony.CardGame;
import capriotti.anthony.CheckForPairs;
import capriotti.anthony.GoFish;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishTest {
    GoFish test;
    CheckForPairs check;
    ArrayList<Card> cards;

    @Before
    public void setup(){
        test = new GoFish();
    }

    @Test
    public void playerDrawsOneTest(){
        test.playerDrawsOne();
        int expected = 1;
        int actual = test.playerHand.size();
        assertEquals("Players hand increases by one", expected, actual);
    }

    @Test
    public void dealerDrawsOneTest(){
        test.dealerDrawsOne();
        int expected = 1;
        int actual = test.dealerHand.size();
        assertEquals("Dealers hand increases by one", expected, actual);
    }

  @Test
    public void  getPlayerHandCountTest(){
        int expected =7;
        int actual = test.getPlayerHandCount();
        assertEquals("Players hand will equal 7", expected, actual);
    }

    @Test
    public void getDealerHandCountTest(){
        int expected = 7;
        int actual = test.getDealerHandCount();
        assertEquals("Dealers hand will equal 7", expected, actual);
    }

    @Test
    public void playerAsksForRankTest(){
        test.setHands();
        test.dealerHand.clear();
        test.dealerHand.add(new Card(0,0));
        test.playerAskForRank(Card.Rank.ACE);
        int expected = 0;
        int actual = test.dealerHand.size();
        assertEquals("Card is removed from hand", expected, actual);
    }

    @Test
    public void dealerAsksForRankTest(){
        test.setHands();
        test.playerHand.clear();
        test.playerHand.add(new Card(0,0));
        test.dealerAskForRank(Card.Rank.ACE);
        int expected = 0;
        int actual = test.playerHand.size();
        assertEquals("Card is removed from players hand", expected, actual);
    }
}
