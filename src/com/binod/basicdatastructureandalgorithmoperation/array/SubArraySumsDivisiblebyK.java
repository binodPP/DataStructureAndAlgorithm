package com.binod.basicdatastructureandalgorithmoperation.array;

public class SubArraySumsDivisiblebyK {
    public static void main(String[] args) {
        int[] A={4,5,0,-2,-3,1};

        System.out.println("Subarray count is : "+subarraysDivByKByUsingArrayMethod(A,5));
    }


    private static int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        int sum = 0, count = 0;
        map[0] = 1;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) {
                sum += K;
            }
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

        private static int subarraysDivByKUsingDiffrentMethod(int[] A, int K) {
            int N = A.length, sum = 0, ans = 0;
            int[] map = new int[K];
            map[0] = 1;
            for (int i = 1; i <= N; i++) {
                sum = sum + A[i-1];
                int key = (sum % K + K) % K;
                ans += map[key];
                map[key]++;
            }
            return ans;
        }


    private static int subarraysDivByKByUsingArrayMethod(int[] A, int K) {
        int[] sum = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + A[i];
        }

        int ans = 0;
        if (sum[0] % K == 0) ans++;

        for (int i = 1; i < sum.length; i++) {
            if (sum[i] % K == 0) ans++;
            for (int j = i - 1; j >= 0; j--) {
                int tmp = sum[i] - sum[j];
                if (tmp % K == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}