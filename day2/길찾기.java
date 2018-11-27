import java.util.Scanner;

public class Solution {
	static int[] c1;
	static int[] c2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++)
		{
			int T = sc.nextInt();
			int E = sc.nextInt();
			c1 = new int[100];
			c2 = new int[100];
			for(int i = 0; i < E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if(c1[n1]==0)
					c1[n1] = n2;
				else
					c2[n1] = n2;
			}
			System.out.println("#"+" "+tc+" "+find(0));
		}
	}
	public static int find(int n)
	{
		if(n == 99)
		{
			return 1;
		}
		else
		{
			if(c1[n] != 0)
				if(find(c1[n])==1)
					return 1;
			if(c2[n] != 0)
				if(find(c2[n])==1)
					return 1;
			return 0;
		}
	}
}
