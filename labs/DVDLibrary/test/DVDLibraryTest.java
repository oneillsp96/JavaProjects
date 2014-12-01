
import dvdlibrary.dao.DVDLibrary;
import dvdlibrary.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class DVDLibraryTest {

    DVDLibrary test;

    public DVDLibraryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new DVDLibrary();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void DVDLibraryTest() {
        String title1 = "Titanic";
        String releaseDate = "1997";
        String rating = "R";
        String director = "Cameron";
        String studio = "Dreamworks";
        String userRatingOrNote = "meh";

        DVD dvd1 = new DVD(title1, releaseDate, rating, director, studio, userRatingOrNote);  //creates my titanic dvd object

        //testing add DVD
        test.addDVD(title1, dvd1);         //add dvd1
        DVD dvd2 = test.findDVD(title1);     //create dvd 2 and set it equal to the dvd found by searching Titanic(title1)....which is dvd1
        assertEquals(dvd1, dvd2);           //now dvd1 an dvd2 should be equal

        //testing find DVD
        DVD dvd3 = test.findDVD(title1);
        boolean y = dvd1.equals(dvd3);      //just using boolean to try a different technique
        assertTrue(y);

        //testing remove DVD
        DVD dvd4 = test.removeDVD(title1);       //set dvd3 equal to dvd that was removed
        assertEquals(dvd4, dvd1);               //dvd removed(dvd3) should be the same as dvd added in the beginning (dvd1)

    }

    @Test
    public void DVDLibraryTest2() {

        //test "find all"
        String title1 = "Titanic";
        String releaseDate = "1997";
        String rating = "R";
        String director = "Cameron";
        String studio = "Dreamworks";
        String userRatingOrNote = "meh";

        String title2 = "V For Vendetta";    //need to have a new title to add a new dvd to test this funcionality (  findAll() )
        //this second title must start with a letter after T if we're going to assert what assert below

        DVD dvd1 = new DVD(title1, releaseDate, rating, director, studio, userRatingOrNote);
        DVD dvd2 = new DVD(title2, releaseDate, rating, director, studio, userRatingOrNote);  //creates the Office Space DVD object

        test.addDVD(title1, dvd1);
        test.addDVD(title2, dvd2);

        DVD[] array1 = test.findAll();
        Arrays.sort(array1);

        DVD[] array2 = new DVD[2];
        array2[0] = dvd1;
        array2[1] = dvd2;

        boolean z = Arrays.equals(array1, array2);  //testing "list all addresses"
        assertTrue(z);

        try {
            test.writeDVDLibrary();
        } catch (IOException ioe1) {
        };

        DVDLibrary a1 = new DVDLibrary();  //create object just so you can use loadLibrary method on next line

        try {
            a1.loadDVDLibrary();               //read in from DVDlibrary 
            DVD[] dvdArrayA = a1.findAll();    //put all DVD's in an array
            Arrays.sort(dvdArrayA);           //sorts alphabetically

            boolean xxx = Arrays.equals(dvdArrayA, array1);
            assertTrue(xxx);

        } catch (FileNotFoundException fnf) {
        };

    }
}
