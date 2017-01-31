package capriotti.anthony.CardTest;

/**
 * Created by anthonycapriotti on 1/30/17.
 */
import capriotti.anthony.Blackjack;
import capriotti.anthony.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlackjackTest {
    Blackjack black;

    @Before
    public void setUp(){
        black = new Blackjack();
    }

    @Test
    //test for initial hand set up, tested correct value and negative value
    public void setHandsTest(){
        int expected = 2;
        int actual = black.getDealerHandCount();
        assertEquals("test for initial hand set up", expected, actual);
    }

    @Test
    //Testing maximum bet
    public void getMaxBetTest(){
        double expected = 100;
        double actual = black.getMAX_bet();
        assertEquals("Testing max bet", expected, actual,0);
    }

    @Test
    //testing minimum bet
    public void getMinBetTest(){
        double expected = 5;
        double actual = black.getMIN_bet();
        assertEquals("Testing min bet", expected, actual, 0);
    }

    @Test
    //test for setting of bet
    public void setBetTest(){
        double expected = 100;
        black.setBet(expected);
        double actual = black.getBet();
        assertEquals("Bet is set", expected, actual, 0);
    }

    @Test
    //Testing winning hand bet
    public void winTest(){
        double expected = 200;
        black.setBet(100);
        black.win();
        double actual = black.getPlayersCash();
        assertEquals("testing winning bet", expected, actual, 0);
    }

    @Test
    //Testing losing bet
    public void loseTest(){
        double expected = -100;
        black.setBet(100);
        black.lose();
        double actual = black.getPlayersCash();
        assertEquals("testing losing bet", expected, actual, 0);
    }

    @Test
    //testing blackjack winning total
    public void blackjackTest(){
        double expected = 150;
        black.setBet(100);
        black.blackjack();
        double actual = black.getPlayersCash();
        assertEquals("testing player win with blackjack", expected, actual, 0);
    }

    @Test
    //testing a "push"
    public void pushTest(){
        double expected = 100;
        black.setBet(100);
        black.push();
        double actual = black.getPlayersCash();
        assertEquals("testing push player dealer tie", expected, actual, 0);
    }

    @Test
    //testing a "surrender"
    public void surrenderTest(){
        double expected = 50;
        black.setBet(100);
        black.surrender();
        double actual = black.getPlayersCash();
        assertEquals("Testing surrender logic for player surrender", expected, actual, 0);
    }

    @Test
    //testing black jack ace value of 11
    public void blackJackAceTest(){
        Card card = new Card(0, 13);
        black.setBlackJackAce(card);
        double expected = 11;
        double actual = card.getRank().getValue();
        assertEquals("testing 11 value ace", expected, actual, 0);
    }

    @Test
    //testing dealers cards rank total
    public void setDealerPointsTest(){
        Card card = new Card(0,9);
        Card card1 = new Card(0, 10);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);
        hand.add(card1);
        black.setDealersPoints(hand);
        double expected = 20;
        double actual = black.getDealersPoints();
        assertEquals("Testing dealer rank totals", expected, actual,0);
    }

    @Test
    //testing players hand rank totals
    public void setPlayersPointsTotal(){
        Card card = new Card(2, 2);
        Card card1 = new Card(2,3);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);
        hand.add(card1);
        black.setPlayersHandPoints(hand);
        double expected = 7;
        double actual = black.getPlayersPoints();
        assertEquals("Testing player rank totals", expected, actual,0);
    }











}
