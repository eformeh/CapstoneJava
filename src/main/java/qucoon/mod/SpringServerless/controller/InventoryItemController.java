
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
@RequestMapping("/inventory-item")
@Validated
public class InventoryItemController {

    private final InventoryItemService inventoryitemService;
    private final Environment environment;

    public InventoryItemController(InventoryItemService inventoryitemService,Environment environment) {
        this.inventoryitemService = inventoryitemService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody InventoryItemCreateRequest request) {
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
    return inventoryitemService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<InventoryItemCreateRequest> request
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
    return inventoryitemService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody InventoryItemUpdateRequest request) {
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
    return inventoryitemService.update(request);
}

@GetMapping("/read")
public InventoryItemReadListResponse read(
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
    return inventoryitemService.read();
}

@DeleteMapping("/delete/{inventoryItemId}")
public BaseResponse softDeleteInventoryitem(
@RequestHeader("Authorization") String authorization,
@PathVariable int  inventoryItemId) {
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
    return inventoryitemService.delete(inventoryItemId);
}



@GetMapping("/read-by-inventory-item-available-stock/{inventoryItemAvailableStock}")
public InventoryItemReadListResponse getInventoryitemInventoryItemAvailableStock(
@RequestHeader("Authorization") String authorization,
@PathVariable int inventoryItemAvailableStock) {
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
    return inventoryitemService.readByInventoryItemAvailableStock(inventoryItemAvailableStock);
}


@GetMapping("/read-by-inventory-item-category/{inventoryItemCategory}")
public InventoryItemReadListResponse getInventoryitemInventoryItemCategory(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemCategory) {
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
    return inventoryitemService.readByInventoryItemCategory(inventoryItemCategory);
}


@GetMapping("/read-by-inventory-item-created-at/{inventoryItemCreatedAt}")
public InventoryItemReadListResponse getInventoryitemInventoryItemCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemCreatedAt) {
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
    return inventoryitemService.readByInventoryItemCreatedAt(inventoryItemCreatedAt);
}


@GetMapping("/read-by-inventory-item-current-stock/{inventoryItemCurrentStock}")
public InventoryItemReadListResponse getInventoryitemInventoryItemCurrentStock(
@RequestHeader("Authorization") String authorization,
@PathVariable int inventoryItemCurrentStock) {
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
    return inventoryitemService.readByInventoryItemCurrentStock(inventoryItemCurrentStock);
}


@GetMapping("/read-by-inventory-item-description/{inventoryItemDescription}")
public InventoryItemReadListResponse getInventoryitemInventoryItemDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemDescription) {
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
    return inventoryitemService.readByInventoryItemDescription(inventoryItemDescription);
}


@GetMapping("/read-by-inventory-item-id/{inventoryItemId}")
public InventoryItemReadSingleResponse getInventoryitemInventoryItemId(
@RequestHeader("Authorization") String authorization,
@PathVariable int inventoryItemId) {
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
    return inventoryitemService.readByInventoryItemId(inventoryItemId);
}


@GetMapping("/read-by-inventory-item-minimum-stock-level/{inventoryItemMinimumStockLevel}")
public InventoryItemReadListResponse getInventoryitemInventoryItemMinimumStockLevel(
@RequestHeader("Authorization") String authorization,
@PathVariable int inventoryItemMinimumStockLevel) {
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
    return inventoryitemService.readByInventoryItemMinimumStockLevel(inventoryItemMinimumStockLevel);
}


@GetMapping("/read-by-inventory-item-name/{inventoryItemName}")
public InventoryItemReadListResponse getInventoryitemInventoryItemName(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemName) {
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
    return inventoryitemService.readByInventoryItemName(inventoryItemName);
}


@GetMapping("/read-by-inventory-item-reserved-stock/{inventoryItemReservedStock}")
public InventoryItemReadListResponse getInventoryitemInventoryItemReservedStock(
@RequestHeader("Authorization") String authorization,
@PathVariable int inventoryItemReservedStock) {
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
    return inventoryitemService.readByInventoryItemReservedStock(inventoryItemReservedStock);
}


@GetMapping("/read-by-inventory-item-status/{inventoryItemStatus}")
public InventoryItemReadListResponse getInventoryitemInventoryItemStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemStatus) {
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
    return inventoryitemService.readByInventoryItemStatus(inventoryItemStatus);
}


@GetMapping("/read-by-inventory-item-unit-cost/{inventoryItemUnitCost}")
public InventoryItemReadListResponse getInventoryitemInventoryItemUnitCost(
@RequestHeader("Authorization") String authorization,
@PathVariable Double inventoryItemUnitCost) {
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
    return inventoryitemService.readByInventoryItemUnitCost(inventoryItemUnitCost);
}


@GetMapping("/read-by-inventory-item-unit-of-measure/{inventoryItemUnitOfMeasure}")
public InventoryItemReadListResponse getInventoryitemInventoryItemUnitOfMeasure(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemUnitOfMeasure) {
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
    return inventoryitemService.readByInventoryItemUnitOfMeasure(inventoryItemUnitOfMeasure);
}


@GetMapping("/read-by-inventory-item-updated-at/{inventoryItemUpdatedAt}")
public InventoryItemReadListResponse getInventoryitemInventoryItemUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String inventoryItemUpdatedAt) {
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
    return inventoryitemService.readByInventoryItemUpdatedAt(inventoryItemUpdatedAt);
}

@GetMapping("/search")
public InventoryItemReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "inventoryItemId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Integer inventoryItemAvailableStock,
        @RequestParam(required = false) String inventoryItemCategory,
        @RequestParam(required = false) String inventoryItemCreatedAt,
        @RequestParam(required = false) Integer inventoryItemCurrentStock,
        @RequestParam(required = false) String inventoryItemDescription,
        @RequestParam(required = false) Integer inventoryItemId,
        @RequestParam(required = false) Integer inventoryItemMinimumStockLevel,
        @RequestParam(required = false) String inventoryItemName,
        @RequestParam(required = false) Integer inventoryItemReservedStock,
        @RequestParam(required = false) String inventoryItemStatus,
        @RequestParam(required = false) Double inventoryItemUnitCost,
        @RequestParam(required = false) String inventoryItemUnitOfMeasure,
        @RequestParam(required = false) String inventoryItemUpdatedAt
) {
    InventoryItemFilterRequest filter = new InventoryItemFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setInventoryItemAvailableStock(inventoryItemAvailableStock);
    filter.setInventoryItemCategory(inventoryItemCategory);
    filter.setInventoryItemCreatedAt(inventoryItemCreatedAt);
    filter.setInventoryItemCurrentStock(inventoryItemCurrentStock);
    filter.setInventoryItemDescription(inventoryItemDescription);
    filter.setInventoryItemId(inventoryItemId);
    filter.setInventoryItemMinimumStockLevel(inventoryItemMinimumStockLevel);
    filter.setInventoryItemName(inventoryItemName);
    filter.setInventoryItemReservedStock(inventoryItemReservedStock);
    filter.setInventoryItemStatus(inventoryItemStatus);
    filter.setInventoryItemUnitCost(inventoryItemUnitCost);
    filter.setInventoryItemUnitOfMeasure(inventoryItemUnitOfMeasure);
    filter.setInventoryItemUpdatedAt(inventoryItemUpdatedAt);

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
    return inventoryitemService.search(filter);
}
}
