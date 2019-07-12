package app;

/**
 * Optimizer
 */
public class Optimizer {

    // Optimize with Strategy
    public static Graph optimize(Node[] nodes, DistanceMatrix distances, int strategy, boolean removeCrossover,
            boolean afterControl) {
        Graph returnGraph = null;
        switch (strategy) {
        case 0:
            returnGraph = insertFirst(nodes, distances);
            break;
        case 1:
            returnGraph = insertClosest(nodes, distances);
            break;
        case 2:
            returnGraph = insertFurthest(nodes, distances);
            break;
        default:
            break;
        }

        if (removeCrossover) {
            returnGraph = removeCrossover(nodes, distances);
        }
        if (afterControl) {
            returnGraph = afterControl(nodes, distances);
        }

        return returnGraph;
    }

    private static Graph insertFirst(Node[] nodes, DistanceMatrix distances) {
        Node[] path = new Node[nodes.length];
        path[0] = nodes[0];
        path[1] = nodes[1];
        // Loop at all Nodes, except first ones
        for (int i = 2; i < nodes.length; i++) {
            // Find best place to merge current Node into
            // Again skip first one since this one is fixed as the origin
            int shortestIndex = -1;
            double shortestDistance = -1;
            for (int j = 1; j < path.length; j++) {
                if (path[j] != null) {

                    double currentDistance = distances.getDistanceById(path[j - 1], nodes[i])
                            + distances.getDistanceById(path[j], nodes[i]);
                    if (shortestIndex == -1 || currentDistance < shortestDistance) {
                        shortestDistance = currentDistance;
                        shortestIndex = j;
                    }
                }
            }
            // Merge into best spot in the sequence
            path = mergeNodeIntoGraph(path, nodes[i], shortestIndex);
        }
        Graph returnGraph = new Graph(nodes);
        return returnGraph;
    }

    private static Graph insertClosest(Node[] nodes, DistanceMatrix distances) {
        return null;
    }

    private static Graph insertFurthest(Node[] nodes, DistanceMatrix distances) {
        return null;
    }

    private static Graph removeCrossover(Node[] nodes, DistanceMatrix distances) {
        return null;
    }

    private static Graph afterControl(Node[] nodes, DistanceMatrix distances) {
        return null;
    }

    private static Node[] mergeNodeIntoGraph(Node[] path, Node node, int index) {
        for(int i = path.length - 2; i >= index; i--) {
            // Node temp = path[i];
            path[i + 1] = path[i]; 
        }
        path[index] = node;

        return path;
    }

}