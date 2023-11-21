package dao;

public final class ErrorManager {
	
	private static String message = "Error desconegut";
	static final String FATAL_ERROR = "Error desconegut";
	static final String CLAU_DUP = " duplicat/a"; 

	public static String getMessage(int codi, String model) {
		switch (codi) {
			case -1062: 
				return model + CLAU_DUP;
			default: 
				return message;
		}
	}



}
