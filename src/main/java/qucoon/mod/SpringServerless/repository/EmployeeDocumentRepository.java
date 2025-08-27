
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.EmployeeDocumentPage;
import qucoon.mod.SpringServerless.model.request.EmployeeDocumentFilterRequest;

import java.util.List;

@Repository
    public interface EmployeeDocumentRepository {


    // Additional query methods can be defined here.
    int create(EmployeeDocument employeedocument);
    void bulkCreate(List<EmployeeDocument>  employeedocument);
    int update(EmployeeDocument  employeedocument);
    int delete(int employeeDocumentId);
    EmployeeDocumentPage findEmployeeDocument(EmployeeDocumentFilterRequest filter);
    boolean truncate();
    List<EmployeeDocument> read();
    List<EmployeeDocument> readByEmployeeDocumentAccessLevel(String employeeDocumentAccessLevel);
    List<EmployeeDocument> readByEmployeeDocumentCreatedAt(String employeeDocumentCreatedAt);
    List<EmployeeDocument> readByEmployeeDocumentEmployeeId(int employeeDocumentEmployeeId);
    List<EmployeeDocument> readByEmployeeDocumentExpiresAt(String employeeDocumentExpiresAt);
    List<EmployeeDocument> readByEmployeeDocumentFileUrl(String employeeDocumentFileUrl);
    EmployeeDocument readByEmployeeDocumentId(int employeeDocumentId);
    List<EmployeeDocument> readByEmployeeDocumentStatus(String employeeDocumentStatus);
    List<EmployeeDocument> readByEmployeeDocumentType(String employeeDocumentType);
    List<EmployeeDocument> readByEmployeeDocumentUpdatedAt(String employeeDocumentUpdatedAt);
    List<EmployeeDocument> readByEmployeeDocumentUploadedBy(int employeeDocumentUploadedBy);
    List<EmployeeDocument> readByEmployeeDocumentVersion(String employeeDocumentVersion);
}
