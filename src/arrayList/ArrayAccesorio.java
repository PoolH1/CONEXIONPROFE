package arrayList;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clase.Accesorio;
import conexión.ConexiónMySQL;

public class ArrayAccesorio {
public ArrayList<Accesorio> listarAccesorio(){
	ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
	try {
		CallableStatement csta=ConexiónMySQL.getConexión().prepareCall("{call sp_Listar()}");
		ResultSet rs=csta.executeQuery();
		Accesorio acce;
		while (rs.next()) {
			acce=new Accesorio(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDouble(4) , rs.getInt(5));
			lista.add(acce);
		}
	} catch (Exception e) {}
	return lista;
}
public ArrayList<Accesorio> ConsultarCod(String cod){
	ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
	try {
		Connection cnx=ConexiónMySQL.getConexión();
		CallableStatement csta=cnx.prepareCall("{call sp_ConsultarCod(?)}");
		csta.setString(1, cod);
		ResultSet rs=csta.executeQuery();
		Accesorio acce;
		while (rs.next()) {
			acce=new Accesorio(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDouble(4) , rs.getInt(5));
			lista.add(acce);
		}
	} catch (Exception e) {}
	return lista;
}
public ArrayList<Accesorio> consultarAccesorio(String nom){
	ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
	try {
		java.sql.Statement sta=ConexiónMySQL.getConexión().createStatement();
		//ResultSet rs=sta.executeQuery("Select * from Accesorio where nom_acce like %" +nom+"%");incorrecto
		ResultSet rs=sta.executeQuery("Select * from Accesorio where nom_acce like '%" +nom+"%'"); //correcto
		Accesorio acce;
		while (rs.next()) {
			acce=new Accesorio(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDouble(4) , rs.getInt(5));
			lista.add(acce);
		}
	} catch (Exception e) {
	}
	return lista; 
}
public void insertar(Accesorio acce) {
	try {
		Connection cnx=ConexiónMySQL.getConexión();
		CallableStatement csta=cnx.prepareCall("{call sp_Insertar(?,?,?,?,?)}");
		csta.setString(1,acce.getCodAcce());
		csta.setString(2,acce.getNomAcce());
		csta.setString(3,acce.getMarcaAcce());
		csta.setDouble(4,acce.getPreAcce());
		csta.setInt(5,acce.getStockAcce());
		csta.executeUpdate();
	} catch (Exception e) {
		System.out.println("ERROR "+e);
	}
}
public void eliminar(String cod) {
	try {
		Connection cnx=ConexiónMySQL.getConexión();
		CallableStatement csta=cnx.prepareCall("{call sp_Eliminar(?)}");
		csta.setString(1, cod);
		csta.executeUpdate();
	} catch (Exception e) {
		System.out.println("ERROR "+e);
	}
}
public void editar(Accesorio acce) {
	try {
		Connection cnx=ConexiónMySQL.getConexión();
		CallableStatement csta=cnx.prepareCall("{call sp_Editar(?,?,?,?,?)}");
		csta.setString(1,acce.getCodAcce());
		csta.setString(2,acce.getNomAcce());
		csta.setString(3,acce.getMarcaAcce());
		csta.setDouble(4,acce.getPreAcce());
		csta.setInt(5,acce.getStockAcce());
		csta.executeUpdate();
	} catch (Exception e) {
		System.out.println("ERROR "+e);
	}
}
}


