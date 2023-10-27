package dao;

import java.util.ArrayList;

import model.Empleat;

public interface EmpleatDAO {
	/*CRUD operations*/
	/*Create*/
	public int addEmpleat(Empleat em);
	
	/*Read*/
	public Empleat getEmpleatById(Integer Id, boolean ambEmpleats);
	
	/*Update*/
	public int updateEmpleat(Empleat em);
	
	/*Delete*/
	public int deleteEmpleat(Empleat em, boolean cascade);
	
	/*Consultes a demanda*/
	public ArrayList<Empleat> listEmpleats();
}
