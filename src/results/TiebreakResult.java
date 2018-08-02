package results;

import java.util.ArrayList;
import java.util.List;

import Utilities.FormatType;

/**
 * Class to hold details of a predected or actual result for a knockout format round.
 * 
 * @author Jonathan
 *
 */
public class TiebreakResult implements IResult {
	private final FormatType format = FormatType.TIEBREAK;
	private List<String> teams;

	public TiebreakResult()
	{
		teams = new ArrayList<String>();
	}
	
	@Override
	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

	@Override
	public List<String> getTeams() {
		return teams;
	}

	@Override
	public FormatType getFormat() {
		return format;
	}

	@Override
	public void addTeam(String team) {
		teams.add(team);
	}
}
