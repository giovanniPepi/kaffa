package exercise4.model

import javax.persistence.*

@Entity
@Table
data class Task(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Int = -1,
	val task: String = ""
)