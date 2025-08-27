package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SalePaymentLogCreateRequest {
public Double salePaymentLogAmount;
@NotNull(message = "salePaymentLogEmployeeid is required")
public int salePaymentLogEmployeeid;
public String salePaymentLogMethod;
public String salePaymentLogNotes;
@NotNull(message = "salePaymentLogSaleid is required")
public int salePaymentLogSaleid;
public String salePaymentUpdatedAt;
}
