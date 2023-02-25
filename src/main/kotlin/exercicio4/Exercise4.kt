package exercicio4

import exercicio4.model.Task
import exercicio4.repository.TaskRespository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class Exercise4(private val repository: TaskRespository) {
	@GetMapping(produces = ["application/json"])
	fun getTask() : ResponseEntity<Any> {
		return ResponseEntity.ok(repository.findAll())
	}

	@PostMapping
	fun createTask(@RequestBody task: Task) : ResponseEntity<Any> {
		val newTask = repository.save(task)
		return ResponseEntity.ok(newTask.id)
	}

	@DeleteMapping("/{id}")
	fun deleteTask(@PathVariable("id") id : Int) : ResponseEntity<Any?> {
		val task = repository.findById(id)
		if(task.isEmpty){
			return ResponseEntity.notFound().build()
		}
		repository.delete(task.get())
		return ResponseEntity.noContent().build()
	}
}

@SpringBootApplication
open class TaskApp() {}

fun main(args: Array<String>) {
	runApplication<TaskApp>(*args)
}

