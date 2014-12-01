
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDaoTest {
    
    
    private StudentDao dao;
    private Student st1;
    private Student st2;
    private Student st3;
    private Logger logger;
    
    public StudentDaoTest() {
       
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml"); 
        dao= (StudentDao) ctx.getBean("dao");
        
        st1=new Student();
        st1.setFirstName("st1");
        st1.setLastName("test");
        st1.setStudentID("1");
        
        st2=new Student();
        st2.setFirstName("st2 firstname");
        st2.setLastName("lastname");
        st2.setStudentID("2");
        
        st3=new Student();
        st3.setFirstName("st3firstname");
        st3.setLastName("lastname");
        st3.setStudentID("3");
        
        
        
        
        
        
        
    }
    
    @After
    public void tearDown() {
    }

   
     @Test  //test add, get, in the same test
     public void addGetTest() {
     
         //test add and get with a valid student id
         dao.addStudent(st1);
         Student temp=dao.getStudentById(st1.getStudentID());
         
         assertEquals (st1, temp);
     
     //test add and get with invalid student id
         temp=dao.getStudentById("bogus");
         assertNull(temp);
         
         //make sure second student added with same ID replaces original student
         
         Student replacement=new Student();
         replacement.setStudentID(st1.getStudentID());
         replacement.setFirstName("replacementFN");
         replacement.setLastName("replacementLN");
         dao.addStudent(replacement);
         
         temp=dao.getStudentById(replacement.getStudentID());
         assertEquals(replacement, temp);
     
     
     }
     
     @Test
     public void addRemoveTest (){
     //test that we can't remove a nonexistent student
         
         dao.addStudent(st1);
         dao.removeStudent(st1.getStudentID());
         
         Student temp=dao.getStudentById(st1.getStudentID());
         assertNull(temp);
     
     }
     
     
     
     @Test
     public void getByLastNameTest(){
     
     //make sure you get empty list when list is empty
         
         List <Student> temp=dao.getStudentsByLastName("bogus");
         
         assertEquals(temp.size(), 0);
     
     dao.addStudent(st1);
     dao.addStudent(st2);
     dao.addStudent(st3);
     
     temp=dao.getStudentsByLastName(st1.getLastName());
     assertEquals(temp.size(), 1);
     
     temp=dao.getStudentsByLastName(st2.getLastName());
     assertEquals(temp.size(), 2);
     
     }
     
     @Test
     public void editTest(){
         
           //add student 1, update, make sure changes took place
             
             dao.addStudent(st1);
             st1.setFirstName("new first name");
             dao.updateStudent(st1);
             Student temp=dao.getStudentById(st1.getStudentID());
             assertEquals(st1, temp);
             
           
     
                     }
     
}
