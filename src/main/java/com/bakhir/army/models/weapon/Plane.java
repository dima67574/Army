package com.bakhir.army.models.weapon;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;

import java.util.List;
import com.bakhir.army.models.exceptions.MaxSpeedOutOfRangeException;
import com.bakhir.army.models.soldier.*;
@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plane extends Weapon {
	private static final Logger log = Logger.getLogger(Plane.class);
	@XmlElement(name = "maxSpeed")
	private int maxSpeed;
	@XmlElement(name = "flightDuration")
	private int flightDuration;
	@XmlElement(name = "takeoffWeight")
	private int takeoffWeight;
	@XmlElement(name = "airForceCommonSoldier")
	@XmlElementWrapper(name="airForceCommonSoldiers")
	private List<AirForceCommonSoldier> airForceCommonSoldiers;
	@XmlElement(name = "airForceOfficer")
	@XmlElementWrapper(name="airForceOfficers")
	private List<AirForceOfficer> airForceOfficers;
		
	public Plane() {
	}
	public Plane(String name, int strikingForce, int strikingDistance, int productionStart, int maxSpeed,
			int flightDuration, int takeoffWeight) throws MaxSpeedOutOfRangeException {
		super(name, strikingForce, strikingDistance, productionStart);
		if (maxSpeed<0) throw new MaxSpeedOutOfRangeException("MaxSpeed<0");
		this.maxSpeed = maxSpeed;
		this.flightDuration = flightDuration;
		this.takeoffWeight = takeoffWeight;
		
	}
	public int getTakeoffWeight() {
		return takeoffWeight;
	}
	public void setTakeoffWeight(int takeoffWeight) {
		this.takeoffWeight = takeoffWeight;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) throws MaxSpeedOutOfRangeException {
		if (maxSpeed<0) throw new MaxSpeedOutOfRangeException("MaxSpeed<0");
		this.maxSpeed = maxSpeed;
	}
	public int getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}	
	
	public List<AirForceCommonSoldier> getAirForceCommonSoldiers() {
		return airForceCommonSoldiers;
	}
	public void setAirForceCommonSoldiers(List<AirForceCommonSoldier> airForceCommonSoldiers) {
		this.airForceCommonSoldiers = airForceCommonSoldiers;
	}
	public List<AirForceOfficer> getAirForceOfficers() {
		return airForceOfficers;
	}
	public void setAirForceOfficers(List<AirForceOfficer> airForceOfficers) {
		this.airForceOfficers = airForceOfficers;
	}
	@Override
	public  void kill() {
		log.info("Kill by Plane");
	}
	@Override
	public String toString() {
		return "Plane maxSpeed=" + maxSpeed + ", flightDuration=" + flightDuration + ", takeoffWeight=" + takeoffWeight
				+ ", airForceCommonSoldiers=" + airForceCommonSoldiers + ", airForceOfficers=" + airForceOfficers
				+ ", " + super.toString() + "";
	}
	
	
	
	
}
