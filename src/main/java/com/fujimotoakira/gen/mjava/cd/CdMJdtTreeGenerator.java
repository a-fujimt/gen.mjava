/*
 * This file is part of GumTree.
 *
 * GumTree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GumTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GumTree.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2011-2015 Jean-Rémy Falleri <jr.falleri@gmail.com>
 * Copyright 2011-2015 Floréal Morandat <florealm@gmail.com>
 *
 * This software is modified on Feb. 2021.
 * Copyright 2021 Akira Fujimoto <a-fujimt@ist.osaka-u.ac.jp>
 */

package com.fujimotoakira.gen.mjava.cd;

import com.fujimotoakira.gen.mjava.AbstractMJdtTreeGenerator;
import com.github.gumtreediff.gen.Register;
import com.github.gumtreediff.gen.Registry;
import com.fujimotoakira.gen.mjava.AbstractMJdtVisitor;
import org.eclipse.jdt.core.compiler.IScanner;

@Register(id = "mjava-cdjdt", accept = "\\.mjava$", priority = Registry.Priority.MINIMUM)
public class CdMJdtTreeGenerator extends AbstractMJdtTreeGenerator {
    @Override
    protected AbstractMJdtVisitor createVisitor(IScanner scanner) {
        return new CdMJdtVisitor();
    }
}
