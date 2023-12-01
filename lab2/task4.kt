// Базовый класс Component с абстрактной функцией display.
abstract class Component(val name: String) {
    abstract fun display()
}

// Составной компонент CompositeComponent.
class CompositeComponent(name: String) : Component(name) {
    private val components = mutableListOf<Component>()

    // Методы для добавления и удаления компонентов.
    fun add(component: Component) {
        components.add(component)
    }

    fun remove(component: Component) {
        components.remove(component)
    }

    // Переопределение функции display для отображения имени и рекурсивного вызова display на дочерних компонентах.
    override fun display() {
        println("Composite Component: $name")
        for (component in components) {
            component.display()
        }
    }
}

// Ветвистый компонент BranchComponent.
class BranchComponent(name: String) : Component(name) {
    // Переопределение функции display для отображения имени ветвистого компонента.
    override fun display() {
        println("Branch Component: $name")
    }
}

fun main() {
    // Создание экземпляров CompositeComponent и BranchComponent.
    val headOffice = CompositeComponent("Head Office")
    val region1 = CompositeComponent("Region 1")
    val region2 = CompositeComponent("Region 2")
    val branch1 = BranchComponent("Branch 1")
    val branch2 = BranchComponent("Branch 2")
    val branch3 = BranchComponent("Branch 3")

    // Добавление ветвистых компонентов в региональные компоненты.
    region1.add(branch1)
    region1.add(branch2)
    region2.add(branch3)

    // Добавление региональных компонентов в головной офис.
    headOffice.add(region1)
    headOffice.add(region2)

    // Вызов функции display на головном офисе для рекурсивного отображения всей иерархии.
    headOffice.display()
}
