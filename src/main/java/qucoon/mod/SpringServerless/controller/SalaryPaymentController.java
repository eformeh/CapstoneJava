
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
@RequestMapping("/salary-payment")
@Validated
public class SalaryPaymentController {

    private final SalaryPaymentService salarypaymentService;
    private final Environment environment;

    public SalaryPaymentController(SalaryPaymentService salarypaymentService,Environment environment) {
        this.salarypaymentService = salarypaymentService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody SalaryPaymentCreateRequest request) {
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
    return salarypaymentService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<SalaryPaymentCreateRequest> request
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
    return salarypaymentService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody SalaryPaymentUpdateRequest request) {
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
    return salarypaymentService.update(request);
}

@GetMapping("/read")
public SalaryPaymentReadListResponse read(
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
    return salarypaymentService.read();
}

@DeleteMapping("/delete/{salaryPaymentId}")
public BaseResponse softDeleteSalarypayment(
@RequestHeader("Authorization") String authorization,
@PathVariable int  salaryPaymentId) {
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
    return salarypaymentService.delete(salaryPaymentId);
}



@GetMapping("/read-by-salary-payment-amount/{salaryPaymentAmount}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentAmount(
@RequestHeader("Authorization") String authorization,
@PathVariable Double salaryPaymentAmount) {
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
    return salarypaymentService.readBySalaryPaymentAmount(salaryPaymentAmount);
}


@GetMapping("/read-by-salary-payment-approved-by/{salaryPaymentApprovedBy}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentApprovedBy(
@RequestHeader("Authorization") String authorization,
@PathVariable int salaryPaymentApprovedBy) {
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
    return salarypaymentService.readBySalaryPaymentApprovedBy(salaryPaymentApprovedBy);
}


@GetMapping("/read-by-salary-payment-channel/{salaryPaymentChannel}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentChannel(
@RequestHeader("Authorization") String authorization,
@PathVariable String salaryPaymentChannel) {
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
    return salarypaymentService.readBySalaryPaymentChannel(salaryPaymentChannel);
}


@GetMapping("/read-by-salary-payment-created-at/{salaryPaymentCreatedAt}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String salaryPaymentCreatedAt) {
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
    return salarypaymentService.readBySalaryPaymentCreatedAt(salaryPaymentCreatedAt);
}


@GetMapping("/read-by-salary-payment-employee-account-id/{salaryPaymentEmployeeAccountId}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentEmployeeAccountId(
@RequestHeader("Authorization") String authorization,
@PathVariable int salaryPaymentEmployeeAccountId) {
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
    return salarypaymentService.readBySalaryPaymentEmployeeAccountId(salaryPaymentEmployeeAccountId);
}


@GetMapping("/read-by-salary-payment-id/{salaryPaymentId}")
public SalaryPaymentReadSingleResponse getSalarypaymentSalaryPaymentId(
@RequestHeader("Authorization") String authorization,
@PathVariable int salaryPaymentId) {
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
    return salarypaymentService.readBySalaryPaymentId(salaryPaymentId);
}


@GetMapping("/read-by-salary-payment-salary-id/{salaryPaymentSalaryId}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentSalaryId(
@RequestHeader("Authorization") String authorization,
@PathVariable int salaryPaymentSalaryId) {
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
    return salarypaymentService.readBySalaryPaymentSalaryId(salaryPaymentSalaryId);
}


@GetMapping("/read-by-salary-payment-status/{salaryPaymentStatus}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String salaryPaymentStatus) {
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
    return salarypaymentService.readBySalaryPaymentStatus(salaryPaymentStatus);
}


@GetMapping("/read-by-salary-payment-transaction-id/{salaryPaymentTransactionId}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentTransactionId(
@RequestHeader("Authorization") String authorization,
@PathVariable int salaryPaymentTransactionId) {
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
    return salarypaymentService.readBySalaryPaymentTransactionId(salaryPaymentTransactionId);
}


@GetMapping("/read-by-salary-payment-updated-at/{salaryPaymentUpdatedAt}")
public SalaryPaymentReadListResponse getSalarypaymentSalaryPaymentUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String salaryPaymentUpdatedAt) {
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
    return salarypaymentService.readBySalaryPaymentUpdatedAt(salaryPaymentUpdatedAt);
}

@GetMapping("/search")
public SalaryPaymentReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "salaryPaymentId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Double salaryPaymentAmount,
        @RequestParam(required = false) Integer salaryPaymentApprovedBy,
        @RequestParam(required = false) String salaryPaymentChannel,
        @RequestParam(required = false) String salaryPaymentCreatedAt,
        @RequestParam(required = false) Integer salaryPaymentEmployeeAccountId,
        @RequestParam(required = false) Integer salaryPaymentId,
        @RequestParam(required = false) Integer salaryPaymentSalaryId,
        @RequestParam(required = false) String salaryPaymentStatus,
        @RequestParam(required = false) Integer salaryPaymentTransactionId,
        @RequestParam(required = false) String salaryPaymentUpdatedAt
) {
    SalaryPaymentFilterRequest filter = new SalaryPaymentFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setSalaryPaymentAmount(salaryPaymentAmount);
    filter.setSalaryPaymentApprovedBy(salaryPaymentApprovedBy);
    filter.setSalaryPaymentChannel(salaryPaymentChannel);
    filter.setSalaryPaymentCreatedAt(salaryPaymentCreatedAt);
    filter.setSalaryPaymentEmployeeAccountId(salaryPaymentEmployeeAccountId);
    filter.setSalaryPaymentId(salaryPaymentId);
    filter.setSalaryPaymentSalaryId(salaryPaymentSalaryId);
    filter.setSalaryPaymentStatus(salaryPaymentStatus);
    filter.setSalaryPaymentTransactionId(salaryPaymentTransactionId);
    filter.setSalaryPaymentUpdatedAt(salaryPaymentUpdatedAt);

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
    return salarypaymentService.search(filter);
}
}
