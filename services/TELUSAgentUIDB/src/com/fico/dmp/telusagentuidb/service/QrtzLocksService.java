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

import com.fico.dmp.telusagentuidb.QrtzLocks;
import com.fico.dmp.telusagentuidb.QrtzLocksId;

/**
 * Service object for domain model class {@link QrtzLocks}.
 */
public interface QrtzLocksService {

    /**
     * Creates a new QrtzLocks. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on QrtzLocks if any.
     *
     * @param qrtzLocks Details of the QrtzLocks to be created; value cannot be null.
     * @return The newly created QrtzLocks.
     */
    QrtzLocks create(@Valid QrtzLocks qrtzLocks);


	/**
     * Returns QrtzLocks by given id if exists.
     *
     * @param qrtzlocksId The id of the QrtzLocks to get; value cannot be null.
     * @return QrtzLocks associated with the given qrtzlocksId.
	 * @throws EntityNotFoundException If no QrtzLocks is found.
     */
    QrtzLocks getById(QrtzLocksId qrtzlocksId);

    /**
     * Find and return the QrtzLocks by given id if exists, returns null otherwise.
     *
     * @param qrtzlocksId The id of the QrtzLocks to get; value cannot be null.
     * @return QrtzLocks associated with the given qrtzlocksId.
     */
    QrtzLocks findById(QrtzLocksId qrtzlocksId);

	/**
     * Find and return the list of QrtzLocks by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param qrtzlocksIds The id's of the QrtzLocks to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return QrtzLocks associated with the given qrtzlocksIds.
     */
    List<QrtzLocks> findByMultipleIds(List<QrtzLocksId> qrtzlocksIds, boolean orderedReturn);


    /**
     * Updates the details of an existing QrtzLocks. It replaces all fields of the existing QrtzLocks with the given qrtzLocks.
     *
     * This method overrides the input field values using Server side or database managed properties defined on QrtzLocks if any.
     *
     * @param qrtzLocks The details of the QrtzLocks to be updated; value cannot be null.
     * @return The updated QrtzLocks.
     * @throws EntityNotFoundException if no QrtzLocks is found with given input.
     */
    QrtzLocks update(@Valid QrtzLocks qrtzLocks);

    /**
     * Deletes an existing QrtzLocks with the given id.
     *
     * @param qrtzlocksId The id of the QrtzLocks to be deleted; value cannot be null.
     * @return The deleted QrtzLocks.
     * @throws EntityNotFoundException if no QrtzLocks found with the given id.
     */
    QrtzLocks delete(QrtzLocksId qrtzlocksId);

    /**
     * Deletes an existing QrtzLocks with the given object.
     *
     * @param qrtzLocks The instance of the QrtzLocks to be deleted; value cannot be null.
     */
    void delete(QrtzLocks qrtzLocks);

    /**
     * Find all QrtzLocks matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching QrtzLocks.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<QrtzLocks> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all QrtzLocks matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching QrtzLocks.
     *
     * @see Pageable
     * @see Page
     */
    Page<QrtzLocks> findAll(String query, Pageable pageable);

    /**
     * Exports all QrtzLocks matching the given input query to the given exportType format.
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
     * Exports all QrtzLocks matching the given input query to the given exportType format.
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
     * Imports all QrtzLocks from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the QrtzLocks in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the QrtzLocks.
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