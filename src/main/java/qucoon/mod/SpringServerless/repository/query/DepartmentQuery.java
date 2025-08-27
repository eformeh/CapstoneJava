
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   DepartmentQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
DEPARTMENT   SET   departmentStatus   =   'DELETED',   departmentUpdatedAt   =   GETDATE() 
WHERE   departmentId=:departmentId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
DEPARTMENT
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
DEPARTMENT(

 departmentDescription,
 departmentName,
departmentStatus,
departmentCreatedAt,
departmentUpdatedAt
)   VALUES   (

 :departmentDescription,
 :departmentName,
 COALESCE(:departmentStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
DEPARTMENT   SET

 departmentDescription = :departmentDescription,
 departmentName = :departmentName,
 departmentStatus=:userStatus,
 departmentUpdatedAt = GETDATE()
WHERE   departmentId=:departmentId
""";


public   static   final   String   READ_BY_DEPARTMENT_DEPARTMENTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentCreatedAt=:departmentCreatedAt   AND   departmentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEPARTMENT_DEPARTMENTDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentDescription=:departmentDescription   AND   departmentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEPARTMENT_DEPARTMENTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentId=:departmentId   AND   departmentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEPARTMENT_DEPARTMENTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentName=:departmentName   AND   departmentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEPARTMENT_DEPARTMENTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentStatus=:departmentStatus   AND   departmentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEPARTMENT_DEPARTMENTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEPARTMENT   WHERE   departmentUpdatedAt=:departmentUpdatedAt   AND   departmentStatus<>'DELETED'
""";



private   DepartmentQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
