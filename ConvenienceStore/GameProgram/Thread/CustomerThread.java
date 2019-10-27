package GameProgram.Thread;

import person.Customer;
import utils.info.ConstantTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import static GameProgram.Thread.Common.*;

/**
 * @className: CustomerThread
 * @author: Shidan Cheng
 * @description: 顾客线程
 * @date: 5:58 下午 2019/10/27
 * @version: v1.0
 */
public class CustomerThread implements Runnable {
    String[] nameList = {"Jessica", "Glen", "Jacqueline", "Brittany", "James", "Katherine", "Elliott", "Jacob", "Clover", "Carlota"};



    @Override
    public void run() {
        while (true) {
            try {
                while (customerList.size() < ConstantTable.CUSTOMER_NUMBER) {
                    Random r = new Random();
                    int i = r.nextInt(nameList.length);
                    Customer customer = customerFactory.createCustomer(nameList[i]);
                    int j = r.nextInt(customerBuyMap.size() - 1);
                    customer.setBuyType(j);
                    customer.setCheckOutFlow(i / 2);
                    customerList.add(customer);
                }
                Thread.sleep(5000);
            } catch (Exception e) {

            }
        }
    }
}
