package abc;
import java.util.Scanner;
public class lianxi4 {
	//������
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.println("����������");
int num =input.nextInt();
for(int i=1;i<=num;i++)
{
	for(int j=1;j<=num-i;j++)
	{
		System.out.print(" ");
	}
	
	for(int j=1;j<=2*i-1;j++)
	{
		System.out.print("*");
	}
	System.out.println("");
}


}
}