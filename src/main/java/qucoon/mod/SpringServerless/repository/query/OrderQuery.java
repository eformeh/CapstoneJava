
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   OrderQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ORDER   SET   orderStatus   =   'DELETED',   orderUpdatedAt   =   GETDATE() 
WHERE   orderId=:orderId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ORDER
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ORDER(

 orderActualDeliveryDate,
 orderCreatedByUserId,
 orderExpectedDeliveryDate,
 orderOrderDate,
 orderSupplierId,
 orderTotalCost,
 orderType,
orderStatus,
orderCreatedAt,
orderUpdatedAt
)   VALUES   (

 :orderActualDeliveryDate,
 :orderCreatedByUserId,
 :orderExpectedDeliveryDate,
 :orderOrderDate,
 :orderSupplierId,
 :orderTotalCost,
 :orderType,
 COALESCE(:orderStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ORDER   SET

 orderActualDeliveryDate = :orderActualDeliveryDate,
 orderCreatedByUserId = :orderCreatedByUserId,
 orderExpectedDeliveryDate = :orderExpectedDeliveryDate,
 orderOrderDate = :orderOrderDate,
 orderSupplierId = :orderSupplierId,
 orderTotalCost = :orderTotalCost,
 orderType = :orderType,
 orderStatus=:userStatus,
 orderUpdatedAt = GETDATE()
WHERE   orderId=:orderId
""";


public   static   final   String   READ_BY_ORDER_ORDERACTUALDELIVERYDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderActualDeliveryDate=:orderActualDeliveryDate   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderCreatedAt=:orderCreatedAt   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERCREATEDBYUSERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderCreatedByUserId=:orderCreatedByUserId   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDEREXPECTEDDELIVERYDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderExpectedDeliveryDate=:orderExpectedDeliveryDate   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderId=:orderId   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERORDERDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderOrderDate=:orderOrderDate   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderStatus=:orderStatus   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERSUPPLIERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderSupplierId=:orderSupplierId   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERTOTALCOST  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderTotalCost=:orderTotalCost   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderType=:orderType   AND   orderStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ORDERUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER   WHERE   orderUpdatedAt=:orderUpdatedAt   AND   orderStatus<>'DELETED'
""";



private   OrderQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
