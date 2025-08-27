package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.JournalEntryLine;


@Data
public class JournalEntryLineDto  {

private Integer journalEntryLineAccountId;
private Double journalEntryLineAmount;
private String journalEntryLineCreatedAt;
private String journalEntryLineEntryType;
private Integer journalEntryLineId;
private String journalEntryLineStatus;
private Integer journalEntryLineTransactionId;
private String journalEntryLineUpdatedAt;

public static JournalEntryLineDto from(JournalEntryLine p) {
    JournalEntryLineDto dto = new JournalEntryLineDto();

    dto.setJournalEntryLineAccountId(p.getJournalEntryLineAccountId());
    dto.setJournalEntryLineAmount(p.getJournalEntryLineAmount());
    dto.setJournalEntryLineCreatedAt(p.getJournalEntryLineCreatedAt());
    dto.setJournalEntryLineEntryType(p.getJournalEntryLineEntryType());
    dto.setJournalEntryLineId(p.getJournalEntryLineId());
    dto.setJournalEntryLineStatus(p.getJournalEntryLineStatus());
    dto.setJournalEntryLineTransactionId(p.getJournalEntryLineTransactionId());
    dto.setJournalEntryLineUpdatedAt(p.getJournalEntryLineUpdatedAt());
    return dto;
   }
}
