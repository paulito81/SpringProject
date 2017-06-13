package phasfjo.mysql.impl;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import phasfjo.mysql.model.Student;
import phasfjo.mysql.StudentDao;
import phasfjo.mysql.model.StudentRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static phasfjo.mysql.impl.SQLQueryStrings.*;


/**
 * Created by paulito on 09.06.2017.
 */
public class StudentHandler extends phasfjo.mysql.impl.jdbcTemplate implements StudentDao {

    private jdbcTemplate jdbcTemplate;

    public StudentHandler(phasfjo.mysql.impl.jdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentHandler() {
    }

    @Override
    public void create() {
        jdbcTemplate.execute(CREATE_STUDENT_TABLE);
        jdbcTemplate.update(INSERT_NAME_AGE_STUDENT, "Maria", 11);
        jdbcTemplate.query(SELECT_ALL_STUDENTS, new StudentRowMapper());
    }

    @Override
    public void insert(Student student) {
        if(!student.equals(null) && student.getId() != 0 && student.getName().equals("") && student.getAge() != 0) {
            jdbcTemplate.update(INSERT_STUDENT, student.getId(), student.getAge(), student.getName());
        }else{
            System.err.println("Student was incorrect typed!");
        }
    }

    @Override
    public void insertBatchSQL(final String sql) {
        int[] i = new int[0];

        if (i.length < jdbcTemplate.batchUpdate(sql).length) {
            jdbcTemplate.batchUpdate(sql);
            System.out.println("Batch insert done!");
        }
    }

    @Override
    public void insertMultiple(List<Student> studentList) {
        jdbcTemplate.batchUpdate(INSERT_BATCH_STUDENTS, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Student student = studentList.get(i);
                preparedStatement.setLong(1, student.getId());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setString(3, student.getName());
            }

            @Override
            public int getBatchSize() {
                return studentList.size();
            }
        });
        System.out.println("Inserted mulitple students ok!");
    }

    @Override
    public Student findStudentById(int studId) {
        if (studId <= 0) {
            return null;
        }
        System.out.println("Student with id: " + studId + " was found!");
        return (Student) jdbcTemplate.queryForObject(SELECT_STUDENT_NAME_BY_ID, new Object[]{studId}, new StudentRowMapper());
    }

    @Override
    public int findTotalStudents() {
        int i = 0;
        if( i < jdbcTemplate.update(SELECT_STUDENTS_COUNT)) {
            System.out.println(jdbcTemplate.update(SELECT_STUDENTS_COUNT) + " students were successfully found!");
            return jdbcTemplate.update(SELECT_STUDENTS_COUNT);
        }
        System.err.println("No students found!");
        return 0;
    }

    @Override
    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_STUDENTS);

        for (Map row : rows) {
            Student student = new Student();
            student.setId((Long) (row.get("STUD_ID")));
            student.setAge((Integer) row.get("AGE"));
            student.setName((String) row.get("NAME"));
            studentList.add(student);
        }
        System.out.println("Students succesffully found:\n\n" + studentList.stream().map(e -> +1));
        return studentList;
    }

    @Override
    public boolean delete(int studId) {
        if(studId != 0 && studId < jdbcTemplate.update(DELETE_STUDENT_BY_ID, studId)){
            System.out.println("Student with id : " + jdbcTemplate.update(DELETE_STUDENT_BY_ID, studId) + " was deleted!");
            return 0 < jdbcTemplate.update(DELETE_STUDENT_BY_ID, studId);
        }
        System.err.println("No student with id: " + studId + " where deleted.. ");
        return false;
    }

    @Override
    public boolean update() {
        if(0 < jdbcTemplate.update(UPDATE_STUDENT_BY_NAME_ID, "Zara", 20)) {
            System.out.println(jdbcTemplate.update(UPDATE_STUDENT_BY_NAME_ID, "Zara", 20));
            return 0 < jdbcTemplate.update(UPDATE_STUDENT_BY_NAME_ID, "Zara", 20);
        }
        System.err.println("No students were updated");
        return false;
    }
    /*
    public class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();

            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));

            return student;
        }
    }
    */

}
