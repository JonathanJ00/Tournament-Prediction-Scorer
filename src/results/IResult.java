package results;

import java.util.List;

import Utilities.FormatType;

public interface IResult {

	public void setTeams(List<String> teams);
	public List<String> getTeams();
	public FormatType getFormat();
}
