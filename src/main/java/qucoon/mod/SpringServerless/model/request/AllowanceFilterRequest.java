package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AllowanceFilterRequest {

private Double allowanceAmount;
private String allowanceCreatedAt;
private Integer allowanceId;
private Integer allowanceSalaryId;
private String allowanceStatus;
private String allowanceType;
private String allowanceUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
