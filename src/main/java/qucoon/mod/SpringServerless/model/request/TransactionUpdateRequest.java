package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionUpdateRequest {
public Double transactionAmount;
public String transactionCreatedAt;
public String transactionDescription;
public int transactionId;
public String transactionNarration;
public String transactionReferenceNumber;
public String transactionSourceModule;
public int transactionSourceReferenceId;
public String transactionStatus;
public int transactionTransactionCategoryId;
public String transactionTransactionDate;
public String transactionUpdatedAt;
}
