package com.swcguild.browniepoints.dao;

import com.swcguild.browniepoints.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.geometry.Side;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentDaoDbImpl implements StudentDao {

    private static final String SQL_INSERT_STUDENT = "insert into students(first_name, last_name, points, side)  values"
            + "(?, ?, ?, ?)";
    private static final String SQL_DELETE_STUDENT = "delete from students where student_id=?";

    private static final String SQL_UPDATE_STUDENT
            = "update students set first_name=?, last_name=?, points=?, side=? where student_id=?";

    private static final String SQL_GET_ALL_STUDENTS
            = "select* from students";

    //DEAL WITH THIS ON JAVA SIDE- RETURN ALL STUDENTS AND JUST DISPLAY STUDENTS WITH POINT ABOVE OR BELOW CERTAIN AMOUNT
//    private static final String SQL_GET_STUDENTS_BY_POINTS 
//            = "select* from students where points=?";
    private static final String SQL_GET_STUDENTS_BY_SIDE
            = "select* from students where side=?";
    private static final String SQL_GET_STUDENT_BY_ID
            = "select* from students where student_id=?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_INSERT_STUDENT,
                student.getFirstName(),
                student.getLastName(),
                student.getPoints(),
                student.getSide());
        student.setStudentId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void removeStudent(int studentId) {
        jdbcTemplate.update(SQL_DELETE_STUDENT, studentId);
    }

    @Override
    public void updateStudent(Student student) {
        jdbcTemplate.update(SQL_UPDATE_STUDENT,
                student.getFirstName(),
                student.getLastName(),
                student.getPoints(),
                student.getSide(),
                student.getStudentId());//id doesn't change when you update the address
    }

    @Override
    public List<Student> getAllStudents() {
        return jdbcTemplate.query(SQL_GET_ALL_STUDENTS, new StudentMapper());
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_STUDENT_BY_ID, new StudentMapper(), studentId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> getStudentsBySide(String side) {
        return jdbcTemplate.query(SQL_GET_STUDENTS_BY_SIDE, new StudentMapper(), side);
    }

    private static final class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student a = new Student();
            a.setStudentId(rs.getInt("student_id"));
            a.setFirstName(rs.getString("first_name"));
            a.setLastName(rs.getString("last_name"));
            a.setPoints(rs.getInt("points"));
            a.setSide(rs.getString("side"));
            return a;
        }
    }

}
