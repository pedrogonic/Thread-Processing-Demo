# Thread Processing  Demo

## Table of Contents

- Description
- Install
- Endpoints

## Description

Simple Spring Boot project to test processing in threads.

## Install

```bash
git clone https://github.com/pedrogonic/Thread-Processing-Demo.git
./mvnw spring-boot:run
```

## Endpoints 

### POST /processInThread

**Description:** Pass a list of strings and immediately receive a "Processing..." response. Open the terminal and watch each word being printed in a 1 second delay.

#### Request

**Request Body:**
Eg:
```bash
[
	"word 1",
	"word 2",
	"word 3"
]
```
**Request URL:**

E.g.:
```shell
http://localhost:8080/processInThread
```

#### Response

```bash
Processing...
```

**Response Codes:** **200** (OK).

### POST /processAsync

**Description:** Pass a list of strings and immediately receive a "Processing..." response. Open the terminal and watch each word being printed in a random delay. Each word is processed in a new Thread.

#### Request

**Request Body:**
Eg:
```bash
[
	"word 1",
	"word 2",
	"word 3"
]
```
**Request URL:**

E.g.:
```shell
http://localhost:8080/processAsync
```

#### Response

```bash
Processing...
```

**Response Codes:** **200** (OK).

### POST /waitProcess

**Description:** Pass a list of strings and wait for all Threads to be processed.

#### Request

**Request Body:**
Eg:
```bash
[
	"word 1",
	"word 2",
	"word 3"
]
```
**Request URL:**

E.g.:
```shell
http://localhost:8080/waitProcess
```

#### Response

E.g.:
```bash
Finished parallel processes! 
Processed word word1 in 9 seconds, Processed word word2 in 4 seconds, Processed word word3 in 5 seconds.
```

**Response Codes:** **200** (OK).

