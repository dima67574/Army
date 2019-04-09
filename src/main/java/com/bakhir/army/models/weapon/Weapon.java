package com.bakhir.army.models.weapon;
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "weapon")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Weapon {
	@XmlAttribute(name = "name")
	private String name;
	@XmlElement(name = "strikingForce")
	private int strikingForce;
	@XmlElement(name = "strikingDistance")
	private int strikingDistance;
	@XmlElement(name = "productionStart")
	private int productionStart;
	
	
	public Weapon() {
	}

	public Weapon(String name, int strikingForce, int strikingDistance, int productionStart) {
		super();
		this.name = name;
		this.strikingForce = strikingForce;
		this.strikingDistance = strikingDistance;
		this.productionStart = productionStart;
	}

	public int getProductionStart() {
		return productionStart;
	}

	public void setProductionStart(int productionStart) {
		this.productionStart = productionStart;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrikingForce() {
		return strikingForce;
	}

	public void setStrikingForce(int strikingForce) {
		this.strikingForce = strikingForce;
	}

	public int getStrikingDistance() {
		return strikingDistance;
	}

	public void setStrikingDistance(int strikingDistance) {
		this.strikingDistance = strikingDistance;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + productionStart;
		result = prime * result + strikingDistance;
		result = prime * result + strikingForce;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (other.hashCode()!=hashCode())
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productionStart != other.productionStart)
			return false;
		if (strikingDistance != other.strikingDistance)
			return false;
		if (strikingForce != other.strikingForce)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name=" + name + ", strikingForce=" + strikingForce + ", strikingDistance=" + strikingDistance
				+ ", productionStart=" + productionStart ;
	}

	public abstract void kill();
 
}
