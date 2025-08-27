
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
@RequestMapping("/appraisal")
@Validated
public class AppraisalController {

    private final AppraisalService appraisalService;
    private final Environment environment;

    public AppraisalController(AppraisalService appraisalService,Environment environment) {
        this.appraisalService = appraisalService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AppraisalCreateRequest request) {
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
    return appraisalService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<AppraisalCreateRequest> request
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
    return appraisalService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AppraisalUpdateRequest request) {
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
    return appraisalService.update(request);
}

@GetMapping("/read")
public AppraisalReadListResponse read(
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
    return appraisalService.read();
}

@DeleteMapping("/delete/{appraisalId}")
public BaseResponse softDeleteAppraisal(
@RequestHeader("Authorization") String authorization,
@PathVariable int  appraisalId) {
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
    return appraisalService.delete(appraisalId);
}



@GetMapping("/read-by-appraisal-created-at/{appraisalCreatedAt}")
public AppraisalReadListResponse getAppraisalAppraisalCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalCreatedAt) {
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
    return appraisalService.readByAppraisalCreatedAt(appraisalCreatedAt);
}


@GetMapping("/read-by-appraisal-date/{appraisalDate}")
public AppraisalReadListResponse getAppraisalAppraisalDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalDate) {
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
    return appraisalService.readByAppraisalDate(appraisalDate);
}


@GetMapping("/read-by-appraisal-employee-id-role-id/{appraisalEmployeeIdRoleId}")
public AppraisalReadListResponse getAppraisalAppraisalEmployeeIdRoleId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalEmployeeIdRoleId) {
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
    return appraisalService.readByAppraisalEmployeeIdRoleId(appraisalEmployeeIdRoleId);
}


@GetMapping("/read-by-appraisal-form-id/{appraisalFormId}")
public AppraisalReadListResponse getAppraisalAppraisalFormId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalFormId) {
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
    return appraisalService.readByAppraisalFormId(appraisalFormId);
}


@GetMapping("/read-by-appraisal-general-feedback/{appraisalGeneralFeedback}")
public AppraisalReadListResponse getAppraisalAppraisalGeneralFeedback(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalGeneralFeedback) {
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
    return appraisalService.readByAppraisalGeneralFeedback(appraisalGeneralFeedback);
}


@GetMapping("/read-by-appraisal-id/{appraisalId}")
public AppraisalReadSingleResponse getAppraisalAppraisalId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalId) {
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
    return appraisalService.readByAppraisalId(appraisalId);
}


@GetMapping("/read-by-appraisal-overall-score/{appraisalOverallScore}")
public AppraisalReadListResponse getAppraisalAppraisalOverallScore(
@RequestHeader("Authorization") String authorization,
@PathVariable Double appraisalOverallScore) {
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
    return appraisalService.readByAppraisalOverallScore(appraisalOverallScore);
}


@GetMapping("/read-by-appraisal-reviewer-id/{appraisalReviewerId}")
public AppraisalReadListResponse getAppraisalAppraisalReviewerId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalReviewerId) {
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
    return appraisalService.readByAppraisalReviewerId(appraisalReviewerId);
}


@GetMapping("/read-by-appraisal-status/{appraisalStatus}")
public AppraisalReadListResponse getAppraisalAppraisalStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalStatus) {
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
    return appraisalService.readByAppraisalStatus(appraisalStatus);
}


@GetMapping("/read-by-appraisal-updated-at/{appraisalUpdatedAt}")
public AppraisalReadListResponse getAppraisalAppraisalUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalUpdatedAt) {
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
    return appraisalService.readByAppraisalUpdatedAt(appraisalUpdatedAt);
}

@GetMapping("/search")
public AppraisalReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "appraisalId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String appraisalCreatedAt,
        @RequestParam(required = false) String appraisalDate,
        @RequestParam(required = false) Integer appraisalEmployeeIdRoleId,
        @RequestParam(required = false) Integer appraisalFormId,
        @RequestParam(required = false) String appraisalGeneralFeedback,
        @RequestParam(required = false) Integer appraisalId,
        @RequestParam(required = false) Double appraisalOverallScore,
        @RequestParam(required = false) Integer appraisalReviewerId,
        @RequestParam(required = false) String appraisalStatus,
        @RequestParam(required = false) String appraisalUpdatedAt
) {
    AppraisalFilterRequest filter = new AppraisalFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setAppraisalCreatedAt(appraisalCreatedAt);
    filter.setAppraisalDate(appraisalDate);
    filter.setAppraisalEmployeeIdRoleId(appraisalEmployeeIdRoleId);
    filter.setAppraisalFormId(appraisalFormId);
    filter.setAppraisalGeneralFeedback(appraisalGeneralFeedback);
    filter.setAppraisalId(appraisalId);
    filter.setAppraisalOverallScore(appraisalOverallScore);
    filter.setAppraisalReviewerId(appraisalReviewerId);
    filter.setAppraisalStatus(appraisalStatus);
    filter.setAppraisalUpdatedAt(appraisalUpdatedAt);

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
    return appraisalService.search(filter);
}
}
