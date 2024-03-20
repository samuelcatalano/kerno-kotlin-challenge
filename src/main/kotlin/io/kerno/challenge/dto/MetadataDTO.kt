package io.kerno.challenge.dto

import java.util.*

/**
 * A data transfer object (DTO) containing metadata information.
 * This class typically conveys basic details about a resource, such as its name,
 * namespace, and creation timestamp. It's often used for identification and
 * tracking purposes.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
class MetadataDTO() {

  var name: String? = null
  var namespace: String? = null
  var creationTimestamp: Date? = null
  var annotations: AnnotationDTO? = null
}
