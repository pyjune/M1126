import java.util.Scanner;

public class Solution {
	static int [][] map;
	static int minV;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			map = new int[N][M];
			minV = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					map[i][j] = sc.nextInt();
				}
			}
			find2(0, 0, N, M, 0);
			if(minV == Integer.MAX_VALUE)
				minV = 0;
			System.out.println("#"+tc+" "+minV);
		}
	}
	public static void find(int r, int c, int N, int M, int s)
	{
		if((r==N-1)&&(c==M-1))
		{
			if(s+map[r][c]<minV)
				minV = s+map[r][c];
		}
		else if(map[r][c] == 0)
		{
			return;
		}
		else
		{
			if(c+1<M)
				find(r+0, c+1, N, M, s+map[r][c]);
			if(r+1<N)
				find(r+1, c+0, N, M, s+map[r][c]);
		}
	}
	public static void find2(int r, int c, int N, int M, int s)
	{
		int [] dr = { 0, 1};
		int [] dc = { 1, 0};
		if((r==N-1)&&(c==M-1))
		{
			if(s+map[r][c]<minV)
				minV = s+map[r][c];
		}
		else if(map[r][c] == 0)
		{
			return;
		}
		else
		{
			for(int i = 0; i < 2; i++)
			{
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < N && nc < M)				
					find2(nr, nc, N, M, s+map[r][c]);
			}
		}
	}
}
