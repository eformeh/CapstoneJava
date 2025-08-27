
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
@RequestMapping("/sale-delivery")
@Validated
public class SaleDeliveryController {

    private final SaleDeliveryService saledeliveryService;
    private final Environment environment;

    public SaleDeliveryController(SaleDeliveryService saledeliveryService,Environment environment) {
        this.saledeliveryService = saledeliveryService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody SaleDeliveryCreateRequest request) {
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
    return saledeliveryService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<SaleDeliveryCreateRequest> request
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
    return saledeliveryService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody SaleDeliveryUpdateRequest request) {
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
    return saledeliveryService.update(request);
}

@GetMapping("/read")
public SaleDeliveryReadListResponse read(
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
    return saledeliveryService.read();
}

@DeleteMapping("/delete/{saleDeliveryId}")
public BaseResponse softDeleteSaledelivery(
@RequestHeader("Authorization") String authorization,
@PathVariable int  saleDeliveryId) {
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
    return saledeliveryService.delete(saleDeliveryId);
}



@GetMapping("/read-by-sale-delivery-address/{saleDeliveryAddress}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryAddress(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryAddress) {
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
    return saledeliveryService.readBySaleDeliveryAddress(saleDeliveryAddress);
}


@GetMapping("/read-by-sale-delivery-confirmed-at/{saleDeliveryConfirmedAt}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryConfirmedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryConfirmedAt) {
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
    return saledeliveryService.readBySaleDeliveryConfirmedAt(saleDeliveryConfirmedAt);
}


@GetMapping("/read-by-sale-delivery-contact-name/{saleDeliveryContactName}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryContactName(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryContactName) {
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
    return saledeliveryService.readBySaleDeliveryContactName(saleDeliveryContactName);
}


@GetMapping("/read-by-sale-delivery-contact-phone/{saleDeliveryContactPhone}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryContactPhone(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryContactPhone) {
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
    return saledeliveryService.readBySaleDeliveryContactPhone(saleDeliveryContactPhone);
}


@GetMapping("/read-by-sale-delivery-created-at/{saleDeliveryCreatedAt}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryCreatedAt) {
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
    return saledeliveryService.readBySaleDeliveryCreatedAt(saleDeliveryCreatedAt);
}


@GetMapping("/read-by-sale-delivery-expected-delivery-date/{saleDeliveryExpectedDeliveryDate}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryExpectedDeliveryDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryExpectedDeliveryDate) {
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
    return saledeliveryService.readBySaleDeliveryExpectedDeliveryDate(saleDeliveryExpectedDeliveryDate);
}


@GetMapping("/read-by-sale-delivery-id/{saleDeliveryId}")
public SaleDeliveryReadSingleResponse getSaledeliverySaleDeliveryId(
@RequestHeader("Authorization") String authorization,
@PathVariable int saleDeliveryId) {
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
    return saledeliveryService.readBySaleDeliveryId(saleDeliveryId);
}


@GetMapping("/read-by-sale-delivery-notes/{saleDeliveryNotes}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryNotes(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryNotes) {
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
    return saledeliveryService.readBySaleDeliveryNotes(saleDeliveryNotes);
}


@GetMapping("/read-by-sale-delivery-provider/{saleDeliveryProvider}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryProvider(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryProvider) {
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
    return saledeliveryService.readBySaleDeliveryProvider(saleDeliveryProvider);
}


@GetMapping("/read-by-sale-delivery-sale-id/{saleDeliverySaleId}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliverySaleId(
@RequestHeader("Authorization") String authorization,
@PathVariable int saleDeliverySaleId) {
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
    return saledeliveryService.readBySaleDeliverySaleId(saleDeliverySaleId);
}


@GetMapping("/read-by-sale-delivery-status/{saleDeliveryStatus}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryStatus) {
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
    return saledeliveryService.readBySaleDeliveryStatus(saleDeliveryStatus);
}


@GetMapping("/read-by-sale-delivery-tracking-number/{saleDeliveryTrackingNumber}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryTrackingNumber(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryTrackingNumber) {
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
    return saledeliveryService.readBySaleDeliveryTrackingNumber(saleDeliveryTrackingNumber);
}


@GetMapping("/read-by-sale-delivery-updated-at/{saleDeliveryUpdatedAt}")
public SaleDeliveryReadListResponse getSaledeliverySaleDeliveryUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String saleDeliveryUpdatedAt) {
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
    return saledeliveryService.readBySaleDeliveryUpdatedAt(saleDeliveryUpdatedAt);
}

@GetMapping("/search")
public SaleDeliveryReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "saleDeliveryId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String saleDeliveryAddress,
        @RequestParam(required = false) String saleDeliveryConfirmedAt,
        @RequestParam(required = false) String saleDeliveryContactName,
        @RequestParam(required = false) String saleDeliveryContactPhone,
        @RequestParam(required = false) String saleDeliveryCreatedAt,
        @RequestParam(required = false) String saleDeliveryExpectedDeliveryDate,
        @RequestParam(required = false) Integer saleDeliveryId,
        @RequestParam(required = false) String saleDeliveryNotes,
        @RequestParam(required = false) String saleDeliveryProvider,
        @RequestParam(required = false) Integer saleDeliverySaleId,
        @RequestParam(required = false) String saleDeliveryStatus,
        @RequestParam(required = false) String saleDeliveryTrackingNumber,
        @RequestParam(required = false) String saleDeliveryUpdatedAt
) {
    SaleDeliveryFilterRequest filter = new SaleDeliveryFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setSaleDeliveryAddress(saleDeliveryAddress);
    filter.setSaleDeliveryConfirmedAt(saleDeliveryConfirmedAt);
    filter.setSaleDeliveryContactName(saleDeliveryContactName);
    filter.setSaleDeliveryContactPhone(saleDeliveryContactPhone);
    filter.setSaleDeliveryCreatedAt(saleDeliveryCreatedAt);
    filter.setSaleDeliveryExpectedDeliveryDate(saleDeliveryExpectedDeliveryDate);
    filter.setSaleDeliveryId(saleDeliveryId);
    filter.setSaleDeliveryNotes(saleDeliveryNotes);
    filter.setSaleDeliveryProvider(saleDeliveryProvider);
    filter.setSaleDeliverySaleId(saleDeliverySaleId);
    filter.setSaleDeliveryStatus(saleDeliveryStatus);
    filter.setSaleDeliveryTrackingNumber(saleDeliveryTrackingNumber);
    filter.setSaleDeliveryUpdatedAt(saleDeliveryUpdatedAt);

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
    return saledeliveryService.search(filter);
}
}
