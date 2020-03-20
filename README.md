# SpringBoot-SpringDataRestAPI
RestAPI created using Spring Boot,Spring DataJPA,Spring Actuator in SpringInitilizr


Run 
    Right click on RestAPIwithDataJpaApplication - click on Run 'RestAPIwit...main()'

Postman: 

Bank
      
      1. To get all bank details 
        GET: http://localhost:8080/bankDetails/

      2. To get a particular bank details 
        GET: http://localhost:8080/bankDetails/101

      3. To add bank deatils
         * Post: http://localhost:8080/bankDetails/
         * Body:
            {
                "id": "101",
                "bankName": "HDFC",
                "branch": "Madhapur Branch",
                "ifscCode": "HDFC001234",
                "address": "Madhapur, Hyderabad"
            }
         * Headers:
            Key: Content-Type, Value: application/json
         * Response: Bank Added Successfully


       4. To update if bank already exists, or create a new one if bank not available 
          PUT: http://localhost:8080/bankDetails/101
          * Body:
              {
                "id": "101",
                "bankName": "HDFC",
                "branch": "Madhapur Branch",
                "ifscCode": "HDFC001234",
                "address": "MediCover Hospitals, Madhapur, Hyderabad"
              }
         * Headers:
              Key: Content-Type, Value: application/json
         * Respose: Bank Updated Successfully

       5.  To delete a particular bank details
          DELETE: http://localhost:8080/bankDetails/101
         
   Customer
   
       1. To get all Customer details 
        GET: http://localhost:8080/bankDetails/102/customerDetails
        Response:
         * [
                {
                    "id": "1001",
                    "customerName": "Mr Mahesh",
                    "mobile": "9912345678",
                    "address": "Madhapur, Hyderabad",
                    "bank": {
                        "id": "102",
                        "bankName": "ICICI",
                        "branch": "Kondapur Branch",
                        "ifscCode": "ICIC00123",
                        "address": "Kondapur, Hyderabad"
                    }
                },
                {
                    "id": "1002",
                    "customerName": "Mr Sathvik",
                    "mobile": "987634832",
                    "address": "Kothaguda, Hyderabad",
                    "bank": {
                        "id": "102",
                        "bankName": "ICICI",
                        "branch": "Kondapur Branch",
                        "ifscCode": "ICIC00123",
                        "address": "Kondapur, Hyderabad"
                    }
                }
           ]

       2. To get a particular customer details 
        GET: http://localhost:8080/bankDetails/102/customerDetails/1001
        Response:
         * {
                "id": "1001",
                "customerName": "Mr Mahesh",
                "mobile": "9912345678",
                "address": "Madhapur, Hyderabad",
                "bank": {
                    "id": "102",
                    "bankName": "ICICI",
                    "branch": "Kondapur Branch",
                    "ifscCode": "ICIC00123",
                    "address": "Kondapur, Hyderabad"
                }
            }

       3. To add customer deatils
         * Post: http://localhost:8080/bankDetails/102/customerDetails
         * Body:
            {
                "id": "1002",
                "customerName": "Mr Sathvik",
                "mobile": "987634832",
                "address":  "Kothaguda, Hyderabad"
            }
         * Headers:
            Key: Content-Type, Value: application/json
         * Response: Customer Added Successfully


        4. To update if customer already exists, or create a new one if customer not available 
          PUT: hhttp://localhost:8080/bankDetails/102/customerDetails/1001
           * Body:
           * {
                  "id": "1001",
                  "customerName": "Mr Mahesh",
                  "mobile": "9912345678",
                  "address":  "Hitech City, Madhapur, Hyderabad"
              }
          * Headers:
              Key: Content-Type, Value: application/json
          * Respose: Customer Updated Successfully

        5.  To delete a particular customer details
          DELETE: http://localhost:8080/bankDetails/102/customerDetails/1002
          * Respose: Customer Deleted Successfully
      
     
