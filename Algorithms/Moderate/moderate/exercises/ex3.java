package moderate.exercises;

/**
 * Intersection
 * 
 * Given two straight line segments (represented as a start point and end
 * point), compute the point of intersection if any.
 * 
 * APPROACH: There are different aspect we should care about in this problem.
 * First off, can we assume in each point, that x1 will be above x2 ( that is,
 * x1 is the closest point to origin)? Also we need some mathematical (mainly)
 * equations for geometry (stoopid).
 * So once, we set the formulas we need, the strategy would be the next:
 * 
 * 1. Check if they are parallel. That means, if they have the same slope.
 * 
 * 2. Assuming they are infinite get the point of intersection. (Once we 
 * checked they are not parallel and assuming they are infinite they MUST 
 * have a point of intersection).
 * 
 * 3. Check if the point we just compute, belongs to both lines.
 * 
 * @author luisa
 */
public class ex3 {

	/**
	 * Represents a point with its respective coordinates x, y
	 * 
	 * */
	public static class Point{
		final double x;
		final double y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	/**
	 * Represents a straight line given two points that defines it.
	 * The parametric equations that describes the line are:
	 * 		Ax1 + b = y1
	 * 		Ax2 + b = y2
	 * 
	 * Where A is the slope relative to the line and b is the point where 
	 * intersect with the Y axis.
	 * 
	 * */
	public static class Line{
		private double slope; // A
		private double y_intersection; //b
		private Point p1;
		private Point p2;
		
		public Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
			this.slope = (p2.y - p1.y)/(p2.x - p1.x);
			this.y_intersection = p2.y - slope *p2.x;
		}
		
		public double getSlope() {
			return this.slope;
		}
		
		public double getYIntersection() {
			return this.y_intersection;
		}
		
		/**
		 * Returns true if the line is parallel with another one.
		 * Two lines are parallel if their slopes are the same
		 * @param Line
		 * @return boolean
		 * */
		public boolean areParallel(Line line) {
			return this.slope == line.getSlope();
		}
		
		/**
		 * Returns the point of intersection of two lines assuming
		 * they are infinite.
		 * @param Line
		 * @return int
		 * */
		public Point pointOfIntersection(Line line) {
			double y = this.slope + this.y_intersection;
			double x = ( y - line.getYIntersection() )/ line.getSlope();
			
			return new Point(x, y);
		}
		
		/**
		 * Returns true if the point belongs in the parameter
		 * belongs to the line. False otherwise
		 * @param Point
		 * @return boolean
		 * */
		public boolean belongsPoint( Point point ) {
			if ((point.x < this.p1.x && point.x > this.p2.x) &&
					point.y < this.p1.y && point.y > this.p2.y)
				return true;
			
			return false;
		}
	}
	
	public static Point pointOfIntersection(Point AStart, Point AEnd, Point BStart, Point BEnd) {
		Line lineA = new Line(AStart, AEnd);
		Line lineB = new Line(BStart, BEnd);
		
		// Check if they are parallel
		if(lineA.areParallel(lineB)) {
			System.out.print("No point of Intersection: The lines are parallel");
			return null;
		}
		
		// Get the point of Intersection assuming they are parallel
		Point pInter = lineA.pointOfIntersection(lineB);
		if(lineA.belongsPoint(pInter) && lineB.belongsPoint(pInter))
			return pInter;
		
		System.out.print("No point of Intersection: Lines are too far from each other");
		return null;
		
	}	
	
	public static void main(String[] args) {
		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(10, 10);
		Point p3 = new Point(2, 8);
		Point p4 = new Point(0, 5);
		
		Point poi = pointOfIntersection(p1, p2, p3, p4);
		
		if(poi != null)
			System.out.print(poi);
	}

}
