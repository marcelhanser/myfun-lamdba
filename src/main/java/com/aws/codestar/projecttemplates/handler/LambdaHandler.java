package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.codestar.projecttemplates.Application;

public class LambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
    private SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    @Override
    public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
        if (handler == null) {
            try {
                handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application.class);
                return handler.proxy(awsProxyRequest, context);

            } catch (ContainerInitializationException e) {
                e.printStackTrace();
                return null;
            }
        } else return null;
    }
}