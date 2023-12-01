package model;

public class Prize {
	private Integer prizeId;
	private Candidate candidateId;
	private PrizeType prizeTypeId;
	private Integer year;

	public Prize() {
		super();
	}

	public Prize(Candidate candidateId, Integer prizeId, PrizeType prizeTypeId, Integer year) {
		super();
		this.candidateId = candidateId;
		this.prizeId = prizeId;
		this.prizeTypeId = prizeTypeId;
		this.year = year;
	}

	public Candidate getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Candidate candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	public PrizeType getPrizeTypeId() {
		return prizeTypeId;
	}

	public void setPrizeTypeId(PrizeType prizeTypeId) {
		this.prizeTypeId = prizeTypeId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		String string = "Prize data:\n";
		string += "\tPrize ID: " + prizeId;
		string += "\tCandidate " + candidateId.getCandidateId() + " data:\n";
		string += "\t\tName: " + candidateId.getFirstName() + " " + candidateId.getLastName() + "\n";
		string += "\t\tEmail: " + candidateId.getEmail() + "\n";
		string += "\t\tPhone: " + candidateId.getPhoneNumber() + "\n";
		string += "\tPrize type " + prizeTypeId.getPrizeTypeId() + " data:\n";
		string += "\t\tName " + prizeTypeId.getPrizeName() + "\n";
		string += "\t\tDescription: " + prizeTypeId.getPrizeDescription() + "\n";
		string += "\t\tValue: " + prizeTypeId.getPrizeValue() + "\n";
		string += "\tYear: " + year + "\n";
		
		return string;
	}
}
