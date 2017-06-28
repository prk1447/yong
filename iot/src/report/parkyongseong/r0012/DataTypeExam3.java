package report.parkyongseong.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam3
{
	public static void main(String[] args)
	{
		ArrayList<HashMap<Object, Object>> al = new ArrayList<HashMap<Object, Object>>();
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		hm.put("클래스", "A");
		hm.put("이름", "길동이");
		hm.put("나이", "20");
		hm.put("성별", "남자");
		al.add(hm);
		
		HashMap<Object, Object> hm1 = new HashMap<Object, Object>();
		hm1.put("클래스", "B");
		hm1.put("이름", "길정이");
		hm1.put("나이", "25");
		hm1.put("성별", "남자");
		al.add(hm1);
		
		HashMap<Object, Object> hm2 = new HashMap<Object, Object>();
		hm2.put("클래스", "C");
		hm2.put("이름", "윤정이");
		hm2.put("나이", "22");
		hm2.put("성별", "여자");
		al.add(hm2);
		
		HashMap<Object, Object> hm3 = new HashMap<Object, Object>();
		hm3.put("클래스", "D");
		hm3.put("이름", "동동이");
		hm3.put("나이", "5");
		hm3.put("성별", "여자");
		al.add(hm3);
		
		for(int i = 0; i < al.size(); i++)
		{
			HashMap<Object, Object> result = al.get(i);
			System.out.print(result.get("클래스") + ",");
			System.out.print(result.get("이름") + ",");
			System.out.print(result.get("나이") + ",");
			System.out.println(result.get("성별"));
		}
	}
}
