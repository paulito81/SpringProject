package phasfjo.mysql;


import javax.sql.DataSource;

/**
 * Created by paulito on 09.06.2017.
 */

public class jdbcTemplate extends org.springframework.jdbc.core.JdbcTemplate {

    private jdbcTemplate jdbcTemplate ;
    private DataSource dataSource;

    public jdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(jdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    jdbcTemplate(jdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public jdbcTemplate(){

    }


}
