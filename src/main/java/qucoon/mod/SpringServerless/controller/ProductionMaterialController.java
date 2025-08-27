
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
@RequestMapping("/production-material")
@Validated
public class ProductionMaterialController {

    private final ProductionMaterialService productionmaterialService;
    private final Environment environment;

    public ProductionMaterialController(ProductionMaterialService productionmaterialService,Environment environment) {
        this.productionmaterialService = productionmaterialService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ProductionMaterialCreateRequest request) {
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
    return productionmaterialService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<ProductionMaterialCreateRequest> request
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
    return productionmaterialService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ProductionMaterialUpdateRequest request) {
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
    return productionmaterialService.update(request);
}

@GetMapping("/read")
public ProductionMaterialReadListResponse read(
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
    return productionmaterialService.read();
}

@DeleteMapping("/delete/{productionMaterialId}")
public BaseResponse softDeleteProductionmaterial(
@RequestHeader("Authorization") String authorization,
@PathVariable int  productionMaterialId) {
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
    return productionmaterialService.delete(productionMaterialId);
}



@GetMapping("/read-by-production-material-created-at/{productionMaterialCreatedAt}")
public ProductionMaterialReadListResponse getProductionmaterialProductionMaterialCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionMaterialCreatedAt) {
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
    return productionmaterialService.readByProductionMaterialCreatedAt(productionMaterialCreatedAt);
}


@GetMapping("/read-by-production-material-id/{productionMaterialId}")
public ProductionMaterialReadSingleResponse getProductionmaterialProductionMaterialId(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionMaterialId) {
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
    return productionmaterialService.readByProductionMaterialId(productionMaterialId);
}


@GetMapping("/read-by-production-material-inventory-item-id/{productionMaterialInventoryItemId}")
public ProductionMaterialReadListResponse getProductionmaterialProductionMaterialInventoryItemId(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionMaterialInventoryItemId) {
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
    return productionmaterialService.readByProductionMaterialInventoryItemId(productionMaterialInventoryItemId);
}


@GetMapping("/read-by-production-material-production-record-id/{productionMaterialProductionRecordId}")
public ProductionMaterialReadListResponse getProductionmaterialProductionMaterialProductionRecordId(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionMaterialProductionRecordId) {
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
    return productionmaterialService.readByProductionMaterialProductionRecordId(productionMaterialProductionRecordId);
}


@GetMapping("/read-by-production-material-quantity-consumed/{productionMaterialQuantityConsumed}")
public ProductionMaterialReadListResponse getProductionmaterialProductionMaterialQuantityConsumed(
@RequestHeader("Authorization") String authorization,
@PathVariable int productionMaterialQuantityConsumed) {
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
    return productionmaterialService.readByProductionMaterialQuantityConsumed(productionMaterialQuantityConsumed);
}


@GetMapping("/read-by-production-material-status/{productionMaterialStatus}")
public ProductionMaterialReadListResponse getProductionmaterialProductionMaterialStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionMaterialStatus) {
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
    return productionmaterialService.readByProductionMaterialStatus(productionMaterialStatus);
}


@GetMapping("/read-by-production-material-updated-at/{productionMaterialUpdatedAt}")
public ProductionMaterialReadListResponse getProductionmaterialProductionMaterialUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String productionMaterialUpdatedAt) {
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
    return productionmaterialService.readByProductionMaterialUpdatedAt(productionMaterialUpdatedAt);
}

@GetMapping("/search")
public ProductionMaterialReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = System.getenv("API_KEY_PRODUCTI")) String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String productionMaterialCreatedAt,
        @RequestParam(required = false) Integer productionMaterialId,
        @RequestParam(required = false) Integer productionMaterialInventoryItemId,
        @RequestParam(required = false) Integer productionMaterialProductionRecordId,
        @RequestParam(required = false) Integer productionMaterialQuantityConsumed,
        @RequestParam(required = false) String productionMaterialStatus,
        @RequestParam(required = false) String productionMaterialUpdatedAt
) {
    ProductionMaterialFilterRequest filter = new ProductionMaterialFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setProductionMaterialCreatedAt(productionMaterialCreatedAt);
    filter.setProductionMaterialId(productionMaterialId);
    filter.setProductionMaterialInventoryItemId(productionMaterialInventoryItemId);
    filter.setProductionMaterialProductionRecordId(productionMaterialProductionRecordId);
    filter.setProductionMaterialQuantityConsumed(productionMaterialQuantityConsumed);
    filter.setProductionMaterialStatus(productionMaterialStatus);
    filter.setProductionMaterialUpdatedAt(productionMaterialUpdatedAt);

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
    return productionmaterialService.search(filter);
}
}
