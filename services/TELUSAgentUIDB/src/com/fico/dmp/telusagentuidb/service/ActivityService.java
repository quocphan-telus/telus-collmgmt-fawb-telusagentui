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

import com.fico.dmp.telusagentuidb.Activity;
import com.fico.dmp.telusagentuidb.ActivityPayload;

/**
 * Service object for domain model class {@link Activity}.
 */
public interface ActivityService {

    /**
     * Creates a new Activity. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Activity if any.
     *
     * @param activity Details of the Activity to be created; value cannot be null.
     * @return The newly created Activity.
     */
    Activity create(@Valid Activity activity);


	/**
     * Returns Activity by given id if exists.
     *
     * @param activityId The id of the Activity to get; value cannot be null.
     * @return Activity associated with the given activityId.
	 * @throws EntityNotFoundException If no Activity is found.
     */
    Activity getById(Integer activityId);

    /**
     * Find and return the Activity by given id if exists, returns null otherwise.
     *
     * @param activityId The id of the Activity to get; value cannot be null.
     * @return Activity associated with the given activityId.
     */
    Activity findById(Integer activityId);

	/**
     * Find and return the list of Activities by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param activityIds The id's of the Activity to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Activities associated with the given activityIds.
     */
    List<Activity> findByMultipleIds(List<Integer> activityIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Activity. It replaces all fields of the existing Activity with the given activity.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Activity if any.
     *
     * @param activity The details of the Activity to be updated; value cannot be null.
     * @return The updated Activity.
     * @throws EntityNotFoundException if no Activity is found with given input.
     */
    Activity update(@Valid Activity activity);

    /**
     * Deletes an existing Activity with the given id.
     *
     * @param activityId The id of the Activity to be deleted; value cannot be null.
     * @return The deleted Activity.
     * @throws EntityNotFoundException if no Activity found with the given id.
     */
    Activity delete(Integer activityId);

    /**
     * Deletes an existing Activity with the given object.
     *
     * @param activity The instance of the Activity to be deleted; value cannot be null.
     */
    void delete(Activity activity);

    /**
     * Find all Activities matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Activities.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Activity> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Activities matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Activities.
     *
     * @see Pageable
     * @see Page
     */
    Page<Activity> findAll(String query, Pageable pageable);

    /**
     * Exports all Activities matching the given input query to the given exportType format.
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
     * Exports all Activities matching the given input query to the given exportType format.
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
     * Imports all Activities from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the Activities in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Activity.
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
     * Returns the associated activityPayloads for given Activity id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated ActivityPayload instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<ActivityPayload> findAssociatedActivityPayloads(Integer id, Pageable pageable);

}