package example
def improve(guess: Double, x: Double): Double =
  (guess + x / guess) / 2

def isGoodEnough(guess: Double, x: Double): Boolean =
  abs(guess * guess - x) < 0.0001 * x

def abs(d: Double): Double =
  if d >= 0 then d else -d

def sqrtIter(guess: Double, x: Double): Double =
  if isGoodEnough(guess, x) then guess
  else sqrtIter(improve(guess, x), x)

def sqrt(x: Double) = sqrtIter(1.0, x)
@main def run(): Unit =
  println(sqrt(1.0e50))
