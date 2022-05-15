/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/17 17:08
 */
class A{
    static{
        System.out.println("A init");
    }
    public A(){
        System.out.println("A Instance");
    }
}

class B extends A{
    static {
        System.out.println("B init");
    }
    public B(){
        System.out.println("B Instance");
    }
}
public class T4 {
    public static void main(String[] args){
        B b = new B();
    }
}
