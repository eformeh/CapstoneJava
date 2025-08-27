
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   JobQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
JOB   SET   jobStatus   =   'DELETED',   jobUpdatedAt   =   GETDATE() 
WHERE   jobId=:jobId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
JOB
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
JOB(

 jobDepartmentId,
 jobRoleId,
jobStatus,
jobCreatedAt,
jobUpdatedAt
)   VALUES   (

 :jobDepartmentId,
 :jobRoleId,
 COALESCE(:jobStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
JOB   SET

 jobDepartmentId = :jobDepartmentId,
 jobRoleId = :jobRoleId,
 jobStatus=:userStatus,
 jobUpdatedAt = GETDATE()
WHERE   jobId=:jobId
""";


public   static   final   String   READ_BY_JOB_JOBCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobCreatedAt=:jobCreatedAt   AND   jobStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOB_JOBDEPARTMENTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobDepartmentId=:jobDepartmentId   AND   jobStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOB_JOBID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobId=:jobId   AND   jobStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOB_JOBROLEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobRoleId=:jobRoleId   AND   jobStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOB_JOBSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobStatus=:jobStatus   AND   jobStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOB_JOBUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOB   WHERE   jobUpdatedAt=:jobUpdatedAt   AND   jobStatus<>'DELETED'
""";



private   JobQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
