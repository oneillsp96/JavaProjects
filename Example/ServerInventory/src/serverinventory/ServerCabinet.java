
package serverinventory;

import java.util.List;
import java.util.Map;


public interface ServerCabinet {
    
    //add
    public Server addServer(String name, Server server);
    public Server removeServer(String name);
    public List<Server> getServersOlderThan(int ageInYears);
    public Map<String, List<Server>> getServersOlderThanGroupByMake (int ageInYears);  //map of lists
    public List<Server>getServersByMake(String make);
    public double getAverageServerAge();
    
}
