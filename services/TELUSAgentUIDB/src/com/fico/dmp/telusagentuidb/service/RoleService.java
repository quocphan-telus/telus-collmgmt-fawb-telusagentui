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

import com.fico.dmp.telusagentuidb.GroupRole;
import com.fico.dmp.telusagentuidb.Role;
import com.fico.dmp.telusagentuidb.RolePermission;
import com.fico.dmp.telusagentuidb.UserRole;

/**
 * Service object for domain model class {@link Role}.
 */
public interface RoleService {

    /**
     * Creates a new Role. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Role if any.
     *
     * @param roleInstance Details of the Role to be created; value cannot be null.
     * @return The newly created Role.
     */
    Role create(@Valid Role roleInstance);


	/**
     * Returns Role by given id if exists.
     *
     * @param roleId The id of the Role to get; value cannot be null.
     * @return Role associated with the given roleId.
	 * @throws EntityNotFoundException If no Role is found.
     */
    Role getById(Integer roleId);

    /**
     * Find and return the Role by given id if exists, returns null otherwise.
     *
     * @param roleId The id of the Role to get; value cannot be null.
     * @return Role associated with the given roleId.
     */
    Role findById(Integer roleId);

	/**
     * Find and return the list of Roles by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param roleIds The id's of the Role to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Roles associated with the given roleIds.
     */
    List<Role> findByMultipleIds(List<Integer> roleIds, boolean orderedReturn);

    /**
     * Find and return the Role for given role  if exists.
     *
     * @param role value of role; value cannot be null.
     * @return Role associated with the given inputs.
     * @throws EntityNotFoundException if no matching Role found.
     */
    Role getByRole(String role);

    /**
     * Updates the details of an existing Role. It replaces all fields of the existing Role with the given roleInstance.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Role if any.
     *
     * @param roleInstance The details of the Role to be updated; value cannot be null.
     * @return The updated Role.
     * @throws EntityNotFoundException if no Role is found with given input.
     */
    Role update(@Valid Role roleInstance);

    /**
     * Deletes an existing Role with the given id.
     *
     * @param roleId The id of the Role to be deleted; value cannot be null.
     * @return The deleted Role.
     * @throws EntityNotFoundException if no Role found with the given id.
     */
    Role delete(Integer roleId);

    /**
     * Deletes an existing Role with the given object.
     *
     * @param roleInstance The instance of the Role to be deleted; value cannot be null.
     */
    void delete(Role roleInstance);

    /**
     * Find all Roles matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Roles.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Role> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Roles matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Roles.
     *
     * @see Pageable
     * @see Page
     */
    Page<Role> findAll(String query, Pageable pageable);

    /**
     * Exports all Roles matching the given input query to the given exportType format.
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
     * Exports all Roles matching the given input query to the given exportType format.
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
     * Imports all Roles from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the Roles in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Role.
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
     * Returns the associated userRoles for given Role id.
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
     * Returns the associated rolePermissions for given Role id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated RolePermission instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<RolePermission> findAssociatedRolePermissions(Integer id, Pageable pageable);

    /*
     * Returns the associated groupRoles for given Role id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated GroupRole instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<GroupRole> findAssociatedGroupRoles(Integer id, Pageable pageable);

}