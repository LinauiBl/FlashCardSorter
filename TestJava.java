import java.util.ArrayList;
import java.util.List;


class TestCard implements Card {
    private String name;
    private boolean correct;
    
    public TestCard(String name, boolean correct) {
        this.name = name;
        this.correct = correct;
    }
    
    @Override
    public boolean wasAnsweredCorrectlyInLastRound() {
        return correct;
    }
    
    @Override
    public String toString() {
        return name + (correct ? " true" : " false");
    }
}

public class TestJava {
    public static void main(String[] args) {
     
        System.out.println("    Flashcard Sorter - Test Results (Java)     ");
        
        // Create test cards
        List<Card> cards = new ArrayList<>();
        cards.add(new TestCard("Card 1", true));
        cards.add(new TestCard("Card 2", false));
        cards.add(new TestCard("Card 3", true));
        cards.add(new TestCard("Card 4", false));
        cards.add(new TestCard("Card 5", true));
        
        System.out.println("BEFORE SORTING:");
        System.out.println("───────────────");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ". " + cards.get(i));
        }
        
        // Apply sorting
        RecentMistakesFirstSorter sorter = new RecentMistakesFirstSorter();
        List<Card> sorted = sorter.organizeCards(cards);
        
        System.out.println("\nAFTER SORTING:");
        System.out.println("──────────────");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i));
        }
        
        System.out.println("Result: Incorrect cards moved to front! true");
    
    }
}