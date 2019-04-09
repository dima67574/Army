package com.bakhir.army.models.weapon;
import org.apache.log4j.Logger;

public class AssaultRifle extends Weapon {
	private static final Logger log = Logger.getLogger(AssaultRifle.class);
    private int rapidityFire;
    private int caliber;
    private int weight;
       
	
	
	public AssaultRifle() {
	}
	public AssaultRifle(String name, int strikingForce, int strikingDistance, int productionStart, int rapidityFire,
			int caliber, int weight) {
		super(name, strikingForce, strikingDistance, productionStart);
		this.rapidityFire = rapidityFire;
		this.caliber = caliber;
		this.weight = weight;
	}
	public int getRapidityFire() {
		return rapidityFire;
	}
	public void setRapidityFire(int rapidityFire) {
		this.rapidityFire = rapidityFire;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCaliber() {
		return caliber;
	}
	public void setCaliber(int caliber) {
		this.caliber = caliber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + caliber;
		result = prime * result + rapidityFire;
		result = prime * result + weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssaultRifle other = (AssaultRifle) obj;		
		if (caliber != other.caliber)
			return false;
		if (rapidityFire != other.rapidityFire)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AssaultRifle [rapidityFire=" + rapidityFire + ", caliber=" + caliber + ", weight=" + weight
				 +", " + super.toString() + "]";
	}
	@Override
	public  void kill() {
		log.info("Kill by Assault Rifle");
	};
}
