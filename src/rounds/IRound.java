package rounds;

import Utilities.FormatType;
import results.IResult;

/**
 * Interface defining methods to store access details of a given round of a tournament.
 * 
 * @author Jonathan
 *
 */
public interface IRound {

	public void setName(String name);
	public String getName();
	public void setResult(IResult result);
	public IResult getResult();
	public FormatType getFormat();
}
