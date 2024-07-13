import java.util.ArrayList;
import java.util.List;

/**
 * @author KiKidog
 * @date 2024/7/13
 */
public class Main {
    public static void main(String[] args) {
        //1.静态检查：编码时检查 2.动态检查：运行编译时检查
        //final int x =10 ;final 为设置不可变引用 x只能赋值一次
        //改变是必要之恶。优秀的程序员会避免改变，因为它们可能会出乎意料地改变。
        //最好使用 final 来声明方法的参数和尽可能多的局部变量。
        //与变量的类型一样，这些声明是重要的文档，对代码的读者有用，并由编译器进行静态检查。
        //But software engineering is not hacking. Engineers are pessimists:
        //Good: write a little bit at a time, testing as you go. In a future class, we’ll talk about test-first programming.
        //Good: document the assumptions that your code depends on
        //Good: defend your code against stupidity – especially your own! Static checking helps with that.
//        The Goal of 6.005
//        Our primary goal in this course is learning how to produce software that is:
//                Safe from bugs : Correctness (correct behavior right now), and defensiveness (correct behavior in the future).
//                Easy to understand : Has to communicate to future programmers who need to understand it and make changes in it (fixing bugs or adding new features). That future programmer might be you, months or years from now. You’ll be surprised how much you forget if you don’t write it down, and how much it helps your own future self to have a good design.
//                Ready for change : Software always changes. Some designs make it easy to make changes; others require throwing away and rewriting a lot of code.
        List<Integer>list = new ArrayList<>();
        HailStone(3,list);
        System.out.println(list.toString());

    }
    public static void HailStone(int n,List<Integer>list){
        if(n==1){
            list.add(n);
            return;
        }else{
            list.add(n);
            if(n%2==0){
                n/=2;
                HailStone(n,list);
            }else{
                n=n*3+1;
                HailStone(n,list);
            }
        }
    }
}