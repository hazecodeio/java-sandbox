package org.hsmak.abstractions.expression.postfix.abstraction;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoolExprTreeWithANDPrecedenceTest {
    private BoolExprTreeWithANDPrecedence boolExprTreeWithANDPrecedence;

    @Before
    public void setUp() throws Exception {
        boolExprTreeWithANDPrecedence = new BoolExprTreeWithANDPrecedence();
    }

    @Test
    public void convertInfixToPostfix() throws Exception {
        List<String> infixBoolean = Arrays.asList("T", "&", "F", "|", "T", "&", "T", "&", "F", "|", "F", "|", "T", "&", "T");
        List<String> infixToPostfixActual = boolExprTreeWithANDPrecedence.convertInfixToPostfix(infixBoolean);

        List<String> infixToPostfixExpected = Arrays.asList("T", "F", "&", "T", "T", "F", "&", "&", "|", "F", "T", "T", "&", "|", "|");

        System.out.println(infixToPostfixActual);

        assertThat(infixToPostfixActual).isEqualTo(infixToPostfixExpected);
    }

}