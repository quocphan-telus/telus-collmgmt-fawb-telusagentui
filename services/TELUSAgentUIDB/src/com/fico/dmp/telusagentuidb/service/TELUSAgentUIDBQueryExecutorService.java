/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportOptions;

import com.fico.dmp.telusagentuidb.models.query.*;

public interface TELUSAgentUIDBQueryExecutorService {

    Page<GetTeamNameByEmplIdResponse> executeGetTeamNameByEmplId(String emplId, Pageable pageable);

    void exportGetTeamNameByEmplId(String emplId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<CheckforDocumentWithEidResponse> executeCheckforDocumentWithEid(String entityId, Pageable pageable);

    void exportCheckforDocumentWithEid(String entityId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryGetDomainValueByCodeAndTypeCodeResponse> executeQuery_GetDomainValueByCodeAndTypeCode(String selectedLocale, String domainValueCode, String domainValueTypeCode, Pageable pageable);

    void exportQuery_GetDomainValueByCodeAndTypeCode(String selectedLocale, String domainValueCode, String domainValueTypeCode, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetTeamManagersByTeamIdResponse> executeGetTeamManagersByTeamId(String teamId, Pageable pageable);

    void exportGetTeamManagersByTeamId(String teamId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<CountRolePermissionResponse> executeCountRolePermission(String roleId, Pageable pageable);

    void exportCountRolePermission(String roleId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetActiveAgentListWithWorkCategoryResponse> executeGetActiveAgentListWithWorkCategory(Pageable pageable);

    void exportGetActiveAgentListWithWorkCategory(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetRolesAssociatedUsersPermissionsResponse> executeGetRolesAssociatedUsersPermissions(String role, Pageable pageable);

    void exportGetRolesAssociatedUsersPermissions(String role, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetActiveRolesByUserNameResponse> executeGetActiveRolesByUserName(String userName, Pageable pageable);

    void exportGetActiveRolesByUserName(String userName, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<SearchUsersResponse> executeSearchUsers(String userCriteria, String teamId, String role, String workCategory, String managerId, Pageable pageable);

    void exportSearchUsers(String userCriteria, String teamId, String role, String workCategory, String managerId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeDeleteGroupRole(String groupId);

    GetLoggedInUserTeamResponse executeGetLoggedInUserTeam(Integer userId);

    Integer executeDeleteUserRole(String roleId);

    Page<GetPermissionByRoleIdResponse> executeGetPermissionByRoleId(String roleId, Pageable pageable);

    void exportGetPermissionByRoleId(String roleId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryGetDomainValueByIdWithActiveFlagResponse> executeQuery_GetDomainValueByIdWithActiveFlag(String selectedLocale, Integer domainValueId, Boolean showAll, Boolean isActiveFlag, Pageable pageable);

    void exportQuery_GetDomainValueByIdWithActiveFlag(String selectedLocale, Integer domainValueId, Boolean showAll, Boolean isActiveFlag, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetLatestNotesResponse> executeGetLatestNotes(String entityId, Pageable pageable);

    void exportGetLatestNotes(String entityId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetAllRolePermissionResponse> executeGetAllRolePermission(Pageable pageable);

    void exportGetAllRolePermission(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetDocumentByDocIdResponse> executeGetDocumentByDocId(Integer docId, Pageable pageable);

    InputStream getDocumentContentForGetDocumentByDocId(Long id, Integer docId) throws EntityNotFoundException;

    void exportGetDocumentByDocId(Integer docId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetDvTypeByIdResponse> executeGetDvTypeById(Integer id, Pageable pageable);

    void exportGetDvTypeById(Integer id, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryActivityLogResponse> executeQuery_ActivityLog(String userLocale, String applicationNumber, Integer activityType, String activityName, Boolean isAppHistory, Timestamp createdDateStart, Timestamp createdDateEnd, Pageable pageable);

    void exportQuery_ActivityLog(String userLocale, String applicationNumber, Integer activityType, String activityName, Boolean isAppHistory, Timestamp createdDateStart, Timestamp createdDateEnd, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetGroupByUserIdResponse> executeGetGroupByUserId(String userId, Pageable pageable);

    void exportGetGroupByUserId(String userId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetRoleByUserIdResponse> executeGetRoleByUserId(String userId, Pageable pageable);

    void exportGetRoleByUserId(String userId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetTeamsAndAssociatedUsersResponse> executeGetTeamsAndAssociatedUsers(String teamId, Pageable pageable);

    void exportGetTeamsAndAssociatedUsers(String teamId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<DvsearchByCodeAndDescriptionResponse> executeDVSearchByCodeAndDescription(String defaultLocale, String domainValueTypeId, Boolean showAll, Boolean isActiveFlag, String searchValue, Pageable pageable);

    void exportDVSearchByCodeAndDescription(String defaultLocale, String domainValueTypeId, Boolean showAll, Boolean isActiveFlag, String searchValue, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryGetAllDvsByDvtypeWithActiveFlagResponse> executeQuery_GetAllDVsByDVTypeWithActiveFlag(String selectedLocale, String domainValueTypeCode, Boolean showAll, Boolean isActiveFlag, Pageable pageable);

    void exportQuery_GetAllDVsByDVTypeWithActiveFlag(String selectedLocale, String domainValueTypeCode, Boolean showAll, Boolean isActiveFlag, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetManagerByTeamNameResponse> executeGetManagerByTeamName(String teamId, Pageable pageable);

    void exportGetManagerByTeamName(String teamId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetWorkCategoryByUserIdResponse> executeGetWorkCategoryByUserId(String userId, Pageable pageable);

    void exportGetWorkCategoryByUserId(String userId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeDeleteTeamUser(Integer teamId);

    Page<GetTeamManagerByRoleIdResponse> executeGetTeamManagerByRoleId(Integer roleId, Pageable pageable);

    void exportGetTeamManagerByRoleId(Integer roleId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetRolesByGroupIdResponse> executeGetRolesByGroupId(String groupId, Pageable pageable);

    void exportGetRolesByGroupId(String groupId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeDeleteGroupUser(String groupId);

    Page<GetUserListByTeamIdResponse> executeGetUserListByTeamId(String teamid, Pageable pageable);

    void exportGetUserListByTeamId(String teamid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQuery_updateUserDetails(QueryUpdateUserDetailsRequest queryUpdateUserDetailsRequest);

    Page<QueryGetAllDomainValueWithOneParentResponse> executeQuery_GetAllDomainValueWithOneParent(String suppliedLocale, String domainValueTypeCode, Integer parent1domainValueId, String dvDescription, Pageable pageable);

    void exportQuery_GetAllDomainValueWithOneParent(String suppliedLocale, String domainValueTypeCode, Integer parent1domainValueId, String dvDescription, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetWorkCategoriesByEmpIdResponse> executeGetWorkCategoriesByEmpId(String emplId, Pageable pageable);

    void exportGetWorkCategoriesByEmpId(String emplId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQuery_DeleteAllErrorsByApplicationId(String applicationId);

    Page<GetPermissionByUserIdResponse> executeGetPermissionByUserId(String userId, Pageable pageable);

    void exportGetPermissionByUserId(String userId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetTeamManagerNameResponse> executeGetTeamManagerName(String roles, Pageable pageable);

    void exportGetTeamManagerName(String roles, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetWorkCtegoryByCodeResponse> executeGetWorkCtegoryByCode(String workCategory, Pageable pageable);

    void exportGetWorkCtegoryByCode(String workCategory, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryGetQueuesByUserIdResponse> executeQuery_GetQueuesByUserId(Integer userId, Pageable pageable);

    void exportQuery_GetQueuesByUserId(Integer userId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetUserByEmplIdResponse> executeGetUserByEmplId(String emplid, Pageable pageable);

    void exportGetUserByEmplId(String emplid, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeDeleteRolePermission(String roleId);

    Integer executeQueueUnLock(QueueUnLockRequest queueUnLockRequest);

    Integer executeDeleteGroupRoleByRoleId(String roleId);

    Page<QueryGetDomainValueByIdResponse> executeQuery_GetDomainValueById(String selectedLocale, Integer domainValueId, Pageable pageable);

    void exportQuery_GetDomainValueById(String selectedLocale, Integer domainValueId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetRolesPermissionResponse> executeGetRolesPermission(String roleId, Pageable pageable);

    void exportGetRolesPermission(String roleId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetManagerBasedOnTeamIdResponse> executeGetManagerBasedOnTeamId(String teamId, Pageable pageable);

    void exportGetManagerBasedOnTeamId(String teamId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryGetAllDomainValuesTwoParentResponse> executeQuery_GetAllDomainValuesTwoParent(String suppliedLocale, String domainValueTypeCode, Integer parent1domainValueId, Integer parent2domainValueId, String dvDescription, Pageable pageable);

    void exportQuery_GetAllDomainValuesTwoParent(String suppliedLocale, String domainValueTypeCode, Integer parent1domainValueId, Integer parent2domainValueId, String dvDescription, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeDeleteQueueGroup(String queueId, String groupId);

    Page<QueryGetAllDomainValuesByDvTypeCodeResponse> executeQuery_GetAllDomainValuesByDvTypeCode(String selectedLocale, String domainValueTypeCode, Boolean isAlphaSort, Pageable pageable);

    void exportQuery_GetAllDomainValuesByDvTypeCode(String selectedLocale, String domainValueTypeCode, Boolean isAlphaSort, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetPermissionGroupByRoleIdResponse> executeGetPermissionGroupByRoleId(String roleId, Pageable pageable);

    void exportGetPermissionGroupByRoleId(String roleId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetGroupsRolesByUserIdResponse> executeGetGroupsRolesByUserId(String userId, Pageable pageable);

    void exportGetGroupsRolesByUserId(String userId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetManagerByTeamIdResponse> executeGetManagerByTeamId(String teamId, Pageable pageable);

    void exportGetManagerByTeamId(String teamId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<QueryGetDvbyCodeAndTypeCodeWithActiveFlagResponse> executeQuery_GetDVByCodeAndTypeCodeWithActiveFlag(String selectedLocale, String domainValueCode, String domainValueTypeCode, Boolean showAll, Boolean isActiveFlag, Pageable pageable);

    void exportQuery_GetDVByCodeAndTypeCodeWithActiveFlag(String selectedLocale, String domainValueCode, String domainValueTypeCode, Boolean showAll, Boolean isActiveFlag, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Integer executeQueueLock(QueueLockRequest queueLockRequest);

}