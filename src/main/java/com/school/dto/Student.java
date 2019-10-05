package com.school.dto;


import com.datastax.driver.core.LocalDate;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

@Table("students")
@Data
public class Student {
  int admissionnumber;

  @PrimaryKeyColumn(name = "sname", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  String sname;

  @PrimaryKeyColumn(name = "standard", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  int standard;

  @PrimaryKeyColumn(name = "section", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  String section;

  @PrimaryKeyColumn(name = "rollnum", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
  int rollNum;

  Date dob;
  String gender;
  String address;
  String fathersname;
  Boolean disablechild;
  @Transient
  String grade;
}
