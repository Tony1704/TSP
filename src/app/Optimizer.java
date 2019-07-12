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

    // Insert Nodes in order of them appearing in the nodes Array
    // Method used: merge into path
    private static Graph insertFirst(Node[] nodes, DistanceMatrix distances) {
        Node[] path = new Node[nodes.length];
        path[0] = nodes[0];
        path[1] = nodes[1];
        // Loop at all Nodes, except first two
        for (int i = 2; i < nodes.length; i++) {

            // Find best place to merge current Node into
            // Again skip first one since this one is fixed as the origin
            int shortestIndex = -1;
            double shortestDistance = -1;

            for (int j = 1; j < path.length - 1; j++) {
                double currentDistance = ((path[j] != null) ? distances.getDistanceById(path[j], nodes[i]) : 0)
                        + (path[j + 1] != null ? distances.getDistanceById(path[j + 1], nodes[i]) : 0);
                if (shortestIndex == -1 || currentDistance < shortestDistance) {
                    shortestIndex = j;
                    shortestDistance = currentDistance;
                }
            }

            // Merge into best spot in the sequence
            path = mergeNodeIntoGraph(path, nodes[i], shortestIndex);
        }

        Graph returnGraph = new Graph(nodes);
        return returnGraph;
    }

    // Append Node closest to the last inserted to the path
    // Method used: append to path
    private static Graph insertClosest(Node[] nodes, DistanceMatrix distances) {
        Node[] path = new Node[nodes.length];
        path[0] = nodes[0];

        // Loop at path to to find the closest Node to append behind the
        for (int i = 1; i < path.length; i++) {
            int shortestIndex = -1;
            double shortestDistance = -1;

            // Find closest Node to current Path Node
            // skip the first one since it already is a part of the graph
            for (int j = 1; j < nodes.length; j++) {
                double currentDistance = distances.getDistanceById(path[i - 1], nodes[j]);
                if (!pathContainsNode(path, nodes[j]) && (shortestIndex == -1 || shortestDistance > currentDistance)) {
                    shortestIndex = j;
                    shortestDistance = currentDistance;
                }
            }
            path = mergeNodeIntoGraph(path, nodes[shortestIndex], i);
        }

        Graph returnGraph = new Graph(path);
        return returnGraph;
    }

    // Merge Node furthest from the last inserted into path
    // Method used: merge into path
    private static Graph insertFurthest(Node[] nodes, DistanceMatrix distances) {
        Node[] path = new Node[nodes.length];
        path[0] = nodes[0];

        // Loop at Path to fill in all Nodes
        for (int i = 1; i < path.length; i++) {
            int furthestIndex = -1;
            double furthestDistance = -1;

            // Find Node Furthest Away from path[i - 1]
            for (int j = 0; j < nodes.length; j++) {
                double currentDistance = distances.getDistanceById(nodes[j], path[i - 1]);
                if (!pathContainsNode(path, nodes[j]) && (furthestIndex == -1 || furthestDistance < currentDistance)) {
                    furthestDistance = currentDistance;
                    furthestIndex = j;
                }
            }

            // Find best place to merge node into
            int shortestIndex = -1;
            double shortestDistance = -1;

            for (int j = 1; j < path.length; j++) {

                double currentDistance = ((path[j - 1] != null)
                        ? distances.getDistanceById(path[j - 1], nodes[furthestIndex])
                        : 0) + ((path[j] != null) ? distances.getDistanceById(path[j], nodes[furthestIndex]) : 0);

                if (shortestIndex == -1 || shortestDistance > currentDistance) {
                    shortestDistance = currentDistance;
                    shortestIndex = j;
                }
            }
            path = mergeNodeIntoGraph(path, nodes[i], shortestIndex);
        }

        return null;
    }

    // Detects and removes Crossover in a given Graph
    private static Graph removeCrossover(Node[] nodes, DistanceMatrix distances) {

        return null;
    }

    // Check if for any given Node a shorter total Distance can be achieved by
    // merging it into another path on the Graph
    private static Graph afterControl(Node[] nodes, DistanceMatrix distances) {
        return null;
    }

    private static Node[] mergeNodeIntoGraph(Node[] path, Node node, int index) {
        for (int i = path.length - 2; i >= index; i--) {
            // Node temp = path[i];
            path[i + 1] = path[i];
        }
        path[index] = node;

        return path;
    }

    private static boolean pathContainsNode(Node[] path, Node node) {
        for (Node n : path) {
            if (node.getID() == (n != null ? n.getID() : -1)) {
                return true;
            }

            if (n != null) {
                if (n.getID() == node.getID()) {
                    return true;
                }
            }
        }
        return false;
    }

}