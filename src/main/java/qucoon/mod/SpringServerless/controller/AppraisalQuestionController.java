
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
@RequestMapping("/appraisal-question")
@Validated
public class AppraisalQuestionController {

    private final AppraisalQuestionService appraisalquestionService;
    private final Environment environment;

    public AppraisalQuestionController(AppraisalQuestionService appraisalquestionService,Environment environment) {
        this.appraisalquestionService = appraisalquestionService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AppraisalQuestionCreateRequest request) {
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
    return appraisalquestionService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<AppraisalQuestionCreateRequest> request
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
    return appraisalquestionService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody AppraisalQuestionUpdateRequest request) {
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
    return appraisalquestionService.update(request);
}

@GetMapping("/read")
public AppraisalQuestionReadListResponse read(
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
    return appraisalquestionService.read();
}

@DeleteMapping("/delete/{appraisalQuestionId}")
public BaseResponse softDeleteAppraisalquestion(
@RequestHeader("Authorization") String authorization,
@PathVariable int  appraisalQuestionId) {
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
    return appraisalquestionService.delete(appraisalQuestionId);
}



@GetMapping("/read-by-appraisal-form-id/{appraisalFormId}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalFormId(
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
    return appraisalquestionService.readByAppraisalFormId(appraisalFormId);
}


@GetMapping("/read-by-appraisal-question-created-at/{appraisalQuestionCreatedAt}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalQuestionCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalQuestionCreatedAt) {
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
    return appraisalquestionService.readByAppraisalQuestionCreatedAt(appraisalQuestionCreatedAt);
}


@GetMapping("/read-by-appraisal-question-id/{appraisalQuestionId}")
public AppraisalQuestionReadSingleResponse getAppraisalquestionAppraisalQuestionId(
@RequestHeader("Authorization") String authorization,
@PathVariable int appraisalQuestionId) {
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
    return appraisalquestionService.readByAppraisalQuestionId(appraisalQuestionId);
}


@GetMapping("/read-by-appraisal-question-status/{appraisalQuestionStatus}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalQuestionStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalQuestionStatus) {
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
    return appraisalquestionService.readByAppraisalQuestionStatus(appraisalQuestionStatus);
}


@GetMapping("/read-by-appraisal-question-text/{appraisalQuestionText}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalQuestionText(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalQuestionText) {
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
    return appraisalquestionService.readByAppraisalQuestionText(appraisalQuestionText);
}


@GetMapping("/read-by-appraisal-question-type/{appraisalQuestionType}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalQuestionType(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalQuestionType) {
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
    return appraisalquestionService.readByAppraisalQuestionType(appraisalQuestionType);
}


@GetMapping("/read-by-appraisal-question-updated-at/{appraisalQuestionUpdatedAt}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalQuestionUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String appraisalQuestionUpdatedAt) {
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
    return appraisalquestionService.readByAppraisalQuestionUpdatedAt(appraisalQuestionUpdatedAt);
}


@GetMapping("/read-by-appraisal-question-weight/{appraisalQuestionWeight}")
public AppraisalQuestionReadListResponse getAppraisalquestionAppraisalQuestionWeight(
@RequestHeader("Authorization") String authorization,
@PathVariable Double appraisalQuestionWeight) {
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
    return appraisalquestionService.readByAppraisalQuestionWeight(appraisalQuestionWeight);
}

@GetMapping("/search")
public AppraisalQuestionReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "appraisalQuestionId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Integer appraisalFormId,
        @RequestParam(required = false) String appraisalQuestionCreatedAt,
        @RequestParam(required = false) Integer appraisalQuestionId,
        @RequestParam(required = false) String appraisalQuestionStatus,
        @RequestParam(required = false) String appraisalQuestionText,
        @RequestParam(required = false) String appraisalQuestionType,
        @RequestParam(required = false) String appraisalQuestionUpdatedAt,
        @RequestParam(required = false) Double appraisalQuestionWeight
) {
    AppraisalQuestionFilterRequest filter = new AppraisalQuestionFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setAppraisalFormId(appraisalFormId);
    filter.setAppraisalQuestionCreatedAt(appraisalQuestionCreatedAt);
    filter.setAppraisalQuestionId(appraisalQuestionId);
    filter.setAppraisalQuestionStatus(appraisalQuestionStatus);
    filter.setAppraisalQuestionText(appraisalQuestionText);
    filter.setAppraisalQuestionType(appraisalQuestionType);
    filter.setAppraisalQuestionUpdatedAt(appraisalQuestionUpdatedAt);
    filter.setAppraisalQuestionWeight(appraisalQuestionWeight);

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
    return appraisalquestionService.search(filter);
}
}
