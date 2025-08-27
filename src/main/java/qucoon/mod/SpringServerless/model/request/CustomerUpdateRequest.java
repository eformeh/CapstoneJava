package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CustomerUpdateRequest {
public String customerAddress;
public String customerCompanyName;
public String customerCreatedAt;
public Double customerCreditBalance;
public String customerEmail;
public int customerId;
public String customerName;
public String customerNotes;
public String customerPhone;
public String customerStatus;
public String customerType;
public String customerUpdatedAt;
}
