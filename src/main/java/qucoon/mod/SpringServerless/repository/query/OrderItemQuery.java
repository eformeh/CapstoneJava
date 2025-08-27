
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   OrderItemQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ORDER_ITEM   SET   orderitemStatus   =   'DELETED',   orderitemUpdatedAt   =   GETDATE() 
WHERE   orderItemId=:orderItemId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ORDER_ITEM
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderitemStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ORDER_ITEM(

 orderItemInventoryItemId,
 orderItemOrderId,
 orderItemQuantityOrdered,
 orderItemTotalCost,
 orderItemUnitCost,
orderItemStatus,
orderItemCreatedAt,
orderItemUpdatedAt
)   VALUES   (

 :orderItemInventoryItemId,
 :orderItemOrderId,
 :orderItemQuantityOrdered,
 :orderItemTotalCost,
 :orderItemUnitCost,
 COALESCE(:orderItemStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ORDER_ITEM   SET

 orderItemInventoryItemId = :orderItemInventoryItemId,
 orderItemOrderId = :orderItemOrderId,
 orderItemQuantityOrdered = :orderItemQuantityOrdered,
 orderItemTotalCost = :orderItemTotalCost,
 orderItemUnitCost = :orderItemUnitCost,
 orderItemStatus=:userStatus,
 orderItemUpdatedAt = GETDATE()
WHERE   orderItemId=:orderItemId
""";


public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemCreatedAt=:orderItemCreatedAt   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemId=:orderItemId   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMINVENTORYITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemInventoryItemId=:orderItemInventoryItemId   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMORDERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemOrderId=:orderItemOrderId   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMQUANTITYORDERED  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemQuantityOrdered=:orderItemQuantityOrdered   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemStatus=:orderItemStatus   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMTOTALCOST  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemTotalCost=:orderItemTotalCost   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMUNITCOST  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemUnitCost=:orderItemUnitCost   AND   orderitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ORDER_ITEM_ORDERITEMUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ORDER_ITEM   WHERE   orderItemUpdatedAt=:orderItemUpdatedAt   AND   orderitemStatus<>'DELETED'
""";



private   OrderItemQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
