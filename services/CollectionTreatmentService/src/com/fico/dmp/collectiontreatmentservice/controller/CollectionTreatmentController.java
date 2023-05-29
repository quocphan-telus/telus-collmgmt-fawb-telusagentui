/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectiontreatmentservice.controller;

import com.fico.dmp.collectiontreatmentservice.CollectionTreatmentService;
import io.swagger.client.model.CollectionActivityLog;
import java.lang.Exception;
import io.swagger.client.model.CollectionTreatment;
import io.swagger.client.model.CollectionTreatmentStepCreate;
import io.swagger.client.model.CollectionTreatmentStep;
import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import java.util.List;
import io.swagger.client.model.CollectionTreatmentStepUpdate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/collectionTreatment")
public class CollectionTreatmentController {

    @Autowired
    private CollectionTreatmentService collectionTreatmentService;

    @RequestMapping(value = "/collectionActivityLog", method = RequestMethod.POST)
    public CollectionActivityLog addCollectionActivityLog(@RequestBody CollectionActivityLog collectionActivityLog) throws Exception {
        return collectionTreatmentService.addCollectionActivityLog(collectionActivityLog);
    }

    @RequestMapping(value = "/collectionTreatment", method = RequestMethod.POST)
    public CollectionTreatment addCollectionTreatment(@RequestBody CollectionTreatment collectionTreatment) throws Exception {
        return collectionTreatmentService.addCollectionTreatment(collectionTreatment);
    }

    @RequestMapping(value = "/collectionTreatmentStep", method = RequestMethod.POST)
    public CollectionTreatmentStep addCollectionTreatmentStep(@RequestBody CollectionTreatmentStepCreate collectionTreatmentStepCreate) throws Exception {
        return collectionTreatmentService.addCollectionTreatmentStep(collectionTreatmentStepCreate);
    }

    @RequestMapping(value = "/collectionActivityLog", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionActivityLog getCollectionActivityLog(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionActivityLog(id, partitionKey);
    }

    @RequestMapping(value = "/collectionActivityLog_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionActivityLog> getCollectionActivityLog_1(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "category", required = false) String category, @RequestParam(value = "createdDate", required = false) String createdDate, @RequestParam(value = "createdBy", required = false) String createdBy, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "assignedTo", required = false) String assignedTo, @RequestParam(value = "assignedTeam", required = false) String assignedTeam, @RequestParam(value = "completionDate", required = false) String completionDate, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionTreatmentService.getCollectionActivityLog(collectionEntityId, type, category, createdDate, createdBy, status, assignedTo, assignedTeam, completionDate, fields, offset, limit, history);
    }

    @RequestMapping(value = "/collectionTreatment", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionTreatment getCollectionTreatment(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionTreatment(id, partitionKey);
    }

    @RequestMapping(value = "/collectionTreatment_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionTreatment> getCollectionTreatment_1(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionTreatmentService.getCollectionTreatment(collectionEntityId, fields, offset, limit, history);
    }

    @RequestMapping(value = "/collectionTreatmentStep", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionTreatmentStep getCollectionTreatmentStep(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentStep(id, partitionKey);
    }

    @RequestMapping(value = "/collectionTreatmentStep_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionTreatmentStep> getCollectionTreatmentStep_1(@RequestParam(value = "collectionTreatmentStepId", required = false) Integer collectionTreatmentStepId, @RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "createdDate", required = false) String createdDate, @RequestParam(value = "createdBy", required = false) String createdBy, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "assignedAgentId", required = false) String assignedAgentId, @RequestParam(value = "assignedTeam", required = false) String assignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentStep(collectionTreatmentStepId, collectionEntityId, type, createdDate, createdBy, status, assignedAgentId, assignedTeam, fields, offset, limit);
    }

    @RequestMapping(value = "/collectionActivityLog", method = RequestMethod.PUT)
    public CollectionActivityLog updateCollectionActivityLog(@RequestParam(value = "id", required = false) String id, @RequestBody CollectionActivityLog collectionActivityLog) throws Exception {
        return collectionTreatmentService.updateCollectionActivityLog(id, collectionActivityLog);
    }

    @RequestMapping(value = "/collectionTreatment", method = RequestMethod.PUT)
    public CollectionTreatment updateCollectionTreatment(@RequestParam(value = "id", required = false) String id, @RequestBody CollectionTreatment collectionTreatment) throws Exception {
        return collectionTreatmentService.updateCollectionTreatment(id, collectionTreatment);
    }

    @RequestMapping(value = "/collectionTreatmentStep", method = RequestMethod.PUT)
    public CollectionTreatmentStep updateCollectionTreatmentStep(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey, @RequestBody CollectionTreatmentStepUpdate collectionTreatmentStepUpdate) throws Exception {
        return collectionTreatmentService.updateCollectionTreatmentStep(id, partitionKey, collectionTreatmentStepUpdate);
    }
}
