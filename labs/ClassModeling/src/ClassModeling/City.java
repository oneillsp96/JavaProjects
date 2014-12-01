

package ClassModeling;


public class City {
    
    
    private String name;
    private int population;
    private int distance;
    
    
    
    public City (String nameIn, int populationIn, int distanceIn) {
    
        name=nameIn;
        population=populationIn;
        distance=distanceIn;
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
    
    
}
