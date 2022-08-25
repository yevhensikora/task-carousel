package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    boolean completed;
    boolean executed;
    boolean finished;

    @Override
    public void execute() {
        this.executed = true;
        if (this.completed) {
            this.finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return this.finished;
    }

    public void complete() {
        if (this.executed) {
            this.completed = true;
        }
    }
}
