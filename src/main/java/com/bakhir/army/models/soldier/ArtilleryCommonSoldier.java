package com.bakhir.army.models.soldier;
import org.apache.log4j.Logger;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import  com.bakhir.army.models.weapon.*;
import java.util.Set;
public class ArtilleryCommonSoldier extends ArtillerySoldier {
	private static final Logger log = Logger.getLogger(ArtilleryCommonSoldier.class);
	private Set <AssaultRifle> assaul;
	public ArtilleryCommonSoldier() {
	}

	public ArtilleryCommonSoldier(int age, String name, int experience, int health, int endurance) throws AgeOutOfRangeException {
		super(age, name, experience, health, endurance);
	}

	

	public Set<AssaultRifle> getAssaul() {
		return assaul;
	}

	public void setAssaul(Set<AssaultRifle> assaul) {
		this.assaul = assaul;
	}

	@Override
	public void fight() {
		log.info("fight by  ArtilleryCommonSoldier");
	};
	@Override
	public void killTank() {
		log.info("kill by ArtilleryCommonSoldier");
	}

	@Override
	public String toString() {
		return "assaul=" + assaul + ", " + super.toString() + "";
	};
   
	
}
