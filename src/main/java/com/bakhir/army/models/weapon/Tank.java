package com.bakhir.army.models.weapon;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;

import java.util.List;

import com.bakhir.army.models.soldier.*;
@XmlRootElement(name = "tank")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tank extends Weapon{
	 private static final Logger log = Logger.getLogger(Tank.class);
	 @XmlElement(name = "caliber")
	 private int caliber;
	 @XmlElement(name = "armerType")
	 private ArmerType armerType;
	 @XmlElement(name = "sightType")
	 private SightType sightType;
	 @XmlElement(name = "tankCommonSoldier")
	 @XmlElementWrapper(name="tankCommonSoldiers")
	 private List<TankCommonSoldier>  tankCommonSoldiers;
	 @XmlElement(name = "tankOfficer")
	 @XmlElementWrapper(name="tankOfficers")
	 private List<TankOfficer>  tankOfficers;
	 public Tank() {
	}

	public Tank(String name, int strikingForce, int strikingDistance, int productionStart, int caliber
			) {
		super(name, strikingForce, strikingDistance, productionStart);
		this.caliber = caliber;
		
	}

	public String getArmerType() {
		return armerType.toString();
	}

	public void setArmerType(String armerType) {
		this.armerType = ArmerType.fromString(armerType);
	}
	public String getSightType() {
		return sightType.toString();
	}

	public void setSightType(String sightType) {
		this.sightType = SightType.fromString(sightType);
	}

	public int getCaliber() {
		return caliber;
	}

	public void setCaliber(int caliber) {
		this.caliber = caliber;
	}
	
	

	public List<TankCommonSoldier> getTankCommonSoldiers() {
		return tankCommonSoldiers;
	}

	public void setTankCommonSoldiers(List<TankCommonSoldier> tankCommonSoldiers) {
		this.tankCommonSoldiers = tankCommonSoldiers;
	}

	public List<TankOfficer> getTankOfficers() {
		return tankOfficers;
	}

	public void setTankOfficers(List<TankOfficer> tankOfficers) {
		this.tankOfficers = tankOfficers;
	}

	@Override
	public  void kill() {
		log.info("Kill by Tank");
	}

	@Override
	public String toString() {
		return "Tank caliber=" + caliber + ", armerType=" + armerType + ", sightType=" + sightType
				+ ", tankCommonSoldiers=" + tankCommonSoldiers + ", tankOfficers=" + tankOfficers + ", "
				+ super.toString() + "";
	}

	

	
}
