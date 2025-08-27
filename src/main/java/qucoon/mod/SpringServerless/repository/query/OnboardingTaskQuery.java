
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   OnboardingTaskQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   SET   onboardingtaskStatus   =   'DELETED',   onboardingtaskUpdatedAt   =   GETDATE() 
WHERE   onboardingTaskId=:onboardingTaskId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingtaskStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK(

 onboardingTaskCreatedBy,
 onboardingTaskDescription,
onboardingTaskStatus,
onboardingTaskCreatedAt,
onboardingTaskUpdatedAt
)   VALUES   (

 :onboardingTaskCreatedBy,
 :onboardingTaskDescription,
 COALESCE(:onboardingTaskStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   SET

 onboardingTaskCreatedBy = :onboardingTaskCreatedBy,
 onboardingTaskDescription = :onboardingTaskDescription,
 onboardingTaskStatus=:userStatus,
 onboardingTaskUpdatedAt = GETDATE()
WHERE   onboardingTaskId=:onboardingTaskId
""";


public   static   final   String   READ_BY_ONBOARDING_TASK_ONBOARDINGTASKCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingTaskCreatedAt=:onboardingTaskCreatedAt   AND   onboardingtaskStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ONBOARDING_TASK_ONBOARDINGTASKCREATEDBY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingTaskCreatedBy=:onboardingTaskCreatedBy   AND   onboardingtaskStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ONBOARDING_TASK_ONBOARDINGTASKDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingTaskDescription=:onboardingTaskDescription   AND   onboardingtaskStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ONBOARDING_TASK_ONBOARDINGTASKID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingTaskId=:onboardingTaskId   AND   onboardingtaskStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ONBOARDING_TASK_ONBOARDINGTASKSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingTaskStatus=:onboardingTaskStatus   AND   onboardingtaskStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ONBOARDING_TASK_ONBOARDINGTASKUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ONBOARDING_TASK   WHERE   onboardingTaskUpdatedAt=:onboardingTaskUpdatedAt   AND   onboardingtaskStatus<>'DELETED'
""";



private   OnboardingTaskQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
