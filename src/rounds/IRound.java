package rounds;

import Utilities.FormatType;
import results.IResult;

public interface IRound {

	public void setName(String name);
	public String getName();
	public void setResult(IResult result);
	public IResult getResult();
	public FormatType getFormat();
}
