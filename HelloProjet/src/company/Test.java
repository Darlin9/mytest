package company;

/**
 * 1) 定义员工类
 * 2)定义公司类, 公司中有若干员工
 * 3)编写测试类
 */
public class Test {
    public static void main(String[] args) {
        //创建公司
        Company company = new Company(10);  //指定数组初始化容量为10
        Company company2 = new Company();   //无参构造方法,数组默认初始化长度是100

        //添加员工
        company.add( new Employee("lisi", 25, 3000.5));
        company.add( new Employee("wangwu", 28, 8000.5));
        company.add( new Employee("zhaoliu", 29, 5000.5));
        company.add( new Employee("chenqi", 23, 7000.5));
        company.add( new Employee("zhuba", 22, 3000.9));
        company.add( new Employee("feifei", 21, 3000.1));
        company.add( new Employee() );
        company.add( new Employee() );

        //显示员工
        company.showAll();

        //判断是否存在zhaoliu
        System.out.println( company.containsName("zhaoliu"));       //true
        //判断是否存在zhaoxiaoliu
        System.out.println( company.containsName("zhaoxiaoliu"));   //false
        //查看公司中是否还有员工没有登记信息,即是否还有员工没有输入姓名,即是否存在有某个员工姓名为null的情况
        System.out.println( company.containsName(null) );   //true
        //注意: null是空值,  "null"是一个字符串, 不是同一个数据
        System.out.println( company.containsName("null") );

        //删除指定姓名的员工
        company.deleteByName("zhaoliu");
        company.showAll();
        //把没有登记姓名的员工删除,即把姓名 为null的员工都删除
        while ( company.containsName(null) ) {
            company.deleteByName(null);
        }
        company.showAll();

        //排序
        company.sortByAge();
        company.showAll();
        company.sortBySalary();
        company.showAll();
        company.sortByName();
        company.showAll();
    }
}
