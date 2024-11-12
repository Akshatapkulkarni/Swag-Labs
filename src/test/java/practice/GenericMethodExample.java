package practice;

public class GenericMethodExample
{
	public static void main(String[] args) 
	{
		int sum= add(10,20);
		System.out.println(sum);
		add(20,30);
		add(20,20,20);
		System.out.println(add(sum,10,10));
	}
	
	public static int add(int a,int b)
	{
		int c = a+b;
		return c;
	}
	
	public static int add(int a , int b , int s)
	{
		int c = a+b+s;
		return c;
	}
}
