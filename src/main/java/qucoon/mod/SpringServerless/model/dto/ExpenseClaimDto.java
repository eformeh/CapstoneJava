package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ExpenseClaim;


@Data
public class ExpenseClaimDto  {

private String expenseClaimCreatedAt;
private String expenseClaimDecisionDate;
private Integer expenseClaimEmployeeId;
private Integer expenseClaimId;
private String expenseClaimReimbursementDate;
private Integer expenseClaimReviewerId;
private String expenseClaimStatus;
private Double expenseClaimTotalAmount;
private String expenseClaimUpdatedAt;

public static ExpenseClaimDto from(ExpenseClaim p) {
    ExpenseClaimDto dto = new ExpenseClaimDto();

    dto.setExpenseClaimCreatedAt(p.getExpenseClaimCreatedAt());
    dto.setExpenseClaimDecisionDate(p.getExpenseClaimDecisionDate());
    dto.setExpenseClaimEmployeeId(p.getExpenseClaimEmployeeId());
    dto.setExpenseClaimId(p.getExpenseClaimId());
    dto.setExpenseClaimReimbursementDate(p.getExpenseClaimReimbursementDate());
    dto.setExpenseClaimReviewerId(p.getExpenseClaimReviewerId());
    dto.setExpenseClaimStatus(p.getExpenseClaimStatus());
    dto.setExpenseClaimTotalAmount(p.getExpenseClaimTotalAmount());
    dto.setExpenseClaimUpdatedAt(p.getExpenseClaimUpdatedAt());
    return dto;
   }
}
