package io.kerno.challenge.dto

/**
 * A data transfer object (DTO) representing the status information.
 * This class is likely used to communicate information about the number of replicas
 * of some data or service.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
class StatusDTO() {
  var replicas: Int? = null

  constructor(replicas: Int) : this() {
    this.replicas = replicas
  }
}
