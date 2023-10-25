/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectiondataservice.controller;

import com.fico.dmp.collectiondataservice.CollectionDataService;
import java.lang.String;
import java.util.Date;
import java.lang.Integer;
import java.lang.Exception;
import com.fico.telus.model.TeamsActionViewResponseWIthTotalCount;
import java.util.List;
import com.fico.telus.model.AssignedEntitiesInEntityModel;
import io.swagger.client.model.EntityBanDetailsResponse;
import io.swagger.client.model.EntityContactsResponse;
import io.swagger.client.model.EntityDetailsResponse;
import com.fico.telus.model.LookUpResponseWithTeamName;
import com.fico.telus.model.AssignedEntitiesInClassicModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/collectionData")
public class CollectionDataController {

    @Autowired
    private CollectionDataService collectionDataService;

    @RequestMapping(value = "/actionViewByTeam", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<TeamsActionViewResponseWIthTotalCount> getActionViewByTeam(@RequestParam(value = "assignedAgent", required = false) String assignedAgent, @RequestParam(value = "assignedTeam", required = false) String assignedTeam, @RequestParam(value = "entityOwner", required = false) String entityOwner, @RequestParam(value = "fromDueDate", required = false) Date fromDueDate, @RequestParam(value = "toDueDate", required = false) Date toDueDate, @RequestParam(value = "actionType", required = false) String actionType, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "workCategory", required = false) String workCategory, @RequestParam(value = "viewType", required = false) String viewType, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getActionViewByTeam(assignedAgent, assignedTeam, entityOwner, fromDueDate, toDueDate, actionType, status, workCategory, viewType, offset, limit);
    }

    @RequestMapping(value = "/assignedEntitiesInEntityView", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<AssignedEntitiesInEntityModel> getAssignedEntitiesInEntityView(@RequestParam(value = "entityOwner", required = false) String entityOwner, @RequestParam(value = "workCategory", required = false) String workCategory, @RequestParam(value = "portfolio", required = false) String portfolio, @RequestParam(value = "billingSystem", required = false) String billingSystem, @RequestParam(value = "collectionStatus", required = false) String collectionStatus, @RequestParam(value = "includeCurrentOrCredit", required = false) String includeCurrentOrCredit, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getAssignedEntitiesInEntityView(entityOwner, workCategory, portfolio, billingSystem, collectionStatus, includeCurrentOrCredit, offset, limit);
    }

    @RequestMapping(value = "/entityBanDetails", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<EntityBanDetailsResponse> getEntityBanDetails(@RequestParam(value = "entityId", required = false) Integer entityId, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getEntityBanDetails(entityId, offset, limit);
    }

    @RequestMapping(value = "/entityContacts", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public EntityContactsResponse getEntityContacts(@RequestParam(value = "entityId", required = false) Integer entityId) throws Exception {
        return collectionDataService.getEntityContacts(entityId);
    }

    @RequestMapping(value = "/entityDetails", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public EntityDetailsResponse getEntityDetails(@RequestParam(value = "entityId", required = false) @ApiParam(value = "34343") String entityId) throws Exception {
        return collectionDataService.getEntityDetails(entityId);
    }

    @RequestMapping(value = "/entitySearch", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<LookUpResponseWithTeamName> getEntitySearch(@RequestParam(value = "inputType", required = false) String inputType, @RequestParam(value = "inputValue", required = false) String inputValue, @RequestParam(value = "level", required = false) String level, @RequestParam(value = "searchMatchCriteria", required = false) String searchMatchCriteria, @RequestParam(value = "billingSystem", required = false) String billingSystem, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getEntitySearch(inputType, inputValue, level, searchMatchCriteria, billingSystem, offset, limit);
    }

    @RequestMapping(value = "/assignedEntitiesInClassicView", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<AssignedEntitiesInClassicModel> getassignedEntitiesInClassicView(@RequestParam(value = "entityOwner", required = false) String entityOwner, @RequestParam(value = "workCategory", required = false) String workCategory, @RequestParam(value = "portfolio", required = false) String portfolio, @RequestParam(value = "billingSystem", required = false) String billingSystem, @RequestParam(value = "collectionStatus", required = false) String collectionStatus, @RequestParam(value = "includeCurrentOrCredit", required = false) String includeCurrentOrCredit, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getassignedEntitiesInClassicView(entityOwner, workCategory, portfolio, billingSystem, collectionStatus, includeCurrentOrCredit, offset, limit);
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public void init() {
        collectionDataService.init();
    }
}
