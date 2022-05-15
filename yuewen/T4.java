import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/23 16:20
 */
public class T4 {
    /**
     * 问题描述：编写用牛顿迭代法求方程的根。方程ax³+bx³+cx+d=0，系数a，b，c，d
     *           由主函数输出。求x在1附近的一个实根，由主函数输出。
     *           牛顿的迭代法公式是：x = x0-f(x0)/f'(x0)，设迭代到|x-x0|<=10^-5
     *           时结束。
     *
     * 算法分析：牛顿迭代法是计算方程近似值的常用方法，主要步骤有：
     *          1. 假定一个初始值，这里设x0=1.5
     *          2. 将初始值x0带入函数f(x0)和导函数fd(x0)
     *          3. 通过公式x = x0-f(x0)/fd(x0)计算出新的近似值x
     *          4. 判断是否符合近似值要求的标准，若不符合继续通过公式进行近似计算
     */
    public static void main(String[] args) {

        float a,b,c,d ;

        Scanner s = new Scanner(System.in) ;
        System.out.println("请输入a,b,c,d的值(请用空格隔开):");
        a = s.nextFloat() ;
        b = s.nextFloat() ;
        c = s.nextFloat() ;
        d = s.nextFloat() ;
        s.close();

        float x = 1.5F , x0 ;
        do{

            x0 = x ;
            float f = a*x0*x0*x0 + b*x0*x0 + c*x0 + d ; //计算f(x0)
            float fd = 3*a*x0*x0 + 2*b*x0 + c ;         //计算fd(x0)
            x = x0 - f/fd ;

        }while(Math.abs(x-x0)>=10e-5) ;                 //判断是否符合标准

        System.out.println(x);
    }
}

