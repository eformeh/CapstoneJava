package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleReadRequest {
@NotEmpty(message = "Saleamountpaid is required")
public Double saleAmountPaid;
@NotEmpty(message = "Salecreatedat is required")
public String saleCreatedAt;
@NotEmpty(message = "Salecreditdue is required")
public String saleCreditDue;
@NotEmpty(message = "Salecustomerid is required")
public int saleCustomerId;
@NotEmpty(message = "Saledeliverytype is required")
public String saleDeliveryType;
@NotEmpty(message = "Saleemployeeid is required")
public int saleEmployeeId;
@NotEmpty(message = "Saleid is required")
public int saleId;
@NotEmpty(message = "Salestatus is required")
public String saleStatus;
@NotEmpty(message = "Saletotalamount is required")
public Double saleTotalAmount;
@NotEmpty(message = "Saletype is required")
public String saleType;
@NotEmpty(message = "Saleupdatedat is required")
public String saleUpdatedAt;
}
