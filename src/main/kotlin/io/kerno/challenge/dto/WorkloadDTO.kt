package io.kerno.challenge.dto

import io.kerno.challenge.dto.base.BaseDTO

/**
 * A data transfer object (DTO) representing a workload.
 *
 * This class encapsulates information about a workload, including its kind (type),
 * metadata, and status. The metadata likely provides details for identification
 * and tracking, while the status might indicate the number of replicas or
 * the workload's operational state.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
class WorkloadDTO : BaseDTO() {

  var kind: String? = null
  var metadata: MetadataDTO? = null
  var status: StatusDTO? = null
}
