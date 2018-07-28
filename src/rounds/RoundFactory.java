package rounds;

import Utilities.FormatType;

public class RoundFactory {
	
	public static IRound createRound(FormatType format) {
		IRound round;
		
		switch (format) {
		case GROUP:
			round = new GroupRound();
			break;
		case KNOCKOUT:
			round = new KnockoutRound();
			break;
		default:
			round = null;
			break;
		}
		
		return round;
	}
}
