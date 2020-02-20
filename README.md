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

