package com.bakhir.army.models.weapon;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
@XmlType(name = "sightType")
@XmlEnum
public enum SightType {
	@XmlEnumValue("optical")
	OPTICAL("optical"),
	@XmlEnumValue("colimator")
	COLIMATOR("colimator"),
	@XmlEnumValue("diopter")
	DIOPTER("diopter"), 
	@XmlEnumValue("globe")
	GLOBE("globe"), 
	@XmlEnumValue("holographic")
	HOLOGRAPHIC("holographic"),
	@XmlEnumValue("iron")
	IRON("iron"), 
	@XmlEnumValue("laser")
	LASER("laser"), 
	@XmlEnumValue("reflector")
	REFLECTOR("reflector");
	private String name;
	private SightType(String text) {
        this.name = text;
    }
    public String getName() {
        return this.name;
    }
    @Override
	public String toString() {
	       return this.name;
	}
	public static SightType fromString(String name) {
        for (SightType sight : SightType.values()) {
            if (sight.name.equalsIgnoreCase(name)) {
                return sight;
            }
        }
        return null;
    }
    
	}