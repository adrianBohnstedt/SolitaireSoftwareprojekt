package tud.ai2.solitaire.model.cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import tud.ai2.solitaire.exceptions.ResourceNotFoundException;
/**
 * Describes a Card
 * @author Maximilian Mitschke, Adrian Bohnstedt
 * @version 1.0
 */
public class Card extends AbstractCard{
	
	private static final long serialVersionUID = 1L;
	private Suit suit; 
	private CardValue cardValue; 
	private boolean revealed; 
	private BufferedImage frontImage;
	
	/**
	 * Constructs a card
	 * @param suit The suit of a card
	 * @param cardValue The value of a card
	 */
	public Card (Suit suit, CardValue cardValue) {
		
		super();
		this.suit = suit; 
		this.cardValue = cardValue; 
		revealed = false;
		
	}
	
	/**
	 * Gets the Suit of the card like hearts, clubs, diamonds or spades
	 * @return the suit
	 */
	@Override
	public Suit getSuit() {
		
		return suit;
	}
	
	/**
	 * Gets the Value of a card
	 * @return the value
	 */
	@Override
	public CardValue getValue() {
		
		return cardValue;
	}
	
	/**
	 * Flips the card card. Changes the revealed value of a card in any case and then returns the revealed value.
	 * @return the value  of revealed after flipping the card
	 */
	@Override
	public boolean flip() {
		if (revealed == false) {
			revealed = true;
			return true;
		} else {
			revealed = false;
			return false;
		}
	}	
	
	/**
	 * Checks if the card is revealed
	 * @return true if the card is revealed
	 */
	@Override
	public boolean isRevealed() {
		return revealed;
	}
	
	/**
	 * Sets the value revealed of a card
	 * @param revealed the new revealed value
	 */
	@Override
	public void setRevealed(boolean revealed) {
		
		this.revealed = revealed; 
	}
	
	/**
	 * Sets the front image to the image found in the base path file
	 * @param basePath the basePath of the file
	 */
	@Override
	public void setFrontImage(String basePath) throws ResourceNotFoundException {
		File basePathFile = new File(basePath , suit.string().toLowerCase() + "/" + cardValue.string().toLowerCase() + ".png");
		//Path path = Paths.get(basePath + "/" + suit + "/" + cardValue + ".png");
		//File basePathFile = path.toFile();
		//setting the front image
		try {
			frontImage = ImageIO.read(basePathFile);
		} catch (IOException e) {
			throw new ResourceNotFoundException(basePath);
		}
	
	}
	
	/**
	 * Gets the front Image of a card
	 * @returns the BufferedImage front Image of a card
	 */
	@Override
	public BufferedImage getFrontImage() {
		
		return frontImage;
	}
	
	/**
	 * Compares the card with another object
	 * @param o the other object
	 * @return if the value and suit are the same
	 */
	@Override
	public boolean equals(Object o) {
		
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true; 
		}
		if (!(o instanceof Card)) {
			return false; 
		}
		Card c = (Card) o; 
		
		return (this.suit == c.getSuit()) && (this.cardValue == c.getValue());
		
		
	}

}
