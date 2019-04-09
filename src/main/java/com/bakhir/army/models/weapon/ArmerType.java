package com.bakhir.army.models.weapon;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
@XmlType(name = "armerType")
@XmlEnum
public enum ArmerType {
	@XmlEnumValue("steel")
	STEEL("steel"), 
	@XmlEnumValue("aluminium")
	ALUMINIUM("aluminium"), 
	@XmlEnumValue("iron")
	IRON("iron"), 
	@XmlEnumValue("titanium")
	TITANIUM("titanium"),
	@XmlEnumValue("uranium")
	URANIUM("uranium"), 
	@XmlEnumValue("ceramic")
	CERAMIC("ceramic"), 
	@XmlEnumValue("composite")
	COMPOSITE("composite");
	private String name;
	private ArmerType(String name) {
		this.name = name;
	 }

	public String getName() {
	     return this.name;
	}
	@Override
	public String toString() {
	       return this.name;
	}
	public static ArmerType fromString(String name) {
        for (ArmerType armer : ArmerType.values()) {
            if (armer.name.equalsIgnoreCase(name)) {
                return armer;
            }
        }
        return null;
    }
	
}
