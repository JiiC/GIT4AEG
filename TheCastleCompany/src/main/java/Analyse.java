package main.java;

/**
 * Aequilibrium technical dev assessment
 * 
 * @author JC Bernat - AUG 25 2017
 * 
 *         Aequilibrium is in the business of building castles (we really
 *         aren’t, but let’s pretend). Now, we also believe in quality
 *         aesthetics, so we only want to build castles in two types of places:
 *         a. Peaks b. Valleys Let’s say you have an array of integers that
 *         describes a stretch of land, where each integer represents the
 *         current height of the land. Can you write a function that reads that
 *         array and returns the number of castles that Aequilibrium should
 *         build on that stretch of land? You can write this solution in
 *         whatever language you like. You can make the following assumptions: ●
 *         You can always build a castle at the start of the array, provided it
 *         is non-empty ● We only want to build one castle per peak or valley. ●
 *         A peak is an integer or series of integers that is above the
 *         immediately preceding and following ints. For example, in the
 *         sequence [2,6,6,6,3] the sequence of 3 6s is a peak. ● A valley is an
 *         integer or series of integers that is below the immediately preceding
 *         and following ints. For example, in the sequence [6,1,4] the "1"
 *         would be a valley.
 */
public class Analyse {
	private int[] toAnalyse;
	private int size;
	private int castles;
	private int peaks;
	private int valleys;
	private Orientation orientation;

	public Analyse(int[] toAnalyse) {
		this.toAnalyse = toAnalyse;
		size = 0;
		if (toAnalyse != null)
			size = toAnalyse.length;
		castles = 0;
		peaks = 0;
		valleys = 0;
	}

	public int doAnalyse() {
		String comment = null;
		if (size == 0) {
			comment = "It's hard to build a castle without any land";
		} else if (size == 1) {
			castles++;
			comment = "Your land is quite small, we can still build you 1 castle";
		} else {
			castles++;// always can construct a castle at the start
			int start = 1;
			// specific case of flat land at the start
			if (toAnalyse[start] == toAnalyse[0]) {
				while (start < size && toAnalyse[start] == toAnalyse[start - 1]) {
					start++;
				}
			}
			for (int i = start; i < toAnalyse.length; i++) {
				System.out.println("Analysing index " + i + " value " + toAnalyse[i]);
				int prev = toAnalyse[i - 1];
				int cur = toAnalyse[i];

				if (cur > prev) {
					if (orientation != null && orientation == Orientation.VALLEY)
						valleys++;
					orientation = Orientation.PEAK;
				} else if (cur < prev) {
					if (orientation != null && orientation == Orientation.PEAK)
						peaks++;
					orientation = Orientation.VALLEY;
				} else if (cur == prev) {
					continue;
				}
			}
			castles += peaks + valleys;
			comment = "So... after a strong expertise, we would be pleased to build " + castles
					+ " castle(s) on your land: \n" + "1 at start \n" + peaks + " on peak \n" + valleys + " on valley";
		}
		System.out.println(comment);
		return castles;

	}

}