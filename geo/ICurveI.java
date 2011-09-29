/*---

    iGeo - http://igeo.jp

    Copyright (c) 2002-2011 Satoru Sugihara

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

package igeo.geo;

/**
   Abstract interface of NURBS curve.
   
   @author Satoru Sugihara
   @version 0.7.0.0;
*/
public interface ICurveI extends ICurveOp, ITransformable{
    
    /**
       @return fixed value but in wrapper class
    */
    public ICurveGeo get();
    
    /**
       @return duplicated instance
    */
    public ICurveI dup();
    
    
    public IVecI pt(double u);
    public IVecI pt(IDoubleI u);
    
    public IVecI tan(double u);
    public IVecI tan(IDoubleI u);
    
    public IVecI cp(int i);
    public IVecI cp(IIntegerI i);
    
    public IVecI ep(int i);
    public IVecI ep(IIntegerI i);
    
    /** all control points */
    public IVecI[] cps();
    
    public double knot(int i);
    public IDoubleI knot(IIntegerI i);
    
    /** all knot values */
    public double[]knots();
    public double[] knots(ISwitchE e);
    public IDoubleI[] knots(ISwitchR r);
        
    public int knotNum();
    //public IIntegerI knotNumR();
    public int knotNum(ISwitchE e);
    public IIntegerI knotNum(ISwitchR r);

    /**
       @return returns true if any of control point has non-default(1.0) weight otherwise false.
    */
    public boolean isRational();
    public boolean isRational(ISwitchE e);
    public IBoolI isRational(ISwitchR r);
    
    public int deg();
    //public IIntegerI degR();
    public int deg(ISwitchE e);
    public IIntegerI deg(ISwitchR r);
    
    public int num(); // equals to cpNum
    //public IIntegerI numR(); // equals to cpNum
    public int num(ISwitchE e); // equals to cpNum
    public IIntegerI num(ISwitchR r); // equals to cpNum
    
    public int cpNum(); //
    //public IIntegerI cpNumR(); //
    public int cpNum(ISwitchE e); //
    public IIntegerI cpNum(ISwitchR r); //
    
    public IVecI start();
    public IVecI end();
    public IVecI startCP();
    public IVecI endCP();
    
    
    public int epNum();
    //public IIntegerI epNumR();
    public int epNum(ISwitchE e);
    public IIntegerI epNum(ISwitchR r);
    
    public double len();
    //public IDouble lenR();
    public double len(ISwitchE e);
    public IDouble len(ISwitchR r);
    
    
    // epIdx: 0-epNum, epFraction: 0-1 or -1-0
    public double u(int epIdx, double epFraction);
    public IDoubleI u(IInteger epIdx, IDouble epFraction);
    
    public double ustart();
    public double uend();
    //public IDoubleI ustartR();
    //public IDoubleI uendR();
    public double ustart(ISwitchE e);
    public double uend(ISwitchE e);
    public IDoubleI ustart(ISwitchR r);
    public IDoubleI uend(ISwitchR r);
    
    
    public boolean isClosed();
    //public IBoolI isClosedR();
    public boolean isClosed(ISwitchE e);
    public IBoolI isClosed(ISwitchR r);
    
    /** reverse self curve ; not creating a new object
     */
    public ICurveI rev();
    
    
    
    /***************************************************************************
     * transformation: API of ITransformable inteface
     ***************************************************************************/
    
    public ICurveI add(double x, double y, double z);
    public ICurveI add(IDoubleI x, IDoubleI y, IDoubleI z);
    public ICurveI add(IVecI v);
    public ICurveI sub(double x, double y, double z);
    public ICurveI sub(IDoubleI x, IDoubleI y, IDoubleI z);
    public ICurveI sub(IVecI v);
    public ICurveI mul(IDoubleI v);
    public ICurveI mul(double v);
    public ICurveI div(IDoubleI v);
    public ICurveI div(double v);
    
    public ICurveI neg();
    /** same with neg */
    //public ICurveI rev(); // rev is used in curve to revrse u parameter
    
    public ICurveI flip();
    
    
    
    /** scale add */
    public ICurveI add(IVecI v, double f);
    public ICurveI add(IVecI v, IDoubleI f); 
    
    public ICurveI rot(IVecI axis, IDoubleI angle);
    public ICurveI rot(IVecI axis, double angle);
    
    public ICurveI rot(IVecI center, IVecI axis, IDoubleI angle);
    public ICurveI rot(IVecI center, IVecI axis, double angle);
    
    /** rotate to destination direction vector */
    public ICurveI rot(IVecI axis, IVecI destDir);
    /** rotate to destination point location */    
    public ICurveI rot(IVecI center, IVecI axis, IVecI destPt);
    
    
    /** alias of mul */
    public ICurveI scale(IDoubleI f);
    public ICurveI scale(double f);
    public ICurveI scale(IVecI center, IDoubleI f);
    public ICurveI scale(IVecI center, double f);
    
    /** scale only in 1 direction */
    public ICurveI scale1d(IVecI axis, double f);
    public ICurveI scale1d(IVecI axis, IDoubleI f);
    public ICurveI scale1d(IVecI center, IVecI axis, double f);
    public ICurveI scale1d(IVecI center, IVecI axis, IDoubleI f);
    
    /** reflect(mirror) 3 dimensionally to the other side of the plane */
    public ICurveI ref(IVecI planeDir);
    public ICurveI ref(IVecI center, IVecI planeDir);
    /** mirror is alias of ref */
    public ICurveI mirror(IVecI planeDir);
    public ICurveI mirror(IVecI center, IVecI planeDir);
    
    
    /** shear operation */
    public ICurveI shear(double sxy, double syx, double syz,
			 double szy, double szx, double sxz);
    public ICurveI shear(IDoubleI sxy, IDoubleI syx, IDoubleI syz,
			 IDoubleI szy, IDoubleI szx, IDoubleI sxz);
    public ICurveI shear(IVecI center, double sxy, double syx, double syz,
			 double szy, double szx, double sxz);
    public ICurveI shear(IVecI center, IDoubleI sxy, IDoubleI syx, IDoubleI syz,
			 IDoubleI szy, IDoubleI szx, IDoubleI sxz);
    
    public ICurveI shearXY(double sxy, double syx);
    public ICurveI shearXY(IDoubleI sxy, IDoubleI syx);
    public ICurveI shearXY(IVecI center, double sxy, double syx);
    public ICurveI shearXY(IVecI center, IDoubleI sxy, IDoubleI syx);
    
    public ICurveI shearYZ(double syz, double szy);
    public ICurveI shearYZ(IDoubleI syz, IDoubleI szy);
    public ICurveI shearYZ(IVecI center, double syz, double szy);
    public ICurveI shearYZ(IVecI center, IDoubleI syz, IDoubleI szy);
    
    public ICurveI shearZX(double szx, double sxz);
    public ICurveI shearZX(IDoubleI szx, IDoubleI sxz);
    public ICurveI shearZX(IVecI center, double szx, double sxz);
    public ICurveI shearZX(IVecI center, IDoubleI szx, IDoubleI sxz);
    
    /** translate is alias of add() */
    public ICurveI translate(double x, double y, double z);
    public ICurveI translate(IDoubleI x, IDoubleI y, IDoubleI z);
    public ICurveI translate(IVecI v);
        
    public ICurveI transform(IMatrix3I mat);
    public ICurveI transform(IMatrix4I mat);
    public ICurveI transform(IVecI xvec, IVecI yvec, IVecI zvec);
    public ICurveI transform(IVecI xvec, IVecI yvec, IVecI zvec, IVecI translate);
    
    
}
