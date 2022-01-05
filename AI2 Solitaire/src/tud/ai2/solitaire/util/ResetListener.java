package tud.ai2.solitaire.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tud.ai2.solitaire.Launch;
import tud.ai2.solitaire.view.PlayingField;
/**
 * Resets the game if needed
 * 
 * @author Adrian Bohnstedt
 */
public class ResetListener implements ActionListener{
	/**
	 * Resets the game if action event is performed
	 * 
	 * @param e ActionEvent to reset the game
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO resets the game
		Launch.activeField = new PlayingField("Solitaire");
	}

}
