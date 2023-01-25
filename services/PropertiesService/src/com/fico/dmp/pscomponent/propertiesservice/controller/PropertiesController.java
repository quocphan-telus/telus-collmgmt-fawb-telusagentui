/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.fico.dmp.pscomponent.propertiesservice.controller;

import com.fico.dmp.pscomponent.propertiesservice.PropertiesService;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import java.lang.Boolean;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import com.fico.pscomponent.handlers.PropertiesHandler.LoadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/properties")
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

    @RequestMapping(value = "/auditFlagValue", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Boolean getAuditFlagValue(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        return propertiesService.getAuditFlagValue(name, request);
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public Map<String, String> getProperties(HttpServletRequest request) {
        return propertiesService.getProperties(request);
    }

    @RequestMapping(value = "/propertyValueByName", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getPropertyValueByName(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        return propertiesService.getPropertyValueByName(name, request);
    }

    @RequestMapping(value = "/loadCustomProperties", method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public ResponseEntity<LoadResponse> loadCustomProperties(@RequestPart(value = "file") MultipartFile file, HttpServletRequest request) {
        return propertiesService.loadCustomProperties(file, request);
    }

    @RequestMapping(value = "/loadDefaultProperties", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public ResponseEntity<LoadResponse> loadDefaultProperties(HttpServletRequest request) {
        return propertiesService.loadDefaultProperties(request);
    }

    @RequestMapping(value = "/refreshProperties", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public void refreshProperties() {
        propertiesService.refreshProperties();
    }
}
