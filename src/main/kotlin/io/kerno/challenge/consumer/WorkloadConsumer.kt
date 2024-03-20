package io.kerno.challenge.consumer

import io.kerno.challenge.dto.WorkloadDTO
import io.kerno.challenge.entity.Workload
import io.kerno.challenge.exception.ServiceException
import io.kerno.challenge.service.WorkloadService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Message
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletionException
import java.util.concurrent.CompletionStage

/**
 * The `WorkloadConsumer` class is responsible for consuming messages from a Kafka topic and processing them.
 * It uses the [WorkloadService] to create a new [WorkloadDTO] instance based on the received message.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
private val log = LoggerFactory.getLogger(WorkloadConsumer::class.java)

@ApplicationScoped
class WorkloadConsumer(private val service: WorkloadService) {

  /**
   * Consumes messages from the Kafka topic and processes them.
   *
   * @param message the message received from the Kafka topic
   * @return a CompletionStage that represents the asynchronous processing of the message
   * @throws CompletionException if an error occurs while processing the message
   */
  @Incoming("kafka-consumer")
  @Transactional
  @Throws(CompletionException::class)
  fun consume(message: Message<WorkloadDTO?>): CompletionStage<Void>? {
    val messagePayload: WorkloadDTO? = message.payload

    if (messagePayload == null) {
      // There's no action required here
      log.warn("The payload is NULL in the {} class.", WorkloadDTO::class.java.getSimpleName())
      return message.ack()
    }

    try {
      val workload: Workload = service.create(dto = messagePayload)
      log.info("The workload {} has been created.", workload)
    } catch (e: ServiceException) {
      // Log error if ServiceException occurs and throw CompletionException with details
      log.error("Error creating a new Workload: {}", e.message, e)
      throw CompletionException("Error creating a new Workload: ", e)
    }

    return message.ack()
  }
}
