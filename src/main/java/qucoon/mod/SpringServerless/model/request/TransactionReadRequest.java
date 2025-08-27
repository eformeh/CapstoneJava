package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionReadRequest {
@NotEmpty(message = "Transactionamount is required")
public Double transactionAmount;
@NotEmpty(message = "Transactioncreatedat is required")
public String transactionCreatedAt;
@NotEmpty(message = "Transactiondescription is required")
public String transactionDescription;
@NotEmpty(message = "Transactionid is required")
public int transactionId;
@NotEmpty(message = "Transactionnarration is required")
public String transactionNarration;
@NotEmpty(message = "Transactionreferencenumber is required")
public String transactionReferenceNumber;
@NotEmpty(message = "Transactionsourcemodule is required")
public String transactionSourceModule;
@NotEmpty(message = "Transactionsourcereferenceid is required")
public int transactionSourceReferenceId;
@NotEmpty(message = "Transactionstatus is required")
public String transactionStatus;
@NotEmpty(message = "Transactiontransactioncategoryid is required")
public int transactionTransactionCategoryId;
@NotEmpty(message = "Transactiontransactiondate is required")
public String transactionTransactionDate;
@NotEmpty(message = "Transactionupdatedat is required")
public String transactionUpdatedAt;
}
