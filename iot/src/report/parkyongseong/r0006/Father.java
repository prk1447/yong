package report.parkyongseong.r0006;

public class Father 
{
	private String adress = "서울시 강서구 가양동";
	private int age = 65;
	private String name = "박철수";
	
	int getAge()
	{
		return age;
	}
	
	int setAge(int age)
	{
		this.age = age;
		return this.age;
	}
	
	String getAdress()
	{
		return adress;
	}
	
	String setAdress(String adress)
	{
		this.adress = adress;
		return this.adress;
	}
	
	String getName()
	{
		return name;
	}
	
	String setName(String name)
	{
		this.name = name;
		return this.name;
	}
}
