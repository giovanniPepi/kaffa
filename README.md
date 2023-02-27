# Kaﬀa Mobile - Pre-qualiﬁcation test

Kaﬀa Mobile - Pre-qualiﬁcation test in Kotlin

## Installation

```bash
git clone git@github.com:giovanniPepi/kaffa.git
```
Install all Maven dependencies listed in pom.xml (required for exercise4)


## Usage

Open using IntelliJ IDEA Community Edition 2022.3.2

Tested on IntelliJ IDEA Community Edition 2022.3.2 and Linux Kernel 6.1.12-zen1-1-zen 


## Exercise 4

Exercise 4's to do list was done using a small persistent database (h2) that is created on /tmp (Linux systems)

- Run the main function inside Exercise4.kt
- Send a POST request to http://localhost:8080 with a task name:

![image](https://user-images.githubusercontent.com/5255535/221440584-78893737-48cb-4479-86a9-6327840c3cf9.png)

- GET all the tasks saved:

![image](https://user-images.githubusercontent.com/5255535/221440616-7272c9f7-f20e-4672-8d0b-2d7d08475ee4.png)

- DELETE a task using its id sending a DELETE request to http://localhost/8080{id}:

![image](https://user-images.githubusercontent.com/5255535/221440665-f25ec0b6-0535-4910-931a-d0cd283e20d4.png)



## Exercise 5 

- Run the main function inside Exercise5.kt

Expected result: 

![image](https://user-images.githubusercontent.com/5255535/221440153-7d21d36c-add3-4387-b34b-dcc66a9a30e9.png)

## Exercise 6

- Uses the same API from Exercise5.kt
- Run the main function inside Exercise6.kt
- Send a GET request to http://localhost:8080

![image](https://user-images.githubusercontent.com/5255535/221440349-fcaa64fa-5313-4f7b-a0d1-06945f20dbcf.png)

- The server returns the current time: 
![image](https://user-images.githubusercontent.com/5255535/221440368-4fdc8f1a-a791-44f7-9786-1eb6ca2a6ef2.png)

## Exercise 7

![image](https://user-images.githubusercontent.com/5255535/221662685-10a9e196-c699-4607-afc7-1dc8356751f9.png)

There is also a SQL file with the DDL inside the resources folder



