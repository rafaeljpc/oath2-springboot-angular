oath2-springboot-angular
===

This project aim to be a simple study that gathers a simple Spring Boot Back-End with Spring Security and a Angular Front-End, both using [Auth0](https://auth0.com) as authentication service.

There is 2 modules:
- service - Which is the Spring Boot service
- front-end - Containg the Angular website

# Auth0 service configuration

The authentication of this project is built-in [Auth0](https://auth0.com) system. So we need to setup some things before running. And you will need a *Auth0* account to do those things.

## Auth0 Social Authentication 

Entering in the *Auth0* management site go to `Authentication -> Social` and create the Social Media connection you like e.g. *Google*. We use the default config because is a development test application.

## Auth0 API Setup

Next head up to `Applications -> API` and create am API.

1. Name your application like `rafaeljpc-auth0-study`
2. In `Permission` tab add a new permission `read:user`
3. Note that *Auth0* created a **Application** to this **API**

## Auth0 Applications Setup

Now we go to `Applications -> Applications` menu.

Remember that *Auth0* created a Application to our API. Later we'll need some infos there.

For now, we need to:

1. Create a new Application with Single Page Application type.
2. In `Settings` Name it with `rafaeljpc-auth0-study-oauth2`
3. Add in `Allowed Callback URLs` field 
   1. > http://localhost:4200
4. Add in `Allowed Logout URLs` field 
   1. > http://localhost:4200
5. Add in `Allowed Web Origins` field 
   1. > http://localhost:4200
6. Add in `Allowed Origins CORS` field 
   1. > http://localhost:4200, http://localhost:8080
7. In `Connections` tab check if your socials are activated

At this point we have 
- 1 API named `rafaeljpc-auth0-study`
- 2 Applications with names `rafaeljpc-auth0-study (Test Application)` (Machine-to-Machine type) and `rafaeljpc-auth0-study-oauth2` (Single-Page-Application type)

# Spring Boot Service

# Angular Front-End


