package io.kerno.challenge.entity.base

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

/**
 * Base entity class for persistence.
 * This class is intended to be extended by other entity classes
 * and provides common attributes and functionality for persistence.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
@MappedSuperclass
abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  open var id: Long? = null
}
