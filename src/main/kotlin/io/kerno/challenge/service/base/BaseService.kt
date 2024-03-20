package io.kerno.challenge.service.base

import io.kerno.challenge.dto.base.BaseDTO
import io.kerno.challenge.entity.base.BaseEntity
import io.kerno.challenge.exception.ServiceException

/**
 * A generic interface for creating and managing entities of type E, which extends BaseEntity, and their DTOs, which extend BaseDTO.
 *
 * @param <E> the type of the entity
 * @param <T> the type of the DTO
 *
 * @author Samuel Catalano
 * @since 1.0
 */
interface BaseService<E : BaseEntity?, T : BaseDTO?> {

  @Throws(ServiceException::class)
  fun create(dto: T): E
}
