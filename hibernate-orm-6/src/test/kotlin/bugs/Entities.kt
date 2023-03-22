package bugs

import jakarta.persistence.*
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Entity1(
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column
    open var value1: String,

    @Column
    open var value2: String
)

@Entity
class Entity2(
    value1: String,
    override var value2: String,
) : Entity1(value1 = value1, value2 = value2) {
    override var value1 = value1
        get() = super.value1
}