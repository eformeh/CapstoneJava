package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ExpenseItem;


@Data
public class ExpenseItemDto  {

private Double expenseItemAmount;
private String expenseItemCategory;
private Integer expenseItemClaimId;
private String expenseItemCreatedAt;
private String expenseItemDescription;
private Integer expenseItemId;
private String expenseItemReceiptUrl;
private String expenseItemStatus;
private String expenseItemUpdatedAt;

public static ExpenseItemDto from(ExpenseItem p) {
    ExpenseItemDto dto = new ExpenseItemDto();

    dto.setExpenseItemAmount(p.getExpenseItemAmount());
    dto.setExpenseItemCategory(p.getExpenseItemCategory());
    dto.setExpenseItemClaimId(p.getExpenseItemClaimId());
    dto.setExpenseItemCreatedAt(p.getExpenseItemCreatedAt());
    dto.setExpenseItemDescription(p.getExpenseItemDescription());
    dto.setExpenseItemId(p.getExpenseItemId());
    dto.setExpenseItemReceiptUrl(p.getExpenseItemReceiptUrl());
    dto.setExpenseItemStatus(p.getExpenseItemStatus());
    dto.setExpenseItemUpdatedAt(p.getExpenseItemUpdatedAt());
    return dto;
   }
}
