/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.queueloadservice.controller;

import com.fico.dmp.queueloadservice.QueueLoadService;
import com.fico.dmp.telusagentuidb.Queue;
import java.lang.Integer;
import java.lang.Object;
import org.springframework.http.ResponseEntity;
import java.lang.String;
import java.lang.Exception;
import java.util.List;
import com.fico.ps.model.queue.QueueResponseWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/queueLoad")
public class QueueLoadController {

    @Autowired
    private QueueLoadService queueLoadService;

    @RequestMapping(value = "/updateDynamicQuery", method = RequestMethod.POST)
    public ResponseEntity<Object> createUpdateDynamicQuery(@RequestBody Queue queue, @RequestParam(value = "listGroups", required = false) Integer[] listGroups) {
        return queueLoadService.createUpdateDynamicQuery(queue, listGroups);
    }

    @RequestMapping(value = "/applicationsInQueue", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<Integer> getApplicationsInQueue(@RequestParam(value = "queueId", required = true) Integer queueId, @RequestParam(value = "userLocale", required = false) String userLocale, @RequestParam(value = "pageNumber", required = false) Integer pageNumber, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "dateFilterFields", required = false) String dateFilterFields) throws Exception {
        return queueLoadService.getApplicationsInQueue(queueId, userLocale, pageNumber, pageSize, dateFilterFields);
    }

    @RequestMapping(value = "/dynamicQueryResultCount", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public ResponseEntity<Object> getDynamicQueryResultCount(@RequestBody Queue queue, @RequestParam(value = "userLocale", required = false) String userLocale, @RequestParam(value = "dateFilterFields", required = false) String dateFilterFields) {
        return queueLoadService.getDynamicQueryResultCount(queue, userLocale, dateFilterFields);
    }

    @RequestMapping(value = "/queueData", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public QueueResponseWrapper getQueueData(@RequestParam(value = "queueId", required = true) Integer queueId, @RequestParam(value = "userLocale", required = false) String userLocale, @RequestParam(value = "searchFilter", required = false) String searchFilter, @RequestParam(value = "sortField", required = false) String sortField, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber", required = false) Integer pageNumber, @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "dateFilterFields", required = false) String dateFilterFields) throws Exception {
        return queueLoadService.getQueueData(queueId, userLocale, searchFilter, sortField, sortOrder, pageNumber, pageSize, dateFilterFields);
    }

    @RequestMapping(value = "/queuesByLoggedinUser", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<Queue> getQueuesByLoggedinUser() {
        return queueLoadService.getQueuesByLoggedinUser();
    }

    @RequestMapping(value = "/prepareSQLWhereClauseFromJSONFilterString", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public ResponseEntity<Object> prepareSQLWhereClauseFromJSONFilterString(@RequestParam(value = "conditionBuilderJSON", required = false) String conditionBuilderJSON) {
        return queueLoadService.prepareSQLWhereClauseFromJSONFilterString(conditionBuilderJSON);
    }
}
