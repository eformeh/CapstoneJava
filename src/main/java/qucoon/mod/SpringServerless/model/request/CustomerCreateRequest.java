package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class CustomerCreateRequest {
@NotEmpty(message = "customerAddress is required")
public String customerAddress;
@NotEmpty(message = "customerCompanyName is required")
public String customerCompanyName;
@NotEmpty(message = "customerCreditBalance is required")
public Double customerCreditBalance;
@NotEmpty(message = "customerEmail is required")
public String customerEmail;
@NotEmpty(message = "customerName is required")
public String customerName;
public String customerNotes;
@NotEmpty(message = "customerPhone is required")
public String customerPhone;
@NotEmpty(message = "customerType is required")
public String customerType;
}
