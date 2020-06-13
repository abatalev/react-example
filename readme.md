# Build And Run

## Introduction

This is a demo project of Spring Boot Application with React Frontend. 

## Production

### Build and Launch 

```sh
mvn clean install
java -jar backend/target/backend-0.0.1-SNAPSHOT.jar
```

## Development

## Frontend tuning

In `package.json` change `dependencies` sections: 

```json
  "dependencies": {
    "react": "^16.13.1",
    "react-dom": "^16.13.1"
  },
  "devDependencies": {
    "@testing-library/jest-dom": "^4.2.4",
    "@testing-library/react": "^9.3.2",
    "@testing-library/user-event": "^7.1.2",
    "react-scripts": "3.4.1"
  },
  "proxy": "http://localhost:8080",
```

### Launch frontend

```sh
cd frontend
yarn start
```

### Launch backend

```sh
cd backend
mvn spring-boot:run 
```
