package com.bakhir.army.models.soldier;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;

public abstract class ArtillerySoldier extends Soldier implements ITankKill{
	private int endurance;
	
	public ArtillerySoldier() {
	}

	public ArtillerySoldier(int age, String name, int experience, int health, int endurance) throws AgeOutOfRangeException {
		super(age, name, experience, health);
		this.endurance = endurance;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public abstract void killTank();
}
