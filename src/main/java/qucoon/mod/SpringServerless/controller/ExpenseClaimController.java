
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
@RequestMapping("/expense-claim")
@Validated
public class ExpenseClaimController {

    private final ExpenseClaimService expenseclaimService;
    private final Environment environment;

    public ExpenseClaimController(ExpenseClaimService expenseclaimService,Environment environment) {
        this.expenseclaimService = expenseclaimService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ExpenseClaimCreateRequest request) {
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
    return expenseclaimService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<ExpenseClaimCreateRequest> request
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
    return expenseclaimService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody ExpenseClaimUpdateRequest request) {
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
    return expenseclaimService.update(request);
}

@GetMapping("/read")
public ExpenseClaimReadListResponse read(
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
    return expenseclaimService.read();
}

@DeleteMapping("/delete/{expenseClaimId}")
public BaseResponse softDeleteExpenseclaim(
@RequestHeader("Authorization") String authorization,
@PathVariable int  expenseClaimId) {
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
    return expenseclaimService.delete(expenseClaimId);
}



@GetMapping("/read-by-expense-claim-created-at/{expenseClaimCreatedAt}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseClaimCreatedAt) {
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
    return expenseclaimService.readByExpenseClaimCreatedAt(expenseClaimCreatedAt);
}


@GetMapping("/read-by-expense-claim-decision-date/{expenseClaimDecisionDate}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimDecisionDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseClaimDecisionDate) {
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
    return expenseclaimService.readByExpenseClaimDecisionDate(expenseClaimDecisionDate);
}


@GetMapping("/read-by-expense-claim-employee-id/{expenseClaimEmployeeId}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int expenseClaimEmployeeId) {
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
    return expenseclaimService.readByExpenseClaimEmployeeId(expenseClaimEmployeeId);
}


@GetMapping("/read-by-expense-claim-id/{expenseClaimId}")
public ExpenseClaimReadSingleResponse getExpenseclaimExpenseClaimId(
@RequestHeader("Authorization") String authorization,
@PathVariable int expenseClaimId) {
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
    return expenseclaimService.readByExpenseClaimId(expenseClaimId);
}


@GetMapping("/read-by-expense-claim-reimbursement-date/{expenseClaimReimbursementDate}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimReimbursementDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseClaimReimbursementDate) {
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
    return expenseclaimService.readByExpenseClaimReimbursementDate(expenseClaimReimbursementDate);
}


@GetMapping("/read-by-expense-claim-reviewer-id/{expenseClaimReviewerId}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimReviewerId(
@RequestHeader("Authorization") String authorization,
@PathVariable int expenseClaimReviewerId) {
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
    return expenseclaimService.readByExpenseClaimReviewerId(expenseClaimReviewerId);
}


@GetMapping("/read-by-expense-claim-status/{expenseClaimStatus}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseClaimStatus) {
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
    return expenseclaimService.readByExpenseClaimStatus(expenseClaimStatus);
}


@GetMapping("/read-by-expense-claim-total-amount/{expenseClaimTotalAmount}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimTotalAmount(
@RequestHeader("Authorization") String authorization,
@PathVariable Double expenseClaimTotalAmount) {
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
    return expenseclaimService.readByExpenseClaimTotalAmount(expenseClaimTotalAmount);
}


@GetMapping("/read-by-expense-claim-updated-at/{expenseClaimUpdatedAt}")
public ExpenseClaimReadListResponse getExpenseclaimExpenseClaimUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String expenseClaimUpdatedAt) {
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
    return expenseclaimService.readByExpenseClaimUpdatedAt(expenseClaimUpdatedAt);
}

@GetMapping("/search")
public ExpenseClaimReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "expenseClaimId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String expenseClaimCreatedAt,
        @RequestParam(required = false) String expenseClaimDecisionDate,
        @RequestParam(required = false) Integer expenseClaimEmployeeId,
        @RequestParam(required = false) Integer expenseClaimId,
        @RequestParam(required = false) String expenseClaimReimbursementDate,
        @RequestParam(required = false) Integer expenseClaimReviewerId,
        @RequestParam(required = false) String expenseClaimStatus,
        @RequestParam(required = false) Double expenseClaimTotalAmount,
        @RequestParam(required = false) String expenseClaimUpdatedAt
) {
    ExpenseClaimFilterRequest filter = new ExpenseClaimFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setExpenseClaimCreatedAt(expenseClaimCreatedAt);
    filter.setExpenseClaimDecisionDate(expenseClaimDecisionDate);
    filter.setExpenseClaimEmployeeId(expenseClaimEmployeeId);
    filter.setExpenseClaimId(expenseClaimId);
    filter.setExpenseClaimReimbursementDate(expenseClaimReimbursementDate);
    filter.setExpenseClaimReviewerId(expenseClaimReviewerId);
    filter.setExpenseClaimStatus(expenseClaimStatus);
    filter.setExpenseClaimTotalAmount(expenseClaimTotalAmount);
    filter.setExpenseClaimUpdatedAt(expenseClaimUpdatedAt);

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
    return expenseclaimService.search(filter);
}
}
