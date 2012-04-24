package org.slc.sli.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import org.slc.sli.util.Constants;
import org.slc.sli.util.URLBuilder;

/**
 * 
 * @author 
 */
@Component("RESTClient")
public class RESTClient {

    private String securityUrl;
    
    private static Logger logger = LoggerFactory.getLogger(RESTClient.class);

    /**
     * Call the session/check API
     * 
     * @param token
     *            the sessionId or null
     * @return JsonOject as described by API documentation
     * @throws NoSessionException
     */
    public JsonObject sessionCheck(String token) {
        logger.info("Session check URL = " + Constants.SESSION_CHECK_PREFIX);
        // String jsonText = makeJsonRequest(Constants.SESSION_CHECK_PREFIX, token);
        String jsonText = makeJsonRequestWHeaders(Constants.SESSION_CHECK_PREFIX, token, true);
        logger.info("jsonText = " + jsonText);
        JsonParser parser = new JsonParser();
        return parser.parse(jsonText).getAsJsonObject();
    }

    /**
     * Make a request to a REST service and convert the result to JSON
     * 
     * @param path
     *            the unique portion of the requested REST service URL
     * @param token
     *            not used yet
     * @return a {@link JsonElement} if the request is successful and returns valid JSON, otherwise
     *         null.
     * @throws NoSessionException
     */
    public String makeJsonRequest(String path, String token) {
        RestTemplate template = new RestTemplate();
        URLBuilder url = new URLBuilder(getSecurityUrl());
        url.addPath(path);
        HttpEntity entity = null;
        if (token != null) {
            // url.addQueryParam(API_SESSION_KEY, token);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);
            entity = new HttpEntity(headers);
        }
        logger.info("Accessing API at: " + url.toString());

        HttpEntity<String> response = template.exchange(url.toString(), HttpMethod.GET, entity, String.class);
        logger.info("JSON response for roles: " + response.getBody());
        // String jsonText = template.getForObject(url.toString(), String.class);
        // logger.info("JSON response for roles: " + jsonText);
        return response.getBody();

    }

    public String makeJsonRequestWHeaders(String path, String token, boolean fullEntities) {
        RestTemplate template = new RestTemplate();

        if (token != null) {
            // url.addQueryParam(API_SESSION_KEY, token);
            URLBuilder url = null;
            if (!path.startsWith("http")) {
                url = new URLBuilder(getSecurityUrl());
                url.addPath(path);
            } else {
                url = new URLBuilder(path);
            }
            //TODO probably should use media types
            if (fullEntities)
                url.addQueryParam("full-entities", "true");

            HttpHeaders headers = new HttpHeaders();
            // headers.add(API_SESSION_KEY, token);
            headers.add("Authorization", "Bearer " + token);
            HttpEntity entity = new HttpEntity(headers);
            logger.debug("Accessing API at: " + url);
            HttpEntity<String> response = null;
            try {
                response = template.exchange(url.toString(), HttpMethod.GET, entity, String.class);
            } catch (HttpClientErrorException e) {
                logger.debug("Catch HttpClientException: " + e.getStatusCode().toString());
            }
            if (response == null) {
                return null;
            }
            return response.getBody();
        }
        logger.debug("Token is null in call to RESTClient for path" + path);

        return null;
    }

    public String getSecurityUrl() {
        return securityUrl;
    }

    public void setSecurityUrl(String securityUrl) {
        this.securityUrl = securityUrl;
    }
}
