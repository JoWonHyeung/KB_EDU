package com.edu.algorithm.pc.test;

public class CombinationTest2 {
	static int[] ans;
	static int K=4, N=3, count=0;	//	1~K카드 중에서 중복X 순서대로 선택

	public static void main(String[] args) {
		ans = new int[K];
		//	항상 가장위의 함수를 호출하면 됨
		dfs(0, 0, 0);
		System.out.println(count);
	}
	
	public static void dfs(int n, int cnt, int idx) {
		//	[0] 종료조건(n관련) 확인 후 정답처리
		if (n==K) {
			if (cnt==N) {	// 선택한 개수가 N개면
				for (int i=0; i<N; i++) 
					System.out.print(ans[i]);
				System.out.println();
				count++;
			}
			return;
		}
		
		ans[idx]=(n+1);
		dfs(n+1, cnt+1, idx+1);	//	선택하는 경우, 정답을 저장
		dfs(n+1, cnt, idx);		//	선택하지 않는 경우
	}

}
