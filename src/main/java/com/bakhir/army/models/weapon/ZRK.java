package com.bakhir.army.models.weapon;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;

import java.util.List;

import com.bakhir.army.models.soldier.*;
@XmlRootElement(name = "zrk")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZRK extends Weapon {
	private static final Logger log = Logger.getLogger(ZRK.class);
	@XmlElement(name = "temp")
	private int temp;
	@XmlElement(name = "heightAffectedArea")
	private int heightAffectedArea;	
	@XmlElement(name = "airDefenceCommonSoldier")
	@XmlElementWrapper(name="airDefenceCommonSoldiers")
	private List<AirDefenceCommonSoldier> airDefenceCommonSoldiers;
	@XmlElement(name = "airDefenceOfficer")
	@XmlElementWrapper(name="airDefenceOfficers")
	private List<AirDefenceOfficer> airDefenceOfficers;
	public ZRK() {
	}

	public ZRK(String name, int strikingForce, int strikingDistance, int productionStart, int temp,
			int heightAffectedArea) {
		super(name, strikingForce, strikingDistance, productionStart);
		this.temp = temp;
		this.heightAffectedArea = heightAffectedArea;
	}

	public int getHeightAffectedArea() {
		return heightAffectedArea;
	}

	public void setHeightAffectedArea(int heightAffectedArea) {
		this.heightAffectedArea = heightAffectedArea;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	

	public List<AirDefenceCommonSoldier> getAirDefenceCommonSoldiers() {
		return airDefenceCommonSoldiers;
	}

	public void setAirDefenceCommonSoldiers(List<AirDefenceCommonSoldier> airDefenceCommonSoldiers) {
		this.airDefenceCommonSoldiers = airDefenceCommonSoldiers;
	}

	public List<AirDefenceOfficer> getAirDefenceOfficers() {
		return airDefenceOfficers;
	}

	public void setAirDefenceOfficers(List<AirDefenceOfficer> airDefenceOfficers) {
		this.airDefenceOfficers = airDefenceOfficers;
	}

	@Override
	public  void kill() {
		log.info("Kill by ZRK");
	}

	@Override
	public String toString() {
		return "ZRK temp=" + temp + ", heightAffectedArea=" + heightAffectedArea 
				+ ", airDefenceCommonSoldiers=" + airDefenceCommonSoldiers + ", airDefenceOfficers="
				+ airDefenceOfficers + "," + super.toString() + "";
	}

	
}
