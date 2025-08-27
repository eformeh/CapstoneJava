
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   FinishedGoodDetailsQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   SET   finishedgooddetailsStatus   =   'DELETED',   finishedgooddetailsUpdatedAt   =   GETDATE() 
WHERE   finishedGoodDetailsId=:finishedGoodDetailsId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedgooddetailsStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS(

 finishedGoodDetailsExpiryDate,
 finishedGoodDetailsInventoryItemId,
 finishedGoodDetailsManufacturingDate,
 finishedGoodDetailsProductId,
finishedGoodDetailsStatus,
finishedGoodDetailsCreatedAt,
finishedGoodDetailsUpdatedAt
)   VALUES   (

 :finishedGoodDetailsExpiryDate,
 :finishedGoodDetailsInventoryItemId,
 :finishedGoodDetailsManufacturingDate,
 :finishedGoodDetailsProductId,
 COALESCE(:finishedGoodDetailsStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   SET

 finishedGoodDetailsExpiryDate = :finishedGoodDetailsExpiryDate,
 finishedGoodDetailsInventoryItemId = :finishedGoodDetailsInventoryItemId,
 finishedGoodDetailsManufacturingDate = :finishedGoodDetailsManufacturingDate,
 finishedGoodDetailsProductId = :finishedGoodDetailsProductId,
 finishedGoodDetailsStatus=:userStatus,
 finishedGoodDetailsUpdatedAt = GETDATE()
WHERE   finishedGoodDetailsId=:finishedGoodDetailsId
""";


public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsCreatedAt=:finishedGoodDetailsCreatedAt   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSEXPIRYDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsExpiryDate=:finishedGoodDetailsExpiryDate   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsId=:finishedGoodDetailsId   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSINVENTORYITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsInventoryItemId=:finishedGoodDetailsInventoryItemId   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSMANUFACTURINGDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsManufacturingDate=:finishedGoodDetailsManufacturingDate   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSPRODUCTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsProductId=:finishedGoodDetailsProductId   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsStatus=:finishedGoodDetailsStatus   AND   finishedgooddetailsStatus<>'DELETED'
""";

public   static   final   String   READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
FINISHED_GOOD_DETAILS   WHERE   finishedGoodDetailsUpdatedAt=:finishedGoodDetailsUpdatedAt   AND   finishedgooddetailsStatus<>'DELETED'
""";



private   FinishedGoodDetailsQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
