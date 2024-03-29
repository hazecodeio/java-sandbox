package org.hsmak.hackerrank;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunnerOfWarmUps {

}

class SockMerchant {
    public static void main(String[] args) {
        System.out.println(sockMerchant(new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    public static int sockMerchant(int[] ar) {
        Map<Integer, Integer> countSocks = new HashMap<>();

        for (int i : ar) {
            if (countSocks.containsKey(i))
                countSocks.put(i, countSocks.get(i) + 1);
            else
                countSocks.put(i, 1);
        }

        int c = 0;
        for (int i : countSocks.values()) {
            for (; i > 0; i--)
                if (i % 2 == 0)
                    c++;
        }

        return c;
    }

    public static int sockMerchant2(int[] c) {
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < c.length; i++) {
            if (!colors.contains(c[i])) {
                colors.add(c[i]);
            } else {
                pairs++;
                colors.remove(c[i]);
            }
        }
        return pairs;
    }
}

class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys2("UDDDUDUU"));
    }

    public static int countingValleys(String path) {
        // Write your code here
        String[] stepsArr = path.split("");
        int valleyCount = 0;
        int stepCount = 0;
        boolean seaLevelChange = true;
        for (String step : stepsArr) {
            if (step.equals("D"))
                stepCount--;
            if (step.equals("U"))
                stepCount++;

            if (stepCount < 0 && seaLevelChange) {
                valleyCount++;
                seaLevelChange = false;
            }
            if (stepCount == 0)
                seaLevelChange = true;
        }
        return valleyCount;
    }

    public static int countingValleys2(String path) {
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for (char c : path.toCharArray()) {
            if (c == 'U') ++lvl;
            if (c == 'D') --lvl;

            // if we just came UP to sea level
            if (lvl == 0 && c == 'U')
                ++v;
        }
        return v;
    }
}

class JumpingOnClouds {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));
    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == 0)
                i++;
            count++;
        }
        return count;
    }
}

class EqualizeArray {

    public static void main(String[] args) {
        int[] nums = Arrays.stream("69 86 100 69 55 83 15 69 86 69 79 16 86 24 24 55 16 69 100 79 16 83 83 79 15 15 86 16 55 18 100 100 86 16 83 79 86 83 100 83 55 15 86 86 55 100 55 18 55 100 86 69 83 24 16 55 100 16 100 24 16 55 15 79 16 18 16 16 83 83 69 18 100 79 16 24 79 16 69 86 83 79 83 18 15 100 24 83"
                        .split(" "))
                .mapToInt(Integer::valueOf).toArray();

        System.out.println(equalizeArray(nums));
    }

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer i : arr) {
            if (!m.containsKey(i))
                m.put(i, 1);
            else
                m.put(i, (m.get(i)) + 1);
        }
        return arr.length - m.values().stream().mapToInt(i -> i).max().getAsInt();
    }
}

class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("aa", 3));
        System.out.println(repeatedString("a", 10000000000000L));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long size = s.length(), repeated = n / size;
        long rem = n - (size * repeated);
        int extra = 0;

        long count = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == 'a').count();

        for (int i = 0; i < rem; i++) {
            if (s.charAt(i) == 'a') {
                ++extra;
            }
        }

        repeated = (repeated * count) + extra;

        return repeated;
    }
}


class CircularArrayRotation {

    public static void main(String[] args) {
        Arrays.stream(circularArrayRotation(new int[]{1, 2, 3}, 1, new int[]{0, 1})).forEach(System.out::println);
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int[] arr = new int[a.length];

        for (int i = 0; i < a.length; i++)
            arr[(i + k) % a.length] = a[i];

        for (int i = 0; i < queries.length; i++)
            queries[i] = arr[queries[i]];

        return queries;
    }
}

class ExtraLongFactorials {

    public static void main(String[] args) {
        extraLongFactorials(5);
    }

    static void extraLongFactorials(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);
    }
}

/**
 * O(n log(n)) solution.
 * 1. find the LCM of all the integers of array A.
 * 2. find the GCD of all the integers of array B.
 * 3. Count the number of multiples of LCM that evenly divides the GCD.
 */
class BetweenTwoSets {
    public static void main(String[] args) {
        System.out.println(getTotalX(List.of(2, 6), List.of(24, 36)));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int f = lcm(a);
        int l = gcd(b);
        int count = 0;
        for (int i = f, j = 2; i <= l; i = f * j, j++) {
            if (l % i == 0) {
                count++;
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static int gcd(List<Integer> l) {
        int result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = gcd(result, l.get(i));
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> l) {
        int result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = lcm(result, l.get(i));
        }
        return result;
    }
}

class BreakingTheRecords {
    public static void main(String[] args) {
        System.out.println(breakingRecords(new int[]{3, 4, 21, 36, 10, 28, 35, 5, 24, 42}));
    }

    static int[] breakingRecords(int[] scores) {
        int maxVal = scores[0], minVal = scores[0];
        int maxC = 0, minC = 0;

        for (int val : scores) {
            if (maxVal > val) {
                maxVal = val;
                maxC++;
            }
            if (minVal < val) {
                minVal = val;
                minC++;
            }
        }
        return new int[]{minC, maxC};
    }
}

class MakeAnagram {

    static int makeAnagram(String a, String b) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : a.toCharArray()) {
//            int cnt = freqMap.containsKey(c) ? freqMap.get(c) : 0;
            int cnt = freqMap.getOrDefault(c, 0);
            freqMap.put(c, (cnt + 1));
        }

        for (char c : b.toCharArray()) {
//            int cnt = freqMap.containsKey(c) ? freqMap.get(c) : 0;
            int cnt = freqMap.getOrDefault(c, 0);
            freqMap.put(c, (cnt - 1));
        }

        List<Integer> values = new ArrayList<>(freqMap.values());
        int total = 0;
        for (Integer v : values) {
            total += Math.abs(v);
        }
        return total;
    }
}

