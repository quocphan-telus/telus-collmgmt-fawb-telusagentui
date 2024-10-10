/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectiontreatmentservice.controller;

import com.fico.dmp.collectiontreatmentservice.CollectionTreatmentService;
import telus.cdo.cnc.collmgmt.collactivitylogmgmt.model.CollectionActivityLog;
import java.lang.Exception;
import telus.cdo.cnc.collmgmt.colltreatmentmgmt.model.CollectionTreatment;
import telus.cdo.cnc.collmgmt.colltreatmentmgmt.model.CollectionTreatmentStepCreate;
import telus.cdo.cnc.collmgmt.colltreatmentmgmt.model.CollectionTreatmentStep;
import java.lang.Integer;
import java.lang.String;
import com.fico.telus.model.CollectionActivityLogRes;
import java.util.List;
import com.fico.telus.model.OrderMgmtHistoryResponse;
import java.lang.Boolean;
import com.fico.telus.model.CollectionTreatmentStepResponse;
import telus.cdo.cnc.collmgmt.colltreatmentmgmt.model.CollectionTreatmentStepUpdate;
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
    public List<CollectionActivityLogRes> getCollectionActivityLog(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "businessEntityEventType", required = false) String businessEntityEventType, @RequestParam(value = "relatedBusinessEntitySubType", required = false) String relatedBusinessEntitySubType, @RequestParam(value = "relatedBusinessEntityId", required = false) String relatedBusinessEntityId, @RequestParam(value = "relatedBusinessEntityType", required = false) String relatedBusinessEntityType, @RequestParam(value = "relatedBusinessEntityStatus", required = false) String relatedBusinessEntityStatus, @RequestParam(value = "relatedBusinessEntityCreatedDate", required = false) String relatedBusinessEntityCreatedDate, @RequestParam(value = "relatedBusinessEntityCreatedBy", required = false) String relatedBusinessEntityCreatedBy, @RequestParam(value = "relatedBusinessEntityAssignedTo", required = false) String relatedBusinessEntityAssignedTo, @RequestParam(value = "relatedBusinessEntityAssignedTeam", required = false) String relatedBusinessEntityAssignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getCollectionActivityLog(collectionEntityId, businessEntityEventType, relatedBusinessEntitySubType, relatedBusinessEntityId, relatedBusinessEntityType, relatedBusinessEntityStatus, relatedBusinessEntityCreatedDate, relatedBusinessEntityCreatedBy, relatedBusinessEntityAssignedTo, relatedBusinessEntityAssignedTeam, fields, offset, limit);
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
    public List<CollectionTreatment> getCollectionTreatment(@RequestParam(value = "entityId", required = false) String entityId, @RequestParam(value = "active", required = false) Boolean active, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionTreatmentService.getCollectionTreatment(entityId, active, fields, offset, limit, history);
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
    public List<CollectionTreatmentStepResponse> getCollectionTreatmentStep(@RequestParam(value = "IsOdManagement", required = false) Boolean IsOdManagement, @RequestParam(value = "collectionTreatmentStepId", required = false) String collectionTreatmentStepId, @RequestParam(value = "entityId", required = false) String entityId, @RequestParam(value = "typeCode", required = false) String typeCode, @RequestParam(value = "createdDate", required = false) String createdDate, @RequestParam(value = "createdBy", required = false) String createdBy, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "assignedAgentId", required = false) String assignedAgentId, @RequestParam(value = "assignedTeam", required = false) String assignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentStep(IsOdManagement, collectionTreatmentStepId, entityId, typeCode, createdDate, createdBy, status, assignedAgentId, assignedTeam, fields, offset, limit);
    }

    @RequestMapping(value = "/collectionTreatmentStepById", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionTreatmentStep getCollectionTreatmentStepById(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "partitionKey", required = false) String partitionKey) throws Exception {
        return collectionTreatmentService.getCollectionTreatmentStepById(id, partitionKey);
    }

    @RequestMapping(value = "/disputeHistoryView", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<OrderMgmtHistoryResponse> getDisputeHistoryView(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "collectionActivityType", required = false) String collectionActivityType, @RequestParam(value = "relatedBusinessEntityId", required = false) String relatedBusinessEntityId, @RequestParam(value = "relatedBusinessEntityType", required = false) String relatedBusinessEntityType, @RequestParam(value = "relatedBusinessEntityStatus", required = false) String relatedBusinessEntityStatus, @RequestParam(value = "relatedBusinessEntityCreatedDate", required = false) String relatedBusinessEntityCreatedDate, @RequestParam(value = "relatedBusinessEntityCreatedBy", required = false) String relatedBusinessEntityCreatedBy, @RequestParam(value = "relatedBusinessEntityAssignedTo", required = false) String relatedBusinessEntityAssignedTo, @RequestParam(value = "relatedBusinessEntityAssignedTeam", required = false) String relatedBusinessEntityAssignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getDisputeHistoryView(collectionEntityId, collectionActivityType, relatedBusinessEntityId, relatedBusinessEntityType, relatedBusinessEntityStatus, relatedBusinessEntityCreatedDate, relatedBusinessEntityCreatedBy, relatedBusinessEntityAssignedTo, relatedBusinessEntityAssignedTeam, fields, offset, limit);
    }

    @RequestMapping(value = "/parrHistoryView", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<OrderMgmtHistoryResponse> getParrHistoryView(@RequestParam(value = "collectionEntityId", required = false) Integer collectionEntityId, @RequestParam(value = "collectionActivityType", required = false) String collectionActivityType, @RequestParam(value = "relatedBusinessEntityId", required = false) String relatedBusinessEntityId, @RequestParam(value = "relatedBusinessEntityType", required = false) String relatedBusinessEntityType, @RequestParam(value = "relatedBusinessEntityStatus", required = false) String relatedBusinessEntityStatus, @RequestParam(value = "relatedBusinessEntityCreatedDate", required = false) String relatedBusinessEntityCreatedDate, @RequestParam(value = "relatedBusinessEntityCreatedBy", required = false) String relatedBusinessEntityCreatedBy, @RequestParam(value = "relatedBusinessEntityAssignedTo", required = false) String relatedBusinessEntityAssignedTo, @RequestParam(value = "relatedBusinessEntityAssignedTeam", required = false) String relatedBusinessEntityAssignedTeam, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionTreatmentService.getParrHistoryView(collectionEntityId, collectionActivityType, relatedBusinessEntityId, relatedBusinessEntityType, relatedBusinessEntityStatus, relatedBusinessEntityCreatedDate, relatedBusinessEntityCreatedBy, relatedBusinessEntityAssignedTo, relatedBusinessEntityAssignedTeam, fields, offset, limit);
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

    @RequestMapping(value = "/collectionTreatmentStepInBulk", method = RequestMethod.PUT, consumes = "multipart/form-data")
    public int updateCollectionTreatmentStepInBulk(@RequestPart(value = "ids") List ids, @RequestPart(value = "partitionKeys") List partitionKeys, @RequestPart(value = "collectionTreatmentStepUpdate") CollectionTreatmentStepUpdate collectionTreatmentStepUpdate) throws Exception {
        return collectionTreatmentService.updateCollectionTreatmentStepInBulk(ids, partitionKeys, collectionTreatmentStepUpdate);
    }
}
