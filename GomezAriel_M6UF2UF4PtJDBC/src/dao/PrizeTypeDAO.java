package dao;

import java.util.ArrayList;

import model.PrizeType;
import model.Prize;

public interface PrizeTypeDAO {
	// CRUD operations:
	
	// Create:
	public int addPrizeType(PrizeType priType);
	
	// Read:
	public PrizeType getPrizeTypeById(int priTypeId, boolean withPrizes);
	
	// Update:
	public int updatePrizeType(PrizeType priType);
	
	// Delete:
	public int deletePrizeType(PrizeType priType);
	
	//Extra queries:
	public ArrayList<Prize> PrizeList();
	public ArrayList<Prize> listPrizesByPrizeType(int priTypeId);
}
