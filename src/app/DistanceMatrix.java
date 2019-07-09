package app;

/**
 * DistanceMatrix
 */
public class DistanceMatrix {

    private static int[] rowHeader;
    private static int[] columnHeader;

    private static double[][] distances;

    public DistanceMatrix(Graph graph) {
        Node[] nodes = graph.getNodes();
        rowHeader = new int[nodes.length];
        columnHeader = new int[nodes.length];
        distances = new double[nodes.length][nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                double distance = Math.sqrt(Math.pow(Math.abs((nodes[i].getX() - nodes[j].getX())), 2)
                                          + Math.pow(Math.abs((nodes[i].getY() - nodes[j].getY())), 2));
                distances[i][j] = distance;
                if (i == 0) {
                    columnHeader[j] = nodes[j].getID();
                }
            }
            rowHeader[i] = nodes[i].getID();
        }
    }

    public double getDistanceById(Node a, Node b) {
        return distances[a.getID()][b.getID()];
    }

}