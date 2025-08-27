package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleUpdateRequest {
public Double saleAmountPaid;
public String saleCreatedAt;
public String saleCreditDue;
public int saleCustomerId;
public String saleDeliveryType;
public int saleEmployeeId;
public int saleId;
public String saleStatus;
public Double saleTotalAmount;
public String saleType;
public String saleUpdatedAt;
}
