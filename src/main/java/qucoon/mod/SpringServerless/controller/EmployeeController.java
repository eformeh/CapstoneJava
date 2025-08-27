
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
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Environment environment;

    public EmployeeController(EmployeeService employeeService,Environment environment) {
        this.employeeService = employeeService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeCreateRequest request) {
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
    return employeeService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<EmployeeCreateRequest> request
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
    return employeeService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody EmployeeUpdateRequest request) {
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
    return employeeService.update(request);
}

@GetMapping("/read")
public EmployeeReadListResponse read(
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
    return employeeService.read();
}

@DeleteMapping("/delete/{employeeId}")
public BaseResponse softDeleteEmployee(
@RequestHeader("Authorization") String authorization,
@PathVariable int  employeeId) {
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
    return employeeService.delete(employeeId);
}



@GetMapping("/read-by-employee-contract-end-date/{employeeContractEndDate}")
public EmployeeReadListResponse getEmployeeEmployeeContractEndDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeContractEndDate) {
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
    return employeeService.readByEmployeeContractEndDate(employeeContractEndDate);
}


@GetMapping("/read-by-employee-created-at/{employeeCreatedAt}")
public EmployeeReadListResponse getEmployeeEmployeeCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeCreatedAt) {
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
    return employeeService.readByEmployeeCreatedAt(employeeCreatedAt);
}


@GetMapping("/read-by-employee-date-of-birth/{employeeDateOfBirth}")
public EmployeeReadListResponse getEmployeeEmployeeDateOfBirth(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeDateOfBirth) {
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
    return employeeService.readByEmployeeDateOfBirth(employeeDateOfBirth);
}


@GetMapping("/read-by-employee-email/{employeeEmail}")
public EmployeeReadSingleResponse getEmployeeEmployeeEmail(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeEmail) {
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
    return employeeService.readByEmployeeEmail(employeeEmail);
}


@GetMapping("/read-by-employee-employment-status/{employeeEmploymentStatus}")
public EmployeeReadListResponse getEmployeeEmployeeEmploymentStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeEmploymentStatus) {
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
    return employeeService.readByEmployeeEmploymentStatus(employeeEmploymentStatus);
}


@GetMapping("/read-by-employee-employment-type/{employeeEmploymentType}")
public EmployeeReadListResponse getEmployeeEmployeeEmploymentType(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeEmploymentType) {
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
    return employeeService.readByEmployeeEmploymentType(employeeEmploymentType);
}


@GetMapping("/read-by-employee-first-name/{employeeFirstName}")
public EmployeeReadListResponse getEmployeeEmployeeFirstName(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeFirstName) {
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
    return employeeService.readByEmployeeFirstName(employeeFirstName);
}


@GetMapping("/read-by-employee-hire-date/{employeeHireDate}")
public EmployeeReadListResponse getEmployeeEmployeeHireDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeHireDate) {
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
    return employeeService.readByEmployeeHireDate(employeeHireDate);
}


@GetMapping("/read-by-employee-id/{employeeId}")
public EmployeeReadSingleResponse getEmployeeEmployeeId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeId) {
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
    return employeeService.readByEmployeeId(employeeId);
}


@GetMapping("/read-by-employee-job-id/{employeeJobId}")
public EmployeeReadListResponse getEmployeeEmployeeJobId(
@RequestHeader("Authorization") String authorization,
@PathVariable int employeeJobId) {
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
    return employeeService.readByEmployeeJobId(employeeJobId);
}


@GetMapping("/read-by-employee-last-name/{employeeLastName}")
public EmployeeReadListResponse getEmployeeEmployeeLastName(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeLastName) {
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
    return employeeService.readByEmployeeLastName(employeeLastName);
}


@GetMapping("/read-by-employee-marital-status/{employeeMaritalStatus}")
public EmployeeReadListResponse getEmployeeEmployeeMaritalStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeMaritalStatus) {
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
    return employeeService.readByEmployeeMaritalStatus(employeeMaritalStatus);
}


@GetMapping("/read-by-employee-nationality/{employeeNationality}")
public EmployeeReadListResponse getEmployeeEmployeeNationality(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeNationality) {
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
    return employeeService.readByEmployeeNationality(employeeNationality);
}


@GetMapping("/read-by-employee-phone/{employeePhone}")
public EmployeeReadSingleResponse getEmployeeEmployeePhone(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeePhone) {
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
    return employeeService.readByEmployeePhone(employeePhone);
}


@GetMapping("/read-by-employee-photo-url/{employeePhotoUrl}")
public EmployeeReadListResponse getEmployeeEmployeePhotoUrl(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeePhotoUrl) {
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
    return employeeService.readByEmployeePhotoUrl(employeePhotoUrl);
}


@GetMapping("/read-by-employee-status/{employeeStatus}")
public EmployeeReadListResponse getEmployeeEmployeeStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeStatus) {
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
    return employeeService.readByEmployeeStatus(employeeStatus);
}


@GetMapping("/read-by-employee-updated-at/{employeeUpdatedAt}")
public EmployeeReadListResponse getEmployeeEmployeeUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String employeeUpdatedAt) {
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
    return employeeService.readByEmployeeUpdatedAt(employeeUpdatedAt);
}

@GetMapping("/search")
public EmployeeReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "employeeId") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String employeeContractEndDate,
        @RequestParam(required = false) String employeeCreatedAt,
        @RequestParam(required = false) String employeeDateOfBirth,
        @RequestParam(required = false) String employeeEmail,
        @RequestParam(required = false) String employeeEmploymentStatus,
        @RequestParam(required = false) String employeeEmploymentType,
        @RequestParam(required = false) String employeeFirstName,
        @RequestParam(required = false) String employeeHireDate,
        @RequestParam(required = false) Integer employeeId,
        @RequestParam(required = false) Integer employeeJobId,
        @RequestParam(required = false) String employeeLastName,
        @RequestParam(required = false) String employeeMaritalStatus,
        @RequestParam(required = false) String employeeNationality,
        @RequestParam(required = false) String employeePhone,
        @RequestParam(required = false) String employeePhotoUrl,
        @RequestParam(required = false) String employeeStatus,
        @RequestParam(required = false) String employeeUpdatedAt
) {
    EmployeeFilterRequest filter = new EmployeeFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setEmployeeContractEndDate(employeeContractEndDate);
    filter.setEmployeeCreatedAt(employeeCreatedAt);
    filter.setEmployeeDateOfBirth(employeeDateOfBirth);
    filter.setEmployeeEmail(employeeEmail);
    filter.setEmployeeEmploymentStatus(employeeEmploymentStatus);
    filter.setEmployeeEmploymentType(employeeEmploymentType);
    filter.setEmployeeFirstName(employeeFirstName);
    filter.setEmployeeHireDate(employeeHireDate);
    filter.setEmployeeId(employeeId);
    filter.setEmployeeJobId(employeeJobId);
    filter.setEmployeeLastName(employeeLastName);
    filter.setEmployeeMaritalStatus(employeeMaritalStatus);
    filter.setEmployeeNationality(employeeNationality);
    filter.setEmployeePhone(employeePhone);
    filter.setEmployeePhotoUrl(employeePhotoUrl);
    filter.setEmployeeStatus(employeeStatus);
    filter.setEmployeeUpdatedAt(employeeUpdatedAt);

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
    return employeeService.search(filter);
}
}
