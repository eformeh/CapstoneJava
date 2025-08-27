package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SaleCreateRequest {
public Double saleAmountPaid;
public String saleCreditDue;
@NotNull(message = "saleCustomerId is required")
public int saleCustomerId;
public String saleDeliveryType;
@NotNull(message = "saleEmployeeId is required")
public int saleEmployeeId;
public Double saleTotalAmount;
public String saleType;
}
