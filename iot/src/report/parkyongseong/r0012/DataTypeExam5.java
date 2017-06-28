package report.parkyongseong.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam5
{
	public static void main(String[] args)
	{
		DataTypeExam4 dte4 = new DataTypeExam4();
		ArrayList<HashMap<Object, Object>> al = new ArrayList<HashMap<Object, Object>>();
		for(int i = 0; i < 10; i++)
		{
			al.add(dte4.getHashMap());
		}
		
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
