
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   ProductionMaterialQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   SET   productionmaterialStatus   =   'DELETED',   productionmaterialUpdatedAt   =   GETDATE() 
WHERE   productionMaterialId=:productionMaterialId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionmaterialStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL(

 productionMaterialInventoryItemId,
 productionMaterialProductionRecordId,
 productionMaterialQuantityConsumed,
productionMaterialStatus,
productionMaterialCreatedAt,
productionMaterialUpdatedAt
)   VALUES   (

 :productionMaterialInventoryItemId,
 :productionMaterialProductionRecordId,
 :productionMaterialQuantityConsumed,
 COALESCE(:productionMaterialStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   SET

 productionMaterialInventoryItemId = :productionMaterialInventoryItemId,
 productionMaterialProductionRecordId = :productionMaterialProductionRecordId,
 productionMaterialQuantityConsumed = :productionMaterialQuantityConsumed,
 productionMaterialStatus=:userStatus,
 productionMaterialUpdatedAt = GETDATE()
WHERE   productionMaterialId=:productionMaterialId
""";


public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialCreatedAt=:productionMaterialCreatedAt   AND   productionmaterialStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialId=:productionMaterialId   AND   productionmaterialStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALINVENTORYITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialInventoryItemId=:productionMaterialInventoryItemId   AND   productionmaterialStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALPRODUCTIONRECORDID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialProductionRecordId=:productionMaterialProductionRecordId   AND   productionmaterialStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALQUANTITYCONSUMED  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialQuantityConsumed=:productionMaterialQuantityConsumed   AND   productionmaterialStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialStatus=:productionMaterialStatus   AND   productionmaterialStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCTION_MATERIAL   WHERE   productionMaterialUpdatedAt=:productionMaterialUpdatedAt   AND   productionmaterialStatus<>'DELETED'
""";



private   ProductionMaterialQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
