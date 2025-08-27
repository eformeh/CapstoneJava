package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExpenseItemFilterRequest {

private Double expenseItemAmount;
private String expenseItemCategory;
private Integer expenseItemClaimId;
private String expenseItemCreatedAt;
private String expenseItemDescription;
private Integer expenseItemId;
private String expenseItemReceiptUrl;
private String expenseItemStatus;
private String expenseItemUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
