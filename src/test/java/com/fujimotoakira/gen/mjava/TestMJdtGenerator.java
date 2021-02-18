package com.fujimotoakira.gen.mjava;

import com.github.gumtreediff.gen.SyntaxException;
import com.github.gumtreediff.tree.Tree;
import com.github.gumtreediff.tree.Type;
import org.eclipse.jdt.core.dom.ASTNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class TestMJdtGenerator {

    private static final Type METHOD_DECLARATION = AbstractMJdtVisitor.nodeAsSymbol(ASTNode.METHOD_DECLARATION);

    @Test
    public void testVoidMethod() throws IOException {
        String input = "public static void main(String[] args) { System.out.println(args[0]); }";
        Tree tree = new MJdtTreeGenerator().generateFrom().string(input).getRoot();
        assertEquals(METHOD_DECLARATION, tree.getType());
    }

    @Test
    public void testHasReturnValueMethod() throws IOException {
        String input = "int max(int x, int y) { if (x > y) return x; else return y; }";
        Tree tree = new MJdtTreeGenerator().generateFrom().string(input).getRoot();
        assertEquals(METHOD_DECLARATION, tree.getType());
    }

    @Test
    public void testAnnotationMethod() throws IOException {
        String input = "@Test public void test() { int a = 1, b = 0; b += 1; assertEquals(a, b); }";
        Tree tree = new MJdtTreeGenerator().generateFrom().string(input).getRoot();
        assertEquals(METHOD_DECLARATION, tree.getType());
    }

    @Test
    public void testSyntaxErrorMethod01() throws IOException {
        String input = "void foo { System.out.println(); }";
        assertThrows(SyntaxException.class, new MJdtTreeGenerator().generateFrom().string(input)::getRoot);
    }

    @Test
    public void testSyntaxErrorMethod02() throws IOException {
        String input = "int max(int x, int y { if (x > y) return x; else return y; }";
        assertThrows(SyntaxException.class, new MJdtTreeGenerator().generateFrom().string(input)::getRoot);
    }

}
