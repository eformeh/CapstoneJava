
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
@RequestMapping("/employee-onboarding")
@Validated
public class EmployeeOnboardingController {

    private final EmployeeOnboardingService employeeonboardingService;
    private final Environment environment;

    public EmployeeOnboardingController(EmployeeOnboardingService employeeonboardingService,Environment environment) {
        this.employeeonboardingService = employeeonboardingService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeOnboardingCreateRequest request) {
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
    return employeeonboardingService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<EmployeeOnboardingCreateRequest> request
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
    return employeeonboardingService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeOnboardingUpdateRequest request) {
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
    return employeeonboardingService.update(request);
}

@GetMapping("/read")
public EmployeeOnboardingReadListResponse read(
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
    return employeeonboardingService.read();
}

@DeleteMapping("/delete/{employeeOnboardingId}")
public BaseResponse softDeleteEmployeeonboarding(
@RequestHeader("Authorization") String authorization,
@PathVariable int  employeeOnboardingId) {
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
    return employeeonboardingService.delete(employeeOnboardingId);
}



@GetMapping("/read-by-employee-onboarding-assigned-by/{employeeOnboardingAssignedBy}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingAssignedBy(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeOnboardingAssignedBy) {
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
    return employeeonboardingService.readByEmployeeOnboardingAssignedBy(employeeOnboardingAssignedBy);
}


@GetMapping("/read-by-employee-onboarding-attachment-url/{employeeOnboardingAttachmentUrl}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingAttachmentUrl(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingAttachmentUrl) {
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
    return employeeonboardingService.readByEmployeeOnboardingAttachmentUrl(employeeOnboardingAttachmentUrl);
}


@GetMapping("/read-by-employee-onboarding-completed-date/{employeeOnboardingCompletedDate}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingCompletedDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingCompletedDate) {
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
    return employeeonboardingService.readByEmployeeOnboardingCompletedDate(employeeOnboardingCompletedDate);
}


@GetMapping("/read-by-employee-onboarding-created-at/{employeeOnboardingCreatedAt}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingCreatedAt) {
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
    return employeeonboardingService.readByEmployeeOnboardingCreatedAt(employeeOnboardingCreatedAt);
}


@GetMapping("/read-by-employee-onboarding-due-date/{employeeOnboardingDueDate}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingDueDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingDueDate) {
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
    return employeeonboardingService.readByEmployeeOnboardingDueDate(employeeOnboardingDueDate);
}


@GetMapping("/read-by-employee-onboarding-employee-id/{employeeOnboardingEmployeeId}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeOnboardingEmployeeId) {
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
    return employeeonboardingService.readByEmployeeOnboardingEmployeeId(employeeOnboardingEmployeeId);
}


@GetMapping("/read-by-employee-onboarding-id/{employeeOnboardingId}")
public EmployeeOnboardingReadSingleResponse getEmployeeonboardingEmployeeOnboardingId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeOnboardingId) {
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
    return employeeonboardingService.readByEmployeeOnboardingId(employeeOnboardingId);
}


@GetMapping("/read-by-employee-onboarding-notes/{employeeOnboardingNotes}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingNotes(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingNotes) {
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
    return employeeonboardingService.readByEmployeeOnboardingNotes(employeeOnboardingNotes);
}


@GetMapping("/read-by-employee-onboarding-status/{employeeOnboardingStatus}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingStatus) {
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
    return employeeonboardingService.readByEmployeeOnboardingStatus(employeeOnboardingStatus);
}


@GetMapping("/read-by-employee-onboarding-task-id/{employeeOnboardingTaskId}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingTaskId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeOnboardingTaskId) {
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
    return employeeonboardingService.readByEmployeeOnboardingTaskId(employeeOnboardingTaskId);
}


@GetMapping("/read-by-employee-onboarding-updated-at/{employeeOnboardingUpdatedAt}")
public EmployeeOnboardingReadListResponse getEmployeeonboardingEmployeeOnboardingUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeOnboardingUpdatedAt) {
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
    return employeeonboardingService.readByEmployeeOnboardingUpdatedAt(employeeOnboardingUpdatedAt);
}

@GetMapping("/search")
public EmployeeOnboardingReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = System.getenv("API_KEY_EMPLOYEE")) String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Integer employeeOnboardingAssignedBy,
        @RequestParam(required = false) String employeeOnboardingAttachmentUrl,
        @RequestParam(required = false) String employeeOnboardingCompletedDate,
        @RequestParam(required = false) String employeeOnboardingCreatedAt,
        @RequestParam(required = false) String employeeOnboardingDueDate,
        @RequestParam(required = false) Integer employeeOnboardingEmployeeId,
        @RequestParam(required = false) Integer employeeOnboardingId,
        @RequestParam(required = false) String employeeOnboardingNotes,
        @RequestParam(required = false) String employeeOnboardingStatus,
        @RequestParam(required = false) Integer employeeOnboardingTaskId,
        @RequestParam(required = false) String employeeOnboardingUpdatedAt
) {
    EmployeeOnboardingFilterRequest filter = new EmployeeOnboardingFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setEmployeeOnboardingAssignedBy(employeeOnboardingAssignedBy);
    filter.setEmployeeOnboardingAttachmentUrl(employeeOnboardingAttachmentUrl);
    filter.setEmployeeOnboardingCompletedDate(employeeOnboardingCompletedDate);
    filter.setEmployeeOnboardingCreatedAt(employeeOnboardingCreatedAt);
    filter.setEmployeeOnboardingDueDate(employeeOnboardingDueDate);
    filter.setEmployeeOnboardingEmployeeId(employeeOnboardingEmployeeId);
    filter.setEmployeeOnboardingId(employeeOnboardingId);
    filter.setEmployeeOnboardingNotes(employeeOnboardingNotes);
    filter.setEmployeeOnboardingStatus(employeeOnboardingStatus);
    filter.setEmployeeOnboardingTaskId(employeeOnboardingTaskId);
    filter.setEmployeeOnboardingUpdatedAt(employeeOnboardingUpdatedAt);

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
    return employeeonboardingService.search(filter);
}
}
