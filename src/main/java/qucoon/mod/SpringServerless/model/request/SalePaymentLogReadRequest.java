package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalePaymentLogReadRequest {
@NotEmpty(message = "Salepaymentlogamount is required")
public Double salePaymentLogAmount;
@NotEmpty(message = "Salepaymentlogcreatedat is required")
public String salePaymentLogCreatedAt;
@NotEmpty(message = "Salepaymentlogemployeeid is required")
public int salePaymentLogEmployeeid;
@NotEmpty(message = "Salepaymentlogid is required")
public int salePaymentLogid;
@NotEmpty(message = "Salepaymentlogmethod is required")
public String salePaymentLogMethod;
@NotEmpty(message = "Salepaymentlognotes is required")
public String salePaymentLogNotes;
@NotEmpty(message = "Salepaymentlogsaleid is required")
public int salePaymentLogSaleid;
@NotEmpty(message = "Salepaymentlogstatus is required")
public String salePaymentLogStatus;
@NotEmpty(message = "Salepaymentupdatedat is required")
public String salePaymentUpdatedAt;
}
