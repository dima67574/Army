package com.bakhir.army.models.soldier;
import javax.xml.bind.annotation.*;

import org.apache.log4j.Logger;

import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import com.bakhir.army.models.exceptions.SubmissionOutOfRangeException;
@XmlRootElement(name = "tankOfficer")
@XmlAccessorType(XmlAccessType.FIELD)
public class TankOfficer extends TankSoldier implements ICommand{
	private static final Logger log = Logger.getLogger(TankOfficer.class);
	@XmlElement(name = "submissionNumber")
	private int submissionNumber;
	
	
	public TankOfficer() {
	}
	public TankOfficer(int age, String name, int experience, int health, int height) throws AgeOutOfRangeException {
		super(age, name, experience, health, height);
		
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
		log.info("fight by  TankOfficer");
	};
	@Override
	public void killTank() {
		log.info("kill by  TankOfficer");
	};
    public void command() {}
	@Override
	public String toString() {
		return "TankOfficer [submissionNumber=" + submissionNumber + ", " + super.toString() + "";
	};
	
    
	
}
