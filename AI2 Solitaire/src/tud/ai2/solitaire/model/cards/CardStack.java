package tud.ai2.solitaire.model.cards;
//import java.util.A

public class CardStack extends AbstractCardStack {

    private static int MAX_STACK = 13;
    private AbstractCard[] a = new AbstractCard [MAX_STACK];
    private int N = 0;
    
   


    public void push(AbstractCard cc) {
    	
    	if(a.length<13) {
    	    a[N]=cc;
    	    ++N;
        }
    }

    public AbstractCard pop() {
    	if(a.length!=0) {
    		AbstractCard c = a[a.length-1];
    		this.remove(a.length-1);
    	}
    	return c;
    
    }

    public AbstractCard peek() {
    	if(a.length>0) {
    		return a[a.length-1];
    	}
    	return null;
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
