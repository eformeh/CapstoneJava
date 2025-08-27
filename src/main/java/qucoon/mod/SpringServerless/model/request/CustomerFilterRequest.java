package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CustomerFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
