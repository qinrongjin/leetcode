package cn.tiny77.algorithm;

public class A010 {

	public static void main(String[] args) {
		System.out.println(new A010().maxArea(new int[]{0,2}));
	}

    public int maxArea(int[] height) {
		int pos[] = new int[height.length];
		int posSize = 0;
		for (int i = 0; i < height.length; i++) {
			if(posSize == 0 || height[pos[posSize-1]] < height[i]) {
				pos[posSize++] = i;
			}
		}
		int max = 0;
		
		return max;
	}

}
