# Ratpack 1.4.6 Instrumentation

Custom Instrumentation for ratpack 1.4.6. This package instruments the `ratpack.path.internal.PathHandler` invocations as Web transactions.

This instrumentation is purposely lightweight and has instrumentation only to create web transactions.

## (Optional) Build

`bash
	./gradlew clean build
`
The jar file is built in 'build/libs' folder

## (Optional) Import project into eclipse  

`bash
	./gradlew eclipse
`
Then choose "File > Import > General > Existing Projects into workspace"
and enter the location of this folder to complete the import.

## Installation / Usage

1. Drop the extension jar in the newrelic agent's "extensions" folder.
2. Java extensions are typically picked up on-the-fly. If wishing to use that ('hot deploy'), wait a minute or so and then check the logs to see that the extension loaded.
3. If you prefer a cold deploy or it doesn't work right with a hot deploy, restart your JVM after adding the JAR and configurations.
3. Check your [results](#results)!


## Results

The instrumentation will report ratpack pathhandler calls as transaction. To create meaningful transaction names, certain substitutions are made as defined in [here](https://github.com/preddy-newrelic/ratpack-1.4.6/blob/3499bdead8d37a876c18d2ab36ed252f29651d1a/src/main/java/com/newrelic/ratpack/path/internal/PathHandler_Instrument.java#L31)


## Troubleshooting

- Set log level to "FINER" in newrelic.yml to capture more detailed info about the extension's attempts. This can be done on-the-fly, and changed back to "INFO" once you have the log entries you need.


