
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
public class DeductionRepositoryImpl implements DeductionRepository {

    private final Environment environment;

    @Autowired
    public DeductionRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Deduction  deduction) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int deductionId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), DeductionQuery.INSERT, true)
                .bind (deduction)
                .executeUpdate()
                .getKey(int.class);


        return deductionId;
    }

    @Override
    public void bulkCreate(List<Deduction> deductions) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,DeductionQuery.INSERT, false);
            for (Deduction deduction : deductions) {
                query.bind(deduction).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Deduction deduction) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.UPDATE, true)
                .bind (deduction)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int deductionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.DELETE, true)
                .addParameter("deductionId", deductionId)
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
                    .execute(DeductionQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Deduction> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ, true)
                .executeAndFetch(Deduction.class);
    }
    @Override
    public List<Deduction> readByDeductionAmount(Double deductionAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONAMOUNT, true)
                .addParameter("deductionAmount", deductionAmount)
                .executeAndFetch(Deduction.class);
    }
    @Override
    public List<Deduction> readByDeductionCreatedAt(String deductionCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONCREATEDAT, true)
                .addParameter("deductionCreatedAt", deductionCreatedAt)
                .executeAndFetch(Deduction.class);
    }
    @Override
    public Deduction readByDeductionId(int deductionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONID, true)
                .addParameter("deductionId", deductionId)
                .executeAndFetch (Deduction.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Deduction> readByDeductionSalaryId(int deductionSalaryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONSALARYID, true)
                .addParameter("deductionSalaryId", deductionSalaryId)
                .executeAndFetch(Deduction.class);
    }
    @Override
    public List<Deduction> readByDeductionStatus(String deductionStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONSTATUS, true)
                .addParameter("deductionStatus", deductionStatus)
                .executeAndFetch(Deduction.class);
    }
    @Override
    public List<Deduction> readByDeductionType(String deductionType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONTYPE, true)
                .addParameter("deductionType", deductionType)
                .executeAndFetch(Deduction.class);
    }
    @Override
    public List<Deduction> readByDeductionUpdatedAt(String deductionUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DeductionQuery.READ_BY_DEDUCTION_DEDUCTIONUPDATEDAT, true)
                .addParameter("deductionUpdatedAt", deductionUpdatedAt)
                .executeAndFetch(Deduction.class);
    }

@Override
public DeductionPage findDeduction(DeductionFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(DeductionQuery.READ);

    // Dynamic filters

    if (filter.getDeductionAmount() != null) {   baseSql.append(" AND deductionAmount = :deductionAmount"); }
    if (filter.getDeductionCreatedAt() != null) {   baseSql.append(" AND deductionCreatedAt = :deductionCreatedAt"); }
    if (filter.getDeductionId() != null) {   baseSql.append(" AND deductionId = :deductionId"); }
    if (filter.getDeductionSalaryId() != null) {   baseSql.append(" AND deductionSalaryId = :deductionSalaryId"); }
    if (filter.getDeductionStatus() != null) {   baseSql.append(" AND deductionStatus = :deductionStatus"); }
    if (filter.getDeductionType() != null) {   baseSql.append(" AND deductionType = :deductionType"); }
    if (filter.getDeductionUpdatedAt() != null) {   baseSql.append(" AND deductionUpdatedAt = :deductionUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getDeductionAmount() != null) countQuery.addParameter("deductionAmount", filter.getDeductionAmount());
     if (filter.getDeductionCreatedAt() != null) countQuery.addParameter("deductionCreatedAt", filter.getDeductionCreatedAt());
     if (filter.getDeductionId() != null) countQuery.addParameter("deductionId", filter.getDeductionId());
     if (filter.getDeductionSalaryId() != null) countQuery.addParameter("deductionSalaryId", filter.getDeductionSalaryId());
     if (filter.getDeductionStatus() != null) countQuery.addParameter("deductionStatus", filter.getDeductionStatus());
     if (filter.getDeductionType() != null) countQuery.addParameter("deductionType", filter.getDeductionType());
     if (filter.getDeductionUpdatedAt() != null) countQuery.addParameter("deductionUpdatedAt", filter.getDeductionUpdatedAt());
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

    if (filter.getDeductionAmount() != null) pageQuery.addParameter("deductionAmount", filter.getDeductionAmount());
    if (filter.getDeductionCreatedAt() != null) pageQuery.addParameter("deductionCreatedAt", filter.getDeductionCreatedAt());
    if (filter.getDeductionId() != null) pageQuery.addParameter("deductionId", filter.getDeductionId());
    if (filter.getDeductionSalaryId() != null) pageQuery.addParameter("deductionSalaryId", filter.getDeductionSalaryId());
    if (filter.getDeductionStatus() != null) pageQuery.addParameter("deductionStatus", filter.getDeductionStatus());
    if (filter.getDeductionType() != null) pageQuery.addParameter("deductionType", filter.getDeductionType());
    if (filter.getDeductionUpdatedAt() != null) pageQuery.addParameter("deductionUpdatedAt", filter.getDeductionUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Deduction> data = pageQuery.executeAndFetch(Deduction.class);

     return new DeductionPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "deductionAmount","deductionCreatedAt","deductionId","deductionSalaryId","deductionStatus","deductionType","deductionUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
