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
import org.springframework.context.annotation.Lazy;
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

import com.fico.dmp.telusagentuidb.Group;
import com.fico.dmp.telusagentuidb.GroupRole;
import com.fico.dmp.telusagentuidb.QueueGroup;
import com.fico.dmp.telusagentuidb.UserGroup;


/**
 * ServiceImpl object for domain model class Group.
 *
 * @see Group
 */
@Service("TELUSAgentUIDB.GroupService")
@Validated
public class GroupServiceImpl implements GroupService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(GroupServiceImpl.class.getName());

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.UserGroupService")
    private UserGroupService userGroupService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.GroupRoleService")
    private GroupRoleService groupRoleService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.QueueGroupService")
    private QueueGroupService queueGroupService;

    @Autowired
    @Qualifier("TELUSAgentUIDB.GroupDao")
    private WMGenericDao<Group, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Group, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Group create(Group _group) {
        LOGGER.debug("Creating a new Group with information: {}", _group);

        Group _groupCreated = this.wmGenericDao.create(_group);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(_groupCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Group getById(Integer groupId) {
        LOGGER.debug("Finding Group by id: {}", groupId);
        return this.wmGenericDao.findById(groupId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Group findById(Integer groupId) {
        LOGGER.debug("Finding Group by id: {}", groupId);
        try {
            return this.wmGenericDao.findById(groupId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Group found with id: {}", groupId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<Group> findByMultipleIds(List<Integer> groupIds, boolean orderedReturn) {
        LOGGER.debug("Finding Groups by ids: {}", groupIds);

        return this.wmGenericDao.findByMultipleIds(groupIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Group getByName(String name) {
        Map<String, Object> nameMap = new HashMap<>();
        nameMap.put("name", name);

        LOGGER.debug("Finding Group by unique keys: {}", nameMap);
        return this.wmGenericDao.findByUniqueKey(nameMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Group update(Group _group) {
        LOGGER.debug("Updating Group with information: {}", _group);

        this.wmGenericDao.update(_group);
        this.wmGenericDao.refresh(_group);

        return _group;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Group delete(Integer groupId) {
        LOGGER.debug("Deleting Group with id: {}", groupId);
        Group deleted = this.wmGenericDao.findById(groupId);
        if (deleted == null) {
            LOGGER.debug("No Group found with id: {}", groupId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Group.class.getSimpleName(), groupId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(Group _group) {
        LOGGER.debug("Deleting Group with {}", _group);
        this.wmGenericDao.delete(_group);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Group> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Groups");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Group> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Groups");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table Group to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table Group to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table Group");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "GROUP");
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

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserGroup> findAssociatedUserGroups(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userGroups");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("_group.id = '" + id + "'");

        return userGroupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<QueueGroup> findAssociatedQueueGroups(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated queueGroups");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("_group.id = '" + id + "'");

        return queueGroupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<GroupRole> findAssociatedGroupRoles(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated groupRoles");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("_group.id = '" + id + "'");

        return groupRoleService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service UserGroupService instance
     */
    protected void setUserGroupService(UserGroupService service) {
        this.userGroupService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service GroupRoleService instance
     */
    protected void setGroupRoleService(GroupRoleService service) {
        this.groupRoleService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service QueueGroupService instance
     */
    protected void setQueueGroupService(QueueGroupService service) {
        this.queueGroupService = service;
    }

}