package com.king.service;

import java.util.List;
import java.util.Map;

public interface IBusinessSupplierService {

    List<Map<String, Object>> getTableTest(String schema);

    List<Map<String, Object>> getTableDetail(String tableName, String schema);

}
