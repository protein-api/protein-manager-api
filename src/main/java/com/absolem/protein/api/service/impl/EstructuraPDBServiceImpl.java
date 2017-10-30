package com.absolem.protein.api.service.impl;

import com.absolem.protein.api.model.EstructuraPDB;
import com.absolem.protein.api.model.dao.impl.EstructuraPDBDAOImpl;
import com.absolem.protein.api.service.EstructuraPDBService;
import org.springframework.stereotype.Service;

/**
 * Created by murmu on 04/08/17.
 */
@Service
public class EstructuraPDBServiceImpl extends AbstractGenericServiceImpl<EstructuraPDB,EstructuraPDBDAOImpl> implements EstructuraPDBService {
}
