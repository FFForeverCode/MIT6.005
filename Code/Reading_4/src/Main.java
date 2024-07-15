/**
 * @author KiKidog
 * @date 2024/7/14
 */
public class Main {
    public static void main(String[] args) {
        //Style of code 代码审查
        //1.注释 规范
        /**
         * 1.该方法的作用
         * 2.See URL 指定从其他地方复制或改编的代码出处与地址
         * 3.@param 参数名 解释
         * 。。
         * 4.@return 返回值  返回值解释
         */
        //2.需要时注释 ： 晦涩难懂的代码  复制引用的代码注释指明出处
        //3.魔法数字：避免直接使用数字 ，使用未命名的数字会掩盖开发人员选择该数字的意图
        // 故使用数字前要命名，表明其意图 将数字声明为具有良好、清晰名称的命名常量
        //4.DRY 不要重复你自己 即不要重复大量的相同的代码块 消除重复的代码块
        //5.每个变量一个目的
        // 不同的变量不同的目的
        // 不要更改方法参数 尽量用final修饰限定参数
        //新建变量来接收参数
        //不要重复使用参数 ，变量
        //6.使用好名字 好的方法和变量名应该很长，并且具有自我描述性。
        // 通常，可以通过使用更好的名称来描述方法和变量，让代码本身更具可读性，
        // 从而完全避免注释。
        //7.方法以驼峰命名 public static void getNumber(final int num);
        //变量也是驼峰命名 int secondNum;避免使用缩写 int message;
        //常量全部大写并带有下划线
        //课程名称大写
        //包都是小写，并以点分隔

    }
    /**
     * Exercise
     */
    /**
     * 判断年份是否为闰年
     * @param year 指定判断的年份
     * @return 若为闰年则返回ture 反之 返回false
     */
    public static boolean judgeLeap(final int year){
        return year % 4 == 0 && year % 100 != 0;

    }
    //8.避免使用全局变量
    //9.方法应该返回结果 而不是打印结果
    /**
     * 概括
     * 代码审查是一种广泛使用的技术，通过人工检查来提高软件质量。代码审查可以检测出代码中的许多问题，但作为入门，本文讨论了优秀代码的一般原则：
     *
     * 不要重复自己（DRY） 不要重复大量的相同代码块 使得错误时修改不彻底
     * 必要的注释
     * 尽早的测试 与 失败检查
     * 避免使用神奇数字 避免直接使用未命名的数字
     * 每个变量一个目的
     * 使用好名字 命名规则 具有解释意义 格式
     * 没有全局变量 避免使用全局变量
     * 方法返回结果，避免打印
     * 使用空格提高可读性
     * 今天阅读的主题与优秀软件的三个关键属性相关，如下所示：
     *
     * 避免出现错误。 一般来说，代码审查使用人工审查人员来查找错误。DRY 代码可让您仅在一个地方修复错误，而不必担心它会传播到其他地方。
     * 清楚地注释您的假设可以降低其他程序员引入错误的可能性。
     * 快速失败原则可尽早发现错误。
     * 避免使用全局变量可以更轻松地定位与变量值相关的错误，因为非全局变量只能在代码中的有限位置进行更改。
     *
     * 易于理解。 代码审查实际上是查找晦涩或令人困惑的代码的唯一方法，因为其他人正在阅读并试图理解它。
     * 使用明智的注释、避免使用魔法数字、为每个变量保留一个用途、使用好的名称以及很好地使用空格都可以提高代码的可理解性。
     *
     * 为变更做好准备。 代码审查由经验丰富的软件开发人员进行，他们可以预测可能发生的变化并提出防范方法，这很有帮助。
     * DRY 代码更适合变更，因为只需在一个地方进行更改。
     * 返回结果而不是打印结果，可以更轻松地将代码调整为新用途。
     */
}