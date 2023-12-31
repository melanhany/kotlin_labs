# Kotlin ООП - 2

## Задача 1.

    Напишите объектно-ориентированную программу на Kotlin, которая реализует
    паттерн декоратора, создавая базовый класс Component и классы декораторов
    BoldDecorator и ItalicDecorator для изменения поведения компонента.
    Объяснение:
    В приведенном упражнении:
    У нас есть интерфейс Component, который определяет общее поведение для
    всех компонентов. Класс MainComponent реализует интерфейс Component,
    возвращает некоторую строку, представляя исходный компонент.

``` kotlin
    interface Component {
        fun render(): String
        }
        class MainComponent : Component {
        override fun render(): String {
        return ""
        }
    }
```

    "TextDecorator" - это абстрактный класс, который реализует интерфейс
    Component и содержит ссылку на другой компонент, который подаётся ему в
    конструктор. Он выступает в качестве базового класса для конкретных
    декораторов, возвращая данные, в нашем случае это некоторая строка,
    родительского объекта.
    abstract class TextDecorator(private val component: Component) : Component
    "BoldDecorator" и "ItalicDecorator" - это конкретные классы декораторов,
    которые расширяют "TextDecorator". Они переопределяют метод render(),
    чтобы изменить поведение обернутого компонента. В данном случае они
    сначала получают исходную строку объекта и добавляют HTML-теги <b> и <i>
    к отображаемому тексту.
    class BoldDecorator(component: Component) : TextDecorator(component)
    В функции main() мы создаем экземпляры исходного компонента и разных
    декораторов. Декораторы изменяют поведение исходного компонента,
    вызывая render() на каждом из них.

## Задача 2

    Напишите программу на Kotlin, реализующую паттерн фабричного метода путем
    создания абстрактного класса Animal с подклассами Tiger и Lion. Используйте
    фабричный класс для создания экземпляров животных на основе ввода
    пользователя.

    Объяснение:
    В указанном упражнении:
    Сначала мы создаем абстрактный класс "Animal", который определяет общее
    поведение. У него есть абстрактный метод makeSound().
    Классы "Tiger" и "Lion" являются подклассами Animal и предоставляют
    собственные реализации метода "makeSound()".
    Класс "AnimalFactory" действует как фабричный класс. У него есть метод
    "createAnimal()", который принимает тип (ввод пользователя) и возвращает
    экземпляр соответствующего животного. В данном случае он создает
    экземпляры Tiger и Lion на основе ввода пользователя.
    В функции main() мы создаем экземпляр AnimalFactory. Мы предлагаем
    пользователю ввести тип животного, которое они хотят создать. На основе
    ввода пользователя мы используем фабричный класс для создания объекта
    животного. Затем мы вызываем метод makeSound() для созданного объекта
    животного, чтобы продемонстрировать его поведение.

## Задача 3

    Напишите программу на языке Kotlin, использующую объектно-ориентированный
    подход, в которой создается интерфейс Observable с методами subscribe и
    unsubscribe и интерфейс Observer с методом update, который обрабатывает
    Kotlin ООП - 2 3
    принятую информацию. Реализуйте этот интерфейс в классе Publisher, чтобы
    объекты могли подписываться и отписываться от событий.
    Объяснение:
    В данном упражнении у нас есть интерфейс Observable, в котором определены
    методы subscribe и unsubscribe. Эти методы позволяют объектам подписываться и
    отписываться от событий.
    Интерфейс Observer определяет метод update, который вызывается при
    возникновении события.

``` kotlin
    interface Observer {
        fun update(message: String)
    }
    interface Observable {
        fun subscribe(observer: Observer)
        fun unsubscribe(observer: Observer)
    }
```

    Класс Publisher реализует интерфейс Observable. Он хранит список наблюдателей
    и предоставляет методы subscribe и unsubscribe для их управления (добавление и
    удаление из списка). Метод publishMessage отправляет сообщение всем
    подписанным наблюдателям. Он вызывает метод update у каждого наблюдателя.
    Создать классы EmailNotification и SMSNotification реализуют интерфейс Observer
    и определяют свое собственное поведение в методе update.
    В функции "main()" мы создаем экземпляр класса Publisher. Мы также создаем
    экземпляры классов EmailNotification и SMSNotification.
    Затем мы подписываем объекты emailNotification и smsNotification на издателя,
    вызывая метод subscribe. После этого мы публикуем сообщение, используя метод
    publishMessage издателя.
    Затем мы отписываем объект emailNotification от издателя, вызывая метод
    unsubscribe. Наконец, мы публикуем еще одно сообщение, используя метод
    publishMessage.

## Задача 4

    Напишите объектно-ориентированную программу на языке Kotlin, которая
    реализует паттерн "компоновщик" (composite pattern), создавая базовый класс
    Component и составные классы CompositeComponent и BranchComponent для
    представления иерархической структуры.

    Объяснение:
    В предложенном упражнении:
    Класс "Component" является абстрактным классом со свойством name и
    абстрактной функцией display. Он служит базовым компонентом как для
    основных, так и для составных компонентов.
    Класс "CompositeComponent" расширяет класс Component и представляет
    составной компонент. Он имеет список дочерних компонентов (components) и
    предоставляет методы для добавления и удаления компонентов. Функция
    display переопределяется для отображения имени составного компонента и
    рекурсивного вызова функции display на его дочерних компонентах.

``` kotlin
    class CompositeComponent(name: String) : Component(name) {
        private val components //list
        fun add(...)
        fun remove(...)
        override fun display() //перебов компонентов и вызов display
    }
```

    Класс "BranchComponent" также расширяет класс Component и представляет
    ветвь компонента. Он переопределяет функцию display для отображения
    имени ветвистого компонента.
    В функции "main()" мы создаем экземпляры CompositeComponent (например,
    headOffice, region1, region2) и BranchComponent (например, branch1, branch2,
    branch3), чтобы представить иерархическую структуру. Мы добавляем
    ветвистые компоненты в региональные компоненты, а региональные
    компоненты в компонент головного офиса.

    Наконец, мы вызываем функцию "display()" на экземпляре headOffice, что
    вызывает рекурсивное отображение всей иерархической структуры, начиная с
    головного офиса
