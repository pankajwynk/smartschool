package com.school.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Standard {
  FIRST(1, getPrimaryEducation(), getMaxPrimaryClassStrength()),
  SECOND(2, getPrimaryEducation(), getMaxPrimaryClassStrength()),
  THIRD(3, getPrimaryEducation(), getMaxPrimaryClassStrength()),
  FOURTH(4, getPrimaryEducation(), getMaxPrimaryClassStrength()),
  FIFTH(5, getPrimaryEducation(), getMaxPrimaryClassStrength()),
  SIXTH(6, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  SEVENTH(7, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  EIGHTH(8, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  NINTH(9, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  TENTH(10, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  ELEVENTH(11, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  TWELVETH(12, getSecondaryEducation(), getMaxSecondaryClassStrength()),
  UNKNOWN(0,"",0);
  private int classNumber;
  private String education;
  private int maxStrengthClass;
  static String primaryEducation = "PRIMARY";
  static String secondaryEducation = "SECONDARY";
  static int maxPrimaryClassStrength = 90;
  static int maxSecondaryClassStrength = 120;

  public static String getPrimaryEducation() {
    return primaryEducation;
  }

  public static String getSecondaryEducation() {
    return secondaryEducation;
  }

  public static int getMaxPrimaryClassStrength() {
    return maxPrimaryClassStrength;
  }

  public static int getMaxSecondaryClassStrength() {
    return maxSecondaryClassStrength;
  }

  public static Standard getClassNum(int classNum) {
    for (Standard classNums : Standard.values()) {
      if (classNums.classNumber==classNum) return classNums;
    }
    return UNKNOWN;
  }

}
