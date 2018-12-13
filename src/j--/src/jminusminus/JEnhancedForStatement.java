// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas
// Some things copied from proffessors above
// Some is modified by Mario Cako
// CS451 

package jminusminus;

abstract class JEnhancedForStatement extends JStatement {
    
    // Formal parameters //
    private JFormalParameter formalParameter;

    // Expression to be evaluated in enhanced for loop //
    private JExpression expression;

    // Body of for enhanced for loop //
    private JBlock body;
    
    /**
     * Construct an AST node for a for enhanced loop statement given its line number,
     * forInit, expression, forUpdate and body
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param formalParameter
     *          paramaters 
     * @param expression
     *        to be evaluated
     * @param body
     *          of the for loop
     */

    public JEnhancedForStatement(int line, JFormalParameter formalParameter,
     JExpression expression, JBlock body) {
        super(line);
        this.formalParameter = formalParameter;
        this.expression = expression;
        this.body = body;
    }
    
    /**
     * @inheritDoc
     */
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JEnhancedForStatement line=\"%d\">\n", line());
        p.indentRight();

        p.printf("<FormalParameters>\n");
        p.indentRight();
        formalParameter.writeToStdOut(p);
        p.indentLeft();
        p.printf("</FormalParameters>\n");

        p.printf("<Expression>\n");
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Expression>\n");

        p.printf("<Statements>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Statements>\n");

        p.indentLeft();
        p.printf("</JEnhancedForStatement>\n");
    }
}


class JEnhancedForStatementOp extends JEnhancedForStatement{

/**
     * Construct an AST node for a for enhanced loop statement given its line number,
     * forInit, expression, forUpdate and body
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param formalParameter
     *          paramaters 
     * @param expression
     *        to be evaluated
     * @param body
     *          of the for loop
     */

    public JEnhancedForStatementOp (int line, JFormalParameter formalParameter, JExpression expression, JBlock body) {
        super(line, formalParameter, expression, body);
    }

    /** 
     * @param context
     *            context in which names are resolved.
     * @return this for hw 3
     */

     public JEnhancedForStatementOp analyze(Context context) {
        return this;
    }
    
    /**
     * Any string concatenation has been rewritten as a JStringConcatenationOp
     * (in analyze()), so code generation here involves simply generating code
     * for loading the operands onto the stack and then generating the
     * appropriate add instruction.
     * 
     * @param output
     *      nothing for hw 3
     */
    public void codegen(CLEmitter output) {
       
    }
}