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
        Customer cyn=new Customer("程伊楠",67);
        Customer lwy=new Customer("李文玥",197);
        Customer zlw=new Customer("朱丽雯",43);
        Customer csd=new Customer("程诗丹",92);
        Customer llx=new Customer("刘岚心",56);
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(cyn);
        customerList.add(lwy);
        customerList.add(zlw);
        customerList.add(csd);
        customerList.add(llx);

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
