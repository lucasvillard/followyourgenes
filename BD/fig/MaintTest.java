/**
 * 
 */
package fig;

import java.util.ArrayList;

/**
 * @author Villard Lucas
 *
 */
public class MaintTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VilleFrDAO ville = new VilleFrDAO(Connect.getInstance());
		VilleFr villee = ville.findByCodePost("06270");
		ArrayList<String> n = ville.autoVille("b");
		System.out.println(n.size());
		for(int i=0; i<n.size(); i++) {
			System.out.println(n.get(i));
		}
	}

}
