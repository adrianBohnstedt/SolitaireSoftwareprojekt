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
    private List<AbstractCard> cards = new ArrayList<AbstractCard>();
    private static final Random rand = new Random();
    
    /**
     * Constructs a card Deck
     */
    //TODO task 2a)
    public Deck() {
    	for (Suit s : Suit.values()) {
    		for (CardValue w : CardValue.values()) {
    			//System.out.println(s + "----" + w);
    			cards.add(new Card(s,w)); 
    		}
    	}
    
    }
    
    /**
     * Mixes the cards. For every iteration it devides the cards and then riffle merges them.
     * @param iterations
     */
    //TODO task 2c)
    public void riffle(int iterations) {
    	
    	for (int i = 0; i < iterations; i++) {
    		List<AbstractCard> l = new ArrayList<AbstractCard>(); 
    		List<AbstractCard> r = new ArrayList<AbstractCard>(); 
    	
    		cutPoint = (int) ((rand.nextDouble() * 11) + 21); //cutPoint the first card of the right list of cards
    	
    		l = cards.subList(0 , cutPoint - 1);
    		r = cards.subList(cutPoint , 51); 
    		cards = riffleMerge(l, r);
    	}
    }
    
    /**
     * Merges the left list with the right list to create the new merged list of abstract cards
     * @param left the left list
     * @param right the right list
     * @return the new merged list
     */
    //TODO task 2b)
    public static List<AbstractCard> riffleMerge(List<AbstractCard> left, List<AbstractCard> right) {
    	List<AbstractCard> l = left;
    	List<AbstractCard> r = right;
    	
    	List<AbstractCard> mergedList = new ArrayList<AbstractCard>(); //new Arraylist of merged cards
    	
    	while (!l.isEmpty() || !r.isEmpty()) {
    		
    		double chanceLeft = (l.size()/(l.size() + r.size())); //chance left
    		
    		if (rand.nextDouble() < chanceLeft) {
    			mergedList.add(l.get(l.size()-1));
    			l.remove(l.size()-1);
    		}
    		else {
    			mergedList.add(r.get(r.size()-1));
    			r.remove(r.size()-1);
    		}
    	}
    			
        return mergedList;
    }

    public List<AbstractCard> getCards() {
        return cards;
    }

    /**
     * loads the card front images found in a given path
     * @param path the path
     */
    //TODO task 6
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
