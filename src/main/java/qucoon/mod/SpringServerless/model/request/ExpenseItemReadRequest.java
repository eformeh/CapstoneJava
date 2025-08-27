package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseItemReadRequest {
@NotEmpty(message = "Expenseitemamount is required")
public Double expenseItemAmount;
@NotEmpty(message = "Expenseitemcategory is required")
public String expenseItemCategory;
@NotEmpty(message = "Expenseitemclaimid is required")
public int expenseItemClaimId;
@NotEmpty(message = "Expenseitemcreatedat is required")
public String expenseItemCreatedAt;
@NotEmpty(message = "Expenseitemdescription is required")
public String expenseItemDescription;
@NotEmpty(message = "Expenseitemid is required")
public int expenseItemId;
@NotEmpty(message = "Expenseitemreceipturl is required")
public String expenseItemReceiptUrl;
@NotEmpty(message = "Expenseitemstatus is required")
public String expenseItemStatus;
@NotEmpty(message = "Expenseitemupdatedat is required")
public String expenseItemUpdatedAt;
}
