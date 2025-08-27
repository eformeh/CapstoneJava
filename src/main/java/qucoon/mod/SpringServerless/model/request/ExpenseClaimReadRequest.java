package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseClaimReadRequest {
@NotEmpty(message = "Expenseclaimcreatedat is required")
public String expenseClaimCreatedAt;
@NotEmpty(message = "Expenseclaimdecisiondate is required")
public String expenseClaimDecisionDate;
@NotEmpty(message = "Expenseclaimemployeeid is required")
public int expenseClaimEmployeeId;
@NotEmpty(message = "Expenseclaimid is required")
public int expenseClaimId;
@NotEmpty(message = "Expenseclaimreimbursementdate is required")
public String expenseClaimReimbursementDate;
@NotEmpty(message = "Expenseclaimreviewerid is required")
public int expenseClaimReviewerId;
@NotEmpty(message = "Expenseclaimstatus is required")
public String expenseClaimStatus;
@NotEmpty(message = "Expenseclaimtotalamount is required")
public Double expenseClaimTotalAmount;
@NotEmpty(message = "Expenseclaimupdatedat is required")
public String expenseClaimUpdatedAt;
}
