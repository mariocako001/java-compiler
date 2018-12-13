// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas
// Somethings copied from proffessors above
// Some is modified by Mario Cako
// CS451 

package jminusminus;

abstract class JConditionalExpression extends JExpression{

    /** The true expression if lhs is true */
    private JExpression truePart;

    /** The false expression if lhs is false */
    private JExpression falsePart;

    /** The lhs or the condtion that is being evaluated to true of false*/ 
    private JExpression lhs;

    /**
     * Construct an AST node for a conditional expression given its line number,
     * the lhs, the true part expression and the false part expression;
     * 
     * @param line
     *            line in which the binary expression occurs in the source file.
     * @param lhs
     *            the lhs operand.
     * @param truePart
     *            the true part expression.
     * @param falsePart
     *            the false part expression.
     */

    public JConditionalExpression(int line, JExpression lhs, JExpression truePart, JExpression falsePart) {
        super(line);
        this.lhs = lhs;
        this.truePart = truePart;
        this.falsePart = falsePart;
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JConditionalExpression line=\"%d\" type=\"%s\" "
                + "operator=\"%s\">\n", line(), ((type == null) ? "" : type
                .toString()),Util.escapeSpecialXMLChars("?"));
        p.indentRight();

        p.printf("<TestExpression>\n");
        p.indentRight();
        lhs.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");

        p.printf("<TrueClause>\n");
        p.indentRight();
        truePart.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TrueClause>\n");

        p.printf("<FalseClause>\n");
        p.indentRight();
        falsePart.writeToStdOut(p);
        p.indentLeft();
        p.printf("</FalseClause>\n");
        p.indentLeft();

        p.printf("</JConditionalExpression>\n");
    }

}

    class JConditionalExpressionOp extends JConditionalExpression{


     /**
     * Construct an AST node for an addition expression given its line number,
     * the lhs, true part and false part expression.
     * 
     * @param line
     *            line in which the addition expression occurs in the source
     *            file.
     * @param lhs
     *            the lhs operand.
     * @param truePart
     *            the truePart expression.
     * @param falsePart
     *            the falsePart expression.
     */

    public JConditionalExpressionOp(int line, JExpression lhs, JExpression truePart, JExpression falsePart) {
        super(line, lhs, truePart, falsePart);
    }


     /** 
     * @param context
     *            context in which names are resolved.
     * @return this for hw 3
     */

    public JExpression analyze(Context context) {
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