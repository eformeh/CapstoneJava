
CREATE DATABASE DBCapstoneProject;
GO

USE DBCapstoneProject;
GO


CREATE TABLE UWX_LEAVE_BALANCE
(
    leaveBalanceId INT IDENTITY(100, 1) PRIMARY KEY  ,
    leaveBalanceStatus varchar(50) DEFAULT 'PENDING',
    leaveBalanceCreatedAt datetime DEFAULT GETDATE(),
    leaveBalanceUpdatedAt DATETIME DEFAULT GETDATE(),
    leaveBalanceEmployeeId INT,
    leaveBalanceRemainingDays INT,
    leaveBalanceTotalDays INT,
    leaveBalanceTypeId INT,
    leaveBalanceUsedDays INT
);
GO
CREATE TABLE UWX_LEAVE_REQUEST
(
    leaveRequestId INT IDENTITY(100, 1) PRIMARY KEY  ,
    leaveRequestStatus varchar(50) DEFAULT 'PENDING',
    leaveRequestCreatedAt datetime DEFAULT GETDATE(),
    leaveRequestUpdatedAt DATETIME DEFAULT GETDATE(),
    leaveRequestDecisionDate DATETIME,
    leaveRequestEmployeeId INT,
    leaveRequestEndDate DATETIME,
    leaveRequestReason VARCHAR(255),
    leaveRequestReviewerId INT,
    leaveRequestStartDate DATETIME,
    leaveRequestSubmittedAt DATETIME,
    leaveRequestTypeId INT UNIQUE
);
GO
CREATE TABLE UWX_LEAVE_TYPE
(
    leaveTypeId INT IDENTITY(100, 1) PRIMARY KEY  ,
    leaveTypeStatus varchar(50) DEFAULT 'PENDING',
    leaveTypeCreatedAt datetime DEFAULT GETDATE(),
    leaveTypeUpdatedAt DATETIME DEFAULT GETDATE(),
    leaveTypeAccrualRatePerMonth DOUBLE PRECISION,
    leaveTypeDescription VARCHAR(255),
    leaveTypeName VARCHAR(255),
    leaveTypeResetPolicy VARCHAR(255)
);
GO
CREATE TABLE UWX_LEDGER
(
    ledgerId INT IDENTITY(100, 1) PRIMARY KEY  ,
    ledgerStatus varchar(50) DEFAULT 'PENDING',
    ledgerCreatedAt datetime DEFAULT GETDATE(),
    ledgerUpdatedAt DATETIME DEFAULT GETDATE(),
    ledgerAccountId INT,
    ledgerBalanceAfter DOUBLE PRECISION,
    ledgerCredit DOUBLE PRECISION,
    ledgerDebit DOUBLE PRECISION,
    ledgerjournalEntryLineAccountId INT
);
GO
CREATE TABLE UWX_LOGIN_HISTORY
(
    loginHistoryId INT IDENTITY(100, 1) PRIMARY KEY  ,
    loginHistoryStatus varchar(50) DEFAULT 'PENDING',
    loginHistoryCreatedAt datetime DEFAULT GETDATE(),
    loginHistoryUpdatedAt DATETIME DEFAULT GETDATE(),
    loginHistoryDeviceId VARCHAR(255),
    loginHistoryIpAddress VARCHAR(255),
    loginHistoryLatitude VARCHAR(255),
    loginHistoryLongitude VARCHAR(255),
    loginHistoryUsername VARCHAR(255)
);
GO
CREATE TABLE UWX_MODULE
(
    moduleId INT IDENTITY(100, 1) PRIMARY KEY  ,
    moduleStatus varchar(50) DEFAULT 'PENDING',
    moduleCreatedAt datetime DEFAULT GETDATE(),
    moduleUpdatedAt DATETIME DEFAULT GETDATE(),
    moduleDescription VARCHAR(255),
    moduleName VARCHAR(255)
);
GO
CREATE TABLE UWX_ONBOARDING_TASK
(
    onboardingTaskId INT IDENTITY(100, 1) PRIMARY KEY  ,
    onboardingTaskStatus varchar(50) DEFAULT 'PENDING',
    onboardingTaskCreatedAt datetime DEFAULT GETDATE(),
    onboardingTaskUpdatedAt DATETIME DEFAULT GETDATE(),
    onboardingTaskCreatedBy INT,
    onboardingTaskDescription VARCHAR(255)
);
GO
CREATE TABLE UWX_ORDER
(
    orderId INT IDENTITY(100, 1) PRIMARY KEY  ,
    orderStatus varchar(50) DEFAULT 'PENDING',
    orderCreatedAt datetime DEFAULT GETDATE(),
    orderUpdatedAt DATETIME DEFAULT GETDATE(),
    orderActualDeliveryDate DATETIME,
    orderCreatedByUserId INT,
    orderExpectedDeliveryDate DATETIME,
    orderOrderDate DATETIME,
    orderSupplierId INT,
    orderTotalCost DOUBLE PRECISION,
    orderType VARCHAR(255)
);
GO
CREATE TABLE UWX_ORDER_ITEM
(
    orderItemId INT IDENTITY(100, 1) PRIMARY KEY  ,
    orderItemStatus varchar(50) DEFAULT 'PENDING',
    orderItemCreatedAt datetime DEFAULT GETDATE(),
    orderItemUpdatedAt DATETIME DEFAULT GETDATE(),
    orderItemInventoryItemId INT,
    orderItemOrderId INT,
    orderItemQuantityOrdered INT,
    orderItemTotalCost DOUBLE PRECISION,
    orderItemUnitCost DOUBLE PRECISION
);
GO
CREATE TABLE UWX_OVERTIME
(
    overtimeId INT IDENTITY(100, 1) PRIMARY KEY  ,
    overtimeStatus varchar(50) DEFAULT 'PENDING',
    overtimeCreatedAt datetime DEFAULT GETDATE(),
    overtimeUpdatedAt DATETIME DEFAULT GETDATE(),
    overtimeDate DATETIME,
    overtimeEmployeeId INT,
    overtimeHours DOUBLE PRECISION
);
GO
CREATE TABLE UWX_PAY_PERIOD
(
    payPeriodId INT IDENTITY(100, 1) PRIMARY KEY  ,
    payPeriodStatus varchar(50) DEFAULT 'PENDING',
    payPeriodCreatedAt datetime DEFAULT GETDATE(),
    payPeriodUpdatedAt DATETIME DEFAULT GETDATE(),
    payPeriodEndDate DATETIME,
    payPeriodName VARCHAR(255),
    payPeriodPeriodType VARCHAR(255),
    payPeriodStartDate DATETIME
);
GO
CREATE TABLE UWX_PRIVILEGE
(
    privilegeId INT IDENTITY(100, 1) PRIMARY KEY  ,
    privilegeStatus varchar(50) DEFAULT 'PENDING',
    privilegeCreatedAt datetime DEFAULT GETDATE(),
    privilegeUpdatedAt DATETIME DEFAULT GETDATE(),
    privilegeCode VARCHAR(255),
    privilegeDescription VARCHAR(255),
    privilegeModuleName VARCHAR(255),
    privilegeName VARCHAR(255)
);
GO
CREATE TABLE UWX_PRODUCT
(
    productId INT IDENTITY(100, 1) PRIMARY KEY  ,
    productStatus varchar(50) DEFAULT 'PENDING',
    productCreatedAt datetime DEFAULT GETDATE(),
    productUpdatedAt DATETIME DEFAULT GETDATE(),
    productBarcode VARCHAR(255),
    productCategory VARCHAR(255),
    productDescription VARCHAR(255),
    productMinimumThreshold INT,
    productName VARCHAR(255),
    productPrice DOUBLE PRECISION,
    productSKU VARCHAR(255) UNIQUE,
    productStockQuantity INT
);
GO
CREATE TABLE UWX_PRODUCTION_MATERIAL
(
    productionMaterialId INT IDENTITY(100, 1) PRIMARY KEY  ,
    productionMaterialStatus varchar(50) DEFAULT 'PENDING',
    productionMaterialCreatedAt datetime DEFAULT GETDATE(),
    productionMaterialUpdatedAt DATETIME DEFAULT GETDATE(),
    productionMaterialInventoryItemId INT,
    productionMaterialProductionRecordId INT,
    productionMaterialQuantityConsumed INT
);
GO
CREATE TABLE UWX_PRODUCTION_RECORD
(
    productionRecordId INT IDENTITY(100, 1) PRIMARY KEY  ,
    productionRecordStatus varchar(50) DEFAULT 'PENDING',
    productionRecordCreatedAt datetime DEFAULT GETDATE(),
    productionRecordUpdatedAt DATETIME DEFAULT GETDATE(),
    productionRecordBatchNumber VARCHAR(255),
    productionRecordCreatedByUserId INT,
    productionRecordDate DATETIME,
    productionRecordFinishedGoodProductId INT,
    supplierPhoneNumber VARCHAR(255)
);
GO
CREATE TABLE UWX_ROLE
(
    roleId INT IDENTITY(100, 1) PRIMARY KEY  ,
    roleStatus varchar(50) DEFAULT 'PENDING',
    roleCreatedAt datetime DEFAULT GETDATE(),
    roleUpdatedAt DATETIME DEFAULT GETDATE(),
    roleDescription VARCHAR(255),
    roleIsPublic VARCHAR(255),
    roleName VARCHAR(255),
    rolePrivilegeCreatedAt DATETIME,
    rolePrivilegeId INT UNIQUE,
    rolePrivilegePrivilegeCode VARCHAR(255),
    rolePrivilegeRoleId INT,
    rolePrivilegeStatus VARCHAR(255),
    rolePrivilegeUpdatedAt DATETIME
);
GO
CREATE TABLE UWX_ROLE_PRIVILEGE
(
    rolePrivilegeId INT IDENTITY(100, 1) PRIMARY KEY  ,
    rolePrivilegeStatus varchar(50) DEFAULT 'PENDING',
    rolePrivilegeCreatedAt datetime DEFAULT GETDATE(),
    rolePrivilegeUpdatedAt DATETIME DEFAULT GETDATE(),
    rolePrivilegePrivilegeCode VARCHAR(255),
    rolePrivilegeRoleId INT
);
GO
CREATE TABLE UWX_SALARY
(
    salaryId INT IDENTITY(100, 1) PRIMARY KEY  ,
    salaryStatus varchar(50) DEFAULT 'PENDING',
    salaryCreatedAt datetime DEFAULT GETDATE(),
    salaryUpdatedAt DATETIME DEFAULT GETDATE(),
    salaryBasicAmount DOUBLE PRECISION,
    salaryEmployeeId INT,
    salaryGrossPay DOUBLE PRECISION,
    salaryNetPay DOUBLE PRECISION,
    salaryPayPeriodId INT
);
GO
CREATE TABLE UWX_SALARY_PAYMENT
(
    salaryPaymentId INT IDENTITY(100, 1) PRIMARY KEY  ,
    salaryPaymentStatus varchar(50) DEFAULT 'PENDING',
    salaryPaymentCreatedAt datetime DEFAULT GETDATE(),
    salaryPaymentUpdatedAt DATETIME DEFAULT GETDATE(),
    salaryPaymentAmount DOUBLE PRECISION,
    salaryPaymentApprovedBy INT,
    salaryPaymentChannel VARCHAR(255),
    salaryPaymentEmployeeAccountId INT,
    salaryPaymentSalaryId INT,
    salaryPaymentTransactionId INT
);
GO
CREATE TABLE UWX_SALE
(
    saleId INT IDENTITY(100, 1) PRIMARY KEY  ,
    saleStatus varchar(50) DEFAULT 'PENDING',
    saleCreatedAt datetime DEFAULT GETDATE(),
    saleUpdatedAt DATETIME DEFAULT GETDATE(),
    saleAmountPaid DOUBLE PRECISION,
    saleCreditDue DATETIME,
    saleCustomerId INT,
    saleDeliveryType VARCHAR(255),
    saleEmployeeId INT,
    saleTotalAmount DOUBLE PRECISION,
    saleType VARCHAR(255)
);
GO
CREATE TABLE UWX_SALE_DELIVERY
(
    saleDeliveryId INT IDENTITY(100, 1) PRIMARY KEY  ,
    saleDeliveryStatus varchar(50) DEFAULT 'PENDING',
    saleDeliveryCreatedAt datetime DEFAULT GETDATE(),
    saleDeliveryUpdatedAt DATETIME DEFAULT GETDATE(),
    saleDeliveryAddress VARCHAR(255),
    saleDeliveryConfirmedAt DATETIME,
    saleDeliveryContactName VARCHAR(255),
    saleDeliveryContactPhone VARCHAR(255),
    saleDeliveryExpectedDeliveryDate DATETIME,
    saleDeliveryNotes VARCHAR(255),
    saleDeliveryProvider VARCHAR(255),
    saleDeliverySaleId INT,
    saleDeliveryTrackingNumber VARCHAR(255)
);
GO
CREATE TABLE UWX_SALE_ITEM
(
    saleItemId INT IDENTITY(100, 1) PRIMARY KEY  ,
    saleItemStatus varchar(50) DEFAULT 'PENDING',
    saleItemCreatedAt datetime DEFAULT GETDATE(),
    saleItemUpdatedAt DATETIME DEFAULT GETDATE(),
    saleItemProductId INT,
    saleItemQuantity INT,
    saleItemSaleId INT,
    saleItemTotal DOUBLE PRECISION,
    saleItemUnitPrice DOUBLE PRECISION
);
GO
CREATE TABLE UWX_SALE_PAYMENT_LOG
(
    salePaymentLogId INT IDENTITY(100, 1) PRIMARY KEY  ,
    salePaymentLogStatus varchar(50) DEFAULT 'PENDING',
    salePaymentLogCreatedAt datetime DEFAULT GETDATE(),
    salePaymentLogUpdatedAt DATETIME DEFAULT GETDATE(),
    salePaymentLogAmount DOUBLE PRECISION,
    salePaymentLogEmployeeid INT,
    salePaymentLogMethod VARCHAR(255),
    salePaymentLogNotes VARCHAR(255),
    salePaymentLogSaleid INT,
    salePaymentUpdatedAt DATETIME
);
GO
CREATE TABLE UWX_SUPPLIER
(
    supplierId INT IDENTITY(100, 1) PRIMARY KEY  ,
    supplierStatus varchar(50) DEFAULT 'PENDING',
    supplierCreatedAt datetime DEFAULT GETDATE(),
    supplierUpdatedAt DATETIME DEFAULT GETDATE(),
    supplierAddress VARCHAR(255),
    supplierContactPerson VARCHAR(255),
    supplierCreatedByUserId INT,
    supplierEmail VARCHAR(255),
    supplierName VARCHAR(255),
    supplierPhoneNumber VARCHAR(255)
);
GO
CREATE TABLE UWX_TRANSACTION
(
    transactionId INT IDENTITY(100, 1) PRIMARY KEY  ,
    transactionStatus varchar(50) DEFAULT 'PENDING',
    transactionCreatedAt datetime DEFAULT GETDATE(),
    transactionUpdatedAt DATETIME DEFAULT GETDATE(),
    transactionAmount DOUBLE PRECISION,
    transactionDescription VARCHAR(255),
    transactionNarration VARCHAR(255),
    transactionReferenceNumber VARCHAR(255),
    transactionSourceModule VARCHAR(255),
    transactionSourceReferenceId INT,
    transactionTransactionCategoryId INT,
    transactionTransactionDate DATETIME
);
GO
CREATE TABLE UWX_TRANSACTION_CATEGORY
(
    transactionCategoryId INT IDENTITY(100, 1) PRIMARY KEY  ,
    transactionCategoryStatus varchar(50) DEFAULT 'PENDING',
    transactionCategoryCreatedAt datetime DEFAULT GETDATE(),
    transactionCategoryUpdatedAt DATETIME DEFAULT GETDATE(),
    transactionCategoryDescription VARCHAR(255),
    transactionCategoryName VARCHAR(255),
    transactionCategoryTransactionNature VARCHAR(255)
);
GO
CREATE TABLE UWX_USER
(
    userId INT IDENTITY(100, 1) PRIMARY KEY  ,
    userStatus varchar(50) DEFAULT 'PENDING',
    userCreatedAt datetime DEFAULT GETDATE(),
    userUpdatedAt DATETIME DEFAULT GETDATE(),
    userEmail VARCHAR(255),
    userEmployeeId INT,
    userFirstName VARCHAR(255),
    userLastLoginDate VARCHAR(255),
    userLastLoginIpAddress VARCHAR(255),
    userLastName VARCHAR(255),
    userLoginCount INT,
    userPassword VARCHAR(255),
    userRoleId INT
);
GO
CREATE TABLE UWX_USER_OTP
(
    userOtpId INT IDENTITY(100, 1) PRIMARY KEY  ,
    userOtpStatus varchar(50) DEFAULT 'PENDING',
    userOtpCreatedAt datetime DEFAULT GETDATE(),
    userOtpUpdatedAt DATETIME DEFAULT GETDATE(),
    userOtpOtp VARCHAR(255),
    userOtpUsername VARCHAR(255)
);
GO
CREATE TABLE UWX_LEAVE_BALANCE
(
    leaveBalanceId INT IDENTITY(100, 1) PRIMARY KEY  ,
    leaveBalanceStatus varchar(50) DEFAULT 'PENDING',
    leaveBalanceCreatedAt datetime DEFAULT GETDATE(),
    leaveBalanceUpdatedAt DATETIME DEFAULT GETDATE(),
    leaveBalanceEmployeeId INT,
    leaveBalanceRemainingDays INT,
    leaveBalanceTotalDays INT,
    leaveBalanceTypeId INT,
    leaveBalanceUsedDays INT
);
GO
CREATE TABLE UWX_JOURNAL_ENTRY_LINE
(
    journalEntryLineId INT IDENTITY(100, 1) PRIMARY KEY  ,
    journalEntryLineStatus varchar(50) DEFAULT 'PENDING',
    journalEntryLineCreatedAt datetime DEFAULT GETDATE(),
    journalEntryLineUpdatedAt DATETIME DEFAULT GETDATE(),
    journalEntryLineAccountId INT,
    journalEntryLineAmount DOUBLE PRECISION,
    journalEntryLineEntryType VARCHAR(255),
    journalEntryLineTransactionId INT
);
GO
CREATE TABLE UWX_EMPLOYEE
(
    employeeId INT IDENTITY(100, 1) PRIMARY KEY  ,
    employeeStatus varchar(50) DEFAULT 'PENDING',
    employeeCreatedAt datetime DEFAULT GETDATE(),
    employeeUpdatedAt DATETIME DEFAULT GETDATE(),
    employeeContractEndDate DATETIME,
    employeeDateOfBirth DATETIME,
    employeeEmail VARCHAR(255) UNIQUE,
    employeeEmploymentStatus VARCHAR(255),
    employeeEmploymentType VARCHAR(255),
    employeeFirstName VARCHAR(255),
    employeeHireDate DATETIME,
    employeeJobId INT,
    employeeLastName VARCHAR(255),
    employeeMaritalStatus VARCHAR(255),
    employeeNationality VARCHAR(255),
    employeePhone VARCHAR(255) UNIQUE,
    employeePhotoUrl VARCHAR(255)
);
GO
CREATE TABLE UWX_DEPARTMENT
(
    departmentId INT IDENTITY(100, 1) PRIMARY KEY  ,
    departmentStatus varchar(50) DEFAULT 'PENDING',
    departmentCreatedAt datetime DEFAULT GETDATE(),
    departmentUpdatedAt DATETIME DEFAULT GETDATE(),
    departmentDescription VARCHAR(255),
    departmentName VARCHAR(255)
);
GO
CREATE TABLE UWX_DEDUCTION
(
    deductionId INT IDENTITY(100, 1) PRIMARY KEY  ,
    deductionStatus varchar(50) DEFAULT 'PENDING',
    deductionCreatedAt datetime DEFAULT GETDATE(),
    deductionUpdatedAt DATETIME DEFAULT GETDATE(),
    deductionAmount DOUBLE PRECISION,
    deductionSalaryId INT,
    deductionType VARCHAR(255)
);
GO
CREATE TABLE UWX_CUSTOMER
(
    customerId INT IDENTITY(100, 1) PRIMARY KEY  ,
    customerStatus varchar(50) DEFAULT 'PENDING',
    customerCreatedAt datetime DEFAULT GETDATE(),
    customerUpdatedAt DATETIME DEFAULT GETDATE(),
    customerAddress VARCHAR(255),
    customerCompanyName VARCHAR(255),
    customerCreditBalance DOUBLE PRECISION,
    customerEmail VARCHAR(255) UNIQUE,
    customerName VARCHAR(255),
    customerNotes VARCHAR(255),
    customerPhone VARCHAR(255) UNIQUE,
    customerType VARCHAR(255)
);
GO
CREATE TABLE UWX_CHECKER_QUEUE
(
    checkerQueueId INT IDENTITY(100, 1) PRIMARY KEY  ,
    checkerQueueStatus varchar(50) DEFAULT 'PENDING',
    checkerQueueCreatedAt datetime DEFAULT GETDATE(),
    checkerQueueUpdatedAt DATETIME DEFAULT GETDATE(),
    checkerQueueAction VARCHAR(255),
    checkerQueueCheckerId INT,
    checkerQueueMakerId INT,
    checkerQueueModule VARCHAR(255),
    checkerQueueReason VARCHAR(255),
    checkerQueueRequest VARCHAR(255)
);
GO
CREATE TABLE UWX_AUDIT_LOG
(
    auditLogId INT IDENTITY(100, 1) PRIMARY KEY  ,
    auditLogStatus varchar(50) DEFAULT 'PENDING',
    auditLogCreatedAt datetime DEFAULT GETDATE(),
    auditLogUpdatedAt DATETIME DEFAULT GETDATE(),
    auditLogAction VARCHAR(255),
    auditLogModule VARCHAR(255),
    auditLogRequest VARCHAR(255),
    auditLogResponse VARCHAR(255),
    auditLogResponseCode VARCHAR(255),
    auditLogResponseMessage VARCHAR(255),
    auditLogUserId INT
);
GO
CREATE TABLE UWX_APPRAISAL_RESPONSE
(
    appraisalResponseId INT IDENTITY(100, 1) PRIMARY KEY  ,
    appraisalResponseStatus varchar(50) DEFAULT 'PENDING',
    appraisalResponseCreatedAt datetime DEFAULT GETDATE(),
    appraisalResponseUpdatedAt DATETIME DEFAULT GETDATE(),
    appraisalResponseAppraisalId INT,
    appraisalResponseQuestionId INT,
    appraisalResponseScore DOUBLE PRECISION,
    appraisalResponseValue VARCHAR(255)
);
GO
CREATE TABLE UWX_APPRAISAL_QUESTION
(
    appraisalQuestionId INT IDENTITY(100, 1) PRIMARY KEY  ,
    appraisalQuestionStatus varchar(50) DEFAULT 'PENDING',
    appraisalQuestionCreatedAt datetime DEFAULT GETDATE(),
    appraisalQuestionUpdatedAt DATETIME DEFAULT GETDATE(),
    appraisalFormId INT,
    appraisalQuestionText VARCHAR(255),
    appraisalQuestionType VARCHAR(255),
    appraisalQuestionWeight DOUBLE PRECISION
);
GO
CREATE TABLE UWX_APPRAISAL_FORM
(
    appraisalFormId INT IDENTITY(100, 1) PRIMARY KEY  ,
    appraisalFormStatus varchar(50) DEFAULT 'PENDING',
    appraisalFormCreatedAt datetime DEFAULT GETDATE(),
    appraisalFormUpdatedAt DATETIME DEFAULT GETDATE(),
    appraisalFormCreatedBy INT,
    appraisalFormDescription VARCHAR(255),
    appraisalFormName VARCHAR(255)
);
GO
CREATE TABLE UWX_APPRAISAL
(
    appraisalId INT IDENTITY(100, 1) PRIMARY KEY  ,
    appraisalStatus varchar(50) DEFAULT 'PENDING',
    appraisalCreatedAt datetime DEFAULT GETDATE(),
    appraisalUpdatedAt DATETIME DEFAULT GETDATE(),
    appraisalDate DATETIME,
    appraisalEmployeeIdRoleId INT,
    appraisalFormId INT,
    appraisalGeneralFeedback VARCHAR(255),
    appraisalOverallScore DOUBLE PRECISION,
    appraisalReviewerId INT
);
GO
CREATE TABLE UWX_JOB
(
    jobId INT IDENTITY(100, 1) PRIMARY KEY  ,
    jobStatus varchar(50) DEFAULT 'PENDING',
    jobCreatedAt datetime DEFAULT GETDATE(),
    jobUpdatedAt DATETIME DEFAULT GETDATE(),
    jobDepartmentId INT,
    jobRoleId INT
);
GO
CREATE TABLE UWX_ALLOWANCE
(
    allowanceId INT IDENTITY(100, 1) PRIMARY KEY  ,
    allowanceStatus varchar(50) DEFAULT 'PENDING',
    allowanceCreatedAt datetime DEFAULT GETDATE(),
    allowanceUpdatedAt DATETIME DEFAULT GETDATE(),
    allowanceAmount DOUBLE PRECISION,
    allowanceSalaryId INT,
    allowanceType VARCHAR(255)
);
GO
CREATE TABLE UWX_ACCOUNT_TYPE
(
    accountTypeId INT IDENTITY(100, 1) PRIMARY KEY  ,
    accountTypeStatus varchar(50) DEFAULT 'PENDING',
    accountTypeCreatedAt datetime DEFAULT GETDATE(),
    accountTypeUpdatedAt DATETIME DEFAULT GETDATE(),
    accountTypeAccountTypeName VARCHAR(255),
    accountTypeDescription VARCHAR(255),
    accountTypeNormalBalance VARCHAR(255)
);
GO
CREATE TABLE UWX_ACCOUNT_MAPPING
(
    accountMappingId INT IDENTITY(100, 1) PRIMARY KEY  ,
    accountMappingStatus varchar(50) DEFAULT 'PENDING',
    accountMappingCreatedAt datetime DEFAULT GETDATE(),
    accountMappingUpdatedAt DATETIME DEFAULT GETDATE(),
    accountMappingCrAccountId INT,
    accountMappingDescription VARCHAR(255),
    accountMappingDrAccountId INT,
    accountMappingTransactionCategoryId INT
);
GO
CREATE TABLE UWX_ACCOUNT
(
    accountId INT IDENTITY(100, 1) PRIMARY KEY  ,
    accountStatus varchar(50) DEFAULT 'PENDING',
    accountCreatedAt datetime DEFAULT GETDATE(),
    accountUpdatedAt DATETIME DEFAULT GETDATE(),
    accountAccountName VARCHAR(255),
    accountAccountTypeId INT,
    accountDescription VARCHAR(255)
);
GO
CREATE TABLE UWX_INVENTORY_ITEM
(
    inventoryItemId INT IDENTITY(100, 1) PRIMARY KEY  ,
    inventoryItemStatus varchar(50) DEFAULT 'PENDING',
    inventoryItemCreatedAt datetime DEFAULT GETDATE(),
    inventoryItemUpdatedAt DATETIME DEFAULT GETDATE(),
    inventoryItemAvailableStock INT,
    inventoryItemCategory VARCHAR(255),
    inventoryItemCurrentStock INT,
    inventoryItemDescription VARCHAR(255),
    inventoryItemMinimumStockLevel INT,
    inventoryItemName VARCHAR(255),
    inventoryItemReservedStock INT,
    inventoryItemUnitCost DOUBLE PRECISION,
    inventoryItemUnitOfMeasure VARCHAR(255)
);
GO
CREATE TABLE UWX_FINISHED_GOOD_DETAILS
(
    finishedGoodDetailsId INT IDENTITY(100, 1) PRIMARY KEY  ,
    finishedGoodDetailsStatus varchar(50) DEFAULT 'PENDING',
    finishedGoodDetailsCreatedAt datetime DEFAULT GETDATE(),
    finishedGoodDetailsUpdatedAt DATETIME DEFAULT GETDATE(),
    finishedGoodDetailsExpiryDate DATETIME,
    finishedGoodDetailsInventoryItemId INT,
    finishedGoodDetailsManufacturingDate DATETIME,
    finishedGoodDetailsProductId INT
);
GO
CREATE TABLE UWX_EXPENSE_ITEM
(
    expenseItemId INT IDENTITY(100, 1) PRIMARY KEY  ,
    expenseItemStatus varchar(50) DEFAULT 'PENDING',
    expenseItemCreatedAt datetime DEFAULT GETDATE(),
    expenseItemUpdatedAt DATETIME DEFAULT GETDATE(),
    expenseItemAmount DOUBLE PRECISION,
    expenseItemCategory VARCHAR(255),
    expenseItemClaimId INT,
    expenseItemDescription VARCHAR(255),
    expenseItemReceiptUrl VARCHAR(255)
);
GO
CREATE TABLE UWX_EXPENSE_CLAIM
(
    expenseClaimId INT IDENTITY(100, 1) PRIMARY KEY  ,
    expenseClaimStatus varchar(50) DEFAULT 'PENDING',
    expenseClaimCreatedAt datetime DEFAULT GETDATE(),
    expenseClaimUpdatedAt DATETIME DEFAULT GETDATE(),
    expenseClaimDecisionDate DATETIME,
    expenseClaimEmployeeId INT,
    expenseClaimReimbursementDate DATETIME,
    expenseClaimReviewerId INT,
    expenseClaimTotalAmount DOUBLE PRECISION
);
GO
CREATE TABLE UWX_EMPLOYEE_ONBOARDING
(
    employeeOnboardingId INT IDENTITY(100, 1) PRIMARY KEY  ,
    employeeOnboardingStatus varchar(50) DEFAULT 'PENDING',
    employeeOnboardingCreatedAt datetime DEFAULT GETDATE(),
    employeeOnboardingUpdatedAt DATETIME DEFAULT GETDATE(),
    employeeOnboardingAssignedBy INT,
    employeeOnboardingAttachmentUrl VARCHAR(255),
    employeeOnboardingCompletedDate DATETIME,
    employeeOnboardingDueDate DATETIME,
    employeeOnboardingEmployeeId INT,
    employeeOnboardingNotes VARCHAR(255),
    employeeOnboardingTaskId INT
);
GO
CREATE TABLE UWX_EMPLOYEE_DOCUMENT
(
    employeeDocumentId INT IDENTITY(100, 1) PRIMARY KEY  ,
    employeeDocumentStatus varchar(50) DEFAULT 'PENDING',
    employeeDocumentCreatedAt datetime DEFAULT GETDATE(),
    employeeDocumentUpdatedAt DATETIME DEFAULT GETDATE(),
    employeeDocumentAccessLevel VARCHAR(255),
    employeeDocumentEmployeeId INT,
    employeeDocumentExpiresAt DATETIME,
    employeeDocumentFileUrl VARCHAR(255),
    employeeDocumentType VARCHAR(255),
    employeeDocumentUploadedBy INT,
    employeeDocumentVersion VARCHAR(255)
);
GO
CREATE TABLE UWX_EMPLOYEE_ACCOUNT
(
    employeeAccountId INT IDENTITY(100, 1) PRIMARY KEY  ,
    employeeAccountStatus varchar(50) DEFAULT 'PENDING',
    employeeAccountCreatedAt datetime DEFAULT GETDATE(),
    employeeAccountUpdatedAt DATETIME DEFAULT GETDATE(),
    employeeAccountBankName VARCHAR(255),
    employeeAccountEmployeeId INT,
    employeeAccountName VARCHAR(255),
    employeeAccountNumber VARCHAR(255)
);
GO
