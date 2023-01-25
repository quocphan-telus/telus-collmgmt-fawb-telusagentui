/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.logging.FAWBStaticLoggerBinder;

import com.fico.dmp.telusagentuidb.RolePermission;


/**
 * ServiceImpl object for domain model class RolePermission.
 *
 * @see RolePermission
 */
@Service("TELUSAgentUIDB.RolePermissionService")
@Validated
public class RolePermissionServiceImpl implements RolePermissionService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(RolePermissionServiceImpl.class.getName());


    @Autowired
    @Qualifier("TELUSAgentUIDB.RolePermissionDao")
    private WMGenericDao<RolePermission, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RolePermission, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public RolePermission create(RolePermission rolePermission) {
        LOGGER.debug("Creating a new RolePermission with information: {}", rolePermission);

        RolePermission rolePermissionCreated = this.wmGenericDao.create(rolePermission);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(rolePermissionCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public RolePermission getById(Integer rolepermissionId) {
        LOGGER.debug("Finding RolePermission by id: {}", rolepermissionId);
        return this.wmGenericDao.findById(rolepermissionId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public RolePermission findById(Integer rolepermissionId) {
        LOGGER.debug("Finding RolePermission by id: {}", rolepermissionId);
        try {
            return this.wmGenericDao.findById(rolepermissionId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No RolePermission found with id: {}", rolepermissionId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<RolePermission> findByMultipleIds(List<Integer> rolepermissionIds, boolean orderedReturn) {
        LOGGER.debug("Finding RolePermissions by ids: {}", rolepermissionIds);

        return this.wmGenericDao.findByMultipleIds(rolepermissionIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public RolePermission update(RolePermission rolePermission) {
        LOGGER.debug("Updating RolePermission with information: {}", rolePermission);

        this.wmGenericDao.update(rolePermission);
        this.wmGenericDao.refresh(rolePermission);

        return rolePermission;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public RolePermission delete(Integer rolepermissionId) {
        LOGGER.debug("Deleting RolePermission with id: {}", rolepermissionId);
        RolePermission deleted = this.wmGenericDao.findById(rolepermissionId);
        if (deleted == null) {
            LOGGER.debug("No RolePermission found with id: {}", rolepermissionId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), RolePermission.class.getSimpleName(), rolepermissionId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(RolePermission rolePermission) {
        LOGGER.debug("Deleting RolePermission with {}", rolePermission);
        this.wmGenericDao.delete(rolePermission);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<RolePermission> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RolePermissions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<RolePermission> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RolePermissions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table RolePermission to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table RolePermission to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table RolePermission");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "ROLE_PERMISSION");
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}