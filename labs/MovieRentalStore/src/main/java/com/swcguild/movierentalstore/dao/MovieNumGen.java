
package com.swcguild.movierentalstore.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface MovieNumGen {
    
    public int movieNumPlus() throws FileNotFoundException;
    public int movieNumGen()throws FileNotFoundException, IOException;
    public void movieNumWrite()throws IOException;
    
}
