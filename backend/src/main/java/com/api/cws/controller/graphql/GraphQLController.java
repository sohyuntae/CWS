//package com.api.cws.controller.graphql;
//
//import graphql.*;
//import graphql.language.SourceLocation;
//import io.leangen.graphql.spqr.spring.autoconfigure.DataLoaderRegistryFactory;
//import io.leangen.graphql.spqr.spring.web.dto.GraphQLRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.util.StopWatch;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.AbstractMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//public class GraphQLController
//{
//    private final GraphQL graphQL;
//    private final DataLoaderRegistryFactory dataLoaderRegistryFactory;
//
//    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Object graphql(@RequestBody GraphQLRequest graphQLRequest, HttpServletRequest raw) throws IOException
//    {
//        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
//            .query(graphQLRequest.getQuery())
//            .context(raw)
//            .dataLoaderRegistry(dataLoaderRegistryFactory.createDataLoaderRegistry())
//            .build();
//
//        String query = graphQLRequest.getQuery();
//        log.info(query);
//
//        String functionName = "";
//        int startIndex = query.indexOf("query");
//        if (startIndex == -1) {
//            startIndex = query.indexOf("ExecuteQueryResult");
//        }
//        if (startIndex != -1) {
//            int endIndex = query.indexOf("\n", startIndex);
//            if (endIndex != -1) functionName = query.substring(startIndex, endIndex);
//            else functionName = query;
//        }
//
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        ExecutionResult executionResult = graphQL.execute(executionInput);
//        stopWatch.stop();
//
//        if (stopWatch.getTotalTimeSeconds() > 1) {
//            log.info("[graphql]{} {} check query", functionName, stopWatch.getTotalTimeSeconds());
//        } else {
//            log.info("[graphql]{} {}", functionName, stopWatch.getTotalTimeSeconds());
//        }
//
//        if (!executionResult.getErrors().isEmpty())
//        {
//            return sanitize(executionResult);
//        }
//
//        return executionResult.toSpecification();
//    }
//
//    private Map<String, Object> convertNullResult(LinkedHashMap<String, Object> data)
//    {
//        List<LinkedHashMap<String, Object>> res = (List<LinkedHashMap<String, Object>>) data.get("query");
//
//        List<Map<String, Object>> finalRes = res
//            .stream()
//            .map(x -> x
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() == null ? "" : e.getValue(), (v1, v2) -> v1, LinkedHashMap::new))
//            ).collect(Collectors.toList());
//
//        return data
//            .keySet()
//            .stream()
//            .map(o -> new AbstractMap.SimpleEntry<>(o, finalRes))
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }
//
//    private ExecutionResult sanitize(ExecutionResult executionResult)
//    {
//        return new ExecutionResultImpl(executionResult.getErrors().stream()
//            .peek(err -> log.error(err.getMessage()))
//            .map(this::sanitize)
//            .collect(Collectors.toList()));
//    }
//
//    private GraphQLError sanitize(GraphQLError error)
//    {
//        if (error instanceof ExceptionWhileDataFetching)
//        {
//            return new GraphQLError()
//            {
//                @Override
//                public String getMessage()
//                {
//                    Throwable cause = ((ExceptionWhileDataFetching) error).getException().getCause();
//                    return cause instanceof InvocationTargetException ? ((InvocationTargetException) cause).getTargetException().getMessage() : cause.getMessage();
//                }
//
//                @Override
//                public List<SourceLocation> getLocations()
//                {
//                    return error.getLocations();
//                }
//
//                @Override
//                public ErrorType getErrorType()
//                {
//                    return (ErrorType) error.getErrorType();
//                }
//            };
//        }
//        return error;
//    }
//}
