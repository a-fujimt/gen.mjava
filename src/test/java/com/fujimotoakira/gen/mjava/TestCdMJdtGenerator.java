package com.fujimotoakira.gen.mjava;

import com.fujimotoakira.gen.mjava.cd.CdMJdtTreeGenerator;
import com.github.gumtreediff.gen.SyntaxException;
import com.github.gumtreediff.tree.Tree;
import com.github.gumtreediff.tree.Type;
import org.eclipse.jdt.core.dom.ASTNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class TestCdMJdtGenerator {

    private static final Type METHOD_DECLARATION = AbstractMJdtVisitor.nodeAsSymbol(ASTNode.METHOD_DECLARATION);

    @Test
    public void testVoidMethod() throws IOException {
        String input = "public static void main(String[] args) { System.out.println(args[0]); }";
        Tree tree = new CdMJdtTreeGenerator().generateFrom().string(input).getRoot();
        assertEquals(METHOD_DECLARATION, tree.getType());
    }

    @Test
    public void testSyntaxErrorMethod01() throws IOException {
        String input = "void foo { System.out.println(); }";
        assertThrows(SyntaxException.class, new MJdtTreeGenerator().generateFrom().string(input)::getRoot);
    }

}
