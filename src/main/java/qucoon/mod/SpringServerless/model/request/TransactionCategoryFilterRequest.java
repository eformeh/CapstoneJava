package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionCategoryFilterRequest {

private String transactionCategoryCreatedAt;
private String transactionCategoryDescription;
private Integer transactionCategoryId;
private String transactionCategoryName;
private String transactionCategoryStatus;
private String transactionCategoryTransactionNature;
private String transactionCategoryUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
