import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import smile.Network;
import smile.SMILEException;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Player> list = new ArrayList<Player>();
		Player james = new Player("Lebron_James", 0.3, 0.7, "Outstanding", 0.7, 0.4);
		Player kobe = new Player("Kobe_Bryant", 0.5, 0.6, "Excellent", 0.7, 0.5);
		list.add(james);
		list.add(kobe);
		
		InfluenceDiagram id = new InfluenceDiagram();
		id.constructDiagram(list);

	}
}
