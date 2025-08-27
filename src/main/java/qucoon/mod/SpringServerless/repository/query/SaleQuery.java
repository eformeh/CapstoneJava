
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SaleQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE   SET   saleStatus   =   'DELETED',   saleUpdatedAt   =   GETDATE() 
WHERE   saleId=:saleId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SALE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SALE(

 saleAmountPaid,
 saleCreditDue,
 saleCustomerId,
 saleDeliveryType,
 saleEmployeeId,
 saleTotalAmount,
 saleType,
saleStatus,
saleCreatedAt,
saleUpdatedAt
)   VALUES   (

 :saleAmountPaid,
 :saleCreditDue,
 :saleCustomerId,
 :saleDeliveryType,
 :saleEmployeeId,
 :saleTotalAmount,
 :saleType,
 COALESCE(:saleStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE   SET

 saleAmountPaid = :saleAmountPaid,
 saleCreditDue = :saleCreditDue,
 saleCustomerId = :saleCustomerId,
 saleDeliveryType = :saleDeliveryType,
 saleEmployeeId = :saleEmployeeId,
 saleTotalAmount = :saleTotalAmount,
 saleType = :saleType,
 saleStatus=:userStatus,
 saleUpdatedAt = GETDATE()
WHERE   saleId=:saleId
""";


public   static   final   String   READ_BY_SALE_SALEAMOUNTPAID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleAmountPaid=:saleAmountPaid   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleCreatedAt=:saleCreatedAt   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALECREDITDUE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleCreditDue=:saleCreditDue   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALECUSTOMERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleCustomerId=:saleCustomerId   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALEDELIVERYTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleDeliveryType=:saleDeliveryType   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALEEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleEmployeeId=:saleEmployeeId   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleId=:saleId   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleStatus=:saleStatus   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALETOTALAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleTotalAmount=:saleTotalAmount   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALETYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleType=:saleType   AND   saleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_SALEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE   WHERE   saleUpdatedAt=:saleUpdatedAt   AND   saleStatus<>'DELETED'
""";



private   SaleQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
