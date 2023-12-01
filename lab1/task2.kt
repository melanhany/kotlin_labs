class Logger private constructor() {
    init {
        // Инициализация логгера
    }

    fun log(message: String) {
        // Реализация функциональности логирования
        println("Logging: $message")
    }

    companion object {
        // Ссылка на объект Logger
        @Volatile
        private var instance: Logger? = null

        // Метод для получения единственного экземпляра класса Logger
        fun getInstance(): Logger {
            if (instance == null) {
                // Двойная проверка блокировки для потоко-безопасности
                synchronized(this) {
                    if (instance == null) {
                        instance = Logger()
                    }
                }
            }
            return instance!!
        }
    }
}

fun main() {
    // Использование паттерна Singleton
    val logger1 = Logger.getInstance()
    val logger2 = Logger.getInstance()

    // Вызов метода log() на обоих экземплярах
    logger1.log("Message from logger1")
    logger2.log("Message from logger2")

    // Сравнение ссылок на объекты с использованием оператора ===
    println("Are logger1 and logger2 the same instance? ${logger1 === logger2}")
}