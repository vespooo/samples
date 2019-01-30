package samples.carddeck;

import java.util.*;

class Card{

    private Rank rank;
    private Suit suit;

    public Card(String rank, String suit) throws Exception{
        setRank(rank);
        setSuit(suit);
    }

    public void setRank(String rankStr) throws Exception{
        this.rank = Rank.searchForRank(rankStr);
        if (this.rank == null){
            throw new Exception("rank is incorect. You must use rank from this range: " + Rank.values().toString());
        }
    }

    public Rank getRank(){
        return this.rank;
    }

    public void setSuit(String suitStr) throws Exception{
        try{
            this.suit = Suit.valueOf(suitStr.toUpperCase());
        }
        catch(Exception e){
            throw new Exception("suit is incorect. You must use suit from this range: " + Suit.values().toString());
        }
    }

    public Suit getSuit(){
        return this.suit;
    }


    public String toString(){
        return "(" + this.rank + "," + this.suit + ")";
    }


    enum Rank{
        ONE("1",1), VALET("valet", 1);

        String caption;
        int value;

        Rank(String caption, int value){
            this.caption = caption;
            this.value = value;
        }

        static Rank searchForRank(String rankStr){
            for(Rank rank : Rank.values()){
                if(rank.caption.equals(rankStr)){
                    return rank;
                }
            }
            return null;
        }

        @Override
        public String toString(){
            return this.caption;
        }
    }

    enum Suit{
        HART;
    }
}

class Deck{

    private List<Card> deck;

    public Deck(){
        this.deck = new ArrayList();
    }

    public void addCard(Card card){
        this.deck.add(card);
    }

    public List<Card> getDeck(){
        return deck;
    }

}

class Main{

    public static void main(String[] args){
        try{
            Card card = new Card("1", "hart");
            System.out.println("card: " + card + " is created");
            Deck deck = new Deck();
            deck.addCard(card);
            method("");
            System.out.println("Deck is created: " + deck.getDeck());
        }
        catch(Exception e){
            System.out.println("Card was not created: " + e.getMessage());
        }

    }

    protected int main(){return 0;}
    void method(){}
    public static int method(String s){return 0;}
}