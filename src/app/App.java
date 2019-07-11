package app;

public class App {
    public static int range = 10;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        Node[] nodes = new Node[10];
        Graph graph = new Graph(nodes);
        nodes[0] = new Node((Math.random() * range), (Math.random() * range), null);

        for(int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node((Math.random() * range), Math.random() * range, nodes[0]);
        }

        DistanceMatrix distances = new DistanceMatrix(graph);

        
        
        UI.runUI(nodes, graph.getTotalDistance(distances));
    }
}