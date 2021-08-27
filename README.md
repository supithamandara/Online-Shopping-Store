# Online-Shopping-Store
Microservices project for CO4353 Distributed Systems

Prerequists:
RabbitMQ
Strip

Steps:
1. Install RabbitMQ and run RabbitMQ command prompt
2. type: rabbitmq-service.bat start
3. open the link in browser
4. Then go to https://dashboard.stripe.com/register and make an account
5. It will show the stripe-key on the dashboard
6. Then go to application properties in payment microservice
7. add that stripe-key as the value to stripe.api.api-key:<_stripe_key_>
8. Then Run the microservices and test
