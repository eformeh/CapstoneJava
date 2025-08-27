
package   qucoon.mod.SpringServerless.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.repository.query.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.repository.page.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;

import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;


@Repository
public class LedgerRepositoryImpl implements LedgerRepository {

    private final Environment environment;

    @Autowired
    public LedgerRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Ledger  ledger) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int ledgerId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), LedgerQuery.INSERT, true)
                .bind (ledger)
                .executeUpdate()
                .getKey(int.class);


        return ledgerId;
    }

    @Override
    public void bulkCreate(List<Ledger> ledgers) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,LedgerQuery.INSERT, false);
            for (Ledger ledger : ledgers) {
                query.bind(ledger).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Ledger ledger) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.UPDATE, true)
                .bind (ledger)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int ledgerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.DELETE, true)
                .addParameter("ledgerId", ledgerId)
                .executeUpdate()
                .getResult();
    }

    @Override
    public boolean truncate() {
        try {
            assert environment.getDatabaseUtil().getSql2oConnection() != null;
            return environment.getDatabaseUtil().getSql2oConnection()
                    .getJdbcConnection()
                    .createStatement()
                    .execute(LedgerQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Ledger> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ, true)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerAccountId(int ledgerAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERACCOUNTID, true)
                .addParameter("ledgerAccountId", ledgerAccountId)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerBalanceAfter(Double ledgerBalanceAfter) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERBALANCEAFTER, true)
                .addParameter("ledgerBalanceAfter", ledgerBalanceAfter)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerCreatedAt(String ledgerCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERCREATEDAT, true)
                .addParameter("ledgerCreatedAt", ledgerCreatedAt)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerCredit(Double ledgerCredit) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERCREDIT, true)
                .addParameter("ledgerCredit", ledgerCredit)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerDebit(Double ledgerDebit) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERDEBIT, true)
                .addParameter("ledgerDebit", ledgerDebit)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public Ledger readByLedgerId(int ledgerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERID, true)
                .addParameter("ledgerId", ledgerId)
                .executeAndFetch (Ledger.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Ledger> readByLedgerjournalEntryLineAccountId(int ledgerjournalEntryLineAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERJOURNALENTRYLINEACCOUNTID, true)
                .addParameter(System.getenv("API_KEY_LEDGERJO"), ledgerjournalEntryLineAccountId)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerStatus(String ledgerStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERSTATUS, true)
                .addParameter("ledgerStatus", ledgerStatus)
                .executeAndFetch(Ledger.class);
    }
    @Override
    public List<Ledger> readByLedgerUpdatedAt(String ledgerUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LedgerQuery.READ_BY_LEDGER_LEDGERUPDATEDAT, true)
                .addParameter("ledgerUpdatedAt", ledgerUpdatedAt)
                .executeAndFetch(Ledger.class);
    }

