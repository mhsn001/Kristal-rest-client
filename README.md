# Kristal-rest-client

Kristal-rest-client is playing two roles. 
  1. Emission of numbers
  2. Rest client for consuming spring rest api
  
  This is a simple java maven projct can be imported in eclipes of STS.
  
  Class com.khmo.rest.client.EmitionStart, starts the number emission thread and rest client as well. On running this class console shows the blow text.
  
  **###################################**

  **Hit Y to get cumulative result.**
  
  **Hit N to stop emission.**
  
  If user hits 'Y' rest client will send emitted data from last half an hour to spring rest api and will get a cumulative result as response.
  
  
