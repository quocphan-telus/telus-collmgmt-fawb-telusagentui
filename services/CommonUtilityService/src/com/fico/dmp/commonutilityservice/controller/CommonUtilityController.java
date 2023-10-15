/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.commonutilityservice.controller;

import com.fico.dmp.commonutilityservice.CommonUtilityService;
import java.lang.String;
import com.fico.telus.model.AssignedUserModel;
import java.util.List;
import com.fico.telus.model.BillingAccountModel;
import java.lang.Integer;
import com.fico.telus.model.AssignedTeamModel;
import java.util.Date;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/commonUtility")
public class CommonUtilityController {

    @Autowired
    private CommonUtilityService commonUtilityService;

    @RequestMapping(value = "/teamManagerOnUpdate", produces = "application/json", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String deleteTeamManagerOnUpdate(@RequestParam(value = "teamId", required = false) String teamId) {
        return commonUtilityService.deleteTeamManagerOnUpdate(teamId);
    }

    @RequestMapping(value = "/assignedPersonInactionManagement", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<AssignedUserModel> getAssignedPersonInActionManagement() {
        return commonUtilityService.getAssignedPersonInActionManagement();
    }

    @RequestMapping(value = "/billingAccountUsingbillingAccountReferenceIds", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<BillingAccountModel> getBillingAccountUsingBillingAccountReferenceIds(@RequestParam(value = "billingAccountRefIds", required = false) String billingAccountRefIds) {
        return commonUtilityService.getBillingAccountUsingBillingAccountReferenceIds(billingAccountRefIds);
    }

    @RequestMapping(value = "/loggedInUserTeamId", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getLoggedInUserTeamId(@RequestParam(value = "userId", required = false) Integer userId) {
        return commonUtilityService.getLoggedInUserTeamId(userId);
    }

    @RequestMapping(value = "/nameUsingEmpId", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getNameUsingEmpId(@RequestParam(value = "empId", required = false) String empId) {
        return commonUtilityService.getNameUsingEmpId(empId);
    }

    @RequestMapping(value = "/teamIdUsingEmpId", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getTeamIdUsingEmpId(@RequestParam(value = "empId", required = false) String empId) {
        return commonUtilityService.getTeamIdUsingEmpId(empId);
    }

    @RequestMapping(value = "/teamListInActionManagement", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<AssignedTeamModel> getTeamListInActionManagement() {
        return commonUtilityService.getTeamListInActionManagement();
    }

    @RequestMapping(value = "/userListByTeamId", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public List<AssignedUserModel> getUserListByTeamId(@RequestParam(value = "teamId", required = false) String teamId) {
        return commonUtilityService.getUserListByTeamId(teamId);
    }

    @RequestMapping(value = "/saveManagerOnTeamCreate", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String saveManagerOnTeamCreate(@RequestParam(value = "teamId", required = false) Integer teamId, @RequestParam(value = "managerIdListString", required = false) String managerIdListString, @RequestParam(value = "createdBy", required = false) Integer createdBy, @RequestParam(value = "updatedBy", required = false) Integer updatedBy, @RequestParam(value = "createdOn", required = false) Date createdOn, @RequestParam(value = "updatedOn", required = false) Date updatedOn) {
        return commonUtilityService.saveManagerOnTeamCreate(teamId, managerIdListString, createdBy, updatedBy, createdOn, updatedOn);
    }
}
