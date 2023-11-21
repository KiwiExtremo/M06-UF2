package dao;

import java.util.ArrayList;

import model.PrizeType;
import model.Prize;

public interface PrizeTypeDAO {
	// CRUD operations:
	
	// Create:
	public int AddPrizeType(PrizeType priType);
	
	// Read:
	public PrizeType getPrizeType(int priTypeId, boolean withPrizes);
	
	// Update:
	public int updatePrizeType(PrizeType priType);
	
	// Delete:
	public int deletePrizeType(PrizeType priType, boolean cascade);
	
	//Extra queries:
	public ArrayList<Prize> PrizeList();
}
