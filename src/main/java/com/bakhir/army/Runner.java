package com.bakhir.army;
import java.text.*;
import com.bakhir.army.models.exceptions.*;
import org.apache.log4j.Logger;

public class Runner {
	private static final Logger log = Logger.getLogger(Runner.class);		
	public static void main(String[] args) throws ParseException, ClassNotFoundException, AgeOutOfRangeException, SubmissionOutOfRangeException, NumberFormatException, MaxSpeedOutOfRangeException {
		OtherMethods other=new OtherMethods();
		other.filling();
		other.refl();
		other.overrideMethods();
		Parsers parsers=new Parsers();
		parsers.parseXML("src\\main\\resources\\army.xml");
		parsers.parseJaxb("src\\main\\resources\\army.xml");
		parsers.parseJson("src\\main\\resources\\army.json");
		
		}
	}



   