package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Candidate;
import model.Prize;
import model.PrizeType;

public class PrizeDAOJDBC implements PrizeDAO {

	@Override
	public int addPrize(Prize pri) {
		Boolean isConnectionOpen = false;

		String sql = "INSERT INTO prize(candidateId, prizeId, prizeTypeId, Year) VALUES (?, ?, ?, ?)";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind values
			sentence.setInt(1, pri.getCandidateId().getCandidateId());
			sentence.setInt(2, pri.getPrizeId());
			sentence.setInt(3, pri.getPrizeTypeId().getPrizeTypeId());
			sentence.setInt(4, pri.getYear());

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

	@Override
	public Prize getPrizeById(int priId) {
		boolean isConnectionOpen = false;
		
		String sql = "SELECT candidateId, prizeId, prizeTypeId, Year FROM prizes WHERE candidateId = ?";
		
		Prize prizePlaceholder = new Prize();
		PrizeType prizeTypePlaceholder = new PrizeType();
		Candidate candidatePlaceholder = new Candidate();
		
		PrizeTypeDAO priTypeDAO = DAOManager.getPriTypeDAO();
		
		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind value
			sentence.setInt(1, candId.getCandidateId());

			ResultSet result = sentence.executeQuery();

			// create array
			ArrayList<Prize> listPrizes = new ArrayList<Prize>();

			while (result.next()) {
				// bind results into placeholder prize type
				prizeTypePlaceholder = priTypeDAO.getPrizeTypeById(candId.getCandidateId(), false);
				
				// bind results into placeholder prize
				prizePlaceholder.setCandidateId(candId);
				prizePlaceholder.setPrizeId(result.getInt(2));
				prizePlaceholder.setPrizeTypeId(prizeTypePlaceholder);
				prizePlaceholder.setYear(result.getInt(4));
				
				// add current prize from placeholder into array
				listPrizes.add(prizePlaceholder);
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

	@Override
	public int updatePrize(Prize pri) {
		Boolean isConnectionOpen = false;

		String sql = "UPDATE prize WHERE prizeId = ?";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind values
			sentence.setInt(1, pri.getPrizeId());

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

	@Override
	public int deletePrize(Prize pri, boolean cascade) {
		// TODO Auto-generated method stub
		return 0;
	}

}
