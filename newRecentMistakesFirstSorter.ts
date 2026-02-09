
interface Card {
    wasAnsweredCorrectlyInLastRound(): boolean;
}


interface CardOrganizer {
    organizeCards(cards: Card[]): Card[];
}

export const newRecentMistakesFirstSorter = (): CardOrganizer => {
    return {
       
        organizeCards(cards: Card[]): Card[] {
            // make arrays for incorrect and correct cards
            const incorrectCards: Card[] = [];
            const correctCards: Card[] = [];
            
            // categorize cards based on last answer
            for (const card of cards) {
                if (card.wasAnsweredCorrectlyInLastRound()) {
                    // Card was answered correctly - add to correct array
                    correctCards.push(card);
                } else {
                    // Card was answered incorrectly - add to incorrect array
                    incorrectCards.push(card);
                }
            }
            
            // Return array: incorrect cards first, then correct cards
            return [...incorrectCards, ...correctCards];
        }
    };
};

export default newRecentMistakesFirstSorter;