class CountHoles {


    static int countHoles(int num) { // via algebraic calculations
        int[] hole = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};

        int holes = 0;

        while (num > 0) {
            int d = num % 10; // Last digit in num
            holes += hole[d];
            num /= 10; // Remove last digit
        }

        return holes;
    }

    static int countHoles2(int num) {
        int[] hole = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};

        char[] chars = String.valueOf(num).toCharArray();
        int holes = 0;

        for (char c : chars)
            holes += hole[Character.getNumericValue(c)];

        return holes;
    }

    static int countHolesViaMap(int num) {
        Map<Integer, Integer> hole = Map.of(
                0, 1,
                1, 0,
                2, 0,
                3, 0,
                4, 1,
                5, 0,
                6, 1,
                7, 0,
                8, 2,
                9, 1);

        char[] chars = String.valueOf(num).toCharArray();
        int holes = 0;

        for (char c : chars)
            holes += hole.get(Character.getNumericValue(c));

        return holes;
    }

    public static void main(String[] args) {
        int num = 6457819;
        System.out.println(countHoles(num));
        System.out.println(countHoles2(num));
        System.out.println(countHolesViaMap(num));
    }
}

class MaximumSubArraySum {

    Function<Integer[], Integer> strategy;

    MaximumSubArraySum(Function<Integer[], Integer> strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {

        EnumSet<StrategyE> strategies = EnumSet.allOf(StrategyE.class);
        for (StrategyE s : strategies) {
            System.out.println("--- " + s.name() + "---");
            MaximumSubArraySum m = new MaximumSubArraySum(s);

            for (Integer[] testCase : testCases()) {
                int maxSubArraySum = m.maxSubArraySum(testCase);
                System.out.println("Maximum contiguous sum is " + maxSubArraySum);
            }
        }
    }

    static List<Integer[]> testCases() {
        List<Integer[]> testData = List.of(
                new Integer[]{-2, -3, 4, -1, -2, 1, 5, -3},
                new Integer[]{-2, 1, -3, 4, -1, 2, 1, -5, 4},
                new Integer[]{5, 4, -1, 7, 8},
                new Integer[]{-2, -1},
                new Integer[]{1}
        );
        return testData;
    }

    Integer maxSubArraySum(Integer[] nums) {
        return strategy.apply(nums);
    }

    enum StrategyE implements Function<Integer[], Integer> {
        S1 {
            @Override
            public Integer apply(Integer[] nums) {
                int maxSum = nums[0];
                int currentSum = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    if (currentSum < 0)
                        currentSum = nums[i];
                    else
                        currentSum = currentSum + nums[i];

                    maxSum = Math.max(currentSum, maxSum);
                }
                return maxSum;
            }
        },
        S2 {
            @Override
            public Integer apply(Integer[] nums) {
                int maxSum = nums[0];
                int currentSum = 0;
                for (int i = 0; i < nums.length; i++) {
                    currentSum += nums[i];
                    maxSum = Math.max(currentSum, maxSum);
                    if (currentSum < 0) {
                        currentSum = 0;
                    }
                }
                return maxSum;
            }
        },
        S3 {
            @Override
            public Integer apply(Integer[] nums) {
                int maxSum = nums[0], currentSum = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    currentSum = Math.max(currentSum + nums[i], nums[i]);
                    maxSum = Math.max(currentSum, maxSum);
                }
                return maxSum;
            }
        }
    }
}

class LowestCommonAncestorInBinaryTree {
    static Node lcaIter(Node current, int v1, int v2) {
        while (current != null) {
            if (current.data > v1 && current.data > v2) {
                current = current.left;
            } else if (current.data < v1 && current.data < v2) {
                current = current.right;
            } else {
                break;
            }
        }
        return current;
    }

    static Node lcaRec(Node current, int v1, int v2) {
        // smaller than both
        if (current.data < v1 && current.data < v2) {
            return lcaRec(current.right, v1, v2);
        }
        // larger than both
        if (current.data > v1 && current.data > v2) {
            return lcaRec(current.left, v1, v2);
        }
        // already found
        return current;
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}

class WebsitePagination {
    public static void main(String[] args) {
        List<List<String>> l = new ArrayList<>(List.of(
                new ArrayList<>(List.of("1", "5", "9")),
                new ArrayList<>(List.of("2", "6", "8")),
                new ArrayList<>(List.of("3", "7", "7"))));
        System.out.println(l);
        sort(l, 2, 0);
        System.out.println(l);
        System.out.println(paging(l, 1, 2));
    }

    static List<List<String>> sort(List<List<String>> l, int sortCol, int sortOrder) {
        Comparator<List<String>> listComparator;
        if (sortOrder == 0)
            listComparator = new ListComparator(sortCol);
        else
            listComparator = new ListComparator(sortCol).reversed();

        Collections.sort(l, listComparator);
        return l;
    }

    static List<String> paging(List<List<String>> items, int pageNumber, int itemsPerPage) {
        return items.stream().skip(items.size() - pageNumber - 1).flatMap(l -> l.stream().limit(itemsPerPage)).collect(Collectors.toList());
    }

    static class ListComparator implements Comparator<List<String>> {
        int column;

        public ListComparator(int column) {
            this.column = column;
        }

        @Override
        public int compare(List<String> o1, List<String> o2) {
            return o1.get(column).compareTo(o2.get(column));
        }
    }
}