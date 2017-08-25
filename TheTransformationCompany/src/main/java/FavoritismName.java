package main.java;

public enum FavoritismName {
	OPTIMUS_PRIME("Optimus Prime"),
	PREDAKING("Predaking");
	
	private String label;
	

	private FavoritismName(String label) {
		this.label = label;
	}
	
	public static boolean isFavoritismName(String name) {
		if (name == null || name == "") {
			return false;
		}
		for (FavoritismName favoritismName : FavoritismName.values()) {
			if (name.equalsIgnoreCase(favoritismName.getLabel())) {
				return true;
			}
		}
		return false;
	}

	public String getLabel() {
		return label;
	}
	
}
