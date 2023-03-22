package bugs

import jakarta.persistence.*
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Entity1(
    @Column open var constructorValue: String
) {
    @Column
    open lateinit var lateinitValue: String

    @Id var id = UUID.randomUUID()
}

@Entity
class Entity2(
    override var constructorValue: String
) : Entity1(constructorValue) {
}