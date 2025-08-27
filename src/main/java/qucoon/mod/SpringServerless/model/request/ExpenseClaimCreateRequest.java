package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class ExpenseClaimCreateRequest {
public String expenseClaimDecisionDate;
@NotNull(message = "expenseClaimEmployeeId is required")
public int expenseClaimEmployeeId;
public String expenseClaimReimbursementDate;
@NotNull(message = "expenseClaimReviewerId is required")
public int expenseClaimReviewerId;
public Double expenseClaimTotalAmount;
}
