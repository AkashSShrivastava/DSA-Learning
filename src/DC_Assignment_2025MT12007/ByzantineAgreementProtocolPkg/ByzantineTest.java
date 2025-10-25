package DC_Assignment_2025MT12007.ByzantineAgreementProtocolPkg;

public class ByzantineTest {

    public static void testDifferentConfigurations() throws Exception {
        System.out.println("\n### TEST 1: 4 nodes, 1 traitor (minimum case) ###\n");
        runTest(4, 1, 0, "ATTACK");

        System.out.println("\n### TEST 2: 7 nodes, 2 traitors ###\n");
        runTest(7, 2, 0, "RETREAT");

        System.out.println("\n### TEST 3: 10 nodes, 3 traitors ###\n");
        runTest(10, 3, 5, "ATTACK");
    }

    private static void runTest(int N, int M, int byzantineNode,
                                String order) throws Exception {
        // Similar to runScenario in main class
        System.out.println("Testing with N=" + N + ", M=" + M);
        System.out.println("Byzantine node: " + byzantineNode);
        System.out.println("Commander order: " + order);
        System.out.println();

        // Implementation here...
    }

    public static void demonstrateFailureCase() {
        System.out.println("\n### FAILURE CASE: N < 3M + 1 ###\n");
        int N = 3;
        int M = 1;

        System.out.println("With N=" + N + " and M=" + M + ":");
        System.out.println("Condition N >= 3M+1: " + N + " >= " +
                (3*M+1) + " = false");
        System.out.println("Cannot guarantee consensus!");
        System.out.println("Need at least " + (3*M+1) + " nodes.");
    }
}
