// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas
// Some things copied from proffessors above
// Some is modified by Mario Cako
// CS451 

package jminusminus;

import java.util.ArrayList;

abstract class JForInitDeclaration extends JStatement {
    
    // Variables declared list //
    private ArrayList<JVariableDeclarator> variableDeclarator;
    

     /**
     * Construct an AST node for a initialization declaration given its line number,
     * and the variables list
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param variableDeclarator
     *          variables declared list.
     *
     */

    public JForInitDeclaration(int line, ArrayList<JVariableDeclarator> variableDeclarator) {
        super(line);
        this.variableDeclarator = variableDeclarator;
    }
    

     /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.println("<VariableDeclaration>");
        p.indentRight();
        // if (variableDeclarator != null) {
            p.println("<VariableDeclarators>");
            for (JVariableDeclarator d : variableDeclarator) {
                p.indentRight();
                d.writeToStdOut(p);
                p.indentLeft();
            }
            p.println("</VariableDeclarators>");
        // }
        p.indentLeft();
        p.println("</VariableDeclaration>");
    }
}



class JForInitDeclarationOp extends JForInitDeclaration{
    
  /**
     * Construct an AST node for a initialization declaration given its line number,
     * and the variables list
     * 
     * @param line
     *            line in which the initialization declaration occurs in the source file.
     * @param variableDeclarator
     *          variables declared list.
     *
     */

 public JForInitDeclarationOp(int line, ArrayList<JVariableDeclarator> variableDeclarator) {
        super(line,variableDeclarator);
    }

    /** 
     * @param context
     *            context in which names are resolved.
     * @return this for hw 3
     */

public JForInitDeclarationOp analyze(Context context) {
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
