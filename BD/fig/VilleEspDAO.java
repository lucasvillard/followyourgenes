package fig;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class VilleEspDAO extends DAO<VilleEsp> {

	private ArrayList <String> n;

	public VilleEspDAO(Connect connect) {
		super(connect);
	}


	@Override
	public boolean update(VilleEsp obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public VilleEsp findByCodePost(String codepost) {
		VilleEsp ville = new VilleEsp();
		try {
			ResultSet result = this.connect.getConnection()
					.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM autovilleesp WHERE codepostale = " + codepost.trim());
			if (result.first()) {
				System.out.println(result.getString("codecommune"));
				ville = new VilleEsp(result.getString("codecommune"), result.getString("ville"), codepost,
						findDepNum(result.getString("departement"))

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}

	public VilleEsp findByVille(String nom) {
		VilleEsp ville = new VilleEsp();
		try {

			String query = "SELECT * FROM autovilleesp WHERE UPPER(ville) = UPPER(?)";
			PreparedStatement prepare = this.connect.getConnection().prepareStatement(query);
			prepare.setObject(1, nom.trim(), Types.VARCHAR);
			System.out.println(prepare.toString());
			ResultSet result = prepare.executeQuery();
			// Statement state =
			// this.connect.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// ResultSet result = this.connect.getConnection().createStatement(
			// ResultSet.TYPE_SCROLL_INSENSITIVE,
			// ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM autoVilleEsp WHERE
			// codepostale = " + codepost);
			if (result.next()) {
				ville = new VilleEsp(result.getString("codepostal"), result.getString("ville"),
						result.getString("provinces"), findDepNum(result.getString("provinces"))

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}

	private String findDepNum(String numdep) throws SQLException {
		ResultSet result = this.connect.getConnection()
				.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
				.executeQuery("SELECT nomdep FROM departementesp WHERE numerodep = " + "'" + numdep.trim() + "'");
		if (result.next()) {
			return result.getString("nomdep");
		}
		return numdep;
	}
	private String findDepName(String nomdep) {
		ResultSet result = null;
		try {
			result = this.connect.getConnection()
					.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT numerodep FROM departementesp WHERE nomdep = " + "'" + nomdep.trim() + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (result.next()) {
				return result.getString("numerodep");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomdep;
	}

	public ArrayList<String> autoVille(String nom) {
		ArrayList<String> n = new ArrayList<String>();
		if(nom.length()>2) {
		try {
			Statement state = this.connect.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT ville FROM autovilleesp WHERE UPPER(ville) LIKE UPPER('"+nom+"%') LIMIT 5;";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				n.add(result.getString("ville"));
			}
			return n;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return n;
	}
	public ArrayList<String> autoVilleDep(String nom, String nomdep){
		ArrayList<String> n = new ArrayList<String>();
		String numdep=null;
		numdep = findDepName(nomdep);
		if(nom.length()>2) {
		try {
			Statement state = this.connect.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT ville FROM autovilleesp WHERE UPPER(ville) LIKE UPPER('"+nom+"%') AND departement = '"+numdep+"' LIMIT 5;";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				n.add(result.getString("ville"));
			}
			return n;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return n;
	}

	@Override
	public VilleEsp find(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		Connect conn = Connect.getInstance();
		VilleEspDAO ville = new VilleEspDAO(conn);
		ArrayList<String> l = ville.autoVille("Barcelona");
		for (String string : l) {
			System.out.println(string);
		}
		VilleEsp viesp= ville.findByVille("Barcelone");
		System.out.println(viesp.getNomVille());
		System.out.println(viesp.getNomdep());
	}
}
