package phasfjo.mysql;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by paulito on 09.06.2017.
 */
public class StudentRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("STUD_ID"));
        student.setAge(resultSet.getInt("AGE"));
        student.setName(resultSet.getString("NAME"));

        return student;
    }
}
