package com.swcguild.googlecharts;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.render.JsonRenderer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/hello"})
public class HelloController {

    public HelloController() {
    }

    @RequestMapping(value = "/sayhi", method = RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller");
        return "hello";
    }

    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    @ResponseBody
    public String getDataTable() {
        
        //iterate through arrayList
        //method called addRows lets you add Row from arraylist
       
        
        try {
            DataTable t = new DataTable();
            t.addColumn(new ColumnDescription("Asset_ID", ValueType.TEXT, "Asset ID"));
            t.addColumn(new ColumnDescription("Damage_Rating", ValueType.NUMBER, "Damage Rating"));
            
            TableRow tr = new TableRow();
            tr.addCell("Product1");     //product (basketball, football, etc.)
            tr.addCell(1);             // number of damaged items
            t.addRow(tr);
            
            tr = new TableRow();
            tr.addCell("Product2");
            tr.addCell(6);
            t.addRow(tr);
            //return t;
            return JsonRenderer.renderDataTable(t, true, false, false).toString();
        } catch (Exception e) {
            return "Invalid Data";
        }
    }
}
