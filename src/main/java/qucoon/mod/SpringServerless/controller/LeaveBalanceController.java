
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
@RequestMapping("/leave-balance")
@Validated
public class LeaveBalanceController {

    private final LeaveBalanceService leavebalanceService;
    private final Environment environment;

    public LeaveBalanceController(LeaveBalanceService leavebalanceService,Environment environment) {
        this.leavebalanceService = leavebalanceService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody LeaveBalanceCreateRequest request) {
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
    return leavebalanceService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<LeaveBalanceCreateRequest> request
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
    return leavebalanceService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody LeaveBalanceUpdateRequest request) {
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
    return leavebalanceService.update(request);
}

@GetMapping("/read")
public LeaveBalanceReadListResponse read(
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
    return leavebalanceService.read();
}

@DeleteMapping("/delete/{leaveBalanceId}")
public BaseResponse softDeleteLeavebalance(
@RequestHeader("Authorization") String authorization,
@PathVariable int  leaveBalanceId) {
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
    return leavebalanceService.delete(leaveBalanceId);
}



@GetMapping("/read-by-leave-balance-created-at/{leaveBalanceCreatedAt}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveBalanceCreatedAt) {
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
    return leavebalanceService.readByLeaveBalanceCreatedAt(leaveBalanceCreatedAt);
}


@GetMapping("/read-by-leave-balance-employee-id/{leaveBalanceEmployeeId}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveBalanceEmployeeId) {
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
    return leavebalanceService.readByLeaveBalanceEmployeeId(leaveBalanceEmployeeId);
}


@GetMapping("/read-by-leave-balance-id/{leaveBalanceId}")
public LeaveBalanceReadSingleResponse getLeavebalanceLeaveBalanceId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveBalanceId) {
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
    return leavebalanceService.readByLeaveBalanceId(leaveBalanceId);
}


@GetMapping("/read-by-leave-balance-remaining-days/{leaveBalanceRemainingDays}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceRemainingDays(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveBalanceRemainingDays) {
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
    return leavebalanceService.readByLeaveBalanceRemainingDays(leaveBalanceRemainingDays);
}


@GetMapping("/read-by-leave-balance-status/{leaveBalanceStatus}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveBalanceStatus) {
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
    return leavebalanceService.readByLeaveBalanceStatus(leaveBalanceStatus);
}


@GetMapping("/read-by-leave-balance-total-days/{leaveBalanceTotalDays}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceTotalDays(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveBalanceTotalDays) {
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
    return leavebalanceService.readByLeaveBalanceTotalDays(leaveBalanceTotalDays);
}


@GetMapping("/read-by-leave-balance-type-id/{leaveBalanceTypeId}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceTypeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveBalanceTypeId) {
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
    return leavebalanceService.readByLeaveBalanceTypeId(leaveBalanceTypeId);
}


@GetMapping("/read-by-leave-balance-updated-at/{leaveBalanceUpdatedAt}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveBalanceUpdatedAt) {
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
    return leavebalanceService.readByLeaveBalanceUpdatedAt(leaveBalanceUpdatedAt);
}


@GetMapping("/read-by-leave-balance-used-days/{leaveBalanceUsedDays}")
public LeaveBalanceReadListResponse getLeavebalanceLeaveBalanceUsedDays(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveBalanceUsedDays) {
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
    return leavebalanceService.readByLeaveBalanceUsedDays(leaveBalanceUsedDays);
}

@GetMapping("/search")
public LeaveBalanceReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "leaveBalanceId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String leaveBalanceCreatedAt,
        @RequestParam(required = false) Integer leaveBalanceEmployeeId,
        @RequestParam(required = false) Integer leaveBalanceId,
        @RequestParam(required = false) Integer leaveBalanceRemainingDays,
        @RequestParam(required = false) String leaveBalanceStatus,
        @RequestParam(required = false) Integer leaveBalanceTotalDays,
        @RequestParam(required = false) Integer leaveBalanceTypeId,
        @RequestParam(required = false) String leaveBalanceUpdatedAt,
        @RequestParam(required = false) Integer leaveBalanceUsedDays
) {
    LeaveBalanceFilterRequest filter = new LeaveBalanceFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setLeaveBalanceCreatedAt(leaveBalanceCreatedAt);
    filter.setLeaveBalanceEmployeeId(leaveBalanceEmployeeId);
    filter.setLeaveBalanceId(leaveBalanceId);
    filter.setLeaveBalanceRemainingDays(leaveBalanceRemainingDays);
    filter.setLeaveBalanceStatus(leaveBalanceStatus);
    filter.setLeaveBalanceTotalDays(leaveBalanceTotalDays);
    filter.setLeaveBalanceTypeId(leaveBalanceTypeId);
    filter.setLeaveBalanceUpdatedAt(leaveBalanceUpdatedAt);
    filter.setLeaveBalanceUsedDays(leaveBalanceUsedDays);

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
    return leavebalanceService.search(filter);
}
}
