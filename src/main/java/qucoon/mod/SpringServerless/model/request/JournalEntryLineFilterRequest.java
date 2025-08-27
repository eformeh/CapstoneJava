package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JournalEntryLineFilterRequest {

private Integer journalEntryLineAccountId;
private Double journalEntryLineAmount;
private String journalEntryLineCreatedAt;
private String journalEntryLineEntryType;
private Integer journalEntryLineId;
private String journalEntryLineStatus;
private Integer journalEntryLineTransactionId;
private String journalEntryLineUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
