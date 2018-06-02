package com.github.loadtest4j.loadtest4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DriverAdapter implements LoadTester {
    private final Driver driver;

    DriverAdapter(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Result run(Request... requests) {
        final List<DriverRequest> driverRequests = preprocessRequests(requests);

        final DriverResult driverResult = driver.run(driverRequests);

        return postprocessResult(driverResult);
    }

    private static List<DriverRequest> preprocessRequests(Request[] requests) {
        return Arrays.stream(requests)
                .map(request -> new DriverRequest(request.getBody(), request.getHeaders(), request.getMethod(), request.getPath()))
                .collect(Collectors.toList());
    }

    private static Result postprocessResult(DriverResult driverResult) {
        return new Result(driverResult.getOk(), driverResult.getKo(), driverResult.getActualDuration());
    }
}
