package exercise4.controller

import exercise4.model.Task
import exercise4.repository.TaskRespository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TaskController(private val repository: TaskRespository) {
	@GetMapping(produces = ["application/json"])
	fun getTask(): ResponseEntity<Any> {
		return ResponseEntity.ok(repository.findAll())
	}

	@PostMapping
	fun createTask(@RequestBody task: Task): ResponseEntity<Any> {
		val newTask = repository.save(task)
		return ResponseEntity.ok(newTask.id)
	}

	@DeleteMapping("/{id}")
	fun deleteTask(@PathVariable("id") id: Int): ResponseEntity<Any?> {
		val task = repository.findById(id)
		if (task.isEmpty) {
			return ResponseEntity.notFound().build()
		}
		repository.delete(task.get())
		return ResponseEntity.noContent().build()
	}
}
