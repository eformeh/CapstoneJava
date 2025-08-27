
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SaleItemQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE_ITEM   SET   saleitemStatus   =   'DELETED',   saleitemUpdatedAt   =   GETDATE() 
WHERE   saleItemId=:saleItemId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SALE_ITEM
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleitemStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SALE_ITEM(

 saleItemProductId,
 saleItemQuantity,
 saleItemSaleId,
 saleItemTotal,
 saleItemUnitPrice,
saleItemStatus,
saleItemCreatedAt,
saleItemUpdatedAt
)   VALUES   (

 :saleItemProductId,
 :saleItemQuantity,
 :saleItemSaleId,
 :saleItemTotal,
 :saleItemUnitPrice,
 COALESCE(:saleItemStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE_ITEM   SET

 saleItemProductId = :saleItemProductId,
 saleItemQuantity = :saleItemQuantity,
 saleItemSaleId = :saleItemSaleId,
 saleItemTotal = :saleItemTotal,
 saleItemUnitPrice = :saleItemUnitPrice,
 saleItemStatus=:userStatus,
 saleItemUpdatedAt = GETDATE()
WHERE   saleItemId=:saleItemId
""";


public   static   final   String   READ_BY_SALE_ITEM_SALEITEMCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemCreatedAt=:saleItemCreatedAt   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemId=:saleItemId   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMPRODUCTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemProductId=:saleItemProductId   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMQUANTITY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemQuantity=:saleItemQuantity   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMSALEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemSaleId=:saleItemSaleId   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemStatus=:saleItemStatus   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMTOTAL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemTotal=:saleItemTotal   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMUNITPRICE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemUnitPrice=:saleItemUnitPrice   AND   saleitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_ITEM_SALEITEMUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_ITEM   WHERE   saleItemUpdatedAt=:saleItemUpdatedAt   AND   saleitemStatus<>'DELETED'
""";



private   SaleItemQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
