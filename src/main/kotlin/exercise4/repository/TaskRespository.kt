package exercise4.repository

import exercise4.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRespository : JpaRepository<Task, Int> {
}