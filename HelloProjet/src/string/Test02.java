package string;

import java.text.Collator;
import java.util.Locale;

/**
 * String的常用方法
 */
public class Test02 {
    public static void main(String[] args) {
        /*1. char charAt(int index) 返回指定索引值的字符
            String字符串底层是通过char value[] 字符数组来存储各个字符的, charAt(i)返回指定位置的字符,实际就是返回value[i]数组元素
            int length()  返回字符串的长度,即字符串中字符的数量, 实际返回的底层value.length
         */
        String txt = "hello动力节点";
        char cc = txt.charAt(0);
        System.out.println(cc );    //h
        cc = txt.charAt(6);
        System.out.println(cc);     //力
        System.out.println( txt.length() );     //9
        //遍历字符串的每个字符
        for (int i = 0; i < txt.length(); i++) {
            System.out.println( txt.charAt(i) );
        }

        /*2 int compareTo(String anotherString)比较当前字符串与参数字符串的大小,如果当前字符串大返回正数, 参数字符串大返回负数,相等返回0
        int compareToIgnoreCase(String str)  忽略大小写再比较大小

            Java把当前对象与另外一个对象比较大小的功能抽象到Comparable接口中, 该接口的定义如下:
                public interface Comparable<T> {
                    public int compareTo(T o);
                }
            说明:
                1) 接口名Comparable后面有 <T> , 这是泛型, 使用泛型参数T来接收一个数据类型, 如String implements Comparable<String>{},   把String传递给参数T, 即compareTo方法的参数T类型就是String类型. Comparable接口后面的泛型<T>用于接收比较对象的数据类型
                2) 泛型就是把数据类型作为参数传递

            Java实现了Comparable接口, 重写了compareTo()方法, 在compareTo()方法是根据第一个不相等的字符, 码值相减来判断字符串大小
         */
        System.out.println("hello".compareTo("hehe"));  //4, 返回正数就表示第一个字符串大
        System.out.println("hello".compareTo("helloworld"));    //-5, 负数表示参数字符串大
        System.out.println("hello".compareTo("HELLO"));     //32, 区分大小写
        //如果比较大小时,不想区分大小写,可以调用compareToIgnaoreCase()
        System.out.println( "hello".compareToIgnoreCase("HeLLO"));  //0
        //汉字也是根据码值比较大小
        System.out.println("张三".compareTo("李四"));   //-2094, 参数字符串大
        System.out.println((int)'张');       //24352
        System.out.println((int)'李');       //26446

        //按照汉字顺序比较大小, 需要先获得一个汉字大小的比较器
        Collator collator = Collator.getInstance(Locale.CHINESE);
        //调用Collator中文比较器的compare(o1, o2) 方法比较大小
        System.out.println( collator.compare("张三", "李四"));  //1, 正数表示第一个字符串大

        /*3 String concat(String str)在当前字符串连接参数字符串,返回连接后的新串
            boolean contains(CharSequence s)  判断当前字符串是否包含参数字符串s
            boolean endsWith(String suffix)  判断当前字符串是否以suffix结尾
            boolean startsWith(String prefix)  判断当前字符串是否以prefix开始
            boolean equals(Object anObject)  重写equals()判断两个字符串是否一样
            boolean equalsIgnoreCase(String anotherString)  忽略大小写再判断是否一样
         */
        String s = txt.concat("NB");    //返回新串,原来的字符串不变
        System.out.println(  s );   //hello动力节点NB
        System.out.println( txt );      //hello动力节点
        System.out.println( txt.contains("动力"));    //true, 判断txt中是否包含动力
        System.out.println( s.startsWith("hello"));     //true, 判断s是否以hello开始
        System.out.println( s.endsWith("world"));     //false, 判断s是否以world结尾
        System.out.println( s.equals(txt));     //false, 判断s与txt引用的字符串是否一样
        System.out.println( "hello".equalsIgnoreCase("Hello"));     //true, 忽略大小写
    }
}
