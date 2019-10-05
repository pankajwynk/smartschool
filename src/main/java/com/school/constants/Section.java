package com.school.constants;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Section {
  SECTIONA('A'),
  SECTIONB('B'),
  SECTIONC('C'),
  UNKNOWN('Z');

  final char section;

  public static Section getSection(int sec) {
    for (Section sections : Section.values()) {
      if (sections.section==sec) return sections;
    }
    return UNKNOWN;
  }

}
