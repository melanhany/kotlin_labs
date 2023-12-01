// Интерфейс Component определяет общее поведение для всех компонентов.
interface Component {
    fun render(): String
}

// Класс MainComponent реализует интерфейс Component и представляет исходный компонент.
class MainComponent : Component {
    override fun render(): String {
        return "This is the main component."
    }
}

// Абстрактный класс TextDecorator реализует интерфейс Component и содержит ссылку на другой компонент.
// Он выступает в качестве базового класса для конкретных декораторов.
abstract class TextDecorator(private val component: Component) : Component {
    override fun render(): String {
        return component.render()
    }
}

// Класс BoldDecorator является конкретным декоратором и добавляет HTML-теги <b>.
class BoldDecorator(component: Component) : TextDecorator(component) {
    override fun render(): String {
        val baseRender = super.render()
        return "<b>$baseRender</b>"
    }
}

// Класс ItalicDecorator является конкретным декоратором и добавляет HTML-теги <i>.
class ItalicDecorator(component: Component) : TextDecorator(component) {
    override fun render(): String {
        val baseRender = super.render()
        return "<i>$baseRender</i>"
    }
}

fun main() {
    // Создаем исходный компонент
    val mainComponent: Component = MainComponent()

    // Создаем декораторы и оборачиваем исходный компонент
    val boldDecorator: Component = BoldDecorator(mainComponent)
    val italicDecorator: Component = ItalicDecorator(mainComponent)
    val boldItalicDecorator: Component = BoldDecorator(ItalicDecorator(mainComponent))

    // Вызываем render() для каждого декоратора
    println("Main Component: ${mainComponent.render()}")
    println("Bold Decorator: ${boldDecorator.render()}")
    println("Italic Decorator: ${italicDecorator.render()}")
    println("Bold Italic Decorator: ${boldItalicDecorator.render()}")
}