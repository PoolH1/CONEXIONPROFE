package conexión;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexiónMySQL {
public static Connection getConexión() {
	Connection cnx=null;
	try {
		//adjuntar driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver correcto");
		cnx=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/BD_VENTA_ACCESORIOS_2025","root","tuff"
				);
		System.out.println("conexión correcta");
	} catch (Exception e) {
		System.out.println("Error: "+e);
	}
	return cnx;
}
	public static void main(String[] args) {
		getConexión();
	}

}
