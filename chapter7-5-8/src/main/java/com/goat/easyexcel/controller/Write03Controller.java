package com.goat.easyexcel.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.goat.easyexcel.model.WriteModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.goat.easyexcel.util.DataUtil.*;

/**
 * Created by 64274 on 2019/2/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/23---20:56
 */
@RestController
@RequestMapping("w03")
public class Write03Controller extends BaseController {

    //  http://localhost:8758/w03/test1
    @GetMapping("test1")
    public void simpleReadListStringV2003() throws IOException {
        OutputStream out = new FileOutputStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter7-5-8\\src\\main\\resources\\2003w.xls");
        ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLS,true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");

        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0,10000);columnWidth.put(1,40000);columnWidth.put(2,10000);columnWidth.put(3,10000);
        sheet1.setColumnWidthMap(columnWidth);
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1); // 表格填充数据

        //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
        sheet2.setTableStyle(createTableStyle());
        writer.write(createTestListJavaMode(), sheet2);  // 表格填充数据

        //写第三个sheet包含多个table情况
        Sheet sheet3 = new Sheet(3, 0);
        sheet3.setSheetName("第三个sheet");
        Table table1 = new Table(1);
        table1.setHead(createTestListStringHead());
        writer.write1(createTestListObject(), sheet3, table1);  // 表格填充数据

        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
        table2.setTableStyle(createTableStyle());
        table2.setClazz(WriteModel.class);
        writer.write(createTestListJavaMode(), sheet3, table2);  // 表格填充数据

        writer.finish();
        out.close();
    }


    /**   http://localhost:8758/w03/test2

     */
    @GetMapping("test2")
    public void simpleReadJavaModelV2003() {

    }

    /**   http://localhost:8758/w03/test3

     */
    @GetMapping("test3")
    public void saxReadListStringV2003() {

    }

    /**  http://localhost:8758/w03/test4

     */
    @GetMapping("test4")
    public void saxReadJavaModelV2003() {

    }


}
