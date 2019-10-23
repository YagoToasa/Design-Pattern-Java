import filters.Filter;
import filters.NormalFilter;
import filters.OrdinaryFilter;
import filters.SeniorFilter;
import person.Customer;

import java.util.ArrayList;
import java.util.List;


/**
 * @className: FilterDemo
 * @author: Yinan Cheng
 * @description:
 * @designPattern:
 * @date: 23:54 2019/10/23
 */
public class FilterDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== Filter Demo ==========================");
        Customer customer1=new Customer("顾客1",67);
        Customer customer2=new Customer("顾客2",197);
        Customer customer3=new Customer("顾客3",43);
        Customer customer4=new Customer("顾客4",92);
        Customer customer5=new Customer("顾客5",56);
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);

        Filter normalFilter = new NormalFilter();
        Filter ordinaryFilter = new OrdinaryFilter();
        Filter seniorFilter = new SeniorFilter();

        System.out.println("建议不办卡的顾客:");
        List<Customer> normal = normalFilter.filtrate(customerList);
        printList(normal, "建议下一年度不需要办卡了。");
        System.out.println("建议办普通会员卡的顾客:");
        List<Customer> ordinary = ordinaryFilter.filtrate(customerList);
        printList(ordinary, "建议下一年度办普通会员卡。");
        System.out.println("建议办高级会员卡的顾客:");
        List<Customer> senior = seniorFilter.filtrate(customerList);
        printList(senior, "建议下一年度办高级会员卡。");
        System.out.println("E N D ========================= Filter Demo =========================\n");
    }

    private static void printList(List<Customer> customerList, String suggestion) {
        for (Customer customer : customerList) {
            System.out.println("用户" + customer.getName()
                    + "，本年度花销：" + customer.getExpense()+","
                    + suggestion);
        }
    }

}
