package Clinique_Auto;


import java.sql.*;




public class Connexion
{
	Connection con;
	public Connexion() {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5434/Clinique", "postgres", "123456789");
			System.out.println("BD connectée");
		}
		catch(Exception ex) {
			}
		}
		public Connexion laconnexion(){
			return (Connexion) con;
		}
		public Statement createStatement() {
			
			return null;
		}
	}


