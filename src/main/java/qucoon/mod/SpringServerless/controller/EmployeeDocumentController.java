
package qucoon.mod.SpringServerless.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.service.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.utility.JwtUtility;
import qucoon.mod.SpringServerless.utility.constant.PrivilegeConstant;
import qucoon.mod.SpringServerless.utility.model.request.ModulePrivilege;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee-document")
@Validated
public class EmployeeDocumentController {

    private final EmployeeDocumentService employeedocumentService;
    private final Environment environment;

    public EmployeeDocumentController(EmployeeDocumentService employeedocumentService,Environment environment) {
        this.employeedocumentService = employeedocumentService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeDocumentCreateRequest request) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.CREATE, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<EmployeeDocumentCreateRequest> request
        ) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.CREATE, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeDocumentUpdateRequest request) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.UPDATE, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.update(request);
}

@GetMapping("/read")
public EmployeeDocumentReadListResponse read(
@RequestHeader("Authorization") String authorization
) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.read();
}

@DeleteMapping("/delete/{employeeDocumentId}")
public BaseResponse softDeleteEmployeedocument(
@RequestHeader("Authorization") String authorization,
@PathVariable int  employeeDocumentId) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.DELETE, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.delete(employeeDocumentId);
}



@GetMapping("/read-by-employee-document-access-level/{employeeDocumentAccessLevel}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentAccessLevel(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentAccessLevel) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentAccessLevel(employeeDocumentAccessLevel);
}


@GetMapping("/read-by-employee-document-created-at/{employeeDocumentCreatedAt}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentCreatedAt) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentCreatedAt(employeeDocumentCreatedAt);
}


@GetMapping("/read-by-employee-document-employee-id/{employeeDocumentEmployeeId}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeDocumentEmployeeId) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentEmployeeId(employeeDocumentEmployeeId);
}


@GetMapping("/read-by-employee-document-expires-at/{employeeDocumentExpiresAt}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentExpiresAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentExpiresAt) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentExpiresAt(employeeDocumentExpiresAt);
}


@GetMapping("/read-by-employee-document-file-url/{employeeDocumentFileUrl}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentFileUrl(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentFileUrl) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentFileUrl(employeeDocumentFileUrl);
}


@GetMapping("/read-by-employee-document-id/{employeeDocumentId}")
public EmployeeDocumentReadSingleResponse getEmployeedocumentEmployeeDocumentId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeDocumentId) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentId(employeeDocumentId);
}


@GetMapping("/read-by-employee-document-status/{employeeDocumentStatus}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentStatus) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentStatus(employeeDocumentStatus);
}


@GetMapping("/read-by-employee-document-type/{employeeDocumentType}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentType(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentType) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentType(employeeDocumentType);
}


@GetMapping("/read-by-employee-document-updated-at/{employeeDocumentUpdatedAt}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentUpdatedAt) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentUpdatedAt(employeeDocumentUpdatedAt);
}


@GetMapping("/read-by-employee-document-uploaded-by/{employeeDocumentUploadedBy}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentUploadedBy(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeDocumentUploadedBy) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentUploadedBy(employeeDocumentUploadedBy);
}


@GetMapping("/read-by-employee-document-version/{employeeDocumentVersion}")
public EmployeeDocumentReadListResponse getEmployeedocumentEmployeeDocumentVersion(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDocumentVersion) {
JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.readByEmployeeDocumentVersion(employeeDocumentVersion);
}

@GetMapping("/search")
public EmployeeDocumentReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "employeeDocumentId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String employeeDocumentAccessLevel,
        @RequestParam(required = false) String employeeDocumentCreatedAt,
        @RequestParam(required = false) Integer employeeDocumentEmployeeId,
        @RequestParam(required = false) String employeeDocumentExpiresAt,
        @RequestParam(required = false) String employeeDocumentFileUrl,
        @RequestParam(required = false) Integer employeeDocumentId,
        @RequestParam(required = false) String employeeDocumentStatus,
        @RequestParam(required = false) String employeeDocumentType,
        @RequestParam(required = false) String employeeDocumentUpdatedAt,
        @RequestParam(required = false) Integer employeeDocumentUploadedBy,
        @RequestParam(required = false) String employeeDocumentVersion
) {
    EmployeeDocumentFilterRequest filter = new EmployeeDocumentFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setEmployeeDocumentAccessLevel(employeeDocumentAccessLevel);
    filter.setEmployeeDocumentCreatedAt(employeeDocumentCreatedAt);
    filter.setEmployeeDocumentEmployeeId(employeeDocumentEmployeeId);
    filter.setEmployeeDocumentExpiresAt(employeeDocumentExpiresAt);
    filter.setEmployeeDocumentFileUrl(employeeDocumentFileUrl);
    filter.setEmployeeDocumentId(employeeDocumentId);
    filter.setEmployeeDocumentStatus(employeeDocumentStatus);
    filter.setEmployeeDocumentType(employeeDocumentType);
    filter.setEmployeeDocumentUpdatedAt(employeeDocumentUpdatedAt);
    filter.setEmployeeDocumentUploadedBy(employeeDocumentUploadedBy);
    filter.setEmployeeDocumentVersion(employeeDocumentVersion);

JwtUtility jwt = new JwtUtility();
String className = getClass().getSimpleName();
String baseName  = className.endsWith("Controller")
        ? className.substring(0, className.length() - "Controller".length())
        : className;
String snakeCase = baseName.replaceAll("([a-z])([A-Z])", "$1_$2")
        .toLowerCase();
String moduleKey = snakeCase.toUpperCase();
ModulePrivilege privilege = new ModulePrivilege(PrivilegeConstant.READ, moduleKey);
environment.userInfo =  jwt.privilegeAuthorization(privilege, authorization, LoginResponse.class);
    return employeedocumentService.search(filter);
}
}
