
package serverinventory;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ServerCabinetMapImpl implements ServerCabinet {

    
     HashMap <String, Server> servers = new HashMap<>();
    
    
    
    
    @Override
    public Server addServer(String name, Server server) {
        return servers.put(name, server);
    }

    @Override
    public Server removeServer(String name) {
        return servers.remove(name);
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        
        return servers.values().stream() //create stream of values from HashMap
                
                //for every server called myServer that comes through the stream, return  when greater than age in years 
                .filter(myServer ->myServer.getServerAge()>ageInYears)
                
                .collect(Collectors.toList());
                
                
        
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears) {
        //colector will collect stuff into map for us
        return servers.values().stream()
                .filter(s ->s.getServerAge()>ageInYears)
                                                 
                                               //here, could also use s-> s.getMake
                .collect(Collectors.groupingBy(Server::getMake));
        
        
        
        
    }

    @Override
    public List<Server> getServersByMake(String make) {
       return servers.values().stream()
               .filter(s-> s.getMake().equalsIgnoreCase(make))
               .collect(Collectors.toList());
               
    }

    @Override
    public double getAverageServerAge() {
        return servers.values().stream()
                .mapToDouble(s->s.getServerAge())
                .average()
                .getAsDouble();
       
    }
    
}
