
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
@RequestMapping("/journal-entry-line")
@Validated
public class JournalEntryLineController {

    private final JournalEntryLineService journalentrylineService;
    private final Environment environment;

    public JournalEntryLineController(JournalEntryLineService journalentrylineService,Environment environment) {
        this.journalentrylineService = journalentrylineService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody JournalEntryLineCreateRequest request) {
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
    return journalentrylineService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<JournalEntryLineCreateRequest> request
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
    return journalentrylineService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody JournalEntryLineUpdateRequest request) {
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
    return journalentrylineService.update(request);
}

@GetMapping("/read")
public JournalEntryLineReadListResponse read(
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
    return journalentrylineService.read();
}

@DeleteMapping("/delete/{journalEntryLineId}")
public BaseResponse softDeleteJournalentryline(
@RequestHeader("Authorization") String authorization,
@PathVariable int  journalEntryLineId) {
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
    return journalentrylineService.delete(journalEntryLineId);
}



@GetMapping("/read-by-journal-entry-line-account-id/{journalEntryLineAccountId}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineAccountId(
@RequestHeader("Authorization") String authorization,
@PathVariable int journalEntryLineAccountId) {
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
    return journalentrylineService.readByJournalEntryLineAccountId(journalEntryLineAccountId);
}


@GetMapping("/read-by-journal-entry-line-amount/{journalEntryLineAmount}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineAmount(
@RequestHeader("Authorization") String authorization,
@PathVariable Double journalEntryLineAmount) {
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
    return journalentrylineService.readByJournalEntryLineAmount(journalEntryLineAmount);
}


@GetMapping("/read-by-journal-entry-line-created-at/{journalEntryLineCreatedAt}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String journalEntryLineCreatedAt) {
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
    return journalentrylineService.readByJournalEntryLineCreatedAt(journalEntryLineCreatedAt);
}


@GetMapping("/read-by-journal-entry-line-entry-type/{journalEntryLineEntryType}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineEntryType(
@RequestHeader("Authorization") String authorization,
@PathVariable String journalEntryLineEntryType) {
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
    return journalentrylineService.readByJournalEntryLineEntryType(journalEntryLineEntryType);
}


@GetMapping("/read-by-journal-entry-line-id/{journalEntryLineId}")
public JournalEntryLineReadSingleResponse getJournalentrylineJournalEntryLineId(
@RequestHeader("Authorization") String authorization,
@PathVariable int journalEntryLineId) {
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
    return journalentrylineService.readByJournalEntryLineId(journalEntryLineId);
}


@GetMapping("/read-by-journal-entry-line-status/{journalEntryLineStatus}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String journalEntryLineStatus) {
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
    return journalentrylineService.readByJournalEntryLineStatus(journalEntryLineStatus);
}


@GetMapping("/read-by-journal-entry-line-transaction-id/{journalEntryLineTransactionId}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineTransactionId(
@RequestHeader("Authorization") String authorization,
@PathVariable int journalEntryLineTransactionId) {
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
    return journalentrylineService.readByJournalEntryLineTransactionId(journalEntryLineTransactionId);
}


@GetMapping("/read-by-journal-entry-line-updated-at/{journalEntryLineUpdatedAt}")
public JournalEntryLineReadListResponse getJournalentrylineJournalEntryLineUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String journalEntryLineUpdatedAt) {
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
    return journalentrylineService.readByJournalEntryLineUpdatedAt(journalEntryLineUpdatedAt);
}

@GetMapping("/search")
public JournalEntryLineReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "journalEntryLineId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) Integer journalEntryLineAccountId,
        @RequestParam(required = false) Double journalEntryLineAmount,
        @RequestParam(required = false) String journalEntryLineCreatedAt,
        @RequestParam(required = false) String journalEntryLineEntryType,
        @RequestParam(required = false) Integer journalEntryLineId,
        @RequestParam(required = false) String journalEntryLineStatus,
        @RequestParam(required = false) Integer journalEntryLineTransactionId,
        @RequestParam(required = false) String journalEntryLineUpdatedAt
) {
    JournalEntryLineFilterRequest filter = new JournalEntryLineFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setJournalEntryLineAccountId(journalEntryLineAccountId);
    filter.setJournalEntryLineAmount(journalEntryLineAmount);
    filter.setJournalEntryLineCreatedAt(journalEntryLineCreatedAt);
    filter.setJournalEntryLineEntryType(journalEntryLineEntryType);
    filter.setJournalEntryLineId(journalEntryLineId);
    filter.setJournalEntryLineStatus(journalEntryLineStatus);
    filter.setJournalEntryLineTransactionId(journalEntryLineTransactionId);
    filter.setJournalEntryLineUpdatedAt(journalEntryLineUpdatedAt);

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
    return journalentrylineService.search(filter);
}
}
