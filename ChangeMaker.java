package change;

import java.util.List;

public interface ChangeMaker {
	//part of post: i in [0, rv.size() - 1) ==>
	//					rv.get(i) > rv.get(i + 1)
	public List<Integer> getDenominations();
	
	//pre: student needs to figure out and write pre
	//post: student needs to figure out and write post
	public boolean canMakeExactChange(int valueInCents);
	
	//part of pre: canMakeExactChange(valueInCents)
	//part of post: calculateValueOfChangeList(rv) == valueInCents
	//part of post: i in [0, rv.size() - 1) ==>
	//getDenominations.get(i) > rv.get(i+1)*getDenominations.get(i+1)
	public List<Integer> getExactChange(int valueInCents);
	
	//part of pre: changeList.size() == getDenominations().size()
	//part of pre: SIZE = changeList.size()
	//				[NOTE: purely for notation]
	//part of post: student needs to figure out and write post
	public int calculateValueOfChangeList(List<Integer> changeList);
}
