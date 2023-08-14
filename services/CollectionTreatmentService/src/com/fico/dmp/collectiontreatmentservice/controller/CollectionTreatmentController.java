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
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import com.fico.telus.model.OrderMgmtHistoryResponse;
import java.lang.Boolean;
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
    public List<CollectionActivityLog> getCollectionActivityLog(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "collectionActivityType", required = false) String collectionActivityType, @RequestParam(value = "relatedBusinessEntitySubType", required = false) String relatedBusinessEntitySubType, @RequestParam(value = "relatedBusinessEntityId", required = false) String relatedBusinessEntityId, @RequestParam(value = "relatedBusinessEntityType", required = false) String relatedBusinessEntityType, @RequestParam(value = "relatedBusinessEntityStatus", required = false) String relatedBusinessEntityStatus, @RequestParam(value = "relatedBusinessEntityCreatedDate", required = false) String relatedBusinessEntityCreatedDate, @RequestParam(value = "relatedBusinessEntityCreatedBy", required = false) String relatedBusinessEntityCreatedBy, @RequestParam(value = "relatedBusinessEntityAssignedTo", required = false) String relatedBusinessEntityAssignedTo, @RequestParam(value = "relatedBusinessEntityAssignedTeam", required = false) String relatedBusinessEntityAssignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getCollectionActivityLog(collectionEntityId, collectionActivityType, relatedBusinessEntitySubType, relatedBusinessEntityId, relatedBusinessEntityType, relatedBusinessEntityStatus, relatedBusinessEntityCreatedDate, relatedBusinessEntityCreatedBy, relatedBusinessEntityAssignedTo, relatedBusinessEntityAssignedTeam, fields, offset, limit);
    }

    @RequestMapping(value = "/collectionActivityLogById", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionActivityLog getCollectionActivityLogById(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionActivityLogById(id, partitionKey);
    }

    @RequestMapping(value = "/collectionHistoryView", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<OrderMgmtHistoryResponse> getCollectionHistoryView(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "collectionActivityType", required = false) String collectionActivityType, @RequestParam(value = "relatedBusinessEntityId", required = false) String relatedBusinessEntityId, @RequestParam(value = "relatedBusinessEntityType", required = false) String relatedBusinessEntityType, @RequestParam(value = "relatedBusinessEntityStatus", required = false) String relatedBusinessEntityStatus, @RequestParam(value = "relatedBusinessEntityCreatedDate", required = false) String relatedBusinessEntityCreatedDate, @RequestParam(value = "relatedBusinessEntityCreatedBy", required = false) String relatedBusinessEntityCreatedBy, @RequestParam(value = "relatedBusinessEntityAssignedTo", required = false) String relatedBusinessEntityAssignedTo, @RequestParam(value = "relatedBusinessEntityAssignedTeam", required = false) String relatedBusinessEntityAssignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getCollectionHistoryView(collectionEntityId, collectionActivityType, relatedBusinessEntityId, relatedBusinessEntityType, relatedBusinessEntityStatus, relatedBusinessEntityCreatedDate, relatedBusinessEntityCreatedBy, relatedBusinessEntityAssignedTo, relatedBusinessEntityAssignedTeam, fields, offset, limit);
    }

    @RequestMapping(value = "/collectionTreatment", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionTreatment> getCollectionTreatment(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionTreatmentService.getCollectionTreatment(collectionEntityId, fields, offset, limit, history);
    }

    @RequestMapping(value = "/collectionTreatmentById", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionTreatment getCollectionTreatmentById(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentById(id, partitionKey);
    }

    @RequestMapping(value = "/collectionTreatmentStep", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionTreatmentStep> getCollectionTreatmentStep(@RequestParam(value = "IsOdManagement", required = false) Boolean IsOdManagement, @RequestParam(value = "collectionTreatmentStepId", required = false) Integer collectionTreatmentStepId, @RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "createdDate", required = false) String createdDate, @RequestParam(value = "createdBy", required = false) String createdBy, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "assignedAgentId", required = false) String assignedAgentId, @RequestParam(value = "assignedTeam", required = false) String assignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentStep(IsOdManagement, collectionTreatmentStepId, collectionEntityId, type, createdDate, createdBy, status, assignedAgentId, assignedTeam, fields, offset, limit);
    }

    @RequestMapping(value = "/collectionTreatmentStepById", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionTreatmentStep getCollectionTreatmentStepById(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentStepById(id, partitionKey);
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public void init() {
        collectionTreatmentService.init();
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
    public CollectionTreatmentStep updateCollectionTreatmentStep(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey, @RequestParam(value = "collectionEntityId", required = false) String collectionEntityId, @RequestBody CollectionTreatmentStepUpdate collectionTreatmentStepUpdate) throws Exception {
        return collectionTreatmentService.updateCollectionTreatmentStep(id, partitionKey, collectionEntityId, collectionTreatmentStepUpdate);
    }
}
