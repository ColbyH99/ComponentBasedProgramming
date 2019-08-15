package dominoes;

import java.util.ArrayList;
import java.util.List;

public class DominoLowDifferenceStringImpl_Hayes implements Domino 
{
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	
	public static void main(String[] args)
	{
		Domino d = new DominoLowDifferenceStringImpl_Hayes(36);
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(3);
		integerList.add(6);
		Domino d2 = new DominoLowDifferenceStringImpl_Hayes(integerList);
	}
	
	//Calculates lowPipCount and highPipCount from lowPlus8TimesHigh and makes sure they're valid pip counts
	//Calculates difference and then adds difference and lowPipCount to lowDifferenceString
	//Prints the high pip count and low pip count
	//Domino d = new DominoLowDifferenceStringImpl_Hayes(25) --> High Pip Count: 3, Low Pip Count: 1
	//Domino d2 = new DominoLowDifferenceStringImpl_Hayes(54) --> High Pip Count: 6, Low Pip Count: 6
	//Domino d3 = new DominoLowDifferenceStringImpl_Hayes(0) --> High Pip Count: 0, Low Pip Count: 0
	public DominoLowDifferenceStringImpl_Hayes(int lowPlus8TimesHigh)
	{
		assert DominoHighLowSetImpl_Hayes.isLowPlus8TimesHighInteger(lowPlus8TimesHigh) == true: "lowPlus8TimesHigh is not a valid number!";
		int lowPipCount = lowPlus8TimesHigh % 8;
		int highPipCount = (lowPlus8TimesHigh - lowPipCount)/8;
		
		assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT!";
		assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT!";
		assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount!";
		
		int difference = highPipCount - lowPipCount;
		assert -(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) <= difference : "Difference is not valid!";
		assert difference <= (MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) : "Difference is not valid!";
		
		lowDifferenceString = "";
		lowDifferenceString += lowPipCount;
		lowDifferenceString += LOW_DIFFERENCE_DELIMITER;
		lowDifferenceString += difference;
		
		System.out.println("Low Pip Count: " + this.getLowPipCount());
		System.out.println("High Pip Count: " + this.getHighPipCount());
		
	}
	
	public static final int INDEX_OF_HIGH = 0;
	public static final int INDEX_OF_SUM = 1;
	
	//Gets the highPipCount and sum from highSum, then calculates the lowPipCount and difference.
	//Adds lowPipCount and difference to lowDifferenceString and prints high pip count and low pip count
	//Domino d = new DominoLowDifferenceStringImpl_Hayes([3, 4]) --> High Pip Count: 3, Low Pip Count: 1
	//Domino d2 = new DominoLowDifferenceStringImpl_Hayes([6, 12]) --> High Pip Count: 6, Low Pip Count: 6
	//Domino d3 = new DominoLowDifferenceStringImpl_Hayes([0, 0]) --> High Pip Count: 0, Low Pip Count: 0
	public DominoLowDifferenceStringImpl_Hayes(List<Integer> highSum)
	{
		int highPipCount = highSum.get(0);
		int sum = highSum.get(1);
		
		int lowPipCount = sum - highPipCount;
		int difference = highPipCount - lowPipCount;
		
		assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT!";
		assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT!";
		assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount!";
		
		lowDifferenceString = "";
		lowDifferenceString += lowPipCount;
		lowDifferenceString += LOW_DIFFERENCE_DELIMITER;
		lowDifferenceString += difference;
		
		System.out.println("Low Pip Count: " + this.getLowPipCount());
		System.out.println("High Pip Count: " + this.getHighPipCount());
	}
	
	//returns: highPipCount
	//System.out.println("High Pip Count: " + this.getHighPipCount());
	public int getHighPipCount() {
		
		char lowPipCountChar = lowDifferenceString.charAt(0);
		char differenceChar = lowDifferenceString.charAt(2);
		int lowPipCount = Character.getNumericValue(lowPipCountChar);
		int difference = Character.getNumericValue(differenceChar);
		int highPipCount = difference + lowPipCount;
		return highPipCount;
	}

	//returns: lowPipCount
	//System.out.println("Low Pip Count: " + this.getLowPipCount());
	public int getLowPipCount() {
		char lowPipCountChar = lowDifferenceString.charAt(0);
		int lowPipCount = Character.getNumericValue(lowPipCountChar);
		return lowPipCount;
	}

	
}
