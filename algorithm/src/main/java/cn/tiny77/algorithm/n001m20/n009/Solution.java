package cn.tiny77.algorithm.n001m20.n009;

/**
	 * 字符串方法
	 */
	class Solution {
		public boolean isPalindrome(int x) {
			char[] arr = String.valueOf(x).toCharArray();
			int i = 0;
			while (true) {
				if (i >= arr.length / 2) {
					break;
				}
				if (arr[i] != arr[arr.length - i - 1]) {
					return false;
				}
				i ++;
			}
			return true;
		}
	}