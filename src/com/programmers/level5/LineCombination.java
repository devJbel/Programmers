package com.programmers.level5;

import java.util.ArrayList;
import java.util.Arrays;

/** [줄 서는 방법]
 * N명의 사람이 있을 때, N명의 사람을 서로 다른 방법으로 줄을 세우는 방법은 N!개가 존재합니다.
 * 이 때 각각의 사람들에게 번호를 매겨서 줄을 서는 방법을 표시합니다.
 * 예를들어 [1,2,3,4]는 1번 사람이 제일 앞에, 2번 사람이 2두번째에... 서 있는 상태를 나타냅니다.
 * 이러한 각각의 방법을 사전순으로 정렬했을때 K번째 방법으로 줄을 세우는 방법을 찾아 보려고 합니다.
 * 예를 들어 3명의 사람이 있다면 총 6개의 방법은 다음과 같이 정렬할 수 있습니다.
 * 1번째 방법은 [1,2,3]
 * 2번째 방법은 [1,3,2]
 * 3번째 방법은 [2,1,3]
 * 4번째 방법은 [2,3,1]
 * 5번째 방법은 [3,1,2]
 * 6번째 방법은 [3,2,1]
 * 이 때 K가 5이면 [3,1,2]가 그 방법입니다.
 * 사람의 수 N과 순서 K를 입력받아 K번째 방법으로 줄을 세우는 setAlign 함수를 완성해 보세요.
 * 예를 들어 setAlign(3,5)를 입력받는다면 [3,1,2]를 리턴해주면 됩니다.
 */

public class LineCombination {
	public int[] setAlign(int n, long k) {
	/*
		int[] answer = {};

		return answer;
	*/
		/**
		 * [1,2,3,4] [2,1,3,4] [3,1,2,4] [4,1,2,3]
		 * [1,2,4,3] [2,1,4,3] [3,1,4,2] [4,1,3,2]
		 * [1,3,2,4] [2,3,1,4] [3,2,1,4] [4,2,1,3]
		 * [1,3,4,2] [2,3,4,1] [3,2,4,1] [4,2,3,1]
		 * [1,4,2,3] [2,4,1,3] [3,4,1,2] [4,3,1,2]
		 * [1,4,3,2] [2,4,3,1] [3,4,2,1] [4,3,2,1]
		 * 4명이 줄을 서면, 4가지 종류의 배열이 생김(n명이 서면 n가지 종류의 배열)
		 * k번째 방법으로 세우는 방법일 때,
		 * 가장 첫번째 숫자: k / (n-1)!
		 * 두번째 숫자: (k % (n-1)) / (n-1 -1)!
		 * 두번째 숫자를 수행하면 몫1과 나머지0을 찾을 수 있는데(4명, 14번째일 경우)
		 * 나머지가 0일 경우에는 (몫-1)으로 첫번째숫자를 찾는다.
		 * 나머지가 0이면 그 그룹의 맨 마지막 값이므로 남아있는 수를 역순으로 배치
		 */
		int[] answer = new int[n];
		int index = 0;
		int tempResult;
		ArrayList<Integer> remainValues = new ArrayList<Integer>();
		long factorial = 1;
		int value = 0;
		long remain = k;
		
		// 1부터 n까지 값을 넣음
		for (int i = 1; i <= n; i++) {
			remainValues.add(i);
		}
		
		for (int i = n - 1; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				factorial *= j;
			}
			value = (int) (remain / factorial);
			remain = remain % factorial;
			
			if (remain == 0) {
				value--;
				tempResult = (int) remainValues.get(value);
				remainValues.remove(value);
				answer[index] = tempResult;
				index++;
				break;
			}
			
			tempResult = (int) remainValues.get(value);
			remainValues.remove(value);
			answer[index] = tempResult;
			index++;
			factorial = 1;
		}
		
		for (int i = remainValues.size() - 1; i >= 0; i--) {
			answer[index] = (int) remainValues.get(i);
			index++;
		}
		
		return answer;
	}
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
	}
}
