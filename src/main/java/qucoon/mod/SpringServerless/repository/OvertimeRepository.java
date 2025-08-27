
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.OvertimePage;
import qucoon.mod.SpringServerless.model.request.OvertimeFilterRequest;

import java.util.List;

@Repository
    public interface OvertimeRepository {


    // Additional query methods can be defined here.
    int create(Overtime overtime);
    void bulkCreate(List<Overtime>  overtime);
    int update(Overtime  overtime);
    int delete(int overtimeId);
    OvertimePage findOvertime(OvertimeFilterRequest filter);
    boolean truncate();
    List<Overtime> read();
    List<Overtime> readByOvertimeCreatedAt(String overtimeCreatedAt);
    List<Overtime> readByOvertimeDate(String overtimeDate);
    List<Overtime> readByOvertimeEmployeeId(int overtimeEmployeeId);
    List<Overtime> readByOvertimeHours(Double overtimeHours);
    Overtime readByOvertimeId(int overtimeId);
    List<Overtime> readByOvertimeStatus(String overtimeStatus);
    List<Overtime> readByOvertimeUpdatedAt(String overtimeUpdatedAt);
}
