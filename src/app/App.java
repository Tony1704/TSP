package app;

import java.io.FileWriter;

public class App {
    public static int range = 10;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        Node[] nodes = new Node[10];
        Graph graph = new Graph(nodes);
        Graph[] solutions = new Graph[12];
        FileWriter writer = new FileWriter("../data.txt");

        nodes[0] = new Node((Math.random() * range), (Math.random() * range), null);

        for(int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node((Math.random() * range), Math.random() * range, nodes[0]);
        }

        DistanceMatrix distances = new DistanceMatrix(graph);

        // Get all different solutions in one array of Graphs

        solutions[0] = Optimizer.optimize(nodes, distances, 0, false, false);
        solutions[1] = Optimizer.optimize(nodes, distances, 0, false, true);
        solutions[2] = Optimizer.optimize(nodes, distances, 0, true, false);
        solutions[3] = Optimizer.optimize(nodes, distances, 0, true, true);

        solutions[4] = Optimizer.optimize(nodes, distances, 1, false, false);
        solutions[5] = Optimizer.optimize(nodes, distances, 1, false, true);
        solutions[6] = Optimizer.optimize(nodes, distances, 1, true, false);
        solutions[7] = Optimizer.optimize(nodes, distances, 1, true, true);

        solutions[8] = Optimizer.optimize(nodes, distances, 2, false, false);
        solutions[9] = Optimizer.optimize(nodes, distances, 2, false, true);
        solutions[10] = Optimizer.optimize(nodes, distances, 2, true, false);
        solutions[11] = Optimizer.optimize(nodes, distances, 2, true, true);

        String dataOutput = "";
        for(Graph g : solutions) {
            dataOutput += g.getTotalDistance(distances);
        }
        try {
            writer.write(dataOutput + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.close();
        UI.runUI(nodes, graph.getTotalDistance(distances));
    }
}