package results;

import Utilities.FormatType;

public class ResultFactory {

	public static IResult createRound(FormatType format) {
		IResult round;
		
		switch (format) {
		case GROUP:
			round = new GroupResult();
			break;
		case KNOCKOUT:
			round = new KnockoutResult();
			break;
		default:
			round = null;
			break;
		}
		
		return round;
	}
}
