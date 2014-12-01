package com.swcguild.chartstest;

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
        
        List<Integer> intList=new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(5);
        
        
        try {
            DataTable t = new DataTable();
            t.addColumn(new ColumnDescription("Product", ValueType.TEXT, "Product"));
            t.addColumn(new ColumnDescription("Number of Damage Incidents", ValueType.NUMBER, "Number of Damage Incidents"));

            TableRow tr = new TableRow();
            
            for (int i=0; i<intList.size(); i++){
            
            tr.addCell("Some Product/ Category");
            tr.addCell(intList.get(i));
            
            
            t.addRow(tr);
            
            }  //end for-loop with int=i
            
//            tr = new TableRow();
//            tr.addCell("Recreation");
//            tr.addCell(intList.get(i));
//            i++;
//            t.addRow(tr);
//            
//            tr = new TableRow();
//            tr.addCell("Sleep");
//            tr.addCell(intList.get(i));
//            i++;
//            t.addRow(tr);
            
              //end for-loop with int=i
            

            return JsonRenderer.renderDataTable(t, true, false, false).toString();
        } catch (Exception e) {
            return "Invalid Data";
        }
    }

}
