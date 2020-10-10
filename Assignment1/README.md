Assignmnet1
---

### Problem Statement
Implement a TCP-based key-value store. The server implements the key-value store and clients make use of it. The server must accept clients’ connections and serve their requests for ‘get’ and ‘put’ key value pairs. All key-value pairs should be stored by the server only in memory. Keys and values are strings. The client accepts a variable no of command line arguments where the first argument is the server hostname followed by port no. It should be followed by any sequence of `get <key>` and/or `put <key> <value>`.
```
./client 192.168.124.5 5555 put city Kolkata put country India get country get city get Institute
India
Kolkata
<blank>
```
The server should be running on a TCP port. The server should support multiple clients and maintain their key-value stores separately. Implement authorization so that only few clients having the role **manager** can access other’s key-value stores. A user is assigned the **guest** role by default. The server can upgrade a **guest** user to a **manager** user.

### Implementation
Every client is uniquely identified by the combination of host's IP address and the port. Server's port is binded to **9999**. 
The program maintains two maps, one is global which holds key value for every client which is accessible onlu to the client whose role is `manager` and another map is locally available to each client for storing their key value pair.
The program also used socket programming for connecting clients and the server.

### How to Run 
1. Start the server using `python3 server.py <HOST IP> <PORT>`
2. In the another terminal, run the client using `python3 client.py <HOST IP> <PORT> <REQUESTS>`

### Requests
 1. **put key value**
 2. **get key**
 3. **upgrade**
 4. **getall key**
