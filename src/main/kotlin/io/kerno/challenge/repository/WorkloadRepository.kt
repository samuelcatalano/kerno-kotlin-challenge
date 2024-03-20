package io.kerno.challenge.repository

import io.kerno.challenge.entity.Workload
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

/**
 * Interface for the Workload repository.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
@ApplicationScoped
class WorkloadRepository : PanacheRepository<Workload>