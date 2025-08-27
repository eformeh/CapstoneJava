package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CustomerReadRequest {
@NotEmpty(message = "Customeraddress is required")
public String customerAddress;
@NotEmpty(message = "Customercompanyname is required")
public String customerCompanyName;
@NotEmpty(message = "Customercreatedat is required")
public String customerCreatedAt;
@NotEmpty(message = "Customercreditbalance is required")
public Double customerCreditBalance;
@NotEmpty(message = "Customeremail is required")
public String customerEmail;
@NotEmpty(message = "Customerid is required")
public int customerId;
@NotEmpty(message = "Customername is required")
public String customerName;
@NotEmpty(message = "Customernotes is required")
public String customerNotes;
@NotEmpty(message = "Customerphone is required")
public String customerPhone;
@NotEmpty(message = "Customerstatus is required")
public String customerStatus;
@NotEmpty(message = "Customertype is required")
public String customerType;
@NotEmpty(message = "Customerupdatedat is required")
public String customerUpdatedAt;
}
