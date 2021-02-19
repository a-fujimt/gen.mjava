/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2021 Akira Fujimoto <a-fujimt@ist.osaka-u.ac.jp>
 */

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
