# sg-parking-v2
Updated version of the sg-parking-api with improved coding practices 
and the implementaion of database migration scripts 
to improve code readability, scalability, and overall responsiveness of the api 
(responsiveness may be affected for initial requests due to server idling)

## Background
A lightweight REST API that allows clients to submit an address and returns 10 closest carparks 
(limited to those managed by the Singapore Housing Development Board) and their corresponding lot availabilities 
(may not be available for all carparks)

## Data
Carpark details and availability data used for this project obtained via https://data.gov.sg under the Singapore Open Data License.

## Production Config
The following JVM args must be passed to configure a datasource for use in a production environment
1. datasourceUrl
2. datasourceUsername
3. datasourcePassword

## dev Config
The following JVM args may be passed to configure the application (via appication-dev.properties) 
for use in a dev environment
1. spring.profiles.active=dev

## API specification
http://sg-parking-v2.herokuapp.com/api/v1/swagger-ui/
