package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Prize;
import model.PrizeType;

public class PrizeTypeDAOJDBC implements PrizeTypeDAO {
	// CRUD operations:
	
	// Create:
	@Override
	public int addPrizeType(PrizeType priType) {
		Boolean isConnectionOpen = false;

		String sql = "INSERT INTO prizetype(prizeTypeId, prizeName, prizeDescription, prizeValue) VALUES (?, ?, ?, ?)";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind values
			sentence.setInt(1, priType.getPrizeTypeId());
			sentence.setString(2, priType.getPrizeName());
			sentence.setString(3, priType.getPrizeDescription());
			sentence.setDouble(4, priType.getPrizeValue());

			int resultCode = sentence.executeUpdate();

			return resultCode;
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {

				// PK repetida
				return e.getErrorCode() * -1;
			} else {
				e.printStackTrace();
				return -1;
			}
		} finally {
			if (!isConnectionOpen) {
				ConnectionManager.closeConnection();
			}
		}
	}
	
	// Read:
	@Override
	public PrizeType getPrizeTypeById(int priTypeId, boolean withPrizes) {
		Boolean isConnectionOpen = false;

		String sql = "SELECT prizeTypeId, prizeName, prizeDescription, prizeValue FROM prizetype WHERE prizeTypeId = ?";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind value
			sentence.setInt(1, priTypeId);

			ResultSet result = sentence.executeQuery();

			// create placeholder prize
			PrizeType resultPrizeType = new PrizeType();

			while (result.next()) {
				// bind results into placeholder prize
				resultPrizeType.setPrizeTypeId(priTypeId);
				resultPrizeType.setPrizeName(result.getString(2));
				resultPrizeType.setPrizeDescription(result.getString(3));
				resultPrizeType.setPrizeValue(result.getDouble(4));
			}
			if (withPrizes) {
				ArrayList<Prize> listPrizes = listPrizesByPrizeType(priTypeId);

				resultPrizeType.setPrizeList(listPrizes);
			} 

			return resultPrizeType;

		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				return null;
			} else {
				e.printStackTrace();
				return null;
			}
		} finally {
			if (!isConnectionOpen) {
				ConnectionManager.closeConnection();
			}
		}
	}
	
	// Update:
	@Override
	public int updatePrizeType(PrizeType priType) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Delete:
	@Override
	public int deletePrizeType(PrizeType priType) {
		Boolean isConnectionOpen = false;

		String sql = "DELETE FROM prizeType WHERE prizeTypeId = ?";

		Connection connection = ConnectionManager.getConnection();
		
		try {
			isConnectionOpen = ConnectionManager.isConnected();

			PreparedStatement sentence = connection.prepareStatement(sql);
			
			// Bindejar valors
			sentence.setInt(1, priType.getPrizeTypeId());
			
			int resultCode = sentence.executeUpdate();

			
			return resultCode;
			
		} catch (SQLException e) {
			if(e.getErrorCode() == 1451) {
				return  e.getErrorCode() * -1;
		      }
			return -1;
			
		} finally {
			if (!isConnectionOpen) {
				ConnectionManager.closeConnection();
			}
		}
	}

	@Override
	public ArrayList<Prize> PrizeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prize> listPrizesByPrizeType(int priTypeId) {
		Boolean isConnectionOpen = false;

		String sql = "SELECT candidateId, prizeId, prizeTypeId, Year FROM prizes WHERE prizeTypeId = ?";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind value
			sentence.setInt(1, priTypeId);

			ResultSet result = sentence.executeQuery();

			// create array
			ArrayList<Prize> listPrizes = new ArrayList<Prize>();

			while (result.next()) {
				// create placeholder prize
				Prize prize = new Prize();
				
				// bind results into placeholder prize
				prize.setCandidateId(priTypeId);
				prize.setPrizeId(result.getInt(2));
				prize.setPrizeTypeId(result.getInt(3));
				
				// add current prize from placeholder into array
				listPrizes.add(prize);
			}

			return listPrizes;

		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				return null;
			} else {
				e.printStackTrace();
				return null;
			}
		} finally {
			if (!isConnectionOpen) {
				ConnectionManager.closeConnection();
			}
		}
	}

}
