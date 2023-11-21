package model;

public class PrizeType {
	private Integer prizeTypeId;
	private String prizeName;
	private String prizeDescription;
	private Double prizeValue;

	public PrizeType() {
		super();
	}

	public PrizeType(Integer prizeTypeId, String prizeName, String prizeDescription, Double prizeValue) {
		super();
		this.prizeTypeId = prizeTypeId;
		this.prizeName = prizeName;
		this.prizeDescription = prizeDescription;
		this.prizeValue = prizeValue;
	}

	public Integer getPrizeTypeId() {
		return prizeTypeId;
	}

	public void setPrizeTypeId(Integer prizeTypeId) {
		this.prizeTypeId = prizeTypeId;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getPrizeDescription() {
		return prizeDescription;
	}

	public void setPrizeDescription(String prizeDescription) {
		this.prizeDescription = prizeDescription;
	}

	public Double getPrizeValue() {
		return prizeValue;
	}

	public void setPrizeValue(Double prizeValue) {
		this.prizeValue = prizeValue;
	}

}
