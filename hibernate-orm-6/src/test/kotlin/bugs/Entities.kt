package bugs

import jakarta.persistence.*
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Entity1(
    @get:Column open var constructorValue: String
) {
    @get:Column
    open lateinit var lateinitValue: String

    @get:Id var id = UUID.randomUUID()
}

@Entity
class Entity2(
    override var constructorValue: String
) : Entity1(constructorValue) {
}