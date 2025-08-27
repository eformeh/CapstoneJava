
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
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Environment environment;

    @Autowired
    public CustomerRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Customer  customer) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int customerId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), CustomerQuery.INSERT, true)
                .bind (customer)
                .executeUpdate()
                .getKey(int.class);


        return customerId;
    }

    @Override
    public void bulkCreate(List<Customer> customers) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,CustomerQuery.INSERT, false);
            for (Customer customer : customers) {
                query.bind(customer).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Customer customer) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.UPDATE, true)
                .bind (customer)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int customerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.DELETE, true)
                .addParameter("customerId", customerId)
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
                    .execute(CustomerQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ, true)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerAddress(String customerAddress) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERADDRESS, true)
                .addParameter("customerAddress", customerAddress)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerCompanyName(String customerCompanyName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERCOMPANYNAME, true)
                .addParameter("customerCompanyName", customerCompanyName)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerCreatedAt(String customerCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERCREATEDAT, true)
                .addParameter("customerCreatedAt", customerCreatedAt)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerCreditBalance(Double customerCreditBalance) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERCREDITBALANCE, true)
                .addParameter(System.getenv("API_KEY_CUSTOMER"), customerCreditBalance)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerEmail(String customerEmail) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMEREMAIL, true)
                .addParameter("customerEmail", customerEmail)
                .executeAndFetch(Customer.class);
    }
    @Override
    public Customer readByCustomerId(int customerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERID, true)
                .addParameter("customerId", customerId)
                .executeAndFetch (Customer.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Customer> readByCustomerName(String customerName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERNAME, true)
                .addParameter("customerName", customerName)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerNotes(String customerNotes) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERNOTES, true)
                .addParameter("customerNotes", customerNotes)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerPhone(String customerPhone) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERPHONE, true)
                .addParameter("customerPhone", customerPhone)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerStatus(String customerStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERSTATUS, true)
                .addParameter("customerStatus", customerStatus)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerType(String customerType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERTYPE, true)
                .addParameter("customerType", customerType)
                .executeAndFetch(Customer.class);
    }
    @Override
    public List<Customer> readByCustomerUpdatedAt(String customerUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CustomerQuery.READ_BY_CUSTOMER_CUSTOMERUPDATEDAT, true)
                .addParameter("customerUpdatedAt", customerUpdatedAt)
                .executeAndFetch(Customer.class);
    }

@Override
public CustomerPage findCustomer(CustomerFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(CustomerQuery.READ);

    // Dynamic filters

    if (filter.getCustomerAddress() != null) {   baseSql.append(" AND customerAddress = :customerAddress"); }
    if (filter.getCustomerCompanyName() != null) {   baseSql.append(" AND customerCompanyName = :customerCompanyName"); }
    if (filter.getCustomerCreatedAt() != null) {   baseSql.append(" AND customerCreatedAt = :customerCreatedAt"); }
    if (filter.getCustomerCreditBalance() != null) {   baseSql.append(" AND customerCreditBalance = :customerCreditBalance"); }
    if (filter.getCustomerEmail() != null) {   baseSql.append(" AND customerEmail = :customerEmail"); }
    if (filter.getCustomerId() != null) {   baseSql.append(" AND customerId = :customerId"); }
    if (filter.getCustomerName() != null) {   baseSql.append(" AND customerName = :customerName"); }
    if (filter.getCustomerNotes() != null) {   baseSql.append(" AND customerNotes = :customerNotes"); }
    if (filter.getCustomerPhone() != null) {   baseSql.append(" AND customerPhone = :customerPhone"); }
    if (filter.getCustomerStatus() != null) {   baseSql.append(" AND customerStatus = :customerStatus"); }
    if (filter.getCustomerType() != null) {   baseSql.append(" AND customerType = :customerType"); }
    if (filter.getCustomerUpdatedAt() != null) {   baseSql.append(" AND customerUpdatedAt = :customerUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getCustomerAddress() != null) countQuery.addParameter("customerAddress", filter.getCustomerAddress());
     if (filter.getCustomerCompanyName() != null) countQuery.addParameter("customerCompanyName", filter.getCustomerCompanyName());
     if (filter.getCustomerCreatedAt() != null) countQuery.addParameter("customerCreatedAt", filter.getCustomerCreatedAt());
     if (filter.getCustomerCreditBalance() != null) countQuery.addParameter(System.getenv("API_KEY_CUSTOMER"), filter.getCustomerCreditBalance());
     if (filter.getCustomerEmail() != null) countQuery.addParameter("customerEmail", filter.getCustomerEmail());
     if (filter.getCustomerId() != null) countQuery.addParameter("customerId", filter.getCustomerId());
     if (filter.getCustomerName() != null) countQuery.addParameter("customerName", filter.getCustomerName());
     if (filter.getCustomerNotes() != null) countQuery.addParameter("customerNotes", filter.getCustomerNotes());
     if (filter.getCustomerPhone() != null) countQuery.addParameter("customerPhone", filter.getCustomerPhone());
     if (filter.getCustomerStatus() != null) countQuery.addParameter("customerStatus", filter.getCustomerStatus());
     if (filter.getCustomerType() != null) countQuery.addParameter("customerType", filter.getCustomerType());
     if (filter.getCustomerUpdatedAt() != null) countQuery.addParameter("customerUpdatedAt", filter.getCustomerUpdatedAt());
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

    if (filter.getCustomerAddress() != null) pageQuery.addParameter("customerAddress", filter.getCustomerAddress());
    if (filter.getCustomerCompanyName() != null) pageQuery.addParameter("customerCompanyName", filter.getCustomerCompanyName());
    if (filter.getCustomerCreatedAt() != null) pageQuery.addParameter("customerCreatedAt", filter.getCustomerCreatedAt());
    if (filter.getCustomerCreditBalance() != null) pageQuery.addParameter(System.getenv("API_KEY_CUSTOMER"), filter.getCustomerCreditBalance());
    if (filter.getCustomerEmail() != null) pageQuery.addParameter("customerEmail", filter.getCustomerEmail());
    if (filter.getCustomerId() != null) pageQuery.addParameter("customerId", filter.getCustomerId());
    if (filter.getCustomerName() != null) pageQuery.addParameter("customerName", filter.getCustomerName());
    if (filter.getCustomerNotes() != null) pageQuery.addParameter("customerNotes", filter.getCustomerNotes());
    if (filter.getCustomerPhone() != null) pageQuery.addParameter("customerPhone", filter.getCustomerPhone());
    if (filter.getCustomerStatus() != null) pageQuery.addParameter("customerStatus", filter.getCustomerStatus());
    if (filter.getCustomerType() != null) pageQuery.addParameter("customerType", filter.getCustomerType());
    if (filter.getCustomerUpdatedAt() != null) pageQuery.addParameter("customerUpdatedAt", filter.getCustomerUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Customer> data = pageQuery.executeAndFetch(Customer.class);

     return new CustomerPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "customerAddress","customerCompanyName","customerCreatedAt",System.getenv("API_KEY_CUSTOMER"),"customerEmail","customerId","customerName","customerNotes","customerPhone","customerStatus","customerType","customerUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
