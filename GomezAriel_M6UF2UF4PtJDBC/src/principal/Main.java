package principal;

import dao.CandidateDAO;
import dao.DAOManager;
import dao.ErrorManager;
import dao.PrizeDAO;
import dao.PrizeTypeDAO;
import model.Candidate;
import model.Prize;
import model.PrizeType;

public class Main {

	public static void main(String[] args) {
		CandidateDAO canDAO = DAOManager.getCandDAO();
		PrizeDAO preDAO = DAOManager.getPriDAO();
		PrizeTypeDAO tipuspreDAO = DAOManager.getPriTypeDAO();

		Candidate c1 = new Candidate(5, "Carlos", "Galera Blazquez", "680519313", "carlos@gmail.com");
		Candidate c2 = new Candidate(6, "Daniel", "Pando Fernandez", "627820317", "daniel@gmail.com");
		PrizeType tp = new PrizeType();
		tp.setPrizeTypeId(2);
		Prize p1 = new Prize(6, c1, tp, 2023);
		Prize p2 = new Prize(7, c2, tp, 2023);

		// 1. Lectura d'un candidat donat una Id
		// Lectura sense premis
		System.out.println(canDAO.getCandidateById(2, false));
		// Lectura amb premis
		System.out.println(canDAO.getCandidateById(2, true));

		// 2. Letura d'un tipus de premi donat una Id
		// Lectura sense premis
		System.out.println(tipuspreDAO.getPrizeTypeById(2, false));
		// Lectura amb premis
		System.out.println(tipuspreDAO.getPrizeTypeById(2, true));

		// 3. Insercio d'un candidat nou
		System.out.println(canDAO.addCandidate(c1));

		// 4. Insercio d'un premi nou

		// Existeix el candidat
		System.out.println(preDAO.addPrize(p1));
		// No existeix el candidat
		System.out.println(preDAO.addPrize(p2));
		// 5. Modificacio d'un premi otorgat
		p1.setCandidateId(c2);
		p1.setYear(2024);
		System.out.println(preDAO.updatePrize(p1));

		// 6. LLista de tots els candidats
		// Sense premis otorgats
		System.out.println(canDAO.CandidateList(false));
		// Amb premis otorgats
		System.out.println(canDAO.CandidateList(true));

		// 7. Esborrat d'un candidat
		System.out.println(canDAO.deleteCandidate(c2, true));

		// 8. Esborrat d'un tipus de premi
		System.out.println(tipuspreDAO.deletePrizeType(tp));

		// 9. Lectura d'un premi donada una id
		System.out.println(preDAO.getPrizeById(2));

		// GESTIO D'ERRORS
		// ERROR 1: Clau duplicada:
		System.out.println(ErrorManager.getMessage(canDAO.addCandidate(c1), c1.getClass().toString()));

		// ERROR 2: Intentar esborrar una clau foranea:
		System.out.println(ErrorManager.getMessage(tipuspreDAO.deletePrizeType(tp), tp.getClass().toString()));

	}

}
