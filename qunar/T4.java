import java.util.Scanner;

public class T4 {
    private static int length;
    private static int value;
    //方向
    public enum Direction{
        Left,Right,Up,Down;
    }
    private Direction lastDirection = Direction.Down;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int x=input.nextInt();
        int y=input.nextInt();
        x--;
        y--;
        int m=input.nextInt();
        length=n;
        value=1;
        new T4().initMatrix(x,y,m);
    }
    public void initMatrix(int x,int y,int m){
        int row = 0;
        int col = 0;
        //初始化
        int[][] matrix = new int[length][length];
        for(int i=0;i<length*length;i++){
            //赋值
            matrix[row][col] = value;
            //根据所在的行列,判断下一步的走向
            Direction nowDirection = getDirection(row,col);
            switch(nowDirection){
                case Left:
                    col--;
                    break;
                case Right:
                    col++;
                    break;
                case Up:
                    row--;
                    break;
                case Down:
                    row++;
                    break;
            }
            value++;
        }
        for(int i=x;i<x+m;i++){
            for(int j=y;j<y+m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    //这里最为重要
    //向左走时,是在回型的最下面,根据所在行号判断到哪列就转向上.比如row=6,那么col=1时就可以转向了.
    //向右走时,是在回型的最上面,根据所在行号判断到哪列就转向下.比如row=0,那么col=7时就可以转向了.
    //向下走时,是在回型的最右面,根据所在列号判断到哪行就转向左.比如col=6,那么row=6时就可以转向了.
    //向上走时,是在回型的最左面,根据所在列号判断到哪行就转向右.比如col=0,那么row=1时就可以转向了.
    public Direction getDirection(int row,int col){
        switch(lastDirection){
            case Down:
                if(col==(length-1-row)) {
                    lastDirection = Direction.Right;
                }
                break;
            case Right:
                if(row==col) {
                    lastDirection = Direction.Up;
                }
                break;
            case Up:
                if(col==(length-1-row)){
                    lastDirection = Direction.Left;
                }
                break;
            case Left:
                if(row+1==col) {
                    lastDirection = Direction.Down;
                }
                break;
        }
        return lastDirection;
    }
}
