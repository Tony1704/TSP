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


}