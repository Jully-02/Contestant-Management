package Model;

import java.io.Serializable;
import java.sql.Date;

public class Contestant implements Serializable {
	private String identifier;
	private String name;
	private Province homeTown;
	private Date dob;
	private boolean gender;
	private float mathScore;
	private float literatureScore;
	private float englishScore;
	
	public Contestant () {
		
	}
	
	public Contestant(String identifier, String name, Province homeTown, Date dob, boolean genter, float mathScore, float literatureScore, float englishScore) {
		this.identifier = identifier;
		this.name = name;
		this.homeTown = homeTown;
		this.dob = dob;
		this.gender = genter;
		this.mathScore = mathScore;
		this.literatureScore = literatureScore;
		this.englishScore = englishScore;
	}

	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Province getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(Province homeTown) {
		this.homeTown = homeTown;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public float getMathScore() {
		return mathScore;
	}
	public void setMathScore(float mathScore) {
		this.mathScore = mathScore;
	}
	public float getLiteratureScore() {
		return literatureScore;
	}
	public void setLiteratureScore(float literatureScore) {
		this.literatureScore = literatureScore;
	}
	public float getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(float englishScore) {
		this.englishScore = englishScore;
	}
	
	
}
