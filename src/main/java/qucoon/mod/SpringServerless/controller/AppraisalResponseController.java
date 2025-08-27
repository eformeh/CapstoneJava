
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
@RequestMapping("/appraisal-response")
@Validated
public class AppraisalResponseController {

    private final AppraisalResponseService appraisalresponseService;
    private final Environment environment;

    public AppraisalResponseController(AppraisalResponseService appraisalresponseService,Environment environment) {
        this.appraisalresponseService = appraisalresponseService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AppraisalResponseCreateRequest request) {
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
    return appraisalresponseService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<AppraisalResponseCreateRequest> request
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
    return appraisalresponseService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AppraisalResponseUpdateRequest request) {
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
    return appraisalresponseService.update(request);
}

@GetMapping("/read")
public AppraisalResponseReadListResponse read(
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
    return appraisalresponseService.read();
}

@DeleteMapping("/delete/{appraisalResponseId}")
public BaseResponse softDeleteAppraisalresponse(
@RequestHeader("Authorization") String authorization,
@PathVariable int  appraisalResponseId) {
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
    return appraisalresponseService.delete(appraisalResponseId);
}



@GetMapping("/read-by-appraisal-response-appraisal-id/{appraisalResponseAppraisalId}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseAppraisalId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalResponseAppraisalId) {
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
    return appraisalresponseService.readByAppraisalResponseAppraisalId(appraisalResponseAppraisalId);
}


@GetMapping("/read-by-appraisal-response-created-at/{appraisalResponseCreatedAt}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalResponseCreatedAt) {
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
    return appraisalresponseService.readByAppraisalResponseCreatedAt(appraisalResponseCreatedAt);
}


@GetMapping("/read-by-appraisal-response-id/{appraisalResponseId}")
public AppraisalResponseReadSingleResponse getAppraisalresponseAppraisalResponseId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalResponseId) {
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
    return appraisalresponseService.readByAppraisalResponseId(appraisalResponseId);
}


@GetMapping("/read-by-appraisal-response-question-id/{appraisalResponseQuestionId}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseQuestionId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalResponseQuestionId) {
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
    return appraisalresponseService.readByAppraisalResponseQuestionId(appraisalResponseQuestionId);
}


@GetMapping("/read-by-appraisal-response-score/{appraisalResponseScore}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseScore(
@RequestHeader("Authorization") String authorization,
@PathVariable Double appraisalResponseScore) {
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
    return appraisalresponseService.readByAppraisalResponseScore(appraisalResponseScore);
}


@GetMapping("/read-by-appraisal-response-status/{appraisalResponseStatus}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalResponseStatus) {
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
    return appraisalresponseService.readByAppraisalResponseStatus(appraisalResponseStatus);
}


@GetMapping("/read-by-appraisal-response-updated-at/{appraisalResponseUpdatedAt}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalResponseUpdatedAt) {
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
    return appraisalresponseService.readByAppraisalResponseUpdatedAt(appraisalResponseUpdatedAt);
}


@GetMapping("/read-by-appraisal-response-value/{appraisalResponseValue}")
public AppraisalResponseReadListResponse getAppraisalresponseAppraisalResponseValue(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalResponseValue) {
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
    return appraisalresponseService.readByAppraisalResponseValue(appraisalResponseValue);
}

@GetMapping("/search")
public AppraisalResponseReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "appraisalResponseId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Integer appraisalResponseAppraisalId,
        @RequestParam(required = false) String appraisalResponseCreatedAt,
        @RequestParam(required = false) Integer appraisalResponseId,
        @RequestParam(required = false) Integer appraisalResponseQuestionId,
        @RequestParam(required = false) Double appraisalResponseScore,
        @RequestParam(required = false) String appraisalResponseStatus,
        @RequestParam(required = false) String appraisalResponseUpdatedAt,
        @RequestParam(required = false) String appraisalResponseValue
) {
    AppraisalResponseFilterRequest filter = new AppraisalResponseFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setAppraisalResponseAppraisalId(appraisalResponseAppraisalId);
    filter.setAppraisalResponseCreatedAt(appraisalResponseCreatedAt);
    filter.setAppraisalResponseId(appraisalResponseId);
    filter.setAppraisalResponseQuestionId(appraisalResponseQuestionId);
    filter.setAppraisalResponseScore(appraisalResponseScore);
    filter.setAppraisalResponseStatus(appraisalResponseStatus);
    filter.setAppraisalResponseUpdatedAt(appraisalResponseUpdatedAt);
    filter.setAppraisalResponseValue(appraisalResponseValue);

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
    return appraisalresponseService.search(filter);
}
}
