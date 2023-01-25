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

import com.fico.dmp.telusagentuidb.AuditSchema;

/**
 * Service object for domain model class {@link AuditSchema}.
 */
public interface AuditSchemaService {

    /**
     * Creates a new AuditSchema. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AuditSchema if any.
     *
     * @param auditSchema Details of the AuditSchema to be created; value cannot be null.
     * @return The newly created AuditSchema.
     */
    AuditSchema create(@Valid AuditSchema auditSchema);


	/**
     * Returns AuditSchema by given id if exists.
     *
     * @param auditschemaId The id of the AuditSchema to get; value cannot be null.
     * @return AuditSchema associated with the given auditschemaId.
	 * @throws EntityNotFoundException If no AuditSchema is found.
     */
    AuditSchema getById(Integer auditschemaId);

    /**
     * Find and return the AuditSchema by given id if exists, returns null otherwise.
     *
     * @param auditschemaId The id of the AuditSchema to get; value cannot be null.
     * @return AuditSchema associated with the given auditschemaId.
     */
    AuditSchema findById(Integer auditschemaId);

	/**
     * Find and return the list of AuditSchemas by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param auditschemaIds The id's of the AuditSchema to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return AuditSchemas associated with the given auditschemaIds.
     */
    List<AuditSchema> findByMultipleIds(List<Integer> auditschemaIds, boolean orderedReturn);


    /**
     * Updates the details of an existing AuditSchema. It replaces all fields of the existing AuditSchema with the given auditSchema.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AuditSchema if any.
     *
     * @param auditSchema The details of the AuditSchema to be updated; value cannot be null.
     * @return The updated AuditSchema.
     * @throws EntityNotFoundException if no AuditSchema is found with given input.
     */
    AuditSchema update(@Valid AuditSchema auditSchema);

    /**
     * Deletes an existing AuditSchema with the given id.
     *
     * @param auditschemaId The id of the AuditSchema to be deleted; value cannot be null.
     * @return The deleted AuditSchema.
     * @throws EntityNotFoundException if no AuditSchema found with the given id.
     */
    AuditSchema delete(Integer auditschemaId);

    /**
     * Deletes an existing AuditSchema with the given object.
     *
     * @param auditSchema The instance of the AuditSchema to be deleted; value cannot be null.
     */
    void delete(AuditSchema auditSchema);

    /**
     * Find all AuditSchemas matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AuditSchemas.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<AuditSchema> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all AuditSchemas matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AuditSchemas.
     *
     * @see Pageable
     * @see Page
     */
    Page<AuditSchema> findAll(String query, Pageable pageable);

    /**
     * Exports all AuditSchemas matching the given input query to the given exportType format.
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
     * Exports all AuditSchemas matching the given input query to the given exportType format.
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
     * Imports all AuditSchemas from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the AuditSchemas in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the AuditSchema.
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


}