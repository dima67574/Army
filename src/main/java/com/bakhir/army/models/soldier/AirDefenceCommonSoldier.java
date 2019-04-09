package com.bakhir.army.models.soldier;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;
@XmlRootElement(name = "airDefenceCommonSoldier")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirDefenceCommonSoldier extends AirDefenceSoldier {
	private static final Logger log = Logger.getLogger(AirDefenceCommonSoldier.class);
	public AirDefenceCommonSoldier() {
	}
	public AirDefenceCommonSoldier(int age, String name, int experience, int health, String education) throws AgeOutOfRangeException {
		super(age, name, experience, health, education);
		
	}
	
	@Override
	public void fight() {
		log.info("fight by AirDefenceCommonSoldier");
	};
	@Override
	public void killPlane() {
		log.info("kill by AirDefenceCommonSoldier");
				
	}
	@Override
	public String toString() {
		return "AirDefenceCommonSoldier [" + super.toString() + "]";
	};
	

}
