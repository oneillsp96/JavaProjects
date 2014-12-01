package com.swcguild.googlechartsangular;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.render.JsonRenderer;
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
    //@ResponseBody
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller");
        return "hello";
        //return 
    }
    
    
    
    
//good template for controller endpoints - just change url mapping and instead of hardcoding data, get it from database

    
//dataTable object
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    //tells it its not a view name, it's data
    @ResponseBody public String getDataTable() {
        try {            
            
            //with database, DataTable t=dao.method
            DataTable t = new DataTable();
            //one is column ID (what we refer to it as), one is display name
            t.addColumn(new ColumnDescription("Asset_Id", ValueType.TEXT, "Asset Id"));
            t.addColumn(new ColumnDescription("Damage_Rating", ValueType.NUMBER, "Damage Rating"));
            TableRow tr = new TableRow();
            tr.addCell("canoe1");
            tr.addCell(1);
            t.addRow(tr);

            tr = new TableRow();
            tr.addCell("tent1");
            tr.addCell(6);
            t.addRow(tr);
            
            //render data table
            
            return JsonRenderer.renderDataTable(t, true, false, false).toString();       //return JSON code (key-value pairs)

        } catch (Exception e) {
            return (e.getMessage().toString());  
        }

    }
}
