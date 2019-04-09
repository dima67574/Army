package com.bakhir.army.models.soldier;

import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "airDefenceSoldier")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract  class AirDefenceSoldier extends Soldier implements IPlaneKill {	
	@XmlElement(name = "education")
	private String education;
		
	
	public AirDefenceSoldier() {
	}

	public AirDefenceSoldier(int age, String name, int experience, int health, String education) throws AgeOutOfRangeException {
		super(age, name, experience, health);
		this.education = education;
	}
		

	public String getEducation() {
			return education;
		}


		public void setEducation(String education) {
			this.education = education;
		}


	public abstract void killPlane();

	@Override
	public String toString() {
		return "education=" + education + ", " + super.toString() + "";
	}
	
	
}
