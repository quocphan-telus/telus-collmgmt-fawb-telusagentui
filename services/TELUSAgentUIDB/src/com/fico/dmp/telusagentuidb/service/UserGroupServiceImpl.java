/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
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

import com.fico.dmp.telusagentuidb.UserGroup;


/**
 * ServiceImpl object for domain model class UserGroup.
 *
 * @see UserGroup
 */
@Service("TELUSAgentUIDB.UserGroupService")
@Validated
public class UserGroupServiceImpl implements UserGroupService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(UserGroupServiceImpl.class.getName());


    @Autowired
    @Qualifier("TELUSAgentUIDB.UserGroupDao")
    private WMGenericDao<UserGroup, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UserGroup, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public UserGroup create(UserGroup userGroup) {
        LOGGER.debug("Creating a new UserGroup with information: {}", userGroup);

        UserGroup userGroupCreated = this.wmGenericDao.create(userGroup);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(userGroupCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public UserGroup getById(Integer usergroupId) {
        LOGGER.debug("Finding UserGroup by id: {}", usergroupId);
        return this.wmGenericDao.findById(usergroupId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public UserGroup findById(Integer usergroupId) {
        LOGGER.debug("Finding UserGroup by id: {}", usergroupId);
        try {
            return this.wmGenericDao.findById(usergroupId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No UserGroup found with id: {}", usergroupId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<UserGroup> findByMultipleIds(List<Integer> usergroupIds, boolean orderedReturn) {
        LOGGER.debug("Finding UserGroups by ids: {}", usergroupIds);

        return this.wmGenericDao.findByMultipleIds(usergroupIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public UserGroup getByUserIdAndGroupId(Integer userId, Integer groupId) {
        Map<String, Object> userIdAndGroupIdMap = new HashMap<>();
        userIdAndGroupIdMap.put("userId", userId);
        userIdAndGroupIdMap.put("groupId", groupId);

        LOGGER.debug("Finding UserGroup by unique keys: {}", userIdAndGroupIdMap);
        return this.wmGenericDao.findByUniqueKey(userIdAndGroupIdMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public UserGroup update(UserGroup userGroup) {
        LOGGER.debug("Updating UserGroup with information: {}", userGroup);

        this.wmGenericDao.update(userGroup);
        this.wmGenericDao.refresh(userGroup);

        return userGroup;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public UserGroup delete(Integer usergroupId) {
        LOGGER.debug("Deleting UserGroup with id: {}", usergroupId);
        UserGroup deleted = this.wmGenericDao.findById(usergroupId);
        if (deleted == null) {
            LOGGER.debug("No UserGroup found with id: {}", usergroupId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), UserGroup.class.getSimpleName(), usergroupId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(UserGroup userGroup) {
        LOGGER.debug("Deleting UserGroup with {}", userGroup);
        this.wmGenericDao.delete(userGroup);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserGroup> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UserGroups");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserGroup> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UserGroups");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table UserGroup to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table UserGroup to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table UserGroup");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "USER_GROUP");
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