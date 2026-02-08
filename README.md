# VITA HEALTH - MOBILE

This repository contains an automated test framework built to validate the **VitaHealth Mobile Flow** and its interaction with **mobile-triggered events** such as **Launch app, Login, Open feed** and **Verifying Items render**.

---

## 🧱 Tech Stack

- Java 23
- Selenium WebDriver
- JUnit
- Maven
- GitHub Actions (CI)

---

## ⚙️ Installation & Setup

### 1. Prerequisites

Ensure the following are installed:

- Java 23
- Maven 3.9+
- Google Chrome (latest)
- Git



## Clone the Repository
    ```git clone https://github.com/LatifatAbdullahi/VitaHealthTestAutomation-Mobile```


## Environment Variables
All sensitive values are injected via environment variables.
Required:
TEST_EMAIL
TEST_PASSWORD
API_BASE_URL
API_BEARER_TOKEN
USER_ID


4. Install Dependencies
   ```mvn clean install -DskipTests```

## Running Tests
Run Operator test suite:
```mvn test -Dtest=TestRunner```
Run with retry logic (CI-style):
```mvn test -Dtest=TestRunner -Dsurefire.rerunFailingTestsCount=2```

---

## How CI runs the tests

When a push or when a PR is opened to `main`, GitHub Actions runs the test suite according to the scripts set in the workflow .yml file.

**What triggers it**  
Any push or pull request targeting `main` kicks off the workflow. No need to do anything else.

**What the runner does**  
The job runs on a fresh Ubuntu VM. It checks out the repo, sets up Java 17, and restores Maven dependencies from cache (so repeat runs are faster). Chrome is installed so any browser-based tests can run. Your secrets (e.g. `TEST_EMAIL`, `TEST_PASSWORD`, `API_BEARER_TOKEN`, etc.) are passed in as environment variables—they’re never printed in logs.

**How the tests run**  
A single Maven command runs the suite: the same one you’d use locally with retries turned on (`-Dtest=TestRunner -Dsurefire.rerunFailingTestsCount=2`).

---

## 🧪 Test Coverage
- Login
- Open Feed
- Items rendering
