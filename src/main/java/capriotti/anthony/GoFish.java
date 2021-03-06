package capriotti.anthony;


/**
 * Created by anthonycapriotti on 1/28/17.
 */
public class GoFish extends CardGame {
    CheckForPairs checkForPairs = new CheckForPairs();
     public int playerBookCount, dealerBookCount;


    public GoFish(){
        super();
        setHands();
    }

    @Override
    public void setHands(){
        for(int i = 0; i < 7; i++){
            playerDrawsOne();
            dealerDrawsOne();
        }
    }

    public boolean playerAskForRank(Card.Rank requestedRank){
        for(int i = 0; i < dealerHand.size(); i++){
            if(dealerHand.get(i).getRank() == requestedRank) {
                dealerHand.remove(i);
                return true;
            } else {
                playerDrawsOne();
                return false;

            }
        }
        return false;
    }

    public void dealerAskForRank(Card.Rank requestedRank){
        for(int i = 0; i < playerHand.size(); i++){
            if(playerHand.get(i).getRank() == requestedRank){
                playerHand.remove(i);
            } else {
                dealerDrawsOne();
            }
        }
    }

    public void checkForPairs(){
        checkForPairs.setRankCount(playerHand);
    }

    public void removeBooks(){

        while (checkForPairs.getBook() != null){
            System.out.println("You have a book of " + checkForPairs.getBook());
            playerBookCount++;

            for(int i =0; i < getPlayerHandCount(); i++){
                if(playerHand.get(i).getRank().equals(checkForPairs.getBook())){
                    playerHand.remove(i);
                }
            }
        }
    }






}
