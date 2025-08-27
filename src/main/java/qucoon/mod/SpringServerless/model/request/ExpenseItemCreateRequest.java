package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class ExpenseItemCreateRequest {
public Double expenseItemAmount;
public String expenseItemCategory;
@NotNull(message = "expenseItemClaimId is required")
public int expenseItemClaimId;
public String expenseItemDescription;
public String expenseItemReceiptUrl;
}
