package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class TransactionCreateRequest {
public Double transactionAmount;
public String transactionDescription;
public String transactionNarration;
public String transactionReferenceNumber;
public String transactionSourceModule;
@NotNull(message = "transactionSourceReferenceId is required")
public int transactionSourceReferenceId;
@NotNull(message = "transactionTransactionCategoryId is required")
public int transactionTransactionCategoryId;
public String transactionTransactionDate;
}
