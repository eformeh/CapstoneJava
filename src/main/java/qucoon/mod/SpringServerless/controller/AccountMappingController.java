
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
@RequestMapping("/account-mapping")
@Validated
public class AccountMappingController {

    private final AccountMappingService accountmappingService;
    private final Environment environment;

    public AccountMappingController(AccountMappingService accountmappingService,Environment environment) {
        this.accountmappingService = accountmappingService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AccountMappingCreateRequest request) {
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
    return accountmappingService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<AccountMappingCreateRequest> request
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
    return accountmappingService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AccountMappingUpdateRequest request) {
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
    return accountmappingService.update(request);
}

@GetMapping("/read")
public AccountMappingReadListResponse read(
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
    return accountmappingService.read();
}

@DeleteMapping("/delete/{accountMappingId}")
public BaseResponse softDeleteAccountmapping(
@RequestHeader("Authorization") String authorization,
@PathVariable int  accountMappingId) {
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
    return accountmappingService.delete(accountMappingId);
}



@GetMapping("/read-by-account-mapping-cr-account-id/{accountMappingCrAccountId}")
public AccountMappingReadListResponse getAccountmappingAccountMappingCrAccountId(
@RequestHeader("Authorization") String authorization,
@PathVariable int accountMappingCrAccountId) {
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
    return accountmappingService.readByAccountMappingCrAccountId(accountMappingCrAccountId);
}


@GetMapping("/read-by-account-mapping-created-at/{accountMappingCreatedAt}")
public AccountMappingReadListResponse getAccountmappingAccountMappingCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String accountMappingCreatedAt) {
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
    return accountmappingService.readByAccountMappingCreatedAt(accountMappingCreatedAt);
}


@GetMapping("/read-by-account-mapping-description/{accountMappingDescription}")
public AccountMappingReadListResponse getAccountmappingAccountMappingDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String accountMappingDescription) {
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
    return accountmappingService.readByAccountMappingDescription(accountMappingDescription);
}


@GetMapping("/read-by-account-mapping-dr-account-id/{accountMappingDrAccountId}")
public AccountMappingReadListResponse getAccountmappingAccountMappingDrAccountId(
@RequestHeader("Authorization") String authorization,
@PathVariable int accountMappingDrAccountId) {
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
    return accountmappingService.readByAccountMappingDrAccountId(accountMappingDrAccountId);
}


@GetMapping("/read-by-account-mapping-id/{accountMappingId}")
public AccountMappingReadSingleResponse getAccountmappingAccountMappingId(
@RequestHeader("Authorization") String authorization,
@PathVariable int accountMappingId) {
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
    return accountmappingService.readByAccountMappingId(accountMappingId);
}


@GetMapping("/read-by-account-mapping-status/{accountMappingStatus}")
public AccountMappingReadListResponse getAccountmappingAccountMappingStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String accountMappingStatus) {
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
    return accountmappingService.readByAccountMappingStatus(accountMappingStatus);
}


@GetMapping("/read-by-account-mapping-transaction-category-id/{accountMappingTransactionCategoryId}")
public AccountMappingReadListResponse getAccountmappingAccountMappingTransactionCategoryId(
@RequestHeader("Authorization") String authorization,
@PathVariable int accountMappingTransactionCategoryId) {
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
    return accountmappingService.readByAccountMappingTransactionCategoryId(accountMappingTransactionCategoryId);
}


@GetMapping("/read-by-account-mapping-updated-at/{accountMappingUpdatedAt}")
public AccountMappingReadListResponse getAccountmappingAccountMappingUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String accountMappingUpdatedAt) {
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
    return accountmappingService.readByAccountMappingUpdatedAt(accountMappingUpdatedAt);
}

@GetMapping("/search")
public AccountMappingReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "accountMappingId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Integer accountMappingCrAccountId,
        @RequestParam(required = false) String accountMappingCreatedAt,
        @RequestParam(required = false) String accountMappingDescription,
        @RequestParam(required = false) Integer accountMappingDrAccountId,
        @RequestParam(required = false) Integer accountMappingId,
        @RequestParam(required = false) String accountMappingStatus,
        @RequestParam(required = false) Integer accountMappingTransactionCategoryId,
        @RequestParam(required = false) String accountMappingUpdatedAt
) {
    AccountMappingFilterRequest filter = new AccountMappingFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setAccountMappingCrAccountId(accountMappingCrAccountId);
    filter.setAccountMappingCreatedAt(accountMappingCreatedAt);
    filter.setAccountMappingDescription(accountMappingDescription);
    filter.setAccountMappingDrAccountId(accountMappingDrAccountId);
    filter.setAccountMappingId(accountMappingId);
    filter.setAccountMappingStatus(accountMappingStatus);
    filter.setAccountMappingTransactionCategoryId(accountMappingTransactionCategoryId);
    filter.setAccountMappingUpdatedAt(accountMappingUpdatedAt);

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
    return accountmappingService.search(filter);
}
}
