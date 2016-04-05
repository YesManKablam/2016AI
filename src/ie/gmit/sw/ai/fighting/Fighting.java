package ie.gmit.sw.ai.fighting;

import net.sourceforge.jFuzzyLogic.FIS;

public class Fighting {
	public double damage;
	
	public double fighting(int strength, int baddie){
		System.out.println(strength + " " + baddie);
		FIS fis = FIS.load("fcl/fight.fcl", true);
		
		fis.setVariable("strength", strength);
		fis.setVariable("baddie", baddie);
		fis.evaluate();

		damage = fis.getVariable("damage").getValue();
		System.out.println(damage + " damage taken");
		
		return damage;
	}
}
