import javafx.scene.control.TextFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args){
        Map<String,Object> map = new HashMap<>();
        Scanner input =new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++){
            String operation = input.next();
            String name = input.next();
            if(operation.equals("Add")){
                int[] location = new int[2];
                location[0] = input.nextInt();
                location[1] = input.nextInt();
                Add(map,name,location);
            }
            else if(operation.equals("Query")){
                Query(map,name);
            }
            else if(operation.equals("Change")){
                int[] location = new int[2];
                location[0] = input.nextInt();
                location[1] = input.nextInt();
                Change(map,name,location);
            }
            else if(operation.equals("Delete")){
                Delete(map,name);
            }
        }
    }

    /**
     * 建筑物位置修改到x，y
     * @param map
     * @param name
     * @param location
     */
    public static void Change(Map map,String name,int[] location){
        if(map.containsKey(name)){
            map.put(name,location);
        }
        else{
            return;
        }
    }

    /**
     * 拆除建筑
     * @param map
     * @param name
     */
    public static void Delete(Map map,String name){
        if(map.containsKey(name)){
            map.remove(name);
        }
        else{
            return;
        }
    }

    /**
     * 修建建筑
     * @param map
     * @param name
     * @param location
     */
    public static void Add(Map map,String name,int[] location){
        map.put(name,location);
    }

    public static void Query(Map map,String name){
        if(map.containsKey(name)){
            int[] location = (int[]) map.get(name);
            System.out.println("yes");
            System.out.println(location[0]+" "+location[1]);
        }
        else{
            System.out.println("no");
        }
    }
}
