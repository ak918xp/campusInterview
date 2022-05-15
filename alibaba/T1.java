import java.util.function.IntConsumer;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/26 15:36
 */
class T1{
    private int n;
    private volatile int count=0;
    private volatile int sum=0;

    public void print0(){
        new Thread(()->
            while(count<=100){
                if(count%5==0){
                    sum+=count;
                    System.out.println(sum);
                    count++;
                }
        }
    }).start();

    public void print1(){
        new Thread(()->
        while(count<=100){
            if(count%5==1){
                sum+=count;
                System.out.println(sum);
                count++;
            }
        }
    }).start();

    public void print2(){
        new Thread(()->
        while(count<=100){
            if(count%5==2){
                sum+=count;
                System.out.println(sum);
                count++;
            }
        }
    }).start();

    public void print3(){
        new Thread(()->
        while(count<=100){
            if(count%5==3){
                sum+=count;
                System.out.println(sum);
                count++;
            }
        }
    }).start();

    public void print4(){
        new Thread(()->
        while(count<=100){
            if(count%5==4){
                sum+=count;
                System.out.println(sum);
                count++;
            }
        }
    }).start();
}
