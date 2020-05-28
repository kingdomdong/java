package com.king.service;

import com.king.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BusinessSupplierService implements IBusinessSupplierService {

    private TableMapper tableMapper;

    @Autowired
    public BusinessSupplierService(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }

    @Override
    public List<Map<String, Object>> getTableTest(String schema) {
        return tableMapper.getAllTableName(schema);
    }

    @Override
    public List<Map<String, Object>> getTableDetail(String tableName, String schema) {
        return tableMapper.getTableDetail(tableName, schema);
    }

}
