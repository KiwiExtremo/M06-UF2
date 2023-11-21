package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Candidate;
import model.Prize;

public class CandidateDAOJDBC implements CandidateDAO {
	// CRUD operations:

	// Create:
	@Override
	public int addCandidate(Candidate cand) {
		Boolean isConnectionOpen = false;

		String sql = "INSERT INTO candidates(candidateId, firstName, lastName, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind values
			sentence.setInt(1, cand.getCandidateId());
			sentence.setString(2, cand.getFirstName());
			sentence.setString(3, cand.getLastName());
			sentence.setString(4, cand.getPhoneNumber());
			sentence.setString(5, cand.getEmail());

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
	public Candidate getCandidateById(int candId, boolean withPrizes) {
		Boolean isConnectionOpen = false;

		String sql = "SELECT candidateId, firstName, lastName, phoneNumber, email FROM candidates WHERE candidateId = ?";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind value
			sentence.setInt(1, candId);

			ResultSet result = sentence.executeQuery();

			// create placeholder candidate
			Candidate resultCandidate = new Candidate();

			while (result.next()) {
				// bind results into placeholder candidate
				resultCandidate.setCandidateId(candId);
				resultCandidate.setFirstName(result.getString(2));
				resultCandidate.setLastName(result.getString(3));
				resultCandidate.setPhoneNumber(result.getString(4));
				resultCandidate.setEmail(result.getString(5));
			}
			if (withPrizes) {
				ArrayList<Prize> listPrizes = listPrizesByCandidate(candId);

				resultCandidate.setPrizeList(listPrizes);
			}

			return resultCandidate;

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

	// Update
	@Override
	public int updateCandidate(Candidate cand) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Delete:
	@Override
	public int deleteCandidate(Candidate cand, boolean cascade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Candidate> CandidateList() {
		Boolean isConnectionOpen = false;

		String sql = "SELECT candidateId, firstName, lastName, phoneNumber, email FROM candidates";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			ResultSet result = sentence.executeQuery();

			// create array
			ArrayList<Candidate> listCandidates = new ArrayList<Candidate>();

			while (result.next()) {
				// create placeholder candidate
				Candidate candidate = new Candidate();
				
				// bind results into placeholder prize
				candidate.setCandidateId(result.getInt(1));
				candidate.setFirstName(result.getString(2));
				candidate.setLastName(result.getString(3));
				candidate.setPhoneNumber(result.getString(4));
				candidate.setEmail(result.getString(5));
				
				// add current candidate from placeholder into array
				listCandidates.add(candidate);
			}

			return listCandidates;

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
	public ArrayList<Prize> listPrizesByCandidate(int candId) {
		Boolean isConnectionOpen = false;

		String sql = "SELECT candidateId, prizeId, prizeTypeId, Year FROM prizes WHERE candidateId = ?";

		try {
			isConnectionOpen = ConnectionManager.isConnected();

			Connection connection = ConnectionManager.getConnection();

			PreparedStatement sentence = connection.prepareStatement(sql);

			// bind value
			sentence.setInt(1, candId);

			ResultSet result = sentence.executeQuery();

			// create array
			ArrayList<Prize> listPrizes = new ArrayList<Prize>();

			while (result.next()) {
				// create placeholder prize
				Prize prize = new Prize();
				
				// bind results into placeholder prize
				prize.setCandidateId(candId);
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
