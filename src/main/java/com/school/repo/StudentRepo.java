package com.school.repo;

import com.school.dto.Student;
import java.util.List;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StudentRepo extends CassandraRepository<Student,String> {

  Student findBySnameAndSectionAndStandard(String sname,String section,int standard);

}
