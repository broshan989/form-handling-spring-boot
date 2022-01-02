# Form Handling with Validations in Spring Boot
This repository contains two files first one is normal form handling with no validations and the second is with validations form handling. 
validations are server-side for that `spring-boot-starter-validation` dependency is used in the configuration file, so that we could use 
various annotations to validate our fields and pass an error message to the client. Web pages are designed using a Thymeleaf template in HTML with Bootstrap classes. 


### Show registration form:
```java
@RequestMapping("/form-handle")
public String showForm(Model m) {
  m.addAttribute("user", new User());
  return "form";
}

```

### Process the form data:
```java
@PostMapping("/info")
public String processInfo(@Valid @ModelAttribute User user, BindingResult bindingResult) {
  System.out.println(user);
  //if form has error return same form
  if(bindingResult.hasErrors()) {
     System.out.println(bindingResult);
     return "form";
   }
  return "info";
}

```


### Thymeleaf form template:
```sh
<form th:action="@{/info}" th:object="${user}" method="post">
      <div class="form-group mb-2">
          <label class="form-label" for="name">Name</label>
          <input type="text" th:field="*{name}" placeholder="Enter name" class="form-control" id="name">
      </div>
      <div class="form-group mb-2">
         <label class="form-label" for="email">Email</label>
         <input type="email" th:field="*{email}" placeholder="Enter email" class="form-control" name="email">
      </div>
      <div class="mt-2">
          <button type="submit" class="btn btn-primary">Submit</button>
      </div>
</form>
```
### Show validation error message on the form:
```sh
<div class="form-group mb-2">
    <label for="name" class="form-label">Name</label>
    <input type="text" th:field="*{name}" placeholder="Enter name" class="form-control" id="name"
      th:classappend="${#fields.hasErrors('name')} ? 'is-invalid' : '' ">
    <!-- Error message -->
    <div class="invalid-feedback" th:each="e : ${#fields.errors('name')}" th:text="${e}"> </div>
 </div>

 <div class="form-group mb-2">
    <label for="email" class="form-label">Email</label>
    <input type="email" th:field="*{email}" placeholder="Enter email" class="form-control" name="email"
      th:classappend="${#fields.hasErrors('email')} ? 'is-invalid' : '' ">
    <!-- Error message -->
    <span class="invalid-feedback" th:if="${#fields.errors('email')}" th:errors="*{email}"> </span>
 </div>
```

### Thymeleaf attributes used above
- `th:action` submits the form data to request handling method in a `@Controller` annotated class, url address must be in `@{...}`.
- `th:object` it is used to specify model class where form data will be mapped it must be a variable expression `${...}`.
- `th:field` it binds form field data with model class property mentioned in `*{...}`.
- `th:classappend` it applies class on the field if the condition is satisfied.
- `th:errors` this holds the all form validation errors to display error message mention class property in `*{property_name}`.
- `th:if` to check if the condition is true.
- `th:text` displays dynamic content of specified variable expression `${...}` on the web page.



## Run the Project

Import file as a maven project in Eclipse STS or Intellij idea and run as Spring Boot Application, the project will run on the following URL

```sh

http://localhost:9090

```

## Result Images

### Registration Form
![form](https://user-images.githubusercontent.com/79737618/147868814-2f32b2e5-fddc-424b-a34b-2c6af3c9c44e.PNG)

### Validations
![validations](https://user-images.githubusercontent.com/79737618/147868818-6129c2cf-3c25-4c13-a642-a1f42b5a3f02.PNG)

### Registration Success
![registration-success](https://user-images.githubusercontent.com/79737618/147868819-9bcc87e8-a9cf-4cdb-baa5-beb5f5f4e7d9.PNG)
