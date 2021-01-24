package array;

import java.util.Arrays;

/**
 * 二维数组
 *      是数组的数组
 *      或者简单点说, 在定义数组时,使用一对方括弧就是一维数组; 定义数组时使用两对方括弧就是二维数组
 */
public class Test {
    public static void main(String[] args) {
        //数组是用来存储同一类型若干数据的容器. 定义数组的语法: 数据类型 [] 数组名 = new 数据类型[长度].  数据类型是数组中存储数据的类型
        int [] data1 = new int[10];     //给数组元素默认初始化
        int [] data2 = {1,2,3,4,5};     //静态初始化
        int x = 10;
        int y = 20;
        int [] data3 = { x , y };   //把x,y变量的值存储到数组中
        //定义数组data1, data2, data3时,指定的数据类型int是指数组中存储的数据是int类型的
        //数组名data1, data2, data3其实就是变量名, 它们的数据类型都是 int []
        //定义数组, 把data1, data2, data3存储到数组中, 定义数组时的数据类型应该定义为int[]
//        数据类型 [] mydata = { data1, data2, data3};
        int[] [] mydata = { data1, data2, data3};   //mydata是数组名, mydata前面的[]表示正在定义数组,  方括弧[]前面的 int[] 是指mydata数组中存储数据的类型
        //mydata是一个数组, 数组的元素又是一个数组, 称mydata数组为二维数组

        //打印mydata数组的长度
        System.out.println( mydata.length );    // 3,  mydata数组就存储了data1, data2, data3这三个元素

        //遍历二维数组存储的具体数据
        for (int i = 0; i < mydata.length; i++) {
            //当i==0时, mydata[0]是data1;  mydata[1]是data2,  mydata[2] 是data3, 即mydata[i]这个二维数组元素是另外一个一维数组的数组名, 数组名存储的堆中数组的引用(地址)
//            System.out.println( mydata[i] );
            //可以继续遍历 mydata[i] 数组中的数据, 把mydata[i]整体看作是一个数组名
            for (int j = 0; j < mydata[i].length; j++) {
                System.out.print(  mydata[i][j] + "  ");
            }
            System.out.println();
        }

        //使用foreach循环遍历
        for (int[] ints : mydata) {
            //mydata中的每个元素是int[]类型的一维数组, 可以继续遍历数组中的数据
            for (int xx : ints) {
                System.out.print( xx + " ");
            }
            System.out.println();
        }

        /*
        * 二维数组的定义格式:
        *   数据类型 [][] 数组名 = new 数据类型[二维数组的长度][];
        * */
        int [][] twoArray1 = new int[5][];  //定义了数组twoArray1, 该数组存储 int[] 类型的数据, 该数组有5个元素, 系统会给twoarray1这5个元素默认初始化为null
        for (int i = 0; i < twoArray1.length; i++) {
            System.out.println(twoArray1[i]);
        }

        /*在定义二维数组时,除了指定二维数组的长度,还可以指定一维数组的长度
            数据类型 [][] 数组名 = new 数据类型[二维数组长度][一维数组长度]
         */
        int [][] twoArray2 = new int[5][10];    //定义数组twoArray2, 有5个元素, 每个元素是长度为10的一维数组, 如果指定了一维 数组长度,系统会给一维数组默认初始化
        for (int i = 0; i < twoArray2.length; i++) {
//            System.out.println( twoArray2[i] );       //元素不为null, 每个 元素是长度10的一维数组
            for (int j = 0; j < twoArray2[i].length; j++) {
                System.out.print( twoArray2[i][j] + " ");
            }
            System.out.println();
        }

        //twoArray2元素是int[]类型, 给twoArray2数组元素赋值时,就需要赋值int[]类型的数据
        twoArray2[0] = data1;
        twoArray2[1] = data2;
        twoArray2[2] = new int[]{6,6,6,6,6};
//        twoArray2[3] = {7,8,9};         //这种简化的形式仅用于数据的静态初始化, 即在定义数组的同时给数组元素赋值可以使用这种简化的形式, 不能用于重新赋值

        //可以调用Arrays.deepToString()可以把二维数组的各个元素连接为一个字符串
        System.out.println(Arrays.deepToString(twoArray2));

        //二维数组的静态初始化
        int [][] twoArray3 = new int[][] { {1,2,3,4,5}, {6,7,8}, {9}};
        int [][] twoArray4 =  { {1,2,3,4,5}, {6,7,8}, {9} , new int[6], new int[]{1,2,3} };

    }
}
