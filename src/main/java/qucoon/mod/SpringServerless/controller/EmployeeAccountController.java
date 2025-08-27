
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
@RequestMapping("/employee-account")
@Validated
public class EmployeeAccountController {

    private final EmployeeAccountService employeeaccountService;
    private final Environment environment;

    public EmployeeAccountController(EmployeeAccountService employeeaccountService,Environment environment) {
        this.employeeaccountService = employeeaccountService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeAccountCreateRequest request) {
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
    return employeeaccountService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<EmployeeAccountCreateRequest> request
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
    return employeeaccountService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeAccountUpdateRequest request) {
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
    return employeeaccountService.update(request);
}

@GetMapping("/read")
public EmployeeAccountReadListResponse read(
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
    return employeeaccountService.read();
}

@DeleteMapping("/delete/{employeeAccountId}")
public BaseResponse softDeleteEmployeeaccount(
@RequestHeader("Authorization") String authorization,
@PathVariable int  employeeAccountId) {
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
    return employeeaccountService.delete(employeeAccountId);
}



@GetMapping("/read-by-employee-account-bank-name/{employeeAccountBankName}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountBankName(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeAccountBankName) {
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
    return employeeaccountService.readByEmployeeAccountBankName(employeeAccountBankName);
}


@GetMapping("/read-by-employee-account-created-at/{employeeAccountCreatedAt}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeAccountCreatedAt) {
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
    return employeeaccountService.readByEmployeeAccountCreatedAt(employeeAccountCreatedAt);
}


@GetMapping("/read-by-employee-account-employee-id/{employeeAccountEmployeeId}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeAccountEmployeeId) {
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
    return employeeaccountService.readByEmployeeAccountEmployeeId(employeeAccountEmployeeId);
}


@GetMapping("/read-by-employee-account-id/{employeeAccountId}")
public EmployeeAccountReadSingleResponse getEmployeeaccountEmployeeAccountId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeAccountId) {
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
    return employeeaccountService.readByEmployeeAccountId(employeeAccountId);
}


@GetMapping("/read-by-employee-account-name/{employeeAccountName}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountName(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeAccountName) {
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
    return employeeaccountService.readByEmployeeAccountName(employeeAccountName);
}


@GetMapping("/read-by-employee-account-number/{employeeAccountNumber}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountNumber(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeAccountNumber) {
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
    return employeeaccountService.readByEmployeeAccountNumber(employeeAccountNumber);
}


@GetMapping("/read-by-employee-account-status/{employeeAccountStatus}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeAccountStatus) {
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
    return employeeaccountService.readByEmployeeAccountStatus(employeeAccountStatus);
}


@GetMapping("/read-by-employee-account-updated-at/{employeeAccountUpdatedAt}")
public EmployeeAccountReadListResponse getEmployeeaccountEmployeeAccountUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeAccountUpdatedAt) {
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
    return employeeaccountService.readByEmployeeAccountUpdatedAt(employeeAccountUpdatedAt);
}

@GetMapping("/search")
public EmployeeAccountReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "employeeAccountId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String employeeAccountBankName,
        @RequestParam(required = false) String employeeAccountCreatedAt,
        @RequestParam(required = false) Integer employeeAccountEmployeeId,
        @RequestParam(required = false) Integer employeeAccountId,
        @RequestParam(required = false) String employeeAccountName,
        @RequestParam(required = false) String employeeAccountNumber,
        @RequestParam(required = false) String employeeAccountStatus,
        @RequestParam(required = false) String employeeAccountUpdatedAt
) {
    EmployeeAccountFilterRequest filter = new EmployeeAccountFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setEmployeeAccountBankName(employeeAccountBankName);
    filter.setEmployeeAccountCreatedAt(employeeAccountCreatedAt);
    filter.setEmployeeAccountEmployeeId(employeeAccountEmployeeId);
    filter.setEmployeeAccountId(employeeAccountId);
    filter.setEmployeeAccountName(employeeAccountName);
    filter.setEmployeeAccountNumber(employeeAccountNumber);
    filter.setEmployeeAccountStatus(employeeAccountStatus);
    filter.setEmployeeAccountUpdatedAt(employeeAccountUpdatedAt);

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
    return employeeaccountService.search(filter);
}
}
