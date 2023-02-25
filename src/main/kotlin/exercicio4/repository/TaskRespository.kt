package exercicio4.repository

import exercicio4.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRespository : JpaRepository<Task, Int> {
}