package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Transaction;


@Data
public class TransactionDto  {

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

public static TransactionDto from(Transaction p) {
    TransactionDto dto = new TransactionDto();

    dto.setTransactionAmount(p.getTransactionAmount());
    dto.setTransactionCreatedAt(p.getTransactionCreatedAt());
    dto.setTransactionDescription(p.getTransactionDescription());
    dto.setTransactionId(p.getTransactionId());
    dto.setTransactionNarration(p.getTransactionNarration());
    dto.setTransactionReferenceNumber(p.getTransactionReferenceNumber());
    dto.setTransactionSourceModule(p.getTransactionSourceModule());
    dto.setTransactionSourceReferenceId(p.getTransactionSourceReferenceId());
    dto.setTransactionStatus(p.getTransactionStatus());
    dto.setTransactionTransactionCategoryId(p.getTransactionTransactionCategoryId());
    dto.setTransactionTransactionDate(p.getTransactionTransactionDate());
    dto.setTransactionUpdatedAt(p.getTransactionUpdatedAt());
    return dto;
   }
}
