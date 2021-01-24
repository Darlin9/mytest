package string;

/**
 * 演示如何创建String对象
 */
public class Test01 {
    public static void main(String[] args) {
        //1) 直接赋值字符串字面量
        String s1 = "hello";        //String是Java定义的一个类, 类是一种引用数据类型, s1就是String类型定义的变量, s1是String类定义的对象名, "hello"字符串字面量才是真正的String对象, s1保存的是"hello"对象的引用

        //2) 调用String()无参构造创建对象
        String s2 = new String();       //new运算符在堆中创建对象, 把对象的引用赋值给s2, 变量s2保存的是堆中对象的引用
        System.out.println( s2 == null );   //false,  s2是一个长度为0的字符串

        //3) 调用 String(byte[] bytes) 构造方法, 根据字节数组创建String对象
        byte[] bytes = {65,66,67,68,69,70};
        String s3 = new String(bytes);  //把bytes数组中所有的字节都转换为字符串
        System.out.println( s3 );       //ABCDEF
        //String(byte[] bytes, int offset, int length) 构造方法是把bytes数组中从offset开始的length个字节转换为字符串
        s3 = new String(bytes, 0, 4);
        System.out.println( s3 );   //ABCD

        //4) String(char[] value) 构造方法可以根据字符数组创建String对象
        char [] chars = { 'A','b','8','@','汉','字',30232 };
        String s4 = new String(chars);
        System.out.println( s4 );   //Ab8@汉字瘘
        //String(char[] value, int offset, int count) 把value数组中从offset开始的length个字符转换为字符串
        s4 = new String(chars, 2, 4);
        System.out.println( s4 );   //8@汉字

        //5) String(String original),根据已有的字符串创建新的字符串
        String s5 = new String(s1);     //new运算符在堆中创建一个对象, 把该对象的引用保存到s5中
        System.out.println( s5 );       //hello
        System.out.println( s5 == s1 );       //false,  == 判断s1与s5变量的值是否 相等, 即s5变量中保存的地址 , 与 s1　变量中保存的地址是否相同

    }
}
