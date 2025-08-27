package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionFilterRequest {

private Double transactionAmount;
private String transactionCreatedAt;
private String transactionDescription;
private Integer transactionId;
private String transactionNarration;
private String transactionReferenceNumber;
private String transactionSourceModule;
private Integer transactionSourceReferenceId;
private String transactionStatus;
private Integer transactionTransactionCategoryId;
private String transactionTransactionDate;
private String transactionUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
