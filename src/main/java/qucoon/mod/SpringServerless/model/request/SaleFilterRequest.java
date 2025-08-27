package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SaleFilterRequest {

private Double saleAmountPaid;
private String saleCreatedAt;
private String saleCreditDue;
private Integer saleCustomerId;
private String saleDeliveryType;
private Integer saleEmployeeId;
private Integer saleId;
private String saleStatus;
private Double saleTotalAmount;
private String saleType;
private String saleUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
