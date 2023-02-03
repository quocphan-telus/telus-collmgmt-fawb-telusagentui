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

import com.fico.dmp.telusagentuidb.Activity;
import com.fico.dmp.telusagentuidb.Application;
import com.fico.dmp.telusagentuidb.AuditDataChange;
import com.fico.dmp.telusagentuidb.Document;
import com.fico.dmp.telusagentuidb.ErrorEntity;
import com.fico.dmp.telusagentuidb.Note;
import com.fico.dmp.telusagentuidb.Party;
import com.fico.dmp.telusagentuidb.service.ApplicationService;


/**
 * Controller object for domain model class Application.
 * @see Application
 */
@RestController("TELUSAgentUIDB.ApplicationController")
@Api(value = "ApplicationController", description = "Exposes APIs to work with Application resource.")
@RequestMapping("/TELUSAgentUIDB/Application")
public class ApplicationController {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(ApplicationController.class.getName());

    @Autowired
	@Qualifier("TELUSAgentUIDB.ApplicationService")
	private ApplicationService applicationService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Application instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Application createApplication(@RequestBody Application application) {
		LOGGER.debug("Create Application with information: {}" , application);

		application = applicationService.create(application);
		LOGGER.debug("Created Application with information: {}" , application);

	    return application;
	}

    @ApiOperation(value = "Returns the Application instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Application getApplication(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Application with id: {}" , id);

        Application foundApplication = applicationService.getById(id);
        LOGGER.debug("Application details with id: {}" , foundApplication);

        return foundApplication;
    }

    @ApiOperation(value = "Updates the Application instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Application editApplication(@PathVariable("id") Integer id, @RequestBody Application application) {
        LOGGER.debug("Editing Application with id: {}" , application.getId());

        application.setId(id);
        application = applicationService.update(application);
        LOGGER.debug("Application details with id: {}" , application);

        return application;
    }

    @ApiOperation(value = "Deletes the Application instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteApplication(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Application with id: {}" , id);

        Application deletedApplication = applicationService.delete(id);

        return deletedApplication != null;
    }

    @RequestMapping(value = "/applicationNumber/{applicationNumber}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Application with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Application getByApplicationNumber(@PathVariable("applicationNumber") String applicationNumber) {
        LOGGER.debug("Getting Application with uniques key ApplicationNumber");
        return applicationService.getByApplicationNumber(applicationNumber);
    }

    /**
     * @deprecated Use {@link #findApplications(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Application instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Application> searchApplicationsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Applications list by query filter:{}", (Object) queryFilters);
        return applicationService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Application instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Application> findApplications(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Applications list by filter:", query);
        return applicationService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Application instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Application> filterApplications(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Applications list by filter", query);
        return applicationService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportApplications(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return applicationService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportApplicationsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Application.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> applicationService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Application instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countApplications( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Applications");
		return applicationService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getApplicationAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return applicationService.getAggregatedValues(aggregationInfo, pageable);
    }

    @ApiOperation(value = "Consumes and inserts csv data into the table")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public void importApplications(@RequestPart("file") @Valid @NotNull MultipartFile file) {
        LOGGER.debug("Importing Application table rows from csv");
        applicationService.importData(file);
    }

    @RequestMapping(value="/{id:.+}/parties", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the parties instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Party> findAssociatedParties(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated parties");
        return applicationService.findAssociatedParties(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/notes", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the notes instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Note> findAssociatedNotes(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated notes");
        return applicationService.findAssociatedNotes(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/documents", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the documents instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Document> findAssociatedDocuments(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated documents");
        return applicationService.findAssociatedDocuments(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/auditDataChanges", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the auditDataChanges instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AuditDataChange> findAssociatedAuditDataChanges(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated auditDataChanges");
        return applicationService.findAssociatedAuditDataChanges(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/errorEntities", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the errorEntities instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ErrorEntity> findAssociatedErrorEntities(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated errorEntities");
        return applicationService.findAssociatedErrorEntities(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/activities", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the activities instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Activity> findAssociatedActivities(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated activities");
        return applicationService.findAssociatedActivities(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ApplicationService instance
	 */
	protected void setApplicationService(ApplicationService service) {
		this.applicationService = service;
	}

}