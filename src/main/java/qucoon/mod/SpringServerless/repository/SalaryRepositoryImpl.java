
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
public class SalaryRepositoryImpl implements SalaryRepository {

    private final Environment environment;

    @Autowired
    public SalaryRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Salary  salary) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int salaryId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SalaryQuery.INSERT, true)
                .bind (salary)
                .executeUpdate()
                .getKey(int.class);


        return salaryId;
    }

    @Override
    public void bulkCreate(List<Salary> salarys) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SalaryQuery.INSERT, false);
            for (Salary salary : salarys) {
                query.bind(salary).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Salary salary) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.UPDATE, true)
                .bind (salary)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int salaryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.DELETE, true)
                .addParameter("salaryId", salaryId)
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
                    .execute(SalaryQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Salary> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ, true)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryBasicAmount(Double salaryBasicAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYBASICAMOUNT, true)
                .addParameter("salaryBasicAmount", salaryBasicAmount)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryCreatedAt(String salaryCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYCREATEDAT, true)
                .addParameter("salaryCreatedAt", salaryCreatedAt)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryEmployeeId(int salaryEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYEMPLOYEEID, true)
                .addParameter("salaryEmployeeId", salaryEmployeeId)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryGrossPay(Double salaryGrossPay) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYGROSSPAY, true)
                .addParameter("salaryGrossPay", salaryGrossPay)
                .executeAndFetch(Salary.class);
    }
    @Override
    public Salary readBySalaryId(int salaryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYID, true)
                .addParameter("salaryId", salaryId)
                .executeAndFetch (Salary.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Salary> readBySalaryNetPay(Double salaryNetPay) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYNETPAY, true)
                .addParameter("salaryNetPay", salaryNetPay)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryPayPeriodId(int salaryPayPeriodId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYPAYPERIODID, true)
                .addParameter("salaryPayPeriodId", salaryPayPeriodId)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryStatus(String salaryStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYSTATUS, true)
                .addParameter("salaryStatus", salaryStatus)
                .executeAndFetch(Salary.class);
    }
    @Override
    public List<Salary> readBySalaryUpdatedAt(String salaryUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalaryQuery.READ_BY_SALARY_SALARYUPDATEDAT, true)
                .addParameter("salaryUpdatedAt", salaryUpdatedAt)
                .executeAndFetch(Salary.class);
    }

@Override
public SalaryPage findSalary(SalaryFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SalaryQuery.READ);

    // Dynamic filters

    if (filter.getSalaryBasicAmount() != null) {   baseSql.append(" AND salaryBasicAmount = :salaryBasicAmount"); }
    if (filter.getSalaryCreatedAt() != null) {   baseSql.append(" AND salaryCreatedAt = :salaryCreatedAt"); }
    if (filter.getSalaryEmployeeId() != null) {   baseSql.append(" AND salaryEmployeeId = :salaryEmployeeId"); }
    if (filter.getSalaryGrossPay() != null) {   baseSql.append(" AND salaryGrossPay = :salaryGrossPay"); }
    if (filter.getSalaryId() != null) {   baseSql.append(" AND salaryId = :salaryId"); }
    if (filter.getSalaryNetPay() != null) {   baseSql.append(" AND salaryNetPay = :salaryNetPay"); }
    if (filter.getSalaryPayPeriodId() != null) {   baseSql.append(" AND salaryPayPeriodId = :salaryPayPeriodId"); }
    if (filter.getSalaryStatus() != null) {   baseSql.append(" AND salaryStatus = :salaryStatus"); }
    if (filter.getSalaryUpdatedAt() != null) {   baseSql.append(" AND salaryUpdatedAt = :salaryUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSalaryBasicAmount() != null) countQuery.addParameter("salaryBasicAmount", filter.getSalaryBasicAmount());
     if (filter.getSalaryCreatedAt() != null) countQuery.addParameter("salaryCreatedAt", filter.getSalaryCreatedAt());
     if (filter.getSalaryEmployeeId() != null) countQuery.addParameter("salaryEmployeeId", filter.getSalaryEmployeeId());
     if (filter.getSalaryGrossPay() != null) countQuery.addParameter("salaryGrossPay", filter.getSalaryGrossPay());
     if (filter.getSalaryId() != null) countQuery.addParameter("salaryId", filter.getSalaryId());
     if (filter.getSalaryNetPay() != null) countQuery.addParameter("salaryNetPay", filter.getSalaryNetPay());
     if (filter.getSalaryPayPeriodId() != null) countQuery.addParameter("salaryPayPeriodId", filter.getSalaryPayPeriodId());
     if (filter.getSalaryStatus() != null) countQuery.addParameter("salaryStatus", filter.getSalaryStatus());
     if (filter.getSalaryUpdatedAt() != null) countQuery.addParameter("salaryUpdatedAt", filter.getSalaryUpdatedAt());
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

    if (filter.getSalaryBasicAmount() != null) pageQuery.addParameter("salaryBasicAmount", filter.getSalaryBasicAmount());
    if (filter.getSalaryCreatedAt() != null) pageQuery.addParameter("salaryCreatedAt", filter.getSalaryCreatedAt());
    if (filter.getSalaryEmployeeId() != null) pageQuery.addParameter("salaryEmployeeId", filter.getSalaryEmployeeId());
    if (filter.getSalaryGrossPay() != null) pageQuery.addParameter("salaryGrossPay", filter.getSalaryGrossPay());
    if (filter.getSalaryId() != null) pageQuery.addParameter("salaryId", filter.getSalaryId());
    if (filter.getSalaryNetPay() != null) pageQuery.addParameter("salaryNetPay", filter.getSalaryNetPay());
    if (filter.getSalaryPayPeriodId() != null) pageQuery.addParameter("salaryPayPeriodId", filter.getSalaryPayPeriodId());
    if (filter.getSalaryStatus() != null) pageQuery.addParameter("salaryStatus", filter.getSalaryStatus());
    if (filter.getSalaryUpdatedAt() != null) pageQuery.addParameter("salaryUpdatedAt", filter.getSalaryUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Salary> data = pageQuery.executeAndFetch(Salary.class);

     return new SalaryPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "salaryBasicAmount","salaryCreatedAt","salaryEmployeeId","salaryGrossPay","salaryId","salaryNetPay","salaryPayPeriodId","salaryStatus","salaryUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
