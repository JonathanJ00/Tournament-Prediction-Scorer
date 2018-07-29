package results;

import Utilities.FormatType;

/**
 * Factory class for objects of type IResult.
 * 
 * @author Jonathan
 *
 */
public class ResultFactory {

	/**
	 * Method to create a new object of type IResult based on provided format details.
	 * 
	 * @param format Format type as FormatType
	 * @return New object of type IResult
	 */
	public static IResult createResult(FormatType format) {
		IResult round;
		
		switch (format) {
		case GROUP:
			round = new GroupResult();
			break;
		case KNOCKOUT:
			round = new KnockoutResult();
			break;
		case TIEBREAK:
			round = new TiebreakResult();
			break;
		default:
			round = null;
			break;
		}
		
		return round;
	}
}
