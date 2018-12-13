// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;

/**
 * An interface declaration has a list of modifiers, a name, a list for extended and an
 * interface body;
 */

class JInterfaceDeclaration extends JAST implements JTypeDecl {

    /** Class modifiers. */
    private ArrayList<String> mods;

    /** Class name. */
    private String name;

    /** Inferface body. */
    private ArrayList<JMember> interfaceBody;

    /** Extends List of type <Type>. */
    private ArrayList<TypeName> extended;

    /** Context for this class. */
    private ClassContext context;

    /** This class type*/
    private Type type;


    /**
     * Construct an AST node for a class declaration given the line number, list
     * of class modifiers, name of the class, extended type list and the interface
     * body.
     * 
     * @param line
     *            line in which the class declaration occurs in the source file.
     * @param mods
     *            class modifiers.
     * @param name
     *            class name.
     * @param extended
     *            extended list.
     * @param interfaceBody
     *            interface body(block).
     */


    // Method format
    // return new JInterfaceDeclaration(line, mods, name, extends, interfaceBody());

     public JInterfaceDeclaration(int line, ArrayList<String> mods, String name,
            ArrayList<TypeName> superClass, ArrayList<JMember> inferfaceBody) {
        super(line);
        this.mods = mods;
        this.name = name;
        this.extended = superClass;
        this.interfaceBody = interfaceBody;
    }

    /**
     * Return the class name.
     * 
     * @return the class name.
     */

    public String name() {
        return name;
    }

    /**
     * Return thisType type.
     * 
     * @return thisType type.
     */
    public Type thisType() {
        return type;
    }

    /**
     * Return the class' super class type.
     * 
     * @return null.
     */

    public Type superType() {
        return null;
    }

    /**
     * Declare this class in the parent (compilation unit) context.
     * 
     * @param context
     *            the parent (compilation unit) context.
     */

    public void declareThisType(Context context) {
        // copied from JClassDeclaration 
        // and commented it out

        // String qualifiedName = JAST.compilationUnit.packageName() == "" ? name
        //         : JAST.compilationUnit.packageName() + "/" + name;
        // CLEmitter partial = new CLEmitter(false);
        // partial.addClass(mods, qualifiedName, Type.OBJECT.jvmName(), null,
        //         false); // Object for superClass, just for now
        // thisType = Type.typeFor(partial.toClass());
        // context.addType(line, thisType);
    }





    /**
     * Pre-analyze the members of this declaration in the parent context.
     * Pre-analysis extends to the member headers (including method headers) but
     * not into the bodies.
     * 
     * @param context
     *            the parent (compilation unit) context.
     */

    public void preAnalyze(Context context) {
        // copied from JClassDeclaration 
        // and commented it out

        // // Construct a class context
        // this.context = new ClassContext(this, context);

        // // Resolve superclass
        // superType = superType.resolve(this.context);

        // // Creating a partial class in memory can result in a
        // // java.lang.VerifyError if the semantics below are
        // // violated, so we can't defer these checks to analyze()
        // thisType.checkAccess(line, superType);
        // if (superType.isFinal()) {
        //     JAST.compilationUnit.reportSemanticError(line,
        //             "Cannot extend a final type: %s", superType.toString());
        // }

        // // Create the (partial) class
        // CLEmitter partial = new CLEmitter(false);

        // // Add the class header to the partial class
        // String qualifiedName = JAST.compilationUnit.packageName() == "" ? name
        //         : JAST.compilationUnit.packageName() + "/" + name;
        // partial.addClass(mods, qualifiedName, superType.jvmName(), null, false);

        // // Pre-analyze the members and add them to the partial
        // // class
        // for (JMember member : classBlock) {
        //     member.preAnalyze(this.context, partial);
        //     if (member instanceof JConstructorDeclaration
        //             && ((JConstructorDeclaration) member).params.size() == 0) {
        //         hasExplicitConstructor = true;
        //     }
        // }

        // // Add the implicit empty constructor?
        // if (!hasExplicitConstructor) {
        //     codegenPartialImplicitConstructor(partial);
        // }

        // // Get the Class rep for the (partial) class and make it
        // // the
        // // representation for this type
        // Type id = this.context.lookupType(name);
        // if (id != null && !JAST.compilationUnit.errorHasOccurred()) {
        //     id.setClassRep(partial.toClass());
        // }
    }


