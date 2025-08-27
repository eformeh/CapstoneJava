
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   ProductQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
PRODUCT   SET   productStatus   =   'DELETED',   productUpdatedAt   =   GETDATE() 
WHERE   productId=:productId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
PRODUCT
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
PRODUCT(

 productBarcode,
 productCategory,
 productDescription,
 productMinimumThreshold,
 productName,
 productPrice,
 productSKU,
 productStockQuantity,
productStatus,
productCreatedAt,
productUpdatedAt
)   VALUES   (

 :productBarcode,
 :productCategory,
 :productDescription,
 :productMinimumThreshold,
 :productName,
 :productPrice,
 :productSKU,
 :productStockQuantity,
 COALESCE(:productStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
PRODUCT   SET

 productBarcode = :productBarcode,
 productCategory = :productCategory,
 productDescription = :productDescription,
 productMinimumThreshold = :productMinimumThreshold,
 productName = :productName,
 productPrice = :productPrice,
 productSKU = :productSKU,
 productStockQuantity = :productStockQuantity,
 productStatus=:userStatus,
 productUpdatedAt = GETDATE()
WHERE   productId=:productId
""";


public   static   final   String   READ_BY_PRODUCT_PRODUCTBARCODE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productBarcode=:productBarcode   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTCATEGORY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productCategory=:productCategory   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productCreatedAt=:productCreatedAt   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productDescription=:productDescription   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productId=:productId   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTMINIMUMTHRESHOLD  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productMinimumThreshold=:productMinimumThreshold   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productName=:productName   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTPRICE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productPrice=:productPrice   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTSKU  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productSKU=:productSKU   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productStatus=:productStatus   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTSTOCKQUANTITY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productStockQuantity=:productStockQuantity   AND   productStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRODUCT_PRODUCTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRODUCT   WHERE   productUpdatedAt=:productUpdatedAt   AND   productStatus<>'DELETED'
""";



private   ProductQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
