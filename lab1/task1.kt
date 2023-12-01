abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

class Triangle(val side1: Double, val side2: Double, val side3: Double) : Shape() {
    override fun area(): Double {
        val s = perimeter() / 2
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3))
    }

    override fun perimeter(): Double {
        return side1 + side2 + side3
    }
}

fun main() {
    val shapes =
            listOf(
                    Circle(radius = 5.0),
                    Rectangle(width = 4.0, height = 6.0),
                    Triangle(side1 = 3.0, side2 = 4.0, side3 = 5.0)
            )

    for (shape in shapes) {
        println("Shape: ${shape::class.simpleName}")
        println("Area: ${shape.area()}")
        println("Perimeter: ${shape.perimeter()}")
        println("---------------")
    }
}
