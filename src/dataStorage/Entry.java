package dataStorage;

import java.util.ArrayList;
import java.util.List;

import rounds.IRound;

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
	
	public void setRounds(List<IRound> rounds) {
		this.rounds = rounds;
	}
}