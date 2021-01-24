package company;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把公司抽象为公司类
 *
 */
public class Company {
//  1)  公司中有若干的员工,使用数组保存员工的信息;
    private Employee[] data;
    //一般情况下,在使用数组时, 会定义变量记录数组中元素的数量
    private int size  ;

    //如果实例变量是数组, 一般情况下会在无参构造方法中对数组进行默认初始化
    public Company(){
        data = new Employee[100];   //数组初始化大小需要估算
    }
    //实例变量是数组, 也可以在类的构造方法中传递一个数组的容量
    public Company( int capacity ){
        data = new Employee[capacity];
    }

//    定义方法添加员工; 需要通过参数来接收一个员工对象
    public void  add( Employee e ){
        //一般情况下,在向数组中添加元素前会判断数组是否已满,或者说数组是否还有足够的空间
        if ( size >= data.length ){
            //如果数组中元素的数量size 等于 数组的长度,表示数组已满, 需要扩容
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = e;   //把参数e接收的员工添加到data数组中,
    }

//    定义方法显示所有员工的信息;
    public void showAll(){
        System.out.println("--------------所有员工信息-----------------");
        //只需要遍历数组的前size个元素即可
        for (int i = 0; i < size; i++) {
            System.out.println( data[i] );
        }
    }

//    定义方法判断是否存在指定姓名的员工, 通过参数来接收一个员工的姓名, 返回一个布尔值表示是否存在
    public boolean containsName( String name ){
       /* //当方法参数是引用类型时, 在方法体中,经常需要判断是否为空
        if ( name == null ){    //参数name为null
            //遍历数组中前size个员工对象,如果有某个员工对象的姓名也是null返回true
            for (int i = 0; i < size; i++) {
                if ( data[i].getName() == null){
                    return true;
                }
            }
        }else {         //参数name不为null
            //遍历数组的前size个元素,如果有某个员工的姓名与参数name一样就返回true,
            for (int i = 0; i < size; i++) {
                String empName = data[i].getName();    //返回第i个员工的姓名
                if (name.equals(empName)) {
                    return true;
                }
            }
        }
        //当for循环结束,遍历完所有的员工对象,还没有找到匹配的员工就返回false
        return  false;*/
        return  indexOf(name) >= 0 ;        //判断指定姓名员工在数组中索引值
    }

//    定义方法删除指定姓名的员工
    public void deleteByName(String name ){
        //先在data数组中找到姓名是name的员工的索引值
        int index = indexOf(name);  //调用方法返回name在数组中的索引值
        if ( index < 0 ){
            return;
        }

        //在数组中把该索引值的元素删除, 从index+1开始的元素逐个前移
        System.arraycopy(data, index+1, data, index, size-index - 1);
        //原来数组中最后一个元素置为null
        data[size-1] = null;
        //元素的数量要减 1
        size--;
    }

    //定义方法返回指定姓名在数组中的索引值
    private int indexOf(String name) {
        //当方法参数是引用类型时, 在方法体中,经常需要判断是否为空
        if ( name == null ){    //参数name为null
            //遍历数组中前size个员工对象,如果有某个员工对象的姓名也是null返回该元素的下标
            for (int i = 0; i < size; i++) {
                if ( data[i].getName() == null){
                    return i;
                }
            }
        }else {         //参数name不为null
            //遍历数组的前size个元素,如果有某个员工的姓名与参数name一样就返回该元素的下标
            for (int i = 0; i < size; i++) {
                String empName = data[i].getName();    //返回第i个员工的姓名
                if (name.equals(empName)) {
                    return i;
                }
            }
        }
        //当for循环结束,遍历完所有的员工对象,还没有找到匹配的员工就返回负数
        return  -1;
    }


//    定义方法根据员工年龄升序排序
    public void sortByAge(){
        Arrays.sort(data, 0, size, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //o1的年龄大返回正数, 对应升序排序
                return o1.getAge() - o2.getAge();
            }
        });
    }

//    定义方法根据员工工资降序排序
    public void sortBySalary(){
        Arrays.sort(data, 0, size, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //o2的工资高返回正数对应降序排序
//                return (int)o2.getSalary() - (int)o1.getSalary();   //900.9元与900.1是相等的
                if ( o2.getSalary() > o1.getSalary()){
                    return  1;
                }else if (o2.getSalary() == o1.getSalary() ){
                    return  0;
                }else {
                    return -1;
                }
            }
        });
    }

    //根据员工的姓名升序排序
    public void sortByName(){
        Arrays.sort(data, 0, size, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //o1对象的姓名比o2对象的姓名大返回正数对应升序
//                return o1.getName() .compareTo( o2.getName() );
                //       o1的姓名                o2的姓名      o1的姓名大返回正数

                return o2.getName().compareTo(o1.getName());    //o2的姓名大返回正数, 对应降序
            }
        });
    }
}
