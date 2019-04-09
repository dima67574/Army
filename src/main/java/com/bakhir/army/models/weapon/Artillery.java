package com.bakhir.army.models.weapon;
import com.bakhir.army.models.soldier.*;
import java.text.*;
import java.util.*;

import org.apache.log4j.Logger;
public class Artillery extends Weapon{
	private static final Logger log = Logger.getLogger(Artillery.class);
	private String armorType;
	private Date dateManufacture;
	private List<ArtillerySoldier> artSold;	
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public Artillery() {
	}
	
	
	
	public Artillery(String name, int strikingForce, int strikingDistance, int productionStart, String armorType,
		String dateManufacture) throws ParseException {
		super(name, strikingForce, strikingDistance, productionStart);
		this.armorType = armorType;
		this.dateManufacture = format.parse( dateManufacture );
	}
	public String getDateManufacture() {
		return format.format( dateManufacture  );
	}

	public void setDateManufacture(String dateManufacture) throws ParseException {
		this.dateManufacture = format.parse( dateManufacture );
	}

	public String getArmorType() {
		return armorType;
	}

	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}

	public List<ArtillerySoldier> getArtSold() {
		return artSold;
	}



	public void setArtSold(List<ArtillerySoldier> artSold) {
		this.artSold = artSold;
	}



	@Override
	public  void kill() {
		log.info("Kill by Artillery");
	}

}
