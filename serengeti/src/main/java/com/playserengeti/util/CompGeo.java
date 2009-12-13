package com.playserengeti.util;

import java.util.ArrayList;
import java.util.List;

public class CompGeo {

	/**
	 * The bound to determine how far away locations can be and remain in a
	 * cluster.
	 */
	private double bound = .03;

	/**
	 * Returns a List of Lists containing the convex hull of each cluster in the
	 * given List of points.
	 * 
	 * @param points
	 * @return
	 */
	public List<List<Double[]>> getRegions(List<Double[]> points) {
		List<List<Double[]>> result = cluster(points);
		for (int i = 0; i < result.size(); i++) {
			result.set(i, findConvexHull(result.get(i)));
		}
		return result;
	}

	/**
	 * A variation of the QT clustering algorithm. Separates the List of points
	 * into clusters based on the "bound" property.
	 * 
	 * @param points
	 * @return
	 */
	public List<List<Double[]>> cluster(List<Double[]> points) {
		List<List<Double[]>> result = new ArrayList<List<Double[]>>();
		if (points.size() <= 1) {
			result.add(points);
			return result;
		}
		List<Double[]> cluster = new ArrayList<Double[]>();
		cluster.add(points.get(0));
		points.remove(0);
		for (int i = 0; i < cluster.size(); i++) {
			for (int j = 0; j < points.size(); j++) {
				if (distanceFromPoints(cluster.get(i), points.get(j)) < bound) {
					cluster.add(points.get(j));
					points.remove(points.get(j));
					j--;
				}
			}
		}

		if (cluster.size() > 2)
			result.add(cluster);
		points.remove(cluster);
		if (points.size() != 0)
			result.addAll(cluster(points));
		return result;
	}

	/**
	 * An implementation of the Graham scan algorithm for computing the convex
	 * hull of a set of points.
	 * 
	 * @param points
	 * @return
	 */
	public List<Double[]> findConvexHull(List<Double[]> points) {
		if (points.size() < 3) {
			return points;
		}
		List<Double[]> hull = new ArrayList<Double[]>();
		Double[] bottom = getBottom(points);
		hull.add(bottom);
		points.remove(bottom);
		points = sort(points, bottom);
		hull.add(points.get(0));
		int i = 1;
		int size;
		while (i < points.size()) {
			size = hull.size();
			if (onLeft(hull.get(size - 2), hull.get(size - 1), points.get(i))) {
				hull.add(points.get(i));
				i++;
			} else {
				hull.remove(size - 1);
			}
		}

		return hull;
	}

	/**
	 * Returns whether or not the point c is on the left of the line from point
	 * a to b.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public boolean onLeft(Double[] a, Double[] b, Double[] c) {
		return ((b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1])) > 0;
	}

	/**
	 * Sorts the given List of points based on the polar angle formed by the x
	 * axis and the line from the given center to that point.
	 * 
	 * @param points
	 * @param center
	 * @return
	 */
	public List<Double[]> sort(List<Double[]> points, Double[] center) {
		Double[] temp;
		for (int i = 0; i < points.size(); i++) {
			for (int j = 0; j < points.size() - 1; j++) {
				if (!onLeft(center, points.get(j), points.get(j + 1))) {
					temp = points.get(j + 1);
					points.set(j + 1, points.get(j));
					points.set(j, temp);
				}
			}
		}

		return points;
	}

	/**
	 * Returns the bottom point in the given List of points. If two points have
	 * the same y value, it returns the right-most point.
	 * 
	 * @param points
	 * @return
	 */
	public Double[] getBottom(List<Double[]> points) {
		Double[] candidate = points.get(0);
		for (Double[] point : points) {
			if (point[1] <= candidate[1]) {
				if (point[1] == candidate[1]) {
					if (point[0] < candidate[0])
						;
				} else {
					candidate = point;
				}
			}
		}
		return candidate;
	}

	/**
	 * Returns the distance from point a to b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Double distanceFromPoints(Double[] a, Double[] b) {
		return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
	}
}
