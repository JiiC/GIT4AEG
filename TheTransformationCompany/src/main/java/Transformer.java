package main.java;

import java.util.Comparator;

public class Transformer {

	private Type type;
	private String name;
	private int strengh;
	private int intelligence;
	private int speed;
	private int endurance;
	private int rank;
	private int courage;
	private int firepower;
	private int skill;
	private Integer overallRating;
	private static final int RATE_MIN = 1;
	private static final int RATE_MAX = 10;
	
	public static final Comparator<Transformer> RANK_COMPARATOR = new Comparator<Transformer>() {
		@Override
		public int compare(Transformer transformer1, Transformer transformer2) {
			return transformer2.getRank() - transformer1.getRank();
		}
	};

	/**
	 * Constructor
	 * @param type
	 * @param name
	 * @param strengh
	 * @param intelligence
	 * @param speed
	 * @param endurance
	 * @param rank
	 * @param courage
	 * @param firepower
	 * @param skill
	 */
	public Transformer(Type type, String name, int strengh, int intelligence, int speed, int endurance, int rank,
			int courage, int firepower, int skill) {
		super();
		this.type = type;
		this.name = name;
		this.strengh = strengh;
		this.intelligence = intelligence;
		this.speed = speed;
		this.endurance = endurance;
		this.rank = rank;
		this.courage = courage;
		this.firepower = firepower;
		this.skill = skill;
	}


	public Integer overallRating() {
		if (overallRating == null) 
			overallRating = strengh + intelligence + speed + endurance + firepower;
		return overallRating;
	}

	
	public boolean checkTransformer() {
		if (type == null)
			return false;
		if (strengh < RATE_MIN || strengh > RATE_MAX)			
			return false;
		if (intelligence < RATE_MIN || intelligence > RATE_MAX)			
			return false;
		if (speed < RATE_MIN || speed > RATE_MAX)			
			return false;
		if (endurance < RATE_MIN || endurance > RATE_MAX)			
			return false;
		if (rank < RATE_MIN || rank > RATE_MAX)			
			return false;
		if (courage < RATE_MIN || courage > RATE_MAX)			
			return false;
		if (firepower < RATE_MIN || firepower > RATE_MAX)			
			return false;
		if (skill < RATE_MIN || skill > RATE_MAX)			
			return false;
		return true;
		
	}
	


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrengh() {
		return strengh;
	}


	public void setStrengh(int strengh) {
		this.strengh = strengh;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getEndurance() {
		return endurance;
	}


	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getCourage() {
		return courage;
	}


	public void setCourage(int courage) {
		this.courage = courage;
	}


	public int getFirepower() {
		return firepower;
	}


	public void setFirepower(int firepower) {
		this.firepower = firepower;
	}


	public int getSkill() {
		return skill;
	}


	public void setSkill(int skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Transformer [type=" + type + ", name=" + name + ", strengh=" + strengh + ", intelligence="
				+ intelligence + ", speed=" + speed + ", endurance=" + endurance + ", rank=" + rank + ", courage="
				+ courage + ", firepower=" + firepower + ", skill=" + skill + "]";
	}
	
	
	
}
