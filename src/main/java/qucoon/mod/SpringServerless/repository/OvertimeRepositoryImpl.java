
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
public class OvertimeRepositoryImpl implements OvertimeRepository {

    private final Environment environment;

    @Autowired
    public OvertimeRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Overtime  overtime) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int overtimeId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), OvertimeQuery.INSERT, true)
                .bind (overtime)
                .executeUpdate()
                .getKey(int.class);


        return overtimeId;
    }

    @Override
    public void bulkCreate(List<Overtime> overtimes) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,OvertimeQuery.INSERT, false);
            for (Overtime overtime : overtimes) {
                query.bind(overtime).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Overtime overtime) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.UPDATE, true)
                .bind (overtime)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int overtimeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.DELETE, true)
                .addParameter("overtimeId", overtimeId)
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
                    .execute(OvertimeQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Overtime> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ, true)
                .executeAndFetch(Overtime.class);
    }
    @Override
    public List<Overtime> readByOvertimeCreatedAt(String overtimeCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMECREATEDAT, true)
                .addParameter("overtimeCreatedAt", overtimeCreatedAt)
                .executeAndFetch(Overtime.class);
    }
    @Override
    public List<Overtime> readByOvertimeDate(String overtimeDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMEDATE, true)
                .addParameter("overtimeDate", overtimeDate)
                .executeAndFetch(Overtime.class);
    }
    @Override
    public List<Overtime> readByOvertimeEmployeeId(int overtimeEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMEEMPLOYEEID, true)
                .addParameter("overtimeEmployeeId", overtimeEmployeeId)
                .executeAndFetch(Overtime.class);
    }
    @Override
    public List<Overtime> readByOvertimeHours(Double overtimeHours) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMEHOURS, true)
                .addParameter("overtimeHours", overtimeHours)
                .executeAndFetch(Overtime.class);
    }
    @Override
    public Overtime readByOvertimeId(int overtimeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMEID, true)
                .addParameter("overtimeId", overtimeId)
                .executeAndFetch (Overtime.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Overtime> readByOvertimeStatus(String overtimeStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMESTATUS, true)
                .addParameter("overtimeStatus", overtimeStatus)
                .executeAndFetch(Overtime.class);
    }
    @Override
    public List<Overtime> readByOvertimeUpdatedAt(String overtimeUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OvertimeQuery.READ_BY_OVERTIME_OVERTIMEUPDATEDAT, true)
                .addParameter("overtimeUpdatedAt", overtimeUpdatedAt)
                .executeAndFetch(Overtime.class);
    }

@Override
public OvertimePage findOvertime(OvertimeFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(OvertimeQuery.READ);

    // Dynamic filters

    if (filter.getOvertimeCreatedAt() != null) {   baseSql.append(" AND overtimeCreatedAt = :overtimeCreatedAt"); }
    if (filter.getOvertimeDate() != null) {   baseSql.append(" AND overtimeDate = :overtimeDate"); }
    if (filter.getOvertimeEmployeeId() != null) {   baseSql.append(" AND overtimeEmployeeId = :overtimeEmployeeId"); }
    if (filter.getOvertimeHours() != null) {   baseSql.append(" AND overtimeHours = :overtimeHours"); }
    if (filter.getOvertimeId() != null) {   baseSql.append(" AND overtimeId = :overtimeId"); }
    if (filter.getOvertimeStatus() != null) {   baseSql.append(" AND overtimeStatus = :overtimeStatus"); }
    if (filter.getOvertimeUpdatedAt() != null) {   baseSql.append(" AND overtimeUpdatedAt = :overtimeUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getOvertimeCreatedAt() != null) countQuery.addParameter("overtimeCreatedAt", filter.getOvertimeCreatedAt());
     if (filter.getOvertimeDate() != null) countQuery.addParameter("overtimeDate", filter.getOvertimeDate());
     if (filter.getOvertimeEmployeeId() != null) countQuery.addParameter("overtimeEmployeeId", filter.getOvertimeEmployeeId());
     if (filter.getOvertimeHours() != null) countQuery.addParameter("overtimeHours", filter.getOvertimeHours());
     if (filter.getOvertimeId() != null) countQuery.addParameter("overtimeId", filter.getOvertimeId());
     if (filter.getOvertimeStatus() != null) countQuery.addParameter("overtimeStatus", filter.getOvertimeStatus());
     if (filter.getOvertimeUpdatedAt() != null) countQuery.addParameter("overtimeUpdatedAt", filter.getOvertimeUpdatedAt());
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

    if (filter.getOvertimeCreatedAt() != null) pageQuery.addParameter("overtimeCreatedAt", filter.getOvertimeCreatedAt());
    if (filter.getOvertimeDate() != null) pageQuery.addParameter("overtimeDate", filter.getOvertimeDate());
    if (filter.getOvertimeEmployeeId() != null) pageQuery.addParameter("overtimeEmployeeId", filter.getOvertimeEmployeeId());
    if (filter.getOvertimeHours() != null) pageQuery.addParameter("overtimeHours", filter.getOvertimeHours());
    if (filter.getOvertimeId() != null) pageQuery.addParameter("overtimeId", filter.getOvertimeId());
    if (filter.getOvertimeStatus() != null) pageQuery.addParameter("overtimeStatus", filter.getOvertimeStatus());
    if (filter.getOvertimeUpdatedAt() != null) pageQuery.addParameter("overtimeUpdatedAt", filter.getOvertimeUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Overtime> data = pageQuery.executeAndFetch(Overtime.class);

     return new OvertimePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "overtimeCreatedAt","overtimeDate","overtimeEmployeeId","overtimeHours","overtimeId","overtimeStatus","overtimeUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
