package com.swcguild.dvdlibrarywebapp;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.model.Dvd;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DvdLibraryTest {

    private DvdLibraryDao dao;

    Dvd dvd1;
    Dvd dvd2;
    Dvd dvd3;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (DvdLibraryDao) ctx.getBean("dvdLibraryDao");

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from dvds");

        dvd1 = new Dvd();
        dvd1.setTitle("Titanic");
        dvd1.setReleaseDate(LocalDate.parse("1997-01-01"));
        dvd1.setMpaaRating("R");
        dvd1.setDirector("Cameron");
        dvd1.setStudio("Dreamworks");
        dvd1.setNote("romantic");

        dvd2 = new Dvd();
        dvd2.setTitle("Friday the 13th");
        dvd2.setReleaseDate(LocalDate.parse("1970-01-01"));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("James");
        dvd2.setStudio("Sony");
        dvd2.setNote("Scary");

        dvd3 = new Dvd();
        dvd3.setTitle("Citizen Kane");
        dvd3.setReleaseDate(LocalDate.parse("1910-01-01"));
        dvd3.setMpaaRating("G");
        dvd3.setDirector("Stanley");
        dvd3.setStudio("MGM");
        dvd3.setNote("Classic");

    }

    @After
    public void tearDown() {
    }

    //test add/remove/ getby dvdId 
    @Test
    public void DVDTest0() {
        dao.addDvd(dvd1);

        Dvd fromDb = new Dvd();
        fromDb = dao.getDvdById(dvd1.getDvdId());
        assertEquals(dvd1.getTitle(), fromDb.getTitle());

    }

    //test add/getAllDvds
    @Test
    public void DVDTest1() {

        dao.addDvd(dvd1);

        //test listAll
        List<Dvd> aList = new ArrayList<>();
        aList = dao.getAllDvds();
        int a = aList.size();

        assertEquals(a, 1);

    }

    //test get by rating
    @Test
    public void DVDTest2() {

        dao.addDvd(dvd1);

        List<Dvd> bList = new ArrayList<>();
        bList = dao.getByRating(dvd1.getMpaaRating());
        assertEquals(bList.size(), 1);

    }

    //test get by title
    @Test
    public void DVDTest3() {

        dao.addDvd(dvd1);

        List<Dvd> cList = new ArrayList<>();
        cList = dao.getByTitle("Titanic");  //used literal name "Titanic" here, could also have used dvd1.getTitle()
        assertEquals(cList.size(), 1);

    }

    //test get by studio
    @Test
    public void DVDTest4() {

        dao.addDvd(dvd1);

        List<Dvd> dList = new ArrayList<>();
        dList = dao.getByStudio(dvd1.getStudio());
        assertEquals(dList.size(), 1);

    }

    //test remove
    @Test
    public void test5() {

        dao.addDvd(dvd1);

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = dao.getAllDvds();
        assertEquals(dvdList.size(), 1);
        dao.removeDvd(dvd1.getDvdId());
        dvdList = dao.getAllDvds();
        assertEquals(dvdList.size(), 0);
    }

//test get Releases in last N Years
    @Test
    public void test6() {

        dao.addDvd(dvd1);
        dao.addDvd(dvd2);
        dao.addDvd(dvd3);

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = dao.getReleasesInLastNYears(1000);  //Also tested this with smaller year values with smaller expected numbers in the list

        assertEquals(dvdList.size(), 3);
    }

//test get by directorGroup By Rating
    @Test
    public void test7() {

        dao.addDvd(dvd1);

        //rating, list of DVD's by director with that rating
        Map<String, List<Dvd>> dvdMap1 = dao.getByDirectorGroupByRating("Cameron");
      //dvdMap1 should now be (R, List of DVD's with only titanic) 

        //could compare with another Map, adding (R, Titanic) but would have to sort it
        Collection myValues = dvdMap1.values();   //
        Iterator<List<Dvd>> iter = myValues.iterator();

        List<Dvd> tList = new ArrayList<>();
        while (iter.hasNext()) {

            tList = iter.next();
            //tlist should now hold just one dvd object with title "Titanic", at position 0
        }
        //get the object at position 0 and put it in Dvd titanic, then get title, which should be "Titanic"
        Dvd titanic = tList.get(0);
        titanic.getTitle();

        assertEquals(titanic.getTitle(), "Titanic");

    }

    //test get average age
    
    //need to implement and test later
//    @Test
//    public void Test8() {
//
//        dao.addDvd(dvd1);
//        dao.addDvd(dvd2);
//
//        double avgAge = dao.getAverageAge();
//
//        double expectedAvg = ((dvd1.getAge() + dvd2.getAge()) / 2);
//
//        //this big delta value is sloppy....I'm sure there's a way to have getAge return a double instead of a long
//        double delta = 10.0;
//
//        assertEquals(avgAge, expectedAvg, delta);

//    }
}
