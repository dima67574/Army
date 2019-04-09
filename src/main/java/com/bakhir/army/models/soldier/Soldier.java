package com.bakhir.army.models.soldier;

import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "soldier")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Soldier {
	@XmlAttribute(name = "age")
	private int age;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "experience")
	private int experience;
	@XmlElement(name = "health")
	private int health;
	
	public Soldier() {
	}
	public Soldier(int age, String name, int experience, int health) throws AgeOutOfRangeException {
		super();
		if (age<18) throw new AgeOutOfRangeException("Age<18");
		this.age = age;
		this.name = name;
		this.experience = experience;
		this.health = health;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeOutOfRangeException {
		
		if (age<18) throw new AgeOutOfRangeException("Age<18");
		this.age = age;
		
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public abstract void  fight();
	@Override
	public String toString() {
		return "age=" + age + ", name=" + name + ", experience=" + experience + ", health=" + health + "]";
	} 
	
	

}
