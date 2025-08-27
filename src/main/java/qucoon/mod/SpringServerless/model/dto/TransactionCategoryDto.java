package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.TransactionCategory;


@Data
public class TransactionCategoryDto  {

private String transactionCategoryCreatedAt;
private String transactionCategoryDescription;
private Integer transactionCategoryId;
private String transactionCategoryName;
private String transactionCategoryStatus;
private String transactionCategoryTransactionNature;
private String transactionCategoryUpdatedAt;

public static TransactionCategoryDto from(TransactionCategory p) {
    TransactionCategoryDto dto = new TransactionCategoryDto();

    dto.setTransactionCategoryCreatedAt(p.getTransactionCategoryCreatedAt());
    dto.setTransactionCategoryDescription(p.getTransactionCategoryDescription());
    dto.setTransactionCategoryId(p.getTransactionCategoryId());
    dto.setTransactionCategoryName(p.getTransactionCategoryName());
    dto.setTransactionCategoryStatus(p.getTransactionCategoryStatus());
    dto.setTransactionCategoryTransactionNature(p.getTransactionCategoryTransactionNature());
    dto.setTransactionCategoryUpdatedAt(p.getTransactionCategoryUpdatedAt());
    return dto;
   }
}
