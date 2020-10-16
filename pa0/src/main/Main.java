
public class Main
{
	public static void main(String[] args)
	{
		Sorter sorter = new Sorter();
		
		int[] asc = sorter.descending(new int[] {10, 20, 80, 30, 60, 50, 
                     110, 100, 130, 170});
		for(int x = 0; x < asc.length; x++) {
			System.out.println(asc[x]);	
		}
		
		System.out.println("Hello, world\n");
	}
}