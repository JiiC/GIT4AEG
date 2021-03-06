package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Aequilibrium technical dev assessment
 * 
 * @author JC Bernat - AUG 25 2017
 *
 *         Aequilibrium does love transforming… people, lives, teams, companies.
 *         And there’s no better representation of transformation than Hasbro’s
 *         Transformers , the classic television series featuring heroic
 *         Autobots raging their battle to destroy the evil forces of the
 *         Deceptions. Please watch this video:
 *         https://www.youtube.com/watch?v=nLS2N9mHWaw And write the following
 *         in whatever language you like: The Transformers are at war and you
 *         are in charge of settling the score! You’re to evaluate who wins a
 *         fight between the Autobots and the Decepticons. Here are the rules.
 *         Each Transformer has the following criteria on their tech spec (see
 *         http://www.ntfa.net/ntfa/techspecs/index.php?cat=Gen1&group=DeceptPZ&char=Predaking
 *         for an example): ● Strength ● Intelligence ● Speed ● Endurance ● Rank
 *         ● Courage ● Firepower ● Skill All of these criteria are ranked from 1
 *         to 10. The “overall rating” of a Transformer is the following
 *         formula: (Strength + Intelligence + Speed + Endurance + Firepower)
 *         Each Transformer must either be an Autobot or a Deception. Your
 *         program should take input that describes a group of Transformers and
 *         based on that group displays: a. The number of battles b. The winning
 *         team c. The surviving members of the losing team The basic rules of
 *         the battle are: ● The teams should be sorted by rank and faced off
 *         one on one against each other in order to determine a victor, the
 *         loser is eliminated ● A battle between opponents uses the following
 *         rules: ○ If any fighter is down 4 or more points of courage and 3 or
 *         more points of strength compared to their opponent, the opponent
 *         automatically wins the face-off regardless of overall rating
 *         (opponent has ran away) ○ Otherwise, if one of the fighters is 3 or
 *         more points of skill above their opponent, they win the fight
 *         regardless of overall rating ○ The winner is the Transformer with the
 *         highest overall rating ● In the event of a tie, both Transformers are
 *         considered destroyed ● Any Transformers who don’t have a fight are
 *         skipped (i.e. if it’s a team of 2 vs. a team of 1, there’s only going
 *         to be one battle) ● The team who eliminated the largest number of the
 *         opposing team is the winner Special rules: ● Any Transformer named
 *         Optimus Prime or Predaking wins his fight automatically regardless of
 *         any other criteria ● In the event either of the above face each other
 *         (or a duplicate of each other), the game immediately ends with all
 *         competitors destroyed For example, given the following input:
 *         Soundwave, D, 8,9,2,6,7,5,6,10 Bluestreak, A, 6,6,7,9,5,2,9,7 Hubcap:
 *         A, 4,4,4,4,4,4,4,4 The output should be: 1 battle Winning team
 *         (Decepticons): Soundwave Survivors from the losing team (Autobots):
 *         Hubcap
 */
public class Battle {
	private Map<Status, List<Transformer>> autobots;
	private Map<Status, List<Transformer>> decepticons;
	private int fights;
	private static final byte DELTA_COURAGE = 4;
	private static final byte DELTA_STRENGH = 3;
	private static final byte DELTA_SKILL = 3;
	private BattleStatus status = BattleStatus.OFF;
	private boolean completeDestroy = false;
	
	public Battle(List<Transformer> autobots, List<Transformer> decepticons) {
		super();
		init();
		if (checkFighters(autobots)) {
			System.out.println("autobots qualified");
			autobots.sort(Transformer.RANK_COMPARATOR);
			this.autobots.put(Status.READY, autobots);
		}
		if (checkFighters(decepticons)) {
			System.out.println("decepticons qualified");
			decepticons.sort(Transformer.RANK_COMPARATOR);
			this.decepticons.put(Status.READY, decepticons);
		}	
		status =  BattleStatus.READY;
	}
	
