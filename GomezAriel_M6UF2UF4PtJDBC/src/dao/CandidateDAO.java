package dao;

import java.util.ArrayList;

import model.Candidate;
import model.Prize;

public interface CandidateDAO {
	// CRUD Operations:

	// Create:
	public int addCandidate(Candidate cand);

	// Read:
	public Candidate getCandidateById(int candId, boolean withPrizes);

	// Update:
	public int updateCandidate(Candidate cand);

	// Delete:
	public int deleteCandidate(Candidate cand, boolean cascade);

	// Extra queries:
	public ArrayList<Candidate> CandidateList();
	public ArrayList<Prize> listPrizesByCandidate(int candId);

}