
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AppraisalFormQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   SET   appraisalformStatus   =   'DELETED',   appraisalformUpdatedAt   =   GETDATE() 
WHERE   appraisalFormId=:appraisalFormId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalformStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM(

 appraisalFormCreatedBy,
 appraisalFormDescription,
 appraisalFormName,
appraisalFormStatus,
appraisalFormCreatedAt,
appraisalFormUpdatedAt
)   VALUES   (

 :appraisalFormCreatedBy,
 :appraisalFormDescription,
 :appraisalFormName,
 COALESCE(:appraisalFormStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   SET

 appraisalFormCreatedBy = :appraisalFormCreatedBy,
 appraisalFormDescription = :appraisalFormDescription,
 appraisalFormName = :appraisalFormName,
 appraisalFormStatus=:userStatus,
 appraisalFormUpdatedAt = GETDATE()
WHERE   appraisalFormId=:appraisalFormId
""";


public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormCreatedAt=:appraisalFormCreatedAt   AND   appraisalformStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMCREATEDBY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormCreatedBy=:appraisalFormCreatedBy   AND   appraisalformStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormDescription=:appraisalFormDescription   AND   appraisalformStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormId=:appraisalFormId   AND   appraisalformStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormName=:appraisalFormName   AND   appraisalformStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormStatus=:appraisalFormStatus   AND   appraisalformStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_FORM_APPRAISALFORMUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_FORM   WHERE   appraisalFormUpdatedAt=:appraisalFormUpdatedAt   AND   appraisalformStatus<>'DELETED'
""";



private   AppraisalFormQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
