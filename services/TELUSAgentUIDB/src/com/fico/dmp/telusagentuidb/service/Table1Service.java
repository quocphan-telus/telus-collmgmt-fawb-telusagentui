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

import com.fico.dmp.telusagentuidb.Table1;

/**
 * Service object for domain model class {@link Table1}.
 */
public interface Table1Service {

    /**
     * Creates a new Table1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table1 if any.
     *
     * @param table1 Details of the Table1 to be created; value cannot be null.
     * @return The newly created Table1.
     */
    Table1 create(@Valid Table1 table1);


	/**
     * Returns Table1 by given id if exists.
     *
     * @param table1Id The id of the Table1 to get; value cannot be null.
     * @return Table1 associated with the given table1Id.
	 * @throws EntityNotFoundException If no Table1 is found.
     */
    Table1 getById(Integer table1Id);

    /**
     * Find and return the Table1 by given id if exists, returns null otherwise.
     *
     * @param table1Id The id of the Table1 to get; value cannot be null.
     * @return Table1 associated with the given table1Id.
     */
    Table1 findById(Integer table1Id);

	/**
     * Find and return the list of Table1s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param table1Ids The id's of the Table1 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Table1s associated with the given table1Ids.
     */
    List<Table1> findByMultipleIds(List<Integer> table1Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Table1. It replaces all fields of the existing Table1 with the given table1.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table1 if any.
     *
     * @param table1 The details of the Table1 to be updated; value cannot be null.
     * @return The updated Table1.
     * @throws EntityNotFoundException if no Table1 is found with given input.
     */
    Table1 update(@Valid Table1 table1);

    /**
     * Deletes an existing Table1 with the given id.
     *
     * @param table1Id The id of the Table1 to be deleted; value cannot be null.
     * @return The deleted Table1.
     * @throws EntityNotFoundException if no Table1 found with the given id.
     */
    Table1 delete(Integer table1Id);

    /**
     * Deletes an existing Table1 with the given object.
     *
     * @param table1 The instance of the Table1 to be deleted; value cannot be null.
     */
    void delete(Table1 table1);

    /**
     * Find all Table1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Table1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Table1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table1s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table1> findAll(String query, Pageable pageable);

    /**
     * Exports all Table1s matching the given input query to the given exportType format.
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
     * Exports all Table1s matching the given input query to the given exportType format.
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
     * Imports all Table1s from the csv into the table.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     */
    void importData(MultipartFile file);

    /**
     * Retrieve the count of the Table1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Table1.
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