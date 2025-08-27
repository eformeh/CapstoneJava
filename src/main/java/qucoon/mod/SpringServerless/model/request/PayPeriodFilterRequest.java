package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PayPeriodFilterRequest {

private String payPeriodCreatedAt;
private String payPeriodEndDate;
private Integer payPeriodId;
private String payPeriodName;
private String payPeriodPeriodType;
private String payPeriodStartDate;
private String payPeriodStatus;
private String payPeriodUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
