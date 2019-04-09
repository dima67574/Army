package com.bakhir.army.models.soldier;
import javax.xml.bind.annotation.*;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
@XmlRootElement(name = "airForceSoldier")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AirForceSoldier extends Soldier implements ITankKill,IPlaneKill{
	
	@XmlElement(name = "speedReaction")
	private int speedReaction;	
	
	public AirForceSoldier() {
	}
	public AirForceSoldier(int age, String name, int experience, int health, int speedReaction) throws AgeOutOfRangeException {
		super(age, name, experience, health);
		this.speedReaction = speedReaction;
	}
	public int getSpeedReaction() {
		return speedReaction;
	}
	public void setSpeedReaction(int speedReaction) {
		this.speedReaction = speedReaction;
	}
	public abstract void killTank();
	public abstract void killZRK();
	public abstract void killPlane();
	@Override
	public String toString() {
		return "speedReaction=" + speedReaction + ", " + super.toString() + "";
	}
	
	
}
