package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class LedgerCreateRequest {
@NotNull(message = "ledgerAccountId is required")
public int ledgerAccountId;
public Double ledgerBalanceAfter;
public Double ledgerCredit;
public Double ledgerDebit;
@NotNull(message = "ledgerjournalEntryLineAccountId is required")
public int ledgerjournalEntryLineAccountId;
}
