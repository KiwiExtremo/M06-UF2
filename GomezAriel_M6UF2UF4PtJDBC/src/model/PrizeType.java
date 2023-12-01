package model;

import java.util.ArrayList;

public class PrizeType {
	private Integer prizeTypeId;
	private String prizeName;
	private String prizeDescription;
	private Double prizeValue;
	private ArrayList<Prize> prizeList = new ArrayList<Prize>();

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
	
	public ArrayList<Prize> getPrizeList() {
		return prizeList;
	}

	public void setPrizeList(ArrayList<Prize> prizeList) {
		this.prizeList = prizeList;
	}
	
	@Override
	public String toString() {
		String string = "Prize type data:\n";
		string += "\tPrize type ID: " + prizeTypeId + "\n";
		string += "\tName: " + prizeName + "\n";
		string += "\tDescription: " + prizeDescription + "\n";
		string += "\tValue: " + prizeValue + "\n";
		if (!prizeList.isEmpty()) {
			string += prizeList;
		}
		
		return string;
	}
}
