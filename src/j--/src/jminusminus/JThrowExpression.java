// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas
// Some things copied from proffessors above
// Some is modified by Mario Cako
// CS451 

package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;

abstract class JThrowExpression extends JStatement{
	
    // Body of a try statement //
    private JExpression statement; 	

     /**
     * Construct an AST node a try catch finally statement given its line number,
     * tryBody,  formalParameters, catchBody, finallyBody
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param tryBody
     *          body of try statement
     * @param formalParameters
     *        paramaters in the catch (...)
     * @param catchBody
     *        body of catch statement
     * @param finallyBody
     *          body of the finally statement
     */
     // return new JTryStatement(line,tryBody,formalParameters, catchBody, finallyBody);

	public JThrowExpression(int line, JExpression statement){
		super(line);
		this.statement = statement;
	}
	
    /**
     * @inheritDoc
     */
	
	public void writeToStdOut(PrettyPrinter p) {

        p.printf("<JThrowStatement line=\"%d\">\n", line());
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JThrowStatement>\n");
	}
}



class JThrowStatementOp extends JThrowExpression{

    /**
     * Construct an AST node a try catch finally statement given its line number,
     * tryBody,  formalParameters, catchBody, finallyBody
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param tryBody
     *          body of try statement
     * @param formalParameters
     *        paramaters in the catch (...)
     * @param catchBody
     *        body of catch statement
     * @param finallyBody
     *          body of the finally statement
     */

    public JThrowStatementOp(int line, JExpression statement){
            super(line, statement);
        }

    /** 
     * @param context
     *            context in which names are resolved.
     * @return this for hw 3
     */

    public JThrowStatementOp analyze(Context context) {
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