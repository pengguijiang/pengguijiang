package abc;
public class lianxi5 {//ц╟ещ
	public static void main(String[] args) {
		int c[]={8,5,4,6}, tem=0;
		for(int i=c.length-1;i>0;i--)
		{
			for(int j=0;j<i;j++)
			{if(c[i]<c[j])
			{
				tem=c[j];
				c[j]=c[i];
				c[i]=tem;
			}
		}
		}
		for(int i=0;i<=c.length-1;i++){
			System.out.println(c[i]);
		}
		}
		
		

	}

