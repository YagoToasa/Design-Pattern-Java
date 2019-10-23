package filters;

import person.Customer;

import java.util.List;

public interface Filter {
    List<Customer> filtrate(List<Customer> customers);
}
