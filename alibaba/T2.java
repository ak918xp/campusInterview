import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/26 15:52
 */
public class T2 {

}

class userInfo{
    public int id;
    public int time;
}

class UserCache{
    private int capacity;
    private HashMap<Integer,userInfo> map;
    private LinkedList<Integer> list;
    public UserCache(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
        list=new LinkedList<>();
    }

    public userInfo get(int key){
        if(map.containsKey(key) && currentTime-map.get(key).time>30){
            list.remove((Integer) key);
            list.addLast(key);
            return map.get(key);
        }
    }

    public void put(int key,userInfo value){
        if(map.containsKey(key)){
            list.removeFirst();
            list.addLast(key);
            map.put(key,value);
            return;
        }
        if(list.size()==capacity){
            map.remove(list.removeFirst());
            map.put(key,value);
            list.addLast(key);
        }
        else{
            map.put(key,value);
            list.addLast(key);
        }
    }
}
