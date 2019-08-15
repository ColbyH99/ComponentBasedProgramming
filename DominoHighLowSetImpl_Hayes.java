package dominoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DominoHighLowSetImpl_Hayes implements Domino 
{
	private Set<Integer> highLowSet;
	
	public static void main(String[] args)
	{
		
		Domino d = new DominoHighLowSetImpl_Hayes(3, 3);
		Domino d2 = new DominoHighLowSetImpl_Hayes("8,0");
		Domino d3 = new DominoHighLowSetImpl_Hayes(27);
		boolean isSumDifferenceStringAnswer = isSumDifferenceString("1,0");
		System.out.println(isSumDifferenceStringAnswer);
		boolean isLowPlus8TimesHighAnswer = isLowPlus8TimesHighInteger(-1);
		System.out.println(isLowPlus8TimesHighAnswer);
	}
	
	//Asserts that highPipCount and lowPipCount are valid
	//adds highPipCount and lowPipCount to highLowSet
	//prints the high and low pip counts
	//Domino d = new DominoHighLowSetImpl_Hayes(3, 2); --> highPipCount = 3, lowPipCount = 2
	//Domino d2 = new DominoHighLowSetImpl_Hayes(0, 0); --> highPipCount = 0, lowPipCount = 0
	//Domino d3 = new DominoHighLowSetImpl_Hayes(6, 0); --> highPipCount = 6, lowPipCount = 0
	public DominoHighLowSetImpl_Hayes(int highPipCount, int lowPipCount)
	{
		
		assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT!";
		assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT!";
		assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount!";
		
		this.highLowSet = new HashSet<Integer>();
		highLowSet.add(highPipCount);
		highLowSet.add(lowPipCount);
		
		System.out.println("High Pip Count: " + this.getHighPipCount());
		System.out.println("Low Pip Count: " + this.getLowPipCount());
		
	}

	public static final char SUM_DIFFERENCE_DELIMITER = ',';
	//Checks if str is a valid sumDifference string
	//assert isSumDifferenceString(str) == true;
	//boolean isSumDifferenceStringValue = isSumDifferenceString(str);
	public static boolean isSumDifferenceString(String str)
	{
		if(str.length() != 3 && str.length() != 4)
		{
			return false;
		}
		if(str.length() == 3)
		{
			if(str.charAt(1) != SUM_DIFFERENCE_DELIMITER)
			{
				return false;
			}
		}
		if(str.length() == 4)
		{
			if(str.charAt(2) != SUM_DIFFERENCE_DELIMITER)
			{
				return false;
			}
		}
	
		return true;
	}
	
	//Calculates highPipCount and lowPipCount from a sumDifferenceString
	//Adds highPipCount and lowPipCount to highLowSet
	//Prints highPipCount and lowPipCount
	//Domino d = new DominoHighLowSetImpl_Hayes("7,5") --> High Pip Count: 6, Low Pip Count: 1
	//Domino d2 = newDominoHighLowSetImpl_Hayes("0,0") --> High Pip Count: 0, Low Pip Count: 0
	//Domino d3 = newDominoHighLowSetImpl_Hayes("12,0") --> High Pip Count: 6, Low Pip Count: 6
	public DominoHighLowSetImpl_Hayes(String sumDifferenceString)
	{
		assert isSumDifferenceString(sumDifferenceString) == true : "sumDifferenceString is not a valid sumDifferenceString";
		
		if(sumDifferenceString.length() == 3)
		{
			char sum = sumDifferenceString.charAt(0);
			char difference = sumDifferenceString.charAt(2);
			
			int sumInt = Character.getNumericValue(sum);
			int differenceInt = Character.getNumericValue(difference);
			assert (sumInt % 2 == 0 && differenceInt % 2 == 0) || (sumInt % 2 == 1 && differenceInt % 2 == 1) : "Sum and difference are not correct"; 
			int lowPipCount = (sumInt - Math.abs(differenceInt))/2;
			int highPipCount = (sumInt + Math.abs(differenceInt))/2;
			
			assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT";
			assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT";
			assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT";
			assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is Greater than MAXIMUM_PIP_COUNT";
			assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount";
			
			this.highLowSet = new HashSet<Integer>();
			
			highLowSet.add(highPipCount);
			highLowSet.add(lowPipCount);
		}
		
		if(sumDifferenceString.length() == 4)
		{
			String sumString = "";
			for(int i = 0; i < 2; i++)
			{
				sumString += sumDifferenceString.charAt(i);
			}
			int sum = Integer.valueOf(sumString);
			char difference = sumDifferenceString.charAt(3);
			int differenceInt = Character.getNumericValue(difference);
			assert (sum % 2 == 0 && differenceInt % 2 == 0) || (sum % 2 == 1 && differenceInt % 2 == 1) : "Sum and difference are not correct"; 
			int lowPipCount = (sum - Math.abs(differenceInt))/2;
			int highPipCount = (sum + Math.abs(differenceInt))/2;
			
			assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT";
			assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT";
			assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT";
			assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is Greater than MAXIMUM_PIP_COUNT";
			assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount";
			
		
			this.highLowSet = new HashSet<Integer>();
			
			highLowSet.add(highPipCount);
			highLowSet.add(lowPipCount);
		}
		
		System.out.println("sumDifferenceString High Pip Count: " + this.getHighPipCount());
		System.out.println("sumDifferenceString Low Pip Count: " + this.getLowPipCount());
		
	}
	
	//Checks that k is a valid low + (8*high) integer
	//assert this.isLowPlus8TimesHighInteger(k) == true;
	//boolean LowPlus8TimesHigh = isLowPlus8TimeshighInteger(k);
	public static boolean isLowPlus8TimesHighInteger(int k)
	{
		int lowPipCount = k % 8;
		int highPipCount = (k - lowPipCount)/8;
		
		if(k < 0 || k > 54)
		{
			return false;
		}
		
		if(lowPipCount < MINIMUM_PIP_COUNT || lowPipCount > MAXIMUM_PIP_COUNT)
		{
			return false;
		}
		
		if(highPipCount < MINIMUM_PIP_COUNT || highPipCount > MAXIMUM_PIP_COUNT)
		{
			return false;
		}
		
		return true;
		
	}
	
	//Calculates lowPipCount and highPipCount from k
	//Adds lowPipCount and highPipCount to highLowSet
	//Prints high pip count and low pip count
	//Domino d = new DominoHighLowSetImpl_Hayes(45) --> High Pip Count: 5, Low Pip Count: 5
	//Domino d2 = new DominoHighLowSetImpl_Hayes(0) --> High Pip Count: 0, Low Pip Count: 0
	//Domino d3 = new DominoHighLowSetImpl_Hayes(25) --> High Pip Count: 3, Low Pip Count: 1
	public DominoHighLowSetImpl_Hayes(int k)
	{
		assert isLowPlus8TimesHighInteger(k) == true: "k is not a valid LowPlus8TimtesHighInteger!";
		int lowPipCount = k % 8;
		int highPipCount = (k - lowPipCount)/8;
		
		assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT!";
		assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT!";
		assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is greater than MAXIMUM_PIP_COUNT!";
		assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount!";
		
		this.highLowSet = new HashSet<Integer>();
		highLowSet.add(lowPipCount);
		highLowSet.add(highPipCount);
		
		System.out.println("lowPlus8TimesHigh High Pip Count: " + this.getHighPipCount());
		System.out.println("lowPlus8TimesHigh Low Pip Count: " + this.getLowPipCount());
	}
	
	//Returns: maximum value in a set
	//int highPipcount = getMaximum(this.highLowSet);
	public static int getMaximum(Set<Integer> highLowSet) {
		ArrayList<Integer> integerList = new ArrayList<Integer>(highLowSet);
		
		int max = integerList.get(0);
		for(int index = 1; index < integerList.size(); index++)
		{
			if(integerList.get(index) > max)
			{
				max = integerList.get(index);
			}
		}
		return max;
	}

	//Returns: minimum value in a set
	//int lowPipCount = getMinimum(this.highLowSet);
	public static int getMinimum(Set<Integer> highLowSet) {
		ArrayList<Integer> integerList = new ArrayList<Integer>(highLowSet);
		
		int min = integerList.get(0);
		for(int index = 1; index < integerList.size(); index++)
		{
			if(integerList.get(index) < min)
			{
				min = integerList.get(index);
			}
		}
		return min;
	}
	
	//Returns: highPipCount;
	//System.out.println("High Pip Count: " + this.getHighPipCount());
	public int getHighPipCount()
	{
		int highPipCount = getMaximum(this.highLowSet);
		return highPipCount;
	}
	
	//Returns: lowPipCount;
	//System.out.println("Low Pip Count: " + this.getLowPipcount());
	public int getLowPipCount()
	{
		int lowPipCount = getMinimum(highLowSet);
		return lowPipCount;
	}
}
