package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DeductionFilterRequest {

private Double deductionAmount;
private String deductionCreatedAt;
private Integer deductionId;
private Integer deductionSalaryId;
private String deductionStatus;
private String deductionType;
private String deductionUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
