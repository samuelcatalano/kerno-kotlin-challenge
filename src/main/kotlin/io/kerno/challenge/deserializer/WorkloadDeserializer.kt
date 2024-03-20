package io.kerno.challenge.deserializer

import io.kerno.challenge.dto.WorkloadDTO
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer

/**
 * A custom deserializer for the Workload class.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
class WorkloadDeserializer : ObjectMapperDeserializer<WorkloadDTO>(WorkloadDTO::class.java)