package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Departament;
import model.Empleat;

public class EmpleatDAOJDBC implements EmpleatDAO {
	// CRUD
	// Create
	@Override
	public int addEmpleat(Empleat em) {
		Boolean isConnectionOpen = false;
		
		String sql ="INSERT INTO empleados(emp_no, apellido, salario, comision, oficio, dir, fecha_alt, dept_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected(); // posem a true la bool si la connexió està encesa
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			// Bindejem a cada ? el valor que volem afegir al statement
			sentencia.setInt(1, em.getCodiEmpleat()); 
			sentencia.setString(2, em.getCognomEmpleat());
			sentencia.setDouble(3, em.getSalariEmpleat());
			sentencia.setDouble(4, em.getComisioEmpleat());
			sentencia.setString(5, em.getOficiEmpleat());
			sentencia.setInt(6, em.getCapEmpleat());
			sentencia.setDate(7, em.getDataAltaEmpleat());
			sentencia.setInt(8, em.getDepartamentEmpleat().getCodiDepartament());
			
			int resultat = sentencia.executeUpdate();
			return resultat;
			
		} catch (SQLException e) {
			if (e.getErrorCode()==1062){
				
				//PK repetida
				return e.getErrorCode() * -1;
			} else {
				e.printStackTrace();
				return -1;
			}
		} finally {
			if(!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}
	
	// Read
	@Override
	public Empleat getEmpleatById(Integer Id) {
		Boolean isConnectionOpen = false;
		
		String sql = "SELECT emp_no, apellido, salario, comision, oficio, dir, fecha_alt, dept_no FROM empleados WHERE emp_no = ?";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			// bindejar valors
			sentencia.setInt(1, Id);
			
			ResultSet resultat = sentencia.executeQuery();
			
			DepartamentDAO depDAO = DAOManager.getDepDAO();
			Departament empDept = new Departament();
			
			empDept = depDAO.getDepartamentById(resultat.getInt(8), false);
			
			Empleat empResultat = new Empleat();
			
			empResultat.setCodiEmpleat(Id);
			empResultat.setCognomEmpleat(resultat.getString(2));
			empResultat.setSalariEmpleat(resultat.getDouble(3));
			empResultat.setComisioEmpleat(resultat.getDouble(4));
			empResultat.setOficiEmpleat(resultat.getString(5));
			empResultat.setCapEmpleat(resultat.getInt(6));
			empResultat.setDataAltaEmpleat(resultat.getDate(7));
			empResultat.setDepartamentEmpleat(empDept);

			return empResultat;
			
		} catch (SQLException e) {
			if (e.getErrorCode()==1062){
				return null;
				
			} else {
				e.printStackTrace();
				return null;
			}
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}

	// Update
	@Override
	public int updateEmpleat(Empleat em) {
		// TODO Auto-generated method stub
		return 0;
	}
	 // Delete
	@Override
	public int deleteEmpleat(Empleat em, boolean cascade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Empleat> listEmpleats() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
