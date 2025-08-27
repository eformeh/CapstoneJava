package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LedgerUpdateRequest {
public int ledgerAccountId;
public Double ledgerBalanceAfter;
public String ledgerCreatedAt;
public Double ledgerCredit;
public Double ledgerDebit;
public int ledgerId;
public int ledgerjournalEntryLineAccountId;
public String ledgerStatus;
public String ledgerUpdatedAt;
}
