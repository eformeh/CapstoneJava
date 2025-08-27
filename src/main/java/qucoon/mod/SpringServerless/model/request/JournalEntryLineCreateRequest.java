package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class JournalEntryLineCreateRequest {
@NotNull(message = "journalEntryLineAccountId is required")
public int journalEntryLineAccountId;
public Double journalEntryLineAmount;
public String journalEntryLineEntryType;
@NotNull(message = "journalEntryLineTransactionId is required")
public int journalEntryLineTransactionId;
}
