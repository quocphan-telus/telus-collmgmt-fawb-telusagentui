/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.runtime.util.logging.FAWBStaticLoggerBinder;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.fico.dmp.telusagentuidb.DomainValue;
import com.fico.dmp.telusagentuidb.DomainValueType;
import com.fico.dmp.telusagentuidb.DomainValueTypeRelationship;
import com.fico.dmp.telusagentuidb.service.DomainValueTypeService;


/**
 * Controller object for domain model class DomainValueType.
 * @see DomainValueType
 */
@RestController("TELUSAgentUIDB.DomainValueTypeController")
@Api(value = "DomainValueTypeController", description = "Exposes APIs to work with DomainValueType resource.")
@RequestMapping("/TELUSAgentUIDB/DomainValueType")
public class DomainValueTypeController {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(DomainValueTypeController.class.getName());

    @Autowired
	@Qualifier("TELUSAgentUIDB.DomainValueTypeService")
	private DomainValueTypeService domainValueTypeService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new DomainValueType instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DomainValueType createDomainValueType(@RequestBody DomainValueType domainValueType) {
		LOGGER.debug("Create DomainValueType with information: {}" , domainValueType);

		domainValueType = domainValueTypeService.create(domainValueType);
		LOGGER.debug("Created DomainValueType with information: {}" , domainValueType);

	    return domainValueType;
	}

    @ApiOperation(value = "Returns the DomainValueType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DomainValueType getDomainValueType(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting DomainValueType with id: {}" , id);

        DomainValueType foundDomainValueType = domainValueTypeService.getById(id);
        LOGGER.debug("DomainValueType details with id: {}" , foundDomainValueType);

        return foundDomainValueType;
    }

    @ApiOperation(value = "Updates the DomainValueType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DomainValueType editDomainValueType(@PathVariable("id") Integer id, @RequestBody DomainValueType domainValueType) {
        LOGGER.debug("Editing DomainValueType with id: {}" , domainValueType.getId());

        domainValueType.setId(id);
        domainValueType = domainValueTypeService.update(domainValueType);
        LOGGER.debug("DomainValueType details with id: {}" , domainValueType);

        return domainValueType;
    }

    @ApiOperation(value = "Deletes the DomainValueType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDomainValueType(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting DomainValueType with id: {}" , id);

        DomainValueType deletedDomainValueType = domainValueTypeService.delete(id);

        return deletedDomainValueType != null;
    }

    /**
     * @deprecated Use {@link #findDomainValueTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DomainValueType instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<DomainValueType> searchDomainValueTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DomainValueTypes list by query filter:{}", (Object) queryFilters);
        return domainValueTypeService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DomainValueType instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DomainValueType> findDomainValueTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DomainValueTypes list by filter:", query);
        return domainValueTypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DomainValueType instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<DomainValueType> filterDomainValueTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DomainValueTypes list by filter", query);
        return domainValueTypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportDomainValueTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return domainValueTypeService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportDomainValueTypesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = DomainValueType.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> domainValueTypeService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of DomainValueType instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countDomainValueTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DomainValueTypes");
		return domainValueTypeService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getDomainValueTypeAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return domainValueTypeService.getAggregatedValues(aggregationInfo, pageable);
    }

    @ApiOperation(value = "Consumes and inserts csv data into the table")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public void importDomainValueTypes(@RequestPart("file") @Valid @NotNull MultipartFile file) {
        LOGGER.debug("Importing DomainValueType table rows from csv");
        domainValueTypeService.importData(file);
    }

    @RequestMapping(value="/{id:.+}/domainValues", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the domainValues instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DomainValue> findAssociatedDomainValues(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated domainValues");
        return domainValueTypeService.findAssociatedDomainValues(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/domainValueTypeRelationshipsForDomainValueTypeId", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the domainValueTypeRelationshipsForDomainValueTypeId instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DomainValueTypeRelationship> findAssociatedDomainValueTypeRelationshipsForDomainValueTypeId(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated domainValueTypeRelationshipsForDomainValueTypeId");
        return domainValueTypeService.findAssociatedDomainValueTypeRelationshipsForDomainValueTypeId(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/domainValueTypeRelationshipsForParentDomainValueTypeId2", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the domainValueTypeRelationshipsForParentDomainValueTypeId2 instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DomainValueTypeRelationship> findAssociatedDomainValueTypeRelationshipsForParentDomainValueTypeId2(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated domainValueTypeRelationshipsForParentDomainValueTypeId2");
        return domainValueTypeService.findAssociatedDomainValueTypeRelationshipsForParentDomainValueTypeId2(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/domainValueTypeRelationshipsForParentDomainValueTypeId1", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the domainValueTypeRelationshipsForParentDomainValueTypeId1 instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DomainValueTypeRelationship> findAssociatedDomainValueTypeRelationshipsForParentDomainValueTypeId1(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated domainValueTypeRelationshipsForParentDomainValueTypeId1");
        return domainValueTypeService.findAssociatedDomainValueTypeRelationshipsForParentDomainValueTypeId1(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DomainValueTypeService instance
	 */
	protected void setDomainValueTypeService(DomainValueTypeService service) {
		this.domainValueTypeService = service;
	}

}