package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class JournalEntryLineUpdateRequest {
public int journalEntryLineAccountId;
public Double journalEntryLineAmount;
public String journalEntryLineCreatedAt;
public String journalEntryLineEntryType;
public int journalEntryLineId;
public String journalEntryLineStatus;
public int journalEntryLineTransactionId;
public String journalEntryLineUpdatedAt;
}
