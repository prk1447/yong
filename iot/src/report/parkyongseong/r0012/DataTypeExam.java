package report.parkyongseong.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam 
{
	public static void main(String[] args)
	{
		ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		ArrayList<Object> list2 = new ArrayList<Object>();
		list2.add("가");
		list2.add("나");
		ArrayList<Object> list3 = new ArrayList<Object>();
		list3.add("a");
		list3.add("b");
		
		HashMap<Object, ArrayList<Object>> hm = new HashMap<Object, ArrayList<Object>>();
		hm.put(list1.get(0), list1);
		hm.put(list2.get(0), list2);
		hm.put(list3.get(0), list3);
		
		System.out.println(hm);
	}
}
