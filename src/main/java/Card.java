enum suit{dimonds, hearts, spades, clubs};

public class Card {
    private int faceValue;// assume the value of Ace is 14, Jack is 11, Queen is 12 and King is 13
    private suit Suit;

    public Card(int v, suit s){
        faceValue = v;
        Suit = s;
    }

    public int getFaceValue(){
        return faceValue;
    }

    public suit getSuit(){
        return Suit;
    }
}
