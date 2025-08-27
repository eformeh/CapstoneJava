package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LedgerFilterRequest {

private Integer ledgerAccountId;
private Double ledgerBalanceAfter;
private String ledgerCreatedAt;
private Double ledgerCredit;
private Double ledgerDebit;
private Integer ledgerId;
private Integer ledgerjournalEntryLineAccountId;
private String ledgerStatus;
private String ledgerUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
