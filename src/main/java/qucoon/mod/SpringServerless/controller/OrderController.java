
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
@RequestMapping("/order")
@Validated
public class OrderController {

    private final OrderService orderService;
    private final Environment environment;

    public OrderController(OrderService orderService,Environment environment) {
        this.orderService = orderService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody OrderCreateRequest request) {
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
    return orderService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<OrderCreateRequest> request
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
    return orderService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody OrderUpdateRequest request) {
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
    return orderService.update(request);
}

@GetMapping("/read")
public OrderReadListResponse read(
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
    return orderService.read();
}

@DeleteMapping("/delete/{orderId}")
public BaseResponse softDeleteOrder(
@RequestHeader("Authorization") String authorization,
@PathVariable int  orderId) {
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
    return orderService.delete(orderId);
}



@GetMapping("/read-by-order-actual-delivery-date/{orderActualDeliveryDate}")
public OrderReadListResponse getOrderOrderActualDeliveryDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderActualDeliveryDate) {
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
    return orderService.readByOrderActualDeliveryDate(orderActualDeliveryDate);
}


@GetMapping("/read-by-order-created-at/{orderCreatedAt}")
public OrderReadListResponse getOrderOrderCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderCreatedAt) {
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
    return orderService.readByOrderCreatedAt(orderCreatedAt);
}


@GetMapping("/read-by-order-created-by-user-id/{orderCreatedByUserId}")
public OrderReadListResponse getOrderOrderCreatedByUserId(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderCreatedByUserId) {
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
    return orderService.readByOrderCreatedByUserId(orderCreatedByUserId);
}


@GetMapping("/read-by-order-expected-delivery-date/{orderExpectedDeliveryDate}")
public OrderReadListResponse getOrderOrderExpectedDeliveryDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderExpectedDeliveryDate) {
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
    return orderService.readByOrderExpectedDeliveryDate(orderExpectedDeliveryDate);
}


@GetMapping("/read-by-order-id/{orderId}")
public OrderReadSingleResponse getOrderOrderId(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderId) {
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
    return orderService.readByOrderId(orderId);
}


@GetMapping("/read-by-order-order-date/{orderOrderDate}")
public OrderReadListResponse getOrderOrderOrderDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderOrderDate) {
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
    return orderService.readByOrderOrderDate(orderOrderDate);
}


@GetMapping("/read-by-order-status/{orderStatus}")
public OrderReadListResponse getOrderOrderStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderStatus) {
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
    return orderService.readByOrderStatus(orderStatus);
}


@GetMapping("/read-by-order-supplier-id/{orderSupplierId}")
public OrderReadListResponse getOrderOrderSupplierId(
@RequestHeader("Authorization") String authorization,
@PathVariable int orderSupplierId) {
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
    return orderService.readByOrderSupplierId(orderSupplierId);
}


@GetMapping("/read-by-order-total-cost/{orderTotalCost}")
public OrderReadListResponse getOrderOrderTotalCost(
@RequestHeader("Authorization") String authorization,
@PathVariable Double orderTotalCost) {
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
    return orderService.readByOrderTotalCost(orderTotalCost);
}


@GetMapping("/read-by-order-type/{orderType}")
public OrderReadListResponse getOrderOrderType(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderType) {
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
    return orderService.readByOrderType(orderType);
}


@GetMapping("/read-by-order-updated-at/{orderUpdatedAt}")
public OrderReadListResponse getOrderOrderUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String orderUpdatedAt) {
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
    return orderService.readByOrderUpdatedAt(orderUpdatedAt);
}

@GetMapping("/search")
public OrderReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "orderId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String orderActualDeliveryDate,
        @RequestParam(required = false) String orderCreatedAt,
        @RequestParam(required = false) Integer orderCreatedByUserId,
        @RequestParam(required = false) String orderExpectedDeliveryDate,
        @RequestParam(required = false) Integer orderId,
        @RequestParam(required = false) String orderOrderDate,
        @RequestParam(required = false) String orderStatus,
        @RequestParam(required = false) Integer orderSupplierId,
        @RequestParam(required = false) Double orderTotalCost,
        @RequestParam(required = false) String orderType,
        @RequestParam(required = false) String orderUpdatedAt
) {
    OrderFilterRequest filter = new OrderFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setOrderActualDeliveryDate(orderActualDeliveryDate);
    filter.setOrderCreatedAt(orderCreatedAt);
    filter.setOrderCreatedByUserId(orderCreatedByUserId);
    filter.setOrderExpectedDeliveryDate(orderExpectedDeliveryDate);
    filter.setOrderId(orderId);
    filter.setOrderOrderDate(orderOrderDate);
    filter.setOrderStatus(orderStatus);
    filter.setOrderSupplierId(orderSupplierId);
    filter.setOrderTotalCost(orderTotalCost);
    filter.setOrderType(orderType);
    filter.setOrderUpdatedAt(orderUpdatedAt);

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
    return orderService.search(filter);
}
}
