class Point(val x: Int, val y: Int)

trait Rectangular {
	def topLeft: Point
	def bottomRight: Point

	def left = topLeft.x
	def right = bottomRight.x
	def width = right - left
}

trait Shape {
  def desc: String
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular


var rec = Rectangle(Point(0, 0), Point(2, 2))

println(rec.width)


class RectangleShape(val topLeft: Point, val bottomRight: Point, val desc: String) extends Rectangular with Shape

var recShape = RectangleShape(Point(0, 0), Point(2, 2), "recShape")

println(recShape.width)
println(recShape.desc)