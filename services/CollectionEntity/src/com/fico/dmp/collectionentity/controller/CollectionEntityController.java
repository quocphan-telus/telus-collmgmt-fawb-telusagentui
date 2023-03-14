/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.collectionentity.controller;

import com.fico.dmp.collectionentity.CollectionEntity;
import io.swagger.client.model.CollectionPaymentArrangement;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Boolean;
import io.swagger.client.model.CollectionBillingAccountRef;
import java.lang.String;
import java.util.List;
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
    private CollectionEntity collectionEntity;

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.POST)
    public CollectionPaymentArrangement addPaymentArrangement(@RequestBody CollectionPaymentArrangement collectionPaymentArrangementCreate) throws Exception {
        return collectionEntity.addPaymentArrangement(collectionPaymentArrangementCreate);
    }

    @RequestMapping(value = "/billingAccountRef", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionBillingAccountRef getBillingAccountRef(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntity.getBillingAccountRef(id, history);
    }

    @RequestMapping(value = "/billingAccountRef_1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionBillingAccountRef> getBillingAccountRef_1(@RequestParam(value = "ban", required = false) String ban, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntity.getBillingAccountRef(ban, history);
    }

    @RequestMapping(value = "/paymentArrangement/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public CollectionPaymentArrangement getPaymentArrangement(@PathVariable("id") Integer id, @RequestParam(value = "history", required = false) Boolean history) throws Exception {
        return collectionEntity.getPaymentArrangement(id, history);
    }

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<CollectionPaymentArrangement> getPaymentArrangements(@RequestParam(value = "entityId", required = false) String entityId) throws Exception {
        return collectionEntity.getPaymentArrangements(entityId);
    }

    @RequestMapping(value = "/paymentArrangement", method = RequestMethod.PUT)
    public CollectionPaymentArrangement updatePaymentArrangement(@RequestParam(value = "id", required = false) Integer id, @RequestBody CollectionPaymentArrangement collectionPaymentArrangementCreate) throws Exception {
        return collectionEntity.updatePaymentArrangement(id, collectionPaymentArrangementCreate);
    }
}
