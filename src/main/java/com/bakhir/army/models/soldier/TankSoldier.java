package com.bakhir.army.models.soldier;
import javax.xml.bind.annotation.*;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
@XmlRootElement(name = "tankSoldier")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TankSoldier extends Soldier implements ITankKill {
	@XmlElement(name = "height")
    private int height;
    
    
    public TankSoldier() {
	}

	public TankSoldier(int age, String name, int experience, int health, int height) throws AgeOutOfRangeException {
		super(age, name, experience, health);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void killTank();

	@Override
	public String toString() {
		return "height=" + height + ", " + super.toString() + "";
	}

	
	
}
