package bugs

import javax.persistence.*
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Entity1(
    @Column open var constructorValue: String
) {
    @Column
    open lateinit var lateinitValue: String

    @Id var id = UUID.fromString("9bf28848-617a-40fa-ba35-375954edb964")
}

@Entity
class Entity2(
    override var constructorValue: String
) : Entity1(constructorValue) {
}