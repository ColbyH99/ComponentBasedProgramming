package dominoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DominoHighLowImpl_Hayes implements Domino {
	
	private int highPipCount;
	private int lowPipCount;
	
	public static void main(String[] args)
	{
		Domino d5 = new DominoHighLowImpl_Hayes(3, 0, 3, 2);
	}
	
	//Checks that highPipCount and lowPipCount are valid
	//Assigns highPipCount and lowPipCount to the private instance variables
	//prints highPipCount and lowPipCount
	//Domino d = new DominoHighLowImpl_Hayes(3, 2); --> highPipCount = 3, lowPipCount = 2
	//Domino d2 = new DominoHighLowImpl_Hayes(0, 0); --> highPipCount = 0, lowPipCount = 0
	//Domino d3 = new DominoHighLowImpl_Hayes(6, 0); --> highPipCount = 6, lowPipCount = 0
	//part of post: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT
	public DominoHighLowImpl_Hayes(int highPipCount, int lowPipCount)
	{
		assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT";
		assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT";
		assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT";
		assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is Greater than MAXIMUM_PIP_COUNT";
		assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount";
		
		this.highPipCount = highPipCount;
		this.lowPipCount = lowPipCount;
		
		System.out.println("High Pip Count: " + this.getHighPipCount());
		System.out.println("Low Pip Count: " + this.getLowPipCount());
		
	}
	
	public static final char HIGH_LOW_STRING_SEPERATOR = ':';
	//Checks that str is a valid HighLow string
	//assert isHighLowString(str) == true;
	//boolean isHighLowStringBoolean = isHighLowString(str);
	public static boolean isHighLowString(String str)
	{
		if(str == null || str == "")
		{
			return false;
		}
		if(!(str.length() == 3))
		{
			return false;
		}

		char high = str.charAt(0);
		char low = str.charAt(2);
		int highPipCount = Character.getNumericValue(high);
		int lowPipCount = Character.getNumericValue(low);
		
		if(highPipCount > MAXIMUM_PIP_COUNT || highPipCount < MINIMUM_PIP_COUNT)
		{
			return false;
		}
		if(lowPipCount > MAXIMUM_PIP_COUNT || lowPipCount < MINIMUM_PIP_COUNT)
		{
			return false;
		}
		if(lowPipCount > highPipCount)
		{
			return false;
		}
		if(str.charAt(1) != HIGH_LOW_STRING_SEPERATOR)
		{
			return false;
		}
		
		return true;
	}
	
	//Gets highPipCount and lowPipCount from highLowString and converts them to integers
	//Assigns highPipCount and lowPipCount to the private instance variables and prints them
	//Domino d = new DominoHighLowImpl_Hayes("6:0"); --> highPipCount =  6, lowPipCount = 0
	//Domino d2 = new DominoHighLowImpl_Hayes("0:0"); --> highPipCount = 0, lowPipCount = 0
	//Domino d3 = new DominoHighLowImpl_Hayes("4:2"); --> highPipCount = 4, lowPipCount = 2
	//part of post: MINIMUM_PIP_COUNT <= int(highLowString.charAt(0)) <= MAXIMUM_PIP_COUNT
	//part of post: MINIMUM_PIP_COUNT <= int(highLowString.charAt(2)) <= MAXIMUM_PIP_COUNT
	public DominoHighLowImpl_Hayes(String highLowString)
	{
		assert isHighLowString(highLowString) : "highLowString is not a properly formatted highLowString";
		
		//Converts the highPip character and lowPip character from chars to integers
		char highPipCountChar = highLowString.charAt(0);
		char lowPipCountChar = highLowString.charAt(2);
		int highPipCountInt = Character.getNumericValue(highPipCountChar);
		int lowPipCountInt = Character.getNumericValue(lowPipCountChar);
		
		this.highPipCount = highPipCountInt;
		this.lowPipCount = lowPipCountInt;
		System.out.println("highLowString High Pip Count: " + this.getHighPipCount());
		System.out.println("highLowString Low Pip Count: " + this.getLowPipCount());
	}
	
	public static final int INDEX_OF_SUM = 0;
	public static final int INDEX_OF_DIFFERENCE = 1;
	//Calculates highPipCount and lowPipCount from the sumDifference array and confirms that they're valid
	//Prints the highPipCount and lowPipCount
	//part of pre: sumDifference.length == 2
	//part of pre: sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]
	//Domino d = new DominoHighLowImpl_Hayes([12, 0]) --> highPipCount = 6, lowPipCount = 6
	//Domino d2 = new DominoHighLowImpl_Hayes([0, 0]) --> highPipCount = 0, lowPipCount = 0
	//Domino d3 = new DominoHighLowImpl_Hayes([5, 1]) --> highPipCount = 3, lowPipCount = 2
	public DominoHighLowImpl_Hayes(int[] sumDifference)
	{
		assert sumDifference != null : "sumDifference array is null!";
		assert sumDifference.length == 2 : "sumDifference array is not the correct size of 2!";
		assert sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE] : "Sum is not greater than or equal to the Difference!";
		int sum = sumDifference[INDEX_OF_SUM];
		int difference = sumDifference[INDEX_OF_DIFFERENCE];
		assert (sum % 2 == 0 && difference % 2 == 0) || (sum % 2 == 1 && difference % 2 == 1) : "Sum and difference are not correct"; 
		assert 2*MINIMUM_PIP_COUNT <= sum : "Sum is not valid!";
		assert sum <= 2*MAXIMUM_PIP_COUNT : "Sum is not valid!";
		assert -(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) <= difference : "Difference is not valid!";
		assert difference <= (MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) : "Difference is not valid!";
		assert difference <= sum : "Difference is greater than the sum!";
		
		this.lowPipCount = (sum - Math.abs(difference))/2;
		this.highPipCount = (sum + Math.abs(difference))/2;
		
		System.out.println("sumDifference High Pip Count: " + this.getHighPipCount());
		System.out.println("sumDifference Low Pip Count: " + this.getLowPipCount());
	}
	
	//Gets the highPipCount and lowPipCount from highLowSet
	//Checks that the pip counts are valid
	//Prints the pip counts
	//part of pre: 1 <= highLowSet.size() <= 2
	//part of pre: ! highLowSet.contains(null)
	//Domino d = new DominoHighLowImpl_Hayes([3]) --> highPipCount = 3, lowPipCount = 3;
	//Domino d2 = new DominoHighLowImpl_Hayes([6, 3]) --> highPipCount = 6, lowPipCount = 3;
	//Domino d3 = new DominoHighLowImpl_Hayes([0]) --> highPipCount = 0, lowPipCount = 0;
	public DominoHighLowImpl_Hayes(Set<Integer> highLowSet)
	{
		assert 1 <= highLowSet.size() && highLowSet.size() <= 2 : "highLowSet is not size 1 or 2";
		assert ! highLowSet.contains(null) : "highLowSet is null!";
		ArrayList<Integer> integerList = new ArrayList<Integer>(highLowSet);
		
		if(integerList.size() == 1)
		{
			
			this.highPipCount = integerList.get(0);
			this.lowPipCount = integerList.get(0);
			
			assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT!";
			assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT!";
			assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT!";
			assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is greater than MAXIMUM_PIP_COUNT!";
			assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount!";
		}
		
		if(integerList.size() == 2)
		{
			assert integerList.get(1) >= integerList.get(0);
			this.highPipCount = integerList.get(1);
			this.lowPipCount = integerList.get(0);
			
			assert MINIMUM_PIP_COUNT <= lowPipCount : "lowPipCount is less than MINIMUM_PIP_COUNT!";
			assert lowPipCount <= MAXIMUM_PIP_COUNT : "lowPipCount is greater than MAXIMUM_PIP_COUNT!";
			assert MINIMUM_PIP_COUNT <= highPipCount : "highPipCount is less than MINIMUM_PIP_COUNT!";
			assert highPipCount <= MAXIMUM_PIP_COUNT : "highPipCount is greater than MAXIMUM_PIP_COUNT!";
			assert lowPipCount <= highPipCount : "lowPipCount is greater than highPipCount!";
		}
		
		System.out.println("highLowSet High Pip Count: " + this.getHighPipCount());
		System.out.println("highLowSet Low Pip Count: " + this.getLowPipCount());
	}
	
	//Calculates the high pip count given the highPipCountDivisionBy2Quotient and highPipCountDivisionBy3Remainder
	private int retrieveHighPipCount(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder)
	{
		ArrayList<Integer> myArrayList = new ArrayList();
		//Puts the possible hpc's into an ArrayList
		for(int i = MINIMUM_PIP_COUNT; i <= MAXIMUM_PIP_COUNT; i++)
		{
			if(i / 2 == highPipCountDivisionBy2Quotient)
			{
				myArrayList.add(i);
			}
		}
		int count = 0;
		while(count < myArrayList.size())
		{
			if(myArrayList.get(count) % 3 == highPipCountDivisionBy3Remainder)
			{
				this.highPipCount = myArrayList.get(count);
				break;
			}
			count++;
		}
		int myHighPipCount = this.getHighPipCount();
		return myHighPipCount;
	}
	
	//Calculates the low pip count given the lowPipCountDivisionBy2Quotient and lowPipCountDivisionBy3Remainder
	private int retrieveLowPipCount(int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder)
	{
		ArrayList<Integer> myArrayList2 = new ArrayList();
		//Puts the possible lpc's into an ArrayList
		for(int i = MINIMUM_PIP_COUNT; i <= MAXIMUM_PIP_COUNT; i++)
		{
			if(i / 2 == lowPipCountDivisionBy2Quotient)
			{
				myArrayList2.add(i);
			}
		}
		int count = 0;
		while(count < myArrayList2.size())
		{
			if(myArrayList2.get(count) % 3 == lowPipCountDivisionBy3Remainder)
			{
				this.lowPipCount = myArrayList2.get(count);
				break;
			}
			count++;
		}
		int myLowPipCount = this.getLowPipCount();
		return myLowPipCount;
	}
	
	//Given the high and low pip counts divded by 2 quotients and high and low pip count division by 3 remainders,
	//finds the high and low pip count, and sets them to the instance variables
	DominoHighLowImpl_Hayes(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder, int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder)
	{
		assert (MINIMUM_PIP_COUNT/2) <= highPipCountDivisionBy2Quotient && highPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2);
		assert 0 <= highPipCountDivisionBy3Remainder && highPipCountDivisionBy3Remainder < 3;
		assert (MINIMUM_PIP_COUNT/2) <= lowPipCountDivisionBy2Quotient && lowPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2);
		assert 0 <= lowPipCountDivisionBy3Remainder && lowPipCountDivisionBy3Remainder < 3;
		
		int myHighPipCount = retrieveHighPipCount(highPipCountDivisionBy2Quotient, highPipCountDivisionBy3Remainder);
		int myLowPipCount = retrieveLowPipCount(lowPipCountDivisionBy2Quotient, lowPipCountDivisionBy3Remainder);
		
		this.highPipCount = myHighPipCount;
		this.lowPipCount = myLowPipCount;
		System.out.println("High Pip Count: " + this.getHighPipCount());
		System.out.println("Low Pip Count: " + this.getLowPipCount());
		
		
	}
	
	//System.out.println("High Pip Count: " + this.getHighPipCount());
	//int highPipCount = this.getHighPipCount();
	public int getHighPipCount()
	{
		return highPipCount;
	}
	
	//System.out.println("Low Pip Count: " + this.getLowPipCount());
	//int lowPipCount = this.getLowPipCount();
	public int getLowPipCount()
	{
		return lowPipCount;
	}
	
	
}
