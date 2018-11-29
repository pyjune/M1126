import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int [][] maze;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int sti = 0;
			int stj = 0;
			maze = new int[N][N];
			for(int i=0; i < N; i++)
			{
				String str = sc.next();
				for(int j = 0; j < N; j++)
				{
					maze[i][j] = str.charAt(j) - '0';
					if(maze[i][j] == 2)
					{
						sti = i;
						stj = j;
					}
				}
			}
			System.out.println("#"+tc+" "+bfs(sti, stj, N));
			//System.out.println("#"+tc+" "+find(sti, stj));
		}
	}
	public static int bfs(int i, int j, int N)
	{
		int [] di = {0, 1, 0, -1};
		int [] dj = {1, 0, -1, 0};
		int [] q = new int [20000];
		int front = -1;
		int rear = -1;
		int [][] visited = new int[N][N];
		// 시작점 enqueue
		q[++rear] = i;
		q[++rear] = j;
		visited[i][j] = 1;
		while(front != rear)
		{
			i = q[++front];
			j = q[++front];
			if(maze[i][j]==3)
				return 1;
			// 인접이고, 미방문이면 enqueue
			for(int k = 0; k < 4; k++)
			{
				int ni = i + di[k];
				int nj = j + dj[k];
				if(maze[ni][nj] != 1 && visited[ni][nj] == 0)
				{
					q[++rear] = ni;
					q[++rear] = nj;
					visited[ni][nj] = 1;
				}
			}
		}
		return 0;
	}
	public static int find(int i, int j)
	{
		int [] di = {0, 1, 0, -1};
		int [] dj = {1, 0, -1, 0};
		if(maze[i][j] == 3) // 목적지인 경우
		{
			return 1;
		}
		else if(maze[i][j] == 1)
		{
			return 0;
		}
		else
		{
			maze[i][j] = 1; // 탐색된 칸으로 표시
			for(int k = 0; k < 4; k++)
			{
				int ni = i + di[k];
				int nj = j + dj[k];
				if(find(ni, nj) == 1)
					return 1;
			}
			return 0;
		}
	}
}
