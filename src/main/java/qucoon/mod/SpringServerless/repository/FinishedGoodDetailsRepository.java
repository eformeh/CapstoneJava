
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.FinishedGoodDetailsPage;
import qucoon.mod.SpringServerless.model.request.FinishedGoodDetailsFilterRequest;

import java.util.List;

@Repository
    public interface FinishedGoodDetailsRepository {


    // Additional query methods can be defined here.
    int create(FinishedGoodDetails finishedgooddetails);
    void bulkCreate(List<FinishedGoodDetails>  finishedgooddetails);
    int update(FinishedGoodDetails  finishedgooddetails);
    int delete(int finishedGoodDetailsId);
    FinishedGoodDetailsPage findFinishedGoodDetails(FinishedGoodDetailsFilterRequest filter);
    boolean truncate();
    List<FinishedGoodDetails> read();
    List<FinishedGoodDetails> readByFinishedGoodDetailsCreatedAt(String finishedGoodDetailsCreatedAt);
    List<FinishedGoodDetails> readByFinishedGoodDetailsExpiryDate(String finishedGoodDetailsExpiryDate);
    FinishedGoodDetails readByFinishedGoodDetailsId(int finishedGoodDetailsId);
    List<FinishedGoodDetails> readByFinishedGoodDetailsInventoryItemId(int finishedGoodDetailsInventoryItemId);
    List<FinishedGoodDetails> readByFinishedGoodDetailsManufacturingDate(String finishedGoodDetailsManufacturingDate);
    List<FinishedGoodDetails> readByFinishedGoodDetailsProductId(int finishedGoodDetailsProductId);
    List<FinishedGoodDetails> readByFinishedGoodDetailsStatus(String finishedGoodDetailsStatus);
    List<FinishedGoodDetails> readByFinishedGoodDetailsUpdatedAt(String finishedGoodDetailsUpdatedAt);
}
