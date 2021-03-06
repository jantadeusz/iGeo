/*---

    iGeo - http://igeo.jp

    Copyright (c) 2002-2013 Satoru Sugihara

    This file is part of iGeo.

    iGeo is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, version 3.

    iGeo is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with iGeo.  If not, see <http://www.gnu.org/licenses/>.

---*/

package igeo.gui;
//package igeo.gl;

import javax.media.opengl.*;

/**
   Objectified OpenGL quad strip drawing process.
   
   @author Satoru Sugihara
*/
public class IGLQuadStrip extends IGLElement{
    private IGLQuadStrip(){}
    private IGLQuadStrip(int size){ super(size); }
    
    public void draw(GL2 gl){
	gl.glBegin(GL2.GL_QUAD_STRIP);
	drawPoints(gl);
	gl.glEnd();
    }
}
