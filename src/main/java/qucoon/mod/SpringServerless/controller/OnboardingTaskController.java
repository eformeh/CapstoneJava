
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
@RequestMapping("/onboarding-task")
@Validated
public class OnboardingTaskController {

    private final OnboardingTaskService onboardingtaskService;
    private final Environment environment;

    public OnboardingTaskController(OnboardingTaskService onboardingtaskService,Environment environment) {
        this.onboardingtaskService = onboardingtaskService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody OnboardingTaskCreateRequest request) {
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
    return onboardingtaskService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<OnboardingTaskCreateRequest> request
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
    return onboardingtaskService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody OnboardingTaskUpdateRequest request) {
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
    return onboardingtaskService.update(request);
}

@GetMapping("/read")
public OnboardingTaskReadListResponse read(
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
    return onboardingtaskService.read();
}

@DeleteMapping("/delete/{onboardingTaskId}")
public BaseResponse softDeleteOnboardingtask(
@RequestHeader("Authorization") String authorization,
@PathVariable int  onboardingTaskId) {
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
    return onboardingtaskService.delete(onboardingTaskId);
}



@GetMapping("/read-by-onboarding-task-created-at/{onboardingTaskCreatedAt}")
public OnboardingTaskReadListResponse getOnboardingtaskOnboardingTaskCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String onboardingTaskCreatedAt) {
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
    return onboardingtaskService.readByOnboardingTaskCreatedAt(onboardingTaskCreatedAt);
}


@GetMapping("/read-by-onboarding-task-created-by/{onboardingTaskCreatedBy}")
public OnboardingTaskReadListResponse getOnboardingtaskOnboardingTaskCreatedBy(
@RequestHeader("Authorization") String authorization,
@PathVariable int onboardingTaskCreatedBy) {
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
    return onboardingtaskService.readByOnboardingTaskCreatedBy(onboardingTaskCreatedBy);
}


@GetMapping("/read-by-onboarding-task-description/{onboardingTaskDescription}")
public OnboardingTaskReadListResponse getOnboardingtaskOnboardingTaskDescription(
@RequestHeader("Authorization") String authorization,
@PathVariable String onboardingTaskDescription) {
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
    return onboardingtaskService.readByOnboardingTaskDescription(onboardingTaskDescription);
}


@GetMapping("/read-by-onboarding-task-id/{onboardingTaskId}")
public OnboardingTaskReadSingleResponse getOnboardingtaskOnboardingTaskId(
@RequestHeader("Authorization") String authorization,
@PathVariable int onboardingTaskId) {
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
    return onboardingtaskService.readByOnboardingTaskId(onboardingTaskId);
}


@GetMapping("/read-by-onboarding-task-status/{onboardingTaskStatus}")
public OnboardingTaskReadListResponse getOnboardingtaskOnboardingTaskStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String onboardingTaskStatus) {
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
    return onboardingtaskService.readByOnboardingTaskStatus(onboardingTaskStatus);
}


@GetMapping("/read-by-onboarding-task-updated-at/{onboardingTaskUpdatedAt}")
public OnboardingTaskReadListResponse getOnboardingtaskOnboardingTaskUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String onboardingTaskUpdatedAt) {
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
    return onboardingtaskService.readByOnboardingTaskUpdatedAt(onboardingTaskUpdatedAt);
}

@GetMapping("/search")
public OnboardingTaskReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "onboardingTaskId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String onboardingTaskCreatedAt,
        @RequestParam(required = false) Integer onboardingTaskCreatedBy,
        @RequestParam(required = false) String onboardingTaskDescription,
        @RequestParam(required = false) Integer onboardingTaskId,
        @RequestParam(required = false) String onboardingTaskStatus,
        @RequestParam(required = false) String onboardingTaskUpdatedAt
) {
    OnboardingTaskFilterRequest filter = new OnboardingTaskFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setOnboardingTaskCreatedAt(onboardingTaskCreatedAt);
    filter.setOnboardingTaskCreatedBy(onboardingTaskCreatedBy);
    filter.setOnboardingTaskDescription(onboardingTaskDescription);
    filter.setOnboardingTaskId(onboardingTaskId);
    filter.setOnboardingTaskStatus(onboardingTaskStatus);
    filter.setOnboardingTaskUpdatedAt(onboardingTaskUpdatedAt);

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
    return onboardingtaskService.search(filter);
}
}
