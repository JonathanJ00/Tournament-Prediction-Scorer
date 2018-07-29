package results;

import java.util.List;

import Utilities.FormatType;

/**
 * Interface defining methods to store and access details of predicted or actual results.
 * 
 * @author Jonathan
 *
 */
public interface IResult {

	public void setTeams(List<String> teams);
	public List<String> getTeams();
	public FormatType getFormat();
}
