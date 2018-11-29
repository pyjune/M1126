import java.util.Scanner;
/*
1 -> T
3 -> N
2 2 -> N 개의 부착 위치 (벽을 벗어나는 경우 경계까지 부착)
3 5
5 4
2 5 -> N 개의 시트지 크기 
3 3
5 4
// 입력용
1
3
2 2
3 5
5 4
2 5 
3 3
5 4
// 최대인 경우 39(겹치지 않게 붙이는 경우)
배치 0-1(가로), 1-0(가로), 2-2(가로)
[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
 [0, 0, 1, 1, 1, 0, 0, 0, 0, 0], 
 [0, 0, 1, 1, 1, 1, 1, 1, 1, 1], 
 [0, 0, 1, 1, 1, 1, 1, 1, 1, 1], 
 [0, 0, 0, 0, 1, 1, 1, 1, 1, 0], 
 [0, 0, 0, 0, 1, 1, 1, 1, 1, 0], 
 [0, 0, 0, 0, 1, 1, 1, 1, 1, 0], 
 [0, 0, 0, 0, 1, 1, 1, 1, 1, 0], 
 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]
 */
public class Solution {
	static int [][] sh;
	static int [][] pos;
	static int [][] p; // 순열(시트지 부착 순서)
	static int [][] wall;
	static int cnt;
	static int [] used;
	static int N;
	static int maxV;
	static int [] perm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			sh = new int [N][2];
			pos = new int [N][2];
			wall = new int[10][10];
			p = new int[120][N]; // 최대  5!개의 순열 저장..
			cnt = 0;
			maxV = 0;
			used = new int[N];
			perm = new int[N];
			for(int i = 0; i < N; i++)
			{
				pos[i][0] = sc.nextInt();
				pos[i][1] = sc.nextInt(); 
			}
			for(int i = 0; i < N; i++)
			{
				sh[i][0] = sc.nextInt();
				sh[i][1] = sc.nextInt(); 
			}
			npr(0, N); // 부착 위치 순열 생성
			for(int i = 0; i < cnt; i++) // 순열별로 부착
			{
				find(i, 0, N, 0); //i번 순열 이용해 0번 부터 N개 부착
			}
			System.out.println("#"+tc+" "+maxV);
		}
	}
	// ip 순열 번호, n번 위치, k 총 시트지 수, s 부착 면적 
	public static void find(int ip, int n, int k, int s)
	{
		if(n==k) // 부착 완료
		{
			if(maxV < s)
			{
				maxV = s;
			}
		}
		else
		{
			// 가로 부착
			int r = draw(ip, n, 0); // n번에 가로 붙이기
			find(ip, n+1, k, s+r);
			erase(ip, n, 0); // n번에 가로 붙인 시트지 제거
			
			// 세로 부착
			r = draw(ip, n, 1);
			find(ip, n+1, k, s+r);
			erase(ip, n, 1); // n번에 세로 붙인 시트지 제거
		}
	}
	public static void erase(int ip, int n, int v)
	{
		// n번에 붙일 시트지 번호
		int num = p[ip][n];
		int hor = sh[num][0]; // 가로 크기
		int ver = sh[num][1]; // 세로 크기
		if(v==1) // 세로인 경우  가로 세로 교환
		{
			hor = sh[num][1];
			ver = sh[num][0];
		}
		for(int i=0; i<ver; i++)
		{
			for(int j=0; j<hor; j++)
			{
				if((pos[n][0]+i<10)&&(pos[n][1]+j<10)) // 영역 내부만
				{
						wall[pos[n][0]+i][pos[n][1]+j] -= 1; // 0으로 만들면 다른 시트지도 제거됨
				}
			}
		}
	}
	public static int draw(int ip, int n, int v)
	{
		// n번에 붙일 시트지 번호
		int num = p[ip][n];
		int hor = sh[num][0]; // 가로 크기
		int ver = sh[num][1]; // 세로 크기
		int cnt = 0;
		if(v==1) // 세로인 경우  가로 세로 교환
		{
			hor = sh[num][1];
			ver = sh[num][0];
		}
		for(int i=0; i<ver; i++)
		{
			for(int j=0; j<hor; j++)
			{
				if((pos[n][0]+i<10)&&(pos[n][1]+j<10)) // 영역 내부만
				{
					if(wall[pos[n][0]+i][pos[n][1]+j]==0) //  겹친 공간 제외
					{
						cnt++;
					}
					wall[pos[n][0]+i][pos[n][1]+j] += 1; //겹친 영역 표시
						
				}
			}
		}
		return cnt; // 겹치지 않게 추가된 영역 크기 리턴
	}
	public static void npr(int n, int k)
	{
		if(n==k)
		{
			System.arraycopy(perm, 0, p[cnt], 0, k);
			cnt++;
		}
		else
		{
			for(int i = 0; i < k; i++)
			{
				if(used[i]==0)
				{
					perm[n] = i;
					used[i] = 1;
					npr(n+1, k);
					used[i] = 0;
				}
			}
		}
	}
}
