plugins {
  kotlin("jvm") version "1.9.22"
  kotlin("plugin.allopen") version "1.9.22"
  id("io.quarkus")
}

repositories {
  mavenCentral()
  mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
  implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
  implementation("io.quarkus:quarkus-config-yaml")
  implementation("io.quarkus:quarkus-rest-client-reactive")
  implementation("io.quarkus:quarkus-hibernate-orm-panache-kotlin")
  implementation("io.quarkus:quarkus-resteasy-reactive")
  implementation("io.quarkus:quarkus-smallrye-reactive-messaging-kafka")
  implementation("io.quarkus:quarkus-kotlin")
  implementation("io.quarkus:quarkus-jdbc-postgresql")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("io.quarkus:quarkus-arc")
  implementation("io.quarkus:quarkus-hibernate-orm")
  testImplementation("io.quarkus:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")
  testImplementation("io.quarkus:quarkus-junit5-mockito")
}

group = "io.kerno.challenge"
version = "1.0-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
  systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
  annotation("jakarta.ws.rs.Path")
  annotation("jakarta.enterprise.context.ApplicationScoped")
  annotation("jakarta.persistence.Entity")
  annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
  kotlinOptions.javaParameters = true
}
