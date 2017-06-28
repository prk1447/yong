package report.parkyongseong.r0010;

import java.util.ArrayList;

public class ListExam<T> extends ArrayList 
{
	ListExam()
	{
		
	}
	
	public String toString()
	{
		return "아무것도 입력받지 않앗습니다.";
	}
	
	public static void main(String[] args)
	{
		ListExam<MapExam> list = new ListExam<MapExam>();
		MapExam me = new MapExam();
		//me.put("test", "test");
		list.add(me);
		System.out.println(me);
	}
}
