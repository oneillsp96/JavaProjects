
package serverinventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class ServerInventoryArrayList {
    public static void main(String[] args) {
        
        
        
        
        ArrayList<Server> servers=new ArrayList<>();
        
        Server temp=new Server();
        temp.setName("Web01");
        temp.setIp("192.168.1.1");
        temp.setMake("Dell");
        temp.setRam("8GB");
        temp.setNumProcessors("8");
        temp.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);
        
        temp=new Server();
        temp.setName("DB01");
        temp.setIp("192.168.3.45");
        temp.setMake("HP");
        temp.setRam("16GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);
        
        temp=new Server();
        temp.setName("HR200");
        temp.setIp("192.168.32.111");
        temp.setMake("IBM");
        temp.setRam("16GB");
        temp.setNumProcessors("12");
        temp.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);
        
        temp=new Server();
        temp.setName("ENG64");
        temp.setIp("192.168.34.56");
        temp.setMake("HP");
        temp.setRam("20GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);
        
        temp=new Server();
        temp.setName("Web02");
        temp.setIp("192.168.1.5");
        temp.setMake("Dell");
        temp.setRam("8GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2005-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);
        
        
        
        String make="dElL";
        servers.stream() //looks like anonymous method, method without name- looks like any other method we've used but has no name and arrow symbol afterward
                            //stream - keeps handing over servers, and then we can do what we want with them in the "method"
        
   
                
                //this is a very formal way of writing out a lambda expression, as if it wee a normal method
        
        .filter((myServer) ->
        {
            return myServer.getMake().equalsIgnoreCase(make);   
        })
        
        .forEach(e -> System.out.println(e.getName()));       //terminal operation
        
        //filter out , get only servers whose make is Dell
        //get each server object out of stream
        //s is stan
        
        
        
        long testAge=3;
        servers.stream()
                
                .filter(s ->s.getServerAge()>testAge)
                .forEach(e -> System.out.println(e.getName()));
        
        
        List <Server> oldServers = 
                
                servers.stream()
                .filter(s-> s.getServerAge()>testAge)
                .collect(Collectors.toList());
        
        System.out.println(oldServers.size());
        
        
        
        
        
        double averageAge=
                
                servers.stream()
                
                        //things coming through stream are server objects- we want a stream of longs, this is what next line does
                .mapToLong(Server::getServerAge)
                .average()
                .getAsDouble();
        System.out.println("Average age of servers is " + averageAge);
        
        
    }
}
