# Introduction to Maven and Spring Boot

## 1. What is Maven?
Maven is a **build automation and dependency management tool** for Java projects.  
It helps developers by:
- Managing project dependencies (e.g., Spring Boot, MySQL drivers).
- Providing a standard project structure.
- Simplifying build, test, and deployment processes with simple commands.

## 2. What is Spring Boot?
Spring Boot is a Java framework that makes it easy to build stand-alone, production-ready web applications.
It is built on top of the Spring Framework but removes much of the boilerplate configuration.

### Why use Spring Boot?
- Quick setup – Run your app with a single command.
- Embedded server – No need to install Tomcat manually.
- Auto configuration – Spring Boot configures common settings automatically.
- Microservice friendly – Easy to create RESTful APIs for frontend-backend integration.
- Large ecosystem – Works with Spring Data JPA, Spring Security, etc.

## 3. Project Structure (Default Maven + Spring Boot)

A typical Spring Boot project has the following structure:
```php
src
 └── main
     ├── java                # Your Java source code
     │   └── com.example.demo
     │       ├── DemoApplication.java  # Main entry point
     │       ├── controller/           # Web controllers
     │       ├── service/              # Business logic
     │       └── repository/           # Database access
     │
     └── resources
         ├── application.properties    # Configuration file
         ├── static/                   # Static resources (CSS, JS, images)
         └── templates/                # HTML templates (Thymeleaf, FreeMarker, etc.)
```
### Key folders:

- `static/` → Stores static frontend assets like CSS, JavaScript, and images.
    Example: `/static/style.css` → accessible at `http://localhost:8080/style.css`.
- `templates/` → Stores dynamic HTML templates (e.g., Thymeleaf).
    Example: index.html can use server-side rendering with data from controllers.
- `application.properties` → Holds app configuration (e.g., server port, database URL).

## 4. MVC Layers in Spring Boot

Spring Boot applications often follow an MVC (Model-View-Controller) or layered architecture:

### Controller
    - Handles HTTP requests.
    - Defines routes (e.g., /hello).
    - Calls the Service layer.
```java
    @RestController
    public class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "Hello Spring Boot!";
        }
    }
```

### Service
    - Contains business logic.
    - Keeps controllers simple.
```java
    @Service
    public class HelloService {
        public String getMessage() {
            return "Hello from Service!";
        }
    }
```
---
# BMI on Web

## BmiApplication.java
位置: `src/main/java/com/example/bmi/BmiApplication.java`
說明: 這是用來啟動 Spring Boot 應用程式的主類別。
```java
package com.example.bmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmiApplication.class, args);
	}

}
```

