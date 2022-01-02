package tud.ai2.solitaire.model.cards;
//import java.util.A

/**
 * 
 * @author Maximilian Mitschke 
 * 
 *
 */
public class CardStack extends AbstractCardStack {

    private static int MAX_STACK = 13; //maximum size of a stack 
    private AbstractCard[] a = new AbstractCard [MAX_STACK]; //new Array with the type AbstractCard, with a size of 13 
    private int N = 0;
    
   
/**
 * {@inheritDoc}
 */
    public void push(AbstractCard cc) {
    	
    	if(a.length<13) {
    	    a[N]=cc;
    	    ++N;
        }
    }

    /**
     * {@inheritDoc}
     */
    public AbstractCard pop() {
    	if(!this.isEmpty()) { //oder direkt auf 0 testen?
    		AbstractCard c = a[a.length-1];
    		a[a.length-1] = null;
    		return c;
    	}
    	else {
    		return null;
    	}
    
    }

    public AbstractCard peek() {
    	if(a.length>0) { //""
    		return a[a.length-1];
    	}
    	else{
    		return null;
    	}
    }  
    
    public int size() {
    	return a.length;
    }
    
    public boolean isFull() {
    	return a.length == MAX_STACK;
    }
    
    public boolean isEmpty() {
    	return a.length == 0;
    }
    
}
