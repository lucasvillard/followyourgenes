package fig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private volatile static Connect conn;
	private String url = "jdbc:sqlite:database\\test1.db";
    private String user = "postgres";
    private String passwd = "Follow$Your&Genes*2017!";
	private Connection connection;
		
		private Connect() throws SQLException {
			this.setConnection(DriverManager.getConnection(url));
	  }
		
		public Connection getConnection() {
			return connection;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}

		public static Connect getInstance(){
		    if(conn == null){
		      synchronized(Connect.class){
		        if(conn == null)
					try {
						conn = new Connect();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      }
		    }      
		    return conn;
		  }	
		
	//CTRL + SHIFT + O pour générer les imports
	  public static void main(String[] args) {      
	    try {
	      Class.forName("org.postgresql.Driver");
	      System.out.println("Driver O.K.");

	      Connect conn = Connect.getInstance();
	      
	      System.out.println("Connexion effective !");         
	               
	            //Création d'un objet Statement
	            Statement state = conn.getConnection().createStatement();
	            Connect conn2 = Connect.getInstance();
	            //L'objet ResultSet contient le résultat de la requête SQL
	            ResultSet result = state.executeQuery("SELECT * FROM departementfr");
	            //On récupère les MetaData
	            ResultSetMetaData resultMeta = result.getMetaData();
	               
	            System.out.println("\n**********************************");
	            //On affiche le nom des colonnes
	            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	              System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	               
	            System.out.println("\n**********************************");
	               
	            while(result.next()){         
	              for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	                System.out.print("\t" + result.getObject(i).toString() + "\t |");
	                  
	              System.out.println("\n---------------------------------");

	            }

	            result.close();
	            state.close();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }      
	  
	  }}

