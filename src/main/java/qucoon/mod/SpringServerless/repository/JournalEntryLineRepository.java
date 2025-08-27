
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.JournalEntryLinePage;
import qucoon.mod.SpringServerless.model.request.JournalEntryLineFilterRequest;

import java.util.List;

@Repository
    public interface JournalEntryLineRepository {


    // Additional query methods can be defined here.
    int create(JournalEntryLine journalentryline);
    void bulkCreate(List<JournalEntryLine>  journalentryline);
    int update(JournalEntryLine  journalentryline);
    int delete(int journalEntryLineId);
    JournalEntryLinePage findJournalEntryLine(JournalEntryLineFilterRequest filter);
    boolean truncate();
    List<JournalEntryLine> read();
    List<JournalEntryLine> readByJournalEntryLineAccountId(int journalEntryLineAccountId);
    List<JournalEntryLine> readByJournalEntryLineAmount(Double journalEntryLineAmount);
    List<JournalEntryLine> readByJournalEntryLineCreatedAt(String journalEntryLineCreatedAt);
    List<JournalEntryLine> readByJournalEntryLineEntryType(String journalEntryLineEntryType);
    JournalEntryLine readByJournalEntryLineId(int journalEntryLineId);
    List<JournalEntryLine> readByJournalEntryLineStatus(String journalEntryLineStatus);
    List<JournalEntryLine> readByJournalEntryLineTransactionId(int journalEntryLineTransactionId);
    List<JournalEntryLine> readByJournalEntryLineUpdatedAt(String journalEntryLineUpdatedAt);
}
