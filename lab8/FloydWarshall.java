

public class FloydWarshall{

    private int edgesNum;
    private char[] mVertex;
    private int[][] mMatrix;
    private static final int INF = Integer.MAX_VALUE;

    public FloydWarshall(char[] vertex, int[][] matrix) {

        int vertexLenght = vertex.length;

        mVertex = new char[vertexLenght];
        for (int i = 0; i < mVertex.length; i++)
            mVertex[i] = vertex[i];

        mMatrix = new int[vertexLenght][vertexLenght];
        for (int i = 0; i < vertexLenght; i++)
            for (int j = 0; j < vertexLenght; j++)
                mMatrix[i][j] = matrix[i][j];

        edgesNum = 0;
        for (int i = 0; i < vertexLenght; i++)
            for (int j = i+1; j < vertexLenght; j++)
                if (mMatrix[i][j]!=INF)
                    edgesNum++;
    }


    public void floyd(int[][] path, int[][] dist) {

        for (int i = 0; i < mVertex.length; i++) {
            for (int j = 0; j < mVertex.length; j++) {
                dist[i][j] = mMatrix[i][j];
                path[i][j] = j;
            }
        }

        for (int k = 0; k < mVertex.length; k++) {
            for (int i = 0; i < mVertex.length; i++) {
                for (int j = 0; j < mVertex.length; j++) {
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        dist[i][j] = tmp;
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        System.out.printf("floyd: \n");
        for (int i = 0; i < mVertex.length; i++) {
            for (int j = 0; j < mVertex.length; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'1','2','3','4','5','6','7','8','9','A','B','C','D','E',
                'F','G','H','I','J','K','L','M','N','O','P','Q','R'};
        int matrix[][] = {

                /*1*/ {INF, 3,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF, 1,   INF, INF, INF, INF},
                /*2*/ {3,   INF, 11,  INF, INF, INF, INF, INF, INF, INF, INF, INF, 2,   INF, INF, INF, 3,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*3*/ {INF, 11,  INF, 3,   2,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*4*/ {INF, INF, 3,   INF, INF, INF, 4,   INF, INF, 3,   2,   INF, INF, INF, INF, 4,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*5*/ {INF, INF, 2,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*6*/ {INF, INF, INF, INF, INF, INF, 4,   1,   5,   INF, INF, INF, INF, INF, INF, INF, INF, 2,   INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*7*/ {INF, INF, INF, 4,   INF, 4,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 6,   INF, INF},
                /*8*/ {INF, INF, INF, INF, INF, 1,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*9*/ {INF, INF, INF, INF, INF, 5,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*A*/ {INF, INF, INF, 3,   INF, INF, INF, INF, INF, INF, INF, 6,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*B*/ {INF, INF, INF, 2,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*C*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, 6,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4  },
                /*D*/ {INF, 2,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*E*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4,   INF, 3,   5,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*F*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF, INF, INF, INF},
                /*G*/ {INF, INF, INF, 4,   INF, INF, INF, INF, INF, INF, INF, INF, INF, 5,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*H*/ {INF, 3,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 2,   INF, INF, INF, INF},
                /*I*/ {INF, INF, 3,   INF, INF, 2,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5,   INF, INF, INF, INF, INF, INF, INF, INF},
                /*J*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5,   INF, INF, INF, INF, INF, INF, INF, INF, INF},
                /*K*/ {3,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7,   INF, INF, INF, INF, INF, INF},
                /*L*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7,   INF, 5,   INF, INF, INF, INF, INF},
                /*M*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF, INF, INF, INF, 5,   INF, INF, INF, INF, INF, INF},
                /*N*/ {1,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 2,   INF, INF, INF, INF, INF, INF, 3,   INF, INF, INF},
                /*O*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF, INF, INF},
                /*P*/ {INF, INF, INF, INF, INF, INF, 6,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF},
                /*Q*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3,   INF, INF},
                /*R*/ {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4,   INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}};
        FloydWarshall algo = new FloydWarshall(vexs, matrix);

        int[][] path = new int[algo.mVertex.length][algo.mVertex.length];
        int[][] floy = new int[algo.mVertex.length][algo.mVertex.length];

        algo.floyd(path, floy);
    }
}
