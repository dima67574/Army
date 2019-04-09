package com.bakhir.army.models.soldier;

import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import com.bakhir.army.models.exceptions.SubmissionOutOfRangeException;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;
@XmlRootElement(name = "AirDefenceOfficer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirDefenceOfficer extends AirDefenceSoldier implements ICommand {
	private static final Logger log = Logger.getLogger(AirDefenceOfficer.class);
	@XmlElement(name = "submissionNumber")
	private int submissionNumber;
	
	public AirDefenceOfficer() {
	}

	public AirDefenceOfficer(int age, String name, int experience, int health, String education) throws AgeOutOfRangeException {
		super(age, name, experience, health, education);
		
		
	}


	public int getSubmissionNumber() {
		return submissionNumber;
	}

	public void setSubmissionNumber(int submissionNumber) throws SubmissionOutOfRangeException {
		if (submissionNumber<0) throw new SubmissionOutOfRangeException("Submission number<0");
		this.submissionNumber = submissionNumber;
		
	}
	@Override
	public void fight() {
		log.info("fight by  AirDefenceOfficer");
	};
	@Override
	public void killPlane() {
		log.info("kill by  AirDefenceOfficer");
	};
    public void command() {}

	@Override
	public String toString() {
		return "AirDefenceOfficer [submissionNumber=" + submissionNumber + "," + super.toString() + "";
	};
    
}
