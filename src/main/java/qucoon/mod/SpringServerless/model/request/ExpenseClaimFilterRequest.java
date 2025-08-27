package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExpenseClaimFilterRequest {

private String expenseClaimCreatedAt;
private String expenseClaimDecisionDate;
private Integer expenseClaimEmployeeId;
private Integer expenseClaimId;
private String expenseClaimReimbursementDate;
private Integer expenseClaimReviewerId;
private String expenseClaimStatus;
private Double expenseClaimTotalAmount;
private String expenseClaimUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
