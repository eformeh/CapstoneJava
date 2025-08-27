
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
@RequestMapping("/sale-payment-log")
@Validated
public class SalePaymentLogController {

    private final SalePaymentLogService salepaymentlogService;
    private final Environment environment;

    public SalePaymentLogController(SalePaymentLogService salepaymentlogService,Environment environment) {
        this.salepaymentlogService = salepaymentlogService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody SalePaymentLogCreateRequest request) {
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
    return salepaymentlogService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<SalePaymentLogCreateRequest> request
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
    return salepaymentlogService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody SalePaymentLogUpdateRequest request) {
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
    return salepaymentlogService.update(request);
}

@GetMapping("/read")
public SalePaymentLogReadListResponse read(
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
    return salepaymentlogService.read();
}

@DeleteMapping("/delete/{salePaymentLogid}")
public BaseResponse softDeleteSalepaymentlog(
@RequestHeader("Authorization") String authorization,
@PathVariable int  salePaymentLogid) {
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
    return salepaymentlogService.delete(salePaymentLogid);
}



@GetMapping("/read-by-sale-payment-log-amount/{salePaymentLogAmount}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogAmount(
@RequestHeader("Authorization") String authorization,
@PathVariable Double salePaymentLogAmount) {
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
    return salepaymentlogService.readBySalePaymentLogAmount(salePaymentLogAmount);
}


@GetMapping("/read-by-sale-payment-log-created-at/{salePaymentLogCreatedAt}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String salePaymentLogCreatedAt) {
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
    return salepaymentlogService.readBySalePaymentLogCreatedAt(salePaymentLogCreatedAt);
}


@GetMapping("/read-by-sale-payment-log-employeeid/{salePaymentLogEmployeeid}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogEmployeeid(
@RequestHeader("Authorization") String authorization,
@PathVariable int salePaymentLogEmployeeid) {
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
    return salepaymentlogService.readBySalePaymentLogEmployeeid(salePaymentLogEmployeeid);
}


@GetMapping("/read-by-sale-payment-logid/{salePaymentLogid}")
public SalePaymentLogReadSingleResponse getSalepaymentlogSalePaymentLogid(
@RequestHeader("Authorization") String authorization,
@PathVariable int salePaymentLogid) {
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
    return salepaymentlogService.readBySalePaymentLogid(salePaymentLogid);
}


@GetMapping("/read-by-sale-payment-log-method/{salePaymentLogMethod}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogMethod(
@RequestHeader("Authorization") String authorization,
@PathVariable String salePaymentLogMethod) {
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
    return salepaymentlogService.readBySalePaymentLogMethod(salePaymentLogMethod);
}


@GetMapping("/read-by-sale-payment-log-notes/{salePaymentLogNotes}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogNotes(
@RequestHeader("Authorization") String authorization,
@PathVariable String salePaymentLogNotes) {
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
    return salepaymentlogService.readBySalePaymentLogNotes(salePaymentLogNotes);
}


@GetMapping("/read-by-sale-payment-log-saleid/{salePaymentLogSaleid}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogSaleid(
@RequestHeader("Authorization") String authorization,
@PathVariable int salePaymentLogSaleid) {
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
    return salepaymentlogService.readBySalePaymentLogSaleid(salePaymentLogSaleid);
}


@GetMapping("/read-by-sale-payment-log-status/{salePaymentLogStatus}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentLogStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String salePaymentLogStatus) {
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
    return salepaymentlogService.readBySalePaymentLogStatus(salePaymentLogStatus);
}


@GetMapping("/read-by-sale-payment-updated-at/{salePaymentUpdatedAt}")
public SalePaymentLogReadListResponse getSalepaymentlogSalePaymentUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String salePaymentUpdatedAt) {
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
    return salepaymentlogService.readBySalePaymentUpdatedAt(salePaymentUpdatedAt);
}

@GetMapping("/search")
public SalePaymentLogReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "salePaymentLogid") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Double salePaymentLogAmount,
        @RequestParam(required = false) String salePaymentLogCreatedAt,
        @RequestParam(required = false) Integer salePaymentLogEmployeeid,
        @RequestParam(required = false) Integer salePaymentLogid,
        @RequestParam(required = false) String salePaymentLogMethod,
        @RequestParam(required = false) String salePaymentLogNotes,
        @RequestParam(required = false) Integer salePaymentLogSaleid,
        @RequestParam(required = false) String salePaymentLogStatus,
        @RequestParam(required = false) String salePaymentUpdatedAt
) {
    SalePaymentLogFilterRequest filter = new SalePaymentLogFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setSalePaymentLogAmount(salePaymentLogAmount);
    filter.setSalePaymentLogCreatedAt(salePaymentLogCreatedAt);
    filter.setSalePaymentLogEmployeeid(salePaymentLogEmployeeid);
    filter.setSalePaymentLogid(salePaymentLogid);
    filter.setSalePaymentLogMethod(salePaymentLogMethod);
    filter.setSalePaymentLogNotes(salePaymentLogNotes);
    filter.setSalePaymentLogSaleid(salePaymentLogSaleid);
    filter.setSalePaymentLogStatus(salePaymentLogStatus);
    filter.setSalePaymentUpdatedAt(salePaymentUpdatedAt);

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
    return salepaymentlogService.search(filter);
}
}
