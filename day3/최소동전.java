import java.util.Scanner;

public class Solution {
	static int [][] adj;
	static int [] ind;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			adj = new int[N+1][N+1];
			ind = new int[N+1];
			for(int i = 0; i < K; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				adj[n1][n2] = 1;
				ind[n2]++;
			}
			System.out.println("#"+tc+" "+find(N));
		}
	}
	public static int find(int k)
	{
		int [] q = new int[k+1];
		int front = -1;
		int rear = -1;
		int [] coin = new int[k+1];
		int maxV = 0;
		// 진입차수가 0인 노드 enqueue, 동전 개수 결정
		for(int i=1; i<=k; i++)
		{
			if(ind[i] == 0)
			{
				q[++rear] = i;
				coin[i] = 1;
			}
		}
		while( front != rear )
		{
			int n = q[++front];
			
			for(int i= 1; i <= k; i++)
			{
				if( adj[n][i] != 0)
				{
					ind[i]--; // n에 인접인 i의 진이차수 감소
					if(ind[i]==0)
					{
						q[++rear] = i;
						coin[i] = coin[n] + 1;
						maxV = coin[i];
					}
				}
			}
		}
//		int maxV = 0;
//		for(int i = 1; i <= k; i++)
//		{
//			if(maxV < coin[i])
//			{
//				maxV = coin[i];
//			}
//		}
		return maxV;
	}
}
