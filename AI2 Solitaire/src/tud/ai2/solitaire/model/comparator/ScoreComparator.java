package tud.ai2.solitaire.model.comparator;

import java.util.Comparator;

import tud.ai2.solitaire.model.HighscoreEntry;
/**
 * Sorts high score entries by score
 * 
 * @author Adrian Bohnstedt
 * @version 1.0
 */
public class ScoreComparator implements Comparator<HighscoreEntry>{
	/**
	 * Sorts the higher score above lower score
	 * if they are the same sorts usernames
	 * 
	 * @param o1 first highscore entry
	 * @param o2 second highscore entry
	 */
	@Override
	public int compare(HighscoreEntry o1, HighscoreEntry o2) {
		//sort score by null	
		if(o1.getScore() == null)
			return 1;
		else if(o2.getScore() == null)
			return 1; //1
		//sort by score
		if(o1.getScore() > o2.getScore())
			return -1; //-1
		if(o1.getScore() < o2.getScore())
			return 1; //absteigend
		//sort name by null
		if(o1.getName() == null)
			return 1;
		else if(o2.getName() == null)
			return 1; //1
		//sort by name
		return o2.getName().compareToIgnoreCase(o1.getName());
	}

}
