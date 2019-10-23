package filters;

import person.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: SeniorFilter
 * @author: Yinan Cheng
 * @description: 过滤出下一年度建议办高级会员卡顾客
 * @designPattern: Filter
 * @date: 0:03 2019/10/24
 */
public class SeniorFilter implements Filter {
    @Override
    public List<Customer> filtrate(List<Customer> customers) {
        List<Customer> customerList = new ArrayList<Customer>();
        for (Customer customer : customers) {
            if (customer.getExpense() >140) {
                customerList.add(customer);
            }
        }
        return customerList;
    }
}
