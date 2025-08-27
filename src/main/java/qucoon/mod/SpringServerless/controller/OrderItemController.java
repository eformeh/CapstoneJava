
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
@RequestMapping("/order-item")
@Validated
public class OrderItemController {

    private final OrderItemService orderitemService;
    private final Environment environment;

    public OrderItemController(OrderItemService orderitemService,Environment environment) {
        this.orderitemService = orderitemService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody OrderItemCreateRequest request) {
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
    return orderitemService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<OrderItemCreateRequest> request
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
    return orderitemService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody OrderItemUpdateRequest request) {
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
    return orderitemService.update(request);
}

@GetMapping("/read")
public OrderItemReadListResponse read(
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
    return orderitemService.read();
}

@DeleteMapping("/delete/{orderItemId}")
public BaseResponse softDeleteOrderitem(
@RequestHeader("Authorization") String authorization,
@PathVariable int  orderItemId) {
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
    return orderitemService.delete(orderItemId);
}



@GetMapping("/read-by-order-item-created-at/{orderItemCreatedAt}")
public OrderItemReadListResponse getOrderitemOrderItemCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderItemCreatedAt) {
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
    return orderitemService.readByOrderItemCreatedAt(orderItemCreatedAt);
}


@GetMapping("/read-by-order-item-id/{orderItemId}")
public OrderItemReadSingleResponse getOrderitemOrderItemId(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderItemId) {
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
    return orderitemService.readByOrderItemId(orderItemId);
}


@GetMapping("/read-by-order-item-inventory-item-id/{orderItemInventoryItemId}")
public OrderItemReadListResponse getOrderitemOrderItemInventoryItemId(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderItemInventoryItemId) {
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
    return orderitemService.readByOrderItemInventoryItemId(orderItemInventoryItemId);
}


@GetMapping("/read-by-order-item-order-id/{orderItemOrderId}")
public OrderItemReadListResponse getOrderitemOrderItemOrderId(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderItemOrderId) {
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
    return orderitemService.readByOrderItemOrderId(orderItemOrderId);
}


@GetMapping("/read-by-order-item-quantity-ordered/{orderItemQuantityOrdered}")
public OrderItemReadListResponse getOrderitemOrderItemQuantityOrdered(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderItemQuantityOrdered) {
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
    return orderitemService.readByOrderItemQuantityOrdered(orderItemQuantityOrdered);
}


@GetMapping("/read-by-order-item-status/{orderItemStatus}")
public OrderItemReadListResponse getOrderitemOrderItemStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderItemStatus) {
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
    return orderitemService.readByOrderItemStatus(orderItemStatus);
}


@GetMapping("/read-by-order-item-total-cost/{orderItemTotalCost}")
public OrderItemReadListResponse getOrderitemOrderItemTotalCost(
@RequestHeader("Authorization") String authorization,
@PathVariable Double orderItemTotalCost) {
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
    return orderitemService.readByOrderItemTotalCost(orderItemTotalCost);
}


@GetMapping("/read-by-order-item-unit-cost/{orderItemUnitCost}")
public OrderItemReadListResponse getOrderitemOrderItemUnitCost(
@RequestHeader("Authorization") String authorization,
@PathVariable Double orderItemUnitCost) {
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
    return orderitemService.readByOrderItemUnitCost(orderItemUnitCost);
}


@GetMapping("/read-by-order-item-updated-at/{orderItemUpdatedAt}")
public OrderItemReadListResponse getOrderitemOrderItemUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderItemUpdatedAt) {
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
    return orderitemService.readByOrderItemUpdatedAt(orderItemUpdatedAt);
}

@GetMapping("/search")
public OrderItemReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "orderItemId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String orderItemCreatedAt,
        @RequestParam(required = false) Integer orderItemId,
        @RequestParam(required = false) Integer orderItemInventoryItemId,
        @RequestParam(required = false) Integer orderItemOrderId,
        @RequestParam(required = false) Integer orderItemQuantityOrdered,
        @RequestParam(required = false) String orderItemStatus,
        @RequestParam(required = false) Double orderItemTotalCost,
        @RequestParam(required = false) Double orderItemUnitCost,
        @RequestParam(required = false) String orderItemUpdatedAt
) {
    OrderItemFilterRequest filter = new OrderItemFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setOrderItemCreatedAt(orderItemCreatedAt);
    filter.setOrderItemId(orderItemId);
    filter.setOrderItemInventoryItemId(orderItemInventoryItemId);
    filter.setOrderItemOrderId(orderItemOrderId);
    filter.setOrderItemQuantityOrdered(orderItemQuantityOrdered);
    filter.setOrderItemStatus(orderItemStatus);
    filter.setOrderItemTotalCost(orderItemTotalCost);
    filter.setOrderItemUnitCost(orderItemUnitCost);
    filter.setOrderItemUpdatedAt(orderItemUpdatedAt);

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
    return orderitemService.search(filter);
}
}
