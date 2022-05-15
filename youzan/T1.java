import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/16 15:08
 */

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class T1 {
    public static void main(String[] args){
        Point[] points1 = new Point[3];
        points1[0] = new Point(0,0);
        points1[1] = new Point(1,1);
        points1[2] = new Point(2,2);

        Point[] points2 = new Point[2];
        points2[0] = new Point(0,0);
        points2[1] = new Point(0,1);
        int res = maxPoints(points2);
        System.out.println(res);
    }

    public static int maxPoints (Point[] points) {
        // write code here
        int length=points.length;
        int res = 0;
        if(length<2){
            return res;
        }
        else if(length==2){
            return 2;
        }
        for(int i=0;i<length;i++){
            Map<Double,Integer> map = new HashMap<>();
            for(int j=0;j<length;j++){
                if(j!=i){
                    double k;
                    if(points[j].x-points[i].x==0){
                        k=Double.MAX_VALUE;
                    }
                    else{
                        k =((points[j].y-points[i].y)/(points[j].x-points[i].x));
                    }
                    if(map.containsKey(k)){
                        map.put(k,map.get(k)+1);
                    }
                    else{
                        map.put(k,2);
                    }
                }
            }
            for(Map.Entry<Double,Integer> entry : map.entrySet()){
                if(entry.getValue()>res){
                    res=entry.getValue();
                }
            }
        }
        return res;
    }
}
