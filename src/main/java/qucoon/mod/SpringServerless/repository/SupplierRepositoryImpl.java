
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
public class SupplierRepositoryImpl implements SupplierRepository {

    private final Environment environment;

    @Autowired
    public SupplierRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Supplier  supplier) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int supplierId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SupplierQuery.INSERT, true)
                .bind (supplier)
                .executeUpdate()
                .getKey(int.class);


        return supplierId;
    }

    @Override
    public void bulkCreate(List<Supplier> suppliers) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SupplierQuery.INSERT, false);
            for (Supplier supplier : suppliers) {
                query.bind(supplier).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Supplier supplier) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.UPDATE, true)
                .bind (supplier)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int supplierId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.DELETE, true)
                .addParameter("supplierId", supplierId)
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
                    .execute(SupplierQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Supplier> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ, true)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierAddress(String supplierAddress) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERADDRESS, true)
                .addParameter("supplierAddress", supplierAddress)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierContactPerson(String supplierContactPerson) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERCONTACTPERSON, true)
                .addParameter(System.getenv("API_KEY_SUPPLIER"), supplierContactPerson)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierCreatedAt(String supplierCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERCREATEDAT, true)
                .addParameter("supplierCreatedAt", supplierCreatedAt)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierCreatedByUserId(int supplierCreatedByUserId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERCREATEDBYUSERID, true)
                .addParameter(System.getenv("API_KEY_SUPPLIER"), supplierCreatedByUserId)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierEmail(String supplierEmail) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIEREMAIL, true)
                .addParameter("supplierEmail", supplierEmail)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public Supplier readBySupplierId(int supplierId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERID, true)
                .addParameter("supplierId", supplierId)
                .executeAndFetch (Supplier.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Supplier> readBySupplierName(String supplierName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERNAME, true)
                .addParameter("supplierName", supplierName)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierPhoneNumber(String supplierPhoneNumber) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERPHONENUMBER, true)
                .addParameter("supplierPhoneNumber", supplierPhoneNumber)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierStatus(String supplierStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERSTATUS, true)
                .addParameter("supplierStatus", supplierStatus)
                .executeAndFetch(Supplier.class);
    }
    @Override
    public List<Supplier> readBySupplierUpdatedAt(String supplierUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SupplierQuery.READ_BY_SUPPLIER_SUPPLIERUPDATEDAT, true)
                .addParameter("supplierUpdatedAt", supplierUpdatedAt)
                .executeAndFetch(Supplier.class);
    }

@Override
public SupplierPage findSupplier(SupplierFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SupplierQuery.READ);

    // Dynamic filters

    if (filter.getSupplierAddress() != null) {   baseSql.append(" AND supplierAddress = :supplierAddress"); }
    if (filter.getSupplierContactPerson() != null) {   baseSql.append(" AND supplierContactPerson = :supplierContactPerson"); }
    if (filter.getSupplierCreatedAt() != null) {   baseSql.append(" AND supplierCreatedAt = :supplierCreatedAt"); }
    if (filter.getSupplierCreatedByUserId() != null) {   baseSql.append(" AND supplierCreatedByUserId = :supplierCreatedByUserId"); }
    if (filter.getSupplierEmail() != null) {   baseSql.append(" AND supplierEmail = :supplierEmail"); }
    if (filter.getSupplierId() != null) {   baseSql.append(" AND supplierId = :supplierId"); }
    if (filter.getSupplierName() != null) {   baseSql.append(" AND supplierName = :supplierName"); }
    if (filter.getSupplierPhoneNumber() != null) {   baseSql.append(" AND supplierPhoneNumber = :supplierPhoneNumber"); }
    if (filter.getSupplierStatus() != null) {   baseSql.append(" AND supplierStatus = :supplierStatus"); }
    if (filter.getSupplierUpdatedAt() != null) {   baseSql.append(" AND supplierUpdatedAt = :supplierUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSupplierAddress() != null) countQuery.addParameter("supplierAddress", filter.getSupplierAddress());
     if (filter.getSupplierContactPerson() != null) countQuery.addParameter(System.getenv("API_KEY_SUPPLIER"), filter.getSupplierContactPerson());
     if (filter.getSupplierCreatedAt() != null) countQuery.addParameter("supplierCreatedAt", filter.getSupplierCreatedAt());
     if (filter.getSupplierCreatedByUserId() != null) countQuery.addParameter(System.getenv("API_KEY_SUPPLIER"), filter.getSupplierCreatedByUserId());
     if (filter.getSupplierEmail() != null) countQuery.addParameter("supplierEmail", filter.getSupplierEmail());
     if (filter.getSupplierId() != null) countQuery.addParameter("supplierId", filter.getSupplierId());
     if (filter.getSupplierName() != null) countQuery.addParameter("supplierName", filter.getSupplierName());
     if (filter.getSupplierPhoneNumber() != null) countQuery.addParameter("supplierPhoneNumber", filter.getSupplierPhoneNumber());
     if (filter.getSupplierStatus() != null) countQuery.addParameter("supplierStatus", filter.getSupplierStatus());
     if (filter.getSupplierUpdatedAt() != null) countQuery.addParameter("supplierUpdatedAt", filter.getSupplierUpdatedAt());
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

    if (filter.getSupplierAddress() != null) pageQuery.addParameter("supplierAddress", filter.getSupplierAddress());
    if (filter.getSupplierContactPerson() != null) pageQuery.addParameter(System.getenv("API_KEY_SUPPLIER"), filter.getSupplierContactPerson());
    if (filter.getSupplierCreatedAt() != null) pageQuery.addParameter("supplierCreatedAt", filter.getSupplierCreatedAt());
    if (filter.getSupplierCreatedByUserId() != null) pageQuery.addParameter(System.getenv("API_KEY_SUPPLIER"), filter.getSupplierCreatedByUserId());
    if (filter.getSupplierEmail() != null) pageQuery.addParameter("supplierEmail", filter.getSupplierEmail());
    if (filter.getSupplierId() != null) pageQuery.addParameter("supplierId", filter.getSupplierId());
    if (filter.getSupplierName() != null) pageQuery.addParameter("supplierName", filter.getSupplierName());
    if (filter.getSupplierPhoneNumber() != null) pageQuery.addParameter("supplierPhoneNumber", filter.getSupplierPhoneNumber());
    if (filter.getSupplierStatus() != null) pageQuery.addParameter("supplierStatus", filter.getSupplierStatus());
    if (filter.getSupplierUpdatedAt() != null) pageQuery.addParameter("supplierUpdatedAt", filter.getSupplierUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Supplier> data = pageQuery.executeAndFetch(Supplier.class);

     return new SupplierPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "supplierAddress",System.getenv("API_KEY_SUPPLIER"),"supplierCreatedAt",System.getenv("API_KEY_SUPPLIER"),"supplierEmail","supplierId","supplierName","supplierPhoneNumber","supplierStatus","supplierUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
