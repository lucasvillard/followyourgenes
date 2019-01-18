package fig;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class PrenomDAO extends DAO<Prenom> {

	private ArrayList <String> n;

	public PrenomDAO(Connect connect) {
		super(connect);
	}


	@Override
	public boolean update(Prenom obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public ArrayList<String> autoPrenom(String nom, String sexe) {
		ArrayList<String> n = new ArrayList<String>();
		if(nom.length()>2) {
		try {
			Statement state = this.connect.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT prenom FROM autoprenom WHERE upper(prenom) LIKE upper('"+nom+"%') AND genre IN('"+sexe.substring(0, 1).toLowerCase()+"','mixte') LIMIT 5;";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				n.add(result.getString("prenom"));
			}
			return n;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return n;
	}

	@Override
	public Prenom find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
