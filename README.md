Images for our use case :-   

```bash

docker build . -f Base.Dockerfile -t apache.org/kafka-base:3.0
docker build . -f Broker.Dockerfile -t apache.org/kafka:3.0

```

### Running in KRaft Mode (Single-Node Cluster)

This setup creates a single node cluster that runs without Zookeeper

```shell

cd compose/kraft

# Deploys a simple single-node cluster in KRaft Mode
docker-compose up

# Shuts down the containers
docker-compose down --remove-orphans
```

[Return to the Top](https://github.com/izzyacademy/kafka-in-a-box/blob/main/README.md#outline)

### Running in KRaft Mode (Multi-Node Cluster)

This deploys a multi-node cluster in KRaft mode (without Zookeeper)

- Node 1 (Controller)
  - "29091:29091" [**broker port**]
  - "19091:19091" [**controller port**]
  - "9091:9091" [**broker port**]
  - "9101:9101" [**jmx port**]

 
- Node 2 (Broker)
  - "29092:29092" [**broker port**]
  - "19092:19092" [**if node 2 is only broker, why CONTROLLER://0.0.0.0:19092 is part of KAFKA_LISTENERS and why it is exposed from container**]
  - "9092:9092" [**broker port**]
  - "9102:9102"  [**jmx port**]

 
- Node 3 (Controller, Broker)
  - "29093:29093" [**broker port**]
  - "19093:19093" [**controller port**]
  - "9093:9093" [**broker port**]
  - "9103:9103" [**jmx port**]


- Node 4 (Controller, Broker)
  - "29094:29094" [**broker port**]
  - "19094:19094" [**controller port**]
  - "9094:9094" [**broker port**]
  - "9104:9104" [**jmx port**]

This provides 3 controller nodes and 3 broker nodes (6-nodes altogether)

Which ends up looking like this when you expand it:

- Node 1 (Controller)
- Node 2 (Broker)
- Node 3 (Controller)
- Node 3 (Broker)
- Node 4 (Controller)
- Node 4 (Broker)

It also has a debugger docker container that you can log in to explore the cluster

Running the following commands allow you to boot up the cluster

```shell

cd compose/kraft

# Deploys a multi-node cluster in KRaft Mode
docker-compose --env-file ./environment-variables.sh -f multi-node-docker-compose.yml up

# Shuts down the containers
docker-compose --env-file ./environment-variables.sh -f multi-node-docker-compose.yml down --remove-orphans

```