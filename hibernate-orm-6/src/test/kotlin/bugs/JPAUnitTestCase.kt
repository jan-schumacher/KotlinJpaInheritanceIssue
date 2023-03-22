package bugs

import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
class JPAUnitTestCase {
    private lateinit var entityManagerFactory: EntityManagerFactory

    @Before
    fun init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU")
    }

    @After
    fun destroy() {
        entityManagerFactory.close()
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    @Throws(Exception::class)
    fun hhh15874Test() {
        val em = entityManagerFactory.createEntityManager()
        em.transaction.begin()
        val entity2 = Entity2("value1Example", "value2Example")
        em.persist(entity2)
        em.transaction.commit()

        println("load from cache (returns the same object as persisted)")
        val result = em.find(Entity2::class.java, entity2.id)
        Assert.assertTrue(entity2 == result)
        Assert.assertEquals("value1Example", result.value1)
        Assert.assertEquals("value2Example", result.value2)

        // creating new entityManager to simulate a new context/threat
        val newEm = entityManagerFactory.createEntityManager()
        println("load from database (see logs for prove)")
        val newResult = newEm.find(Entity2::class.java, entity2.id)
        Assert.assertEquals("value1Example", newResult.value1)
        Assert.assertEquals("value2Example", newResult.value2)

        newEm.close()
        em.close()
    }
}
