import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DeckTest {
    @Test public void testShuffle() {
        ArrayList<Card> res = new ArrayList<>();
        for(suit s : suit.values()) {
            for (int i = 2; i <= 14; i++) {
                Card c = new Card(i, s);
                res.add(c);
            }
        }
        Deck deck = new Deck(res);
		ArrayList<Card> c1 = deck.getDeck();
		deck.shuffle();
		ArrayList<Card> c2 = deck.getDeck();
		boolean result = true;
		for(int i = 0; i < c1.size(); i++){
				Card card1 = c1.get(i);
				Card card2 = deck.dealOneCard();
				if(!card1.equals(card2)){
					result = false;
					break;
				}
		}
		assertFalse(result);
    }
}
