package rounds;

import Utilities.FormatType;

/**
 * Factory class to create objects of type IRound.
 * 
 * @author Jonathan
 *
 */
public class RoundFactory {
	
	/**
	 * Creates an object of type IRound based on provided details.
	 * 
	 * @param format Format of round provided as a value of FormatType
	 * @return Newly created object of type IRound
	 */
	public static IRound createRound(FormatType format) {
		IRound round;
		
		switch (format) {
		case GROUP:
			round = new GroupRound();
			break;
		case KNOCKOUT:
			round = new KnockoutRound();
			break;
		case TIEBREAK:
			round = new TiebreakRound();
			break;
		default:
			round = null;
			break;
		}
		
		return round;
	}
}
