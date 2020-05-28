package com.king;

import com.king.service.IBusinessSupplierService;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * 创建word文档 步骤: 1,建立文档 2,创建一个书写器 3,打开文档 4,向文档中写入数据 5,关闭文档
 */

@Service
public class DateToWordUtil {

    private final IBusinessSupplierService businessSupplierService;

    public DateToWordUtil(IBusinessSupplierService businessSupplierService) {
        this.businessSupplierService = businessSupplierService;
    }

    public void toWord(List<Map<String, Object>> listAll) throws Exception {// 创建word文档,并设置纸张的大小


    }

}

