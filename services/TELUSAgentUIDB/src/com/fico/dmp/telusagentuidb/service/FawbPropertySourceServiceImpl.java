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

import com.fico.dmp.telusagentuidb.FawbPropertySource;


/**
 * ServiceImpl object for domain model class FawbPropertySource.
 *
 * @see FawbPropertySource
 */
@Service("TELUSAgentUIDB.FawbPropertySourceService")
@Validated
public class FawbPropertySourceServiceImpl implements FawbPropertySourceService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(FawbPropertySourceServiceImpl.class.getName());


    @Autowired
    @Qualifier("TELUSAgentUIDB.FawbPropertySourceDao")
    private WMGenericDao<FawbPropertySource, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<FawbPropertySource, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public FawbPropertySource create(FawbPropertySource fawbPropertySource) {
        LOGGER.debug("Creating a new FawbPropertySource with information: {}", fawbPropertySource);

        FawbPropertySource fawbPropertySourceCreated = this.wmGenericDao.create(fawbPropertySource);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(fawbPropertySourceCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public FawbPropertySource getById(Integer fawbpropertysourceId) {
        LOGGER.debug("Finding FawbPropertySource by id: {}", fawbpropertysourceId);
        return this.wmGenericDao.findById(fawbpropertysourceId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public FawbPropertySource findById(Integer fawbpropertysourceId) {
        LOGGER.debug("Finding FawbPropertySource by id: {}", fawbpropertysourceId);
        try {
            return this.wmGenericDao.findById(fawbpropertysourceId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No FawbPropertySource found with id: {}", fawbpropertysourceId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<FawbPropertySource> findByMultipleIds(List<Integer> fawbpropertysourceIds, boolean orderedReturn) {
        LOGGER.debug("Finding FawbPropertySources by ids: {}", fawbpropertysourceIds);

        return this.wmGenericDao.findByMultipleIds(fawbpropertysourceIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public FawbPropertySource getByPropertyKey(String propertyKey) {
        Map<String, Object> propertyKeyMap = new HashMap<>();
        propertyKeyMap.put("propertyKey", propertyKey);

        LOGGER.debug("Finding FawbPropertySource by unique keys: {}", propertyKeyMap);
        return this.wmGenericDao.findByUniqueKey(propertyKeyMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public FawbPropertySource update(FawbPropertySource fawbPropertySource) {
        LOGGER.debug("Updating FawbPropertySource with information: {}", fawbPropertySource);

        this.wmGenericDao.update(fawbPropertySource);
        this.wmGenericDao.refresh(fawbPropertySource);

        return fawbPropertySource;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public FawbPropertySource delete(Integer fawbpropertysourceId) {
        LOGGER.debug("Deleting FawbPropertySource with id: {}", fawbpropertysourceId);
        FawbPropertySource deleted = this.wmGenericDao.findById(fawbpropertysourceId);
        if (deleted == null) {
            LOGGER.debug("No FawbPropertySource found with id: {}", fawbpropertysourceId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), FawbPropertySource.class.getSimpleName(), fawbpropertysourceId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(FawbPropertySource fawbPropertySource) {
        LOGGER.debug("Deleting FawbPropertySource with {}", fawbPropertySource);
        this.wmGenericDao.delete(fawbPropertySource);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<FawbPropertySource> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all FawbPropertySources");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<FawbPropertySource> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all FawbPropertySources");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table FawbPropertySource to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table FawbPropertySource to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table FawbPropertySource");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "FAWB_PROPERTY_SOURCE");
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