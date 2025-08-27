
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
@RequestMapping("/expense-item")
@Validated
public class ExpenseItemController {

    private final ExpenseItemService expenseitemService;
    private final Environment environment;

    public ExpenseItemController(ExpenseItemService expenseitemService,Environment environment) {
        this.expenseitemService = expenseitemService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ExpenseItemCreateRequest request) {
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
    return expenseitemService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<ExpenseItemCreateRequest> request
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
    return expenseitemService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ExpenseItemUpdateRequest request) {
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
    return expenseitemService.update(request);
}

@GetMapping("/read")
public ExpenseItemReadListResponse read(
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
    return expenseitemService.read();
}

@DeleteMapping("/delete/{expenseItemId}")
public BaseResponse softDeleteExpenseitem(
@RequestHeader("Authorization") String authorization,
@PathVariable int  expenseItemId) {
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
    return expenseitemService.delete(expenseItemId);
}



@GetMapping("/read-by-expense-item-amount/{expenseItemAmount}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemAmount(
@RequestHeader("Authorization") String authorization,
@PathVariable Double expenseItemAmount) {
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
    return expenseitemService.readByExpenseItemAmount(expenseItemAmount);
}


@GetMapping("/read-by-expense-item-category/{expenseItemCategory}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemCategory(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseItemCategory) {
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
    return expenseitemService.readByExpenseItemCategory(expenseItemCategory);
}


@GetMapping("/read-by-expense-item-claim-id/{expenseItemClaimId}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemClaimId(
@RequestHeader("Authorization") String authorization,
@PathVariable int expenseItemClaimId) {
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
    return expenseitemService.readByExpenseItemClaimId(expenseItemClaimId);
}


@GetMapping("/read-by-expense-item-created-at/{expenseItemCreatedAt}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseItemCreatedAt) {
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
    return expenseitemService.readByExpenseItemCreatedAt(expenseItemCreatedAt);
}


@GetMapping("/read-by-expense-item-description/{expenseItemDescription}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseItemDescription) {
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
    return expenseitemService.readByExpenseItemDescription(expenseItemDescription);
}


@GetMapping("/read-by-expense-item-id/{expenseItemId}")
public ExpenseItemReadSingleResponse getExpenseitemExpenseItemId(
@RequestHeader("Authorization") String authorization,
@PathVariable int expenseItemId) {
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
    return expenseitemService.readByExpenseItemId(expenseItemId);
}


@GetMapping("/read-by-expense-item-receipt-url/{expenseItemReceiptUrl}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemReceiptUrl(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseItemReceiptUrl) {
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
    return expenseitemService.readByExpenseItemReceiptUrl(expenseItemReceiptUrl);
}


@GetMapping("/read-by-expense-item-status/{expenseItemStatus}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseItemStatus) {
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
    return expenseitemService.readByExpenseItemStatus(expenseItemStatus);
}


@GetMapping("/read-by-expense-item-updated-at/{expenseItemUpdatedAt}")
public ExpenseItemReadListResponse getExpenseitemExpenseItemUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseItemUpdatedAt) {
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
    return expenseitemService.readByExpenseItemUpdatedAt(expenseItemUpdatedAt);
}

@GetMapping("/search")
public ExpenseItemReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "expenseItemId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Double expenseItemAmount,
        @RequestParam(required = false) String expenseItemCategory,
        @RequestParam(required = false) Integer expenseItemClaimId,
        @RequestParam(required = false) String expenseItemCreatedAt,
        @RequestParam(required = false) String expenseItemDescription,
        @RequestParam(required = false) Integer expenseItemId,
        @RequestParam(required = false) String expenseItemReceiptUrl,
        @RequestParam(required = false) String expenseItemStatus,
        @RequestParam(required = false) String expenseItemUpdatedAt
) {
    ExpenseItemFilterRequest filter = new ExpenseItemFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setExpenseItemAmount(expenseItemAmount);
    filter.setExpenseItemCategory(expenseItemCategory);
    filter.setExpenseItemClaimId(expenseItemClaimId);
    filter.setExpenseItemCreatedAt(expenseItemCreatedAt);
    filter.setExpenseItemDescription(expenseItemDescription);
    filter.setExpenseItemId(expenseItemId);
    filter.setExpenseItemReceiptUrl(expenseItemReceiptUrl);
    filter.setExpenseItemStatus(expenseItemStatus);
    filter.setExpenseItemUpdatedAt(expenseItemUpdatedAt);

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
    return expenseitemService.search(filter);
}
}
