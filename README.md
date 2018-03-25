# NCD Connect Backend

This is the backend for the NCD Connect website, written in Kotlin.

## Dev Setup

Copy and fill in the `bootstrap.yml.example` file: 
`cp config/bootstrap.yml.example config/bootstrap.yml`.  This should just have the encrypt key that is used by Spring to decrypt all the encrypted properties.  At the moment the easiest way to obtain this is asking Angus.

Run like a normal Spring Boot project, using the `dev` profile.
