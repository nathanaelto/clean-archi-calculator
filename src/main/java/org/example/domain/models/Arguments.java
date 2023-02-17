package org.example.domain.models;

public class Arguments {
    final Operator operation;
    final String fileName;
    final boolean withLog;


    public Arguments(Operator operation, String fileName, boolean withLog) {
        this.operation = operation;
        this.fileName = fileName;
        this.withLog = withLog;
    }

    @Override
    public String toString() {
        return "Arguments{" +
                "operation=" + operation +
                ", fileNames='" + fileName + '\'' +
                ", withLog=" + withLog +
                '}';
    }

    public Operator getOperation() {
        return operation;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isWithLog() {
        return withLog;
    }
}
