/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/15 19:27
 */
public class T3 {
    public static void main(String[] args){

    }

    public static boolean find (int[][] arr, int target) {
        // write code here
        int rows = arr.length;
        int columns = arr[0].length;
        int row = 0;
        int column = columns-1;
        while(row<rows && column>=0){
            if(target>arr[row][column]){
                row++;
            }
            else if(target<arr[row][column]){
                column--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
