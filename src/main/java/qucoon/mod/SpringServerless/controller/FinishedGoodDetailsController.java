
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
@RequestMapping("/finished-good-details")
@Validated
public class FinishedGoodDetailsController {

    private final FinishedGoodDetailsService finishedgooddetailsService;
    private final Environment environment;

    public FinishedGoodDetailsController(FinishedGoodDetailsService finishedgooddetailsService,Environment environment) {
        this.finishedgooddetailsService = finishedgooddetailsService;
        this.environment = environment;
    }


@PostMapping("/create")
public BaseResponse create(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody FinishedGoodDetailsCreateRequest request) {
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
    return finishedgooddetailsService.create(request);
}


@PostMapping("/bulk-create")
public BaseResponse bulkCreate(
@RequestHeader("Authorization") String authorization,
        @Valid @RequestBody List<FinishedGoodDetailsCreateRequest> request
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
    return finishedgooddetailsService.bulkCreate(request);
}

@PostMapping("/update")
public BaseResponse update(
@RequestHeader("Authorization") String authorization,
@Valid @RequestBody FinishedGoodDetailsUpdateRequest request) {
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
    return finishedgooddetailsService.update(request);
}

@GetMapping("/read")
public FinishedGoodDetailsReadListResponse read(
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
    return finishedgooddetailsService.read();
}

@DeleteMapping("/delete/{finishedGoodDetailsId}")
public BaseResponse softDeleteFinishedgooddetails(
@RequestHeader("Authorization") String authorization,
@PathVariable int  finishedGoodDetailsId) {
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
    return finishedgooddetailsService.delete(finishedGoodDetailsId);
}



@GetMapping("/read-by-finished-good-details-created-at/{finishedGoodDetailsCreatedAt}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsCreatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String finishedGoodDetailsCreatedAt) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsCreatedAt(finishedGoodDetailsCreatedAt);
}


@GetMapping("/read-by-finished-good-details-expiry-date/{finishedGoodDetailsExpiryDate}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsExpiryDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String finishedGoodDetailsExpiryDate) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsExpiryDate(finishedGoodDetailsExpiryDate);
}


@GetMapping("/read-by-finished-good-details-id/{finishedGoodDetailsId}")
public FinishedGoodDetailsReadSingleResponse getFinishedgooddetailsFinishedGoodDetailsId(
@RequestHeader("Authorization") String authorization,
@PathVariable int finishedGoodDetailsId) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsId(finishedGoodDetailsId);
}


@GetMapping("/read-by-finished-good-details-inventory-item-id/{finishedGoodDetailsInventoryItemId}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsInventoryItemId(
@RequestHeader("Authorization") String authorization,
@PathVariable int finishedGoodDetailsInventoryItemId) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsInventoryItemId(finishedGoodDetailsInventoryItemId);
}


@GetMapping("/read-by-finished-good-details-manufacturing-date/{finishedGoodDetailsManufacturingDate}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsManufacturingDate(
@RequestHeader("Authorization") String authorization,
@PathVariable String finishedGoodDetailsManufacturingDate) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsManufacturingDate(finishedGoodDetailsManufacturingDate);
}


@GetMapping("/read-by-finished-good-details-product-id/{finishedGoodDetailsProductId}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsProductId(
@RequestHeader("Authorization") String authorization,
@PathVariable int finishedGoodDetailsProductId) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsProductId(finishedGoodDetailsProductId);
}


@GetMapping("/read-by-finished-good-details-status/{finishedGoodDetailsStatus}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsStatus(
@RequestHeader("Authorization") String authorization,
@PathVariable String finishedGoodDetailsStatus) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsStatus(finishedGoodDetailsStatus);
}


@GetMapping("/read-by-finished-good-details-updated-at/{finishedGoodDetailsUpdatedAt}")
public FinishedGoodDetailsReadListResponse getFinishedgooddetailsFinishedGoodDetailsUpdatedAt(
@RequestHeader("Authorization") String authorization,
@PathVariable String finishedGoodDetailsUpdatedAt) {
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
    return finishedgooddetailsService.readByFinishedGoodDetailsUpdatedAt(finishedGoodDetailsUpdatedAt);
}

@GetMapping("/search")
public FinishedGoodDetailsReadPagedResponse search(
@RequestHeader("Authorization") String authorization,

        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = System.getenv("API_KEY_FINISHED")) String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDir,
        @RequestParam(required = false) String search,

        @RequestParam(required = false) String finishedGoodDetailsCreatedAt,
        @RequestParam(required = false) String finishedGoodDetailsExpiryDate,
        @RequestParam(required = false) Integer finishedGoodDetailsId,
        @RequestParam(required = false) Integer finishedGoodDetailsInventoryItemId,
        @RequestParam(required = false) String finishedGoodDetailsManufacturingDate,
        @RequestParam(required = false) Integer finishedGoodDetailsProductId,
        @RequestParam(required = false) String finishedGoodDetailsStatus,
        @RequestParam(required = false) String finishedGoodDetailsUpdatedAt
) {
    FinishedGoodDetailsFilterRequest filter = new FinishedGoodDetailsFilterRequest();
    filter.setPageNumber(pageNumber);
    filter.setPageSize(pageSize);
    filter.setSortBy(sortBy);
    filter.setSortDir(sortDir);
    filter.setSearch(search);

    filter.setFinishedGoodDetailsCreatedAt(finishedGoodDetailsCreatedAt);
    filter.setFinishedGoodDetailsExpiryDate(finishedGoodDetailsExpiryDate);
    filter.setFinishedGoodDetailsId(finishedGoodDetailsId);
    filter.setFinishedGoodDetailsInventoryItemId(finishedGoodDetailsInventoryItemId);
    filter.setFinishedGoodDetailsManufacturingDate(finishedGoodDetailsManufacturingDate);
    filter.setFinishedGoodDetailsProductId(finishedGoodDetailsProductId);
    filter.setFinishedGoodDetailsStatus(finishedGoodDetailsStatus);
    filter.setFinishedGoodDetailsUpdatedAt(finishedGoodDetailsUpdatedAt);

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
    return finishedgooddetailsService.search(filter);
}
}
