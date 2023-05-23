/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectionentityservice.controller;

import com.fico.dmp.collectionentityservice.CollectionEntityService;
import io.swagger.client.model.CollectionBillingAccountRefCreate;
import java.lang.Exception;
import io.swagger.client.model.CollectionEntityCreate;
import io.swagger.client.model.CollectionContactCreate;
import io.swagger.client.model.CollectionDisputeCreate;
import io.swagger.client.model.CollectionPaymentArrangementCreate;
import java.lang.String;
import io.swagger.client.model.CollectionPaymentArrangement;
import java.lang.Integer;
import io.swagger.client.model.CollectionBillingAccountRef;
import java.util.List;
import java.lang.Boolean;
import io.swagger.client.model.CollectionEntity;
import io.swagger.client.model.CollectionContact;
import io.swagger.client.model.CollectionDispute;
import io.swagger.client.model.CollectionBillingAccountRefUpdate;
import io.swagger.client.model.CollectionEntityUpdate;
import io.swagger.client.model.CollectionContactUpdate;
import io.swagger.client.model.CollectionDisputeUpdate;
import io.swagger.client.model.CollectionPaymentArrangementUpdate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/collectionEntity")
public class CollectionEntityController {

    @Autowired
    private CollectionEntityService collectionEntityService;

    @RequestMapping(value = "/billingAccountRef", method = RequestMethod.POST)
    public CollectionBillingAccountRefCreate addBillingAccountRef(@RequestBody CollectionBillingAccountRefCreate collectionBillingAccountRefCreate) throws Exception {
        return collectionEntityService.addBillingAccountRef(collectionBillingAccountRefCreate);
    }

    @RequestMapping(value = "/collectionEntity", method = RequestMethod.POST)
    public CollectionEntityCreate addCollectionEntity(@RequestBody CollectionEntityCreate collectionEntityCreate) throws Exception {
        return collectionEntityService.addCollectionEntity(collectionEntityCreate);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public CollectionContactCreate addContact(@RequestBody CollectionContactCreate collectionContactCreate) throws Exception {
        return collectionEntityService.addContact(collectionContactCreate);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.POST)
    public CollectionDisputeCreate addDispute(@RequestBody CollectionDisputeCreate collectionDispute) throws Exception {
        return collectionEntityService.addDispute(collectionDispute);
    }

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.POST)
    public CollectionPaymentArrangement addPaymentArrangement(@RequestBody CollectionPaymentArrangementCreate collectionPaymentArrangementCreate, @RequestParam(value = "entityId", required = false) String entityId) throws Exception {
        return collectionEntityService.addPaymentArrangement(collectionPaymentArrangementCreate, entityId);
    }

    @RequestMapping(value = "/billingAccountRef", method = RequestMethod.GET)
    public List<CollectionBillingAccountRef> getBillingAccountRef(@RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "ban", required = false) String ban, @RequestParam(value = "entityId", required = false) Integer entityId, @RequestParam(value = "id", required = false) Integer id) throws Exception {
        return collectionEntityService.getBillingAccountRef(fields, offset, limit, ban, entityId, id);
    }

    @RequestMapping(value = "/billingAccountRef_1", method = RequestMethod.GET)
    public CollectionBillingAccountRef getBillingAccountRef_1(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "fields", required = false) String fields) throws Exception {
        return collectionEntityService.getBillingAccountRef(id, fields);
    }

    @RequestMapping(value = "/collectionEntity", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionEntity getCollectionEntity(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getCollectionEntity(id, history);
    }

    @RequestMapping(value = "/collectionEntity_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionEntity> getCollectionEntity_1(@RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "ban", required = false) String ban, @RequestParam(value = "rcid", required = false) String rcid, @RequestParam(value = "cbucid", required = false) String cbucid, @RequestParam(value = "entityId", required = false) String entityId, @RequestParam(value = "agentId", required = false) String agentId, @RequestParam(value = "workCategory", required = false) String workCategory, @RequestParam(value = "sortBy", required = false) String sortBy) throws Exception {
        return collectionEntityService.getCollectionEntity(fields, offset, limit, ban, rcid, cbucid, entityId, agentId, workCategory, sortBy);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionContact getContact(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "fields", required = false) String fields) throws Exception {
        return collectionEntityService.getContact(id, fields);
    }

    @RequestMapping(value = "/contact_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionContact> getContact_1(@RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "entityId", required = false) Integer entityId) throws Exception {
        return collectionEntityService.getContact(fields, offset, limit, entityId);
    }

    @RequestMapping(value = "/paymentArrangement/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionPaymentArrangement getPaymentArrangement(@PathVariable("id") Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getPaymentArrangement(id, history);
    }

    @RequestMapping(value = "/paymentArrangements", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionPaymentArrangement> getPaymentArrangements(@RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "agentId", required = false) String agentId, @RequestParam(value = "entityId", required = false) String entityId, @RequestParam(value = "entityRisk", required = false) String entityRisk, @RequestParam(value = "evaluation", required = false) String evaluation, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "createdBy", required = false) String createdBy, @RequestParam(value = "createdFrom", required = false) String createdFrom, @RequestParam(value = "createdTo", required = false) String createdTo) throws Exception {
        return collectionEntityService.getPaymentArrangements(fields, offset, limit, agentId, entityId, entityRisk, evaluation, status, createdBy, createdFrom, createdTo);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.GET)
    public CollectionDispute getdispute(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getdispute(id, fields, history);
    }

    @RequestMapping(value = "/dispute_1", method = RequestMethod.GET)
    public List<CollectionDispute> getdispute_1(@RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "banRefId", required = false) Integer banRefId, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getdispute(fields, offset, limit, banRefId, history);
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public void init() {
        collectionEntityService.init();
    }

    @RequestMapping(value = "/billingAccountRef", method = RequestMethod.PUT)
    public CollectionBillingAccountRefUpdate updateBillingAccountRef(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionBillingAccountRefUpdate collectionBillingAccountRefUpdate) throws Exception {
        return collectionEntityService.updateBillingAccountRef(id, collectionBillingAccountRefUpdate);
    }

    @RequestMapping(value = "/collectionEntity", method = RequestMethod.PUT)
    public CollectionEntityUpdate updateCollectionEntity(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionEntityUpdate collectionEntityUpdate) throws Exception {
        return collectionEntityService.updateCollectionEntity(id, collectionEntityUpdate);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public CollectionContactUpdate updateContact(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionContactUpdate collectionContactUpdate) throws Exception {
        return collectionEntityService.updateContact(id, collectionContactUpdate);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.PUT)
    public CollectionDisputeUpdate updateDispute(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionDisputeUpdate collectionDispute) throws Exception {
        return collectionEntityService.updateDispute(id, collectionDispute);
    }

    @RequestMapping(value = "/parrStatus", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionPaymentArrangement updateParrStatus(@RequestParam(value = "parrId", required = false) Integer parrId, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "comments", required = false) String comments) throws Exception {
        return collectionEntityService.updateParrStatus(parrId, status, comments);
    }

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.PUT)
    public CollectionPaymentArrangement updatePaymentArrangement(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionPaymentArrangementUpdate collectionPaymentArrangementUpdate) throws Exception {
        return collectionEntityService.updatePaymentArrangement(id, collectionPaymentArrangementUpdate);
    }
}
