package com.programmers.level3;

/** [다음 큰 숫자]
 * 어떤 수 N(1≤N≤1,000,000) 이 주어졌을 때, N의 다음 큰 숫자는 다음과 같습니다.
 * N의 다음 큰 숫자는 N을 2진수로 바꾸었을 때의 1의 개수와 같은 개수로 이루어진 수입니다.
 * 1번째 조건을 만족하는 숫자들 중 N보다 큰 수 중에서 가장 작은 숫자를 찾아야 합니다.
 * 예를 들어, 78을 2진수로 바꾸면 1001110 이며, 78의 다음 큰 숫자는 83으로 2진수는 1010011 입니다.
 * N이 주어질 때, N의 다음 큰 숫자를 찾는 nextBigNumber 함수를 완성하세요.
 */

public class NextBigNumber {
	public int nextBigNumber(int n) {
	/*	
		int answer = 0;

		return answer;
	*/
		// N 1의 개수 세기
		int cntN = 0;
		String binaryN = Integer.toBinaryString(n);
		for (char c : binaryN.toCharArray()) {
			if (c == '1') {
				cntN++;
			}
		}
		// N 다음 숫자 찾기
		while (true) {
			n = n + 1;
			int cntFindN = 0;
			String findN = Integer.toBinaryString(n);
			for (char c : findN.toCharArray()) {
				if (c == '1') {
					cntFindN++;
				}
			}
			if (cntN == cntFindN) {
				break;
			}
		}
		return n;
		
	/**
	 * 다른 정답
		int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
		return n + postPattern | smallPattern;
		
		int a = Integer.bitCount(n);
		int compare = n+1;
		while(true) {
			if(Integer.bitCount(compare)==a)
				break;
			compare++;
		}
		return compare;
	 */
	}

	public static void main(String[] args) {
		NextBigNumber test = new NextBigNumber();
		int n = 78;
		System.out.println(test.nextBigNumber(n));
	}
}
