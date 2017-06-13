package phasfjo.mysql;

/**
 * Created by paulito on 09.06.2017.
 */
public class SQLQueryStrings {

    public static String CREATE_STUDENT_TABLE = "CREATE TABLE Student( " +
            "ID   INT NOT NULL AUTO_INCREMENT, " +
            "NAME VARCHAR(20) NOT NULL, " +
            "AGE  INT NOT NULL, " +
            "PRIMARY KEY (ID) );";

    public static String UPDATE_STUDENT_BATCH = "UPDATE Student SET NAME = 'BATCHUPDATE'";
    public static String SELECT_ALL_STUDENTS = "SELECT * FROM Student";
    public static String SELECT_ALL_STUDENTS_BY_ID = "SELECT * FROM Student WHERE CUST_ID = ?";
    public static String DELETE_STUDENT_BY_ID = "DELETE Student WHERE CUST_ID = ?";
    public static String INSERT_NAME_AGE_STUDENT = "INSERT INTO Student (name, age) VALUES (?, ?)";
    public final static String INSERT_BATCH_STUDENTS = "INSERT INTO Student (STUD_ID, NAME, AGE) VALUES (?, ?, ?)";
    public static String INSERT_STUDENT = "INSERT INTO Customer (STUD_ID, NAME, AGE) VALUES (?, ?, ?)";
    public static String UPDATE_STUDENT_BY_NAME_ID = "UPDATE Student SET NAME = ? where CUST_ID = ?";
    public static String SELECT_STUDENTS_COUNT = "SELECT COUNT(*) FROM Student";
    public static String SELECT_STUDENT_AGE_BY_ID = "SELECT age FROM Student WHERE CUST_ID = ?";
    public static String SELECT_STUDENT_NAME_BY_ID = "SELECT name FROM Student WHERE CUST_ID = ?";
}

