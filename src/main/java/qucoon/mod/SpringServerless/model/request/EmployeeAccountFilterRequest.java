package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EmployeeAccountFilterRequest {

private String employeeAccountBankName;
private String employeeAccountCreatedAt;
private Integer employeeAccountEmployeeId;
private Integer employeeAccountId;
private String employeeAccountName;
private String employeeAccountNumber;
private String employeeAccountStatus;
private String employeeAccountUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
