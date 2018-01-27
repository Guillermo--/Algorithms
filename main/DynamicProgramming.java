import java.util.*;

public class DynamicProgramming {

    private static int scanLargerString(int start, String input, char c) {
        for(int i = start; i < input.length(); i++) {
            if(c == input.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isSequence(String sub, String input) {
        int foundIndex = 0;
        for(int i = 0; i < sub.length(); i++) {
            foundIndex = scanLargerString(foundIndex, input, sub.charAt(i));
            if(foundIndex == -1) {
                return false;
            }
        }
        return true;
    }

    public static Map<Integer, List<String>> getSubsets(List<Integer> original) {
        Map<Integer, List<String>> cache = new HashMap<>();
        getSubsets(original, cache, 0);
        return cache;
    }

    private static List<String> getSubsets(List<Integer> original, Map<Integer, List<String>> cache, int current) {
        List<String> setsStartingHere = new ArrayList<>();
        String here = " " + original.get(current) + " ";
        setsStartingHere.add(here);

        for(int i = current + 1; i < original.size(); i++) {
            List<String> setsFromNext;

            if(cache.containsKey(i)) {
                setsFromNext = cache.get(i);
            } else {
                setsFromNext = getSubsets(original, cache, i);
            }

            for(String setFromNext : setsFromNext) {
                setsStartingHere.add(here + " " + setFromNext);
            }
        }

        cache.put(current, setsStartingHere);

        return setsStartingHere;
    }

    public static int findMagicIndex(int[] input) {
        return findMagicIndex(0, input.length, input);
    }

    private static int findMagicIndex(int start, int end, int[] input) {
        int pivotIndex = (start + end) / 2;
        int pivot = input[pivotIndex];
        int pivotDiff = pivotIndex - pivot;

        if(start == end && pivotDiff != 0) return -1;

        if(pivotDiff > 0) return findMagicIndex(pivotIndex + 1, end, input);

        if(pivotDiff < 0) return findMagicIndex(start, pivotIndex - 1, input);

        if(pivotDiff == 0) return pivotIndex;

        return -1;
    }

    public static int recursiveMultiply(int a, int b) {
        int small = Math.min(a, b);
        int big = Math.max(a, b);
        int ans = 0;

        if (small > 0)  ans += big + recursiveMultiply(small - 1, big);

        return ans;
    }

    public static boolean canPurchase(int[] coins, int target) {
        List<Integer> combinations = new ArrayList<>();
        boolean canPurchase = canPurchase(coins, target, 0, combinations);
        return canPurchase;
    }

    private static boolean canPurchase(int[] coins, int target, int currentIndex, List<Integer> combinationsSoFar) {
        boolean foundCombination = false;
        int current = coins[currentIndex];

        if(current == target) return true;

        if(currentIndex == coins.length - 1) {
            combinationsSoFar.add(current);
        }
        else {
            foundCombination = canPurchase(coins, target, currentIndex + 1, combinationsSoFar);

            if(!foundCombination) {
                List<Integer> othersPlusCurrent = new ArrayList<>();
                othersPlusCurrent.add(current);

                for (int i = 0; i < combinationsSoFar.size(); i++) {
                    int plusCurrent = combinationsSoFar.get(i) + current;
                    othersPlusCurrent.add(plusCurrent);

                    if(plusCurrent == target) {
                        foundCombination = true;
                        break;
                    }
                }

                combinationsSoFar.addAll(othersPlusCurrent);
            }
        }

        return foundCombination;
    }

    static class MaxHeight {
        public static int globalMaxHeight = 0;
    }

    public class Box {
        int width;
        int height;
        int depth;

        public Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int getDepth() {
            return depth;
        }
    }

    public static int getMaxHeight(Box[] boxes) {
        Map<Integer, Integer> maxes = new HashMap<>();

        for(int i = 0; i < boxes.length; i++) {
            getMaxHeight(boxes, i, maxes);
        }

        return MaxHeight.globalMaxHeight;
    }

    private static boolean canStack(Box top, Box bottom) {
        if(top.getDepth() >= bottom.getDepth()) return false;
        if(top.getWidth() >= bottom.getWidth()) return false;
        if(top.getHeight() >= bottom.getHeight()) return false;

        return true;
    }

    private static int getMaxHeight(Box[] boxes, int current, Map<Integer, Integer> maxes) {
        int currentHeight = boxes[current].getHeight();
        int maxHere = currentHeight;

        if(maxes.containsKey(current)) return maxes.get(current);

        for(int i = 0; i < boxes.length; i++) {
            if(i != current && canStack(boxes[current], boxes[i])) {
                int nextMaxHeight;

                if(maxes.containsKey(i)) {
                    nextMaxHeight = maxes.get(i);
                } else {
                    nextMaxHeight = getMaxHeight(boxes, i, maxes);
                }

                int plusMore = currentHeight + nextMaxHeight;

                if(plusMore > maxHere) maxHere = plusMore;
            }
        }

        if(maxHere > MaxHeight.globalMaxHeight) MaxHeight.globalMaxHeight = maxHere;

        maxes.put(current, maxHere);

        return maxHere;
    }

    public static List<String> permutationsOfUniqueString(String input) {
        return permutationsOfUniqueString(input, 0);
    }

    private static List<String> permutationsOfUniqueString(String input, int current) {
        List<String> permutationsHere = new ArrayList<>();

        String here = String.valueOf(input.charAt(current));

        if(current == input.length() - 1) {
            permutationsHere.add(here);
            return permutationsHere;
        }

        List<String> permutationsNext = permutationsOfUniqueString(input, current + 1);

        for(int i = 0; i < permutationsNext.size(); i++) {
            String next = permutationsNext.get(i);
            for(int j = 0; j < next.length() + 1; j++) {
                String plusHere = next.substring(0, j) + here + next.substring(j, next.length());
                permutationsHere.add(plusHere);
            }
        }

        return permutationsHere;
    }

    public static Set<String> permutationsOfStringWithDupes(String input) {
        return permutationsOfStringWithDupes(input, 0);
    }

    private static Set<String> permutationsOfStringWithDupes(String input, int current) {
        Set<String> permutationsHere = new HashSet<>();

        String here = String.valueOf(input.charAt(current));

        if(current == input.length() - 1) {
            permutationsHere.add(here);
            return permutationsHere;
        }

        Set<String> permutationsNext = permutationsOfStringWithDupes(input, current + 1);

        for(String permutationNext : permutationsNext) {
            for(int j = 0; j < permutationNext.length() + 1; j++) {
                String plusHere = permutationNext.substring(0, j) + here + permutationNext.substring(j, permutationNext.length());
                permutationsHere.add(plusHere);
            }
        }

        return permutationsHere;
    }


}
