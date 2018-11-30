import java.util.Scanner;

/*
...M#
FF.#F
..#F.
.F.FF
MF.FF
 */
public class Solution {
	static char [][] map;
	static char man;
	static int [][] manpos;
	static int [][] status;
	static int maxV;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new char [5][5];
		status = new int [5][5];
		manpos = new int[2][2];
		man = 0;
		maxV = 0;
		for(int i = 0; i < 5; i++)
		{
			String st = sc.next();
			for(int j = 0; j < 5; j++)
			{
				map[i][j] = st.charAt(j);
				if(map[i][j]=='M')
				{
					manpos[man][0] = i;
					manpos[man][1] = j;
					man++;
				}
			}
		}		
		find(0, man, 0);
		System.out.println(maxV);
	}
	public static void find(int n, int k, int s)
	{
		
		int [] di = {5, 3};
		int [] dj = {3, 5};
 		if(n==k)
		{
			if(maxV < s)
				maxV = s;
		}
		else
		{
			// right, (5, 3), (3, 5)
			for(int m = 0; m < 2; m++)
			{
				int supressed = 0;
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][0] - di[m]/2 + i;
						int c = manpos[n][1] + 1 + j;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								if(status[r][c] == 0)
									supressed++;
								status[r][c]++;
							}
						}
					}
				}
				find(n+1, k, s + supressed);
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][0] - di[m]/2 + i;
						int c = manpos[n][1] + 1 + j;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								status[r][c]--;
							}
						}
					}
				}
			} // right
			// down, (5, 3), (3, 5)
			for(int m = 0; m < 2; m++)
			{
				int supressed = 0;
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][0] + 1 + j;
						int c = manpos[n][1] - di[m]/2 + i;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								if(status[r][c] == 0)
									supressed++;
								status[r][c]++;
							}
						}
					}
				}
				find(n+1, k, s + supressed);
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][0] + 1 + j;
						int c = manpos[n][1] - di[m]/2 + i;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								status[r][c]--;
							}
						}
					}
				}
			} // down
			// left, (5, 3), (3, 5)
			for(int m = 0; m < 2; m++)
			{
				int supressed = 0;
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][0] - di[m]/2 + i;
						int c = manpos[n][1] - 1 - j;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								if(status[r][c] == 0)
									supressed++;
								status[r][c]++;
							}
						}
					}
				}
				find(n+1, k, s + supressed);
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][0] - di[m]/2 + i;
						int c = manpos[n][1] - 1 - j;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								status[r][c]--;
							}
						}
					}
				}
			} // left
			// up, (5, 3), (3, 5)
			for(int m = 0; m < 2; m++)
			{
				int supressed = 0;
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][1] - 1 - j;
						int c = manpos[n][0] - di[m]/2 + i;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								if(status[r][c] == 0)
									supressed++;
								status[r][c]++;
							}
						}
					}
				}
				find(n+1, k, s + supressed);
				for(int i = 0; i < di[m]; i++)
				{
					for(int j = 0; j < dj[m]; j++)
					{
						int r = manpos[n][1] - 1 - j;
						int c = manpos[n][0] - di[m]/2 + i;
						if( r >= 0 && r < 5 && c >= 0 && c < 5)
						{
							if(map[r][c]=='#')
								break;
							else if(map[r][c]=='F')
							{
								status[r][c]--;
							}
						}
					}
				}
			} // up
		}
	}
}
