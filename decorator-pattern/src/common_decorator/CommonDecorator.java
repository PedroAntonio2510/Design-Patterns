package common_decorator;

import domain.Request;

import java.util.Map;

public class CommonDecorator {
    public static void main(String[] args) {
        RequestProcessor baseProcessor = new BaseRequestProcessor();

        RequestProcessor validationProcessor = new ValidationDecorator(baseProcessor);
        RequestProcessor loggingProcessor = new LoggingDecorator(validationProcessor);

        RequestProcessor processorPipeline = loggingProcessor;

        var headers = Map.of("Authorization", "Bearer token123");
        var validRequest = new Request("192.168.1.1", headers);
        var invalidRequest = new Request("192.168.1.1", null);

        try {
            processorPipeline.process(validRequest);
            processorPipeline.process(invalidRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

interface RequestProcessor {
    void process(Request request);
}

class BaseRequestProcessor implements RequestProcessor {
    @Override
    public void process(Request request) {
        System.out.println("Request processed successfully");
    }
}

abstract class RequestProcessDecorator implements RequestProcessor {
    protected final RequestProcessor wrappedProcessor;

    public RequestProcessDecorator(RequestProcessor wrappedProcessor) {
        this.wrappedProcessor = wrappedProcessor;
    }

    @Override
    public void process(Request request) {
        wrappedProcessor.process(request);
    }
}

class LoggingDecorator extends RequestProcessDecorator {
    public LoggingDecorator(RequestProcessor processor) {
        super(processor);
    }

    @Override
    public void process(Request request) {
        System.out.println("Logging request: " + request);
        super.process(request);
    }
}

class ValidationDecorator extends RequestProcessDecorator {
    public ValidationDecorator(RequestProcessor processor) {
        super(processor);
    }

    @Override
    public void process(Request request) {
        if(isRequestInvalid(request))
            throw new IllegalArgumentException("Missing authorization header");

        super.process(request);
    }

    private boolean isRequestInvalid(Request request) {
        return request.headers() == null || !request.headers().containsKey("Authorization");
    }
}