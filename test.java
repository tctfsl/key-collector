import java.util.Vector;

public class test{
	public static void main(String[] arg)
	{
		Vector<Integer> firstColumn = new Vector<Integer>(1,1);
		
		firstColumn.add(9);
		
		System.out.println("The number of elements are :" + firstColumn.get(0));
		System.out.println("The number of elements are :" + firstColumn.size());
		
		firstColumn.add(2);
		firstColumn.add(3);
		firstColumn.add(4);
		
		Vector<Integer> secondColumn = new Vector<Integer>(1,1);
		
		secondColumn.add(5);
		secondColumn.add(6);
		secondColumn.add(7);
		secondColumn.add(8);
		
		Vector<Vector<Integer>> mergedColumns = new Vector<Vector<Integer>>();
		mergedColumns.add(firstColumn);
		mergedColumns.add(secondColumn);
		
		Vector<Integer> test1 = mergedColumns.get(0);
		
		System.out.println("The number of elements are :" + test1.get(3));
	}
	
}