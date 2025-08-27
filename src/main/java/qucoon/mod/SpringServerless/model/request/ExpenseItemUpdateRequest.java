package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseItemUpdateRequest {
public Double expenseItemAmount;
public String expenseItemCategory;
public int expenseItemClaimId;
public String expenseItemCreatedAt;
public String expenseItemDescription;
public int expenseItemId;
public String expenseItemReceiptUrl;
public String expenseItemStatus;
public String expenseItemUpdatedAt;
}
