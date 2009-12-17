package com.playserengeti.util;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;


public class CompGeoTest extends TestCase {

	CompGeo tester = new CompGeo();
	Double[] a;
	Double[] b;
	Double[] c;
	Double[] d;
	Double[] e;
	Double[] f;
	Double[] g;
	Double[] h;
	Double[] i;
	Double[] j;
	Double[] k;
	Double[] l;
	Double[] m;
	Double[] n;
	//Set1
	List<Double[]> points1;
	//Sorted set1 around b
	List<Double[]> points2;
	//Convex hull of set1
	List<Double[]> points3;
	//Set1 minus the bottom point
	List<Double[]> points4;	
	//Set2
	List<Double[]> points5;
	//Convex hull of set2
	List<Double[]> points6;
	//Set3
	List<Double[]> points7;
	//Clustered set3
	List<List<Double[]>> points8;
	//Convex hulls of set3
	List<List<Double[]>> points9;
	
	@BeforeClass
	public void setUp() {
		tester.setBound(4.0);
		a = new Double[]{6.0, 7.0};
		b = new Double[]{5.0, 3.0};
		c = new Double[]{4.0, 8.0};
		d = new Double[]{3.0, 5.0};
		e = new Double[]{2.0, 8.0};
		f = new Double[]{7.0, 10.0};
		g = new Double[]{9.0, 6.0};
		h = new Double[]{11.0, 9.0};
		i = new Double[]{17.0, 17.0};
		j = new Double[]{17.0, 14.0};
		k = new Double[]{19.0, 16.0};
		l = new Double[]{16.0, 18.0};
		m = new Double[]{19.0, 18.0};
		n = new Double[]{30.0, 30.0};
		//Set1 {a,b,c,d,e,f,g,h}
		points1 = new ArrayList<Double[]>();
		points1.add(a);
		points1.add(b);
		points1.add(c);
		points1.add(d);
		points1.add(e);
		points1.add(f);
		points1.add(g);
		points1.add(h);
		//Sorted set1 around b {g,h,f,a,c,e,d}
		points2 = new ArrayList<Double[]>();
		points2.add(g);
		points2.add(h);
		points2.add(f);
		points2.add(a);
		points2.add(c);
		points2.add(e);
		points2.add(d);
		//Convex hull of set1 {b,g,h,f,e,d}
		points3 = new ArrayList<Double[]>();
		points3.add(b);
		points3.add(g);
		points3.add(h);
		points3.add(f);
		points3.add(e);
		points3.add(d);
		//Set1 minus the bottom point {a,c,d,e,f,g,h}
		points4 = new ArrayList<Double[]>();
		points4.add(a);
		points4.add(c);
		points4.add(d);
		points4.add(e);
		points4.add(f);
		points4.add(g);
		points4.add(h);
		//Set2 {i,j,k,l,m}
		points5 = new ArrayList<Double[]>();
		points5.add(i);
		points5.add(j);
		points5.add(k);
		points5.add(l);
		points5.add(m);
		//Convex hull of set2 {j,k,m,l}
		points6 = new ArrayList<Double[]>();
		points6.add(j);
		points6.add(k);
		points6.add(m);
		points6.add(l);
		//Set3 {a,b,c,d,e,f,g,h,i,j,k,l,m,n}
		points7 = new ArrayList<Double[]>();
		points7.addAll(points1);
		points7.addAll(points5);
		points7.add(n);
		//Clustered set3 {{a,b,c,d,e,f,g,h},{i,j,k,l,m},{n}}
		points8 = new ArrayList<List<Double[]>>();
		points8.add(points1);
		points8.add(points5);
		List<Double[]> temp = new ArrayList<Double[]>();
		temp.add(n);
		points8.add(temp);
		//Convex hulls of set3
		points9 = new ArrayList<List<Double[]>>();
		points9.add(points3);
		points9.add(points6);
		points9.add(temp);
	}
	
	@Test
	public void testGetBottom() {
		assertEquals(tester.getBottom(points1), b);
	}
	
	@Test
	public void testSort() {
		assertEquals(tester.sort(points4, b), points2);
	}
	
	@Test
	public void testOnLeft() {
		assertTrue(tester.onLeft(b, g, a));
		assertFalse(tester.onLeft(b, d, a));
		assertFalse(tester.onLeft(g, f, h));
		assertTrue(tester.onLeft(a, f, c));
		assertFalse(tester.onLeft(f, a, c));
		assertFalse(tester.onLeft(f, c, e));
	}
	
	@Test
	public void testConvexHull() {
		assertEquals(tester.findConvexHull(points1), points3);
		assertEquals(tester.findConvexHull(points5), points6);
	}
	
	@Test
	public void testCluster() {
		boolean equal = true;
		List<List<Double[]>> result = tester.cluster(points7);
		if (result.size() == points8.size()) {
			for (int i = 0; i < result.size(); i ++) {
		    	if (!result.get(i).containsAll(points8.get(i)) 
		    			|| result.get(i).size() != points8.get(i).size()) equal = false;
    		}
		}
		else {
			equal = false;
		}
		assertTrue(equal);
	}
	
	@Test
	public void testGetRegions() {
		assertEquals(tester.getRegions(points7), points9);
	}
}
