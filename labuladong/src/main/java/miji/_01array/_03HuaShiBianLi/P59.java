package miji._01array._03HuaShiBianLi;

import java.util.Arrays;

class P59 {
    public static void main(String[] args) {
        int[][] arr = new P59().generateMatrix(5);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
	public int[][] generateMatrix(int n) {
		int[][] arr = new int[n][n];

		int shang = 0;
		int xia = n - 1;
		int zuo = 0;
		int you = n - 1;

		int num = 1;

		while (num <= n * n) {
			if (shang <= xia) {
				for (int i = zuo; i <= you; i++) {
                    arr[shang][i]=num;
                    num++;
				}
                shang++;
			}
            if (zuo <= you) {
                for (int i = shang; i <=xia ; i++) {
                    arr[i][you]=num;
                    num++;
                }
                you--;
            }
            if (shang <= xia) {
                for (int i = you; i >=zuo ; i--) {
                    arr[xia][i]=num++;
                }
                xia--;
            }
            if (zuo <= you) {
                for (int i = xia; i >=shang ; i--) {
                    arr[i][zuo]=num++;
                }
                zuo++;
            }
		}
        return arr;

	}
}