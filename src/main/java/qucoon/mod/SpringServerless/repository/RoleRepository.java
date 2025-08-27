
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.RolePage;
import qucoon.mod.SpringServerless.model.request.RoleFilterRequest;

import java.util.List;

@Repository
    public interface RoleRepository {


    // Additional query methods can be defined here.
    int create(Role role);
    void bulkCreate(List<Role>  role);
    int update(Role  role);
    int delete(int rolePrivilegeId);
    RolePage findRole(RoleFilterRequest filter);
    boolean truncate();
    List<Role> read();
    List<Role> readByRoleCreatedAt(String roleCreatedAt);
    List<Role> readByRoleDescription(String roleDescription);
    List<Role> readByRoleId(int roleId);
    List<Role> readByRoleIsPublic(String roleIsPublic);
    List<Role> readByRoleName(String roleName);
    List<Role> readByRolePrivilegeCreatedAt(String rolePrivilegeCreatedAt);
    Role readByRolePrivilegeId(int rolePrivilegeId);
    List<Role> readByRolePrivilegePrivilegeCode(String rolePrivilegePrivilegeCode);
    List<Role> readByRolePrivilegeRoleId(int rolePrivilegeRoleId);
    List<Role> readByRolePrivilegeStatus(String rolePrivilegeStatus);
    List<Role> readByRolePrivilegeUpdatedAt(String rolePrivilegeUpdatedAt);
    List<Role> readByRoleStatus(String roleStatus);
    List<Role> readByRoleUpdatedAt(String roleUpdatedAt);
}
