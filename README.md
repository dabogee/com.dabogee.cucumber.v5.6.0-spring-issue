# com.dabogee.cucumber.v5.6.0-spring-issue

**Briefly:** spring components are shareable between test threads when tests have been started in the parallel mode.

It's a small project which contains 2 simple scenarios in different feature files because I'd like to run them in parallel mode.

> Scenario: Modify shopping cart  
>     Given Shopping cart is empty  
>     When  Add a new product to shopping cart  
>     Then  Shopping cart contains 1 item  

> Scenario: Check that shopping cart is empty all the time  
>     Given Shopping cart is empty  
>     When  Wait 5 seconds  
>     Then  Shopping cart is empty  

**Running tests with different cucumber versions:**  
> mvn clean test -Pv4.7.2

> mvn clean test -Pv5.6.0


### v4.7.2
When I run this scenario with cucumber v4.7.2 it works fine and execution log looks like:  

[cucumber-runner-1-thread-1] INFO c.d.t.s.c.ContextShutdownHook:12 - Setup..  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.c.ContextShutdownHook:12 - Setup..**  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 0..**  
[cucumber-runner-1-thread-1] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 0..  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.ProductSteps:21 - Adding a new product item to shopping cart..**  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 1..**  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.c.ContextShutdownHook:17 - Shutdown..**  
[cucumber-runner-1-thread-1] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 0..  
[cucumber-runner-1-thread-1] INFO c.d.t.s.c.ContextShutdownHook:17 - Shutdown..  

### v5.6.0
With cucumber-jvm of v5.6.0 version the log looks like:  
[cucumber-runner-1-thread-1] INFO c.d.t.s.c.ContextShutdownHook:12 - Setup..  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.c.ContextShutdownHook:12 - Setup..**  
[cucumber-runner-1-thread-1] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 0..  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 0..**  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.ProductSteps:21 - Adding a new product item to shopping cart..**  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 1..**  
**[cucumber-runner-1-thread-2] INFO c.d.t.s.c.ContextShutdownHook:17 - Shutdown..**  
[cucumber-runner-1-thread-1] INFO c.d.t.s.ProductSteps:32 - Checking shopping cart size equals to 0..  
java.lang.AssertionError: Expected size:<0> but was:<1> in:<["AKEtJzlTcxooQGagQUJZvNSKPJuztYEb"]>  



This means when the shopping cart has been modified in a scenario which runs in the **thread-2** then this changes are going available in another **thread-1** for totally different scenario.