package com.bakhir.army;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.apache.log4j.Logger;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import com.bakhir.army.models.exceptions.MaxSpeedOutOfRangeException;
import com.bakhir.army.models.exceptions.SubmissionOutOfRangeException;
import com.bakhir.army.models.soldier.AirDefenceCommonSoldier;
import com.bakhir.army.models.soldier.AirDefenceOfficer;
import com.bakhir.army.models.soldier.AirForceCommonSoldier;
import com.bakhir.army.models.soldier.AirForceOfficer;
import com.bakhir.army.models.soldier.TankCommonSoldier;
import com.bakhir.army.models.soldier.TankOfficer;
import com.bakhir.army.models.weapon.Plane;
import com.bakhir.army.models.weapon.Tank;
import com.bakhir.army.models.weapon.ZRK;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsers {
	private static final Logger log = Logger.getLogger(Parsers.class);
	 public void parseXML(String fileName) throws NumberFormatException, AgeOutOfRangeException, SubmissionOutOfRangeException, MaxSpeedOutOfRangeException {
		 	List<AirDefenceCommonSoldier> airDefenceCommonSoldiers = new ArrayList<>();
		 	List<AirDefenceOfficer> airDefenceOfficers = new ArrayList<>();
		 	AirDefenceCommonSoldier airDefenceCommonSoldier = null;
	        AirDefenceOfficer airDefenceOfficer = null;
	        ZRK zrk=null;
	        List<AirForceCommonSoldier> airForceCommonSoldiers= new ArrayList<>();
	        List<AirForceOfficer> airForceOfficers= new ArrayList<>();
	        AirForceCommonSoldier airForceCommonSoldier=null;
	        AirForceOfficer airForceOfficer=null;
	        Plane plane=null;
	        List<TankCommonSoldier> tankCommonSoldiers= new ArrayList<>();
	        List<TankOfficer> tankOfficers= new ArrayList<>();
	        TankCommonSoldier tankCommonSoldier=null;
	        TankOfficer tankOfficer=null;
	        Tank tank=null;
	        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	        try {
	            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
	            while(xmlEventReader.hasNext()){
	            	            	 
	                XMLEvent xmlEvent = xmlEventReader.nextEvent();
	               
	            	             	 
	                if (xmlEvent.isStartElement()){
		                   StartElement startElement = xmlEvent.asStartElement();
		                   switch(startElement.getName().getLocalPart()) {
		                   		case "zrk":{		                   			
		                   			Attribute nameAttr = startElement.getAttributeByName(new QName("name"));	                   			
		                            String name=nameAttr.getValue();		                            
		                   			xmlEvent = xmlEventReader.nextTag();		                   			
		                   			zrk = parseZrk(xmlEvent, xmlEventReader);
		                   			zrk.setName(name);
		                   		 
		                   		}
		                   		break;		                   		
		                   		case "airDefenceCommonSoldier":{
		                   			Attribute ageAttr = startElement.getAttributeByName(new QName("age"));	                   			
		                            int age=Integer.parseInt(ageAttr.getValue());
		                            xmlEvent = xmlEventReader.nextTag();
		                   			airDefenceCommonSoldier= parseDefenceCommonSoldier(xmlEvent, xmlEventReader);	               
		                   			airDefenceCommonSoldier.setAge(age);
		                   		}
		                   		break;                 		
		                   		case "airDefenceOfficer":{
		                   			Attribute ageAttr = startElement.getAttributeByName(new QName("age"));	                   			
		                            int age=Integer.parseInt(ageAttr.getValue());
		                            xmlEvent = xmlEventReader.nextTag();
		                   			airDefenceOfficer = parseDefenceOfficer(xmlEvent, xmlEventReader);	
		                   			airDefenceOfficer.setAge(age);
		                   		}
		                   		break;
		                   		
		                   		case "plane":{
		                   			Attribute nameAttr = startElement.getAttributeByName(new QName("name"));	                   			
		                            String name=nameAttr.getValue();
		                            xmlEvent = xmlEventReader.nextTag();  
		                   			plane = parsePlane(xmlEvent, xmlEventReader);
		                   			plane.setName(name);
		                   		}
		                   		break;
		                   		
		                   		case "airForceCommonSoldier":{
		                   			Attribute ageAttr = startElement.getAttributeByName(new QName("age"));	                   			
		                            int age=Integer.parseInt(ageAttr.getValue());		                   			
		                            xmlEvent = xmlEventReader.nextTag();	                   			
		                   			airForceCommonSoldier = parseForceCommonSoldier(xmlEvent, xmlEventReader);	
		                   			airForceCommonSoldier.setAge(age);
		                   		}
		                   		break;
		                   		
		                   		case "airForceOfficer":{
		                   			Attribute ageAttr = startElement.getAttributeByName(new QName("age"));	                   			
		                            int age=Integer.parseInt(ageAttr.getValue());
		                            xmlEvent = xmlEventReader.nextTag();                			
		                   			airForceOfficer = parseForceOfficer(xmlEvent, xmlEventReader);
		                   			airForceOfficer.setAge(age);
		                   		}
		                   		break;
		                   		
		                   		case "tank":{
		                   			Attribute nameAttr = startElement.getAttributeByName(new QName("name"));	                   			
		                            String name=nameAttr.getValue();
		                            xmlEvent = xmlEventReader.nextTag(); 		                   			
				                	tank = parseTank(xmlEvent, xmlEventReader);	
				                	tank.setName(name);
		                   		}
		                   		break;
		                   		
		                   		case "tankCommonSoldier":{
		                   			Attribute ageAttr = startElement.getAttributeByName(new QName("age"));	                   			
		                            int age=Integer.parseInt(ageAttr.getValue());
		                            xmlEvent = xmlEventReader.nextTag();               			
		                   			tankCommonSoldier = parseTankCommonSoldier(xmlEvent, xmlEventReader);
		                   			tankCommonSoldier.setAge(age);
		                   		}
		                   		break;
		                   		
		                   		case "tankOfficer":{
		                   			Attribute ageAttr = startElement.getAttributeByName(new QName("age"));	                   			
		                            int age=Integer.parseInt(ageAttr.getValue());
		                            xmlEvent = xmlEventReader.nextTag();
		                   			tankOfficer = parseTankOfficer(xmlEvent, xmlEventReader);
		                   			tankOfficer.setAge(age);
		                   		}
		                   		break;
		                   		
		                   		
		                   }
		                   
		               }
	                
	               if(xmlEvent.isEndElement()){
	                   EndElement endElement = xmlEvent.asEndElement();
	                  	                   
	                   switch (endElement.getName().getLocalPart()) {
	                   
	                   		case "airDefenceCommonSoldier":{
	                   			airDefenceCommonSoldiers.add(airDefenceCommonSoldier);
	                   		}
	                   		break;
	                   		case "airDefenceOfficer":{
	                   			airDefenceOfficers.add(airDefenceOfficer);
	                   		}
	                   		break;
	                   		case "airDefenceCommonSoldiers":{
	                   			zrk.setAirDefenceCommonSoldiers(airDefenceCommonSoldiers);	    
	                   		}
	                   		break;
	                   		case "airDefenceOfficers":{
	                   			zrk.setAirDefenceOfficers(airDefenceOfficers);	    
	                   		}
	                   		break;
	                   		case "airForceCommonSoldier":{
	                   			airForceCommonSoldiers.add(airForceCommonSoldier);   
	                   		}
	                   		break;
	                   		case "airForceOfficer":{
	                   			airForceOfficers.add(airForceOfficer);
	                   		}
	                   		break;
	                   		case "airForceCommonSoldiers":{
	                   			plane.setAirForceCommonSoldiers(airForceCommonSoldiers);	  
	                   		}
	                   		break;
	                   		case "airForceOfficers":{
	                   			plane.setAirForceOfficers(airForceOfficers);	  
	                   		}
	                   		break;
	                   		case "tankCommonSoldier":{
	                   			tankCommonSoldiers.add(tankCommonSoldier);   
	                   		}
	                   		break;
	                   		case "tankOfficer":{
	                   			tankOfficers.add(tankOfficer);
	                   		}
	                   		break;
	                   		case "tankCommonSoldiers":{
	                   			tank.setTankCommonSoldiers(tankCommonSoldiers);
	                   		}
	                   		break;
	                   		case "tankOfficers":{
	                   			tank.setTankOfficers(tankOfficers);
	                   		}
	                   		break;
	                   }
	                   
	                   
	               }
	             
	               
	               
	            }
	            
	        } catch (FileNotFoundException | XMLStreamException e) {
	           log.error(e);
	        }
	      log.info(zrk);
	      log.info(plane);
	      log.info(tank);
	      log.info("Method parseXML started successfully");
	      
	      
	    }

	private static AirDefenceCommonSoldier parseDefenceCommonSoldier(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws NumberFormatException, AgeOutOfRangeException, XMLStreamException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		AirDefenceCommonSoldier airDefenceCommonSoldier = new AirDefenceCommonSoldier();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "age":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceCommonSoldier.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
  		}       
     	case "name":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceCommonSoldier.setName(xmlEvent.asCharacters().getData());	
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}        	
     	case "experience":{
    			xmlEvent = xmlEventReader.nextEvent();
             airDefenceCommonSoldier.setExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));
             xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
    		}       		
    		case "health":{
    			xmlEvent = xmlEventReader.nextEvent();
             airDefenceCommonSoldier.setHealth(Integer.parseInt(xmlEvent.asCharacters().getData()));	
             xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
    		}       		
    		case "education":{
    			xmlEvent = xmlEventReader.nextEvent();
             airDefenceCommonSoldier.setEducation(xmlEvent.asCharacters().getData());               
    		}       		
     }
		return airDefenceCommonSoldier;
		
	}
	
	private static AirDefenceOfficer parseDefenceOfficer(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws NumberFormatException, AgeOutOfRangeException, XMLStreamException, SubmissionOutOfRangeException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		AirDefenceOfficer airDefenceOfficer = new AirDefenceOfficer();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "age":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceOfficer.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "name":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceOfficer.setName(xmlEvent.asCharacters().getData());
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "experience":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceOfficer.setExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "health":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceOfficer.setHealth(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}        	
     	case "education":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceOfficer.setEducation(xmlEvent.asCharacters().getData());
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}        	
     	case "submissionNumber":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airDefenceOfficer.setSubmissionNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
     	}       				
     
     }
     return airDefenceOfficer;			
     }
	
	private static AirForceCommonSoldier parseForceCommonSoldier(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws NumberFormatException, AgeOutOfRangeException, XMLStreamException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		AirForceCommonSoldier airForceCommonSoldier = new AirForceCommonSoldier();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "age":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airForceCommonSoldier.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "name":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airForceCommonSoldier.setName(xmlEvent.asCharacters().getData());
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "experience":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airForceCommonSoldier.setExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}        	
     	case "health":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airForceCommonSoldier.setHealth(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}        		                   		
     	case "speedReaction":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airForceCommonSoldier.setSpeedReaction(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		
     	}
		
     }
     return airForceCommonSoldier;
	}
	
	private static AirForceOfficer parseForceOfficer(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws NumberFormatException, AgeOutOfRangeException, XMLStreamException, SubmissionOutOfRangeException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		AirForceOfficer airForceOfficer = new AirForceOfficer();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "age":{
     		xmlEvent = xmlEventReader.nextEvent();
     		airForceOfficer.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
     		xmlEvent = xmlEventReader.nextTag();
     	}
		   	case "name":{
		   		xmlEvent = xmlEventReader.nextEvent();
		   		airForceOfficer.setName(xmlEvent.asCharacters().getData());
	   		   	xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();	
		   	}
		   	case "experience":{
		   		xmlEvent = xmlEventReader.nextEvent();
		   		airForceOfficer.setExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));
	   		   	xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
		   	}
		   	case "health":{
		   		xmlEvent = xmlEventReader.nextEvent();
		   		airForceOfficer.setHealth(Integer.parseInt(xmlEvent.asCharacters().getData()));
		   		xmlEvent = xmlEventReader.nextTag();
		   		xmlEvent = xmlEventReader.nextTag();
		   	}  			                   		
		   	case "speedReaction":{
		   		xmlEvent = xmlEventReader.nextEvent();
		   		airForceOfficer.setSpeedReaction(Integer.parseInt(xmlEvent.asCharacters().getData()));
	   		   	xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
		   	}   			                   		
		   	case "submissionNumber":{
		   		xmlEvent = xmlEventReader.nextEvent();
		   		airForceOfficer.setSubmissionNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
		   	}
		    }
     return airForceOfficer;
     }
	private static TankCommonSoldier parseTankCommonSoldier(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws NumberFormatException, AgeOutOfRangeException, XMLStreamException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		TankCommonSoldier tankCommonSoldier = new TankCommonSoldier();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "age":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankCommonSoldier.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "name":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankCommonSoldier.setName(xmlEvent.asCharacters().getData());
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "experience":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankCommonSoldier.setExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "health":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankCommonSoldier.setHealth(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "height":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankCommonSoldier.setHeight(Integer.parseInt(xmlEvent.asCharacters().getData()));
     	}
		
     }
     return tankCommonSoldier;
   }
	private static TankOfficer parseTankOfficer(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws NumberFormatException, AgeOutOfRangeException, XMLStreamException, SubmissionOutOfRangeException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		TankOfficer tankOfficer = new TankOfficer();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "age":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankOfficer.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "name":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankOfficer.setName(xmlEvent.asCharacters().getData());
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "experience":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankOfficer.setExperience(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "health":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankOfficer.setHealth(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}        			
     	case "height":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankOfficer.setHeight(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "submissionNumber":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tankOfficer.setSubmissionNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		
     	}
     }      
     return tankOfficer;
     
 }
	private static ZRK parseZrk(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		ZRK zrk = new ZRK();
     switch(SoldierStart.getName().getLocalPart()) {        		
     	case "strikingForce":{
     		xmlEvent = xmlEventReader.nextEvent();
     		zrk.setStrikingForce(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "strikingDistance":{
     		xmlEvent = xmlEventReader.nextEvent();
     		zrk.setStrikingDistance(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "productionStart":{
     		xmlEvent = xmlEventReader.nextEvent();
     		zrk.setProductionStart(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "temp":{
     		xmlEvent = xmlEventReader.nextEvent();
     		zrk.setTemp(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     		
     	}   		
     	case "heightAffectedArea":{
     		xmlEvent = xmlEventReader.nextEvent();
     		zrk.setHeightAffectedArea(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     	}
     	
     }
     return zrk; 
 }
	private static Plane parsePlane(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException, NumberFormatException, MaxSpeedOutOfRangeException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		Plane plane = new Plane();
     switch(SoldierStart.getName().getLocalPart()) {        		
     	case "strikingForce":{
     		xmlEvent = xmlEventReader.nextEvent();
     		plane.setStrikingForce(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "strikingDistance":{
     		xmlEvent = xmlEventReader.nextEvent();
     		plane.setStrikingDistance(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "productionStart":{
     		xmlEvent = xmlEventReader.nextEvent();
     		plane.setProductionStart(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}  	
     	case "maxSpeed":{
     		xmlEvent = xmlEventReader.nextEvent();
     		plane.setMaxSpeed(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}  	
     	case "flightDuration":{
     		xmlEvent = xmlEventReader.nextEvent();
     		plane.setFlightDuration(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "takeoffWeight":{
     		xmlEvent = xmlEventReader.nextEvent();
     		plane.setTakeoffWeight(Integer.parseInt(xmlEvent.asCharacters().getData()));	
     	}   		
     }
     return plane;
	}
	private static Tank parseTank(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws  XMLStreamException {
		StartElement SoldierStart = xmlEvent.asStartElement();
		Tank tank = new Tank();
     switch(SoldierStart.getName().getLocalPart()) {
     	case "strikingForce":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tank.setStrikingForce(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "strikingDistance":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tank.setStrikingDistance(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "productionStart":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tank.setProductionStart(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   
     	case "caliber":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tank.setCaliber(Integer.parseInt(xmlEvent.asCharacters().getData()));
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}   		
     	case "armerType":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tank.setArmerType(xmlEvent.asCharacters().getData());
     		xmlEvent = xmlEventReader.nextTag();
	    		xmlEvent = xmlEventReader.nextTag();
     	}        	
     	case "sightType":{
     		xmlEvent = xmlEventReader.nextEvent();
     		tank.setSightType(xmlEvent.asCharacters().getData());        		
     	}
		
     }
   return tank;  
 }
	public void parseJaxb(String fileName) {			
		try {	
		JAXBContext jaxbContext = JAXBContext.newInstance(Army.class);
     Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
     Army army = (Army) jaxbUnmarshaller.unmarshal(new File(fileName));
     log.info(army);
		} 		
		catch (JAXBException e) {		
			
			log.error(e);
		}
		log.info("Method parseJaxb started successfully");
		
	}
	public void parseJson(String fileName){		
		ObjectMapper mapper= new ObjectMapper();
		try {			
			Army army= mapper.readValue(new File(fileName), Army.class);			
			log.info(army);
			
		} 		
		catch (JsonParseException e) {	
			log.error(e);
		} catch (JsonMappingException e) {		
			log.error(e);
		} catch (IOException e) {		
			
			log.error(e);
		}
		log.info("Method parseJson started successfully");
		
	}
}
