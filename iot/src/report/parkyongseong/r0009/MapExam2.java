package report.parkyongseong.r0009;

import java.util.HashMap;
import java.util.Iterator;

public class MapExam2 
{
	HashMap<String, Integer> hm;
	
	MapExam2()
	{
		hm = new HashMap<String, Integer>();
	}
	
	public static void main(String[] args)
	{
		MapExam2 me2 = new MapExam2();
		me2.hm.put("1", 1);
		me2.hm.put("2", 2);
		me2.hm.put("3", 3);
		me2.hm.put("4", 4);
		me2.hm.put("5", 5);
		
		System.out.println(me2.hm.containsKey("6"));
		Iterator it = me2.hm.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String)it.next();
			System.out.print(key + ",");
			System.out.println(me2.hm.get(key));
		}
	}
}
