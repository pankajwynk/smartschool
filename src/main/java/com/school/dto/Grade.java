package com.school.dto;

import com.school.constants.Section;

import com.school.constants.Standard;
import lombok.Data;

@Data
public class Grade {
  private Standard standard;
  private Section section;
}
