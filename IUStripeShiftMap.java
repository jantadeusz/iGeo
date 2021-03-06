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

package igeo;

import java.util.ArrayList;

/**
   A subclass of IMap defined by another map and parameter shift in u direction in a stripe way in v direction
   
   @author Satoru Sugihara
*/
public class IUStripeShiftMap extends IMap{
    public ArrayList<Double> domains;
    public ArrayList<Double> shiftAmounts;
    
    public IMap origMap;
    public IUStripeShiftMap(IMap originalMap){
	origMap = originalMap;
	domains = new ArrayList<Double>();
	shiftAmounts = new ArrayList<Double>();
    }
    
    public IUStripeShiftMap(IMap originalMap, double shift){
	origMap = originalMap;
	domains = new ArrayList<Double>();
	shiftAmounts = new ArrayList<Double>();
	addShift(0,shift);
	addShift(1,shift);
    }
    
    public void addShift(double domain, double shiftAmount){
	domains.add(domain);
	shiftAmounts.add(shiftAmount);
    }
    
    public double get(double u, double v){
	double ushift=getShift(v);
	if(u+ushift<0) return origMap.get(0,v);
	if(u+ushift>1) return origMap.get(1,v);
	return origMap.get(u+ushift,v);
    }
    
    public double getShift(double x){
	for(int i=0; i<domains.size()-1; i++){
	    if(i==0 && x <= domains.get(i)) return 0;
	    if(x>=domains.get(i) && x<domains.get(i+1))
		return shiftAmounts.get(i);
	    if(i==domains.size()-2 && x>=domains.get(i+1))
		return shiftAmounts.get(i+1);
	}
	return 0;
    }
    
}
