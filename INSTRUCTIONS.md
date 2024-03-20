# Solution

### Tech Stack
| Technology        | Version        |
|-------------------|----------------|
| **Kotlin**        | 1.9.23 2024-03 |
| **Quarkus**       | 3.8.2          |
| **Postgres**      | 14.6.0         |
| **Jupiter JUnit** | 5.10.2         |
| **Mockito**       | 5.11.0         |
| **Zookeeper**     | 3.9.2          |
| **Kafka**         | 3.7.0          |
| **Kafka UI**      | latest         |

### Approach

I'm not a Kotlin developer, so I chose to try to make things as simple as possible.

We have a class called `Workload` which represents an abstraction to save relevant data for consumed messages so that it is simple to consult the most important data (in my opinion).  
The following attributes of this class:

- `id`
- `name`
- `kind`
- `timestamp`
- `namespace`
- `replicas`
- `revision`
- `configuration`

### Configuring the Environment to run the Application 

You can find a `docker-compose.yml` file in the project root that was changed (according to the rules) for this solution to work.  
Run the following command:
```bash
docker-compose up -d
```
This will cause all necessary docker images to be downloaded and containers to be created with these images.  
You should see this:
```shell
CONTAINER ID   IMAGE                           COMMAND                  CREATED        STATUS        PORTS                                                  NAMES
cd3b7a449555   bitnami/zookeeper:3.9.2         "/opt/bitnami/script…"   11 hours ago   Up 11 hours   2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp, 8080/tcp   zookeeper
6858cc98fe9f   provectuslabs/kafka-ui:latest   "/bin/sh -c 'java --…"   11 hours ago   Up 11 hours   0.0.0.0:8080->8080/tcp                                 kafka-ui
a3baebc2653d   bitnami/kafka:3.7.0             "/opt/bitnami/script…"   11 hours ago   Up 11 hours   0.0.0.0:9092->9092/tcp, 0.0.0.0:29092->29092/tcp       kafka
0e62a99dfa35   bitnami/postgresql:14.6.0       "/opt/bitnami/script…"   11 hours ago   Up 11 hours   0.0.0.0:5432->5432/tcp                                 postgres
```
Once this is done we can feed our Kafka topic named **k8s-resources**.  

To do this, there is a file in the root of the project called `setup.sh` that contains the command to feed the Kafka topic adapted for this solution  
Run the following command:
```bash
./setup.sh
```
Once done, you can access the Kafka UI to see a preview of the Kafka broker, as well as the topic and consumer:  
```bash 
http://localhost:8080
```

### Great! We are ready to run our application 💪

**IDE (IntelliJ):**
- Importing the project as a Gradle project on your IDE.
- Build the project using Java 17/ Kotlinm1.9.23
- Run/Debug project from Main Application Class :: `io.kerno.challenge.consumer.WorkloadConsumer.kt`

**Terminal:**
```bash 
./gradlew quarkusDev
```
This will start the application and the consumer will consume via streaming the messages that are in the previously defined Kafka topic and will insert the data into a table called `workload` in the postgreSQL database.

### Running the tests
**Terminal:**
```bash 
./gradlew test
```

### Accessing Database:
```sql
jdbc:postgresql://localhost:5432/postgres
user: postgres
pass: C7SQKr@g6SwtXNi
```