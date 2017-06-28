package report.parkyongseong.r0005;

public class Robot 
{
	String name;			
	int age;				
	
	
	public Robot(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	void doKick()
	{
		System.out.println(age + "살먹은 " + name + " 이 발차기를 하였습니다.");
	}
	
	void doRun()
	{
		System.out.println(age + "살먹은 " + name + " 이 달리기를 하였습니다.");
	}
	
	void doChange()
	{
		System.out.println(age + "살먹은 " + name + " 이 변신을 하였습니다.");
	}
	
	public static void main(String[] args)
	{
		Robot bot = new Robot("지로봇", 4);
		bot.doKick();
		bot.doRun();
		bot.doChange();
	}
}
