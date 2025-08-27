
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
@RequestMapping("/transaction-category")
@Validated
public class TransactionCategoryController {

    private final TransactionCategoryService transactioncategoryService;
    private final Environment environment;

    public TransactionCategoryController(TransactionCategoryService transactioncategoryService,Environment environment) {
        this.transactioncategoryService = transactioncategoryService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody TransactionCategoryCreateRequest request) {
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
    return transactioncategoryService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<TransactionCategoryCreateRequest> request
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
    return transactioncategoryService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody TransactionCategoryUpdateRequest request) {
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
    return transactioncategoryService.update(request);
}

@GetMapping("/read")
public TransactionCategoryReadListResponse read(
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
    return transactioncategoryService.read();
}

@DeleteMapping("/delete/{transactionCategoryId}")
public BaseResponse softDeleteTransactioncategory(
@RequestHeader("Authorization") String authorization,
@PathVariable int  transactionCategoryId) {
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
    return transactioncategoryService.delete(transactionCategoryId);
}



@GetMapping("/read-by-transaction-category-created-at/{transactionCategoryCreatedAt}")
public TransactionCategoryReadListResponse getTransactioncategoryTransactionCategoryCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCategoryCreatedAt) {
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
    return transactioncategoryService.readByTransactionCategoryCreatedAt(transactionCategoryCreatedAt);
}


@GetMapping("/read-by-transaction-category-description/{transactionCategoryDescription}")
public TransactionCategoryReadListResponse getTransactioncategoryTransactionCategoryDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCategoryDescription) {
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
    return transactioncategoryService.readByTransactionCategoryDescription(transactionCategoryDescription);
}


@GetMapping("/read-by-transaction-category-id/{transactionCategoryId}")
public TransactionCategoryReadSingleResponse getTransactioncategoryTransactionCategoryId(
@RequestHeader("Authorization") String authorization,
@PathVariable int transactionCategoryId) {
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
    return transactioncategoryService.readByTransactionCategoryId(transactionCategoryId);
}


@GetMapping("/read-by-transaction-category-name/{transactionCategoryName}")
public TransactionCategoryReadListResponse getTransactioncategoryTransactionCategoryName(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCategoryName) {
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
    return transactioncategoryService.readByTransactionCategoryName(transactionCategoryName);
}


@GetMapping("/read-by-transaction-category-status/{transactionCategoryStatus}")
public TransactionCategoryReadListResponse getTransactioncategoryTransactionCategoryStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCategoryStatus) {
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
    return transactioncategoryService.readByTransactionCategoryStatus(transactionCategoryStatus);
}


@GetMapping("/read-by-transaction-category-transaction-nature/{transactionCategoryTransactionNature}")
public TransactionCategoryReadListResponse getTransactioncategoryTransactionCategoryTransactionNature(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCategoryTransactionNature) {
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
    return transactioncategoryService.readByTransactionCategoryTransactionNature(transactionCategoryTransactionNature);
}


@GetMapping("/read-by-transaction-category-updated-at/{transactionCategoryUpdatedAt}")
public TransactionCategoryReadListResponse getTransactioncategoryTransactionCategoryUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCategoryUpdatedAt) {
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
    return transactioncategoryService.readByTransactionCategoryUpdatedAt(transactionCategoryUpdatedAt);
}

@GetMapping("/search")
public TransactionCategoryReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = System.getenv("API_KEY_TRANSACT")) String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String transactionCategoryCreatedAt,
        @RequestParam(required = false) String transactionCategoryDescription,
        @RequestParam(required = false) Integer transactionCategoryId,
        @RequestParam(required = false) String transactionCategoryName,
        @RequestParam(required = false) String transactionCategoryStatus,
        @RequestParam(required = false) String transactionCategoryTransactionNature,
        @RequestParam(required = false) String transactionCategoryUpdatedAt
) {
    TransactionCategoryFilterRequest filter = new TransactionCategoryFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setTransactionCategoryCreatedAt(transactionCategoryCreatedAt);
    filter.setTransactionCategoryDescription(transactionCategoryDescription);
    filter.setTransactionCategoryId(transactionCategoryId);
    filter.setTransactionCategoryName(transactionCategoryName);
    filter.setTransactionCategoryStatus(transactionCategoryStatus);
    filter.setTransactionCategoryTransactionNature(transactionCategoryTransactionNature);
    filter.setTransactionCategoryUpdatedAt(transactionCategoryUpdatedAt);

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
    return transactioncategoryService.search(filter);
}
}
