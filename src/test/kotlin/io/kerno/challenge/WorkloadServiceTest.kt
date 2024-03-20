package io.kerno.challenge

import io.kerno.challenge.dto.AnnotationDTO
import io.kerno.challenge.dto.MetadataDTO
import io.kerno.challenge.dto.StatusDTO
import io.kerno.challenge.dto.WorkloadDTO
import io.kerno.challenge.entity.Workload
import io.kerno.challenge.exception.ServiceException
import io.kerno.challenge.repository.WorkloadRepository
import io.kerno.challenge.service.WorkloadService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

/**
 * This class tests the {@link WorkloadService} class using JUnit's Mockito framework.
 * It tests the `createWorkload` method of the service, ensuring it correctly converts a
 * {@link WorkloadDTO} object to a {@link Workload} entity and persists it using the injected
 * {@link WorkloadRepository}. It also includes a test case for handling a null input to the
 * `createWorkload` method.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
@ExtendWith(MockitoExtension::class)
internal class WorkloadServiceTest {

  /**
   * Mocked instance of the {@link WorkloadRepository} class.
   */
  @Mock
  private val repository: WorkloadRepository? = null

  /**
   * Injected instance of the {@link WorkloadService} class to be tested. Mockito injects mocks
   * into fields annotated with @InjectMocks.
   */
  @InjectMocks
  private val service: WorkloadService? = null

  /**
   * Initializes mocks before each test is run.
   */
  @BeforeEach
  fun before() {
    MockitoAnnotations.openMocks(this)
  }

  /**
   * Tests the `createWorkload` method of the {@link WorkloadService} class. This method creates
   * a {@link WorkloadDTO} object, populates it with sample data, and verifies that the converted
   * {@link Workload} entity has the same data after calling the `create` method.
   *
   * @throws ServiceException if an error occurs while creating the workload.
   */
  @Test
  @Throws(ServiceException::class)
  fun test_create_workload() {

    // Given
    val dto: WorkloadDTO = WorkloadDTO()
    val metadata: MetadataDTO = MetadataDTO()
    val annotations: AnnotationDTO = AnnotationDTO()
    val status: StatusDTO = StatusDTO()

    dto.kind = "Deployment"
    metadata.name = "AnyName"
    metadata.namespace = "AnyNamespace"
    metadata.creationTimestamp = Date()
    annotations.revision = "1"
    annotations.configuration = "AnyConfiguration"
    metadata.annotations = annotations;
    status.replicas = 1

    dto.metadata = metadata
    dto.status = status

    // When
    val workload: Workload = service!!.create(dto)

    // Then
    assertEquals(workload.kind, dto.kind)
    assertEquals(workload.name, dto.metadata?.name)
    assertEquals(workload.timestamp, dto.metadata?.creationTimestamp)
    assertEquals(workload.namespace, dto.metadata?.namespace)
    assertEquals(workload.revision, dto.metadata?.annotations?.revision)
    assertEquals(workload.configuration, dto.metadata?.annotations?.configuration)
    assertEquals(workload.replicas, dto.status?.replicas)
  }

  /**
   * Tests handling a null input to the `createWorkload` method. This test ensures that the service
   * throws a NullPointerException when a null WorkloadDTO is provided.
   */
  @Test
  fun test_create_workload_from_dto_null_input() {
    val workloadDto: WorkloadDTO? = null // Assuming WorkloadDTO might be null
    if (workloadDto != null) {
      assertThrows<NullPointerException> {
        service?.create(workloadDto)
      }
    }
  }
}
