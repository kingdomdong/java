package com.king.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BusinessSupplierService implements IBusinessSupplierService {

    @Override
    public void getTableTest() {
        List<Map<String, Object>> listTable =new ArrayList<>();
    }

    @Override
    public List<Map<String, Object>> listMap(String sql) {
        return null;
    }
}
