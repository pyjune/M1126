import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	static int [][] map;
	static int N; 
	static int [][] visited;
	static int [] block;
	static int [][] q;

	static int cnt;
	static int num;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int [25][25];
		visited = new int[25][25];
		block = new int[313];

		for(int i=0; i<N; i++)
		{
			String st = sc.next();
			for(int j = 0; j<N; j++)
			{
				map[i][j] = st.charAt(j)-'0';
			}
		}
		
		num = 0;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(map[i][j]!=0 && visited[i][j]==0)
				{
					//cnt = 0;
					//find(i, j);
					block[num++] = find2(i, j);
				}
			}
		}
		Arrays.sort(block, 0, num);
		System.out.println(num);
		for(int i = 0; i<num; i++)
		{
			System.out.println(block[i]);
		}
	}

	public static int find2(int r, int c)
	{
		int [] dr = { 0, 1, 0, -1};
		int [] dc = { 1, 0, -1, 0};
		q = new int[25*25][2];
		int front = -1;
		int rear = -1;
		rear++;
		q[rear][0] = r;
		q[rear][1] = c;
		visited[r][c] = 1;
		int cnt = 1;
		while(front!=rear)
		{
			front++;
			r = q[front][0];
			c = q[front][1];
			for(int i = 0; i<4; i++)
			{
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N)
				{
					if(map[nr][nc] != 0 && visited[nr][nc]==0)
					{
						rear++;
						q[rear][0] = nr;
						q[rear][1] = nc;
						visited[nr][nc] = 1;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
