package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionCategoryUpdateRequest {
public String transactionCategoryCreatedAt;
public String transactionCategoryDescription;
public int transactionCategoryId;
public String transactionCategoryName;
public String transactionCategoryStatus;
public String transactionCategoryTransactionNature;
public String transactionCategoryUpdatedAt;
}
