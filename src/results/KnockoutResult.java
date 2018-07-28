package results;

import java.util.ArrayList;
import java.util.List;

import Utilities.FormatType;

public class KnockoutResult implements IResult {
	private final FormatType format = FormatType.KNOCKOUT;
	private List<String> teams;

	public KnockoutResult()
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
}
