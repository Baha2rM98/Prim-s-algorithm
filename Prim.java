import java.util.Arrays;

//Created by Baha2r

public class Prim {

    public static void main(String[] args) {
        //Default graph
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        prim(graph);
    }

    private static void prim(int graph[][]) {
        final int INF = Integer.MAX_VALUE;
        int n = graph.length, MinNode, MinWeight, CurrentNode, weight = 0;
        int[] Parent = new int[n];
        boolean[] CheckNodes = new boolean[n];
        int[] Key = new int[n];
        Arrays.fill(CheckNodes, false);
        Arrays.fill(Key, INF);
        Arrays.fill(Parent , -1);
        Key[0] = 0;
        CurrentNode = 0;
        CheckNodes[CurrentNode] = true;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (!CheckNodes[i] && graph[CurrentNode][i] != 0 && graph[CurrentNode][i] < Key[i]) {
                    Key[i] = graph[CurrentNode][i];
                    Parent[i] = CurrentNode;
                }
            }
            MinNode = -1;
            MinWeight = INF;
            for (int i = 0; i < n; i++) {
                if (!CheckNodes[i] && Key[i] < MinWeight) {
                    MinNode = i;
                    MinWeight = Key[i];
                }
            }
            if (MinNode == -1)
                break;
            CurrentNode = MinNode;
            CheckNodes[CurrentNode] = true;
        }
        for (int i = 1; i < n; i++) {
            weight += graph[i][Parent[i]];
        }
        for (int i = 1; i < n; i++) {
            System.out.println(Parent[i] + " - " + i + " : " + graph[i][Parent[i]]);
        }
        System.out.println("Weight Of Tree Is : " + weight);
    }
}
