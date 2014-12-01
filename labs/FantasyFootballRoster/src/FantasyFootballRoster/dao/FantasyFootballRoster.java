package fantasyfootballroster.dao;

import FantasyFootballRoster.dto.Player;
import java.util.HashMap;

public class FantasyFootballRoster {

    HashMap<String, Player> playerMap = new HashMap<String, Player>();

    
    public Player addPlayer(String lastName, Player player) {

        return playerMap.put(lastName, player);

    }

    public Player removePlayer(String lastName) {

        return playerMap.remove(lastName);

    }
    
    public Player findPlayer(String lastName) {
    
    return playerMap.get(lastName);
    
    }

}