	private void init() {
		System.out.println("\ninitialisation...");
		autobots = new HashMap<Status, List<Transformer>>();
		decepticons = new HashMap<Status, List<Transformer>>();
		for (Status status : Status.values()) {
			autobots.put(status, new ArrayList<Transformer>());
			decepticons.put(status, new ArrayList<Transformer>());
		}
	}

	public void fight() {
		System.out.println("\nfighting...");
		status =  BattleStatus.ON;
		fights = 0;
		
		Boolean keepFighting = true;
		do {
			Iterator<Transformer> iter =  autobots.get(Status.READY).iterator();
			Transformer autobot = iter.next();
			iter = decepticons.get(Status.READY).iterator();
			Transformer decepticon = iter.next();

			fights++;
			System.out.println("round " + fights + ":\n\t" + autobot.toString() + "\n\tVS\n\t" + decepticon.toString());
			roundFight(autobot, decepticon);
			
			if (autobots.get(Status.READY).size() <= 0 ||
				decepticons.get(Status.READY).size() <= 0 ) {
				keepFighting = false;
			} 
		} while (keepFighting);
		status =  BattleStatus.OVER;
		
	}

	/**
	 * Return true is keep fighting, false if not,
	 * @param indexAutobot
	 * @param indexDeception
	 * @return
	 */
	public void roundFight(Transformer autobot, Transformer decepticon) {
		// special rule
		if (FavoritismName.isFavoritismName(autobot.getName()) || FavoritismName.isFavoritismName(decepticon.getName())) {
			// end of the game, all competitors destroyed
			if (FavoritismName.isFavoritismName(autobot.getName()) && FavoritismName.isFavoritismName(decepticon.getName())) {
				for (Transformer transformer : autobots.get(Status.READY)) {
					autobots.get(Status.ELIMINATED).add(transformer);
				}
				autobots.get(Status.READY).clear();
				for (Transformer transformer : autobots.get(Status.WINNER)) {
					autobots.get(Status.ELIMINATED).add(transformer);
				}
				autobots.get(Status.WINNER).clear();
				for (Transformer transformer : decepticons.get(Status.READY)) {
					decepticons.get(Status.ELIMINATED).add(transformer);
				}
				decepticons.get(Status.READY).clear();
				for (Transformer transformer : decepticons.get(Status.WINNER)) {
					decepticons.get(Status.ELIMINATED).add(transformer);
				}
				decepticons.get(Status.WINNER).clear();
				completeDestroy = true;
			} else if (FavoritismName.isFavoritismName(autobot.getName()) && !FavoritismName.isFavoritismName(decepticon.getName())) {
				autobots.get(Status.WINNER).add(autobot);
				autobots.get(Status.READY).remove(autobot);
				decepticons.get(Status.ELIMINATED).add(decepticon);
				decepticons.get(Status.READY).remove(decepticon);
			} else if (!FavoritismName.isFavoritismName(autobot.getName()) && FavoritismName.isFavoritismName(decepticon.getName())) {
				autobots.get(Status.ELIMINATED).add(autobot);
				autobots.get(Status.READY).remove(autobot);
				decepticons.get(Status.WINNER).add(decepticon);
				decepticons.get(Status.READY).remove(decepticon);
			}
			
		} 
		// courage and strengh rules
		else if (autobot.getCourage() - decepticon.getCourage() >= DELTA_COURAGE
				&& autobot.getStrengh() - decepticon.getStrengh() >= DELTA_STRENGH) {
			autobots.get(Status.WINNER).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.ELIMINATED).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);
		} else if (autobot.getCourage() - decepticon.getCourage() <= -DELTA_COURAGE
				&& autobot.getStrengh() - decepticon.getStrengh() <= -DELTA_STRENGH) {
			autobots.get(Status.ELIMINATED).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.WINNER).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);
		}
		// skill rule
		else if (autobot.getSkill() - decepticon.getSkill() >= DELTA_SKILL) {
			autobots.get(Status.WINNER).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.ELIMINATED).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);	
		} else if (autobot.getSkill() - decepticon.getSkill() <= -DELTA_SKILL) {
			autobots.get(Status.ELIMINATED).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.WINNER).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);
		} 
		// overall rating
		else if (autobot.overallRating() == decepticon.overallRating()) {
			autobots.get(Status.ELIMINATED).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.ELIMINATED).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);
		} else if (autobot.overallRating() > decepticon.overallRating()) {
			autobots.get(Status.WINNER).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.ELIMINATED).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);
		} else {
			autobots.get(Status.ELIMINATED).add(autobot);
			autobots.get(Status.READY).remove(autobot);
			decepticons.get(Status.WINNER).add(decepticon);
			decepticons.get(Status.READY).remove(decepticon);	
		}
	}

	private boolean checkFighters(List<Transformer> fighters) {
		// the team exists and has fighters
		if (fighters == null || fighters.isEmpty()) {
			System.err.println("Team error");
			return false;
		}
		
		// check each fighter
		for (Transformer transformer : fighters) {
			if (!transformer.checkTransformer()) {
				System.err.println("Fighter error: " + transformer.toString());
				return false;
			}
		}
		
		return true;
	}

	public Type getWinnerTeam() {
		int eliminatedAutobots = autobots.get(Status.ELIMINATED).size();
		int eliminatedDeceptions = decepticons.get(Status.ELIMINATED).size();
		
		if (eliminatedAutobots == eliminatedDeceptions)
			return null;
		if (eliminatedAutobots > eliminatedDeceptions)
			return Type.DECEPTICON;
		else
			return Type.AUTOBOT;
	}
	
	public String getSurvivors(Type team) {
		String ret = "";
		if (team.equals(Type.AUTOBOT)) {
			for (Status status : Status.values()) {
				if (status != Status.ELIMINATED) {
					for (Transformer transformer : autobots.get(status)) {
						ret += transformer.getName() + ", ";
					}
				}
			}
		}
		if (team.equals(Type.DECEPTICON)) {
			for (Status status : Status.values()) {
				if (status != Status.ELIMINATED) {
					for (Transformer transformer : decepticons.get(status)) {
						ret += transformer.getName() + ", ";
					}
				}
			}
		} 
		if (ret == "") ret = "no survivor";
		else ret = ret.substring(0, ret.length() - 2);
		return ret;
	}
	
	public List<Transformer> getFighters(Status status, Type team) {
		if (team.equals(Type.AUTOBOT)) {
			return autobots.get(status);
		} else if (team.equals(Type.DECEPTICON)) {
			return decepticons.get(status);
		}
		return null;
	}
	
	public void displayResult() {
		if (status == BattleStatus.OVER) {
			System.out.println("\nresult...");
			
			if (completeDestroy) {

				System.out.println("That was the clash of titans!\n"
						+ fights + " battle(s)\n"
						+ "no survivors");
			} else {
				Type winnerTeam = getWinnerTeam();
				Type loserTeam = Type.getOppositeType(winnerTeam);
				
				System.out.println("well, well, well...");
				if (winnerTeam == null) 
					System.out.println("That's incredible! Ladies and gentleman, this is a tie! Incredible!\n"
							+ "All fighters are eliminated after " + fights + " fight(s)!");
				else {
					System.out.println("The winner team is the " + winnerTeam.name() + "! Congrats!\n"
							+ fights + " battle(s)\n"
							+ "winning team (" + winnerTeam.name() + "): " + getSurvivors(winnerTeam) + "\n"
							+ "survivors from the losing team (" + loserTeam.name() + "): " + getSurvivors(loserTeam) + "\n");
					
				}
			}
			
		} else {
			System.out.println("too soon or too late, not a good moment for results anyway!");
		}

	}

}
