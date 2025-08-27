package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class JournalEntryLineReadRequest {
@NotEmpty(message = "Journalentrylineaccountid is required")
public int journalEntryLineAccountId;
@NotEmpty(message = "Journalentrylineamount is required")
public Double journalEntryLineAmount;
@NotEmpty(message = "Journalentrylinecreatedat is required")
public String journalEntryLineCreatedAt;
@NotEmpty(message = "Journalentrylineentrytype is required")
public String journalEntryLineEntryType;
@NotEmpty(message = "Journalentrylineid is required")
public int journalEntryLineId;
@NotEmpty(message = "Journalentrylinestatus is required")
public String journalEntryLineStatus;
@NotEmpty(message = "Journalentrylinetransactionid is required")
public int journalEntryLineTransactionId;
@NotEmpty(message = "Journalentrylineupdatedat is required")
public String journalEntryLineUpdatedAt;
}
