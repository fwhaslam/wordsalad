package com.fiends.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class RatioSet<T> {

	static class RatioRec<T> {
		int count;
		long index;
		T value;
		public RatioRec(int count,long index,T value){
			this.count = count;
			this.index = index;
			this.value = value;
		}
		public String toString(){return count+"|"+index+"|"+value;}
	}

	List<RatioRec<T>> list;
	long sum, index[];
	boolean locked;

	public RatioSet(){
		list = new ArrayList();
		sum = 0;
		locked = false;
		index = null;
	}

	public long getBound(){return sum;}
	public int size(){return list.size();}

	synchronized public void add( int count, T value) {
		if (count<=0) return;
		list.add( new RatioRec<T>(count,sum,value));
		sum += count;
	}

	synchronized public boolean isLocked(){return locked;}

	/**
	 * The class must be locked for efficiency
	 */
	synchronized public void setLocked(){
		if (locked) return;

		locked = true;
		index = new long[ list.size() ];
		for (int ix=0;ix<list.size();ix++) index[ix] = list.get(ix).index;
	}

	/**
	 * This class must be locked, or the 'getByRatio' method with throw NPE
	 * @param goal
	 * @return
	 * @throws NullPointerException if not locked
	 */
	public T getByIndex(long goal){

		if (locked==false) throw new IllegalStateException("RatioSet has not been locked!");
		if (goal<0 || goal>=index.length) return null;

		return list.get((int)goal).value;
	}

	/**
	 * This class must be locked, or the 'getByRatio' method with throw NPE
	 * @param goal
	 * @return
	 * @throws NullPointerException if not locked
	 */
	public T getByRatio(long goal){
//System.out.println("goal="+goal+"   bound="+sum);

		if (locked==false) throw new IllegalStateException("RatioSet has not been locked!");
		if (goal<0 || goal>=sum) return null;

		int lo = 0;
		int hi = index.length-1;

		while (lo <= hi) {
			int mid = (hi+lo)/2;
//System.out.println("mid="+mid+"  index[mid]="+index[mid]);
			if      (goal < index[mid]) hi = mid - 1;
			else if (goal > index[mid]) lo = mid + 1;
			else {
				hi = mid;
				break;
			}
		}
//System.out.println("index="+hi+" / "+index.length );
		return list.get(hi).value;
	}
}
