package com.swcguild.dvdlibrary.dao;

import org.joda.time.LocalDate;
import com.swcguild.dvdlibrary.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DvdLibraryDbImpl implements DvdLibraryDao {

    private static final String SQL_INSERT_DVD = "insert into dvds(title, release_date, mpaa_rating, director, studio, note)  values"
            + "(?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_DVD = "delete from dvds where dvd_id=?";

    private static final String SQL_UPDATE_DVD
            = "update dvds set title=?, release_date=?, mpaa_rating=?, director=?, studio=?, note=? where dvd_id=?";
    private static final String SQL_GET_ALL_DVDS
            = "select* from dvds";
    private static final String SQL_GET_DVD_BY_ID
            = "select* from dvds where dvd_id=?";
    private static final String SQL_GET_DVDS_BY_TITLE
            = "select* from dvds where title=?";
    private static final String SQL_GET_DVDS_BY_RATING
            = "select* from dvds where mpaa_rating=?";
    private static final String SQL_GET_DVDS_BY_STUDIO
            = "select* from dvds where studio=?";
    private static final String SQL_GET_DVDS_BY_DIRECTOR //sort in the method below
            = "select* from dvds where director=?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addDvd(Dvd dvd) {

        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate().toString(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate().toString(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getDvdId()); //id doesn't change when you update the dvd
    }

    //get mapper class for all 4 of these methods
    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper());
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_DVD_BY_ID, new DvdMapper(), dvdId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        return jdbcTemplate.query(SQL_GET_DVDS_BY_TITLE, new DvdMapper(), title);
    }

    @Override
    public List<Dvd> getByRating(String mpaaRating) {
        return jdbcTemplate.query(SQL_GET_DVDS_BY_RATING, new DvdMapper(), mpaaRating);
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return jdbcTemplate.query(SQL_GET_DVDS_BY_STUDIO, new DvdMapper(), studio);

    }
//rewriting these methods because OpenShift doesn't support Java 8
//    @Override
//    public List<Dvd> getReleasesInLastNYears(int years) {
//        List<Dvd> dList = new ArrayList<>();
//        dList = jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper());
//
//        return dList.stream()
//                .filter(d -> d.getAge() < years)
//                .collect(Collectors.toList());
//
//    }

    //test this !
    @Override
    public List<Dvd> getReleasesInLastNYears(int years) {

        List<Dvd> dList = new ArrayList<>();
        dList = jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper());
        List<Dvd> d2List = new ArrayList<>();

        for (int i = 0; i < dList.size(); i++) {
            Dvd d = dList.get(i);
            if (d.getAge() < years) {
                d2List.add(d);
               
            }

        }
 return d2List;
    }
////rewriting these methods because OpenShift doesn't support Java 8
//    @Override
//    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director) {
//
//        return jdbcTemplate.query(SQL_GET_DVDS_BY_DIRECTOR, new DvdMapper(), director).stream()
//                .filter(d -> d.getDirector().equalsIgnoreCase(director))
//                .collect(Collectors.groupingBy(d -> d.getMpaaRating()));          //returns map
//    }

    @Override
    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director) {

        List<Dvd> dList = new ArrayList<>();
        dList = jdbcTemplate.query(SQL_GET_DVDS_BY_DIRECTOR, new DvdMapper(), director);
        Map<String, List<Dvd>> dMap = new HashMap<>();
        List<Dvd> d2List = new ArrayList<>();

        for (int i = 0; i < dList.size(); i++) {
            Dvd d = dList.get(i);
            if (d.getDirector().equalsIgnoreCase(director)) {
                if (dMap.get(d.getMpaaRating()) == null) {
                    d2List = new ArrayList<>();
                } else {
                    d2List = dMap.get(d.getMpaaRating());

                }
                d2List.add(d);
                dMap.put(d.getMpaaRating(), d2List);
            }

        }
        return dMap;
    }

    //rewriting this method because OpenShift doesn't support Java 8 Lambda's
//    @Override
//    public double getAverageAge() {
//
//        return jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper()).stream()
//                .mapToDouble(d -> d.getAge())
//                .average()
//                .getAsDouble();
//
//    }
    
    //Java 7 version
//    @Override
//    public double getAverageAge() {
//
//        List<Dvd> dList = new ArrayList<>();
//        dList = jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper());
//        for (int i = 0; i < dList.size(); i++) {
//            Dvd d = dList.get(i);
//            double a =d.getAge();
//
//        }
//        
//        
//return avgAge;
//    }

    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {

            Dvd d = new Dvd();
            d.setDvdId(rs.getInt("dvd_id"));
            d.setTitle(rs.getString("title"));
            d.setReleaseDate(LocalDate.parse(rs.getString("release_date")));  
            d.setMpaaRating(rs.getString("mpaa_rating"));
            d.setDirector(rs.getString("director"));
            d.setStudio(rs.getString("studio"));
            d.setNote(rs.getString("note"));

            return d;
        }
    }

}