    // /**
    //  * Perform semantic analysis on the class and all of its members within the
    //  * given context. Analysis includes field initializations and the method
    //  * bodies.
    //  * 
    //  * @param context
    //  *            the parent (compilation unit) context. Ignored here.
    //  * @return the analyzed (and possibly rewritten) AST subtree.
    //  */

    public JAST analyze(Context context) {
        // copied from JClassDeclaration 
        // and deleted everything and left it with just the return this
        return this;
    }


    /**
     * Generate code for the class declaration.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
        // copied from JClassDeclaration 
        // and deleted everything
    }


    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<InterfaceDeclaration line=\"%d\" name=\"%s\">\n",
            line(), name);
        p.indentRight();
        if (extended != null) {
            for (TypeName superType : extended) {
                p.printf("<Super = \"%s\">\n", superType.toString());
            }
        }
        p.indentLeft();
        p.indentRight();
        if (context != null) {
            context.writeToStdOut(p);
        }
        if (mods != null) {
            p.println("<Modifiers>");
            p.indentRight();
            for (String mod : mods) {
                p.printf("<Modifier name=\"%s\"/>\n", mod);
            }
            p.indentLeft();
            p.println("</Modifiers>");
        }
        if (interfaceBody != null) {
            p.println("<InterfaceBlock>");
            for (JMember member : interfaceBody) {
                ((JAST) member).writeToStdOut(p);
            }
            p.println("</InterfaceBody>");
        }
        p.indentLeft();
        p.println("</InterfaceDeclaration>");
    }


    // copied from JClassDeclaration.java class
    // will leave it there for now
    // commented out for hw3 

    // /**
    //  * Generate code for an implicit empty constructor. (Necessary only if there
    //  * is not already an explicit one.)
    //  * 
    //  * @param partial
    //  *            the code emitter (basically an abstraction for producing a
    //  *            Java class).
    //  */

    // private void codegenPartialImplicitConstructor(CLEmitter partial) {
    //     // Invoke super constructor
    //     ArrayList<String> mods = new ArrayList<String>();
    //     mods.add("public");
    //     partial.addMethod(mods, "<init>", "()V", null, false);
    //     partial.addNoArgInstruction(ALOAD_0);
    //     partial.addMemberAccessInstruction(INVOKESPECIAL, superType.jvmName(),
    //             "<init>", "()V");

    //     // Return
    //     partial.addNoArgInstruction(RETURN);
    // }

    // /**
    //  * Generate code for an implicit empty constructor. (Necessary only if there
    //  * is not already an explicit one.
    //  * 
    //  * @param output
    //  *            the code emitter (basically an abstraction for producing the
    //  *            .class file).
    //  */

    // private void codegenImplicitConstructor(CLEmitter output) {
    //     // Invoke super constructor
    //     ArrayList<String> mods = new ArrayList<String>();
    //     mods.add("public");
    //     output.addMethod(mods, "<init>", "()V", null, false);
    //     output.addNoArgInstruction(ALOAD_0);
    //     output.addMemberAccessInstruction(INVOKESPECIAL, superType.jvmName(),
    //             "<init>", "()V");

    //     // If there are instance field initializations, generate
    //     // code for them
    //     for (JFieldDeclaration instanceField : instanceFieldInitializations) {
    //         instanceField.codegenInitializations(output);
    //     }

    //     // Return
    //     output.addNoArgInstruction(RETURN);
    // }

    // /**
    //  * Generate code for class initialization, in j-- this means static field
    //  * initializations.
    //  * 
    //  * @param output
    //  *            the code emitter (basically an abstraction for producing the
    //  *            .class file).
    //  */

    // private void codegenClassInit(CLEmitter output) {
    //     ArrayList<String> mods = new ArrayList<String>();
    //     mods.add("public");
    //     mods.add("static");
    //     output.addMethod(mods, "<clinit>", "()V", null, false);

    //     // If there are instance initializations, generate code
    //     // for them
    //     for (JFieldDeclaration staticField : staticFieldInitializations) {
    //         staticField.codegenInitializations(output);
    //     }

    //     // Return
    //     output.addNoArgInstruction(RETURN);
    // }

}
