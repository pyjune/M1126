// sw expert 1949

import java.util.Scanner;

public class Solution {
	static int [][] map;
	static int [][] visited;
	static int N;
	static int K;
	static int maxV;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new int[N][N];
			maxV = 0;
			int si = 0;
			int sj = 0;
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					map[i][j] = sc.nextInt();
					if(map[si][sj]<map[i][j]) // 가장 높은 곳 찾기
					{
						si = i;
						sj = j;
					}
				}
			}
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(map[si][sj]==map[i][j])
					{
						find(i, j, 1, 1);
					}
				}
			}
			System.out.println("#"+tc+" "+maxV);
		}
	}
	// c 남은 깍기 횟수, e 방문 칸 수
	public static void find(int i, int j, int c, int e)
	{
		int [] di = { 0, 1, 0, -1};
		int [] dj = { 1, 0, -1, 0};
		
		if(maxV<e)
			maxV = e;
		visited[i][j] = 1;
		for(int k = 0; k < 4; k++) //주변에 더 낮은 칸을 찾아 이동
		{
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<N)
			{
				if(visited[ni][nj] == 0)
				{
					if(map[i][j]>map[ni][nj])
					{
						find(ni, nj, c, e+1);
					}
					else if((c>0)&&(map[i][j]>map[ni][nj]-K)) //  깎을 횟수가 남아있고, 깎아서 더 낮아지는 경우
					{
						int h = map[ni][nj];
						map[ni][nj] = map[i][j] - 1; // 갈 수 있는 최대 높이로 깎음..
						find(ni, nj, 0, e+1);// 깎을 수 있는 횟수 제한 후 이동
						map[ni][nj] = h; // 원래 높이로 복구..
					}
				}
			}
		}
		visited[i][j] = 0;
	}
}
