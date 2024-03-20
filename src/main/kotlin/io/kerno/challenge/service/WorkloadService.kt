package io.kerno.challenge.service

import io.kerno.challenge.dto.WorkloadDTO
import io.kerno.challenge.entity.Workload
import io.kerno.challenge.exception.ServiceException
import io.kerno.challenge.repository.WorkloadRepository
import io.kerno.challenge.service.base.BaseService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.persistence.PersistenceException
import org.slf4j.LoggerFactory

/**
 * Service class responsible for managing Workload entities.
 * This class extends the `BaseService` class and provides methods for creating Workloads.
 *
 * @see Workload
 * @see WorkloadDTO
 * @see BaseService
 *
 * @author Samuel Catalano
 * @since 1.0
 */
private val log = LoggerFactory.getLogger(WorkloadService::class.java)

@ApplicationScoped
class WorkloadService(private val repository: WorkloadRepository) : BaseService<Workload, WorkloadDTO> {

  /**
   * Creates a new Workload instance based on the provided DTO and persists it in the repository.
   *
   * @param dto the DTO containing the necessary information to create a new Workload
   * @return the newly created and persisted Workload instance
   * @throws ServiceException if there is an error creating or persisting the Workload
   */
  override fun create(dto: WorkloadDTO): Workload {
    try {
      val workload = createWorkloadFromDto(dto)
      repository.persist(workload)
      return workload
    } catch (e: PersistenceException) {
      log.error("Error persisting Workload: ${e.message}", e)
      throw ServiceException("Error persisting Workload: ", e)
    } catch (e: IllegalArgumentException) {
      log.error("Error creating Workload: ${e.message}", e)
      throw ServiceException("Error creating Workload: ", e)
    }
  }

  /**
   * Creates a new Workload instance based on the provided DTO.
   * If any of the required fields are missing, default values will be used.
   *
   * @param dto the DTO containing the necessary information to create a new Workload
   * @return the newly created Workload instance
   */
  private fun createWorkloadFromDto(dto: WorkloadDTO): Workload {
    requireNotNull(dto.metadata) { "Metadata cannot be null" }

    val kind = dto.kind ?: ""
    val name = dto.metadata!!.name
    val namespace = dto.metadata!!.namespace
    val timestamp = dto.metadata!!.creationTimestamp
    val revision = dto.metadata!!.annotations?.revision ?: ""
    val configuration = dto.metadata!!.annotations?.configuration ?: ""
    val replicas = dto.status?.replicas ?: 0

    return Workload(name, kind, timestamp, namespace, replicas, revision, configuration)
  }
}
