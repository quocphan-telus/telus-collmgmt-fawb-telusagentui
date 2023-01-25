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

import com.fico.dmp.telusagentuidb.QrtzPausedTriggerGrps;
import com.fico.dmp.telusagentuidb.QrtzPausedTriggerGrpsId;


/**
 * ServiceImpl object for domain model class QrtzPausedTriggerGrps.
 *
 * @see QrtzPausedTriggerGrps
 */
@Service("TELUSAgentUIDB.QrtzPausedTriggerGrpsService")
@Validated
public class QrtzPausedTriggerGrpsServiceImpl implements QrtzPausedTriggerGrpsService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(QrtzPausedTriggerGrpsServiceImpl.class.getName());


    @Autowired
    @Qualifier("TELUSAgentUIDB.QrtzPausedTriggerGrpsDao")
    private WMGenericDao<QrtzPausedTriggerGrps, QrtzPausedTriggerGrpsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<QrtzPausedTriggerGrps, QrtzPausedTriggerGrpsId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzPausedTriggerGrps create(QrtzPausedTriggerGrps qrtzPausedTriggerGrps) {
        LOGGER.debug("Creating a new QrtzPausedTriggerGrps with information: {}", qrtzPausedTriggerGrps);

        QrtzPausedTriggerGrps qrtzPausedTriggerGrpsCreated = this.wmGenericDao.create(qrtzPausedTriggerGrps);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(qrtzPausedTriggerGrpsCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzPausedTriggerGrps getById(QrtzPausedTriggerGrpsId qrtzpausedtriggergrpsId) {
        LOGGER.debug("Finding QrtzPausedTriggerGrps by id: {}", qrtzpausedtriggergrpsId);
        return this.wmGenericDao.findById(qrtzpausedtriggergrpsId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzPausedTriggerGrps findById(QrtzPausedTriggerGrpsId qrtzpausedtriggergrpsId) {
        LOGGER.debug("Finding QrtzPausedTriggerGrps by id: {}", qrtzpausedtriggergrpsId);
        try {
            return this.wmGenericDao.findById(qrtzpausedtriggergrpsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No QrtzPausedTriggerGrps found with id: {}", qrtzpausedtriggergrpsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<QrtzPausedTriggerGrps> findByMultipleIds(List<QrtzPausedTriggerGrpsId> qrtzpausedtriggergrpsIds, boolean orderedReturn) {
        LOGGER.debug("Finding QrtzPausedTriggerGrps by ids: {}", qrtzpausedtriggergrpsIds);

        return this.wmGenericDao.findByMultipleIds(qrtzpausedtriggergrpsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzPausedTriggerGrps update(QrtzPausedTriggerGrps qrtzPausedTriggerGrps) {
        LOGGER.debug("Updating QrtzPausedTriggerGrps with information: {}", qrtzPausedTriggerGrps);

        this.wmGenericDao.update(qrtzPausedTriggerGrps);
        this.wmGenericDao.refresh(qrtzPausedTriggerGrps);

        return qrtzPausedTriggerGrps;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public QrtzPausedTriggerGrps delete(QrtzPausedTriggerGrpsId qrtzpausedtriggergrpsId) {
        LOGGER.debug("Deleting QrtzPausedTriggerGrps with id: {}", qrtzpausedtriggergrpsId);
        QrtzPausedTriggerGrps deleted = this.wmGenericDao.findById(qrtzpausedtriggergrpsId);
        if (deleted == null) {
            LOGGER.debug("No QrtzPausedTriggerGrps found with id: {}", qrtzpausedtriggergrpsId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), QrtzPausedTriggerGrps.class.getSimpleName(), qrtzpausedtriggergrpsId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(QrtzPausedTriggerGrps qrtzPausedTriggerGrps) {
        LOGGER.debug("Deleting QrtzPausedTriggerGrps with {}", qrtzPausedTriggerGrps);
        this.wmGenericDao.delete(qrtzPausedTriggerGrps);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<QrtzPausedTriggerGrps> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all QrtzPausedTriggerGrps");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<QrtzPausedTriggerGrps> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all QrtzPausedTriggerGrps");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table QrtzPausedTriggerGrps to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table QrtzPausedTriggerGrps to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table QrtzPausedTriggerGrps");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "QRTZ_PAUSED_TRIGGER_GRPS");
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