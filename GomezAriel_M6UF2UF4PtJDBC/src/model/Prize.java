package model;

public class Prize {
	private Integer candidateId;
	private Integer prizeId;
	private Integer prizeTypeId;
	private Integer year;

	public Prize() {
		super();
	}

	public Prize(Integer candidateId, Integer prizeId, Integer prizeTypeId, Integer year) {
		super();
		this.candidateId = candidateId;
		this.prizeId = prizeId;
		this.prizeTypeId = prizeTypeId;
		this.year = year;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	public Integer getPrizeTypeId() {
		return prizeTypeId;
	}

	public void setPrizeTypeId(Integer prizeTypeId) {
		this.prizeTypeId = prizeTypeId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
