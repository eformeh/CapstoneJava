
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.CustomerPage;
import qucoon.mod.SpringServerless.model.request.CustomerFilterRequest;

import java.util.List;

@Repository
    public interface CustomerRepository {


    // Additional query methods can be defined here.
    int create(Customer customer);
    void bulkCreate(List<Customer>  customer);
    int update(Customer  customer);
    int delete(int customerId);
    CustomerPage findCustomer(CustomerFilterRequest filter);
    boolean truncate();
    List<Customer> read();
    List<Customer> readByCustomerAddress(String customerAddress);
    List<Customer> readByCustomerCompanyName(String customerCompanyName);
    List<Customer> readByCustomerCreatedAt(String customerCreatedAt);
    List<Customer> readByCustomerCreditBalance(Double customerCreditBalance);
    List<Customer> readByCustomerEmail(String customerEmail);
    Customer readByCustomerId(int customerId);
    List<Customer> readByCustomerName(String customerName);
    List<Customer> readByCustomerNotes(String customerNotes);
    List<Customer> readByCustomerPhone(String customerPhone);
    List<Customer> readByCustomerStatus(String customerStatus);
    List<Customer> readByCustomerType(String customerType);
    List<Customer> readByCustomerUpdatedAt(String customerUpdatedAt);
}
