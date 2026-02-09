import java.util.ArrayList;
import java.util.List;

public class RecentMistakesFirstSorter implements CardOrganizer {
    
  
    @Override
    public List<Card> organizeCards(List<Card> cards) {
        // Create lists to store cards
        List<Card> result = new ArrayList<>();
        List<Card> incorrectCards = new ArrayList<>();
        List<Card> correctCards = new ArrayList<>();
        
        // categorize cards based on last answer
        for (Card card : cards) {
            if (card.wasAnsweredCorrectlyInLastRound()) {
                // Card was answered correctly - add to correct list
                correctCards.add(card);
            } else {
                // Card was answered incorrectly - add to incorrect list
                incorrectCards.add(card);
            }
        }
        
        // Add incorrect cards first (they appear at the beginning)
        result.addAll(incorrectCards);
        
        // Then add correct cards (they appear after incorrect ones)
        result.addAll(correctCards);
        
        return result;
    }
}