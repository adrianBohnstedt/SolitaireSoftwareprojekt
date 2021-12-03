package tud.ai2.solitaire.model.cards;

import tud.ai2.solitaire.exceptions.ResourceNotFoundException;

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

    public int cutPoint = -1;
    private List<AbstractCard> cards;
    private static final Random rand = new Random();

    //TODO task 2a)
    public Deck() {

    }

    //TODO task 2c)
    public void riffle(int iterations) {

    }

    //TODO task 2b)
    public static List<AbstractCard> riffleMerge(List<AbstractCard> left, List<AbstractCard> right) {
        return null;
    }

    public List<AbstractCard> getCards() {
        return cards;
    }

    //TODO task 6
    public void loadCardImages(String path) {

    }
}
