# Ratpack 1.4.6 Instrumentation

Custom Instrumentation for ratpack 1.4.6. This package instruments the `ratpack.path.internal.PathHandler` invocations as Web transactions.

This instrumentation is purposely lightweight and is a replacements for incubator version of the ratpack instrumentation which provides more instrumenation but also suffers from performance issues because of it.

## Installation / Usage

1. Drop the extension jar in the newrelic agent's "extensions" folder.
2. Java extensions are typically picked up on-the-fly. If wishing to use that ('hot deploy'), wait a minute or so and then check the logs to see that the extension loaded.
3. If you prefer a cold deploy or it doesn't work right with a hot deploy, restart your JVM after adding the JAR and configurations.
3. Check your [results](#results)!


## Results

The instrumentation will report ratpack pathhandler calls as transaction. By default, it limits the URL path segments to a maximum of four. For example "/custom/v2/hubs/orders/87776" will be reported under "custom/v2/hubs/orders"


## Troubleshooting

- Set log level to "FINER" in newrelic.yml to capture more detailed info about the extension's attempts. This can be done on-the-fly, and changed back to "INFO" once you have the log entries you need.


