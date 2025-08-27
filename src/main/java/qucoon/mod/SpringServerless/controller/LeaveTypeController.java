
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
@RequestMapping("/leave-type")
@Validated
public class LeaveTypeController {

    private final LeaveTypeService leavetypeService;
    private final Environment environment;

    public LeaveTypeController(LeaveTypeService leavetypeService,Environment environment) {
        this.leavetypeService = leavetypeService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody LeaveTypeCreateRequest request) {
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
    return leavetypeService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<LeaveTypeCreateRequest> request
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
    return leavetypeService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody LeaveTypeUpdateRequest request) {
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
    return leavetypeService.update(request);
}

@GetMapping("/read")
public LeaveTypeReadListResponse read(
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
    return leavetypeService.read();
}

@DeleteMapping("/delete/{leaveTypeId}")
public BaseResponse softDeleteLeavetype(
@RequestHeader("Authorization") String authorization,
@PathVariable int  leaveTypeId) {
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
    return leavetypeService.delete(leaveTypeId);
}



@GetMapping("/read-by-leave-type-accrual-rate-per-month/{leaveTypeAccrualRatePerMonth}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeAccrualRatePerMonth(
@RequestHeader("Authorization") String authorization,
@PathVariable Double leaveTypeAccrualRatePerMonth) {
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
    return leavetypeService.readByLeaveTypeAccrualRatePerMonth(leaveTypeAccrualRatePerMonth);
}


@GetMapping("/read-by-leave-type-created-at/{leaveTypeCreatedAt}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveTypeCreatedAt) {
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
    return leavetypeService.readByLeaveTypeCreatedAt(leaveTypeCreatedAt);
}


@GetMapping("/read-by-leave-type-description/{leaveTypeDescription}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveTypeDescription) {
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
    return leavetypeService.readByLeaveTypeDescription(leaveTypeDescription);
}


@GetMapping("/read-by-leave-type-id/{leaveTypeId}")
public LeaveTypeReadSingleResponse getLeavetypeLeaveTypeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveTypeId) {
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
    return leavetypeService.readByLeaveTypeId(leaveTypeId);
}


@GetMapping("/read-by-leave-type-name/{leaveTypeName}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeName(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveTypeName) {
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
    return leavetypeService.readByLeaveTypeName(leaveTypeName);
}


@GetMapping("/read-by-leave-type-reset-policy/{leaveTypeResetPolicy}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeResetPolicy(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveTypeResetPolicy) {
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
    return leavetypeService.readByLeaveTypeResetPolicy(leaveTypeResetPolicy);
}


@GetMapping("/read-by-leave-type-status/{leaveTypeStatus}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveTypeStatus) {
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
    return leavetypeService.readByLeaveTypeStatus(leaveTypeStatus);
}


@GetMapping("/read-by-leave-type-updated-at/{leaveTypeUpdatedAt}")
public LeaveTypeReadListResponse getLeavetypeLeaveTypeUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveTypeUpdatedAt) {
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
    return leavetypeService.readByLeaveTypeUpdatedAt(leaveTypeUpdatedAt);
}

@GetMapping("/search")
public LeaveTypeReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "leaveTypeId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Double leaveTypeAccrualRatePerMonth,
        @RequestParam(required = false) String leaveTypeCreatedAt,
        @RequestParam(required = false) String leaveTypeDescription,
        @RequestParam(required = false) Integer leaveTypeId,
        @RequestParam(required = false) String leaveTypeName,
        @RequestParam(required = false) String leaveTypeResetPolicy,
        @RequestParam(required = false) String leaveTypeStatus,
        @RequestParam(required = false) String leaveTypeUpdatedAt
) {
    LeaveTypeFilterRequest filter = new LeaveTypeFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setLeaveTypeAccrualRatePerMonth(leaveTypeAccrualRatePerMonth);
    filter.setLeaveTypeCreatedAt(leaveTypeCreatedAt);
    filter.setLeaveTypeDescription(leaveTypeDescription);
    filter.setLeaveTypeId(leaveTypeId);
    filter.setLeaveTypeName(leaveTypeName);
    filter.setLeaveTypeResetPolicy(leaveTypeResetPolicy);
    filter.setLeaveTypeStatus(leaveTypeStatus);
    filter.setLeaveTypeUpdatedAt(leaveTypeUpdatedAt);

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
    return leavetypeService.search(filter);
}
}
