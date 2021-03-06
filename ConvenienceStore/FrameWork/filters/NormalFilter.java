package filters;

import person.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: NormalFilter
 * @author: Yinan Cheng
 * @description: 过滤出下一年度不建议办卡的顾客
 * @designPattern: Filter
 * @date: 0:04 2019/10/24
 */
public class NormalFilter implements Filter {
    @Override
    public List<Customer> filtrate(List<Customer> customers) {
        List<Customer> customerList = new ArrayList<Customer>();
        for (Customer customer : customers) {
            if (customer.getExpense() <= 60) {
                customerList.add(customer);
            }
        }
        return customerList;
    }
}
