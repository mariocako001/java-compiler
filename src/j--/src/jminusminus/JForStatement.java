// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas
// Some things copied from proffessors above
// Some is modified by Mario Cako
// CS451 

package jminusminus;

import java.util.ArrayList;

abstract class JForStatement extends JStatement {
	
    // initialization part of for loop //
	ArrayList<JStatement> forInit;

    // update part of for loop //
	ArrayList<JStatement> forUpdate;

    // Expression to be evaluated in for loop //
	JExpression expression;

    // Body of for loop //
	JBlock body;
	

     /**
     * Construct an AST node for a for loop statement given its line number,
     * forInit, expression, forUpdate and body
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param forInit
     *          initialization part of for loop
     * @param expression
     *        to be evaluated
     * @param forUpdate
     *        update part of for loop
     * @param body
     *          of the for loop
     */

	public JForStatement(int line, ArrayList<JStatement> forInit,
     JExpression expression, ArrayList<JStatement> forUpdate,
     JBlock body){
		super(line);
		this.forInit = forInit;
		this.forUpdate = forUpdate;
		this.expression = expression;
		this.body = body;
	}
	
    /**
     * @inheritDoc
     */
	
	public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<InitialExpression>\n");
        p.indentRight();
        for (JStatement s : forInit) {
            p.indentRight();
            s.writeToStdOut(p);
            p.indentLeft();
        }
        p.indentLeft();
        p.printf("</InitialExpression>\n");
        p.printf("<TestExpression>\n");
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        
        p.printf("<UpdateExpression>\n");
        p.indentRight();
        for (JStatement s : forUpdate) {
            p.indentRight();
            s.writeToStdOut(p);
            p.indentLeft();
        }
        p.indentLeft();
        p.printf("</UpdateExpression>\n");

    	p.printf("<Statement>\n");
    	p.indentRight();
    	body.writeToStdOut(p);
    	p.indentLeft();
    	p.printf("</Statement>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");
	}

}



class JForStatementOp extends JForStatement{

    /**
     * Construct an AST node for a for loop statement given its line number,
     * forInit, expression, forUpdate and body
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param forInit
     *          initialization part of for loop
     * @param expression
     *        to be evaluated
     * @param forUpdate
     *        update part of for loop
     * @param body
     *          of the for loop
     */

    public JForStatementOp(int line, ArrayList<JStatement> forInit, JExpression expression, ArrayList<JStatement> forUpdate,JBlock body){
            super(line, forInit, expression, forUpdate, body);
        }

    /** 
     * @param context
     *            context in which names are resolved.
     * @return this for hw 3
     */

    public JForStatementOp analyze(Context context) {
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