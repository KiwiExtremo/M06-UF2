package model;

import java.util.ArrayList;

public class Candidate {
	private Integer candidateId;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private ArrayList<Prize> prizeList = new ArrayList<Prize>();

	public Candidate() {
		super();
	}

	public Candidate(Integer candidateId, String email, String firstName, String lastName, String phoneNumber) {
		super();
		this.candidateId = candidateId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<Prize> getPrizeList() {
		return prizeList;
	}

	public void setPrizeList(ArrayList<Prize> prizeList) {
		this.prizeList = prizeList;
	}
	
	@Override
	public String toString() {
		String string = "Candidate data:\n";
		string += "\tCandidate ID: " + getCandidateId() + "\n";
		string += "\tName: " + getFirstName() + " " + getLastName() + "\n";
		string += "\tEmail: " + getEmail() + "\n";
		string += "\tPhone: " + getPhoneNumber() + "\n";
		if (!prizeList.isEmpty()) {
			string += prizeList;
		}
		
		return string;
	}
}
