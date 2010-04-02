/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */

package com.sonarsource.parser.matcher;

import com.sonarsource.sslr.api.Token;
import com.sonarsource.sslr.api.TokenType;

public class TokenTypeMatcher extends TokenMatcher {

  private final TokenType type;

  public TokenTypeMatcher(TokenType type) {
    this(type, false);
  }

  public TokenTypeMatcher(TokenType type, boolean hasToBeSkippedFromAst) {
    super(hasToBeSkippedFromAst);
    this.type = type;
  }

  @Override
  public void setParentRule(Rule parentRule) {
    this.parentRule = parentRule;
  }

  public String toString() {
    return type.getName();
  }

  @Override
  protected boolean isExpectedToken(Token token) {
    return type == token.getType();
  }
}
