import { newRecentMistakesFirstSorter } from './newRecentMistakesFirstSorter';

class TestCard {
    constructor(
        private name: string,
        private correct: boolean
    ) {}
    
    wasAnsweredCorrectlyInLastRound(): boolean {
        return this.correct;
    }
    
    toString(): string {
    return `${this.name} (${this.correct ? 'True' : 'False'})`;
  }
}


console.log("  Flashcard Sorter - Test Results (TypeScript) ");


// Create test cards
const cards = [
    new TestCard("Card 1", true),
    new TestCard("Card 2", false),
    new TestCard("Card 3", true),
    new TestCard("Card 4", false),
    new TestCard("Card 5", true)
];

console.log("BEFORE SORTING:");
console.log("───────────────");
cards.forEach((card, i) => console.log(`${i + 1}. ${card.toString()}`));

// Apply sorting
const sorter = newRecentMistakesFirstSorter();
const sorted = sorter.organizeCards(cards);

console.log("\nAFTER SORTING:");
console.log("──────────────");
sorted.forEach((card, i) => console.log(`${i + 1}. ${(card as TestCard).toString()}`));
