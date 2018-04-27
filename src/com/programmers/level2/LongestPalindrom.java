package com.programmers.level2;

/** [가장 긴 팰린드롬]
 * 앞뒤를 뒤집어도 똑같은 문자열을 palindrome이라고 합니다.
 * longest_palindrom함수는 문자열 s를 매개변수로 입력받습니다.
 * s의 부분문자열중 가장 긴 palindrom의 길이를 리턴하는 함수를 완성하세요.
 * 예를들어 s가 토마토맛토마토이면 7을 리턴하고 토마토맛있어이면 3을 리턴합니다.
 */

public class LongestPalindrom {
	
	public int longestPalindrom(String str) {
		
		StringBuffer sb = new StringBuffer(str);
		String reverseStr = sb.reverse().toString();
		if (str.equals(reverseStr)) {
			return str.length();
		}
		else {
			int a = longestPalindrom(str.substring(0, str.length() - 1));
			int b = longestPalindrom(str.substring(1, str.length()));
			return Math.max(a, b);
		}
	}
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LongestPalindrom lp = new LongestPalindrom();
		System.out.println(lp.longestPalindrom("토마토맛있어"));
	}
}
