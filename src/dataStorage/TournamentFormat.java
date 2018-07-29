package dataStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Utilities.FormatType;
import Utilities.RoundDetails;

/**
 * Class to hold details about the format of the tournament.
 * 
 * @author Jonathan
 *
 */
public class TournamentFormat {
	private Map<String, RoundDetails> rounds;
	
	public TournamentFormat()
	{
		rounds = new HashMap<String, RoundDetails>();
	}
	
	public void addRound(String name, FormatType type, int score, int numTeams, int numGroups, int bonus) {
		RoundDetails details = new RoundDetails(type, score, numTeams, numGroups, bonus);
		
		rounds.put(name, details);
	}
	
	public FormatType getType(String name) {
		RoundDetails details = rounds.get(name);
		
		return details.getType();
	}
	
	public Set<String> getRounds() {
		return rounds.keySet();
	}
	
	public RoundDetails getDetails(String round) {
		return rounds.get(round);
	}
}
