package com.github.nexus85.practice.javatest.custommatcher;
/**
 * @file CustomMatcher.java
 * 
 * @author wbao
 * 
 * @date Jun 24, 2011
 * 
 *       Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
 */


import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMatcher<T> implements IArgumentMatcher {

  private final T expected;
  private final Checker checker;

  private static final Logger logger = LoggerFactory.getLogger(CustomMatcher.class);

  public static <T> T customMatcher(final Checker checker, final T expected) {

    EasyMock.reportMatcher(new CustomMatcher<T>(checker, expected));
    return null;
  }

  public CustomMatcher(final Checker checker, final T expected) {

    this.expected = expected;
    this.checker = checker;
  }

  public boolean matches(final Object actual) {

    if (checker == null) {
      logger.debug("CustomMatcher: null checker Object");
      return false;
    }
    
    if(expected == null && actual != null){
      logger.debug("CustomMatcher: expected null, actual not null");
      return false;
    }
    
    if(expected != null && actual == null){
      logger.debug("CustomMatcher: expected not null, actual null");
      return false;
    }

    return checker.check(expected, actual);
  }

  public void appendTo(StringBuffer buffer) {

    buffer.append("customMatcher(");
    if (checker == null) {
      buffer.append("null");
    } else {
      buffer.append(checker.getClass().getName());
    }
    buffer.append(", ");
    if (expected == null) {
      buffer.append("null");
    } else {
      buffer.append(expected.getClass().getName());
    }
    buffer.append(")");
  }
}
