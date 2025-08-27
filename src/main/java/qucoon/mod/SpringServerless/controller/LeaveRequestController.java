
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
@RequestMapping("/leave-request")
@Validated
public class LeaveRequestController {

    private final LeaveRequestService leaverequestService;
    private final Environment environment;

    public LeaveRequestController(LeaveRequestService leaverequestService,Environment environment) {
        this.leaverequestService = leaverequestService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody LeaveRequestCreateRequest request) {
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
    return leaverequestService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<LeaveRequestCreateRequest> request
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
    return leaverequestService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody LeaveRequestUpdateRequest request) {
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
    return leaverequestService.update(request);
}

@GetMapping("/read")
public LeaveRequestReadListResponse read(
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
    return leaverequestService.read();
}

@DeleteMapping("/delete/{leaveRequestId}")
public BaseResponse softDeleteLeaverequest(
@RequestHeader("Authorization") String authorization,
@PathVariable int  leaveRequestId) {
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
    return leaverequestService.delete(leaveRequestId);
}



@GetMapping("/read-by-leave-request-created-at/{leaveRequestCreatedAt}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestCreatedAt) {
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
    return leaverequestService.readByLeaveRequestCreatedAt(leaveRequestCreatedAt);
}


@GetMapping("/read-by-leave-request-decision-date/{leaveRequestDecisionDate}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestDecisionDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestDecisionDate) {
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
    return leaverequestService.readByLeaveRequestDecisionDate(leaveRequestDecisionDate);
}


@GetMapping("/read-by-leave-request-employee-id/{leaveRequestEmployeeId}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveRequestEmployeeId) {
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
    return leaverequestService.readByLeaveRequestEmployeeId(leaveRequestEmployeeId);
}


@GetMapping("/read-by-leave-request-end-date/{leaveRequestEndDate}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestEndDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestEndDate) {
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
    return leaverequestService.readByLeaveRequestEndDate(leaveRequestEndDate);
}


@GetMapping("/read-by-leave-request-id/{leaveRequestId}")
public LeaveRequestReadSingleResponse getLeaverequestLeaveRequestId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveRequestId) {
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
    return leaverequestService.readByLeaveRequestId(leaveRequestId);
}


@GetMapping("/read-by-leave-request-reason/{leaveRequestReason}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestReason(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestReason) {
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
    return leaverequestService.readByLeaveRequestReason(leaveRequestReason);
}


@GetMapping("/read-by-leave-request-reviewer-id/{leaveRequestReviewerId}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestReviewerId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveRequestReviewerId) {
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
    return leaverequestService.readByLeaveRequestReviewerId(leaveRequestReviewerId);
}


@GetMapping("/read-by-leave-request-start-date/{leaveRequestStartDate}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestStartDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestStartDate) {
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
    return leaverequestService.readByLeaveRequestStartDate(leaveRequestStartDate);
}


@GetMapping("/read-by-leave-request-status/{leaveRequestStatus}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestStatus) {
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
    return leaverequestService.readByLeaveRequestStatus(leaveRequestStatus);
}


@GetMapping("/read-by-leave-request-submitted-at/{leaveRequestSubmittedAt}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestSubmittedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestSubmittedAt) {
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
    return leaverequestService.readByLeaveRequestSubmittedAt(leaveRequestSubmittedAt);
}


@GetMapping("/read-by-leave-request-type-id/{leaveRequestTypeId}")
public LeaveRequestReadSingleResponse getLeaverequestLeaveRequestTypeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int leaveRequestTypeId) {
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
    return leaverequestService.readByLeaveRequestTypeId(leaveRequestTypeId);
}


@GetMapping("/read-by-leave-request-updated-at/{leaveRequestUpdatedAt}")
public LeaveRequestReadListResponse getLeaverequestLeaveRequestUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String leaveRequestUpdatedAt) {
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
    return leaverequestService.readByLeaveRequestUpdatedAt(leaveRequestUpdatedAt);
}

@GetMapping("/search")
public LeaveRequestReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "leaveRequestId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String leaveRequestCreatedAt,
        @RequestParam(required = false) String leaveRequestDecisionDate,
        @RequestParam(required = false) Integer leaveRequestEmployeeId,
        @RequestParam(required = false) String leaveRequestEndDate,
        @RequestParam(required = false) Integer leaveRequestId,
        @RequestParam(required = false) String leaveRequestReason,
        @RequestParam(required = false) Integer leaveRequestReviewerId,
        @RequestParam(required = false) String leaveRequestStartDate,
        @RequestParam(required = false) String leaveRequestStatus,
        @RequestParam(required = false) String leaveRequestSubmittedAt,
        @RequestParam(required = false) Integer leaveRequestTypeId,
        @RequestParam(required = false) String leaveRequestUpdatedAt
) {
    LeaveRequestFilterRequest filter = new LeaveRequestFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setLeaveRequestCreatedAt(leaveRequestCreatedAt);
    filter.setLeaveRequestDecisionDate(leaveRequestDecisionDate);
    filter.setLeaveRequestEmployeeId(leaveRequestEmployeeId);
    filter.setLeaveRequestEndDate(leaveRequestEndDate);
    filter.setLeaveRequestId(leaveRequestId);
    filter.setLeaveRequestReason(leaveRequestReason);
    filter.setLeaveRequestReviewerId(leaveRequestReviewerId);
    filter.setLeaveRequestStartDate(leaveRequestStartDate);
    filter.setLeaveRequestStatus(leaveRequestStatus);
    filter.setLeaveRequestSubmittedAt(leaveRequestSubmittedAt);
    filter.setLeaveRequestTypeId(leaveRequestTypeId);
    filter.setLeaveRequestUpdatedAt(leaveRequestUpdatedAt);

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
    return leaverequestService.search(filter);
}
}
