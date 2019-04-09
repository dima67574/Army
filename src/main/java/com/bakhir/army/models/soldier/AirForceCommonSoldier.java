package com.bakhir.army.models.soldier;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import javax.xml.bind.annotation.*;
import org.apache.log4j.Logger;

@XmlRootElement(name = "airForceCommonSoldier")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirForceCommonSoldier extends AirForceSoldier {
	
	private static final Logger log = Logger.getLogger(AirForceCommonSoldier.class);
	
	public AirForceCommonSoldier() {
	}
	public AirForceCommonSoldier(int age, String name, int experience, int health, int speedReaction) throws AgeOutOfRangeException {
		super(age, name, experience, health, speedReaction);		
	}
	
	@Override
	public void killTank() {
		log.info("kill by  AirForceCommonSoldier");
	};
	@Override
	public  void killZRK() {
		log.info("kill by  AirForceCommonSoldier");
	};
	@Override
	public  void killPlane() {
		log.info("kill by  AirForceCommonSoldier");
	};
	@Override
	public  void fight() {
		log.info("fight by  AirForceCommonSoldier");
	}
	@Override
	public String toString() {
		return "AirForceCommonSoldier [" + super.toString() + "";
	};
	

}
