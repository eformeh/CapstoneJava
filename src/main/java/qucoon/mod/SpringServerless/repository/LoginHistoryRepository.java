
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.LoginHistoryPage;
import qucoon.mod.SpringServerless.model.request.LoginHistoryFilterRequest;

import java.util.List;

@Repository
    public interface LoginHistoryRepository {


    // Additional query methods can be defined here.
    int create(LoginHistory loginhistory);
    void bulkCreate(List<LoginHistory>  loginhistory);
    int update(LoginHistory  loginhistory);
    int delete(int loginHistoryId);
    LoginHistoryPage findLoginHistory(LoginHistoryFilterRequest filter);
    boolean truncate();
    List<LoginHistory> read();
    List<LoginHistory> readByLoginHistoryCreatedAt(String loginHistoryCreatedAt);
    List<LoginHistory> readByLoginHistoryDeviceId(String loginHistoryDeviceId);
    LoginHistory readByLoginHistoryId(int loginHistoryId);
    List<LoginHistory> readByLoginHistoryIpAddress(String loginHistoryIpAddress);
    List<LoginHistory> readByLoginHistoryLatitude(String loginHistoryLatitude);
    List<LoginHistory> readByLoginHistoryLongitude(String loginHistoryLongitude);
    List<LoginHistory> readByLoginHistoryStatus(String loginHistoryStatus);
    List<LoginHistory> readByLoginHistoryUpdatedAt(String loginHistoryUpdatedAt);
    List<LoginHistory> readByLoginHistoryUsername(String loginHistoryUsername);
}
