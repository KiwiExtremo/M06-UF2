package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Departament;
import model.Empleat;

public class DepartamentDAOJDBC implements DepartamentDAO {
	// CRUD:
	// Create
	@Override
	public int addDepartament(Departament d) {
		Boolean isConnectionOpen = false;
		
		String sql ="INSERT INTO departamentos(dept_no,dnombre,loc) VALUES (?,?,?)";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected(); // posem a true la bool si la connexió està encesa
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			// Bindejem a cada ? el valor que volem afegir al statement
			sentencia.setInt(1, d.getCodiDepartament()); 
			sentencia.setString(2, d.getNomDepartament());
			sentencia.setString(3, d.getLlocDepartament());
			
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
	public Departament getDepartamentById(Integer id, boolean ambEmpleats) {
		Boolean isConnectionOpen = false;
		
		String sql = "SELECT dept_no, dnombre, loc FROM departamentos WHERE dept_no = ?";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			// bindejar valors
			sentencia.setInt(1, id);
			
			ResultSet resultat = sentencia.executeQuery();
			
			Departament depResultat = new Departament();
			
			ArrayList<Empleat> listEmp = null;
			
			while (resultat.next()) {
				depResultat.setCodiDepartament(id);
				depResultat.setNomDepartament(resultat.getString(2));
				depResultat.setLlocDepartament(resultat.getString(3));
			}
			
			if (ambEmpleats) {
				listEmp = listEmpleatsByDepartament(id);
				
				depResultat.setLlistaEmpleats(listEmp);
			}
			
			return depResultat;
			
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
	public int updateDepartament(Departament d) {
		Boolean isConnectionOpen = false;
		
		String sql = "UPDATE departamentos WHERE dept_no = ?";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			// Bindejar valors
			sentencia.setInt(1, d.getCodiDepartament());
			
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
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}
	// Delete
	@Override
	public int deleteDepartament(Departament d, boolean cascade) {
		Boolean isConnectionOpen = false;
		
		String sql = "DELETE FROM departamentos WHERE dept_no = ?";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			// Bindejar valors
			sentencia.setInt(1, d.getCodiDepartament());
			
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
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}

	@Override
	public ArrayList<Departament> listDepartaments() {
		ArrayList<Departament> listDept = new ArrayList<>();
		
		Boolean isConnectionOpen = false;
		
		String sql = "SELECT dept_no, dnombre, loc FROM departamentos";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			ResultSet resultat = sentencia.executeQuery();
			
			while (resultat.next()) {
				Departament dept = new Departament();
				
				dept.setCodiDepartament(resultat.getInt(1));
				dept.setNomDepartament(resultat.getString(2));
				dept.setLlocDepartament(resultat.getString(3));
				
				listDept.add(dept);
			}
			
			return listDept;
			
		} catch (SQLException e) {
			return null;
			
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}

	@Override
	public ArrayList<Empleat> listEmpleatsByDepartament(int deptID) {
		ArrayList<Empleat> listEmp = new ArrayList<>();
		
		Boolean isConnectionOpen = false;
		
		String sql = "SELECT emp_no, apellido, dir, fecha_alt, salario, comision, oficio, dept_no FROM empleados WHERE dept_no = ?";
		
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			
			Connection conexio = GestorConnexions.obtenirConnexio();
			
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			
			sentencia.setInt(1, deptID);
			
			ResultSet resultat = sentencia.executeQuery();
			
			while (resultat.next()) {
				Empleat emp = new Empleat();
				
				DepartamentDAO depDao = DAOManager.getDepDAO();
				
				Departament dept = new Departament();
				
				dept = depDao.getDepartamentById(resultat.getInt(8), false);
				
				emp.setCodiEmpleat(resultat.getInt(1));
				emp.setCognomEmpleat(resultat.getString(2));
				emp.setCapEmpleat(resultat.getInt(3));
				emp.setDataAltaEmpleat(resultat.getDate(4));
				emp.setSalariEmpleat(resultat.getDouble(5));
				emp.setComisioEmpleat(resultat.getDouble(6));
				emp.setOficiEmpleat(resultat.getString(7));
				emp.setDepartamentEmpleat(dept);
				
				listEmp.add(emp);
			}
		} catch (SQLException e) {
			return null;
			
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
		return listEmp;
	}


}
