
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SupplierPage;
import qucoon.mod.SpringServerless.model.request.SupplierFilterRequest;

import java.util.List;

@Repository
    public interface SupplierRepository {


    // Additional query methods can be defined here.
    int create(Supplier supplier);
    void bulkCreate(List<Supplier>  supplier);
    int update(Supplier  supplier);
    int delete(int supplierId);
    SupplierPage findSupplier(SupplierFilterRequest filter);
    boolean truncate();
    List<Supplier> read();
    List<Supplier> readBySupplierAddress(String supplierAddress);
    List<Supplier> readBySupplierContactPerson(String supplierContactPerson);
    List<Supplier> readBySupplierCreatedAt(String supplierCreatedAt);
    List<Supplier> readBySupplierCreatedByUserId(int supplierCreatedByUserId);
    List<Supplier> readBySupplierEmail(String supplierEmail);
    Supplier readBySupplierId(int supplierId);
    List<Supplier> readBySupplierName(String supplierName);
    List<Supplier> readBySupplierPhoneNumber(String supplierPhoneNumber);
    List<Supplier> readBySupplierStatus(String supplierStatus);
    List<Supplier> readBySupplierUpdatedAt(String supplierUpdatedAt);
}
