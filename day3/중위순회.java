import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static char [] tree;
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
			int N = sc.nextInt();
			tree = new char [N+1];
			for(int i = 1; i <= N; i++)
			{
				int a = sc.nextInt();
				tree[i] = sc.next().charAt(0);
				if(a*2<=N)
				{
					sc.nextInt();
				}
				if((a*2+1)<=N)
				{
					sc.nextInt();
				}
			}
			System.out.print("#"+tc+" ");
			find(1, N);
			System.out.println();
		}
	}
	public static void find(int n, int k)
	{
		if(n <= k)
		{
			find(n*2, k);
			System.out.print(tree[n]);
			find(n*2+1, k);
		}
	}

}
