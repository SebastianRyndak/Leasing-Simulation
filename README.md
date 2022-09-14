## **Leasing-Simulation**

In order to run the application properly, you need to:

- Download the repository
- Run it with the IDE
- In the "application.properties" file, we add in the 3rd line of code mail, and in the 4th line of code the password for mail. Example below.

spring.mail.username=mail@gmail.com

spring.mail.password=password

- Then, using Postman, transfer the data in Jason format to "/leasing/sendForm" endpoint. For an example of a serialized object, see the file Jason.txt
- App is using inserted data to validate if the leasing application can be approved and then response is sending to given email address.