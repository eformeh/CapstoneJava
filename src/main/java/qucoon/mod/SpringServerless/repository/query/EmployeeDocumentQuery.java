
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   EmployeeDocumentQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   SET   employeedocumentStatus   =   'DELETED',   employeedocumentUpdatedAt   =   GETDATE() 
WHERE   employeeDocumentId=:employeeDocumentId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeedocumentStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT(

 employeeDocumentAccessLevel,
 employeeDocumentEmployeeId,
 employeeDocumentExpiresAt,
 employeeDocumentFileUrl,
 employeeDocumentType,
 employeeDocumentUploadedBy,
 employeeDocumentVersion,
employeeDocumentStatus,
employeeDocumentCreatedAt,
employeeDocumentUpdatedAt
)   VALUES   (

 :employeeDocumentAccessLevel,
 :employeeDocumentEmployeeId,
 :employeeDocumentExpiresAt,
 :employeeDocumentFileUrl,
 :employeeDocumentType,
 :employeeDocumentUploadedBy,
 :employeeDocumentVersion,
 COALESCE(:employeeDocumentStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   SET

 employeeDocumentAccessLevel = :employeeDocumentAccessLevel,
 employeeDocumentEmployeeId = :employeeDocumentEmployeeId,
 employeeDocumentExpiresAt = :employeeDocumentExpiresAt,
 employeeDocumentFileUrl = :employeeDocumentFileUrl,
 employeeDocumentType = :employeeDocumentType,
 employeeDocumentUploadedBy = :employeeDocumentUploadedBy,
 employeeDocumentVersion = :employeeDocumentVersion,
 employeeDocumentStatus=:userStatus,
 employeeDocumentUpdatedAt = GETDATE()
WHERE   employeeDocumentId=:employeeDocumentId
""";


public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTACCESSLEVEL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentAccessLevel=:employeeDocumentAccessLevel   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentCreatedAt=:employeeDocumentCreatedAt   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentEmployeeId=:employeeDocumentEmployeeId   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTEXPIRESAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentExpiresAt=:employeeDocumentExpiresAt   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTFILEURL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentFileUrl=:employeeDocumentFileUrl   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentId=:employeeDocumentId   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentStatus=:employeeDocumentStatus   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentType=:employeeDocumentType   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentUpdatedAt=:employeeDocumentUpdatedAt   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTUPLOADEDBY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentUploadedBy=:employeeDocumentUploadedBy   AND   employeedocumentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTVERSION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_DOCUMENT   WHERE   employeeDocumentVersion=:employeeDocumentVersion   AND   employeedocumentStatus<>'DELETED'
""";



private   EmployeeDocumentQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
