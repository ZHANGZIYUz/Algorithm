import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    int[] X = {0, 1, 0, -1};//bfs时的邻接节点的横坐标，顺序为右，下，左，上
    int[] Y = {1, 0, -1, 0};//bfs时的邻接节点的纵坐标，顺序为右，下，左，上
    static int[][] array = new int[5][5];
    static int[][] isVisited = new int[5][5];
    static Path[][] path = new Path[5][5];
    static int Step;
    static Path[] paths;

    public static void main(String[] args) {
        int X = 4, Y = 4;
        int tempx, tempy;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = input.nextInt();
                isVisited[i][j] = array[i][j];
                path[i][j] = new Path(0, 0);
            }
        }
        Main m = new Main();
        m.bfs(4, 4);
        paths = new Path[Step + 1];
        for (int i = Step - 1; i >= 0; i--) {
            tempx = path[X][Y].x;
            tempy = path[X][Y].y;
            X = tempx;
            Y = tempy;
            paths[i] = new Path(X, Y);
        }
        paths[Step] = new Path(4, 4);
        for (int i = 0; i <= Step; i++) {
            System.out.println(paths[i].x+","+paths[i].y);
        }
    }

    public void bfs(int Endx, int Endy) {
        LinkedList<Pointer> p = new LinkedList<>();
        Pointer pointer = new Pointer(0, 0, 0);
        p.add(pointer);
        while (!p.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int x = p.peek().x;
                int y = p.peek().y;
                int step = p.peek().step + 1;
                if ((x + X[i]) >= 0 && (x + X[i]) < 5) {
                    x = x + X[i];
                } else {
                    continue;
                }
                if ((y + Y[i]) >= 0 && (y + Y[i]) < 5) {
                    y = y + Y[i];
                } else {
                    continue;
                }
                if (x == Endx && y == Endy) {
                    Step = step;
                    Pointer po = new Pointer(x, y, step);
                    p.add(po);
                    isVisited[x][y] = 2;
                    path[x][y].x = p.peek().x;
                    path[x][y].y = p.peek().y;
                    break;
                }
                if (isVisited[x][y] == 0) {
                    Pointer po = new Pointer(x, y, step);
                    p.add(po);
                    isVisited[x][y] = 2;
                    path[x][y].x = p.peek().x;
                    path[x][y].y = p.peek().y;
                }
            }
            p.remove();
        }
    }
}

class Pointer {
    int x;
    int y;
    int step;

    public Pointer(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

class Path {
    int x;
    int y;

    public Path(int x, int y) {
        this.x = x;
        this.y = y;
    }
}