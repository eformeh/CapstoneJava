package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SalaryFilterRequest {

private Double salaryBasicAmount;
private String salaryCreatedAt;
private Integer salaryEmployeeId;
private Double salaryGrossPay;
private Integer salaryId;
private Double salaryNetPay;
private Integer salaryPayPeriodId;
private String salaryStatus;
private String salaryUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
