package rounds;

import Utilities.FormatType;
import results.IResult;

public class GroupRound implements IRound {
	private final FormatType format = FormatType.GROUP;
	private String name;
	private IResult result;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setResult(IResult result) {
		this.result = result;
	}

	@Override
	public IResult getResult() {
		return result;
	}

	@Override
	public FormatType getFormat() {
		return format;
	}
}
