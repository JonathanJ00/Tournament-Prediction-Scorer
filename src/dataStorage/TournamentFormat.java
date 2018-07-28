package dataStorage;

import java.util.HashMap;
import java.util.Map;

import Utilities.RoundDetails;
import Utilities.FormatType;

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
}
