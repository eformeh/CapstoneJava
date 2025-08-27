
package   qucoon.mod.SpringServerless.service;


import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.utility.LocalDateTimeTypeAdapter;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.CustomerPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.CustomerDto;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private  final Gson GSON;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(CustomerCreateRequest request) {
        //Unique Attribute Check
        List<Customer> customer_1 = customerRepository.readByCustomerEmail(request.getCustomerEmail());
        if (!customer_1.isEmpty()) {
            throw new CustomExceptions.DuplicateItemException("+Customer with CustomerEmail: " + request.getCustomerEmail() + " already exists");
        }

        //Unique Attribute Check
        List<Customer> customer_2 = customerRepository.readByCustomerPhone(request.getCustomerPhone());
        if (!customer_2.isEmpty()) {
            throw new CustomExceptions.DuplicateItemException("+Customer with CustomerPhone: " + request.getCustomerPhone() + " already exists");
        }


        Customer customer = GSON.fromJson(GSON.toJson(request), Customer.class);
        if (customer.getCustomerStatus() == null) {
            customer.setCustomerStatus("ACTIVE");
        }
        customerRepository.create(customer);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<CustomerCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Customer[] customerArray = GSON.fromJson(json, Customer[].class);
            List<Customer> customers = Arrays.asList(customerArray);
            customerRepository.bulkCreate(customers);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(CustomerUpdateRequest request) {
        Customer customer = customerRepository.readByCustomerId(request.getCustomerId());
        if (customer == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        customerRepository.update(customer);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int customerId) {
        int updateResponse = customerRepository.delete(customerId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public CustomerReadListResponse read() {
        List<Customer> customers = customerRepository.read();
       if(customers == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new CustomerReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), customers);
    }
   public CustomerReadPagedResponse search(CustomerFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       CustomerPage page = customerRepository.findCustomer(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<CustomerDto> dtos = page.getData().stream()
            .map(CustomerDto::from)
            .collect(Collectors.toList());
    return new CustomerReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public CustomerReadListResponse readByCustomerAddress(String customeraddress) {
        List<Customer> customers = customerRepository.readByCustomerAddress(customeraddress);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadListResponse readByCustomerCompanyName(String customercompanyname) {
        List<Customer> customers = customerRepository.readByCustomerCompanyName(customercompanyname);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadListResponse readByCustomerCreatedAt(String customercreatedat) {
        List<Customer> customers = customerRepository.readByCustomerCreatedAt(customercreatedat);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadListResponse readByCustomerCreditBalance(Double customercreditbalance) {
        List<Customer> customers = customerRepository.readByCustomerCreditBalance(customercreditbalance);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadSingleResponse readByCustomerEmail(String customeremail) {
        List<Customer> customer = customerRepository.readByCustomerEmail(customeremail);
        if (customer == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new CustomerReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                customer.get(0));
    }
    public CustomerReadSingleResponse readByCustomerId(int customerid) {
        Customer customer = customerRepository.readByCustomerId(customerid);
        if (customer == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new CustomerReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                customer);
    }
    public CustomerReadListResponse readByCustomerName(String customername) {
        List<Customer> customers = customerRepository.readByCustomerName(customername);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadListResponse readByCustomerNotes(String customernotes) {
        List<Customer> customers = customerRepository.readByCustomerNotes(customernotes);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadSingleResponse readByCustomerPhone(String customerphone) {
        List<Customer> customer = customerRepository.readByCustomerPhone(customerphone);
        if (customer == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new CustomerReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                customer.get(0));
    }
    public CustomerReadListResponse readByCustomerStatus(String customerstatus) {
        List<Customer> customers = customerRepository.readByCustomerStatus(customerstatus);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadListResponse readByCustomerType(String customertype) {
        List<Customer> customers = customerRepository.readByCustomerType(customertype);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
    public CustomerReadListResponse readByCustomerUpdatedAt(String customerupdatedat) {
        List<Customer> customers = customerRepository.readByCustomerUpdatedAt(customerupdatedat);
        return new CustomerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        customers);
    }
}
