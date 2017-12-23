package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.codestar.projecttemplates.GatewayResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<Object, Object> {

    private static String schmutz = null;

    public Object handleRequest(final Object input, final Context context) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "*");
        if (schmutz == null) {
            schmutz = UUID.randomUUID().toString();
        }

        return new GatewayResponse("{ \"Output\": \"Hello My Jenny, you are part of this project:) Wuhuuuu &hearts;! " + schmutz + "\"}", headers, 200);
    }
}
