# Assignment 2

## Instructions for KDUers to complete the assignment
1. The API that must be used for the forward and reverse geocoding must be taken from [postion-stack](https://positionstack.com/)
2. Caching keys and names format :
    * Forward geocoding key = "#address"
    * Forward geocoding name = "geocoding"
    * Reverse geocoding key = "{#latitude,#longitude}"
    * Reverse geocoding name = "reverse-geocoding"
3. APIs Format :
    * Forward geocoding = "http://localhost:${port}/geocoding?address=${value}"
    * Reverse geocoding = "http://localhost:${port}/reverse-geocoding?latitude=${value}&longitude=${value}"
4. API request params names with the following sequence :
    * Forward geocoding = "address"
    * Reverse geocoding = "latitude" , "longitude"
5. In case of forward geocoding, no caching must be done for the location named - “goa” - it should always be re-fetched.

Your application must have:

- In-Memory caching support
- Lookup in an in-memory cache for :
  -- lat/long corresponding to an address.
  -- Address corresponding to latitude and longitude
- If the record is not found in the cache, invoke the third party location API to fetch the lat/long for a given address and persist that in the in-memory cache.
- Remove one or more/all stale and unused records from cache so that fresh values can be loaded into the cache again.
- Avoid evicting too much data out of the cache by selectively updating the entries whenever you alter them
- Clearly log the mapping for lat/long corresponding to an address, and address corresponding to latitude and longitude.

## This Assignment consists of 8 test cases :
1. `testGetGeoCode` -  Test case to verify the successful retrieval of geocoding information from the external API via the `/geocoding` endpoint.
2. `testGetReverseGeoCode` -  Test case to verify the successful retrieval of reverse geocoding information from the external API via the "/reverse-geocoding" endpoint.
3. `testGeoCodingCacheHitWithEndpoint` -  Test case to verify that the cache is populated and successfully retrieved on the second call for the geocoding endpoint.
4. `testReverseGeoCodingCacheHitWithEndpoint` -  Test case to verify that the cache is populated and successfully retrieved on the second call for the reverse geocoding endpoint.
5. `testGeoCodingCacheMiss` -  Test case to verify that calling the geocoding endpoint with a specific address - *goa* results in a cache miss.
6. `testGeoCodingCacheEviction` -  Test case to verify the eviction of cache entries for geocoding information.
7. `testGetGeoCodeNegative` - Test case to verify the geocoding endpoint with an invalid address.
8. `testGetReverseGeoCodeNegative` - Test case to verify the reverse geocoding endpoint with invalid parameters.



