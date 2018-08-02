package dataStorage;

import java.util.ArrayList;
import java.util.List;

import rounds.IRound;

/**
 * Class to hold details about an individual entry to the competition.
 * 
 * @author Jonathan
 *
 */
public class Entry {
	private String name;
	private List<IRound> rounds;
	
	public Entry() {
		rounds = new ArrayList<IRound>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<IRound> getRounds() {
		return rounds;
	}
	
	public void addRound(IRound round) {
		rounds.add(round);
	}
	
	public IRound getRound(String name) {
		for (IRound round: rounds) {
			if (round.getName().equals(name)) {
				return round;
			}
		}
		
		return null;
	}
	
	public void setRounds(List<IRound> rounds) {
		this.rounds = rounds;
	}
}
