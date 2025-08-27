
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
public class SalaryPaymentRepositoryImpl implements SalaryPaymentRepository {

    private final Environment environment;

    @Autowired
    public SalaryPaymentRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(SalaryPayment  salarypayment) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int salaryPaymentId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SalaryPaymentQuery.INSERT, true)
                .bind (salarypayment)
                .executeUpdate()
                .getKey(int.class);


        return salaryPaymentId;
    }

    @Override
    public void bulkCreate(List<SalaryPayment> salarypayments) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SalaryPaymentQuery.INSERT, false);
            for (SalaryPayment salarypayment : salarypayments) {
                query.bind(salarypayment).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(SalaryPayment salarypayment) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.UPDATE, true)
                .bind (salarypayment)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int salaryPaymentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.DELETE, true)
                .addParameter("salaryPaymentId", salaryPaymentId)
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
                    .execute(SalaryPaymentQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SalaryPayment> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ, true)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentAmount(Double salaryPaymentAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTAMOUNT, true)
                .addParameter("salaryPaymentAmount", salaryPaymentAmount)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentApprovedBy(int salaryPaymentApprovedBy) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTAPPROVEDBY, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentApprovedBy)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentChannel(String salaryPaymentChannel) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTCHANNEL, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentChannel)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentCreatedAt(String salaryPaymentCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentCreatedAt)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentEmployeeAccountId(int salaryPaymentEmployeeAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTEMPLOYEEACCOUNTID, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentEmployeeAccountId)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public SalaryPayment readBySalaryPaymentId(int salaryPaymentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTID, true)
                .addParameter("salaryPaymentId", salaryPaymentId)
                .executeAndFetch (SalaryPayment.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentSalaryId(int salaryPaymentSalaryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTSALARYID, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentSalaryId)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentStatus(String salaryPaymentStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTSTATUS, true)
                .addParameter("salaryPaymentStatus", salaryPaymentStatus)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentTransactionId(int salaryPaymentTransactionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTTRANSACTIONID, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentTransactionId)
                .executeAndFetch(SalaryPayment.class);
    }
    @Override
    public List<SalaryPayment> readBySalaryPaymentUpdatedAt(String salaryPaymentUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryPaymentQuery.READ_BY_SALARY_PAYMENT_SALARYPAYMENTUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_SALARYPA"), salaryPaymentUpdatedAt)
                .executeAndFetch(SalaryPayment.class);
    }

@Override
public SalaryPaymentPage findSalaryPayment(SalaryPaymentFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SalaryPaymentQuery.READ);

    // Dynamic filters

    if (filter.getSalaryPaymentAmount() != null) {   baseSql.append(" AND salaryPaymentAmount = :salaryPaymentAmount"); }
    if (filter.getSalaryPaymentApprovedBy() != null) {   baseSql.append(" AND salaryPaymentApprovedBy = :salaryPaymentApprovedBy"); }
    if (filter.getSalaryPaymentChannel() != null) {   baseSql.append(" AND salaryPaymentChannel = :salaryPaymentChannel"); }
    if (filter.getSalaryPaymentCreatedAt() != null) {   baseSql.append(" AND salaryPaymentCreatedAt = :salaryPaymentCreatedAt"); }
    if (filter.getSalaryPaymentEmployeeAccountId() != null) {   baseSql.append(" AND salaryPaymentEmployeeAccountId = :salaryPaymentEmployeeAccountId"); }
    if (filter.getSalaryPaymentId() != null) {   baseSql.append(" AND salaryPaymentId = :salaryPaymentId"); }
    if (filter.getSalaryPaymentSalaryId() != null) {   baseSql.append(" AND salaryPaymentSalaryId = :salaryPaymentSalaryId"); }
    if (filter.getSalaryPaymentStatus() != null) {   baseSql.append(" AND salaryPaymentStatus = :salaryPaymentStatus"); }
    if (filter.getSalaryPaymentTransactionId() != null) {   baseSql.append(" AND salaryPaymentTransactionId = :salaryPaymentTransactionId"); }
    if (filter.getSalaryPaymentUpdatedAt() != null) {   baseSql.append(" AND salaryPaymentUpdatedAt = :salaryPaymentUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSalaryPaymentAmount() != null) countQuery.addParameter("salaryPaymentAmount", filter.getSalaryPaymentAmount());
     if (filter.getSalaryPaymentApprovedBy() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentApprovedBy());
     if (filter.getSalaryPaymentChannel() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentChannel());
     if (filter.getSalaryPaymentCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentCreatedAt());
     if (filter.getSalaryPaymentEmployeeAccountId() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentEmployeeAccountId());
     if (filter.getSalaryPaymentId() != null) countQuery.addParameter("salaryPaymentId", filter.getSalaryPaymentId());
     if (filter.getSalaryPaymentSalaryId() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentSalaryId());
     if (filter.getSalaryPaymentStatus() != null) countQuery.addParameter("salaryPaymentStatus", filter.getSalaryPaymentStatus());
     if (filter.getSalaryPaymentTransactionId() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentTransactionId());
     if (filter.getSalaryPaymentUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentUpdatedAt());
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

    if (filter.getSalaryPaymentAmount() != null) pageQuery.addParameter("salaryPaymentAmount", filter.getSalaryPaymentAmount());
    if (filter.getSalaryPaymentApprovedBy() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentApprovedBy());
    if (filter.getSalaryPaymentChannel() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentChannel());
    if (filter.getSalaryPaymentCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentCreatedAt());
    if (filter.getSalaryPaymentEmployeeAccountId() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentEmployeeAccountId());
    if (filter.getSalaryPaymentId() != null) pageQuery.addParameter("salaryPaymentId", filter.getSalaryPaymentId());
    if (filter.getSalaryPaymentSalaryId() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentSalaryId());
    if (filter.getSalaryPaymentStatus() != null) pageQuery.addParameter("salaryPaymentStatus", filter.getSalaryPaymentStatus());
    if (filter.getSalaryPaymentTransactionId() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentTransactionId());
    if (filter.getSalaryPaymentUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALARYPA"), filter.getSalaryPaymentUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<SalaryPayment> data = pageQuery.executeAndFetch(SalaryPayment.class);

     return new SalaryPaymentPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "salaryPaymentAmount",System.getenv("API_KEY_SALARYPA"),System.getenv("API_KEY_SALARYPA"),System.getenv("API_KEY_SALARYPA"),System.getenv("API_KEY_SALARYPA"),"salaryPaymentId",System.getenv("API_KEY_SALARYPA"),"salaryPaymentStatus",System.getenv("API_KEY_SALARYPA"),System.getenv("API_KEY_SALARYPA")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
