package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SalePaymentLogFilterRequest {

private Double salePaymentLogAmount;
private String salePaymentLogCreatedAt;
private Integer salePaymentLogEmployeeid;
private Integer salePaymentLogid;
private String salePaymentLogMethod;
private String salePaymentLogNotes;
private Integer salePaymentLogSaleid;
private String salePaymentLogStatus;
private String salePaymentUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
