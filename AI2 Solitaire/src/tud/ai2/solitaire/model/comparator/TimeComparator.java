package tud.ai2.solitaire.model.comparator;

import java.util.Comparator;

import tud.ai2.solitaire.model.HighscoreEntry;
/**
 * Sorts highscore entries by time
 * 
 * @author Adrian Bohnstedt
 * @version 1.0
 */
public class TimeComparator implements Comparator<HighscoreEntry>{
	/**
	 * Sorts the shorter time above the longer time
	 * if they are the same sorts usernames
	 * 
	 * @param o1 first highscore entry
	 * @param o2 second highscore entry
	 */
	@Override
	public int compare(HighscoreEntry o1, HighscoreEntry o2) {
		//sort time by null
		if(o1.getTime() == null)
			return 1;
		else if(o2.getTime() == null)
			return 1;
		//sort by time
		if(o1.getTime() < o2.getTime())
			return -1; //-1
		if(o1.getTime() > o2.getTime())
			return 1; //1
		//sort name by null
		if(o1.getName() == null)
			return 1;
		else if(o2.getName() == null)
			return 1;
		//sort by name
		return o2.getName().compareToIgnoreCase(o1.getName());
	}

}
