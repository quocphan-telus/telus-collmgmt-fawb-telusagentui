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

import com.fico.dmp.telusagentuidb.Group;
import com.fico.dmp.telusagentuidb.GroupRole;
import com.fico.dmp.telusagentuidb.QueueGroup;
import com.fico.dmp.telusagentuidb.UserGroup;

/**
 * Service object for domain model class {@link Group}.
 */
public interface GroupService {

    /**
     * Creates a new Group. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Group if any.
     *
     * @param _group Details of the Group to be created; value cannot be null.
     * @return The newly created Group.
     */
    Group create(@Valid Group _group);


	/**
     * Returns Group by given id if exists.
     *
     * @param groupId The id of the Group to get; value cannot be null.
     * @return Group associated with the given groupId.
	 * @throws EntityNotFoundException If no Group is found.
     */
    Group getById(Integer groupId);

    /**
     * Find and return the Group by given id if exists, returns null otherwise.
     *
     * @param groupId The id of the Group to get; value cannot be null.
     * @return Group associated with the given groupId.
     */
    Group findById(Integer groupId);

	/**
     * Find and return the list of Groups by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param groupIds The id's of the Group to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Groups associated with the given groupIds.
     */
    List<Group> findByMultipleIds(List<Integer> groupIds, boolean orderedReturn);

    /**
     * Find and return the Group for given name  if exists.
     *
     * @param name value of name; value cannot be null.
     * @return Group associated with the given inputs.
     * @throws EntityNotFoundException if no matching Group found.
     */
    Group getByName(String name);

    /**
     * Updates the details of an existing Group. It replaces all fields of the existing Group with the given _group.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Group if any.
     *
     * @param _group The details of the Group to be updated; value cannot be null.
     * @return The updated Group.
     * @throws EntityNotFoundException if no Group is found with given input.
     */
    Group update(@Valid Group _group);

    /**
     * Deletes an existing Group with the given id.
     *
     * @param groupId The id of the Group to be deleted; value cannot be null.
     * @return The deleted Group.
     * @throws EntityNotFoundException if no Group found with the given id.
     */
    Group delete(Integer groupId);

    /**
     * Deletes an existing Group with the given object.
     *
     * @param _group The instance of the Group to be deleted; value cannot be null.
     */
    void delete(Group _group);

    /**
     * Find all Groups matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Groups.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Group> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Groups matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Groups.
     *
     * @see Pageable
     * @see Page
     */
    Page<Group> findAll(String query, Pageable pageable);

    /**
     * Exports all Groups matching the given input query to the given exportType format.
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
     * Exports all Groups matching the given input query to the given exportType format.
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
     * Imports all Groups from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the Groups in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Group.
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
     * Returns the associated userGroups for given Group id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated UserGroup instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserGroup> findAssociatedUserGroups(Integer id, Pageable pageable);

    /*
     * Returns the associated queueGroups for given Group id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated QueueGroup instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<QueueGroup> findAssociatedQueueGroups(Integer id, Pageable pageable);

    /*
     * Returns the associated groupRoles for given Group id.
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