
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
@RequestMapping("/transaction")
@Validated
public class TransactionController {

    private final TransactionService transactionService;
    private final Environment environment;

    public TransactionController(TransactionService transactionService,Environment environment) {
        this.transactionService = transactionService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody TransactionCreateRequest request) {
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
    return transactionService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<TransactionCreateRequest> request
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
    return transactionService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody TransactionUpdateRequest request) {
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
    return transactionService.update(request);
}

@GetMapping("/read")
public TransactionReadListResponse read(
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
    return transactionService.read();
}

@DeleteMapping("/delete/{transactionId}")
public BaseResponse softDeleteTransaction(
@RequestHeader("Authorization") String authorization,
@PathVariable int  transactionId) {
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
    return transactionService.delete(transactionId);
}



@GetMapping("/read-by-transaction-amount/{transactionAmount}")
public TransactionReadListResponse getTransactionTransactionAmount(
@RequestHeader("Authorization") String authorization,
@PathVariable Double transactionAmount) {
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
    return transactionService.readByTransactionAmount(transactionAmount);
}


@GetMapping("/read-by-transaction-created-at/{transactionCreatedAt}")
public TransactionReadListResponse getTransactionTransactionCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionCreatedAt) {
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
    return transactionService.readByTransactionCreatedAt(transactionCreatedAt);
}


@GetMapping("/read-by-transaction-description/{transactionDescription}")
public TransactionReadListResponse getTransactionTransactionDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionDescription) {
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
    return transactionService.readByTransactionDescription(transactionDescription);
}


@GetMapping("/read-by-transaction-id/{transactionId}")
public TransactionReadSingleResponse getTransactionTransactionId(
@RequestHeader("Authorization") String authorization,
@PathVariable int transactionId) {
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
    return transactionService.readByTransactionId(transactionId);
}


@GetMapping("/read-by-transaction-narration/{transactionNarration}")
public TransactionReadListResponse getTransactionTransactionNarration(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionNarration) {
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
    return transactionService.readByTransactionNarration(transactionNarration);
}


@GetMapping("/read-by-transaction-reference-number/{transactionReferenceNumber}")
public TransactionReadListResponse getTransactionTransactionReferenceNumber(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionReferenceNumber) {
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
    return transactionService.readByTransactionReferenceNumber(transactionReferenceNumber);
}


@GetMapping("/read-by-transaction-source-module/{transactionSourceModule}")
public TransactionReadListResponse getTransactionTransactionSourceModule(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionSourceModule) {
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
    return transactionService.readByTransactionSourceModule(transactionSourceModule);
}


@GetMapping("/read-by-transaction-source-reference-id/{transactionSourceReferenceId}")
public TransactionReadListResponse getTransactionTransactionSourceReferenceId(
@RequestHeader("Authorization") String authorization,
@PathVariable int transactionSourceReferenceId) {
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
    return transactionService.readByTransactionSourceReferenceId(transactionSourceReferenceId);
}


@GetMapping("/read-by-transaction-status/{transactionStatus}")
public TransactionReadListResponse getTransactionTransactionStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionStatus) {
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
    return transactionService.readByTransactionStatus(transactionStatus);
}


@GetMapping("/read-by-transaction-transaction-category-id/{transactionTransactionCategoryId}")
public TransactionReadListResponse getTransactionTransactionTransactionCategoryId(
@RequestHeader("Authorization") String authorization,
@PathVariable int transactionTransactionCategoryId) {
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
    return transactionService.readByTransactionTransactionCategoryId(transactionTransactionCategoryId);
}


@GetMapping("/read-by-transaction-transaction-date/{transactionTransactionDate}")
public TransactionReadListResponse getTransactionTransactionTransactionDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionTransactionDate) {
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
    return transactionService.readByTransactionTransactionDate(transactionTransactionDate);
}


@GetMapping("/read-by-transaction-updated-at/{transactionUpdatedAt}")
public TransactionReadListResponse getTransactionTransactionUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String transactionUpdatedAt) {
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
    return transactionService.readByTransactionUpdatedAt(transactionUpdatedAt);
}

@GetMapping("/search")
public TransactionReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "transactionId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Double transactionAmount,
        @RequestParam(required = false) String transactionCreatedAt,
        @RequestParam(required = false) String transactionDescription,
        @RequestParam(required = false) Integer transactionId,
        @RequestParam(required = false) String transactionNarration,
        @RequestParam(required = false) String transactionReferenceNumber,
        @RequestParam(required = false) String transactionSourceModule,
        @RequestParam(required = false) Integer transactionSourceReferenceId,
        @RequestParam(required = false) String transactionStatus,
        @RequestParam(required = false) Integer transactionTransactionCategoryId,
        @RequestParam(required = false) String transactionTransactionDate,
        @RequestParam(required = false) String transactionUpdatedAt
) {
    TransactionFilterRequest filter = new TransactionFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setTransactionAmount(transactionAmount);
    filter.setTransactionCreatedAt(transactionCreatedAt);
    filter.setTransactionDescription(transactionDescription);
    filter.setTransactionId(transactionId);
    filter.setTransactionNarration(transactionNarration);
    filter.setTransactionReferenceNumber(transactionReferenceNumber);
    filter.setTransactionSourceModule(transactionSourceModule);
    filter.setTransactionSourceReferenceId(transactionSourceReferenceId);
    filter.setTransactionStatus(transactionStatus);
    filter.setTransactionTransactionCategoryId(transactionTransactionCategoryId);
    filter.setTransactionTransactionDate(transactionTransactionDate);
    filter.setTransactionUpdatedAt(transactionUpdatedAt);

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
    return transactionService.search(filter);
}
}