## BmiController.java
位置: `src/main/java/com/example/bmi/controller/BmiController.java`
說明: 該控制器負責處理來自表單提交的請求 (/calculate) 以及提供 BMI 計算的 API (/api/bmi)。表單數據會被處理後顯示，API 則會回傳 JSON 格式的 BMI 和分類。
```java
package com.example.bmi.controller;

import com.example.bmi.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @PostMapping("/calculate")
    public String calculateBmi(@RequestParam("height") double height,
                               @RequestParam("weight") double weight,
                               Model model) {
        double bmi = bmiService.calculateBmi(height, weight);
        String category = bmiService.getBmiCategory(bmi);
        model.addAttribute("bmi", bmi);
        model.addAttribute("category", category);
        return "result";
    }

    // API端點
    @GetMapping("/api/bmi")
    @ResponseBody
    public BmiResponse getBmi(@RequestParam("height") double height,
                              @RequestParam("weight") double weight) {
        double bmi = bmiService.calculateBmi(height, weight);
        String category = bmiService.getBmiCategory(bmi);
        return new BmiResponse(bmi, category);
    }

    // BmiResponse內部類
    public static class BmiResponse {
        private double bmi;
        private String category;

        public BmiResponse(double bmi, String category) {
            this.bmi = bmi;
            this.category = category;
        }

        public double getBmi() {
            return bmi;
        }

        public String getCategory() {
            return category;
        }
    }
}
```
## BmiService.java
位置: `src/main/java/com/example/bmi/service/BmiService.java`
說明: 這個服務包含兩個方法：一個是用來計算 BMI，另一個是用來根據 BMI 值返回對應的 BMI 分類。
```java
package com.example.bmi.service;

import org.springframework.stereotype.Service;

@Service
public class BmiService {

    public double calculateBmi(double heightCm, double weightKg) {
        double heightM = heightCm / 100;
        return weightKg / (heightM * heightM);
    }

    public String getBmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "體重過輕";
        } else if (bmi < 24) {
            return "正常範圍";
        } else if (bmi < 27) {
            return "過重";
        } else if (bmi < 30) {
            return "輕度肥胖";
        } else if (bmi < 35) {
            return "中度肥胖";
        } else {
            return "重度肥胖";
        }
    }
}
```
## index.html
位置: `src/main/resources/static/index.html`
說明: 這是 BMI 計算器的前端界面，使用者可以在這裡輸入身高和體重，並點擊按鈕來進行 BMI 計算，結果將會顯示在頁面下方。
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
 <title>BMI 計算器</title>
 <meta charset="UTF-8">
 <style>
     body {
         font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
         background-color: #f4f6f9;
         display: flex;
         justify-content: center;
         align-items: center;
         height: 100vh;
         margin: 0;
     }
     .container {
         background-color: #ffffff;
         padding: 30px 40px;
         border-radius: 10px;
         box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
         max-width: 400px;
         width: 100%;
     }
     h2 {
         text-align: center;
         color: #333333;
         margin-bottom: 20px;
     }
     label {
         display: block;
         margin-top: 15px;
         color: #555555;
     }
     input {
         width: 100%;
         padding: 12px 15px;
         margin-top: 5px;
         border: 1px solid #cccccc;
         border-radius: 5px;
         box-sizing: border-box;
         font-size: 16px;
     }
     button {
         width: 100%;
         padding: 12px 15px;
         margin-top: 20px;
         background-color: #007BFF;
         border: none;
         border-radius: 5px;
         color: #ffffff;
         font-size: 16px;
         cursor: pointer;
         transition: background-color 0.3s ease;
     }
     button:hover {
         background-color: #0056b3;
     }
     hr {
         margin: 30px 0;
         border: none;
         border-top: 1px solid #eeeeee;
     }
     #apiResult {
         margin-top: 20px;
         font-size: 18px;
         color: #333333;
         text-align: center;
     }
 </style>
</head>
<body>
<div class="container">
 <h2>BMI 計算器</h2>

 <h3>使用API計算BMI</h3>
 <form id="bmiApiForm">
     <label for="apiHeight">身高（公分）:</label>
     <input type="number" id="apiHeight" name="height" min="50" max="300" required placeholder="例如: 170">

     <label for="apiWeight">體重（公斤）:</label>
     <input type="number" id="apiWeight" name="weight" min="10" max="500" required placeholder="例如: 65">

     <button type="button" onclick="callBmiApi()">計算BMI</button>
 </form>

 <p id="apiResult"></p>
</div>

<script>
 function callBmiApi() {
     const height = document.getElementById('apiHeight').value;
     const weight = document.getElementById('apiWeight').value;

     if (!height || !weight) {
         alert('請填寫所有欄位。');
         return;
     }

     fetch(`/api/bmi?height=${height}&weight=${weight}`)
         .then(response => {
             if (!response.ok) {
                 throw new Error('網路回應不是OK');
             }
             return response.json();
         })
         .then(data => {
             document.getElementById('apiResult').innerText = `BMI: ${data.bmi.toFixed(2)} (${data.category})`;
         })
         .catch(error => {
             console.error('Error:', error);
             document.getElementById('apiResult').innerText = '計算失敗，請檢查輸入值。';
         });
 }
</script>
</body>
</html>
```

## Upload screenshot using Moodle
- Screenshot scope: the BMI web page showing both the input fields and the calculated result
