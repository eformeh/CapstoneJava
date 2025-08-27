
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.LedgerPage;
import qucoon.mod.SpringServerless.model.request.LedgerFilterRequest;

import java.util.List;

@Repository
    public interface LedgerRepository {


    // Additional query methods can be defined here.
    int create(Ledger ledger);
    void bulkCreate(List<Ledger>  ledger);
    int update(Ledger  ledger);
    int delete(int ledgerId);
    LedgerPage findLedger(LedgerFilterRequest filter);
    boolean truncate();
    List<Ledger> read();
    List<Ledger> readByLedgerAccountId(int ledgerAccountId);
    List<Ledger> readByLedgerBalanceAfter(Double ledgerBalanceAfter);
    List<Ledger> readByLedgerCreatedAt(String ledgerCreatedAt);
    List<Ledger> readByLedgerCredit(Double ledgerCredit);
    List<Ledger> readByLedgerDebit(Double ledgerDebit);
    Ledger readByLedgerId(int ledgerId);
    List<Ledger> readByLedgerjournalEntryLineAccountId(int ledgerjournalEntryLineAccountId);
    List<Ledger> readByLedgerStatus(String ledgerStatus);
    List<Ledger> readByLedgerUpdatedAt(String ledgerUpdatedAt);
}
