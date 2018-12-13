// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import java.util.ArrayList;

/**
 * The AST node for a StaticBlock, which delimits a nested level of scope.
 */

class JStaticBlock extends JAST implements JMember{

    /** Current block. */
    private JBlock block;

    /**
     * The new context (built in analyze()) represented by this block.
     */
    private LocalContext context;

    /**
     * Construct an AST node for a block given its line number, and the list of
     * statements forming the block body.
     * 
     * @param line
     *            line in which the block occurs in the source file.
     * @param statements
     *            list of statements forming the block body.
     */

    public JStaticBlock(int line, JBlock block) {
        super(line);
        this.block = block;
    }

    /**
     * Analyzing a block consists of creating a new nested context for that
     * block and analyzing each of its statements within that context.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JStaticBlock analyze(Context context) {
        // // { ... } defines a new level of scope.
        // this.context = new LocalContext(context);

        // for (int i = 0; i < statements.size(); i++) {
        //     statements.set(i, (JStatement) statements.get(i).analyze(
        //             this.context));
        // }
        
        return this;
    }

    public void preAnalyze(Context c, CLEmitter cle){
        // just to override it
    }
    

    /**
     * Generating code for a block consists of generating code for each of its
     * statements.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
        // for (JStatement statement : statements) {
        //     statement.codegen(output);
        // }
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JStaticBlock line=\"%d\">\n", line());
        p.indentRight();
        block.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JStaticBlock>\n");
    }

}
