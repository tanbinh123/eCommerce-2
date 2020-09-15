# eCommerce
A distributed and highly concurrent e-commerce trading platform

## Table of Contents

- [What makes this project special?](#what-makes-this-project-special)
- [Features](#features)
- [Installation](#installation)
- [Documentation](#documentation)


## What makes this project special?

This is a high concurrency e-shop platform, based on SpringBoot + MySQL + Zookeeper + Redis, which realize the basic functions of e-commerce, including goods management, order management, commodity purchase, coupon management, shopping cart management and so on.  The technologies involved in each function point in the project are as follows:

## Features

1. The entire deployment architecture adopts a distributed deployment architecture based on nginx+zookeeper, where the database adopts the active and standby mode, and the session session also adopts the distributed session mechanism for disaster recovery prevention.
2. Coupon automatically expires and expires using springboot-based timing tasks + thread pool + redis-based distributed locks to ensure the efficiency of task execution and the concurrency of execution
3. Coupon collection uses the optimistic lock based on the mysql version number to ensure the high concurrency idempotent problem that the user receives, which has a good performance improvement compared to the pessimistic lock. At the same time, the distributed redis + token mechanism is used to prevent repeated submissions to ensure idempotence
4. At the same time, a rule check is added to the receiving rules to ensure the correctness of the receiving rules.
5. In the coupon verification process, the distributed redis transaction is used to ensure the concurrent issue of coupon verification. After the coupon expires, the landing card package becomes invalid. The task to ensure that the record status of the verified coupon in the card package is invalid

## Installation

This project requires Java 1.8, MySQL.


## Documentation

//TODO



