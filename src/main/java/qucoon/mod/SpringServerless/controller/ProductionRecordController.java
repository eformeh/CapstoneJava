
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
@RequestMapping("/production-record")
@Validated
public class ProductionRecordController {

    private final ProductionRecordService productionrecordService;
    private final Environment environment;

    public ProductionRecordController(ProductionRecordService productionrecordService,Environment environment) {
        this.productionrecordService = productionrecordService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ProductionRecordCreateRequest request) {
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
    return productionrecordService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<ProductionRecordCreateRequest> request
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
    return productionrecordService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ProductionRecordUpdateRequest request) {
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
    return productionrecordService.update(request);
}

@GetMapping("/read")
public ProductionRecordReadListResponse read(
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
    return productionrecordService.read();
}

@DeleteMapping("/delete/{productionRecordId}")
public BaseResponse softDeleteProductionrecord(
@RequestHeader("Authorization") String authorization,
@PathVariable int  productionRecordId) {
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
    return productionrecordService.delete(productionRecordId);
}



@GetMapping("/read-by-production-record-batch-number/{productionRecordBatchNumber}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordBatchNumber(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionRecordBatchNumber) {
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
    return productionrecordService.readByProductionRecordBatchNumber(productionRecordBatchNumber);
}


@GetMapping("/read-by-production-record-created-at/{productionRecordCreatedAt}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionRecordCreatedAt) {
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
    return productionrecordService.readByProductionRecordCreatedAt(productionRecordCreatedAt);
}


@GetMapping("/read-by-production-record-created-by-user-id/{productionRecordCreatedByUserId}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordCreatedByUserId(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionRecordCreatedByUserId) {
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
    return productionrecordService.readByProductionRecordCreatedByUserId(productionRecordCreatedByUserId);
}


@GetMapping("/read-by-production-record-date/{productionRecordDate}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionRecordDate) {
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
    return productionrecordService.readByProductionRecordDate(productionRecordDate);
}


@GetMapping("/read-by-production-record-finished-good-product-id/{productionRecordFinishedGoodProductId}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordFinishedGoodProductId(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionRecordFinishedGoodProductId) {
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
    return productionrecordService.readByProductionRecordFinishedGoodProductId(productionRecordFinishedGoodProductId);
}


@GetMapping("/read-by-production-record-id/{productionRecordId}")
public ProductionRecordReadSingleResponse getProductionrecordProductionRecordId(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionRecordId) {
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
    return productionrecordService.readByProductionRecordId(productionRecordId);
}


@GetMapping("/read-by-production-record-status/{productionRecordStatus}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionRecordStatus) {
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
    return productionrecordService.readByProductionRecordStatus(productionRecordStatus);
}


@GetMapping("/read-by-production-record-updated-at/{productionRecordUpdatedAt}")
public ProductionRecordReadListResponse getProductionrecordProductionRecordUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionRecordUpdatedAt) {
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
    return productionrecordService.readByProductionRecordUpdatedAt(productionRecordUpdatedAt);
}


@GetMapping("/read-by-supplier-phone-number/{supplierPhoneNumber}")
public ProductionRecordReadListResponse getProductionrecordSupplierPhoneNumber(
@RequestHeader("Authorization") String authorization,
@PathVariable String supplierPhoneNumber) {
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
    return productionrecordService.readBySupplierPhoneNumber(supplierPhoneNumber);
}

@GetMapping("/search")
public ProductionRecordReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "productionRecordId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String productionRecordBatchNumber,
        @RequestParam(required = false) String productionRecordCreatedAt,
        @RequestParam(required = false) Integer productionRecordCreatedByUserId,
        @RequestParam(required = false) String productionRecordDate,
        @RequestParam(required = false) Integer productionRecordFinishedGoodProductId,
        @RequestParam(required = false) Integer productionRecordId,
        @RequestParam(required = false) String productionRecordStatus,
        @RequestParam(required = false) String productionRecordUpdatedAt,
        @RequestParam(required = false) String supplierPhoneNumber
) {
    ProductionRecordFilterRequest filter = new ProductionRecordFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setProductionRecordBatchNumber(productionRecordBatchNumber);
    filter.setProductionRecordCreatedAt(productionRecordCreatedAt);
    filter.setProductionRecordCreatedByUserId(productionRecordCreatedByUserId);
    filter.setProductionRecordDate(productionRecordDate);
    filter.setProductionRecordFinishedGoodProductId(productionRecordFinishedGoodProductId);
    filter.setProductionRecordId(productionRecordId);
    filter.setProductionRecordStatus(productionRecordStatus);
    filter.setProductionRecordUpdatedAt(productionRecordUpdatedAt);
    filter.setSupplierPhoneNumber(supplierPhoneNumber);

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
    return productionrecordService.search(filter);
}
}
