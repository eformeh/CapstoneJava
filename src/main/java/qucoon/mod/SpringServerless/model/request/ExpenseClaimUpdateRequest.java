package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseClaimUpdateRequest {
public String expenseClaimCreatedAt;
public String expenseClaimDecisionDate;
public int expenseClaimEmployeeId;
public int expenseClaimId;
public String expenseClaimReimbursementDate;
public int expenseClaimReviewerId;
public String expenseClaimStatus;
public Double expenseClaimTotalAmount;
public String expenseClaimUpdatedAt;
}
