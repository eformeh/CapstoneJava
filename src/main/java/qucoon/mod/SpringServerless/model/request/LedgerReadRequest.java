package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LedgerReadRequest {
@NotEmpty(message = "Ledgeraccountid is required")
public int ledgerAccountId;
@NotEmpty(message = "Ledgerbalanceafter is required")
public Double ledgerBalanceAfter;
@NotEmpty(message = "Ledgercreatedat is required")
public String ledgerCreatedAt;
@NotEmpty(message = "Ledgercredit is required")
public Double ledgerCredit;
@NotEmpty(message = "Ledgerdebit is required")
public Double ledgerDebit;
@NotEmpty(message = "Ledgerid is required")
public int ledgerId;
@NotEmpty(message = "Ledgerjournalentrylineaccountid is required")
public int ledgerjournalEntryLineAccountId;
@NotEmpty(message = "Ledgerstatus is required")
public String ledgerStatus;
@NotEmpty(message = "Ledgerupdatedat is required")
public String ledgerUpdatedAt;
}
