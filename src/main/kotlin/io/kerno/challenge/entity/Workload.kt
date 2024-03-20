package io.kerno.challenge.entity

import io.kerno.challenge.entity.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

/**
 * A workload is a collection of one or more Pods that run a user-defined workload.
 *
 * @property name the name of the workload
 * @property kind the type of workload (e.g. Deployment, StatefulSet, etc.)
 * @property timestamp the time the workload was created
 * @property namespace the Kubernetes namespace the workload is running in
 * @property replicas the number of replicas the workload should have
 * @property revision the revision of the workload
 * @property configuration the Kubernetes configuration for the workload, represented as a YAML string
 *
 * @author Samuel Catalano
 * @since 1.0
 */
@Entity
@Table(name = "workload")
class Workload(

  @Column(name = "name")
  var name: String? = null,

  @Column(name = "kind")
  var kind: String? = null,

  @Column(name = "creation_timestamp")
  var timestamp: Date? = null,

  @Column(name = "namespace")
  var namespace: String? = null,

  @Column(name = "replicas")
  var replicas: Int? = null,

  @Column(name = "revision")
  var revision: String? = null,

  @Column(name = "kubernetes_configuration", columnDefinition = "TEXT")
  var configuration: String? = null
) : BaseEntity()
