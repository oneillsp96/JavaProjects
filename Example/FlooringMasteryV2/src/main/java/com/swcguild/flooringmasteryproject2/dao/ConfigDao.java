
package com.swcguild.flooringmasteryproject2.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public interface ConfigDao {
    
    public String getTestOrProd();
    public void setTestOrProd(String testOrProd);
    public void writeConfig() throws IOException;
    public boolean loadConfig() throws FileNotFoundException;
}
