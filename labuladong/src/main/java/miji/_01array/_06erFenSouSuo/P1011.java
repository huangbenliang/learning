package miji._01array._06erFensousuo;

public class P1011 {
    public static void main(String[] args) {
        System.out.println(new P1011().f(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
        System.out.println(new P1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] weights, int x) {
        int t = 0, res = 1;
        for (int i = 0; i < weights.length; i++) {
            int weight=weights[i];
            if (t + weight > x) {
                res++;
                t = weight;
            } else {
                t += weight;
            }
        }
        return res;
    }
}
