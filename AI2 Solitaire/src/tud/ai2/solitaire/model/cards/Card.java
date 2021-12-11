package tud.ai2.solitaire.model.cards;

import java.awt.image.BufferedImage;

import tud.ai2.solitaire.exceptions.ResourceNotFoundException;

public class Card extends AbstractCard{
	
	private Suit suit; 
	private CardValue cardValue; 
	private boolean direction; 
	private BufferedImage frontImage;
	
	/**
	 * 
	 * @param suit
	 * @param cardValue
	 */
	
public Card (Suit suit, CardValue cardValue) {
		
		super();
		this.suit = suit; 
		this.cardValue = cardValue; 
		direction = false;
		
	}
	
	
	@Override
	public Suit getSuit() {
		
		return suit;
	}
	@Override
	public CardValue getValue() {
		
		return cardValue;
	}
	@Override
	public boolean flip() {
		if (direction == false) {
			return true;
		} else {
		return false;
		}
	}	
	public boolean getDirection() {
		
		return direction;
	}
	@Override
	public boolean isRevealed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setRevealed(boolean revealed) {
		
		direction = revealed; 
	}
	@Override
	public void setFrontImage(String basePath) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BufferedImage getFrontImage() {
		
		return frontImage;
	} 
	@Override
	public boolean equals(Object o) {
		
		if (o == this) {
			return true; 
		}
		if (!(o instanceof Card)) {
			return false; 
		}
		Card c = (Card) o; 
		
		return (this.suit == c.getSuit()) && (this.cardValue == c.getValue());
		
		//if (this.getSuit() = o.getSuit() && this.getValue() == o.getValue()) {
		//	return true;
		//} else {
		//	return false; 
		//	
		
		
	}

}
