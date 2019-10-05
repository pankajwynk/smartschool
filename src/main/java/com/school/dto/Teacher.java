package com.school.dto;

import java.util.Set;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("teachers")
@Data
public class Teacher {

  @PrimaryKeyColumn(name = "teacherid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  int teacherid;

  @PrimaryKeyColumn(name = "sname", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
  String sname;

  @PrimaryKeyColumn(name = "standard", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
  int standard;

  @PrimaryKeyColumn(name = "section", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
  String section;

  Set<String> subjects;

  String gender;

  String address;
}
