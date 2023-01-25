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

import com.fico.dmp.telusagentuidb.QrtzLocks;
import com.fico.dmp.telusagentuidb.QrtzLocksId;


/**
 * ServiceImpl object for domain model class QrtzLocks.
 *
 * @see QrtzLocks
 */
@Service("TELUSAgentUIDB.QrtzLocksService")
@Validated
public class QrtzLocksServiceImpl implements QrtzLocksService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(QrtzLocksServiceImpl.class.getName());


    @Autowired
    @Qualifier("TELUSAgentUIDB.QrtzLocksDao")
    private WMGenericDao<QrtzLocks, QrtzLocksId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<QrtzLocks, QrtzLocksId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzLocks create(QrtzLocks qrtzLocks) {
        LOGGER.debug("Creating a new QrtzLocks with information: {}", qrtzLocks);

        QrtzLocks qrtzLocksCreated = this.wmGenericDao.create(qrtzLocks);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(qrtzLocksCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzLocks getById(QrtzLocksId qrtzlocksId) {
        LOGGER.debug("Finding QrtzLocks by id: {}", qrtzlocksId);
        return this.wmGenericDao.findById(qrtzlocksId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzLocks findById(QrtzLocksId qrtzlocksId) {
        LOGGER.debug("Finding QrtzLocks by id: {}", qrtzlocksId);
        try {
            return this.wmGenericDao.findById(qrtzlocksId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No QrtzLocks found with id: {}", qrtzlocksId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<QrtzLocks> findByMultipleIds(List<QrtzLocksId> qrtzlocksIds, boolean orderedReturn) {
        LOGGER.debug("Finding QrtzLocks by ids: {}", qrtzlocksIds);

        return this.wmGenericDao.findByMultipleIds(qrtzlocksIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzLocks update(QrtzLocks qrtzLocks) {
        LOGGER.debug("Updating QrtzLocks with information: {}", qrtzLocks);

        this.wmGenericDao.update(qrtzLocks);
        this.wmGenericDao.refresh(qrtzLocks);

        return qrtzLocks;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzLocks delete(QrtzLocksId qrtzlocksId) {
        LOGGER.debug("Deleting QrtzLocks with id: {}", qrtzlocksId);
        QrtzLocks deleted = this.wmGenericDao.findById(qrtzlocksId);
        if (deleted == null) {
            LOGGER.debug("No QrtzLocks found with id: {}", qrtzlocksId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), QrtzLocks.class.getSimpleName(), qrtzlocksId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(QrtzLocks qrtzLocks) {
        LOGGER.debug("Deleting QrtzLocks with {}", qrtzLocks);
        this.wmGenericDao.delete(qrtzLocks);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<QrtzLocks> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all QrtzLocks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<QrtzLocks> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all QrtzLocks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table QrtzLocks to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table QrtzLocks to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table QrtzLocks");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "QRTZ_LOCKS");
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