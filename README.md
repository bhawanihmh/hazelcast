# hazelcast 

#Introduction

The Operational In-Memory Computing Platform

Easy to work with, high-performance, resilient
The Hazelcast IMDG operational in-memory computing platform helps leading companies worldwide manage their data and distribute processing using in-memory storage and parallel execution for breakthrough application speed and scale.

Hazelcast IMDG is easy to work with and brings a highly resilient and elastic memory resource to all of your applications. At its core, Hazelcast is one of the most widely adopted open source solutions with tens of thousands of installed clusters and over 23 million server starts per month. On top of this popular open source platform, Hazelcast IMDG Enterprise HD, Hazelcast IMDG Enterprise, and Hazelcast IMDG Professional Support offer licensed features for large scale deployments. Now you can free your data from slow, expensive, and hard to scale relational databases. With Hazelcast IMDG, your database remains the system of record, but bottlenecks disappear.

# Ref https://hazelcast.com/products/

#hazelcast example

1.	Download Hazelcast IMDG 3.7.5 zip and extract
https://hazelcast.org/download/
2.	Add “hazelcast-client-3.7.5” and “hazelcast-3.7.5” and “mariadb-java-client-1.1.7” jars to “hazelcastsample” project build path
3.	Restore hazelcast sample maria db dump 
4.	Download hazelcast message center Zip  and extract
https://hazelcast.org/download/
5.	Execute startManCenter in mancenter  “hazelcast-3.7.5\mancenter”
6.	Run HazelCastNodes.java in sample project to create hazelcast node. Run as many instances as required nodes.
7.	Run HazelCastClient.java to access cached data.
8. insert employee data like:
   INSERT INTO `employee` (`id`, `name`, `role`) VALUES (1, 'Bhawani Singh', 'SPL');
