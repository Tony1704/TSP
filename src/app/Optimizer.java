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
        return null;
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

    // private static DistanceMatrix distances;

    // public static Graph mindDist(Node[] nodes, DistanceMatrix _distances, int
    // strategy) {
    // distances = _distances;
    // Graph returnGraph = null;
    // switch (strategy) {
    // case Strategy.FIRST:
    // returnGraph = new Graph(nodes.length);
    // break;

    // default:
    // break;
    // }
    // return returnGraph;
    // }

    // private Graph removeCrossover(Node[] nodes, DistanceMatrix distances) {
    // return null;
    // }

    // private Graph postOptimization(Node[] nodes, DistanceMatrix distances) {
    // return null;
    // }

    // private Graph insertFirstMinDist(Node[] nodes) {
    // Graph returnGraph = new Graph(nodes.length);

    // for()
    // }

}