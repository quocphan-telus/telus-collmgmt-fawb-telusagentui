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

import com.fico.dmp.telusagentuidb.Team;
import com.fico.dmp.telusagentuidb.TeamUser;


/**
 * ServiceImpl object for domain model class Team.
 *
 * @see Team
 */
@Service("TELUSAgentUIDB.TeamService")
@Validated
public class TeamServiceImpl implements TeamService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(TeamServiceImpl.class.getName());

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.TeamUserService")
    private TeamUserService teamUserService;

    @Autowired
    @Qualifier("TELUSAgentUIDB.TeamDao")
    private WMGenericDao<Team, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Team, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Team create(Team team) {
        LOGGER.debug("Creating a new Team with information: {}", team);

        Team teamCreated = this.wmGenericDao.create(team);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(teamCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Team getById(Integer teamIdInstance) {
        LOGGER.debug("Finding Team by id: {}", teamIdInstance);
        return this.wmGenericDao.findById(teamIdInstance);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Team findById(Integer teamIdInstance) {
        LOGGER.debug("Finding Team by id: {}", teamIdInstance);
        try {
            return this.wmGenericDao.findById(teamIdInstance);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Team found with id: {}", teamIdInstance, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<Team> findByMultipleIds(List<Integer> teamIdInstances, boolean orderedReturn) {
        LOGGER.debug("Finding Teams by ids: {}", teamIdInstances);

        return this.wmGenericDao.findByMultipleIds(teamIdInstances, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Team update(Team team) {
        LOGGER.debug("Updating Team with information: {}", team);

        this.wmGenericDao.update(team);
        this.wmGenericDao.refresh(team);

        return team;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Team delete(Integer teamIdInstance) {
        LOGGER.debug("Deleting Team with id: {}", teamIdInstance);
        Team deleted = this.wmGenericDao.findById(teamIdInstance);
        if (deleted == null) {
            LOGGER.debug("No Team found with id: {}", teamIdInstance);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Team.class.getSimpleName(), teamIdInstance);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(Team team) {
        LOGGER.debug("Deleting Team with {}", team);
        this.wmGenericDao.delete(team);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Team> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Teams");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Team> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Teams");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table Team to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table Team to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table Team");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "TEAM");
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
    public Page<TeamUser> findAssociatedTeamUsers(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated teamUsers");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("team.id = '" + id + "'");

        return teamUserService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service TeamUserService instance
     */
    protected void setTeamUserService(TeamUserService service) {
        this.teamUserService = service;
    }

}