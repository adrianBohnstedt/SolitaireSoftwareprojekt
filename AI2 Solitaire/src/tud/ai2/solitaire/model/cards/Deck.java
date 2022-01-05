package tud.ai2.solitaire.model.cards;

import tud.ai2.solitaire.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static tud.ai2.solitaire.util.Const.CARD_COUNT;

/**
 * Class tud.ai2.solitaire.model.cards.Deck
 * describes a deck object created for the game.
 * An object contains a list of cards, 13x4=52 elements.
 * Those 52 elements represent every possible card value from ace to king exists four times but
 * same values differ by their chosen suit.
 * Therefore no duplicates get created.
 * Decks can shuffle themselves
 *
 * @author (Felix Gail, Philipp Malkmus, Artjom Poljakow)
 * @version 1.0
 */

public class Deck {

    public int cutPoint ;
    private List<AbstractCard> cards;
    private static final Random rand = new Random();

    //TODO task 2a)
    /**
     * 
     */
    public Deck() {

    	for (Suit s : Suit.values()) {
    		for (CardValue w : CardValue.values()) {
    			cards.add(new Card(s,w)); 
    		}
    	}
    
    }
    
    //TODO task 2c)
    public void riffle(int iterations) {
    	
    	for (int i = 0; i < iterations; i++) {
    	List<AbstractCard> l = new ArrayList<AbstractCard>(); 
    	List<AbstractCard> r = new ArrayList<AbstractCard>(); 
    	
    	cutPoint = (int) ((Math.random() * 11) + 22); //cutPoint ist die erste Karte des rechten Stapels
    	
    	l = cards.subList(0 , cutPoint - 1 );
    	r = cards.subList(cutPoint , 52); 
    	
    	riffleMerge(l, r);
    	
    	//cards = n; 
    	}
    }

    //TODO task 2b)
    public static List<AbstractCard> riffleMerge(List<AbstractCard> left, List<AbstractCard> right) {
    	List<AbstractCard> l = left;
    	List<AbstractCard> r = right;
    	
    	List<AbstractCard> n = new ArrayList<AbstractCard>(52);
    	
    	for (int i = 0; i < n.size() ; i++) {
    		
    		Random mn = new Random();
    		double z = mn.nextDouble();
    		double cl = (l.size()/(l.size() + r.size()));
    		
    		if (z <= cl) {
    			n.add(l.get(0));
    			l.remove(0);
    		}
    		else {
    			n.add(r.get(0));
    			r.remove(0);
    		}
    	}
    	
        return n;
    }

    public List<AbstractCard> getCards() {
        return cards;
    }

    //TODO task 6
    /**
     * loads the card front images
     * 
     * @param path
     */
    public void loadCardImages(String path) {
    	for(AbstractCard card: cards) {
    		try {
				card.setFrontImage(path);
			} catch (ResourceNotFoundException e) {
				System.out.println("loading card image failed");
				e.printStackTrace();
			}
    	}
    }
}
