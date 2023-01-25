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

import com.fico.dmp.telusagentuidb.RolePermission;
import com.fico.dmp.telusagentuidb.service.RolePermissionService;


/**
 * Controller object for domain model class RolePermission.
 * @see RolePermission
 */
@RestController("TELUSAgentUIDB.RolePermissionController")
@Api(value = "RolePermissionController", description = "Exposes APIs to work with RolePermission resource.")
@RequestMapping("/TELUSAgentUIDB/RolePermission")
public class RolePermissionController {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(RolePermissionController.class.getName());

    @Autowired
	@Qualifier("TELUSAgentUIDB.RolePermissionService")
	private RolePermissionService rolePermissionService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new RolePermission instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RolePermission createRolePermission(@RequestBody RolePermission rolePermission) {
		LOGGER.debug("Create RolePermission with information: {}" , rolePermission);

		rolePermission = rolePermissionService.create(rolePermission);
		LOGGER.debug("Created RolePermission with information: {}" , rolePermission);

	    return rolePermission;
	}

    @ApiOperation(value = "Returns the RolePermission instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RolePermission getRolePermission(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RolePermission with id: {}" , id);

        RolePermission foundRolePermission = rolePermissionService.getById(id);
        LOGGER.debug("RolePermission details with id: {}" , foundRolePermission);

        return foundRolePermission;
    }

    @ApiOperation(value = "Updates the RolePermission instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RolePermission editRolePermission(@PathVariable("id") Integer id, @RequestBody RolePermission rolePermission) {
        LOGGER.debug("Editing RolePermission with id: {}" , rolePermission.getId());

        rolePermission.setId(id);
        rolePermission = rolePermissionService.update(rolePermission);
        LOGGER.debug("RolePermission details with id: {}" , rolePermission);

        return rolePermission;
    }

    @ApiOperation(value = "Deletes the RolePermission instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRolePermission(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RolePermission with id: {}" , id);

        RolePermission deletedRolePermission = rolePermissionService.delete(id);

        return deletedRolePermission != null;
    }

    /**
     * @deprecated Use {@link #findRolePermissions(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RolePermission instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<RolePermission> searchRolePermissionsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RolePermissions list by query filter:{}", (Object) queryFilters);
        return rolePermissionService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RolePermission instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RolePermission> findRolePermissions(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RolePermissions list by filter:", query);
        return rolePermissionService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RolePermission instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<RolePermission> filterRolePermissions(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RolePermissions list by filter", query);
        return rolePermissionService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportRolePermissions(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return rolePermissionService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportRolePermissionsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = RolePermission.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> rolePermissionService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of RolePermission instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countRolePermissions( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RolePermissions");
		return rolePermissionService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getRolePermissionAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return rolePermissionService.getAggregatedValues(aggregationInfo, pageable);
    }

    @ApiOperation(value = "Consumes and inserts csv data into the table")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public void importRolePermissions(@RequestPart("file") @Valid @NotNull MultipartFile file) {
        LOGGER.debug("Importing RolePermission table rows from csv");
        rolePermissionService.importData(file);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RolePermissionService instance
	 */
	protected void setRolePermissionService(RolePermissionService service) {
		this.rolePermissionService = service;
	}

}