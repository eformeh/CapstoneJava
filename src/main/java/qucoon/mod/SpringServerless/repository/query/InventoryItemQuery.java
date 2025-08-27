
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   InventoryItemQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   SET   inventoryitemStatus   =   'DELETED',   inventoryitemUpdatedAt   =   GETDATE() 
WHERE   inventoryItemId=:inventoryItemId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryitemStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM(

 inventoryItemAvailableStock,
 inventoryItemCategory,
 inventoryItemCurrentStock,
 inventoryItemDescription,
 inventoryItemMinimumStockLevel,
 inventoryItemName,
 inventoryItemReservedStock,
 inventoryItemUnitCost,
 inventoryItemUnitOfMeasure,
inventoryItemStatus,
inventoryItemCreatedAt,
inventoryItemUpdatedAt
)   VALUES   (

 :inventoryItemAvailableStock,
 :inventoryItemCategory,
 :inventoryItemCurrentStock,
 :inventoryItemDescription,
 :inventoryItemMinimumStockLevel,
 :inventoryItemName,
 :inventoryItemReservedStock,
 :inventoryItemUnitCost,
 :inventoryItemUnitOfMeasure,
 COALESCE(:inventoryItemStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   SET

 inventoryItemAvailableStock = :inventoryItemAvailableStock,
 inventoryItemCategory = :inventoryItemCategory,
 inventoryItemCurrentStock = :inventoryItemCurrentStock,
 inventoryItemDescription = :inventoryItemDescription,
 inventoryItemMinimumStockLevel = :inventoryItemMinimumStockLevel,
 inventoryItemName = :inventoryItemName,
 inventoryItemReservedStock = :inventoryItemReservedStock,
 inventoryItemUnitCost = :inventoryItemUnitCost,
 inventoryItemUnitOfMeasure = :inventoryItemUnitOfMeasure,
 inventoryItemStatus=:userStatus,
 inventoryItemUpdatedAt = GETDATE()
WHERE   inventoryItemId=:inventoryItemId
""";


public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMAVAILABLESTOCK  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemAvailableStock=:inventoryItemAvailableStock   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMCATEGORY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemCategory=:inventoryItemCategory   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemCreatedAt=:inventoryItemCreatedAt   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMCURRENTSTOCK  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemCurrentStock=:inventoryItemCurrentStock   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemDescription=:inventoryItemDescription   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemId=:inventoryItemId   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMMINIMUMSTOCKLEVEL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemMinimumStockLevel=:inventoryItemMinimumStockLevel   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemName=:inventoryItemName   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMRESERVEDSTOCK  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemReservedStock=:inventoryItemReservedStock   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemStatus=:inventoryItemStatus   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMUNITCOST  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemUnitCost=:inventoryItemUnitCost   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMUNITOFMEASURE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemUnitOfMeasure=:inventoryItemUnitOfMeasure   AND   inventoryitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_INVENTORY_ITEM_INVENTORYITEMUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
INVENTORY_ITEM   WHERE   inventoryItemUpdatedAt=:inventoryItemUpdatedAt   AND   inventoryitemStatus<>'DELETED'
""";



private   InventoryItemQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
