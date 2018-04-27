package com.programmers.level4;

/** [가장 큰 정사각형 찾기]
 * O와 X로 채워진 표가 있습니다.
 * 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
 * 표에서 O로 이루어진 가장 큰 정사각형을 찾아 넓이를 반환하는 findLargestSquare 함수를 완성하세요.
 * 예를 들어
	1	2	3	4	5
	X	O	O	O	X
	X	O	O	O	O
	X	X	O	O	O
	X	X	O	O	O
	X	X	X	X	X
	가 있다면 정답은
	1	2	3	4	5
	X	O	O	O	X
	X	O	●	●	●
	X	X	●	●	●
	X	X	●	●	●
	X	X	X	X	X
	가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.
 */

public class FindLargestSquare {
	
	int[][] dp = new int[1001][1001];
	
	public int findLargestSquare(char[][] board) {
	/*
		int answer = 0;

		return answer;
	*/
		int ans = 0;
		int change[][] = new int[board.length][board[0].length];
		// 문자 O를 1로 변환
		for (int i = 0; i < change.length; i++) {
			for (int j = 0; j < change[0].length; j++) {
				if (board[i][j] == 'O') {
					change[i][j] = 1;
				}
			}
		}
		// i-1에서 i가 0일 때를 생각하여 1로 시작(j도 마찬가지)
		int row = change.length;
		int col = change[0].length;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (change[i-1][j-1] != 0) {
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		return ans * ans;
	}

	public static void main(String[] args) {
		FindLargestSquare test = new FindLargestSquare();
		char[][] board = {
				{ 'X', 'O', 'O', 'O', 'X' },
				{ 'X', 'O', 'O', 'O', 'O' },
				{ 'X', 'X', 'O', 'O', 'O' },
				{ 'X', 'X', 'O', 'O', 'O' },
				{ 'X', 'X', 'X', 'X', 'X' } };

		System.out.println(test.findLargestSquare(board));
	}
}
