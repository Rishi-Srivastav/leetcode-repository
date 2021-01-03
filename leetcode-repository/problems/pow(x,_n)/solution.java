class Solution {
   public double myPow(double x, int n) {
            Map<Integer, Double> power = new HashMap<>();
            power.put(1, x);

            double sum = 1;
            int n1 = n;
            int rem = 0;
            if (n < 0) {
                if (n == Integer.MIN_VALUE) {
                    n = Integer.MAX_VALUE;
                    rem = Math.abs(Integer.MAX_VALUE + Integer.MIN_VALUE);
                } else
                    n = -n;
            }

            for (int i = 1; i <= n; i = i * 2) {
                if (n >= 2 * i) {
                    power.put(2 * i, power.get(i) * power.get(i));
                    sum *= power.get(2 * i);
                    n = n - 2 * i;
                }
            }
            while (n+rem > 0) {
                sum *= x;
                n--;
            }
            if (n1 > 0)
                return sum;
            return 1 / sum;
        }
}