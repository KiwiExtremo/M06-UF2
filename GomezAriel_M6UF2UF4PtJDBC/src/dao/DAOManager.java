package dao;

public class DAOManager {
	// Candidate manager
	private static CandidateDAO candDAO;
	
	public static CandidateDAO getCandDAO() {
		if (candDAO == null) {
			candDAO = new CandidateDAOJDBC();
		}	
		return candDAO;
	}
	
	// Prize manager
	private static PrizeDAO priDAO;
	
	public static PrizeDAO getPriDAO() {
		if (priDAO == null) {
			priDAO = new PrizeDAOJDBC();
		}
		return priDAO;
	}
	
	// PrizeType manager
	private static PrizeTypeDAO priTypeDAO;
	
	public static PrizeTypeDAO getPriTypeDAO() {
		if (priTypeDAO == null) {
			priTypeDAO = new PrizeTypeDAOJDBC();
		}
		return priTypeDAO;
	}
}
