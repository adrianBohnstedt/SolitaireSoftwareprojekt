package tud.ai2.solitaire.model.cards;

/**
 * Implements a card stack
 * 
 * @author Maximilian Mitschke, Adrian Bohnstedt
 * @version 1.0
 */
public class CardStack extends AbstractCardStack {

    private static int MAX_STACK = 13; //maximum size of a stack 
    private AbstractCard[] a = new AbstractCard [MAX_STACK]; //new Array with the type AbstractCard, with a size of 13 
    
   
/**
 * Pushes an abstract card onto the stack and does nothing if stack is already full
 * @param c the abstract card that gets pushed onto the stack
 */
    public void push(AbstractCard c) {
    	boolean pushed = false; //if the card got already pushed onto the stack
    	while(pushed == false) {
    		for(int i=0; i<MAX_STACK;i++) {
        		if(a[i] == null) {
        			a[i] = c;
        			pushed = true;
        		}
        	}
    	}
    }

    /**
     * Removes the card on the top of the stack and returns it. If stack is empty returns null
     * @return the top card
     */
    public AbstractCard pop() {
    	for(int i=MAX_STACK-1; i>=0; i--) {
    		if(a[i] != null) {
    			a[i] = null;
    			return a[i];
    		}
    	}
    	return null; //if the stack is empty
    }
    
    /**
     * Returns the top card without removing it
     * @return the top card
     */
    public AbstractCard peek() {
    	for(int i=MAX_STACK-1; i>=0; i--) {
    		if(a[i] != null) {
    			return a[i];
    		}
    	}
    	return null; //if the stack is empty the top card is null
    } 
    
    /**
     * Returns the number of cards on the stack
     * @return number of cards
     */
    public int size() {
    	int num = 0;
    	for(AbstractCard card:a) {
    		if(card != null) {
    			num++;
    		}
    	}
    	return num;
    }
    
    /**
     * Returns if the stack is full
     * @return true if full, otherwise false
     */
    public boolean isFull() {
    	return size() == MAX_STACK;
    }
    
    /**
     * Returns if the stack is empty
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
    	return size() == 0;
    }
    
}
