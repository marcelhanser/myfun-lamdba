import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.aws.codestar.projecttemplates.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@Configuration
public class IntegrationTestConfig {

    @Autowired
    private ConfigurableWebApplicationContext applicationContext;

    @Bean
    public MockLambdaContext lambdaContext() {
        return new MockLambdaContext();
    }

    @Bean
    public SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> springLambdaContainerHandler() throws ContainerInitializationException {
        SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application.class);
//        handler.setRefreshContext(false);
        return handler;
    }

}