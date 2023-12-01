// Абстрактный класс Animal с методом makeSound().
abstract class Animal {
    abstract fun makeSound()
}

// Подкласс Tiger, реализующий метод makeSound().
class Tiger : Animal() {
    override fun makeSound() {
        println("Tiger roars.")
    }
}

// Подкласс Lion, реализующий метод makeSound().
class Lion : Animal() {
    override fun makeSound() {
        println("Lion roars.")
    }
}

// Фабричный класс AnimalFactory с методом createAnimal().
class AnimalFactory {
    fun createAnimal(type: String): Animal? {
        return when (type.toLowerCase()) {
            "tiger" -> Tiger()
            "lion" -> Lion()
            else -> null
        }
    }
}

fun main() {
    val animalFactory = AnimalFactory()

    // Предложение пользователю ввести тип животного.
    println("Enter the type of animal (Tiger or Lion):")
    val userInput = readLine()

    // Используем фабричный класс для создания объекта животного на основе ввода пользователя.
    val animal = animalFactory.createAnimal(userInput.orEmpty())

    // Проверяем, создан ли объект, и вызываем метод makeSound().
    if (animal != null) {
        animal.makeSound()
    } else {
        println("Invalid animal type.")
    }
}