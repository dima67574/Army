package com.bakhir.army.models.soldier;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import javax.xml.bind.annotation.*;
import org.apache.log4j.Logger;
import com.bakhir.army.models.exceptions.SubmissionOutOfRangeException;
@XmlRootElement(name = "airForceOfficer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirForceOfficer extends AirForceSoldier implements ICommand {
	private static final Logger log = Logger.getLogger(AirForceOfficer.class);
	@XmlElement(name = "submissionNumber")
	private int submissionNumber;	
	public AirForceOfficer() {
	}
	
	public AirForceOfficer(int age, String name, int experience, int health, int speedReaction) throws AgeOutOfRangeException {
		super(age, name, experience, health, speedReaction);
		
	}

	public int getSubmissionNumber() {
		return submissionNumber;
	}

	public void setSubmissionNumber(int submissionNumber) throws SubmissionOutOfRangeException {
		if (submissionNumber<0) throw new SubmissionOutOfRangeException("Submission number<0");
		this.submissionNumber = submissionNumber;
	}

	@Override
	public void killTank() {
		log.info("kill by  AirForceOfficer");
	};
	@Override
	public  void killZRK() {
		log.info("kill by  AirForceOfficer");
	};
	@Override
	public  void killPlane() {
		log.info("kill by  AirForceOfficer");
	};
	@Override
	public  void fight() {
		log.info("fight by  AirForceOfficer");
	};
	public void command() {}

	@Override
	public String toString() {
		return "AirForceOfficer [submissionNumber=" + submissionNumber + ", " + super.toString() + "";
	};
	
	
	
}