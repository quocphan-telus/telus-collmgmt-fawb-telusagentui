/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectionentityservice.controller;

import com.fico.dmp.collectionentityservice.CollectionEntityService;
import io.swagger.client.model.CollectionBillingAccountRefCreate;
import java.lang.Exception;
import io.swagger.client.model.CollectionContactCreate;
import io.swagger.client.model.CollectionEntityCreate;
import io.swagger.client.model.CollectionDisputeCreate;
import io.swagger.client.model.CollectionPaymentArrangementCreate;
import io.swagger.client.model.CollectionSuppressionCreate;
import java.lang.String;
import java.lang.Boolean;
import io.swagger.client.model.CollectionBillingAccountRef;
import java.util.List;
import java.lang.Integer;
import io.swagger.client.model.CollectionContactArray;
import io.swagger.client.model.CollectionContact;
import io.swagger.client.model.CollectionEntity;
import io.swagger.client.model.CollectionEntityArray;
import io.swagger.client.model.CollectionPaymentArrangement;
import io.swagger.client.model.CollectionSuppressionArray;
import io.swagger.client.model.CollectionSuppression;
import io.swagger.client.model.CollectionDispute;
import io.swagger.client.model.CollectionBillingAccountRefUpdate;
import io.swagger.client.model.CollectionContactUpdate;
import io.swagger.client.model.CollectionEntityUpdate;
import io.swagger.client.model.CollectionDisputeUpdate;
import io.swagger.client.model.CollectionPaymentArrangementUpdate;
import io.swagger.client.model.CollectionSuppressionUpdate;
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

    @RequestMapping(value = "/collectioncontact", method = RequestMethod.POST)
    public CollectionContactCreate addCollectionContact(@RequestBody CollectionContactCreate collectionContactCreate) throws Exception {
        return collectionEntityService.addCollectionContact(collectionContactCreate);
    }

    @RequestMapping(value = "/collectionEntity", method = RequestMethod.POST)
    public CollectionEntityCreate addCollectionEntity(@RequestBody CollectionEntityCreate collectionEntityCreate) throws Exception {
        return collectionEntityService.addCollectionEntity(collectionEntityCreate);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.POST)
    public CollectionDisputeCreate addDispute(@RequestBody CollectionDisputeCreate collectionDispute) throws Exception {
        return collectionEntityService.addDispute(collectionDispute);
    }

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.POST)
    public CollectionPaymentArrangementCreate addPaymentArrangement(@RequestBody CollectionPaymentArrangementCreate collectionPaymentArrangementCreate) throws Exception {
        return collectionEntityService.addPaymentArrangement(collectionPaymentArrangementCreate);
    }

    @RequestMapping(value = "/suppression", method = RequestMethod.POST)
    public CollectionSuppressionCreate addSuppression(@RequestBody CollectionSuppressionCreate collectionSuppressionCreate) throws Exception {
        return collectionEntityService.addSuppression(collectionSuppressionCreate);
    }

    @RequestMapping(value = "/billingAccountRef", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionBillingAccountRef> getBillingAccountRef(@RequestParam(value = "ban", required = false) String ban, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getBillingAccountRef(ban, history);
    }

    @RequestMapping(value = "/billingAccountRef_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionBillingAccountRef getBillingAccountRef_1(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getBillingAccountRef(id, history);
    }

    @RequestMapping(value = "/collectioncontact", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionContactArray> getCollectionContact(@RequestParam(value = "ban", required = false) String ban, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getCollectionContact(ban, history);
    }

    @RequestMapping(value = "/collectioncontact/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionContact getCollectionContact_1(@PathVariable("id") Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getCollectionContact(id, history);
    }

    @RequestMapping(value = "/collectionEntityArray/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionEntity getCollectionEntityArray(@PathVariable("id") Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getCollectionEntityArray(id, history);
    }

    @RequestMapping(value = "/collectionEntityArray", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionEntityArray> getCollectionEntityArray_1(@RequestParam(value = "ban", required = false) String ban, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getCollectionEntityArray(ban, history);
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
    public List<CollectionPaymentArrangement> getPaymentArrangements(@RequestParam(value = "entityId", required = false) String entityId) throws Exception {
        return collectionEntityService.getPaymentArrangements(entityId);
    }

    @RequestMapping(value = "/suppression", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionSuppressionArray> getSuppression(@RequestParam(value = "banRefId", required = false) String banRefId) throws Exception {
        return collectionEntityService.getSuppression(banRefId);
    }

    @RequestMapping(value = "/suppression_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionSuppression getSuppression_1(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getSuppression(id, fields, history);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionDispute> getdispute(@RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "banRefId", required = false) Integer banRefId, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getdispute(fields, offset, limit, banRefId, history);
    }

    @RequestMapping(value = "/dispute_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionDispute getdispute_1(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "fields", required = false) String fields, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntityService.getdispute(id, fields, history);
    }

    @RequestMapping(value = "/billingAccountRef", method = RequestMethod.PUT)
    public CollectionBillingAccountRefUpdate updateBillingAccountRef(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionBillingAccountRefUpdate collectionBillingAccountRefUpdate) throws Exception {
        return collectionEntityService.updateBillingAccountRef(id, collectionBillingAccountRefUpdate);
    }

    @RequestMapping(value = "/collectioncontact", method = RequestMethod.PUT)
    public CollectionContactUpdate updateCollectionContact(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionContactUpdate collectionContactUpdate) throws Exception {
        return collectionEntityService.updateCollectionContact(id, collectionContactUpdate);
    }

    @RequestMapping(value = "/collectionEntity", method = RequestMethod.PUT)
    public CollectionEntityUpdate updateCollectionEntity(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionEntityUpdate collectionEntityUpdate) throws Exception {
        return collectionEntityService.updateCollectionEntity(id, collectionEntityUpdate);
    }

    @RequestMapping(value = "/dispute", method = RequestMethod.PUT)
    public CollectionDisputeUpdate updateDispute(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionDisputeUpdate collectionDispute) throws Exception {
        return collectionEntityService.updateDispute(id, collectionDispute);
    }

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.PUT)
    public CollectionPaymentArrangementUpdate updatePaymentArrangement(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionPaymentArrangementUpdate collectionPaymentArrangementUpdate) throws Exception {
        return collectionEntityService.updatePaymentArrangement(id, collectionPaymentArrangementUpdate);
    }

    @RequestMapping(value = "/suppression", method = RequestMethod.PUT)
    public CollectionSuppressionUpdate updateSuppression(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionSuppressionUpdate collectionSuppressionUpdate) throws Exception {
        return collectionEntityService.updateSuppression(id, collectionSuppressionUpdate);
    }
}
