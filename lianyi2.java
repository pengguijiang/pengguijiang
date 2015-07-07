package abc;
public class lianyi2 {
	public static void main(String[] args)
	{//Êä³öÖÊÊı
		int num=0;
		for(int i=2;i<=100;i++){
			boolean flag=true;
		for(int j=2;j<i;j++){
			if(i%j==0)
			{
				flag =false;
				break;
			}
		}
		if(flag){
			System.out.println(i);
			num++;
		}
	}
		System.out.println(num);
}
}