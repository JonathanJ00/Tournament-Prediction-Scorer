package Utilities;

public class RoundDetails {
	private FormatType type;
	private int score;
	private int numTeams;
	private int bonus;
	private int numGroups;
	
	public RoundDetails(FormatType type, int score, int numTeams, int numGroups, int bonus) {
		this.type = type;
		this.score = score;
		this.numTeams = numTeams;
		this.bonus = bonus;
		this.numGroups = numGroups;
	}
	
	public FormatType getType() {
		return type;
	}
	
	public void setType(FormatType type) {
		this.type = type;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public int getNumTeams() {
		return numTeams;
	}

	public void setNumTeams(int numTeams) {
		this.numTeams = numTeams;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getNumGroups() {
		return numGroups;
	}

	public void setNumGroups(int numGroups) {
		this.numGroups = numGroups;
	}
}
