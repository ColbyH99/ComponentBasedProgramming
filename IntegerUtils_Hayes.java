package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface IntegerUtils_Hayes {
	
	ArrayList<Integer> greatestCommonFactorList = new ArrayList();
	ArrayList<Character> myReverseList = new ArrayList();
	ArrayList<Character> mySumThingCharList = new ArrayList();
	ArrayList<Integer> mySumThingIntList = new ArrayList();
	ArrayList<Integer> myGreatestConstrainedMultipleList = new ArrayList();
	Set<Integer> integerSet = new HashSet<Integer>();
	Set<Integer> integerSet2 = new HashSet<Integer>();
	Set<Integer> integerSet3 = new HashSet<Integer>();
	int[] myTestArrayOne = new int[5];
	int[] myTestArrayTwo = new int[4];
	int[] myTestArrayThree = new int[5];
	int[] myTestArrayFour = new int[4];
	
	
	public static void main(String [ ] args) {
		
		System.out.println("-----Now Testing isEven()-----");
		System.out.println(isEven(7));
		System.out.println(isEven(0));
		System.out.println(isEven(-10));
		
		System.out.println("-----Now Testing isOdd()-----");
		System.out.println(isOdd(9));
		System.out.println(isOdd(0));
		System.out.println(isOdd(-141));
		
		System.out.println("-----Now Testing isPrime()-----");
		System.out.println(isPrime(2));
		System.out.println(isPrime(1));
		System.out.println(isPrime(-1));
		System.out.println(isPrime(5));
		System.out.println(isPrime(4));
		System.out.println(isPrime(75));
		System.out.println(isPrime(10000));
		System.out.println(isPrime(101));
		
		System.out.println("-----Now Testing greatestCommonFactor()-----");
		System.out.println(greatestCommonFactor(99, 100));
		System.out.println(greatestCommonFactor(72, 6));
		System.out.println(greatestCommonFactor(72, -128));
		System.out.println(greatestCommonFactor(0, 100));
		System.out.println(greatestCommonFactor(100, 0));
		System.out.println(greatestCommonFactor(-4, 0));
		
		System.out.println("-----Now Testing getGreatestConstrainedMultiple------");
		System.out.println(getGreatestConstrainedMultiple(7, 50));
		System.out.println(getGreatestConstrainedMultiple(10, 789));
		System.out.println(getGreatestConstrainedMultiple(-50, 2));
		System.out.println(getGreatestConstrainedMultiple(-4, 49));
		
		System.out.println("-----Now Testing getMinimum()-----");
		myTestArrayOne[0] = 1;
		myTestArrayOne[1] = 5;
		myTestArrayOne[2] = -3;
		myTestArrayOne[3] = 0;
		myTestArrayOne[4] = 7;
		System.out.println(getMinimum(myTestArrayOne));
		myTestArrayTwo[0] = 1;
		myTestArrayTwo[1] = 2;
		myTestArrayTwo[2] = 4;
		myTestArrayTwo[3] = 7;
		System.out.println(getMinimum(myTestArrayTwo));
		myTestArrayThree[0] = 6;
		myTestArrayThree[1] = 3;
		myTestArrayThree[2] = 4;
		myTestArrayThree[3] = -1;
		myTestArrayThree[4] = -4;
		System.out.println(getMinimum(myTestArrayThree));
		myTestArrayFour[0] = -3;
		myTestArrayFour[1] = -1;
		myTestArrayFour[2] = 1;
		myTestArrayFour[3] = -3;
		System.out.println(getMinimum(myTestArrayFour));
		
		
		System.out.println("-----Now testing isSorted()-----");
		myTestArrayTwo[0] = 1;
		myTestArrayTwo[1] = 1;
		myTestArrayTwo[2] = 4;
		myTestArrayTwo[3] = 7;
		System.out.println(isSorted(myTestArrayTwo));
		myTestArrayThree[0] = 6;
		myTestArrayThree[1] = 3;
		myTestArrayThree[2] = 4;
		myTestArrayThree[3] = -1;
		myTestArrayThree[4] = -4;
		System.out.println(isSorted(myTestArrayThree));
		myTestArrayFour[0] = -3;
		myTestArrayFour[1] = -1;
		myTestArrayFour[2] = 1;
		myTestArrayFour[3] = 3;
		System.out.println(isSorted(myTestArrayFour));
		
		System.out.println("-----Now testing for getSmallestIndexOfMatch()-----");
		System.out.println(getSmallestIndexOfMatch(myTestArrayOne, 5));
		System.out.println(getSmallestIndexOfMatch(myTestArrayTwo, 7));
		System.out.println(getSmallestIndexOfMatch(myTestArrayThree, -1));
		System.out.println(getSmallestIndexOfMatch(myTestArrayFour, -3));
		System.out.println(getSmallestIndexOfMatch(myTestArrayFour, 17));
		
		System.out.println("-----Now testing reverse()-----");
		System.out.println(reverse(123));
		System.out.println(reverse(75629));
		System.out.println(reverse(-13452));
		System.out.println(reverse(0));
		System.out.println(reverse(-19));
		System.out.println(reverse(111222333));
		System.out.println(reverse(007));
		
		System.out.println("-----Now testing sumthing()-----");
		System.out.println(sumthing(12));
		System.out.println(sumthing(123));
		System.out.println(sumthing(29));
		System.out.println(sumthing(54));
		System.out.println(sumthing(555));
		System.out.println(sumthing(457));
		
		System.out.println("-----Now testing getMaximum()------");
		integerSet.add(4);
		integerSet.add(7);
		integerSet.add(1);
		integerSet.add(-1);
		System.out.println(getMaximum(integerSet));
		integerSet2.add(-5);
		integerSet2.add(-7);
		integerSet2.add(-2);
		integerSet2.add(-3);
		System.out.println(getMaximum(integerSet2));
		integerSet3.add(9);
		integerSet3.add(9);
		integerSet3.add(5);
		integerSet3.add(4);
		System.out.println(getMaximum(integerSet3));
		
	}
	
	// returns true if int k is even, false if odd
	// isEven(7) --> false
	// isEven(0) --> true
	// isEven(-10) --> true
	public static boolean isEven(int k)
	{
		if(k % 2 == 0) //check if even
		{
			return true;
		}
		return false;
	}
	
	// returns: true if int k is odd, false if even
	// isOdd(49) --> true
	// isOdd(0) --> false
	// isOdd(-139) --> true
	public static boolean isOdd(int k) 
	{
		if(k % 2 != 0) //Check if not even
		{
			return true;
		}
		return false;
	}
	
	// returns: true if int k is a prime number, false if not
	// isPrime(2) --> true
	// isPrime(1) --> false
	// isPrime(8) --> false
	public static boolean isPrime(int k) 
	{
		if(k < 2) //No prime number less than 2
		{
			return false;
		}
		
		for(int index = 2; index < k; index++) //Searching for non-prime numbers
		{
			if(k % index == 0) //Checks if index isn't prime
			{
				return false;
			}
		}
		return true;
	}
	
	//returns: the greatest common factor between the passed int values of m and n
	//greatestCommonFactor(72, 6) --> 6
	//greatestCommonFactor(72, -128) --> 8
	//greatestCommonFactor(0, 0) --> Infinity, returns 0 in place of infinity
	public static int greatestCommonFactor(int m, int n) {
		if(m == 0 && n == 0) {
			System.out.println("GCF is Infinite Numbers");
			return 0; 
		}
		
		if (m == 0)
		{
			greatestCommonFactorList.add(Math.abs(n));
		}
		else if(n == 0)
		{
			greatestCommonFactorList.add(Math.abs(m));
		}
		
		if(m < n || n < 0) {
			for(int index = 1; index <= m; index++) {
				if(m % index == 0 && n % index == 0)
				{
					greatestCommonFactorList.add(index);
				}
			}
		}
		
		if(n < m || m < 0) {
			for(int index = 1; index <= n; index++) {
				if(m % index == 0 && n % index == 0) {
					greatestCommonFactorList.add(index);
				}
			}
		}
		
		int greatestCommonFactorListSize = greatestCommonFactorList.size();
		int gcf = greatestCommonFactorList.get(greatestCommonFactorListSize - 1);
		greatestCommonFactorList.clear();
		return gcf;
	}
	
	// Returns the highest multiple of K without exceeding the given maximum
	// getGreatestConstrainedMultiple(7, 50) --> 49
	// getGreatestConstrainedMultiple(-50, 2) --> 0
	// getGreatestConstrainedMultiple(-4, 49) --> 48
	public static int getGreatestConstrainedMultiple(int k, int maximum)
	{
		if(k < maximum)
		{
			for(int index = 0; index <= maximum; index++)
			{
				if(index % k == 0)
				{
					myGreatestConstrainedMultipleList.add(index);
				}
			}
		}
		int greatestConstrainedMultipleListSize = myGreatestConstrainedMultipleList.size();
		int greatestConstrainedMultiple = myGreatestConstrainedMultipleList.get(greatestConstrainedMultipleListSize - 1);
		return greatestConstrainedMultiple;
	}
	
	/*
	public static int getIntegerH(int h_q_3, int h_r_5) {
		
	}*/
	
	// returns: int max; the maximum value in integerSet
	// [2, 4, 1, 5, 3] --> 5
	// [-5, -2, -3, -1] --> -1
	// [0, 0, -2, -4] --> 0
	public static int getMaximum(Set<Integer> integerSet) {
		ArrayList<Integer> integerList = new ArrayList<Integer>(integerSet);
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
	
	
	// returns: minimum value in intArray
	// [5, 4, 3, 2, 1] --> 1
	// [0, 3, 4, -2, 6] --> -2
	// [-10, -10, -4, 2] --> -10
	public static int getMinimum(int[] intArray) 
	{
		int min = intArray[0];
		for (int index = 1; index < intArray.length; index++)
		{
			if (intArray[index] < min)
			{
				min = intArray[index];
			}
		}
		return min;
	}
	
	// returns: true if intArray is sorted lowest integer value to highest integer value
	// returns: false if intArray is not sorted
	// [0, 1, 2, 3, 4] --> true
	// [-4, 10, 5, -2, 3] --> false
	// [1, 1, 2, 3, 4] --> true
	public static boolean isSorted(int[] intArray)
	{
		int count = 0;
		int count2 = 1;
		
		while(count < intArray.length - 1 && count2 < intArray.length)
		{
			if(intArray[count] > intArray[count2])
			{
				return false;
			}
			count++;
			count2++;
		}
		return true;
	}
	
	// returns: the smallest index of the matched target value
	// getSmallestIndexOfMatch([4, 3, 2, 5, 2, 6], 2) --> 2
	// getSmallestIndexOfMatch([-1, 0, 1, 2, 3, 0], 0) --> 1
	// getSmallestIndexOfMatch([1, 2, 3, 4, 5, 6], 6) --> 5
	public static int getSmallestIndexOfMatch(int[]intArray, int target) 
	{
		for(int index = 0; index < intArray.length; index++)
		{
			if(intArray[index] == target)
			{
				return index;
			}
		}
		System.out.println("Target Not In intArray");
		return -1;
	}
	
	// returns: the reversed integer reversedK
	// reverse(123) --> 321
	// reverse(-456) --> -654
	// reverse(0) --> 0
	public static int reverse(int k) 
	{
		String integerKString = Integer.toString(k);
		String reversedKString = "";
		if(k < 0)
		{
			reversedKString += "-";
			for(int index = integerKString.length() - 1; index > 0; index--)
			{
				if(integerKString.charAt(integerKString.length()-1) == '-')
				{
					break;
				}
				reversedKString += integerKString.charAt(index);
			}
		}
		
		if(k >= 0) 
		{
			for(int index = integerKString.length() - 1; index >= 0; index--)
			{
				if(integerKString.charAt(integerKString.length()-1) == '-')
				{
					break;
				}
				reversedKString += integerKString.charAt(index);
			}
		}
		int reversedK = Integer.valueOf(reversedKString);
		return reversedK;
	}
	
	// Adds up the digits in long k
	// if the sum of the digits is greater than 9, it adds them again
	// sumthing(111) --> 3
	// sumthing(457) --> 7
	public static int sumthing(long k) 
	{
		
		String longKString = Long.toString(k);
		for(int index = 0; index < longKString.length(); index++)
		{
			mySumThingCharList.add(longKString.charAt(index));
		}
		
		for(int index = 0; index < mySumThingCharList.size(); index++)
		{
			char ch = mySumThingCharList.get(index);
			int numValue = Character.getNumericValue(ch);
			mySumThingIntList.add(numValue);
		}
		
		int result = 0;
		for(int index = 0; index < mySumThingIntList.size(); index++)
		{
			result += mySumThingIntList.get(index);
		}
		
		if(result > 9)
		{
			mySumThingIntList.clear();
			mySumThingCharList.clear();
			String resultString = Integer.toString(result);
			for(int index = 0; index < resultString.length(); index++)
			{
				mySumThingCharList.add(resultString.charAt(index));
			}
			
			for(int secondIndex = 0; secondIndex < mySumThingCharList.size(); secondIndex++)
			{
				char ch2 = mySumThingCharList.get(secondIndex);
				int l = Character.getNumericValue(ch2);
				mySumThingIntList.add(l);
			}
			
			result = 0;
			for(int thirdIndex = 0; thirdIndex < mySumThingIntList.size(); thirdIndex++)
			{
				
				result += mySumThingIntList.get(thirdIndex);
			}
		}
		mySumThingIntList.clear();
		mySumThingCharList.clear();
		return result;
		
	}
}
