package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalePaymentLogUpdateRequest {
public Double salePaymentLogAmount;
public String salePaymentLogCreatedAt;
public int salePaymentLogEmployeeid;
public int salePaymentLogid;
public String salePaymentLogMethod;
public String salePaymentLogNotes;
public int salePaymentLogSaleid;
public String salePaymentLogStatus;
public String salePaymentUpdatedAt;
}
