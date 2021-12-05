package tud.ai2.solitaire.model.cards;

import java.awt.image.BufferedImage;

import tud.ai2.solitaire.exceptions.ResourceNotFoundException;

public class Card extends AbstractCard{
	
	private Suit suit; 
	private CardValue cardValue; 
	private boolean direction; 
	private BufferedImage image;
	
	public Card (Suit suit, CardValue cardValue) {
		
		this.suit = suit; 
		this.cardValue = cardValue; 
	}
	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return suit;
	}
	@Override
	public CardValue getValue() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		direction = revealed; 
	}
	@Override
	public void setFrontImage(String basePath) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BufferedImage getFrontImage() {
		// TODO Auto-generated method stub
		return image;
	} 
	@Override
	public boolean equals(Object o) {
		
		if (this.getSuit() = o.getSuit() && this.getValue() == o.getValue()) {
			return true;
		} else {
			return false; 
			
		}
		
	}

}
