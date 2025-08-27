
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   ProductionRecordQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   SET   productionrecordStatus   =   'DELETED',   productionrecordUpdatedAt   =   GETDATE() 
WHERE   productionRecordId=:productionRecordId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionrecordStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD(

 productionRecordBatchNumber,
 productionRecordCreatedByUserId,
 productionRecordDate,
 productionRecordFinishedGoodProductId,
 supplierPhoneNumber,
productionRecordStatus,
productionRecordCreatedAt,
productionRecordUpdatedAt
)   VALUES   (

 :productionRecordBatchNumber,
 :productionRecordCreatedByUserId,
 :productionRecordDate,
 :productionRecordFinishedGoodProductId,
 :supplierPhoneNumber,
 COALESCE(:productionRecordStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   SET

 productionRecordBatchNumber = :productionRecordBatchNumber,
 productionRecordCreatedByUserId = :productionRecordCreatedByUserId,
 productionRecordDate = :productionRecordDate,
 productionRecordFinishedGoodProductId = :productionRecordFinishedGoodProductId,
 supplierPhoneNumber = :supplierPhoneNumber,
 productionRecordStatus=:userStatus,
 productionRecordUpdatedAt = GETDATE()
WHERE   productionRecordId=:productionRecordId
""";


public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDBATCHNUMBER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordBatchNumber=:productionRecordBatchNumber   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordCreatedAt=:productionRecordCreatedAt   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDCREATEDBYUSERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordCreatedByUserId=:productionRecordCreatedByUserId   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordDate=:productionRecordDate   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDFINISHEDGOODPRODUCTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordFinishedGoodProductId=:productionRecordFinishedGoodProductId   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordId=:productionRecordId   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordStatus=:productionRecordStatus   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   productionRecordUpdatedAt=:productionRecordUpdatedAt   AND   productionrecordStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_RECORD_SUPPLIERPHONENUMBER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_RECORD   WHERE   supplierPhoneNumber=:supplierPhoneNumber   AND   productionrecordStatus<>'DELETED'
""";



private   ProductionRecordQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
