package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Customer;


@Data
public class CustomerDto  {

private String customerAddress;
private String customerCompanyName;
private String customerCreatedAt;
private Double customerCreditBalance;
private String customerEmail;
private Integer customerId;
private String customerName;
private String customerNotes;
private String customerPhone;
private String customerStatus;
private String customerType;
private String customerUpdatedAt;

public static CustomerDto from(Customer p) {
    CustomerDto dto = new CustomerDto();

    dto.setCustomerAddress(p.getCustomerAddress());
    dto.setCustomerCompanyName(p.getCustomerCompanyName());
    dto.setCustomerCreatedAt(p.getCustomerCreatedAt());
    dto.setCustomerCreditBalance(p.getCustomerCreditBalance());
    dto.setCustomerEmail(p.getCustomerEmail());
    dto.setCustomerId(p.getCustomerId());
    dto.setCustomerName(p.getCustomerName());
    dto.setCustomerNotes(p.getCustomerNotes());
    dto.setCustomerPhone(p.getCustomerPhone());
    dto.setCustomerStatus(p.getCustomerStatus());
    dto.setCustomerType(p.getCustomerType());
    dto.setCustomerUpdatedAt(p.getCustomerUpdatedAt());
    return dto;
   }
}
