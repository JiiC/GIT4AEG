package main.java;

public enum Type {
	AUTOBOT,
	DECEPTICON;
	
	public static Type getOppositeType(Type type) {
		if (type != null) {
			if (type.equals(AUTOBOT)) return DECEPTICON;
			else return AUTOBOT;
		}
		return null;
	}
}
