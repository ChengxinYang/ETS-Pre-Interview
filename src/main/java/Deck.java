import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck(ArrayList<Card> cards){
        this.cards = cards;
        random = new Random();
    }

    public void shuffle(){
        if(cards == null){
            return;
        }
		// Shuffle the ArrayList and return its result. Any permutation of the ArrayList must equally likely to be returned.
        for(int j = 1; j < cards.size(); j++){
            int i = random.nextInt(j + 1);
            Card temp = cards.get(j);
            cards.set(j, cards.get(i));
            cards.set(i, temp);
        }
    }

    public Card dealOneCard(){
        if(cards.size() <= 0){
            return null;
        }
        Card c = cards.get(0);//get the card from top of the deck
        cards.remove(0);//remove card from the deck
        return c;
    }
	
	public ArrayList<Card> getDeck(){
		return cards;
	}

    public static void main(String args[]){
        ArrayList<Card> res = new ArrayList<>();
		//52 cards in a deck
        for(suit s : suit.values()) {
            for (int i = 2; i <= 14; i++) {
                Card c = new Card(i, s);
                res.add(c);
            }
        }
        Deck deck = new Deck(res);
        System.out.println("The deck before shuffle: ");
		
        for(int i = 0; i < deck.cards.size(); i++) {
            System.out.println("Suit is: " + deck.cards.get(i).getSuit());
            System.out.println("FaceValue is: " + deck.cards.get(i).getFaceValue());
        }	
        deck.shuffle();
        
		System.out.println("Number of cards remain in the deck: " + deck.cards.size());
        System.out.println("The deck after shuffle and 52 deals: ");
        
		for(int i = 0; i < 52; i++){
            Card c = deck.dealOneCard();
            System.out.println("Suit is: " + c.getSuit());
            System.out.println("Facevalue is: " + c.getFaceValue());
        }
        System.out.println("Number of cards remain in the deck: " + deck.cards.size());
    }
}