@Override
public LedgerPage findLedger(LedgerFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(LedgerQuery.READ);

    // Dynamic filters

    if (filter.getLedgerAccountId() != null) {   baseSql.append(" AND ledgerAccountId = :ledgerAccountId"); }
    if (filter.getLedgerBalanceAfter() != null) {   baseSql.append(" AND ledgerBalanceAfter = :ledgerBalanceAfter"); }
    if (filter.getLedgerCreatedAt() != null) {   baseSql.append(" AND ledgerCreatedAt = :ledgerCreatedAt"); }
    if (filter.getLedgerCredit() != null) {   baseSql.append(" AND ledgerCredit = :ledgerCredit"); }
    if (filter.getLedgerDebit() != null) {   baseSql.append(" AND ledgerDebit = :ledgerDebit"); }
    if (filter.getLedgerId() != null) {   baseSql.append(" AND ledgerId = :ledgerId"); }
    if (filter.getLedgerjournalEntryLineAccountId() != null) {   baseSql.append(" AND ledgerjournalEntryLineAccountId = :ledgerjournalEntryLineAccountId"); }
    if (filter.getLedgerStatus() != null) {   baseSql.append(" AND ledgerStatus = :ledgerStatus"); }
    if (filter.getLedgerUpdatedAt() != null) {   baseSql.append(" AND ledgerUpdatedAt = :ledgerUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getLedgerAccountId() != null) countQuery.addParameter("ledgerAccountId", filter.getLedgerAccountId());
     if (filter.getLedgerBalanceAfter() != null) countQuery.addParameter("ledgerBalanceAfter", filter.getLedgerBalanceAfter());
     if (filter.getLedgerCreatedAt() != null) countQuery.addParameter("ledgerCreatedAt", filter.getLedgerCreatedAt());
     if (filter.getLedgerCredit() != null) countQuery.addParameter("ledgerCredit", filter.getLedgerCredit());
     if (filter.getLedgerDebit() != null) countQuery.addParameter("ledgerDebit", filter.getLedgerDebit());
     if (filter.getLedgerId() != null) countQuery.addParameter("ledgerId", filter.getLedgerId());
     if (filter.getLedgerjournalEntryLineAccountId() != null) countQuery.addParameter(System.getenv("API_KEY_LEDGERJO"), filter.getLedgerjournalEntryLineAccountId());
     if (filter.getLedgerStatus() != null) countQuery.addParameter("ledgerStatus", filter.getLedgerStatus());
     if (filter.getLedgerUpdatedAt() != null) countQuery.addParameter("ledgerUpdatedAt", filter.getLedgerUpdatedAt());
     if (filter.getSearch() != null) countQuery.addParameter("search", "%" + filter.getSearch() + "%");
     Long total = countQuery.executeScalar(Long.class);

   // MSSQL pagination requires ORDER BY for OFFSET/FETCH
    String validSortDir = filter.getSortDir().equalsIgnoreCase("ASC") ? "ASC" : "DESC";
    String orderBy = " ORDER BY " + sanitizeSortBy(filter.getSortBy()) + " " + validSortDir;
     // Append order and pagination
     StringBuilder pageSql_old = new StringBuilder(baseSql)
             .append(" ORDER BY ").append (filter.getSortBy())
             .append(" ").append (filter.getSortDir())
             .append("  OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
    // Build pagination SQL
    String pageSql = baseSql.toString() + orderBy +
" OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY";

     // Fetch page data
     var pageQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             pageSql.toString(),
             true);

    if (filter.getLedgerAccountId() != null) pageQuery.addParameter("ledgerAccountId", filter.getLedgerAccountId());
    if (filter.getLedgerBalanceAfter() != null) pageQuery.addParameter("ledgerBalanceAfter", filter.getLedgerBalanceAfter());
    if (filter.getLedgerCreatedAt() != null) pageQuery.addParameter("ledgerCreatedAt", filter.getLedgerCreatedAt());
    if (filter.getLedgerCredit() != null) pageQuery.addParameter("ledgerCredit", filter.getLedgerCredit());
    if (filter.getLedgerDebit() != null) pageQuery.addParameter("ledgerDebit", filter.getLedgerDebit());
    if (filter.getLedgerId() != null) pageQuery.addParameter("ledgerId", filter.getLedgerId());
    if (filter.getLedgerjournalEntryLineAccountId() != null) pageQuery.addParameter(System.getenv("API_KEY_LEDGERJO"), filter.getLedgerjournalEntryLineAccountId());
    if (filter.getLedgerStatus() != null) pageQuery.addParameter("ledgerStatus", filter.getLedgerStatus());
    if (filter.getLedgerUpdatedAt() != null) pageQuery.addParameter("ledgerUpdatedAt", filter.getLedgerUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Ledger> data = pageQuery.executeAndFetch(Ledger.class);

     return new LedgerPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "ledgerAccountId","ledgerBalanceAfter","ledgerCreatedAt","ledgerCredit","ledgerDebit","ledgerId",System.getenv("API_KEY_LEDGERJO"),"ledgerStatus","ledgerUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
