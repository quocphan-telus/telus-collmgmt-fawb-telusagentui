/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectiondataservice.controller;

import com.fico.dmp.collectiondataservice.CollectionDataService;
import java.lang.String;
import java.lang.Integer;
import java.lang.Exception;
import io.swagger.client.model.AssignedEntitiesInEntityViewResponseArray;
import io.swagger.client.model.EntityBanDetailsResponse;
import java.util.List;
import io.swagger.client.model.EntitySearchResponseArray;
import io.swagger.client.model.CollectionDispute;
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

    @RequestMapping(value = "/assignedEntitiesInEntityView", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public AssignedEntitiesInEntityViewResponseArray getAssignedEntitiesInEntityView(@RequestParam(value = "agentId", required = false) String agentId, @RequestParam(value = "workCategory", required = false) String workCategory, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getAssignedEntitiesInEntityView(agentId, workCategory, offset, limit);
    }

    @RequestMapping(value = "/entityBanDetails", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<EntityBanDetailsResponse> getEntityBanDetails(@RequestParam(value = "entityId", required = false) String entityId) throws Exception {
        return collectionDataService.getEntityBanDetails(entityId);
    }

    @RequestMapping(value = "/entitySearch", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public EntitySearchResponseArray getEntitySearch(@RequestParam(value = "inputType", required = false) String inputType, @RequestParam(value = "inputValue", required = false) String inputValue, @RequestParam(value = "searchMatchCriteria", required = false) String searchMatchCriteria, @RequestParam(value = "billingSystem", required = false) String billingSystem, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        return collectionDataService.getEntitySearch(inputType, inputValue, searchMatchCriteria, billingSystem, offset, limit);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionDispute> getdispute(@RequestParam(value = "banRefId", required = false) String banRefId) throws Exception {
        return collectionDataService.getdispute(banRefId);
    }
}
