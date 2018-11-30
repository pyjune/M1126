import java.util.Scanner;

public class Solution {
	static int maxV;
	static int [] box;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		box = new int[N];
		maxV = 0;
		for(int i=0; i<N; i++)
			box[i] = sc.nextInt();
		
		find(0, N, 0, 0);
		System.out.println(maxV);
		
	}
	public static void find(int n, int k, int s, int c)
	{
		if(n==k)
		{
			if(maxV<c)
				maxV = c;
		}
		else
		{
			// 사용
			if(s<box[n])
				find(n+1, k, box[n], c+1);
			// 미사용
			find(n+1, k, s, c);
		}
	}
}
	
