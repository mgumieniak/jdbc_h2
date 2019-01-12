package com.jdbc.h2.jdbc_h2.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setDepartment(rs.getString("department"));
            return student;
        }
    }

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] {
                id}, new BeanPropertyRowMapper<Student>(Student.class));
    }

    public List<Student> findAll(){
        return  jdbcTemplate.query("select * from student",
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    public List<Student> findByName(String name){
        return jdbcTemplate.query("select * from student where name=?", new Object[]{name},
                new BeanPropertyRowMapper(Student.class));
    }

    public List<Student> findByDepartment(String department){
        return jdbcTemplate.query("select * from student where department=?", new Object[]{department},
                new BeanPropertyRowMapper(Student.class));
    }

    public int deleteById(long id){
        return jdbcTemplate.update("delete from student where id=?",new Object[]{id});
    }

    public int deleteByName(String name){
        return jdbcTemplate.update("delete from student where name=?",new Object[]{name});
    }

    public int insert(Student student){
        return jdbcTemplate.update("insert into student(id,name,department)"+
                "values(?,?,?)", new Object[]{student.getId(),student.getName(),student.getDepartment()});
    }

    public int update(Student student){
        return jdbcTemplate.update("update student set name= ?, department= ? where id = ?",
                new Object[]{student.getName(),student.getDepartment(),student.getId()});
    }
}