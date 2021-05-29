package com.company;

public class AdjMatrix {
    private int numOfNodes;
    private boolean directed;
    private boolean weighted;
    private float[][] matrix;

    private boolean[][] isSetMatrix;
    private int[][] isSetMatrixInt;
    private static final int INF = 1000 * 1000 * 1000;

    public AdjMatrix(int numOfNodes, boolean directed, boolean weighted) {

        this.directed = directed;
        this.weighted = weighted;
        this.numOfNodes = numOfNodes;

        matrix = new float[numOfNodes][numOfNodes];
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
        isSetMatrixInt = new int[numOfNodes][numOfNodes];
    }

    public AdjMatrix addVertex(AdjMatrix graphing) {
        numOfNodes++;
        graphing = new AdjMatrix(numOfNodes++, directed, weighted);
        return graphing;
    }
    public AdjMatrix removeVertex(AdjMatrix graphing) {
        numOfNodes--;
        AdjMatrix graph = new AdjMatrix(numOfNodes++, directed, weighted);
        return graph;
    }

    public void addEdge(int source, int destination) {
        int valueToAdd = 1;

        if (weighted) {
            valueToAdd = 0;
        }
        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void addEdge(int source, int destination, float weight) {

        float valueToAdd = weight;

        if (!weighted) {
            valueToAdd = 1;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void removeEdge(int source, int destination) {
        isSetMatrix[source][destination] = false;
    }
    public void removeEdge(int source, int destination, int weight) {
        isSetMatrix[source][destination] = false;
    }

    public void printMatrix() {
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                if (isSetMatrix[i][j])
                    System.out.format(" 1 ");
                else System.out.format(" 0 ");
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < numOfNodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < numOfNodes; j++) {
                if (isSetMatrix[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int source, int destination)  {
        return isSetMatrix[source][destination];
    }
    public boolean hasVertex(int destination) {
        for (int i = 0; i <= numOfNodes; i++) {
            if(isSetMatrix[i][destination]) return true;
        }
        return false;
    }

    public Float getEdgeValue(int source, int destination) {
        if (!weighted || !isSetMatrix[source][destination])
            return null;
        return matrix[source][destination];
    }


    public static void main(String[] args) {
        AdjMatrix graph = new AdjMatrix(27, false, true);
        //graph.addVertex(graph);
        //long start = System.nanoTime();
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 22, 1);
        graph.addEdge(0, 19, 3);
        graph.addEdge(1, 16, 3);
        graph.addEdge(1, 2, 11);
        graph.addEdge(1, 12, 2);
        graph.addEdge(2, 4, 2);
        graph.addEdge(2, 17, 3);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 15, 4);

        graph.addEdge(3, 9, 3);
        graph.addEdge(3, 10, 2);
        graph.addEdge(3, 6, 4);
        graph.addEdge(5, 17, 2);
        graph.addEdge(5, 7, 1);
        graph.addEdge(5, 8, 5);
        graph.addEdge(5, 6, 4);
        graph.addEdge(6, 24, 6);
        graph.addEdge(9, 11, 6);
        graph.addEdge(11, 26, 4);

        graph.addEdge(12, 13, 4);
        graph.addEdge(13, 14, 3);
        graph.addEdge(13, 15, 5);
        graph.addEdge(14, 21, 3);
        graph.addEdge(16, 2, 2);
        graph.addEdge(17, 18, 5);
        graph.addEdge(19, 20, 7);
        graph.addEdge(20, 21, 5);
        graph.addEdge(22, 23, 3);
        graph.addEdge(24, 25, 3);
        //long end = System.nanoTime();
        //long result = end - start;
        //System.out.println("Час виконання додавання:" + result);

        /*long start = System.nanoTime();
        graph.removeEdge(0, 1, 3);
        graph.removeEdge(0, 22, 1);
        graph.removeEdge(0, 19, 3);
        graph.removeEdge(1, 16, 3);
        graph.removeEdge(1, 2, 11);
        graph.removeEdge(1, 12, 2);
        graph.removeEdge(2, 4, 2);
        graph.removeEdge(2, 17, 3);
        graph.removeEdge(2, 3, 3);
        graph.removeEdge(3, 15, 4);

        graph.removeEdge(3, 9, 3);
        graph.removeEdge(3, 10, 2);
        graph.removeEdge(3, 6, 4);
        graph.removeEdge(5, 17, 2);
        graph.removeEdge(5, 7, 1);
        graph.removeEdge(5, 8, 5);
        graph.removeEdge(5, 6, 4);
        graph.removeEdge(6, 24, 6);
        graph.removeEdge(9, 11, 6);
        graph.removeEdge(11, 26, 4);

        graph.removeEdge(12, 13, 4);
        graph.removeEdge(13, 14, 3);
        graph.removeEdge(13, 15, 5);
        graph.removeEdge(14, 21, 3);
        graph.removeEdge(16, 2, 2);
        graph.removeEdge(17, 18, 5);
        graph.removeEdge(19, 20, 7);
        graph.removeEdge(20, 21, 5);
        graph.removeEdge(22, 23, 3);
        graph.removeEdge(24, 25, 3);
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Час виконання видалення:" + result);*/

        graph.printMatrix();

        System.out.println();
        System.out.println();

        graph.printEdges();

        System.out.println();
        System.out.println("Does an edge from 1 to 0 exist?");
        if (graph.hasEdge(0,19)) {
            System.out.println("Yes");
        }
        else System.out.println("No");

        System.out.println("Does matrix have 24 vertex?");
        if (graph.hasVertex(24)) {
            System.out.println("Yes");
        }
        else System.out.println("No");

        //graph.getEdgeValue(1, 2);

    }

}

