# Kerno's Kotlin Senior Backend Challenge

Howdy 👋  So... are you a legend?

We are in the lookout for passionate backend developers, mindful of architecture, data structures, performance and good engineering work — but whom always keep an eye on timely, customer-facing value delivery.

You are proficient in Kotlin (or another "core" JVM language), and have experience working with different paradigms, can identify and apply best-of-type approaches to solution, and craft code that tells a story.


**And don't be shy!**
We place great value in education and experience; but we also recognize that talent is built on passion and hours dedicated to deliberate practice and learning... so don't shy away from applying if you feel you have what it takes!


## The challenge:
A Kafka topic streams JSON objects representing Kubernetes Resources from a single cluster. You need to build an aggregation abstraction of such resources into **a single object** (let's call it workload) where we can query all the fundamental aspects of such workload, such as: id, name, replication factor, etc. (don't limit yourself to this). The **simplified abstraction** will allow your users to query information about these workloads and their state without having to become familiar with the multiple workload topologies Kubernetes offer.

Do not limit yourself to the datapoints we use as examples, we want to see your ability to think through use cases and deliver added intellectual value besides writing amazing code.
This challenge will be used as the foundation for a technical interview to discuss over your code, abstractions and technical decisions.

### Now let's code:
We are providing a docker-compose file which contains:

- A Kafka broker which has a topic `k8s-resources` with a bunch od preloaded data
- A Postgres DB
- The base for the app you are developing

The objective is to create an app which is going to consume the messages from the topic and store them into the DB following the abstraction you've defined.
It's important to consider that an App is composed by many Kubernetes' resources.


### Kubernetes data structure
The provided data is from a real Kubernetes Cluster, if you are not familiar with Kubernetes here are some tips on how data is store and linked.

1. In this set of data you have two type of workloads `Deployment` and `StatefulSet`
2. Child resources are linked to their parent by a field called `ownerReferences`
  1. The exception on this example is the `Service`, which is related by a `spec.selector` to a `Deployment` or `StatefulSet`


### Considerations
We do favor Ktor or Quarkus, but you are free to structure the projects, choose frameworks and/or libraries as you see fit to deliver on this project -- the framework itself will have very little weight in the evaluation: but how you use the features and best-practices for your framework of choice will be considered.

Also feel free to update the `docker-compose` file as you see necessary. The only condition is that it has to work with a simple `docker-compose up`.

We will be evaluating data structures, synchronization, resiliency and performance strategies.
And be mindful that this is your presentation letter! Make sure it talks highly of you!

We are a Kotlin house, however, if you are currently more comfortable with Scala, Groovy or Java, feel free to use them.



### Clone this project to get started!
Once you are happy with it, zip it and send it to `dev-challenges@kerno.io` for us to review.
