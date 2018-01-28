package cn.tiny77.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("ab?");
		Matcher matcher = pattern.matcher("mmassaab");
		System.out.println(matcher.find());
		System.out.println(matcher.group());
		System.out.println(matcher.group());
	}

}
