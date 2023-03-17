package com.example.kotlinjpainheritanceissue

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import org.springframework.data.repository.CrudRepository
import java.util.UUID

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

interface Entity1Repository<T: Entity1> : CrudRepository<T, UUID>

interface Entity2Repository: Entity1Repository<Entity2>