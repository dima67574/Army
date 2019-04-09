package com.bakhir.army.models.soldier;
import com.bakhir.army.models.exceptions.AgeOutOfRangeException;
import com.bakhir.army.models.exceptions.SubmissionOutOfRangeException;
import  com.bakhir.army.models.weapon.*;
import org.apache.log4j.Logger;
import java.util.Set;
public class ArtilleryOfficer extends ArtillerySoldier implements ICommand {
	private static final Logger log = Logger.getLogger(ArtilleryOfficer.class);
	private int submissionNumber;
	
	private Set<AssaultRifle> assaul;
	
	public ArtilleryOfficer() {
	}

	

	public ArtilleryOfficer(int age, String name, int experience, int health, int endurance) throws AgeOutOfRangeException {
		super(age, name, experience, health, endurance);
		
		
	}



	public int getSubmissionNumber() {
		return submissionNumber;
	}

	public void setSubmissionNumber(int submissionNumber) throws SubmissionOutOfRangeException {
		if (submissionNumber<0) throw new SubmissionOutOfRangeException("Submission number<0");
		this.submissionNumber = submissionNumber;
	}

	

	public Set<AssaultRifle> getAssaul() {
		return assaul;
	}



	public void setAssaul(Set<AssaultRifle> assaul) {
		this.assaul = assaul;
	}



	@Override
	public void fight() {
		log.info("fight by  ArtilleryOfficer");
	};
	@Override
	public void killTank() {
		log.info("kill by  ArtilleryOfficer");
	};
    public void command() {}



	@Override
	public String toString() {
		return "ArtilleryOfficer [submissionNumber=" + submissionNumber + ", assaul=" + assaul + ","
				+ super.toString() + "";
	};
    
    
}
