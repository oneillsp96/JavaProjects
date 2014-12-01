//package com.swcguild.dvdlibrary.dao;
//
//import com.swcguild.dvdlibrary.model.Dvd;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class DvdLibraryInMemImpl implements DvdLibraryDao {
//
//    private Map<Integer, Dvd> dvdMap = new HashMap<>();
//
//    private static int dvdIdCounter = 0;
//
////  @Override
////    public Dvd getDvdById(int DvdId) {
////        return DvdList.get(DvdId);
////    }
//    @Override
//    public void addDvd(Dvd dvd) {
//        dvd.setDvdId(dvdIdCounter);
//        dvdIdCounter++;
//        
//        dvdMap.put(dvd.getDvdId(), dvd);
//
//// counter mimics database assignment of ID's
//    
//    }
//
//    @Override
//    public void removeDvd (int dvdId) {
//        dvdMap.remove(dvdId);
//    }
//    
//    @Override 
//    public void updateDvd(Dvd dvd) {
//    dvdMap.put(dvd.getDvdId(), dvd);
//    
//    }
//
//    @Override
//    public List<Dvd> getAllDvds() {
//        Collection<Dvd> d = dvdMap.values();
//        return new ArrayList(d);
//      
//    }
//    
//    @Override
//     public Dvd getDvdById(int dvdId){
//     return dvdMap.get(dvdId);
//     
//     }
//
//     
//     
//     
//    @Override
//    public List<Dvd> getByTitle(String title) {
//
//        Collection<Dvd> coll = dvdMap.values();
//        return coll.stream()
//       
//                .filter(d -> d.getTitle().equalsIgnoreCase(title))
//                .collect(Collectors.toList());
//  }
//
//    @Override
//    public List<Dvd> getReleasesInLastNYears(int years) {
//
//       Collection<Dvd> coll = dvdMap.values();
//        return coll.stream()
//       
//                .filter(d -> d.getAge() < years)
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public List<Dvd> getByRating(String mpaaRating) {
//
//        Collection<Dvd> coll = dvdMap.values();
//        return coll.stream()
//                .filter(r -> r.getMpaaRating().equalsIgnoreCase(mpaaRating))
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public List<Dvd> getByStudio(String studio) {
//
//        return dvdMap.values().stream() //same as in getByRating, slightly different syntax but same thing happening
//                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
//                .collect(Collectors.toList());
//
//    }
//
//    //string is rating?
//    @Override
//    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director) {
//
//        return dvdMap.values().stream()
//                .filter(d -> d.getDirector().equalsIgnoreCase(director))
//                .collect(Collectors.groupingBy(d -> d.getMpaaRating()));
//
//
//    }
//
//    @Override
//    public double getAverageAge() {
//
//        return dvdMap.values().stream()
//                .mapToDouble(d -> d.getAge())
//                .average()
//                .getAsDouble();
//
//    }
//
//}
