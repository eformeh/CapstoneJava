
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SaleDeliveryQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   SET   saledeliveryStatus   =   'DELETED',   saledeliveryUpdatedAt   =   GETDATE() 
WHERE   saleDeliveryId=:saleDeliveryId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saledeliveryStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY(

 saleDeliveryAddress,
 saleDeliveryConfirmedAt,
 saleDeliveryContactName,
 saleDeliveryContactPhone,
 saleDeliveryExpectedDeliveryDate,
 saleDeliveryNotes,
 saleDeliveryProvider,
 saleDeliverySaleId,
 saleDeliveryTrackingNumber,
saleDeliveryStatus,
saleDeliveryCreatedAt,
saleDeliveryUpdatedAt
)   VALUES   (

 :saleDeliveryAddress,
 :saleDeliveryConfirmedAt,
 :saleDeliveryContactName,
 :saleDeliveryContactPhone,
 :saleDeliveryExpectedDeliveryDate,
 :saleDeliveryNotes,
 :saleDeliveryProvider,
 :saleDeliverySaleId,
 :saleDeliveryTrackingNumber,
 COALESCE(:saleDeliveryStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   SET

 saleDeliveryAddress = :saleDeliveryAddress,
 saleDeliveryConfirmedAt = :saleDeliveryConfirmedAt,
 saleDeliveryContactName = :saleDeliveryContactName,
 saleDeliveryContactPhone = :saleDeliveryContactPhone,
 saleDeliveryExpectedDeliveryDate = :saleDeliveryExpectedDeliveryDate,
 saleDeliveryNotes = :saleDeliveryNotes,
 saleDeliveryProvider = :saleDeliveryProvider,
 saleDeliverySaleId = :saleDeliverySaleId,
 saleDeliveryTrackingNumber = :saleDeliveryTrackingNumber,
 saleDeliveryStatus=:userStatus,
 saleDeliveryUpdatedAt = GETDATE()
WHERE   saleDeliveryId=:saleDeliveryId
""";


public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYADDRESS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryAddress=:saleDeliveryAddress   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYCONFIRMEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryConfirmedAt=:saleDeliveryConfirmedAt   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYCONTACTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryContactName=:saleDeliveryContactName   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYCONTACTPHONE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryContactPhone=:saleDeliveryContactPhone   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryCreatedAt=:saleDeliveryCreatedAt   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYEXPECTEDDELIVERYDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryExpectedDeliveryDate=:saleDeliveryExpectedDeliveryDate   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryId=:saleDeliveryId   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYNOTES  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryNotes=:saleDeliveryNotes   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYPROVIDER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryProvider=:saleDeliveryProvider   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYSALEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliverySaleId=:saleDeliverySaleId   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryStatus=:saleDeliveryStatus   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYTRACKINGNUMBER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryTrackingNumber=:saleDeliveryTrackingNumber   AND   saledeliveryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_DELIVERY_SALEDELIVERYUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_DELIVERY   WHERE   saleDeliveryUpdatedAt=:saleDeliveryUpdatedAt   AND   saledeliveryStatus<>'DELETED'
""";



private   SaleDeliveryQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
