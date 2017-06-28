package report.parkyongseong.r0006;

public class Son extends Father
{
	
	public static void main(String[] args)
	{
		Son son = new Son();
		
		son.setAge(21);
		System.out.println(son.getAge());
		son.setAdress("서울시 서초구 방배동");
		System.out.println(son.getAdress());
		son.setName("박용성");
		System.out.println(son.getName());
		
		Father fa = new Father();
		System.out.println(fa.getAge());
		System.out.println(fa.getAdress());
		System.out.println(fa.getName());
		
		
		
	}
}
