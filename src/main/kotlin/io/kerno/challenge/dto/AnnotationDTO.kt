package io.kerno.challenge.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data Transfer Object for Kubernetes Annotations
 * @param revision The revision of the deployment
 * @param configuration The last applied configuration
 *
 * @author Samuel Catalano
 * @since 1.0
 */
class AnnotationDTO {

  @JsonProperty(value = "deployment.kubernetes.io/revision")
  var revision: String? = null

  @JsonProperty(value = "kubectl.kubernetes.io/last-applied-configuration")
  var configuration: String? = null
}
