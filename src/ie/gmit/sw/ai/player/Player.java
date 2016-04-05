package ie.gmit.sw.ai.player;

import ie.gmit.sw.ai.fighting.Fighting;

public class Player {
	
	private static int playerHealth = 50;
	private static int strength;
	private int baddie;
	
	public void playerStrength(int strength){
		Player.strength += strength;
		}
	
	public void baddie(int baddie){
		this.baddie = baddie;
	}
	
	public void playerCombat(){
		Fighting f = new Fighting();
		f.fighting(strength, baddie);
		playerHealth -= f.damage;
		System.out.println(playerHealth + " hp");
		if (playerHealth <= 0){
			System.exit(0);
		}
	}
}
