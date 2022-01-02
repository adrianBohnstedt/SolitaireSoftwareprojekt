package tud.ai2.solitaire.model.cards;

import java.awt.Container;
import java.util.Collection;
/**
 * Implements the card pool with a draw stack and a waste stack
 * 
 * @author Adrian Bohnstedt
 * @version 1.0
 */
public class CardPool extends AbstractCardPool {

    /**
     * Initializes a tud.ai2.solitaire.model.cards.CardPool instance on its creation.
     * Initializes the parent class, adds the provided cards to the pool.
     *
     * @param cards     a list of cards that will be added to the draw pool
     * @param container a container to draw on
     */
    public CardPool(Collection<AbstractCard> cards, Container container) {
        super(cards, container);
        for (AbstractCard card : cards) {
            getDrawStack().push(card);
        }
        prepare();
    }
    /**
     * Gets activated when draw stack is clicked. If draw stack is not empty, the card gets moved to the waste stack
     */
	@Override
	public AbstractCard drawStackClicked() {
		if(!getDrawStack().isEmpty())
			getWasteStack().push(getDrawStack().pop());
		return null;
	}
	/**
	 * Moves all cards from the waste Stack back to the draw stack in the correct order
	 */
	@Override
	public void redeal() {
		while(!getWasteStack().isEmpty()) {
			getDrawStack().push(getWasteStack().pop());
		}
	}
	/**
	 * Removes the first card on the waste stack, if the first card on the waste Stack equals the card parameter and the card parameter is not null.
	 * 
	 * @param card the comparison card
	 */
	@Override
	public void removeFromWaste(AbstractCard card) {
		if(card != null && card.equals(getWasteStack().peek()))
			getWasteStack().pop();
		
	}


}

