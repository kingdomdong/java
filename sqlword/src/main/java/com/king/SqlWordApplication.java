package com.king;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication(scanBasePackages = "com.king")
public class SqlWordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlWordApplication.class, args);
    }

    static void doExecute() {

// 创建word文档,并设置纸张的大小

        Document document = new Document(PageSize.A4);

        try {

//            RtfWriter2.getInstance(document,
//
//                    new FileOutputStream("E:/word5.doc"));

            document.open();

//设置合同头

            Paragraph ph = new Paragraph();

            Font font = new Font();

            Paragraph p = new Paragraph("数据库表设计文档", new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));

            p.setAlignment(1);

            document.add(p);

            ph.setFont(font);

// 设置中文字体

// BaseFont bfFont =    BaseFont.createFont("STSongStd-Light",  "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);

// Font chinaFont = new Font();

            /*

             * 创建有三列的表格

             */

            for (int i = 0; i < 5; i++) {

                Table table = new Table(6);

                document.add(new Paragraph(""));

                table.setBorderWidth(1);

// table.setBorderColor(Color.BLACK);

                table.setPadding(0);

                table.setSpacing(0);

                /*

                 * 添加表头的元素

                 */

                Color chade = new Color(176, 196, 222);

                Cell cell = new Cell("序号");//单元格

                cell.setBackgroundColor(chade);

                cell.setHeader(true);

//        cell.setColspan(1);//设置表格为三列

//        cell.setRowspan(1);//设置表格为三行

                table.addCell(cell);

                cell = new Cell("字段名");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("类型");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("是否为空");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("主键");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("字段说明");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                table.endHeaders();// 表头结束

// 表格的主体

                table.addCell("1,1");

                table.addCell("1,2");

                table.addCell("1,3");

                table.addCell("1,4");

                table.addCell("1,5");

                table.addCell("1,6");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                document.add(new Paragraph("表一"));

                document.add(table);

            }

            document.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
