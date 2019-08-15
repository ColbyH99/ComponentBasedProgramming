package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Hayes implements ChangeMaker {

	private ArrayList<Integer> denominations;
	
	public static void main(String[] args)
	{
		Set denominations = new HashSet<Integer>();
		denominations.add(100);
		denominations.add(25);
		denominations.add(10);
		denominations.add(5);
		denominations.add(1);
		ChangeMaker change = new ChangeMakerImpl_Hayes(denominations);
	}
	//part of pre: i <= 0 ==> !denominations.contains(i)
	public ChangeMakerImpl_Hayes(Set<Integer> denominations)
	{
		assert Collections.min(denominations) > 0;
		
		this.denominations = new ArrayList<Integer>(denominations);
		Collections.sort(this.denominations, Collections.reverseOrder());
		System.out.println(this.denominations);
	}
	
	//part of post: i in [0, rv.size() - 1) ==>
	//					rv.get(i) > rv.get(i + 1)
	public List<Integer> getDenominations() {
		return this.denominations;
	}

	//pre: valueInCents >= 0
	//post: returns either true or false
	// true if any of the denominations can make exact change
	// false if the denominations cannot make change or if invalid valueInCents
	public boolean canMakeExactChange(int valueInCents) {
		if (valueInCents == 0)
		{
			return true;
		}
		for(int i = 0; i < this.denominations.size(); i++)
		{
			int denomination = this.denominations.get(i);
			if(valueInCents % denomination == 0)
			{
				return true;
			}
		}
		return false;
	}

	//part of pre: canMakeExactChange(valueInCents)
	//part of post: calculateValueOfChangeList(rv) == valueInCents
	//part of post: i in [0, rv.size() - 1) ==>
	//getDenominations.get(i) > rv.get(i+1)*getDenominations.get(i+1)
	public List<Integer> getExactChange(int valueInCents) {
		assert canMakeExactChange(valueInCents);
		
		ArrayList<Integer> changeList = new ArrayList<Integer>();
		for(int i = 0; i < this.denominations.size(); i++)
		{
			changeList.add(valueInCents / this.denominations.get(i));
			valueInCents = valueInCents - changeList.get(i) * this.denominations.get(i);
		}
		System.out.println(changeList);
		return changeList;
	}

	//part of pre: changeList.size() == getDenominations().size()
	//part of pre: SIZE = changeList.size()
	//				[NOTE: purely for notation]
	//part of post: student needs to figure out and write post
	public int calculateValueOfChangeList(List<Integer> changeList) {
		assert changeList.size() == getDenominations().size();
		int valueInCents = 0;
		
		for(int i = 0; i < this.denominations.size(); i++)
		{
			valueInCents += this.denominations.get(i) * changeList.get(i);
		}

		return valueInCents;
	}
	
	//Displays a formatted String of the denomination list
	public String toString()
	{
		String retValue = "";
		retValue += "Denominations: " + this.getDenominations();
		return retValue;
		
	}
}
