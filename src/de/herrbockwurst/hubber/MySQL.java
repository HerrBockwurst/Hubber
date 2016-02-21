package de.herrbockwurst.hubber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.herrbockwurst.hubber.Main;

public class MySQL {
	
	private static Main main = Main.thisclass;
	
	public static String host = main.lobbys.getString("MySQL.host");
	public static String port = main.lobbys.getString("MySQL.port");
	public static String db = main.lobbys.getString("MySQL.database");
	public static String user = main.lobbys.getString("MySQL.user");
	public static String pass = main.lobbys.getString("MySQL.pass");
	public static Connection con;
	
	public static void connect() {
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pass);
				System.out.println(Methods.getPluginName(true) + " " + main.lang.getString("MySQL.conOK"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println(Methods.getPluginName(true) + " " + main.lang.getString("MySQL.disconnected"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	public static void query(String query) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet getResult(String query) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
