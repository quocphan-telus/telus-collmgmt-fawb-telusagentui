/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.fico.dmp.telusagentuidb.AuditDataChange;
import com.fico.dmp.telusagentuidb.Document;
import com.fico.dmp.telusagentuidb.DomainValue;
import com.fico.dmp.telusagentuidb.DomainValueType;
import com.fico.dmp.telusagentuidb.FawbPropertySource;
import com.fico.dmp.telusagentuidb.Group;
import com.fico.dmp.telusagentuidb.GroupRole;
import com.fico.dmp.telusagentuidb.Party;
import com.fico.dmp.telusagentuidb.Queue;
import com.fico.dmp.telusagentuidb.Role;
import com.fico.dmp.telusagentuidb.TeamUser;
import com.fico.dmp.telusagentuidb.User;
import com.fico.dmp.telusagentuidb.UserGroup;
import com.fico.dmp.telusagentuidb.UserRole;
import com.fico.dmp.telusagentuidb.WorkcategoryUser;

/**
 * Service object for domain model class {@link User}.
 */
public interface UserService {

    /**
     * Creates a new User. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on User if any.
     *
     * @param user Details of the User to be created; value cannot be null.
     * @return The newly created User.
     */
    User create(@Valid User user);


	/**
     * Returns User by given id if exists.
     *
     * @param userIdInstance The id of the User to get; value cannot be null.
     * @return User associated with the given userIdInstance.
	 * @throws EntityNotFoundException If no User is found.
     */
    User getById(Integer userIdInstance);

    /**
     * Find and return the User by given id if exists, returns null otherwise.
     *
     * @param userIdInstance The id of the User to get; value cannot be null.
     * @return User associated with the given userIdInstance.
     */
    User findById(Integer userIdInstance);

	/**
     * Find and return the list of Users by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param userIdInstances The id's of the User to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Users associated with the given userIdInstances.
     */
    List<User> findByMultipleIds(List<Integer> userIdInstances, boolean orderedReturn);

    /**
     * Find and return the User for given email  if exists.
     *
     * @param email value of email; value cannot be null.
     * @return User associated with the given inputs.
     * @throws EntityNotFoundException if no matching User found.
     */
    User getByEmail(String email);

    /**
     * Find and return the User for given userId  if exists.
     *
     * @param userId value of userId; value cannot be null.
     * @return User associated with the given inputs.
     * @throws EntityNotFoundException if no matching User found.
     */
    User getByUserId(String userId);

    /**
     * Updates the details of an existing User. It replaces all fields of the existing User with the given user.
     *
     * This method overrides the input field values using Server side or database managed properties defined on User if any.
     *
     * @param user The details of the User to be updated; value cannot be null.
     * @return The updated User.
     * @throws EntityNotFoundException if no User is found with given input.
     */
    User update(@Valid User user);

    /**
     * Deletes an existing User with the given id.
     *
     * @param userIdInstance The id of the User to be deleted; value cannot be null.
     * @return The deleted User.
     * @throws EntityNotFoundException if no User found with the given id.
     */
    User delete(Integer userIdInstance);

    /**
     * Deletes an existing User with the given object.
     *
     * @param user The instance of the User to be deleted; value cannot be null.
     */
    void delete(User user);

    /**
     * Find all Users matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Users.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Users matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Users.
     *
     * @see Pageable
     * @see Page
     */
    Page<User> findAll(String query, Pageable pageable);

    /**
     * Exports all Users matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Users matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Imports all Users from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the Users in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the User.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated partiesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Party instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Party> findAssociatedPartiesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated partiesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Party instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Party> findAssociatedPartiesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated rolesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Role instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Role> findAssociatedRolesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated rolesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Role instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Role> findAssociatedRolesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated workcategoryUsers for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated WorkcategoryUser instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<WorkcategoryUser> findAssociatedWorkcategoryUsers(Integer id, Pageable pageable);

    /*
     * Returns the associated domainValuesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated DomainValue instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<DomainValue> findAssociatedDomainValuesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated domainValuesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated DomainValue instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<DomainValue> findAssociatedDomainValuesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated groupRolesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated GroupRole instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<GroupRole> findAssociatedGroupRolesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated groupRolesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated GroupRole instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<GroupRole> findAssociatedGroupRolesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated userRoles for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated UserRole instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserRole> findAssociatedUserRoles(Integer id, Pageable pageable);

    /*
     * Returns the associated queuesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Queue instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Queue> findAssociatedQueuesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated queuesForLockedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Queue instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Queue> findAssociatedQueuesForLockedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated queuesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Queue instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Queue> findAssociatedQueuesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated documentsForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Document instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Document> findAssociatedDocumentsForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated documentsForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Document instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Document> findAssociatedDocumentsForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated auditDataChanges for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated AuditDataChange instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<AuditDataChange> findAssociatedAuditDataChanges(Integer id, Pageable pageable);

    /*
     * Returns the associated teamUsers for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TeamUser instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TeamUser> findAssociatedTeamUsers(Integer id, Pageable pageable);

    /*
     * Returns the associated fawbPropertySourcesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FawbPropertySource instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FawbPropertySource> findAssociatedFawbPropertySourcesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated fawbPropertySourcesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FawbPropertySource instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FawbPropertySource> findAssociatedFawbPropertySourcesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated domainValueTypesForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated DomainValueType instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<DomainValueType> findAssociatedDomainValueTypesForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated domainValueTypesForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated DomainValueType instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<DomainValueType> findAssociatedDomainValueTypesForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated usersForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated User instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<User> findAssociatedUsersForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated usersForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated User instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<User> findAssociatedUsersForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated _groupsForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Group instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Group> findAssociated_groupsForCreatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated _groupsForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Group instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Group> findAssociated_groupsForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated userGroupsForUserId for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated UserGroup instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserGroup> findAssociatedUserGroupsForUserId(Integer id, Pageable pageable);

    /*
     * Returns the associated userGroupsForUpdatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated UserGroup instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserGroup> findAssociatedUserGroupsForUpdatedBy(Integer id, Pageable pageable);

    /*
     * Returns the associated userGroupsForCreatedBy for given User id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated UserGroup instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserGroup> findAssociatedUserGroupsForCreatedBy(Integer id, Pageable pageable);

}