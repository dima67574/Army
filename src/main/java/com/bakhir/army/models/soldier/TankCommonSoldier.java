package com.bakhir.army.models.soldier;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;

import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
@XmlRootElement(name = "tankCommonSoldier")
@XmlAccessorType(XmlAccessType.FIELD)
public class TankCommonSoldier extends TankSoldier {
	private static final Logger log = Logger.getLogger(TankCommonSoldier.class);
	public TankCommonSoldier() {
	}

	public TankCommonSoldier(int age, String name, int experience, int health, int height) throws AgeOutOfRangeException {
		super(age, name, experience, health, height);
	}

	@Override
	public void killTank() {
		log.info("kill by  TankCommonSoldier");
	};
	@Override
	public  void fight() {
		log.info("fight by  TankCommonSoldier");
	}

	@Override
	public String toString() {
		return "TankCommonSoldier [" + super.toString() + "";
	};
	
}
