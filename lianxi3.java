package abc;
import java.util.Scanner;
public class lianxi3 {
	//三角形
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入行数");
		int num =input.nextInt();
		for(int i=1;i<=num;i++)
		{		
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
				}
			System.out.println("");	
		}
	}

}
