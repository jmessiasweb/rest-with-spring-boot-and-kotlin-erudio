package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger.getLogger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")
       return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
    }

    fun create(person: Person): Person {
        logger.info("Creating one with name ${person.firtName}!")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one with ID ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firtName = person.firtName
        entity.lastName = person.lastName
        entity.addres = person.addres
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun delete(id: Long){
        logger.info("Deleting one with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records foud for this ID") }

        repository.delete(entity)
    }

}