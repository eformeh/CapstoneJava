package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionCategoryReadRequest {
@NotEmpty(message = "Transactioncategorycreatedat is required")
public String transactionCategoryCreatedAt;
@NotEmpty(message = "Transactioncategorydescription is required")
public String transactionCategoryDescription;
@NotEmpty(message = "Transactioncategoryid is required")
public int transactionCategoryId;
@NotEmpty(message = "Transactioncategoryname is required")
public String transactionCategoryName;
@NotEmpty(message = "Transactioncategorystatus is required")
public String transactionCategoryStatus;
@NotEmpty(message = "Transactioncategorytransactionnature is required")
public String transactionCategoryTransactionNature;
@NotEmpty(message = "Transactioncategoryupdatedat is required")
public String transactionCategoryUpdatedAt;
}
