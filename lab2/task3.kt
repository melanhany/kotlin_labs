// Интерфейс Observer с методом update.
interface Observer {
    fun update(message: String)
}

// Интерфейс Observable с методами subscribe и unsubscribe.
interface Observable {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
}

// Класс Publisher реализует интерфейс Observable.
class Publisher : Observable {
    private val observers = mutableListOf<Observer>()

    // Метод для подписки на события.
    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    // Метод для отписки от событий.
    override fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    // Метод для оповещения всех подписанных наблюдателей.
    fun publishMessage(message: String) {
        for (observer in observers) {
            observer.update(message)
        }
    }
}

// Класс EmailNotification реализует интерфейс Observer.
class EmailNotification : Observer {
    override fun update(message: String) {
        println("Email Notification: $message")
    }
}

// Класс SMSNotification реализует интерфейс Observer.
class SMSNotification : Observer {
    override fun update(message: String) {
        println("SMS Notification: $message")
    }
}

fun main() {
    // Создаем издателя.
    val publisher = Publisher()

    // Создаем объекты наблюдателей.
    val emailNotification = EmailNotification()
    val smsNotification = SMSNotification()

    // Подписываем наблюдателей на издателя.
    publisher.subscribe(emailNotification)
    publisher.subscribe(smsNotification)

    // Публикуем сообщение, которое получат оба наблюдателя.
    publisher.publishMessage("New update!")

    // Отписываем emailNotification от издателя.
    publisher.unsubscribe(emailNotification)

    // Публикуем еще одно сообщение, которое получит только smsNotification.
    publisher.publishMessage("Another update!")
}