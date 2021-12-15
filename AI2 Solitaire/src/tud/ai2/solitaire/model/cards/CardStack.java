package tud.ai2.solitaire.model.cards;

public class CardStack extends AbstractCardStack {

    private static int MAX_STACK = 13;
    private AbstracdCard[] a;
    private int N=0;
    
    public ArrayStackOfCards (int b = 13) {
        a = new AbstractCard [b];
    }

    public void push(AbstractCard cc) {
    	
    	if(a.size<13) {
    	    a[N]=cc;
    	    ++N;
        }
    }

    public AbstractCard pop() {
    	if(a.size!=0) {
    		AbstractCard c = a[a.size-1];
    		this.a.remove(a.size-1);
    	}
    	return c
    
    }

    public AbstractCard peek() {
    	if(a.size>0) {
    		return a[a.size-1]
    	}
    	return null;
    }  
    
    public int size() {
    	return a.size;
    }
    
    public boolean isFull() {
    	return a.size == 13
    }
    
    public boolean isEmpty() {
    	return a.size == 0
    }
    
}
