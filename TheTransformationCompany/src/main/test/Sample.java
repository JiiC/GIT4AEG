package main.test;

import java.util.ArrayList;
import java.util.List;

import main.java.Battle;
import main.java.Transformer;
import main.java.Type;

public class Sample {
	 public static void main(String[] args) {
	        System.out.println("The Transformation Company \n==========================\n");
	        

	        // given example 
	        Transformer soundWave = new Transformer(Type.DECEPTICON,
	        		"Soundwave", 8, 9, 2, 6, 7, 5, 6, 10);
	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
	        		"Bluestreak",  6, 6, 7, 9, 5, 2, 9, 7);
	        Transformer hubCap = new Transformer(Type.AUTOBOT,
	        		"Hubcap", 4, 4, 4, 4, 4, 4, 4, 4);
	        
	        //courage and strengh case
//	        Transformer soundWave = new Transformer(Type.DECEPTICON,
//	        		"Soundwave", 5, 1, 1, 1, 1, 4, 1, 1);
//	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
//	        		"Bluestreak", 1, 1, 1, 1, 1, 1, 1, 1);

	        // skill case
//	        Transformer soundWave = new Transformer(Type.DECEPTICON,
//	        		"Soundwave", 1, 1, 1, 1, 1, 1, 1, 4);
//	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
//	        		"Bluestreak", 1, 1, 1, 1, 1, 1, 1, 1);

	        // overall rating case
//	        Transformer soundWave = new Transformer(Type.DECEPTICON,
//	        		"Soundwave", 1, 1, 1, 1, 1, 1, 1, 1);
//	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
//	        		"Bluestreak", 1, 1, 1, 1, 1, 1, 2, 1);

	        // tie case
//	        Transformer soundWave = new Transformer(Type.DECEPTICON,
//	        		"Soundwave", 1, 1, 1, 1, 1, 1, 1, 1);
//	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
//	        		"Bluestreak", 1, 1, 1, 1, 1, 1, 1, 1);

	        // favoritism case 1
//	        Transformer predaking = new Transformer(Type.DECEPTICON,
//	        		FavoritismName.PREDAKING.getLabel(), 10, 5, 10, 8, 7, 9, 9, 8);
//	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
//	        		"Bluestreak", 6, 6, 7, 9, 5, 2, 9, 7);
//	        Transformer hubCap = new Transformer(Type.AUTOBOT,
//	        		"Hubcap", 4, 4, 4, 4, 4, 4, 4, 4);

	        // favoritism case 2
//	        Transformer predaking = new Transformer(Type.DECEPTICON,
//	        		FavoritismName.PREDAKING.getLabel(), 10, 5, 10, 8, 7, 9, 9, 8);
//	        Transformer optimusPrime = new Transformer(Type.AUTOBOT,
//	        		FavoritismName.OPTIMUS_PRIME.getLabel(), 10, 10, 8, 8, 8, 10, 10, 8);
//	        Transformer blueStreak = new Transformer(Type.AUTOBOT,
//	        		"Bluestreak", 6, 6, 7, 9, 5, 2, 9, 7);

	        // big battle case - orderer by rank-winner
	        // round1: overall A=29 D=34
//	        Transformer d3 = new Transformer(Type.DECEPTICON,
//	        		"D3", 10, 3, 6, 9, 10, 5, 6, 7);
//	        Transformer a2 = new Transformer(Type.AUTOBOT,
//	        		"A2", 8, 8, 3, 5, 10, 4, 5, 9);
//	        // round2: skill
//	        Transformer a4 = new Transformer(Type.AUTOBOT,
//	        		"A4", 3, 10, 8, 8, 9, 2, 9, 4);
//	        Transformer d4 = new Transformer(Type.DECEPTICON,
//	        		"D4", 6, 8, 8, 10, 8, 3, 1, 1);
//	        // round3: overall A=29 D=34
//	        Transformer d1 = new Transformer(Type.DECEPTICON,
//	        		"D1", 7, 7, 7, 9, 2, 6, 4, 9);
//	        Transformer a3 = new Transformer(Type.AUTOBOT,
//	        		"A3", 6, 2, 5, 9, 8, 4, 7, 7);
//	        // round4: overall A=14 D=36
//	        Transformer a5 = new Transformer(Type.AUTOBOT,
//	        		"A5", 3, 8, 1, 2, 6, 2, 9, 7);
//	        Transformer d2 = new Transformer(Type.DECEPTICON,
//	        		"D2", 9, 7, 8, 4, 1, 4, 8, 8);
//	        // not fighting
//	        Transformer a1 = new Transformer(Type.AUTOBOT,
//	        		"A1", 3, 6, 5, 9, 2, 4, 7, 7);
	        
	        List<Transformer> autobots= new ArrayList<Transformer>();
	        List<Transformer> decepticons = new ArrayList<Transformer>();
//	        autobots.add(a1);
//	        autobots.add(a2);
//	        autobots.add(a3);
//	        autobots.add(a4);
//	        autobots.add(a5);
	        autobots.add(blueStreak);
	        autobots.add(hubCap);
//	        autobots.add(optimusPrime);
	        decepticons.add(soundWave);
//	        decepticons.add(predaking);
//	        decepticons.add(d1);
//	        decepticons.add(d2);
//	        decepticons.add(d3);
//	        decepticons.add(d4);
	        
	        
	        fight(autobots, decepticons);
	 }
	 
	 private static void fight(List<Transformer> autobots, List<Transformer> decepticons) {
	        Battle battle = new Battle(autobots, decepticons);
	        battle.fight();
	        battle.displayResult();
	 }
}
