// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas
// Some things copied from proffessors above
// Some is modified by Mario Cako
// CS451 

package jminusminus;

import java.util.ArrayList;

abstract class JTryStatement extends JStatement {
	
    // Body of a try statement //
    private JBlock tryBody; 

    // Parameters on the catch (1..*) //
    private ArrayList<JFormalParameter> formalParameters;

    // Body of a catch statement // 
    private ArrayList<JBlock> catchBody;

    // Body of a finally statement //
    private JBlock finallyBody;
	

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

	public JTryStatement(int line, JBlock tryBody, ArrayList<JFormalParameter> formalParameters, ArrayList<JBlock> catchBody, JBlock finallyBody){
		super(line);
		this.tryBody = tryBody;
		this.formalParameters = formalParameters;
		this.catchBody = catchBody;
		this.finallyBody = finallyBody;
	}
	
    /**
     * @inheritDoc
     */
	
	public void writeToStdOut(PrettyPrinter p) {
        
        p.printf("<JTryStatement line=\"%d\">\n", line());
        p.indentRight();

        p.printf("<JTryBodyStatement>\n");
        p.indentRight();
        tryBody.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JTryBodyStatement>\n");

        p.printf("<FormalParameters>\n");
        p.indentRight();
        for(JFormalParameter f : formalParameters){
            p.indentRight();
            f.writeToStdOut(p);
            p.indentLeft();
        }
        p.indentLeft();
        p.printf("</FormalParameters>\n");
        

        p.printf("<CatchBodyStatements>\n");
        p.indentRight();
        for (JBlock b : catchBody) {
            p.indentRight();
            b.writeToStdOut(p);
            p.indentLeft();
        }
        p.indentLeft();
        p.printf("</CatchBodyStatements>\n");

    	p.printf("<FinallyBodyStatement>\n");
    	p.indentRight();
    	finallyBody.writeToStdOut(p);
    	p.indentLeft();
    	p.printf("</FinallyBodyStatement>\n");
        
        p.indentLeft();
        p.printf("</JTryStatement>\n");
	}

}



class JTryStatementOp extends JTryStatement{

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

    public JTryStatementOp(int line, JBlock tryBody, ArrayList<JFormalParameter> formalParameters, ArrayList<JBlock> catchBody, JBlock finallyBody){
            super(line, tryBody, formalParameters, catchBody, finallyBody);
        }

    /** 
     * @param context
     *            context in which names are resolved.
     * @return this for hw 3
     */

    public JTryStatementOp analyze(Context context) {
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