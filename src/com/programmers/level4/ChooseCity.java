package com.programmers.level4;

/** [공항 건설하기]
 * 1보다 큰 N개의 도시 중 한 곳에 공항을 지을 예정입니다.
 * 사람들의 편의를 위해 공항으로부터 각 사람들까지의 도시간 이동 거리가 최소가 되는 도시에 짓기로 하였습니다.
 * 편의상 도시는 일직선상에 놓여있다고 가정하며 좌표의 범위는 음수가 포함됩니다.
 * 또한 좌표는 정렬되어 있지 않습니다.
 * 직선상의 위치와 그 도시에 사는 사람들의 수가 주어질 때, 공항을 지을 도시의 위치를 반환해주는 함수 chooseCity 함수를 완성하세요.
 * 거리가 같은 도시가 2개 이상일 경우 위치가 더 작은 쪽의 도시를 선택하면 됩니다.
 * 예를 들어 다음과 같은 정보의 도시가 있다고 가정해 봅시다.
 * 위치	1	2	3
 * 인구수	5	2	3
 * 이 살 경우, 각각의 도시에 공항을 지었을 때의 사람들의 이동 거리는 8, 8, 12 이므로 1번 또는 2번에 지을 수 있지만, 1의 위치가 더 작으므로 1을 반환해주면 됩니다.
 */

public class ChooseCity {
	public int chooseCity(int n, int[][] city) {
	/*
		int answer = 0;

		return answer;
	*/
		int answer = 0;
		int distance = 0;
		int minIdx = 0;
		int minDis = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					// 위치에 사는 인구 이동 거리는 계산하지 않음
					;
				}
				else {
					// 다른 위치에 사는 인구에 대한 이동거리(사람 수 * 위치 차이)
					distance += city[j][1] * Math.abs((city[j][0] - city[i][0]));
				}
			}
			if (i == 0) {
				minDis = distance;
			}
			// 현재거리 값이 최소값으로 되어야 한다면
			if (distance < minDis) {
				minDis = distance;
				minIdx = i;
			}
			else if (minDis == distance) {
				if (city[i][0] < city[minIdx][0]) {
					// 더 작은 idx 값으로 변경
					minIdx = i;
				}
			}
			distance = 0;
		}
		answer = city[minIdx][0];
		return answer;
	}

	public static void main(String[] args) {
		ChooseCity test = new ChooseCity();
		int tn = 3;
		int[][] tcity = { { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}
}
