import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DynamicProgrammingTest {

    DynamicProgramming obj;

    @Test
    public void isSubSequenceTest() {
        assertTrue(obj.isSequence("abc", "ajhlvbnmcd"));
        assertFalse(obj.isSequence("abc", "cfgaklbif"));
    }

    @Test
    public void getSubsetsTest() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        Map<Integer, List<String>> actual = DynamicProgramming.getSubsets(input);

        assertEquals(4, actual.size());
    }

    @Test
    public void findMagicIndexTest() {
        int[] input = new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        assertEquals(7, DynamicProgramming.findMagicIndex(input));
    }

    @Test
    public void recursiveMultiplyTest() {
        assertEquals(14, DynamicProgramming.recursiveMultiply(7, 2));
        assertEquals(7, DynamicProgramming.recursiveMultiply(7, 1));
        assertEquals(100, DynamicProgramming.recursiveMultiply(10, 10));
    }

    @Test
    public void canPurchaseTest() {
        int[] coins = new int[] {5,2,4,3,1,20};

        assertTrue(DynamicProgramming.canPurchase(coins, 6));
        assertTrue(DynamicProgramming.canPurchase(coins, 1));
        assertTrue(DynamicProgramming.canPurchase(coins, 12));
        assertTrue(DynamicProgramming.canPurchase(coins, 26));
        assertFalse(DynamicProgramming.canPurchase(coins, 18));
    }

    @Test
    public void getMaxHeightTest() {
        DynamicProgramming.Box[] boxes1 = new DynamicProgramming.Box[] {
                new DynamicProgramming().new Box(1,1,1),
                new DynamicProgramming().new Box(4,5,2),
                new DynamicProgramming().new Box(3,3,4),
                new DynamicProgramming().new Box(2,2,3),
                new DynamicProgramming().new Box(1,2,1)
        };

        assertEquals(7, DynamicProgramming.getMaxHeight(boxes1));
    }

    @Test
    public void permutationsOfUniqueStringTest() {
        String input1 = "abc";
        List<String> actual = DynamicProgramming.permutationsOfUniqueString(input1);

        assertEquals(6, actual.size());
        assertTrue(actual.contains("abc"));
        assertTrue(actual.contains("acb"));
        assertTrue(actual.contains("bac"));
        assertTrue(actual.contains("bca"));
        assertTrue(actual.contains("cab"));
        assertTrue(actual.contains("cba"));
    }

    @Test
    public void permutationsOfStringWithDupesTest() {
        String input1 = "aba";
        Set<String> actual = DynamicProgramming.permutationsOfStringWithDupes(input1);

        assertEquals(3, actual.size());
        assertTrue(actual.contains("aba"));
        assertTrue(actual.contains("baa"));
        assertTrue(actual.contains("aab"));
    }



}
