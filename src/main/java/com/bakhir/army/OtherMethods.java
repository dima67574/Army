package com.bakhir.army;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import com.bakhir.army.models.exceptions.MaxSpeedOutOfRangeException;
import com.bakhir.army.models.exceptions.SubmissionOutOfRangeException;
import com.bakhir.army.models.soldier.AirDefenceOfficer;
import com.bakhir.army.models.soldier.ArtilleryCommonSoldier;
import com.bakhir.army.models.soldier.ArtilleryOfficer;
import com.bakhir.army.models.soldier.ArtillerySoldier;
import com.bakhir.army.models.weapon.Artillery;
import com.bakhir.army.models.weapon.AssaultRifle;
import com.bakhir.army.models.weapon.Plane;

public class OtherMethods {
	private static final Logger log = Logger.getLogger(OtherMethods.class);
	public void filling() throws ParseException, AgeOutOfRangeException {		
		AssaultRifle assa=new AssaultRifle("Ak74", 5, 6, 8, 4, 4, 5);	
		AssaultRifle assa2=new AssaultRifle("Ak74", 6, 6, 8, 4, 4, 5);
		AssaultRifle assa3=new AssaultRifle("Ak74", 5, 6, 8, 4, 4, 5);
		Set<AssaultRifle> a=new HashSet<AssaultRifle>();
		a.add(assa);
		a.add(assa2);
		a.add(assa3);
		Artillery art=new Artillery("Auf", 3, 2, 2, "main", "1998-12-31");		
		List<ArtillerySoldier> artOff = new ArrayList<ArtillerySoldier>();
		artOff.add(new ArtilleryOfficer(25,"Ivan",25,100,100));
		artOff.add(new ArtilleryCommonSoldier(25,"Petr",65,100,100));
		art.setArtSold(artOff);		
		art.setName("ijh");
		assa.kill();
		
		try {
			Plane plane = new Plane("Il2",25,23,12,-234,45,45);
		
		} catch (MaxSpeedOutOfRangeException e1) {
			log.error(e1);
		}
				
			
		AirDefenceOfficer airoff=new AirDefenceOfficer();
		
		try {
			airoff.setSubmissionNumber(-55);			
		} catch (SubmissionOutOfRangeException e) {
			log.error(e);
		}
		log.info("Method filling started successfully");			
		
	}
	public void refl() throws ClassNotFoundException {		 	
		Class<?> c = Class.forName("com.bakhir.army.models.soldier.Soldier");
		Field[] fs = c.getDeclaredFields();
		Method[] ms=c.getDeclaredMethods();
		log.info(Modifier.toString(fs[1].getModifiers()) +" "+ fs[1].getName() + " "+ fs[1].getType());
		log.info(Modifier.toString(ms[1].getModifiers()) +" "+  ms[1].getName() +" "+  ms[1].getReturnType());
		log.info("Method refl started successfully");				
	}
	public void overrideMethods() {
		AssaultRifle riffle= new AssaultRifle("max", 2, 3, 4, 5, 4, 5);
		AssaultRifle riffle2= new AssaultRifle("max", 2, 3, 4, 5, 4, 6);
		AssaultRifle riffle3= new AssaultRifle("max", 2, 3, 4, 5, 8, 5);
		log.info(riffle.equals(riffle2));
		log.info(riffle.equals(riffle3));
		log.info(riffle.hashCode());
		log.info(riffle2.hashCode());
		log.info(riffle3.hashCode());
		log.info(riffle3.toString());		
		log.info("Method overrideMethods started successfully");	
		
	}
}
