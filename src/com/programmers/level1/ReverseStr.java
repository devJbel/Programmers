package com.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

/** [문자열 내림차순으로 배치하기]
 * reverseStr 메소드는 String형 변수 str을 매개변수로 입력받습니다.
 * str에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 String을 리턴해주세요.
 * str는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 * 예를들어 str이 Zbcdefg면 gfedcbZ을 리턴하면 됩니다.
 */

public class ReverseStr {
	public String reverseStr(String str){
	/*
		return "";
	*/
		
		/** 
		 * 아스키 코드값에서 대문자가 작은 값을 가짐
		 * A ~ Z : 65 ~ 90
		 * a ~ z : 97 ~ 122
		 */
		String[] result = str.split("");
		Arrays.sort(result, Collections.reverseOrder());
		return String.join("", result);
		
	/**
	 * 다른 정답
		char[] sol = str.toCharArray();
		Arrays.sort(sol);
		return new StringBuilder(new String(sol)).reverse().toString();
	 */
	}
	
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		ReverseStr rs = new ReverseStr();
		System.out.println( rs.reverseStr("Zbcdefg") );
	}
}
