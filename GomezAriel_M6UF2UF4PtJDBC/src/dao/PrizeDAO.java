package dao;

import model.Prize;

public interface PrizeDAO {
	// CRUD Operations:

	// Create:
	public int addPrize(Prize pri);

	// Read:
	public Prize getPrizeById(int priId);

	// Update:
	public int updatePrize(Prize pri);

	// Delete:
	public int deletePrize(Prize pri, boolean cascade);

}
